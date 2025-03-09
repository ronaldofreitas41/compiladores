/* 14/11/2024 - Calc lexer
 * Elton M. Cardoso
 * Example of a lexer for a simple claculator language.
 *
 * This lexer implementation contains Arrays as tokens.
 * The students are encouraged to argue why this is a bad ideia !
 *
 *  Ronaldo Luiz de Freitas Santos
 *  Bernardo Lucas de Araujo Dias
 */
package lang.parser;

import java.util.ArrayList;
import java_cup.runtime.Symbol;

%%

%public
%function nextToken
%type Symbol
%class LangLexer

%state ARR

%line
%column

%unicode

%eofval{
   return new Symbol(LangParserSym.EOF, yyline + 1, yycolumn + 1);
%eofval}

%{
       private ArrayList<Integer> arr;

       private int toInt(String s){
          try{
              return Integer.parseInt(yytext());
          }catch(NumberFormatException e){
              System.out.println("Erro de conversão: " + s + " para inteiro");
              return 0;
          }
       }

       private float toFloat(String s){
          try{
              return Float.parseFloat(yytext());
          }catch(NumberFormatException e){
              System.out.println("Erro de conversão: " + s + " para ponto flutuante.");
              return 0;
          }
       }

       private char ascIIToChar(String s) {
           String octalValue = s.substring(2, s.length() - 1);

           try {
               int decimalValue = Integer.parseInt(octalValue, 8);
               return (char)decimalValue;
           } catch (NumberFormatException e) {
               throw new Error("Erro na conversão de valor octal (" + s + ") para ASCII.");
           }
       }

       private Symbol mkSymbol(int symCode, Object obj){
           return new Symbol(symCode, yyline + 1, yycolumn + 1, obj);
       }

       private Symbol mkSymbol(int symCode){
           return mkSymbol(symCode,null);
       }

%}


identifier    = [a-z][a-zA-Z0-9_]*
type_id       = [A-Z][a-zA-Z0-9_]*
integer       = [0-9]+
float         = [0-9]+\.[0-9]*|\.[0-9]+|[0-9]+\.
whitespace    = [ \n\t\r]+ | {comment}
escape        = "'\\b'" | "'\\n'" | "'\\t'" | "'\\r'"
ascII         = "'\\[0-9]{1,3}'"
comment       = "{-" ~"-}"

%%

<YYINITIAL> {

    /* Tipos de Dados */
    "Int"            { return mkSymbol(LangParserSym.INT); }
    "Float"          { return mkSymbol(LangParserSym.FLOAT); }
    "Char"           { return mkSymbol(LangParserSym.CHAR); }
    "Bool"           { return mkSymbol(LangParserSym.BOOL); }

    /* Literias Booleanos */
    "true"           { return mkSymbol(LangParserSym.TRUE, true); }
    "false"          { return mkSymbol(LangParserSym.FALSE, false); }

    /* Comentário */
    {comment}        { /* N/A */ }

    /* Palavras reservadas */
    "if"             { return mkSymbol(LangParserSym.IF);      }
    "else"           { return mkSymbol(LangParserSym.ELSE);    }
    "data"           { return mkSymbol(LangParserSym.DATA);    }
    "null"           { return mkSymbol(LangParserSym.NULL);    }
    "iterate"        { return mkSymbol(LangParserSym.ITERATE); }
    "read"           { return mkSymbol(LangParserSym.READ);    }
    "print"          { return mkSymbol(LangParserSym.PRINT);   }
    "return"         { return mkSymbol(LangParserSym.RETURN);  }

    /* Operadores */
    "=="             { return mkSymbol(LangParserSym.EQUAL);          }
    "!="             { return mkSymbol(LangParserSym.DIFFERENT);      }
    "<="             { return mkSymbol(LangParserSym.LESS_EQUAL);     }
    ">="             { return mkSymbol(LangParserSym.GREATER_EQUAL);  }
    "&&"             { return mkSymbol(LangParserSym.AND);            }
    "::"             { return mkSymbol(LangParserSym.DOUBLE_COLON);   }
    "="              { return mkSymbol(LangParserSym.ASSIGN);         }
    "<"              { return mkSymbol(LangParserSym.LESS);           }
    ">"              { return mkSymbol(LangParserSym.GREATER);        }
    "+"              { return mkSymbol(LangParserSym.PLUS);           }
    "-"              { return mkSymbol(LangParserSym.MINUS);          }
    "*"              { return mkSymbol(LangParserSym.TIMES);          }
    "/"              { return mkSymbol(LangParserSym.DIVIDE);         }
    "%"              { return mkSymbol(LangParserSym.MOD);            }
    "!"              { return mkSymbol(LangParserSym.NOT);            }

    /* Caracteres de pontuação */
    "("              { return mkSymbol(LangParserSym.OPEN_PARENTHESIS);  }
    ")"              { return mkSymbol(LangParserSym.CLOSE_PARENTHESIS); }
    "{"              { return mkSymbol(LangParserSym.OPEN_BRACES);       }
    "}"              { return mkSymbol(LangParserSym.CLOSE_BRACES);      }
    "["              { return mkSymbol(LangParserSym.LBRACKET);          }
    "]"              { return mkSymbol(LangParserSym.RBRACKET);          }
    ";"              { return mkSymbol(LangParserSym.SEMICOLON);         }
    ","              { return mkSymbol(LangParserSym.COMMA);             }
    ":"              { return mkSymbol(LangParserSym.COLON);             }
    "."              { return mkSymbol(LangParserSym.DOT);               }
    "'"              { return mkSymbol(LangParserSym.QUOTATION_MARKS);   }

    /* Identificadores */
    {identifier}     { return mkSymbol(LangParserSym.IDENTIFIER, yytext()); }
    {type_id}        { return mkSymbol(LangParserSym.TYPE_ID, yytext()); }

    /* Literal inteiro e Literal flutuante */
    {integer}        { return mkSymbol(LangParserSym.INT_LITERAL, toInt(yytext())); }
    {float}          { return mkSymbol(LangParserSym.FLOAT_LITERAL, toFloat(yytext())); }

    /* Caracter literal */
    {escape}         { return mkSymbol(LangParserSym.ESCAPE, yytext()); }
    {ascII}          { return mkSymbol(LangParserSym.ASCII, ascIIToChar(yytext())); }

    /* Espaço em branco */
    {whitespace}     { /* N/A */ }

    /* ERRO */
    [^]              { throw new Error("Illegal character <" + yytext() + "> at line " + (yyline + 1) + ", column " + (yycolumn + 1)); }
}


