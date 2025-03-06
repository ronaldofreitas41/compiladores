package  ast.nodes.operators;

import nodes.operators.Op;

public abstract class Bin extends nodes.operators.Op {
      private Op left, right;

      public Bin(int line, int col, Op el, Op er){
           super(line,col);
           left = el;
           right = er;
      }

      public Op getLeft(){return left;}
      public Op getRight(){return right;}
}