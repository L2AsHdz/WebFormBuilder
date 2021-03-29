package analizadores.lexico;

import model.Token;
import model.errores.ErrorAnalisis;
import model.errores.TipoError;

import java.util.ArrayList;
import java.util.List;

import java_cup.runtime.Symbol;

import static analizadores.sintactico.RequestsSym.*;

%%

%class RequestsLexer
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

    private void addLexicError(){
        String descripcion = "El simbolo no pertenece al lenguaje";
        errores.add(new ErrorAnalisis(yytext(), yyline+1, yycolumn+1, TipoError.LEXICO, descripcion));
    }

%}

%eofval{
    return new Symbol(EOF, new Token(yyline, yycolumn, "Fin de linea"));
%eofval}

ENTERO = "\""(0|([1-9][0-9]*))"\""
ID = "\""[\_\-\$](\w|[\_\-\$])*"\""
FECHA = "\""\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])"\""
OPCIONES = "\""((\w+\|\w+)(\|\w+)*)"\""
VALUE = "\""[^ '\"']*"\""
LITERAL = "\""[^"\""]*"\""

%%

//Palabras reservadas

<YYINITIAL> [iI][nN][iI]_[sS][oO][lL][iI][cC][iI][tT][uU][dD]             {return symbol(START_REQUEST);}
<YYINITIAL> [fF][iI][nN]_[sS][oO][lL][iI][cC][iI][tT][uU][dD]             {return symbol(END_REQUEST);}
<YYINITIAL> [iI][nN][iI]_[sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS]     {return symbol(START_REQUESTS);}
<YYINITIAL> [fF][iI][nN]_[sS][oO][lL][iI][cC][iI][tT][uU][dD][eE][sS]     {return symbol(END_REQUESTS);}

<YYINITIAL> "\""(\s)*("LOGIN_USUARIO")(\s)*"\""             {return symbol(LOGIN);}
<YYINITIAL> "\""(\s)*("CREAR_USUARIO")(\s)*"\""             {return symbol(CREATE_USER);}
<YYINITIAL> "\""(\s)*("ELIMINAR_USUARIO")(\s)*"\""          {return symbol(DELETE_USER);}
<YYINITIAL> "\""(\s)*("MODIFICAR_USUARIO")(\s)*"\""         {return symbol(MODIFY_USER);}

<YYINITIAL> "\""(\s)*("NUEVO_FORMULARIO")(\s)*"\""          {return symbol(NEW_FORM);}
<YYINITIAL> "\""(\s)*("ELIMINAR_FORMULARIO")(\s)*"\""       {return symbol(DELETE_FORM);}
<YYINITIAL> "\""(\s)*("MODIFICAR_FORMULARIO")(\s)*"\""      {return symbol(MODIFY_FORM);}

<YYINITIAL> "\""(\s)*("AGREGAR_COMPONENTE")(\s)*"\""        {return symbol(NEW_COMPONENT);}
<YYINITIAL> "\""(\s)*("ELIMINAR_COMPONENTE")(\s)*"\""       {return symbol(DELETE_COMPONENT);}
<YYINITIAL> "\""(\s)*("MODIFICAR_COMPONENTE")(\s)*"\""      {return symbol(EDIT_COMPONENT);}

<YYINITIAL> "\""(\s)*("CREDENCIALES_USUARIO")(\s)*"\""      {return symbol(USER_CREDENTIALS);}
<YYINITIAL> "\""(\s)*("PARAMETROS_FORMULARIO")(\s)*"\""     {return symbol(FORM_PARAMS);}
<YYINITIAL> "\""(\s)*("PARAMETROS_COMPONENTE")(\s)*"\""     {return symbol(COMPONENT_PARAMS);}

<YYINITIAL> "\""(\s)*("USUARIO")(\s)*"\""                   {return symbol(PARAM_USUARIO);}
<YYINITIAL> "\""(\s)*("PASSWORD")(\s)*"\""                  {return symbol(PARAM_PASSWORD);}
<YYINITIAL> "\""(\s)*("FECHA_CREACION")(\s)*"\""            {return symbol(PARAM_FECHA_CREACION);}
<YYINITIAL> "\""(\s)*("FECHA_MODIFICACION")(\s)*"\""        {return symbol(PARAM_FECHA_MODIFICACION);}
<YYINITIAL> "\""(\s)*("USUARIO_ANTIGUO")(\s)*"\""           {return symbol(PARAM_OLD_USER);}
<YYINITIAL> "\""(\s)*("USUARIO_NUEVO")(\s)*"\""             {return symbol(PARAM_NEW_USER);}
<YYINITIAL> "\""(\s)*("NUEVO_PASSWORD")(\s)*"\""            {return symbol(PARAM_NEW_PASSWORD);}

