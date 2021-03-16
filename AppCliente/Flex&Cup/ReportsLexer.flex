 

 %%

%class ReportsLexer
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

SALTO = \n|\r|\r\n
ESPACIO = {SALTO} | [ \t\f]

ID = [\_\-\$](\w|[\-\$])*

%%

<YYINITIAL> "SELECT"        {return symbol(SELECT);}
<YYINITIAL> "TO"            {return symbol(TO);}
<YYINITIAL> "FORM"          {return symbol(FORM);}
<YYINITIAL> "WHERE"         {return symbol(WHERE);}
<YYINITIAL> "AND"           {return symbol(AND);}
<YYINITIAL> "OR"            {return symbol(OR):}
<YYINITIAL> "NOT"           {return symbol(NOT);}

<YYINITIAL> {
    "->"                                {return symbol(ARROW);}
    "<"                                 {return symbol(LESS_THAN);}
    ">"                                 {return symbol(GREATER_THAN);}
    "="                                 {return symbol(EQUAL_TO);}
    "<="                                {return symbol(LESS_THAN_OR_EQUAL_TO);}
    ">="                                {return symbol(GREATER_THAN_OR_EQUAL_TO);}
    "!="                                {return symbol(NOT_EQUAL_TO);}
    "["                                 {return symbol(OPEN_BRACKET);}
    "]"                                 {return symbol(CLOSE_BRACKET);}
}

<YYINITIAL> {ID}                {return symbol(ID);}
<YYINITIAL> {}

[^]                     {addLexicError();}