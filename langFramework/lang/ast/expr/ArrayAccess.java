package lang.ast.expr;

import lang.ast.NodeVisitor;

public class ArrayAccess extends LValue {
    private LValue array;
    private Exp index;

    public ArrayAccess(int line, int col, LValue array, Exp index) {
        super(line, col, null); 
        this.array = array;
        this.index = index;
    }

    public LValue getArray() {
        return array;
    }

    public Exp getIndex() {
        return index;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + array + "[" + index + "])";
    }
}
