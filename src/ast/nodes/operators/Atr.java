package  ast.nodes.operators;

import  ast.nodes.visitors.LVisitor;


public abstract class Atr extends Bin {
    public Atr(int line, int col, Op el, Op er) {
        super(line, col, el, er);
    }

    public String toString() {
        return "=";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}