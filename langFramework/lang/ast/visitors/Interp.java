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
    private Map<String, Object> varTable; // Tabela de variáveis

    public Interp() {
        stk = new Stack<Object>();
    }

    public Object getStackTop() {
        return stk.peek();
    }

    public void visit(Attrib c) {
        //Não sei o que por aqui
    }

    public Object getVarValue(String id) {
        return varTable.get(id);
    }


    //Operação de &&
    public void visit(And e) {
        e.getLeft().accept(this);
        boolean left = (Boolean) stk.pop();

        e.getRight().accept(this);
        boolean right = (Boolean) stk.pop();

        boolean r = left && right;

        stk.push(r);
    }

    // Verificação se dois elementos são diferentes
    public void visit(Diff e) {
        e.getLeft().accept(this);
        boolean left = (Boolean) stk.pop();

        e.getRight().accept(this);
        boolean right = (Boolean) stk.pop();

        boolean r = (left != right);

        stk.push(r);
    }

    //Verificação se dois elementos são iguais
    public void visit(Equal e) {
        e.getLeft().accept(this);
        boolean left = (Boolean) stk.pop();

        e.getRight().accept(this);
        boolean right = (Boolean) stk.pop();

        boolean r = (left == right);

        stk.push(r);
    }


    //Operação de Maior que
    public void visit(Greater e) {
        e.getLeft().accept(this);
        float left = (Float) stk.pop();

        e.getRight().accept(this);
        float right = (Float) stk.pop();

        stk.push(left > right);
    }

    //Operação de Menor que
    public void visit(Less e) {
        e.getLeft().accept(this);
        float left = (Float) stk.pop();

        e.getRight().accept(this);
        float right = (Float) stk.pop();

        stk.push(left < right);
    }

    //Operação de Resto
    public void visit(Mod e) {
        e.getLeft().accept(this);
        Integer left = (Integer) stk.pop();

        e.getRight().accept(this);
        Integer right = (Integer) stk.pop();

        Integer r = left % right;
        stk.push(r);
    }

    //Operação de Not
    public void visit(Not e) {
        e.getExp().accept(this);
        boolean value = (Boolean) stk.pop();
        stk.push(!value);
    }


    //Operção de Subtração
    public void visit(Sub e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);
        Integer r = (Integer) stk.pop() - (Integer) stk.pop();
        stk.push(r);
    }

    //Operação de Soma
    public void visit(Plus e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);
        Integer r = (Integer) stk.pop() + (Integer) stk.pop();
        stk.push(r);
    }

    //Operação de Multiplicação
    public void visit(Times e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);
        Integer r = (Integer) stk.pop() * (Integer) stk.pop();
        stk.push(r);
    }

    //Operação de Divisão
    public void visit(Div e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);
        Integer r = (Integer) stk.pop() / (Integer) stk.pop();
        stk.push(r);
    }

    public void visit(Var e) {
        // Obtém o valor da variável da tabela
        Object value = getVarValue(e.getName());

        // Empilha o valor na pilha
        stk.push(value);
    }

    public void visit(IntLit e) {
        stk.push(e.getValue());
    }
    public void visit(BoolLit e) {
        stk.push(e.getValue());
    }
    public void visit(Floatlit e) {
        stk.push(e.getValue());
    }

    public void visit(TyBool t) {
    }
    public void visit(TyInt t) {
    }

    @Override
    public void visit(Assign c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Atbr c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Cmd c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(If c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(IterateCmd c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(PrintCmd c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(ReadCmd c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(ReturnCmd c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(ArrayAccess dec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Bind dec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Block dec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Decl dec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(FieldAccess dec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(FunDef dec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Param dec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(StmtBlock dec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Comma del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Delimiter del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LBrace del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LBracket del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LParen del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(RBrace del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(RBracket del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(RParen del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Semicolon del) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(BinOp e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(CharLit e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Exp e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(FCall e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LValue e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(NullLit e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(LType t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(TyChar t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(TyId t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(TyNull t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Program p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

}
