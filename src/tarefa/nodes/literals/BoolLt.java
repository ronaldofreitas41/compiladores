package tarefa.nodes.literals;

import tarefa.nodes.visitors.*;

public class BoolLt extends Lit {
    public boolean value;

    public BoolLt(int line, int col, boolean value) {
        super(line, col);
        this.value = value;
    }

    public boolean getValue() { return value; }

    public void accept(LVisitor v){ v.visit(this); }
}