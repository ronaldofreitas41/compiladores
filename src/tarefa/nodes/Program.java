package tarefa.nodes;

import java.util.ArrayList;

import tarefa.nodes.decl.FunDef;
import tarefa.nodes.visitors.LVisitor;

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