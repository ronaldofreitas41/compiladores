package  nodes.literals;

import  nodes.visitors.*;

public class CharLt extends Lit {
    public char value;

    public CharLt(int line, int col, char value) {
        super(line, col);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}