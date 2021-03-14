package com.l2ashdz.appcliente.controller;

import com.l2ashdz.appcliente.view.TextEditorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;

import static com.l2ashdz.appcliente.controller.FileController.*;
import java.awt.HeadlessException;

/**
 *
 * @author asael
 */
public class TextEditorController implements ActionListener {

    private TextEditorView textEditorV;
    private boolean hasChanges = false;
    private String path = "";

    public TextEditorController(TextEditorView textEditorV) {
        this.textEditorV = textEditorV;
        this.textEditorV.getBtnSendToServer().addActionListener(this);
        this.textEditorV.getBtnShowReports().addActionListener(this);

        this.textEditorV.getItmAbrir().addActionListener(this);
        this.textEditorV.getItmSave().addActionListener(this);
        this.textEditorV.getItmSaveAs().addActionListener(this);
        this.textEditorV.getItmNuevo().addActionListener(this);

        this.textEditorV.getItmRehacer().addActionListener(this);
        this.textEditorV.getItmDeshacer().addActionListener(this);
        this.textEditorV.getItmCopiar().addActionListener(this);
        this.textEditorV.getItmCortar().addActionListener(this);
        this.textEditorV.getItmPegar().addActionListener(this);

        this.textEditorV.getItmAbout().addActionListener(this);
        this.textEditorV.getItmManual().addActionListener(this);
    }

    public void start() {
        this.textEditorV.pack();
        this.textEditorV.setResizable(false);
        this.textEditorV.setLocationRelativeTo(null);
        this.textEditorV.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.textEditorV.getBtnSendToServer() == e.getSource()) {

        } else if (this.textEditorV.getBtnShowReports() == e.getSource()) {

        } else if (this.textEditorV.getItmAbrir() == e.getSource()) {
            abrir();
        } else if (this.textEditorV.getItmNuevo() == e.getSource()) {
            nuevo();
        } else if (this.textEditorV.getItmSave() == e.getSource()) {
            guardar();
        } else if (this.textEditorV.getItmSaveAs() == e.getSource()) {
            guardarComo();
        } else if (this.textEditorV.getItmRehacer() == e.getSource()) {

        } else if (this.textEditorV.getItmDeshacer() == e.getSource()) {

        } else if (this.textEditorV.getItmCopiar() == e.getSource()) {

        } else if (this.textEditorV.getItmCortar() == e.getSource()) {

        } else if (this.textEditorV.getItmPegar() == e.getSource()) {

        } else if (this.textEditorV.getItmManual() == e.getSource()) {

        } else if (this.textEditorV.getItmAbout() == e.getSource()) {

        }
    }

    private void abrir() {
        if (!hasChanges) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this.textEditorV);
            try {
                path = fc.getSelectedFile().getAbsolutePath();
                this.textEditorV.getTxtArea().setText(readFile(path));
                hasChanges = false;
            } catch (Exception ex) {
                System.out.println("se cancelo");
                ex.printStackTrace(System.out);
            }
        } else {
            //cambiosSinGuardar
        }
    }

    private void nuevo() {
        if (!hasChanges) {
            this.textEditorV.getTxtArea().setText("");
            path = "";
            hasChanges = false;
        } else {
            //cambiosSinGuardar
        }
    }

    private void guardar() {
        String texto = this.textEditorV.getTxtArea().getText();
        if (verifyFile(path)) {
            saveFile(path, texto);
            hasChanges = false;
        } else {
            JFileChooser fc = new JFileChooser();
            try {
                if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        path = fc.getSelectedFile().getAbsolutePath() + ".txt";
                        saveFile(path, texto);
                        hasChanges = false;
                    } catch (Exception ex) {
                        System.out.println("se cancelo");
                        ex.printStackTrace(System.out);
                    }
                }
            } catch (HeadlessException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    private void guardarComo() {
        String texto = this.textEditorV.getTxtArea().getText();
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Guardar Como");
        try {
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    path = fc.getSelectedFile().getAbsolutePath() + ".txt";
                    saveFile(path, texto);
                    hasChanges = false;
                } catch (Exception e) {
                    System.out.println("se cancelo");
                }
            }
        } catch (HeadlessException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