<YYINITIAL> "\""(\s)*("ID")(\s)*"\""                        {return symbol(PARAM_ID);}
<YYINITIAL> "\""(\s)*("TITULO")(\s)*"\""                    {return symbol(PARAM_TITULO_FORM);}
<YYINITIAL> "\""(\s)*("NOMBRE")(\s)*"\""                    {return symbol(PARAM_NOMBRE_FORM);}
<YYINITIAL> "\""(\s)*("TEMA")(\s)*"\""                      {return symbol(PARAM_TEMA);}
<YYINITIAL> "\""(\s)*("USUARIO_CREACION")(\s)*"\""          {return symbol(PARAM_USUARIO_CREACION);}

<YYINITIAL> "\""(\s)*("NOMBRE_CAMPO")(\s)*"\""              {return symbol(PARAM_NOMBRE_CAMPO);}
<YYINITIAL> "\""(\s)*("FORMULARIO")(\s)*"\""                {return symbol(PARAM_FORMULARIO);}
<YYINITIAL> "\""(\s)*("CLASE")(\s)*"\""                     {return symbol(PARAM_CLASE);}
<YYINITIAL> "\""(\s)*("INDICE")(\s)*"\""                    {return symbol(PARAM_INDICE);}
<YYINITIAL> "\""(\s)*("TEXTO_VISIBLE")(\s)*"\""             {return symbol(PARAM_TEXTO_VISIBLE);}
<YYINITIAL> "\""(\s)*("ALINEACION")(\s)*"\""                {return symbol(PARAM_ALINEACION);}
<YYINITIAL> "\""(\s)*("REQUERIDO")(\s)*"\""                 {return symbol(PARAM_REQUERIDO);}
<YYINITIAL> "\""(\s)*("OPCIONES")(\s)*"\""                  {return symbol(PARAM_OPCIONES);}
<YYINITIAL> "\""(\s)*("FILAS")(\s)*"\""                     {return symbol(PARAM_FILAS);}
<YYINITIAL> "\""(\s)*("COLUMNAS")(\s)*"\""                  {return symbol(PARAM_COLUMNAS);}
<YYINITIAL> "\""(\s)*("URL")(\s)*"\""                       {return symbol(PARAM_URL);}

<YYINITIAL> "\""(\s)*([dD][aA][rR][kK])(\s)*"\""            {return symbol(DARK);}
<YYINITIAL> "\""(\s)*([wW][hH][iI][tT][eE])(\s)*"\""        {return symbol(WHITE);}

<YYINITIAL> "\""(\s)*("CAMPO_TEXTO")(\s)*"\""               {return symbol(CLASS_CAMPO_TEXTO);}
<YYINITIAL> "\""(\s)*("AREA_TEXTO")(\s)*"\""                {return symbol(CLASS_AREA_TEXTO);}
<YYINITIAL> "\""(\s)*("CHECKBOX")(\s)*"\""                  {return symbol(CLASS_CHECKBOX);}
<YYINITIAL> "\""(\s)*("RADIO")(\s)*"\""                     {return symbol(CLASS_RADIO);}
<YYINITIAL> "\""(\s)*("FICHERO")(\s)*"\""                   {return symbol(CLASS_FICHERO);}
<YYINITIAL> "\""(\s)*("IMAGEN")(\s)*"\""                    {return symbol(CLASS_IMAGEN);}
<YYINITIAL> "\""(\s)*("COMBO")(\s)*"\""                     {return symbol(CLASS_COMBO);}
<YYINITIAL> "\""(\s)*("BOTON")(\s)*"\""                     {return symbol(CLASS_BOTON);}

<YYINITIAL> "\""(\s)*("CENTRO")(\s)*"\""                    {return symbol(CENTRO);}
<YYINITIAL> "\""(\s)*("IZQUIERDA")(\s)*"\""                 {return symbol(IZQUIERDA);}
<YYINITIAL> "\""(\s)*("DERECHA")(\s)*"\""                   {return symbol(DERECHA);}
<YYINITIAL> "\""(\s)*("JUSTIFICAR")(\s)*"\""                {return symbol(JUSTIFICAR);}

<YYINITIAL> "\""(\s)*([sS][iI])(\s)*"\""                    {return symbol(SI);}
<YYINITIAL> "\""(\s)*([nN][oO])(\s)*"\""                    {return symbol(NO);}

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

<YYINITIAL> {ID}                        {return symbol(ID);}
<YYINITIAL> {FECHA}                     {return symbol(FECHA);}
<YYINITIAL> {ENTERO}                    {return symbol(ENTERO);}
<YYINITIAL> {OPCIONES}                  {return symbol(OPCIONES);}
<YYINITIAL> {VALUE}                     {return symbol(VALUE);}
<YYINITIAL> {LITERAL}                   {return symbol(LITERAL);}

[^]                                 {addLexicError();}