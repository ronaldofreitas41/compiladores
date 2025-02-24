package parser.nodes.delimiters;

import parser.nodes.visitors.LVisitor;

public class LBrace extends Delimiter {
    public LBrace(int line, int col) {
        super(line, col);
    }

    public String toString() {
        return "{";
    }

    public void accept(LVisitor v){v.visit(this);}
}