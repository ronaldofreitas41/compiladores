package  nodes.reserved;

import  nodes.LNode;
import  nodes.visitors.*;

public class Print extends LNode {
    private LNode e;

    public Print(int line, int col, LNode e){
        super(line,col);
        this.e = e;
    }

    public LNode getRes(){ return e; }

    public void accept(LVisitor v){ v.visit(this); }
}