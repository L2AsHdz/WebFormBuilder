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
    private String path;

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
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this.textEditorV);
            try {
                path = fc.getSelectedFile().getAbsolutePath();
                this.textEditorV.getTxtArea().setText(readFile(path));
                //withoutChange = true;
            } catch (Exception ex) {
                System.out.println("se cancelo");
                ex.printStackTrace(System.out);
            }
        } else if (this.textEditorV.getItmNuevo() == e.getSource()) {
            //if (withoutChange) {
                this.textEditorV.getTxtArea().setText("");
                path = "";
                //withoutChange = true;
            //} else {
                //cambiosSinGuardar(evt, 2);
            //}
        } else if (this.textEditorV.getItmSave() == e.getSource()) {
            String texto = this.textEditorV.getTxtArea().getText();
            if (verifyFile(path)) {
                saveFile(path, texto);
                //withoutChange = true;
            } else {
                JFileChooser fc = new JFileChooser();
                path = "";
                try {
                    if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        try {
                            path = fc.getSelectedFile().getAbsolutePath() + ".txt";
                            //withoutChange = true;
                        } catch (Exception ex) {
                            System.out.println("se cancelo");
                            ex.printStackTrace(System.out);
                        }
                    }
                    saveFile(path, texto);
                } catch (HeadlessException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } else if (this.textEditorV.getItmSaveAs() == e.getSource()) {

        } else if (this.textEditorV.getItmRehacer() == e.getSource()) {

        } else if (this.textEditorV.getItmDeshacer() == e.getSource()) {

        } else if (this.textEditorV.getItmCopiar() == e.getSource()) {

        } else if (this.textEditorV.getItmCortar() == e.getSource()) {

        } else if (this.textEditorV.getItmPegar() == e.getSource()) {

        } else if (this.textEditorV.getItmManual() == e.getSource()) {

        } else if (this.textEditorV.getItmAbout() == e.getSource()) {

        }
    }

}
