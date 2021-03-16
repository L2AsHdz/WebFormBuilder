#!/bin/bash

echo Compilando Lexer...
jflex requestsLexer.flex
echo ---------------------

echo Compilando Parser...
cup -parser RequestsParser -symbols RequestsSym requestsParser.cup

mv RequestsLexer.java /home/asael/NetBeansProjects/WebFormBuilder/AppCliente/src/main/java/com/l2ashdz/appcliente/analizadores/lexico/
mv RequestsParser.java RequestsSym.java /home/asael/NetBeansProjects/WebFormBuilder/AppCliente/src/main/java/com/l2ashdz/appcliente/analizadores/sintactico/
