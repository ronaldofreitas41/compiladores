package  nodes.operators;

import  nodes.visitors.*;

public abstract class Lt extends Bin {
    public Lt(int line, int col, Op el, Op er) {
        super(line, col, el, er);
    }

    public String toString() {
        return "<";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}