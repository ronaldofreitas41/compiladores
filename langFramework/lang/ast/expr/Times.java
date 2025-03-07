package lang.ast.expr;

import lang.ast.NodeVisitor;

public class Times extends BinOp {

      public Times(int line, int col, Exp el, Exp er){
           super(line,col,el,er);

      }

      public void accept(NodeVisitor v){v.visit(this);}


}


