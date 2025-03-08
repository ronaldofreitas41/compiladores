package lang.ast.command;

import lang.ast.expr.Exp;
import lang.ast.NodeVisitor;

public class PrintCmd extends Cmd {
    private Exp exp;

    public PrintCmd(int line, int column, Exp exp) {
        super(line, column);
        this.exp = exp;
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
        return "PrintCmd(" + exp + ")";
    }
}