package  nodes.literals;

import  nodes.visitors.*;

public class NullLt extends Lit {
    public NullLt(int line, int col) {
        super(line, col);
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}