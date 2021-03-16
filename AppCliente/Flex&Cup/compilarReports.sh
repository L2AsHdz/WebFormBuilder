#!/bin/bash

echo Compilando Lexer...
jflex reportsLexer.flex
echo ---------------------

echo Compilando Parser...
cup -parser ReportsParser -symbols ReportsSym reportsParser.cup

mv ReportsLexer.java /home/asael/NetBeansProjects/WebFormBuilder/AppCliente/src/main/java/com/l2ashdz/appcliente/analizadores/lexico/
mv ReportsParser.java RequestsSym.java /home/asael/NetBeansProjects/WebFormBuilder/AppCliente/src/main/java/com/l2ashdz/appcliente/analizadores/sintactico/
