package  nodes.eof;

import  nodes.LNode;
import  nodes.visitors.*;

public class EOF extends LNode {
    public EOF(int line, int col) { 
        super(line, col); 
    }

    public void accept(LVisitor v){ v.visit(this); }
}