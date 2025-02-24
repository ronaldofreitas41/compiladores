package tarefa.nodes.literals;

import tarefa.nodes.visitors.*;

public class IntLt extends Lit {
    public int value;

    public IntLt(int line, int col, int value) {
        super(line, col);
        this.value = value;
    }

    public int getValue() {
         return value; 
        }

    public void accept(LVisitor v){
         v.visit(this); 
        }
}