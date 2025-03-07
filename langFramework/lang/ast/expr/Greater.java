package lang.ast.expr;

import lang.ast.NodeVisitor;

public class Greater extends BinOp {

    public Greater(int line, int col, Exp el, Exp er){
        super(line,col,el,er);

    }

    public void accept(NodeVisitor v){v.visit(this);}
}