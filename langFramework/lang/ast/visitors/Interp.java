package lang.ast.visitors;

//import lang.ast.decl.*;
import lang.ast.expr.*;
import lang.ast.command.*;
import lang.ast.types.*;
import java.util.*;
import lang.ast.NodeVisitor;


public class Interp extends NodeVisitor{

    public Stack<Object> stk;

    public Interp() {
        stk = new Stack<Object>();
    }

    public Object getStackTop(){
        return stk.peek();
    }

    public void visit(Attrib c){}

    public void visit(Sub  e){}
    public void visit(Plus e){
        e.getLeft().accept(this);
        e.getRight().accept(this);
        Integer r = (Integer) stk.pop() + (Integer) stk.pop();
        stk.push(r);
    }
    public void visit(Times e){
        e.getLeft().accept(this);
        e.getRight().accept(this);
        Integer r = (Integer)stk.pop() * (Integer)stk.pop();
        stk.push(r);
    }
    public void visit(Div e){}
    public void visit(Var e){}
    public void visit(IntLit e){
        stk.push(e.getValue());
    }
    public void visit(BoolLit e){
        stk.push(e.getValue());
    }

    public void visit(TyBool t){}
    public void visit(TyInt t){}

}
