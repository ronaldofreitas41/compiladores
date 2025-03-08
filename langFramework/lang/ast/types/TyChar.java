package lang.ast.types;

import lang.ast.NodeVisitor;

public class TyChar extends LType {
    public TyChar(int line, int col) {
        super(line, col);
    }

    public void accept(NodeVisitor v) {
        v.visit(this);
    }

}