package lang.ast.visitors;

//import lang.ast.decl.*;

import lang.ast.expr.*;
import lang.ast.command.*;
import lang.ast.decl.ArrayAccess;
import lang.ast.decl.Bind;
import lang.ast.decl.Block;
import lang.ast.decl.Decl;
import lang.ast.decl.FieldAccess;
import lang.ast.decl.FunDef;
import lang.ast.decl.Param;
import lang.ast.decl.StmtBlock;
import lang.ast.delimiters.Comma;
import lang.ast.delimiters.Delimiter;
import lang.ast.delimiters.LBrace;
import lang.ast.delimiters.LBracket;
import lang.ast.delimiters.LParen;
import lang.ast.delimiters.RBrace;
import lang.ast.delimiters.RBracket;
import lang.ast.delimiters.RParen;
import lang.ast.delimiters.Semicolon;
import lang.ast.types.*;

import java.util.*;

import lang.ast.NodeVisitor;
import lang.ast.Program;

public class Interp extends NodeVisitor {

    public Stack<Object> stk;
    private Map<String, Object> varTable;

    public Interp() {
        stk = new Stack<Object>();
        varTable = new HashMap<>();
    }

    public Object getStackTop() {
        return stk.peek();
    }

    public void visit(Attrib c) {

        c.getExp().accept(this);
        Object value = stk.pop();

        if (c.getLValue() instanceof LValue) {
            LValue var = (LValue) c.getLValue();
            String varName = var.getId();

            varTable.put(varName, value);
        } else {
            throw new RuntimeException("Atribuição inválida! O lado esquerdo não é uma variável.");
        }
    }

    // Método para obter o valor de uma variável
    public Object getVarValue(String id) {
        return varTable.get(id);
    }

    // Método para definir o valor de uma variável
    public void setVarValue(String id, Object value) {
        varTable.put(id, value);
    }

    /* EXPR Visitors - I */
    // BinOp - Abstrato
    // Var - Abstrato

    // exp && exp
    public void visit(And e) {
        e.getLeft().accept(this);
        Object leftObj = stk.pop();

        e.getRight().accept(this);
        Object rightObj = stk.pop();

        // Verifica e converte para Boolean
        boolean left = (leftObj instanceof Boolean) ? (Boolean) leftObj : false;
        boolean right = (rightObj instanceof Boolean) ? (Boolean) rightObj : false;

        stk.push(Boolean.valueOf(left && right));
    }

    // lvalue ‘[’ exp ‘]’
    public void visit(ArrayAccess e) {
        e.getBase().accept(this);
        Object arrayObj = stk.pop();
        e.getIndex().accept(this);
        Object indexObj = stk.pop();

        Object[] array = (Object[]) arrayObj;
        int index = (Integer) indexObj;

        stk.push(array[index]);
    }

    // true, false
    public void visit(BoolLit e) {
        stk.push(e.getValue());
    }

    // CHAR
    public void visit(CharLit e) {
        stk.push(e.getValue());
    }

    // rexp != aexp
    public void visit(Diff e) {
        e.getLeft().accept(this);
        Object leftObj = stk.pop();

        e.getRight().accept(this);
        Object rightObj = stk.pop();

        boolean r = !leftObj.equals(rightObj);

        stk.push(Boolean.valueOf(r));
    }

    // mexp / sexp
    public void visit(Div e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        Integer right = (Integer) stk.pop();
        Integer left = (Integer) stk.pop();

        stk.push(left / right);
    }

    // rexp == aexp
    public void visit(Equal e) {
        e.getLeft().accept(this);
        Object leftObj = stk.pop();

        e.getRight().accept(this);
        Object rightObj = stk.pop();

        boolean r = leftObj.equals(rightObj);

        stk.push(Boolean.valueOf(r));
    }

    public void visit(FCall e) {
        List<Object> evaluatedArgs = new ArrayList<>();

        for (Exp arg : e.getArgs()) {
            arg.accept(this);
            evaluatedArgs.add(stk.pop());
        }

        FCall func = (FCall) varTable.get(e.getFuncName());
        if (func == null) {
            throw new RuntimeException("Função não encontrada: " + e.getFuncName());
        }

        // Object result = func.call(evaluatedArgs);

        // if (result != null){
        // stk.push(result);
        // }
    }

    // lvalue . ID
    public void visit(FieldAccess e) {
        e.accept(this);
        Object objectObj = stk.pop();

        Map<String, Object> object = (Map<String, Object>) objectObj;
        String fieldName = e.toString();

        stk.push(object.get(fieldName));
    }

    // FLOAT
    public void visit(Floatlit e) {
        stk.push(e.getValue());
    }

