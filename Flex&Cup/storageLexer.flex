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
<YYINITIAL> "\"COMPONENTES\""               {return new Symbol(PARAM_COMPONENTES, yytext());}

<YYINITIAL> "\"NOMBRE_CAMPO\""              {return new Symbol(PARAM_NOMBRE_CAMPO, yytext());}
<YYINITIAL> "\"FORMULARIO\""                {return new Symbol(PARAM_FORMULARIO, yytext());}
<YYINITIAL> "\"CLASE\""                     {return new Symbol(PARAM_CLASE, yytext());}
<YYINITIAL> "\"TEXTO_VISIBLE\""             {return new Symbol(PARAM_TEXTO_VISIBLE, yytext());}
<YYINITIAL> "\"ALINEACION\""                {return new Symbol(PARAM_ALINEACION, yytext());}
<YYINITIAL> "\"REQUERIDO\""                 {return new Symbol(PARAM_REQUERIDO, yytext());}
<YYINITIAL> "\"OPCIONES\""                  {return new Symbol(PARAM_OPCIONES, yytext());}
<YYINITIAL> "\"FILAS\""                     {return new Symbol(PARAM_FILAS, yytext());}
<YYINITIAL> "\"COLUMNAS\""                  {return new Symbol(PARAM_COLUMNAS, yytext());}
<YYINITIAL> "\"URL\""                       {return new Symbol(PARAM_URL, yytext());}

<YYINITIAL> "\"CAMPO_TEXTO\""               {return new Symbol(CLASS_CAMPO_TEXTO, yytext());}
<YYINITIAL> "\"AREA_TEXTO\""                {return new Symbol(CLASS_AREA_TEXTO, yytext());}
<YYINITIAL> "\"CHECKBOX\""                  {return new Symbol(CLASS_CHECKBOX, yytext());}
<YYINITIAL> "\"RADIO\""                     {return new Symbol(CLASS_RADIO, yytext());}
<YYINITIAL> "\"FICHERO\""                   {return new Symbol(CLASS_FICHERO, yytext());}
<YYINITIAL> "\"IMAGEN\""                    {return new Symbol(CLASS_IMAGEN, yytext());}
<YYINITIAL> "\"COMBO\""                     {return new Symbol(CLASS_COMBO, yytext());}
<YYINITIAL> "\"BOTON\""                     {return new Symbol(CLASS_BOTON, yytext());}

<YYINITIAL> "\"CENTRO\""                    {return new Symbol(CENTRO, yytext());}
<YYINITIAL> "\"IZQUIERDA\""                 {return new Symbol(IZQUIERDA, yytext());}
<YYINITIAL> "\"DERECHA\""                   {return new Symbol(DERECHA, yytext());}
<YYINITIAL> "\"JUSTIFICAR\""                {return new Symbol(JUSTIFICAR, yytext());}

<YYINITIAL> "\""([sS][iI])"\""                    {return new Symbol(SI, yytext());}
<YYINITIAL> "\""([nN][oO])"\""                    {return new Symbol(NO, yytext());}

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
<YYINITIAL> {OPCIONES}                  {return new Symbol(OPCIONES, yytext());}
<YYINITIAL> {VALUE}                     {return new Symbol(VALUE, yytext());}
<YYINITIAL> {LITERAL}                   {return new Symbol(LITERAL, yytext());}

[^]                                     {System.out.println("Error " + yytext());}