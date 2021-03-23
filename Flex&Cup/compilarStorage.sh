#!/bin/bash

echo Compilando Lexer...
jflex storageLexer.flex
echo ---------------------

echo Compilando Parser...
cup -parser StorageParser -symbols StorageSym storageParser.cup

mv StorageLexer.java /home/asael/NetBeansProjects/WebFormBuilder/AppServer/src/main/java/analizadores/lexico/
mv StorageParser.java StorageSym.java /home/asael/NetBeansProjects/WebFormBuilder/AppServer/src/main/java/analizadores/sintactico/
