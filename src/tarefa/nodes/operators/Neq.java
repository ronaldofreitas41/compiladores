package tarefa.nodes.operators;

import tarefa.nodes.visitors.*;

public abstract class Neq extends Bin {
    public Neq(int line, int col, Op el, Op er) {
        super(line, col, el, er);
    }

    public String toString() {
        return "!=";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}