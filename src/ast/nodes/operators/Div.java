package  ast.nodes.operators;



public abstract class Div extends Bin {
    public Div(int line, int col, Op el, Op er) {
        super(line, col, el, er);
    }

    public String toString() {
        return "/";
    }

    public void accept(nodes.visitors.LVisitor v) {
        v.visit(this);
    }
}