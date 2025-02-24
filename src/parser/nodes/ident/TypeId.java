package parser.nodes.ident;

import parser.nodes.LNode;
import parser.nodes.visitors.*;

public class TypeId extends LNode {
    private String typeName;

    public TypeId(int line, int col, String typeName) {
        super(line, col);
        this.typeName = typeName;
    }

    public String getTypeName() { return typeName; }

    public void accept(LVisitor v) { v.visit(this); }
}