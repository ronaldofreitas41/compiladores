package lang.ast.expr;

import lang.ast.NodeVisitor;

public class NullLit extends Exp {

    public NullLit(int line, int col) {
        super(line, col);
    }

    @Override
    public void accept(NodeVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "NullLit()";
    }
}
