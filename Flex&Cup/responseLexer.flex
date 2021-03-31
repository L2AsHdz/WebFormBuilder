package com.l2ashdz.appcliente.analizador.lexico;

import static com.l2ashdz.appcliente.analizador.sintactico.ResponseSym.*;
import java_cup.runtime.Symbol;

%%

%class ResponseLexer
%public
%cup
%unicode
%line
%column

%{

    private Symbol symbol(int type){
        return new Symbol(type, yytext());
    }

%}

%eofval{
    return new Symbol(EOF, "Fin de linea");
%eofval}

VALUE = "\""[^ '\"']*"\""
LITERAL = "\""[^"\""]*"\""

%%

<YYINITIAL> "ini_respuesta"             {return symbol(START_RESPONSE);}
<YYINITIAL> "fin_respuesta"             {return symbol(END_RESPONSE);}
<YYINITIAL> "ini_respuestas"            {return symbol(START_RESPONSES);}
<YYINITIAL> "fin_respuestas"            {return symbol(END_RESPONSES);}

<YYINITIAL> "\"PARAMETROS_RESPUESTA\""      {return symbol(RESPONSE_PARAMS);}

<YYINITIAL> "\"LOGIN_USUARIO\""             {return symbol(LOGIN);}
<YYINITIAL> "\"CREAR_USUARIO\""             {return symbol(CREATE_USER);}
<YYINITIAL> "\"ELIMINAR_USUARIO\""          {return symbol(DELETE_USER);}
<YYINITIAL> "\"MODIFICAR_USUARIO\""         {return symbol(MODIFY_USER);}

<YYINITIAL> "\"NUEVO_FORMULARIO\""          {return symbol(NEW_FORM);}
<YYINITIAL> "\"ELIMINAR_FORMULARIO\""       {return symbol(DELETE_FORM);}
<YYINITIAL> "\"MODIFICAR_FORMULARIO\""      {return symbol(MODIFY_FORM);}

<YYINITIAL> "\"AGREGAR_COMPONENTE\""        {return symbol(NEW_COMPONENT);}
<YYINITIAL> "\"ELIMINAR_COMPONENTE\""       {return symbol(DELETE_COMPONENT);}
<YYINITIAL> "\"MODIFICAR_COMPONENTE\""      {return symbol(EDIT_COMPONENT);}

<YYINITIAL> "\"STATE\""                 {return symbol(PARAM_STATE);}
<YYINITIAL> "\"MESSAGE\""               {return symbol(PARAM_MESSAGE);}
<YYINITIAL> "\"LOGGED_USER\""           {return symbol(PARAM_LOGGED_USER);}

<YYINITIAL> "\"Exito\""                {return symbol(SUCCES);}
<YYINITIAL> "\"Error\""                 {return symbol(ERROR);}

<YYINITIAL> {
    "<"                                 {return symbol(LESS_THAN);}
    ">"                                 {return symbol(GREATER_THAN);}
    "!"                                 {return symbol(EXCLAMATION_MARK);}
    ":"                                 {return symbol(COLON);}
    ","                                 {return symbol(COMMA);}
    "{"                                 {return symbol(OPEN_BRACE);}
    "}"                                 {return symbol(CLOSE_BRACE);}
    "["                                 {return symbol(OPEN_BRACKET);}
    "]"                                 {return symbol(CLOSE_BRACKET);}
    (\s)                                {/*Ignorar*/}
}

<YYINITIAL> {VALUE}                     {return symbol(VALUE);}
<YYINITIAL> {LITERAL}                     {return symbol(LITERAL);}

[^]                                     {System.out.println("Error " + yytext());}
