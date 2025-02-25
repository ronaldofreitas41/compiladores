package  nodes;

import java.util.ArrayList;

import  nodes.decl.FunDef;
import  nodes.visitors.LVisitor;

public class Program extends LNode {
    private ArrayList<FunDef> funcs;

    public Program(int l, int c, ArrayList<FunDef> fs) {
        super(l, c);
        this.funcs = fs;
    }

    public ArrayList<FunDef> getFuncs() {
        return funcs;
    }

    public void accept(LVisitor v) {
        v.visit(this);
    }
}