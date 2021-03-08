#!/bin/bash

echo Compilando Lexer...
jflex lexer.flex
echo ---------------------

echo Compilando Parser...
cup -parser Parser -symbols sym parser.cup

mv Lexer.java /home/asael/NetBeansProjects/WebFormBuilder/AppCliente/src/main/java/com/l2ashdz/appcliente/analizadores/Lexico/
mv Parser.java sym.java /home/asael/NetBeansProjects/WebFormBuilder/AppCliente/src/main/java/com/l2ashdz/appcliente/analizadores/Lexico/
