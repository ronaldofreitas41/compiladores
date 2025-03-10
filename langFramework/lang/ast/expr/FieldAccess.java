package lang.ast.expr;

import lang.ast.NodeVisitor;

public class FieldAccess extends LValue {
    private LValue object;
    private String fieldName;

    public FieldAccess(int line, int col, LValue object, String fieldName) {
        super(line, col, null);
        this.object = object;
        this.fieldName = fieldName;
    }

    public LValue getObject() {
        return object;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + object + "." + fieldName + ")";
    }
}
