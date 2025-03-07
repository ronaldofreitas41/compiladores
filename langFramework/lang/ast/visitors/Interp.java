package lang.ast.visitors;

//import lang.ast.decl.*;

import lang.ast.expr.*;
import lang.ast.command.*;
import lang.ast.types.*;

import java.util.*;

import lang.ast.NodeVisitor;


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

}
