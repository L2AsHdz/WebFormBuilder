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
    private StringBuffer string = new StringBuffer();

    public List<ErrorAnalisis> getErrores(){
        return this.errores;
    }

    private Symbol symbol(int type){
        return new Symbol(type, new Token(yyline, yycolumn, yytext()));
    }
    
    private Symbol symbol(int type, String lexema){
        return new Symbol(type, new Token(yyline, yycolumn, lexema);
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
LETRA = [a-zA-Z]
ENTERO = 0|([1-9][0-9]*)
DECIMAL = 0|([1-9][0-9]*)(\.(0|([0-9]*[1-9])))?

IDENT = ("-"|"_"|"$")({LETRA}|\d|"-"|"_"|"$")+
FECHA = "\""\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])"\""

%state STRING

%%

//Palabras reservadas

<YYINITIAL> "ini_solicitud"             {return symbol(START_REQUEST);}
<YYINITIAL> "fin_solicitud"             {return symbol(END_REQUEST);}
<YYINITIAL> "ini_solicitudes"           {return symbol(START_REQUESTS);}
<YYINITIAL> "fin_solicitudes"           {return symbol(END_REQUESTS);}

<YYINITIAL> "\""({ESPACIO})*("LOGIN_USUARIO")({ESPACIO})*"\""             {return symbol(LOGIN);}
<YYINITIAL> "\""({ESPACIO})*("CREAR_USUARIO")({ESPACIO})*"\""             {return symbol(CREATE_USER);}
<YYINITIAL> "\""({ESPACIO})*("ELIMINAR_USUARIO")({ESPACIO})*"\""          {return symbol(DELETE_USER);}
<YYINITIAL> "\""({ESPACIO})*("MODIFICAR_USUARIO")({ESPACIO})*"\""         {return symbol(MODIFY_USER);}

<YYINITIAL> "\""({ESPACIO})*("NUEVO_FORMULARIO")({ESPACIO})*"\""          {return symbol(NEW_FORM);}
<YYINITIAL> "\""({ESPACIO})*("ELIMINAR_FORMULARIO")({ESPACIO})*"\""       {return symbol(DELETE_FORM);}
<YYINITIAL> "\""({ESPACIO})*("MODIFICAR_FORMULARIO")({ESPACIO})*"\""      {return symbol(MODIFY_FORM);}

<YYINITIAL> "\""({ESPACIO})*("AGREGAR_COMPONENTE")({ESPACIO})*"\""        {return symbol(NEW_COMPONENT);}
<YYINITIAL> "\""({ESPACIO})*("ELIMINAR_COMPONENTE")({ESPACIO})*"\""       {return symbol(DELETE_COMPONENT);}
<YYINITIAL> "\""({ESPACIO})*("MODIFICAR_COMPONENTE")({ESPACIO})*"\""      {return symbol(EDIT_COMPONENT);}

<YYINITIAL> "\""({ESPACIO})*("CREDENCIALES_USUARIO")({ESPACIO})*"\""      {return symbol(USER_CREDENTIALS);}
<YYINITIAL> "\""({ESPACIO})*("PARAMETROS_FORMULARIO")({ESPACIO})*"\""     {return symbol(FORM_PARAMS);}
<YYINITIAL> "\""({ESPACIO})*("PARAMETROS_COMPONENTE")({ESPACIO})*"\""     {return symbol(COMPONENT_PARAMS);}

<YYINITIAL> "\""({ESPACIO})*("USUARIO")({ESPACIO})*"\""                   {return symbol(PARAM_USUARIO);}
<YYINITIAL> "\""({ESPACIO})*("PASSWORD")({ESPACIO})*"\""                  {return symbol(PARAM_PASSWORD);}
<YYINITIAL> "\""({ESPACIO})*("FECHA_CREACION")({ESPACIO})*"\""            {return symbol(PARAM_FECHA_CREACION);}
<YYINITIAL> "\""({ESPACIO})*("FECHA_MODIFICACION")({ESPACIO})*"\""        {return symbol(PARAM_FECHA_MODIFICACION);}
<YYINITIAL> "\""({ESPACIO})*("USUARIO_ANTIGUO")({ESPACIO})*"\""           {return symbol(PARAM_OLD_USER);}
<YYINITIAL> "\""({ESPACIO})*("USUARIO_NUEVO")({ESPACIO})*"\""             {return symbol(PARAM_NEW_USER);}
<YYINITIAL> "\""({ESPACIO})*("NUEVO_PASSWORD")({ESPACIO})*"\""            {return symbol(PARAM_NEW_PASSWORD);}

<YYINITIAL> "\""({ESPACIO})*("ID")({ESPACIO})*"\""                        {return symbol(PARAM_ID);}
<YYINITIAL> "\""({ESPACIO})*("TITULO")({ESPACIO})*"\""                    {return symbol(PARAM_TITULO_FORM);}
<YYINITIAL> "\""({ESPACIO})*("NOMBRE")({ESPACIO})*"\""                    {return symbol(PARAM_NOMBRE_FORM);}
<YYINITIAL> "\""({ESPACIO})*("TEMA")({ESPACIO})*"\""                      {return symbol(PARAM_TEMA);}
<YYINITIAL> "\""({ESPACIO})*("USUARIO_CREACION")({ESPACIO})*"\""          {return symbol(PARAM_USUARIO_CREACION);}

