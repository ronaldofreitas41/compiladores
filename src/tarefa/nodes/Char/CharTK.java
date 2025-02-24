package tarefa.nodes.Char;

import tarefa.nodes.LNode;

public abstract class CharTK extends LNode {
    private final char value;

    public CharTK(int line, int col, char value) {
        super(line, col);
        this.value = value;
    }

    public char getValue() { return value; }
}
