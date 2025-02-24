package nodes.charTokens;

public abstract class Char extends LNode {
    private final char value;

    public Char(int line, int col, char value) {
        super(line, col);
        this.value = value;
    }

    public char getValue() { return value; }
}