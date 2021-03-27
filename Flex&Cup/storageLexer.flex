package analizadores.lexico;

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
        return new Symbol(type, yytext());
    }

%}

%eofval{
    return new Symbol(EOF, "Fin de linea");
%eofval}

SALTO = \n|\r|\r\n
ESPACIO = {SALTO} | [ \t\f]
ENTERO = "\""(0|([1-9][0-9]*))"\""

ID = "\""[\_\-\$](\w|[\_\-\$])*"\""
FECHA = "\""\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])"\""
OPCIONES = "\""((\w+\|\w+)(\|\w+)*)"\""
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
<YYINITIAL> "\"COMPONENTES\""               {return symbol(PARAM_COMPONENTES);}

<YYINITIAL> "\"NOMBRE_CAMPO\""              {return symbol(PARAM_NOMBRE_CAMPO);}
<YYINITIAL> "\"FORMULARIO\""                {return symbol(PARAM_FORMULARIO);}
<YYINITIAL> "\"CLASE\""                     {return symbol(PARAM_CLASE);}
<YYINITIAL> "\"TEXTO_VISIBLE\""             {return symbol(PARAM_TEXTO_VISIBLE);}
<YYINITIAL> "\"ALINEACION\""                {return symbol(PARAM_ALINEACION);}
<YYINITIAL> "\"REQUERIDO\""                 {return symbol(PARAM_REQUERIDO);}
<YYINITIAL> "\"OPCIONES\""                  {return symbol(PARAM_OPCIONES);}
<YYINITIAL> "\"FILAS\""                     {return symbol(PARAM_FILAS);}
<YYINITIAL> "\"COLUMNAS\""                  {return symbol(PARAM_COLUMNAS);}
<YYINITIAL> "\"URL\""                       {return symbol(PARAM_URL);}

<YYINITIAL> "\"CAMPO_TEXTO\""               {return symbol(CLASS_CAMPO_TEXTO);}
<YYINITIAL> "\"AREA_TEXTO\""                {return symbol(CLASS_AREA_TEXTO);}
<YYINITIAL> "\"CHECKBOX\""                  {return symbol(CLASS_CHECKBOX);}
<YYINITIAL> "\"RADIO\""                     {return symbol(CLASS_RADIO);}
<YYINITIAL> "\"FICHERO\""                   {return symbol(CLASS_FICHERO);}
<YYINITIAL> "\"IMAGEN\""                    {return symbol(CLASS_IMAGEN);}
<YYINITIAL> "\"COMBO\""                     {return symbol(CLASS_COMBO);}
<YYINITIAL> "\"BOTON\""                     {return symbol(CLASS_BOTON);}

<YYINITIAL> "\"CENTRO\""                    {return symbol(CENTRO);}
<YYINITIAL> "\"IZQUIERDA\""                 {return symbol(IZQUIERDA);}
<YYINITIAL> "\"DERECHA\""                   {return symbol(DERECHA);}
<YYINITIAL> "\"JUSTIFICAR\""                {return symbol(JUSTIFICAR);}

<YYINITIAL> "\""([sS][iI])"\""                    {return symbol(SI);}
<YYINITIAL> "\""([nN][oO])"\""                    {return symbol(NO);}

<YYINITIAL> "\""([dD][aA][rR][kK])"\""            {return symbol(DARK);}
<YYINITIAL> "\""([wW][hH][iI][tT][eE])"\""        {return symbol(WHITE);}


<YYINITIAL> {
    ":"                                 {return symbol(COLON);}
    ","                                 {return symbol(COMMA);}
    "{"                                 {return symbol(OPEN_BRACE);}
    "}"                                 {return symbol(CLOSE_BRACE);}
    "("                                 {return symbol(OPEN_ROUND_BRACKET);}
    ")"                                 {return symbol(CLOSE_ROUND_BRACKET);}
    {ESPACIO}                           {/*Ignorar*/}
}

<YYINITIAL> {ID}                        {return symbol(ID);}
<YYINITIAL> {FECHA}                     {return symbol(FECHA);}
<YYINITIAL> {ENTERO}                    {return symbol(ENTERO);}
<YYINITIAL> {OPCIONES}                  {return symbol(OPCIONES);}
<YYINITIAL> {VALUE}                     {return symbol(VALUE);}
<YYINITIAL> {LITERAL}                   {return symbol(LITERAL);}

[^]                                     {System.out.println("Error " + yytext());}