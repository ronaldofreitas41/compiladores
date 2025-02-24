package parser.nodes.delimiters;

import parser.nodes.visitors.LVisitor;

public class RBracket extends Delimiter {
    public RBracket(int line, int col) {
        super(line, col);
    }

    public String toString() {
        return "]";
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }

}