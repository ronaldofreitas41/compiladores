package parser.nodes.ident;

import parser.nodes.LNode;
import parser.nodes.visitors.*;

public class Ptr extends LNode {
    private final LNode baseType;

    public Ptr(int line, int col, LNode baseType) {
        super(line, col);
        this.baseType = baseType;
    }

    public LNode getBaseType() {
        return baseType;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}