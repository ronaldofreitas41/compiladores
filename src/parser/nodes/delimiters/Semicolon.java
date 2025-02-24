package parser.nodes.delimiters;

import parser.nodes.visitors.LVisitor;

public class Semicolon extends Delimiter {
    public Semicolon(int line, int col) {
        super(line, col);
    }

    public String toString() {
        return ";";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}