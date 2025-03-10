package lang.ast.expr;

import lang.ast.NodeVisitor;

public class NewArray extends Exp {
    private Type type;
    private Exp sizeExp;

    public NewArray(int line, int col, Type type, Exp sizeExp) {
        super(line, col);
        this.type = type;
        this.sizeExp = sizeExp;
    }

    public Type getType() {
        return type;
    }

    public Exp getSizeExp() {
        return sizeExp;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + type + ", " + sizeExp + ")";
    }
}
