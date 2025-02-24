package parser.nodes.eof;

import parser.nodes.visitors.*;
import parser.nodes.LNode;

public class EOF extends LNode {
    public EOF(int line, int col) { 
        super(line, col); 
    }

    public void accept(LVisitor v){ v.visit(this); }
}