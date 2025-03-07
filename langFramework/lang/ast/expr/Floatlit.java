package lang.ast.expr;

import lang.ast.NodeVisitor;

public class Floatlit extends Exp{
    private float value;
    public Floatlit(int line, int col, float value){
        super(line, col);
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void accept(NodeVisitor v) {
        v.visit(this);
    }

}
