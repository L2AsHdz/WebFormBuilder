package analizadores.lexico;

import model.Token;

import java_cup.runtime.Symbol;

import static analizadores.sintactico.StorageSym.*;

%%

%class StorageLexer
%public
%cup
%unicode
%line
%column

%{

%}

%eofval{
    return new Symbol(EOF, new Token(yyline, yycolumn, "Fin de linea"));
%eofval}

SALTO = \n|\r|\r\n
ESPACIO = {SALTO} | [ \t\f]
ENTERO = "\""(0|([1-9][0-9]*))"\""

ID = "\""[\_\-\$](\w|[\_\-\$])*"\""
FECHA = "\""\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])"\""
VALUE = "\""[^ '\"']*"\""
LITERAL = "\""[^"\""]*"\""
    
%%


<YYINITIAL> "db.user"                       {return new Symbol(INICIO_USER, yytext());}
<YYINITIAL> "db.form"                       {return new Symbol(INICIO_FORM, yytext());}

<YYINITIAL> "\"USUARIO\""                   {return new Symbol(PARAM_USUARIO, yytext());}
<YYINITIAL> "\"PASSWORD\""                  {return new Symbol(PARAM_PASSWORD, yytext());}
<YYINITIAL> "\"FECHA_CREACION\""            {return new Symbol(PARAM_FECHA_CREACION, yytext());}

<YYINITIAL> "\"ID\""                        {return new Symbol(PARAM_ID, yytext());}
<YYINITIAL> "\"TITULO\""                    {return new Symbol(PARAM_TITULO_FORM, yytext());}
<YYINITIAL> "\"NOMBRE\""                    {return new Symbol(PARAM_NOMBRE_FORM, yytext());}
<YYINITIAL> "\"TEMA\""                      {return new Symbol(PARAM_TEMA, yytext());}
<YYINITIAL> "\"USUARIO_CREACION\""          {return new Symbol(PARAM_USUARIO_CREACION, yytext());}

<YYINITIAL> "\""([dD][aA][rR][kK])"\""            {return new Symbol(DARK, yytext());}
<YYINITIAL> "\""([wW][hH][iI][tT][eE])"\""        {return new Symbol(WHITE, yytext());}


<YYINITIAL> {
    ":"                                 {return new Symbol(COLON, yytext());}
    ","                                 {return new Symbol(COMMA, yytext());}
    "{"                                 {return new Symbol(OPEN_BRACE, yytext());}
    "}"                                 {return new Symbol(CLOSE_BRACE, yytext());}
    "("                                 {return new Symbol(OPEN_ROUND_BRACKET, yytext());}
    ")"                                 {return new Symbol(CLOSE_ROUND_BRACKET, yytext());}
    {ESPACIO}                           {/*Ignorar*/}
}

<YYINITIAL> {ID}                        {return new Symbol(ID, yytext());}
<YYINITIAL> {FECHA}                     {return new Symbol(FECHA, yytext());}
<YYINITIAL> {ENTERO}                    {return new Symbol(ENTERO, yytext());}
<YYINITIAL> {VALUE}                     {return new Symbol(VALUE, yytext());}
<YYINITIAL> {LITERAL}                   {return new Symbol(LITERAL, yytext());}

[^]                                     {System.out.println("Error " + yytext());}