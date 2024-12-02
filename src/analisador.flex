/*
    Bernardo Lucas de Araujo Dias - 20.1.8011
    Ronaldo Luiz de Freitas Santos - 20.1.8113
*/

import java.util.ArrayList;
%%

%public
%function nextToken
%type Token
%class Analisador

%line
%column

%unicode

%eofval{
   return new Token(yyline, yycolumn, TK.EOF);
%eofval}

%state ARR,

%{
       private ArrayList<Integer> arr;

       private int toInt(String s) {
          try {
              return Integer.parseInt(yytext());
          } catch (NumberFormatException e) {
              System.out.println("Impossible error converting " + s + " to integer");
              return 0;
          }
       }
%}

identifier = [a-zA-Z]+
intNumber = [0-9]+
white =  [ \n\t\r]+ | {comment} | "'\\n'" | "'\\t'" | "'\\r'"
comment = "{-" ~"-}"

%%

<YYINITIAL>{
"--"  !([^]* \R [^]*) \R  {}

"true"         { return new Token(yyline, yycolumn, TK.TRUE); }
"false"        { return new Token(yyline, yycolumn, TK.FALSE); }

"data"         { return new Token(yyline, yycolumn, TK.DATA); }
"if"           { return new Token(yyline, yycolumn, TK.IF); }
"else"         { return new Token(yyline, yycolumn, TK.ELSE); }
"read"         { return new Token(yyline, yycolumn, TK.READ); }
"print"        { return new Token(yyline, yycolumn, TK.PRINT); }
"return"       { return new Token(yyline, yycolumn, TK.RETURN); }
"null"         { return new Token(yyline, yycolumn, TK.NULL); }
"iterate"      { return new Token(yyline, yycolumn, TK.ITERATE); }

"Int"           { return new Token(yyline, yycolumn, TK.INT); }
"Float"         { return new Token(yyline, yycolumn, TK.FLOAT); }
"Char"          { return new Token(yyline, yycolumn, TK.CHAR); }
"Bool"          { return new Token(yyline, yycolumn, TK.BOOL); }

"=="           { return new Token(yyline, yycolumn, TK.EQUAL); }
"!="           { return new Token(yyline, yycolumn, TK.DIFFERENT); }
"<="           { return new Token(yyline, yycolumn, TK.LESSEQUAL); }
">="           { return new Token(yyline, yycolumn, TK.GREATEREQUAL); }
"&&"           { return new Token(yyline, yycolumn, TK.AND); }
"::"           { return new Token(yyline, yycolumn, TK.PARAMETER); }
"="            { return new Token(yyline, yycolumn, TK.ASSIGN); }
"<"            { return new Token(yyline, yycolumn, TK.LESS); }
">"            { return new Token(yyline, yycolumn, TK.GREATER); }
"+"            { return new Token(yyline, yycolumn, TK.PLUS); }
"-"            { return new Token(yyline, yycolumn, TK.MINUS); }
"*"            { return new Token(yyline, yycolumn, TK.TIMES); }
"/"            { return new Token(yyline, yycolumn, TK.DIVIDE); }
"%"            { return new Token(yyline, yycolumn, TK.MOD); }
"!"            { return new Token(yyline, yycolumn, TK.NOT); }
"("            { return new Token(yyline, yycolumn, TK.OPENPARENTHESIS); }
")"            { return new Token(yyline, yycolumn, TK.CLOSEPARENTHESIS); }
"{"            { return new Token(yyline, yycolumn, TK.OPENBRACES); }
"}"            { return new Token(yyline, yycolumn, TK.CLOSEBRACES); }
";"            { return new Token(yyline, yycolumn, TK.SEMICOLON); }
","            { return new Token(yyline, yycolumn, TK.COMMA); }
":"            { return new Token(yyline, yycolumn, TK.COLON); }
"."            { return new Token(yyline, yycolumn, TK.DOT); }
"'"            { return new Token(yyline, yycolumn, TK.MARK); }

{identifier}   { return new Token(yyline, yycolumn, TK.IDENTIFIER, yytext()); }
{intNumber}    { return new Token(yyline, yycolumn, TK.INTNUMBER, toInt(yytext())); }

"["            { yybegin(ARR); arr = new ArrayList<>(); }
{white}        {/* While reading whites do nothing*/ }
[^]            {/* Matches any char form the input*/
                throw new Error("Illegal character <"+ yytext()+">"); }
}

<ARR>{
{intNumber}       { arr.add(toInt(yytext())); }
{white}        {/* Ignore whitespaces */}
"]"            { yybegin(YYINITIAL); return new Token(yyline, yycolumn, TK.ARR, arr); }
}
