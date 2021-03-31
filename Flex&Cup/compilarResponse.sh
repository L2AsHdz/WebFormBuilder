#!/bin/bash

echo Compilando Lexer...
jflex responseLexer.flex
echo ---------------------

echo Compilando Parser...
cup -parser ResponseParser -symbols ResponseSym responseParser.cup

mv ResponseLexer.java /home/asael/NetBeansProjects/WebFormBuilder/AppCliente/src/main/java/com/l2ashdz/appcliente/analizador/lexico/
mv ResponseParser.java ResponseSym.java /home/asael/NetBeansProjects/WebFormBuilder/AppCliente/src/main/java/com/l2ashdz/appcliente/analizador/sintactico/
