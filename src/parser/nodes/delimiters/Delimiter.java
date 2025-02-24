package parser.nodes.delimiters;

import parser.nodes.LNode;

public abstract class Delimiter extends LNode {
    public Delimiter(int line, int col) {
        super(line, col);
    }
}