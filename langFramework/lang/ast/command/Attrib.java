package lang.ast.command;

import lang.ast.expr.Exp;
import lang.ast.expr.LValue;
import lang.ast.NodeVisitor;

public class Attrib extends Cmd {
    private LValue lvalue;
    private Exp exp;

    public Attrib(int line, int column, LValue lvalue, Exp exp) {
        super(line, column);
        this.lvalue = lvalue;
        this.exp = exp;
    }

    public LValue getLValue() {
        return lvalue;
    }

    public Exp getExp() {
        return exp;
    }

    @Override
    public void accept(NodeVisitor v) {
        v.visit(this);
    }
    
    @Override
    public String toString() {
        return "AtbrCmd(" + lvalue + ", " + exp + ")";
    }
}