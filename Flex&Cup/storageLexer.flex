package analizadores.lexico;

import model.Token;
import java.util.ArrayList;
import java.util.List;

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

    private Symbol symbol(int type){
        return new Symbol(type, new Token(yyline, yycolumn, yytext()));
    }

%}

%eofval{
return new Symbol(EOF, new Token(yyline, yycolumn, "Fin de linea"));
%eofval}

ENTERO = "\""(0|([1-9][0-9]*))"\""

ID = "\""[\_\-\$](\w|[\_\-\$])*"\""
FECHA = "\""\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])"\""
VALUE = "\""[^ '\"']*"\""
LITERAL = "\""[^"\""]*"\""
    
%%


<YYINITIAL> "db.user"                       {return symbol(INICIO_USER);}
<YYINITIAL> "db.form"                       {return symbol(INICIO_FORM);}

<YYINITIAL> "\"USUARIO\""                   {return symbol(PARAM_USUARIO);}
<YYINITIAL> "\"PASSWORD\""                  {return symbol(PARAM_PASSWORD);}
<YYINITIAL> "\"FECHA_CREACION\""            {return symbol(PARAM_FECHA_CREACION);}

<YYINITIAL> "\"ID\""                        {return symbol(PARAM_ID);}
<YYINITIAL> "\"TITULO\""                    {return symbol(PARAM_TITULO_FORM);}
<YYINITIAL> "\"NOMBRE\""                    {return symbol(PARAM_NOMBRE_FORM);}
<YYINITIAL> "\"TEMA\""                      {return symbol(PARAM_TEMA);}
<YYINITIAL> "\"USUARIO_CREACION\""          {return symbol(PARAM_USUARIO_CREACION);}

<YYINITIAL> "\""([dD][aA][rR][kK])"\""            {return symbol(DARK);}
<YYINITIAL> "\""([wW][hH][iI][tT][eE])"\""        {return symbol(WHITE);}


<YYINITIAL> {
    ":"                                 {return symbol(COLON);}
    ","                                 {return symbol(COMMA);}
    "{"                                 {return symbol(OPEN_BRACE);}
    "}"                                 {return symbol(CLOSE_BRACE);}
    "("                                 {return symbol(OPEN_ROUND_BRACKET);}
    ")"                                 {return symbol(CLOSE_ROUND_BRACKET);}
    "\s"                                {/*Ignorar*/}
}

<YYINITIAL> {ID}                        {return symbol(ID);}
<YYINITIAL> {FECHA}                     {return symbol(FECHA);}
<YYINITIAL> {ENTERO}                    {return symbol(ENTERO);}
<YYINITIAL> {VALUE}                     {return symbol(VALUE);}
<YYINITIAL> {LITERAL}                   {return symbol(LITERAL);}