
%%

%class Lexer
%public
%cup
%unicode
%line
%column

%{
    //private List<ErrorAnalisis> errores = new ArrayList();

    private Symbol symbol(int type){
        return new Symbol(type, new Token(yyline, yycolumn, yytext()));
    }

    private void addLexicError(){
        String descripcion = "El simbolo no pertenece al lenguaje";
        //errores.add(new ErrorAnalisis(yytext(), yyline+1, yycolumn+1, TipoError.LEXICO, descripcion));
    }





%}

SALTO = \n|\r|\r\n
ESPACIO = {SALTO} | [ \t\f]
DIGITO = [0-9]
LETRA = [a-zA-z]
NUMERO = 0|([1-9][0-9]*)(\.(0|([0-9]*[1-9])))?

NOSE = ({LETRA}|{DIGITO}|"-"|"_")*

%%

//Palabras reservadas

<YYINITIAL> "ini_solicitud"             {return symbol(START_REQUEST);}
<YYINITIAL> "fin_solicitud"             {return symbol(END_REQUEST);}

<YYINITIAL> "LOGIN_USUARIO"             {return symbol(LOGIN);}
<YYINITIAL> "CREAR_USUARIO"             {return symbol(CREATE_USER);}
<YYINITIAL> "ELIMINAR_USUARIO"          {return symbol(DELETE_USER);}
<YYINITIAL> "MODIFICAR_USUARIO"         {return symbol(MODIFY_USER);}

<YYINITIAL> "CREDENCIALES_USUARIO"      {return symbol(USER_CREDENTIALS);}

<YYINITIAL> "USUARIO"                   {return symbol(PARAM_USUARIO);}
<YYINITIAL> "PASSWORD"                  {return symbol(PARAM_PASSWORD);}
<YYINITIAL> "FECHA_CREACION"            {return symbol(PARAM_FECHA_CREACION);}
<YYINITIAL> "USUARIO_ANTIGUO"           {return symbol(PARAM_OLD_USER);}
<YYINITIAL> "USUARIO_NUEVO"             {return symbol(PARAM_NEW_USER);}
<YYINITIAL> "NUEVO_PASSWORD"            {return symbol(PARAM_NEW_PASSWORD);}

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
    "]"                                 {return symbol(CLOSE_BACKET);}
}

{NOSE}                                  {return symbol(NOSE);}

[^]                                 {addLexicError();}