<YYINITIAL> "\""({ESPACIO})*("NOMBRE_CAMPO")({ESPACIO})*"\""              {return symbol(PARAM_NOMBRE_CAMPO);}
<YYINITIAL> "\""({ESPACIO})*("FORMULARIO")({ESPACIO})*"\""                {return symbol(PARAM_FORMULARIO);}
<YYINITIAL> "\""({ESPACIO})*("CLASE")({ESPACIO})*"\""                     {return symbol(PARAM_CLASE);}
<YYINITIAL> "\""({ESPACIO})*("INDICE")({ESPACIO})*"\""                    {return symbol(PARAM_INDICE);}
<YYINITIAL> "\""({ESPACIO})*("TEXTO_VISIBLE")({ESPACIO})*"\""             {return symbol(PARAM_TEXTO_VISIBLE);}
<YYINITIAL> "\""({ESPACIO})*("ALINEACION")({ESPACIO})*"\""                {return symbol(PARAM_ALINEACION);}
<YYINITIAL> "\""({ESPACIO})*("REQUERIDO")({ESPACIO})*"\""                 {return symbol(PARAM_REQUERIDO);}
<YYINITIAL> "\""({ESPACIO})*("OPCIONES")({ESPACIO})*"\""                  {return symbol(PARAM_OPCIONES);}
<YYINITIAL> "\""({ESPACIO})*("FILAS")({ESPACIO})*"\""                     {return symbol(PARAM_FILAS);}
<YYINITIAL> "\""({ESPACIO})*("COLUMNAS")({ESPACIO})*"\""                  {return symbol(PARAM_COLUMNAS);}
<YYINITIAL> "\""({ESPACIO})*("URL")({ESPACIO})*"\""                       {return symbol(PARAM_URL);}

<YYINITIAL> "\""({ESPACIO})*("CAMPO_TEXTO")({ESPACIO})*"\""               {return symbol(CLASS_CAMPO_TEXTO);}
<YYINITIAL> "\""({ESPACIO})*("AREA_TEXTO")({ESPACIO})*"\""                {return symbol(CLASS_AREA_TEXTO);}
<YYINITIAL> "\""({ESPACIO})*("CHECKBOX")({ESPACIO})*"\""                  {return symbol(CLASS_CHECKBOX);}
<YYINITIAL> "\""({ESPACIO})*("RADIO")({ESPACIO})*"\""                     {return symbol(CLASS_RADIO);}
<YYINITIAL> "\""({ESPACIO})*("FICHERO")({ESPACIO})*"\""                   {return symbol(CLASS_FICHERO);}
<YYINITIAL> "\""({ESPACIO})*("IMAGEN")({ESPACIO})*"\""                    {return symbol(CLASS_IMAGEN);}
<YYINITIAL> "\""({ESPACIO})*("COMBO")({ESPACIO})*"\""                     {return symbol(CLASS_COMBO);}
<YYINITIAL> "\""({ESPACIO})*("BOTON")({ESPACIO})*"\""                     {return symbol(CLASS_BOTON);}

<YYINITIAL> "\""({ESPACIO})*("CENTRO")({ESPACIO})*"\""                    {return symbol(CENTRO);}
<YYINITIAL> "\""({ESPACIO})*("IZQUIERDA")({ESPACIO})*"\""                 {return symbol(IZQUIERDA);}
<YYINITIAL> "\""({ESPACIO})*("DERECHA")({ESPACIO})*"\""                   {return symbol(DERECHA);}
<YYINITIAL> "\""({ESPACIO})*("JUSTIFICAR")({ESPACIO})*"\""                {return symbol(JUSTIFICAR);}

<YYINITIAL> {
    "<"                                 {return symbol(LESS_THAN);}
    ">"                                 {return symbol(GREATER_THAN);}
    "!"                                 {return symbol(EXCLAMATION_MARK);}
    "\""                                {string.setLength(0); yybegin(STRING);}
    ":"                                 {return symbol(COLON);}
    ","                                 {return symbol(COMMA);}
    "{"                                 {return symbol(OPEN_BRACE);}
    "}"                                 {return symbol(CLOSE_BRACE);}
    "["                                 {return symbol(OPEN_BRACKET);}
    "]"                                 {return symbol(CLOSE_BRACKET);}
    
    {IDENT}                             {return symbol(IDENTIFICADOR);}
    {FECHA}                             {return symbol(FECHA);}
    {ESPACIO}                           {/*Ignorar*/}
}

<STRING> {
    \"                            { 
                                        yybegin(YYINITIAL);
                                        return symbol(VALUE, string.toString()); 
                                    }
    [^\n\r\"\\]+                  {string.append(yytext());}
    \\t                             {string.append('\t');}
    \\n                             {string.append('\n');}
    \\r                             {string.append('\r');}
    \\\"                          {string.append('\"');}
    \\                              {string.append('\\');}
  }

[^]                                 {addLexicError();}