package parser.nodes;

import parser.nodes.visitors.LVisitor;
import parser.nodes.decl.FunDef;

import java.util.ArrayList;

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