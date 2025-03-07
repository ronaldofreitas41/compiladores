package lang.ast.decl;

public class Decl {
    private String name;
    private int line;
    private int col;

    public Decl(int line, int col, String name) {
        this.line = line;
        this.col = col;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }

    public int getCol() {
        return col;
    }
}
