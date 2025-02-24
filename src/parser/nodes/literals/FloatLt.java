package parser.nodes.literals;

import parser.nodes.visitors.*;

public class FloatLt extends Lit {
    public float value;

    public FloatLt(int line, int col, float value) {
        super(line, col);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}