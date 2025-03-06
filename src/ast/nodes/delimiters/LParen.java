package  nodes.delimiters;

import  nodes.visitors.LVisitor;

public class LParen extends Delimiter {
    public LParen(int line, int col) {
        super(line, col);
    }

    public String toString() {
        return "(";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }

}