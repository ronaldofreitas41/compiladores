package tarefa.nodes.operators;

public abstract class Bin extends Op {
      private Op left, right;

      public Bin(int line, int col, Op el, Op er){
           super(line,col);
           left = el;
           right = er;
      }

      public Op getLeft(){return left;}
      public Op getRight(){return right;}
}