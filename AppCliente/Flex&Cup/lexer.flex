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
ENTERO = 0|([1-9][0-9]*)
DECIMAL = 0|([1-9][0-9]*)(\.(0|([0-9]*[1-9])))?

NOSE = ({LETRA}|{DIGITO}|"-"|"_")+
IDENT = ("-"|"_"|"$")({LETRA}|{DIGITO}|"-"|"_"|"$")+
FECHA = ([ENTERO]"-"[1-12]"-"[1-31])

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

<YYINITIAL> "AGREGAR_COMPONENTE"        {return symbol(NEW_COMPONENT);}
<YYINITIAL> "ELIMINAR_COMPONENTE"       {return symbol(DELETE_COMPONENT);}
<YYINITIAL> "MODIFICAR_COMPONENTE"      {return symbol(EDIT_COMPONENT);}

<YYINITIAL> "CREDENCIALES_USUARIO"      {return symbol(USER_CREDENTIALS);}
<YYINITIAL> "PARAMETROS_FORMULARIO"     {return symbol(FORM_PARAMS);}
<YYINITIAL> "PARAMETROS_COMPONENTE"     {return symbol(COMPONENT_PARAMS);}

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

<YYINITIAL> "NOMBRE_CAMPO"              {return symbol(PARAM_NOMBRE_CAMPO);}
<YYINITIAL> "FORMULARIO"                {return symbol(PARAM_FORMULARIO);}
<YYINITIAL> "CLASE"                     {return symbol(PARAM_CLASE);}
<YYINITIAL> "INDICE"                    {return symbol(PARAM_INDICE);}
<YYINITIAL> "TEXTO_VISIBLE"             {return symbol(PARAM_TEXTO_VISIBLE);}
<YYINITIAL> "ALINEACION"                {return symbol(PARAM_ALINEACION);}
<YYINITIAL> "REQUERIDO"                 {return symbol(PARAM_REQUERIDO);}
<YYINITIAL> "OPCIONES"                  {return symbol(PARAM_OPCIONES);}
<YYINITIAL> "FILAS"                     {return symbol(PARAM_FILAS);}
<YYINITIAL> "COLUMNAS"                  {return symbol(PARAM_COLUMNAS);}
<YYINITIAL> "URL"                       {return symbol(PARAM_URL);}

<YYINITIAL> "CAMPO_TEXTO"               {return symbol(CLASS_CAMPO_TEXTO);}
<YYINITIAL> "AREA_TEXTO"                {return symbol(CLASS_AREA_TEXTO);}
<YYINITIAL> "CHECKBOX"                  {return symbol(CLASS_CHECKBOX);}
<YYINITIAL> "RADIO"                     {return symbol(CLASS_RADIO);}
<YYINITIAL> "FICHERO"                   {return symbol(CLASS_FICHERO);}
<YYINITIAL> "IMAGEN"                    {return symbol(CLASS_IMAGEN);}
<YYINITIAL> "COMBO"                     {return symbol(CLASS_COMBO);}
<YYINITIAL> "BOTON"                     {return symbol(CLASS_BOTON);}

<YYINITIAL> "CENTRO"                    {return symbol(CENTRO);}
<YYINITIAL> "IZQUIERDA"                 {return symbol(IZQUIERDA);}
<YYINITIAL> "DERECHA"                   {return symbol(DERECHA);}
<YYINITIAL> "JUSTIFICAR"                {return symbol(JUSTIFICAR);}

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
{IDENT}                                 {return symbol(IDENTIFICADOR);}
{ESPACIO}                               {/*Ignorar*/}

[^]                                 {addLexicError();}