    // aexp > aexp
    public void visit(Greater e) {
        e.getLeft().accept(this);
        Object leftObj = stk.pop();

        e.getRight().accept(this);
        Object rightObj = stk.pop();

        // Converte para Float se necessário
        float left = (leftObj instanceof Integer) ? ((Integer) leftObj).floatValue() : (Float) leftObj;
        float right = (rightObj instanceof Integer) ? ((Integer) rightObj).floatValue() : (Float) rightObj;

        stk.push(Boolean.valueOf(left > right));
    }

    // aexp < aexp
    public void visit(Less e) {
        e.getLeft().accept(this);
        Object leftObj = stk.pop();

        e.getRight().accept(this);
        Object rightObj = stk.pop();

        // Converte para Float caso seja Integer
        float left = (leftObj instanceof Integer) ? ((Integer) leftObj).floatValue() : (Float) leftObj;
        float right = (rightObj instanceof Integer) ? ((Integer) rightObj).floatValue() : (Float) rightObj;

        stk.push(Boolean.valueOf(left < right));
    }

    // INT
    public void visit(IntLit e) {
        stk.push(e.getValue());
    }

    // lvalue
    public void visit(LValue v) {
        Object value = varTable.get(v.getId());
        stk.push(value);
    }

    // mexp % sexp
    public void visit(Mod e) {
        e.getLeft().accept(this);
        Integer left = (Integer) stk.pop();

        e.getRight().accept(this);
        Integer right = (Integer) stk.pop();

        Integer r = left % right;
        stk.push(r);
    }

    // new type [ ‘[’ exp ‘]’ ]
    public void visit(NewArray e) {
        e.getSizeExp().accept(this);
        Object sizeObj = stk.pop();

        int size = (Integer) sizeObj;
        Object[] array = new Object[size];

        stk.push(array);
    }

    // ! sexp
    public void visit(Not e) {
        e.getExp().accept(this);
        boolean value = (Boolean) stk.pop();
        stk.push(!value);
    }

    // null
    public void visit(NullLit e) {
        stk.push(null);
    }

    // aexp - mexp
    public void visit(Sub e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        Integer right = (Integer) stk.pop();
        Integer left = (Integer) stk.pop();

        stk.push(left - right);
    }

    // aexp + mexp
    public void visit(Plus e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        Integer right = (Integer) stk.pop();
        Integer left = (Integer) stk.pop();

        stk.push(left + right);
    }

    // mexp * sexp
    public void visit(Times e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        Integer right = (Integer) stk.pop();
        Integer left = (Integer) stk.pop();

        stk.push(left * right);
    }

    // - sexp
    public void visit(UnaryMinus e) {
        e.getExp().accept(this);
        Object valueObj = stk.pop();

        float value = (valueObj instanceof Integer) ? ((Integer) valueObj).floatValue() : (Float) valueObj;

        stk.push(-value);
    }

    public void visit(Var e) {
        if (!varTable.containsKey(e.getName())) {
            throw new RuntimeException("Variável não definida: " + e.getName());
        }
        Object value = getVarValue(e.getName());
        stk.push(value);
    }

    /* EXPR Visitors - F */

    /* Type Visitors - I */
    public void visit(TyBool t) {
        stk.push(t.getTypeName());
    }

    public void visit(TyInt t) {
        stk.push(t.getTypeName());
    }

    public void visit(TyChar t) {
        stk.push(t.getTypeName());
    }

    public void visit(TyFloat t) {
        stk.push(t.getTypeName());
    }

    public void visit(TyId t) {
        stk.push(t.getTypeName());
    }

    public void visit(TyNull t) {
        stk.push(t.getTypeName());
    }
    /* Type Visitors - F */

    public void visit(Assign c) {
 
        c.getExp().accept(this);

        Object value = stk.pop();

        setVarValue(c.getVar().getName(), value);

        stk.push(value);
    }

    public void visit(Atbr c) {

    }

    public void visit(Cmd c) {

    }

    public void visit(If c) {

    }

    public void visit(IterateCmd c) {

    }

    public void visit(PrintCmd c) {

    }

    public void visit(ReadCmd c) {

    }

    public void visit(ReturnCmd c) {

    }

    public void visit(Bind dec) {

    }

    public void visit(Block dec) {

    }

    public void visit(Decl dec) {

    }

    public void visit(FunDef dec) {

    }

    public void visit(Param dec) {

    }

    public void visit(StmtBlock dec) {

    }

    public void visit(Comma del) {

    }

    public void visit(Delimiter del) {

    }

    public void visit(LBrace del) {

    }

    public void visit(LBracket del) {

    }

    public void visit(LParen del) {

    }

    public void visit(RBrace del) {

    }

    public void visit(RBracket del) {

    }

    public void visit(RParen del) {

    }

    public void visit(Semicolon del) {

    }

    public void visit(BinOp e) {

    }

    public void visit(LType t) {

    }

    public void visit(Program p) {

    }

    public void visit(Exp e) {

    }

}
