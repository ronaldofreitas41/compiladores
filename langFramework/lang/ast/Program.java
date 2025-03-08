package lang.ast;


import java.util.ArrayList;
import lang.ast.decl.FunDef;

public class Program extends Node{

   private ArrayList<FunDef> funcs;


   public Program(int l, int c, ArrayList<FunDef> fs){
       super(l,c);
       this.funcs = fs;
   }

   public ArrayList<FunDef> getFuncs(){return funcs;}

   public void accept(NodeVisitor v){v.visit(this);}

}
