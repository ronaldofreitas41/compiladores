package parser.nodes.operators;

import parser.nodes.visitors.*;

public abstract class Mod extends Bin {
    public Mod(int line, int col, Op el, Op er) {
        super(line, col, el, er);
    }

    public String toString() {
        return "%";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}