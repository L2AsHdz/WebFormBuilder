package com.l2ashdz.appcliente.analizadores.lexico;

import com.l2ashdz.appcliente.model.Token;
import com.l2ashdz.appcliente.model.errores.ErrorAnalisis;
import com.l2ashdz.appcliente.model.errores.TipoError;

import java.util.ArrayList;
import java.util.List;

import java_cup.runtime.Symbol;

import static com.l2ashdz.appcliente.analizadores.sintactico.sym.*;

%%

%class Lexer
%public
%cup
%unicode
%line
%column

%{
    private List<ErrorAnalisis> errores = new ArrayList();

    public List<ErrorAnalisis> getErrores(){
        return this.errores;
    }

    private Symbol symbol(int type){
        return new Symbol(type, new Token(yyline, yycolumn, yytext()));
    }

    private void addLexicError(){
        String descripcion = "El simbolo no pertenece al lenguaje";
        errores.add(new ErrorAnalisis(yytext(), yyline+1, yycolumn+1, TipoError.LEXICO, descripcion));
    }

%}

%eofval{
    return new Symbol(EOF, new Token(yyline, yycolumn, "Fin de linea"));
%eofval}

SALTO = \n|\r|\r\n
ESPACIO = {SALTO} | [ \t\f]
DIGITO = [0-9]
LETRA = [a-zA-z]
NUMERO = 0|([1-9][0-9]*)(\.(0|([0-9]*[1-9])))?

NOSE = ({LETRA}|{DIGITO}|"-"|"_")+

%%

//Palabras reservadas

<YYINITIAL> "ini_solicitud"             {return symbol(START_REQUEST);}
<YYINITIAL> "fin_solicitud"             {return symbol(END_REQUEST);}
<YYINITIAL> "ini_solicitudes"           {return symbol(START_REQUESTS);}
<YYINITIAL> "fin_solicitudes"           {return symbol(END_REQUESTS);}

<YYINITIAL> "LOGIN_USUARIO"             {return symbol(LOGIN);}
<YYINITIAL> "CREAR_USUARIO"             {return symbol(CREATE_USER);}
<YYINITIAL> "ELIMINAR_USUARIO"          {return symbol(DELETE_USER);}
<YYINITIAL> "MODIFICAR_USUARIO"         {return symbol(MODIFY_USER);}

<YYINITIAL> "NUEVO_FORMULARIO"          {return symbol(NEW_FORM);}
<YYINITIAL> "ELIMINAR_FORMULARIO"       {return symbol(DELETE_FORM);}
<YYINITIAL> "MODIFICAR_FORMULARIO"      {return symbol(MODIFY_FORM);}

<YYINITIAL> "CREDENCIALES_USUARIO"      {return symbol(USER_CREDENTIALS);}
<YYINITIAL> "PARAMETROS_FORMULARIO"     {return symbol(FORM_PARAMS);}

<YYINITIAL> "USUARIO"                   {return symbol(PARAM_USUARIO);}
<YYINITIAL> "PASSWORD"                  {return symbol(PARAM_PASSWORD);}
<YYINITIAL> "FECHA_CREACION"            {return symbol(PARAM_FECHA_CREACION);}
<YYINITIAL> "FECHA_MODIFICACION"        {return symbol(PARAM_FECHA_MODIFICACION);}
<YYINITIAL> "USUARIO_ANTIGUO"           {return symbol(PARAM_OLD_USER);}
<YYINITIAL> "USUARIO_NUEVO"             {return symbol(PARAM_NEW_USER);}
<YYINITIAL> "NUEVO_PASSWORD"            {return symbol(PARAM_NEW_PASSWORD);}

<YYINITIAL> "ID"                        {return symbol(PARAM_ID);}
<YYINITIAL> "TITULO"                    {return symbol(PARAM_TITULO_FORM);}
<YYINITIAL> "NOMBRE"                    {return symbol(PARAM_NOMBRE_FORM);}
<YYINITIAL> "TEMA"                      {return symbol(PARAM_TEMA);}
<YYINITIAL> "USUARIO_CREACION"          {return symbol(PARAM_USUARIO_CREACION);}

<YYINITIAL> {
    "<"                                 {return symbol(LESS_THAN);}
    ">"                                 {return symbol(GREATER_THAN);}
    "!"                                 {return symbol(EXCLAMATION_MARK);}
    "\""                                {return symbol(QUOTE_MARK);}
    ":"                                 {return symbol(COLON);}
    ","                                 {return symbol(COMMA);}
    "{"                                 {return symbol(OPEN_BRACE);}
    "}"                                 {return symbol(CLOSE_BRACE);}
    "["                                 {return symbol(OPEN_BRACKET);}
    "]"                                 {return symbol(CLOSE_BRACKET);}
}

{NOSE}                                  {return symbol(VALUE);}
{ESPACIO}                               {/*Ignorar*/}

[^]                                 {addLexicError();}