package lang.ast.expr;

import lang.ast.NodeVisitor;
import java.util.List;

public class FCall extends Exp {
    private String funcName;
    private List<Exp> args;

    public FCall(int line, int col, String funcName, List<Exp> args) {
        super(line, col);
        this.funcName = funcName;
        this.args = args;
    }

    public String getFuncName() {
        return funcName;
    }

    public List<Exp> getArgs() {
        return args;
    }

    @Override
    public void accept(NodeVisitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FCall{").append("functionName='").append(this.funcName).append('\'')
          .append(", arguments=").append(this.args).append('}');
        return sb.toString();
    }
}
