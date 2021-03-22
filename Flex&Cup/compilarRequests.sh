#!/bin/bash

echo Compilando Lexer...
jflex requestsLexer.flex
echo ---------------------

echo Compilando Parser...
cup -parser RequestsParser -symbols RequestsSym requestsParser.cup

mv RequestsLexer.java /home/asael/NetBeansProjects/WebFormBuilder/AppServer/src/main/java/analizadores/lexico/
mv RequestsParser.java RequestsSym.java /home/asael/NetBeansProjects/WebFormBuilder/AppServer/src/main/java/analizadores/sintactico/
