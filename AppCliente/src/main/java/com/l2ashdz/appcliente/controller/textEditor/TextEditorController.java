package com.l2ashdz.appcliente.controller.textEditor;

import com.l2ashdz.appcliente.aux.ResponseAnalyzer;
import com.l2ashdz.appcliente.view.TextEditorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.HeadlessException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import static com.l2ashdz.appcliente.controller.FileController.*;
import static com.l2ashdz.appcliente.controller.textEditor.SendDataToServer.send;

/**
 *
 * @author asael
 */
public class TextEditorController extends WindowAdapter implements ActionListener,
        DocumentListener, UndoableEditListener, CaretListener {
    
    private final UndoManager undoManager = new UndoManager();
    private final TextEditorView textEditorV;
    private final ResponseAnalyzer responseA = new ResponseAnalyzer();
    private boolean hasChanges = false;
    private String usuarioLogueado = "";
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

        this.textEditorV.getTxtArea().addCaretListener(this);
        this.textEditorV.getTxtArea().getDocument().addDocumentListener(this);
        this.textEditorV.getTxtArea().getDocument().addUndoableEditListener(this);

        this.textEditorV.addWindowListener(this);
    }

    public void start() {
        this.textEditorV.pack();
        this.textEditorV.setTitle("Documento sin guardar");
        this.textEditorV.setResizable(false);
        this.textEditorV.setLocationRelativeTo(null);
        this.textEditorV.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.textEditorV.getBtnSendToServer() == e.getSource()) {
            String text = this.textEditorV.getTxtArea().getText();
            String respuestaServer = send(text, usuarioLogueado);
            responseA.analyze(respuestaServer);
            System.out.println(responseA.getMessages()+ "\n");
            System.out.println(responseA.getLoggedUser());
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
            rehacer();
        } else if (this.textEditorV.getItmDeshacer() == e.getSource()) {
            deshacer();
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
                this.textEditorV.setTitle(path);
                hasChanges = false;
            } catch (Exception ex) {
                System.out.println("se cancelo");
                ex.printStackTrace(System.out);
            }
        } else {
            cambiosSinGuardar(1);
        }
    }

    private void nuevo() {
        if (!hasChanges) {
            this.textEditorV.getTxtArea().setText("");
            this.textEditorV.setTitle("Documento sin guardar");
            path = "";
            hasChanges = false;
        } else {
            cambiosSinGuardar(2);
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

    private void cambiosSinGuardar(int op) {
        String[] options = {"Guardar Cambios", "Desechar Cambios", "Cancelar"};
        int selection = JOptionPane.showOptionDialog(null, "Hay cambios sin guardar!",
                "Informacion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        switch (selection) {
            case 0 ->
                guardar();
            case 1 -> {
                switch (op) {
                    case 0 ->
                        System.exit(0);
                    case 1 -> {
                        hasChanges = false;
                        abrir();
                    }
                    case 2 -> {
                        hasChanges = false;
                        nuevo();
                    }
                }
            }
            case 2 -> {
            }
        }
    }
    
    private void rehacer() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
        }
    }

    private void deshacer() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
        }
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        hasChanges = true;
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        hasChanges = true;
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        hasChanges = true;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (!hasChanges) {
            System.exit(0);
        } else {
            cambiosSinGuardar(0);
        }
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
    }

    @Override
    public void caretUpdate(CaretEvent ce) {
        int linea = 1;
        int columna = 1;

        try {
            int caretPos = this.textEditorV.getTxtArea().getCaretPosition();
            linea = this.textEditorV.getTxtArea().getLineOfOffset(caretPos);
            columna = caretPos - this.textEditorV.getTxtArea().getLineStartOffset(linea);
            linea++;
            columna++;
            
        } catch (BadLocationException e) {
        }
        this.textEditorV.getLblPosCaret().setText("Linea: " + linea + "  -  Columna: " + columna);
    }
}
