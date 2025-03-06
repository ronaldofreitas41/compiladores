package  nodes.visitors;

import  nodes.Program;
import  ast.nodes.Char.*;
import  ast.nodes.decl.*;
import  ast.nodes.delimiters.*;
import  ast.nodes.eof.*;
import  ast.nodes.ident.*;
import  ast.nodes.literals.*;
import  ast.nodes.operators.*;
import  ast.nodes.reserved.*;

public abstract class LVisitor {
    public abstract void visit(Program p);

    // Palavras reservadas
    public abstract void visit(Data r); // DATA
    public abstract void visit(If r); // IF
    public abstract void visit(Iterate r); // ITERATE
    public abstract void visit(Read r); // READ
    public abstract void visit(Print r); // PRINT
    public abstract void visit(Return r); // RETURN

    // Identificadores e tipos
    public abstract void visit(Identifier i); // ID, TYPE
    public abstract void visit(TypeId i); // TYID
    public abstract void visit(Ptr i); // PTR

    // Literais
    public abstract void visit(IntLt l); // INT
    public abstract void visit(FloatLt l); // FLOAT
    public abstract void visit(CharLt l); // CHAR
    public abstract void visit(BoolLt l); // BOOL
    public abstract void visit(NullLt l); // NULL

    // Operadores
    public abstract void visit(Plus o); // PLUS
    public abstract void visit(Minus o); // MINUS
    public abstract void visit(Mult o); // MULT
    public abstract void visit(Div o); // DIV
    public abstract void visit(Mod o); // MOD
    public abstract void visit(Atr o); // ATBR
    public abstract void visit(Eq o); // EQ
    public abstract void visit(Neq o); // NEQ
    public abstract void visit(Lt o); // LT
    public abstract void visit(Gt o); // GT
    public abstract void visit(Dot o); // DOT

    // Delimitadores
    public abstract void visit(LBrace d); // LBRACE
    public abstract void visit(RBrace d); // RBRACE
    public abstract void visit(LBracket d); // LBRACKET 
    public abstract void visit(RBracket d); // RBRACKET
    public abstract void visit(LParen d); // LPAREN
    public abstract void visit(RParen d); // RPAREN
    public abstract void visit(Comma d); // COMMA, SEMICOLON
    public abstract void visit(Semicolon d); // SEMICOLON

    // Char tokens
    public abstract void visit(CharTK c); // NEWLINE, TAB, BACKSPACE, CARRIAGERETURN, BACKSLASH, SINGLEQUOTE, DOUBLEQUOTE, ASC

    // Outros
    public abstract void visit(FunDef x);
    public abstract void visit(Bind x);
    public abstract void visit(Block x);

    // Fim do arquivo
    public abstract void visit(EOF f); // EOF
}