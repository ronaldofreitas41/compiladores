import mkSymbol;
import java.util.ArrayList;

%public
%function nextToken
%type Token
%class Analisador

%line
%column

%unicode

%eofval{
   return mkSymbol(yyline, yycolumn, Mk.EOF);
%eofval}

%state ARR,

%{
    private ArrayList<Integer> arr;

    private int toInt(String s) {
      try {
          return Integer.parseInt(s);
      } catch (NumberFormatException e) {
          System.out.println("Impossible error converting " + s + " to integer");
          return 0;
      }
    }

    private float toFloat(String s) {
      try {
        return Float.parseFloat(s);
      } catch (NumberFormatException e) {
        System.out.println("Impossible error converting " + s + " to integer");
        return 0;
      }
    }
    // adicionar a função de converter o ASCII para char

%}

identifier = [a-z][a-zA-Z0-9_]*
TYID = [A-Z][a-zA-Z0-9_]*
intNumber = [0-9]+
floatNumber = [0-9]+(\.[0-9]+)?
white =  [ \n\t\r]+ | {comment} 
comment = "{-" ~"-}"
char = "'" [^'\\] "'" |"'" "\\" [ntbr\\\'\"] "'" | "'" "\\" [0-9]{3} "'"

%%

<YYINITIAL>{
"--"  !([^]* \R [^]*) \R  {}

"true"         { return mkSymbol(yyline, yycolumn, Mk.TRUE); }
"false"        { return mkSymbol(yyline, yycolumn, Mk.FALSE); }

"data"         { return mkSymbol(yyline, yycolumn, Mk.DATA); }
"if"           { return mkSymbol(yyline, yycolumn, Mk.IF); }
"else"         { return mkSymbol(yyline, yycolumn, Mk.ELSE); }
"read"         { return mkSymbol(yyline, yycolumn, Mk.READ); }
"print"        { return mkSymbol(yyline, yycolumn, Mk.PRINT); }
"return"       { return mkSymbol(yyline, yycolumn, Mk.RETURN); }
"null"         { return mkSymbol(yyline, yycolumn, Mk.NULL); }
"iterate"      { return mkSymbol(yyline, yycolumn, Mk.ITERATE); }

"Int"           { return mkSymbol(yyline, yycolumn, Mk.INT); }
"Float"         { return mkSymbol(yyline, yycolumn, Mk.FLOAT); }
"Char"          { return mkSymbol(yyline, yycolumn, Mk.CHAR); }
"Bool"          { return mkSymbol(yyline, yycolumn, Mk.BOOL); }

"=="           { return mkSymbol(yyline, yycolumn, Mk.EQUAL); }
"!="           { return mkSymbol(yyline, yycolumn, Mk.DIFFERENT); }
"<="           { return mkSymbol(yyline, yycolumn, Mk.LESSEQUAL); }
">="           { return mkSymbol(yyline, yycolumn, Mk.GREATEREQUAL); }
"&&"           { return mkSymbol(yyline, yycolumn, Mk.AND); }
"::"           { return mkSymbol(yyline, yycolumn, Mk.DOUBLECOLON); }
"="            { return mkSymbol(yyline, yycolumn, Mk.ASSIGN); }
"<"            { return mkSymbol(yyline, yycolumn, Mk.LESS); }
">"            { return mkSymbol(yyline, yycolumn, Mk.GREATER); }
"+"            { return mkSymbol(yyline, yycolumn, Mk.PLUS); }
"-"            { return mkSymbol(yyline, yycolumn, Mk.MINUS); }
"*"            { return mkSymbol(yyline, yycolumn, Mk.TIMES); }
"/"            { return mkSymbol(yyline, yycolumn, Mk.DIVIDE); }
"%"            { return mkSymbol(yyline, yycolumn, Mk.MOD); }
"!"            { return mkSymbol(yyline, yycolumn, Mk.NOT); }
"("            { return mkSymbol(yyline, yycolumn, Mk.OPENPARENTHESIS); }
")"            { return mkSymbol(yyline, yycolumn, Mk.CLOSEPARENTHESIS); }
"{"            { return mkSymbol(yyline, yycolumn, Mk.OPENBRACES); }
"}"            { return mkSymbol(yyline, yycolumn, Mk.CLOSEBRACES); }
";"            { return mkSymbol(yyline, yycolumn, Mk.SEMICOLON); }
","            { return mkSymbol(yyline, yycolumn, Mk.COMMA); }
":"            { return mkSymbol(yyline, yycolumn, Mk.COLON); }
"."            { return mkSymbol(yyline, yycolumn, Mk.DOT); }
"'"            { return mkSymbol(yyline, yycolumn, Mk.MARK); }
"["            { return mkSymbol(yyline, yycolumn, Mk.LCOLCH); }
"]"            { return mkSymbol(yyline, yycolumn, Mk.RCOLCH); }

{identifier}   { return mkSymbol(yyline, yycolumn, Mk.IDENTIFIER, yytext()); }
{TYID}         { return mkSymbol(yyline, yycolumn, Mk.TYID, yytext()); }
{intNumber}    { return mkSymbol(yyline, yycolumn, Mk.INTNUMBER, toInt(yytext())); }
{floatNumber}  { return mkSymbol(yyline, yycolumn, Mk.FLOATNUMBER, toFloat(yytext())); }
{char}         { return mkSymbol(yyline, yycolumn, Mk.CHARACTER, yytext());}
{white}        {/* While reading whites do nothing*/ }
[^]            {/* Matches any char form the input*/
                throw new Error("Illegal character <"+ yytext()+">"); }
