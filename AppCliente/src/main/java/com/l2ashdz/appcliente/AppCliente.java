package com.l2ashdz.appcliente;

import com.l2ashdz.appcliente.controller.TextEditorController;
import com.l2ashdz.appcliente.view.TextEditorView;

/**
 *
 * @author asael
 */
public class AppCliente {

    public static void main(String[] args) {
        TextEditorView textEditorV = new TextEditorView();
        TextEditorController textEditorC = new TextEditorController(textEditorV);
        textEditorC.start();
    }
}
