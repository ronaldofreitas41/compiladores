package tarefa.nodes.reserved;

import tarefa.nodes.LNode;
import tarefa.nodes.visitors.*;

public abstract class Read extends LNode {
    private final LNode returnValue;

    public Read(int line, int col, LNode returnValue) {
        super(line, col);
        this.returnValue = returnValue;
    }

    public LNode getReturnValue() { return returnValue; }

    public void accept(LVisitor v){ v.visit(this); }
}