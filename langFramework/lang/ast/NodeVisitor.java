package lang.ast;

//import lang.ast.decl.*;
import lang.ast.expr.*;
import lang.ast.command.*;
import lang.ast.decl.ArrayAccess;
import lang.ast.decl.Bind;
import lang.ast.decl.Block;
import lang.ast.decl.Decl;
import lang.ast.decl.FieldAccess;
import lang.ast.decl.FunDef;
import lang.ast.decl.Param;
import lang.ast.decl.StmtBlock;
import lang.ast.delimiters.Comma;
import lang.ast.delimiters.Delimiter;
import lang.ast.delimiters.LBrace;
import lang.ast.delimiters.LBracket;
import lang.ast.delimiters.LParen;
import lang.ast.delimiters.RBrace;
import lang.ast.delimiters.RBracket;
import lang.ast.delimiters.RParen;
import lang.ast.delimiters.Semicolon;
import lang.ast.types.*;


public abstract class NodeVisitor{
    //Visitors para Commands
    public abstract void visit(Attrib c);
    public abstract void visit(Assign c);
    public abstract void visit(Atbr c);
    public abstract void visit(Cmd c);
    public abstract void visit(If c);
    // public abstract void visit(IfElse c);
    public abstract void visit(IterateCmd c);
    public abstract void visit(PrintCmd c);
    public abstract void visit(ReadCmd c);
    public abstract void visit(ReturnCmd c);
    
    //Visitors para os Decls
    public abstract void visit(ArrayAccess dec);
    public abstract void visit(Bind dec);
    public abstract void visit(Block dec);
    public abstract void visit(Decl dec);
    public abstract void visit(FieldAccess dec);
    public abstract void visit(FunDef dec);
    public abstract void visit(Param dec);
    public abstract void visit(StmtBlock dec);
    
    //Visitors para os Delimiters
    public abstract void visit(Comma del);
    public abstract void visit(Delimiter del);
    public abstract void visit(LBrace del);
    public abstract void visit(LBracket del);
    public abstract void visit(LParen del);
    public abstract void visit(RBrace del);
    public abstract void visit(RBracket del);
    public abstract void visit(RParen del);
    public abstract void visit(Semicolon del);


    //Visitors para os Expr
    public abstract void visit(And e);
    public abstract void visit(BinOp e);
    public abstract void visit(BoolLit e);
    public abstract void visit(CharLit e);
    public abstract void visit(Div e);
    public abstract void visit(Diff e);
    public abstract void visit(Equal e);
    public abstract void visit(Exp e);
    public abstract void visit(FCall e);
    public abstract void visit(Floatlit e);
    public abstract void visit(Greater e);
    public abstract void visit(IntLit e);
    public abstract void visit(Less e);
    public abstract void visit(LValue e);
    public abstract void visit(Mod e);
    public abstract void visit(Not e);
    public abstract void visit(NullLit e);
    public abstract void visit(Plus e);
    public abstract void visit(Sub  e);
    public abstract void visit(Times e);
    public abstract void visit(Var e);

    //Visitors para os Types
    public abstract void visit(LType t);
    public abstract void visit(TyBool t);
    public abstract void visit(TyChar t);
    public abstract void visit(TyId t);
    public abstract void visit(TyInt t);
    public abstract void visit(TyNull t);

    //Visitors para os RootPrograms
    public abstract void visit(Program p);
    
}
