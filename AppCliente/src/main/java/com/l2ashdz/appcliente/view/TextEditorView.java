/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l2ashdz.appcliente.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author asael
 */
public class TextEditorView extends javax.swing.JFrame {

    /**
     * Creates new form EditorTexto
     */
    public TextEditorView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDesk = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        pnlInfo = new javax.swing.JPanel();
        btnSendToServer = new javax.swing.JButton();
        lblPosCaret = new javax.swing.JLabel();
        btnShowReports = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblLoggedUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaRespuestas = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itmAbrir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itmNuevo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itmSave = new javax.swing.JMenuItem();
        itmSaveAs = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itmRehacer = new javax.swing.JMenuItem();
        itmDeshacer = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itmCopiar = new javax.swing.JMenuItem(new DefaultEditorKit.CopyAction());
        itmCortar = new javax.swing.JMenuItem(new DefaultEditorKit.CutAction());
        itmPegar = new javax.swing.JMenuItem(new DefaultEditorKit.PasteAction());
        jMenu3 = new javax.swing.JMenu();
        itmManual = new javax.swing.JMenuItem();
        itmAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 600));

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnSendToServer.setText("Enviar al servidor");

        lblPosCaret.setText("Linea: 1  -  Columna: 1");

        btnShowReports.setText("Area reportes");
        btnShowReports.setEnabled(false);

        btnLogout.setText("Cerrar sesion");
        btnLogout.setEnabled(false);

        lblLoggedUser.setText("No esta logeado");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoggedUser)
                .addGap(80, 80, 80)
                .addComponent(lblPosCaret)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnSendToServer)
                .addGap(18, 18, 18)
                .addComponent(btnShowReports)
                .addContainerGap())
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosCaret)
                    .addComponent(btnSendToServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout)
                    .addComponent(lblLoggedUser))
                .addGap(8, 8, 8))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Area de respuestas:");

        txtAreaRespuestas.setEditable(false);
        txtAreaRespuestas.setColumns(20);
        txtAreaRespuestas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAreaRespuestas.setRows(5);
        jScrollPane2.setViewportView(txtAreaRespuestas);

        javax.swing.GroupLayout pnlDeskLayout = new javax.swing.GroupLayout(pnlDesk);
        pnlDesk.setLayout(pnlDeskLayout);
        pnlDeskLayout.setHorizontalGroup(
            pnlDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(pnlDeskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        pnlDeskLayout.setVerticalGroup(
            pnlDeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeskLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Archivo");

        itmAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmAbrir.setText("Abrir...");
        jMenu1.add(itmAbrir);
        jMenu1.add(jSeparator1);

        itmNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmNuevo.setText("Nuevo");
        jMenu1.add(itmNuevo);
        jMenu1.add(jSeparator2);

        itmSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmSave.setText("Guardar");
        jMenu1.add(itmSave);

        itmSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmSaveAs.setText("Guardar como");
        jMenu1.add(itmSaveAs);

        menuBar.add(jMenu1);

        jMenu2.setText("Editar");

        itmRehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmRehacer.setText("Rehacer");
        jMenu2.add(itmRehacer);

        itmDeshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmDeshacer.setText("Deshacer");
        jMenu2.add(itmDeshacer);
        jMenu2.add(jSeparator3);

        itmCopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmCopiar.setText("Copiar");
        jMenu2.add(itmCopiar);

        itmCortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmCortar.setText("Cortar");
        jMenu2.add(itmCortar);

        itmPegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itmPegar.setText("Pegar");
        jMenu2.add(itmPegar);

        menuBar.add(jMenu2);

        jMenu3.setText("Ayuda");

        itmManual.setText("Manual de usuario");
        jMenu3.add(itmManual);

        itmAbout.setText("Acerda de...");
        itmAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAboutActionPerformed(evt);
            }
        });
        jMenu3.add(itmAbout);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(pnlDesk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAboutActionPerformed
        String mensaje = "Proyecto 1 Compiladores 1 2021\nAsael Hernandez";
        JOptionPane.showMessageDialog(null, mensaje, "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_itmAboutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSendToServer;
    private javax.swing.JButton btnShowReports;
    private javax.swing.JMenuItem itmAbout;
    private javax.swing.JMenuItem itmAbrir;
    private javax.swing.JMenuItem itmCopiar;
    private javax.swing.JMenuItem itmCortar;
    private javax.swing.JMenuItem itmDeshacer;
    private javax.swing.JMenuItem itmManual;
    private javax.swing.JMenuItem itmNuevo;
    private javax.swing.JMenuItem itmPegar;
    private javax.swing.JMenuItem itmRehacer;
    private javax.swing.JMenuItem itmSave;
    private javax.swing.JMenuItem itmSaveAs;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lblLoggedUser;
    private javax.swing.JLabel lblPosCaret;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel pnlDesk;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextArea txtAreaRespuestas;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnSendToServer() {
        return btnSendToServer;
    }

    public JButton getBtnShowReports() {
        return btnShowReports;
    }

    public JMenuItem getItmAbout() {
        return itmAbout;
    }

    public JMenuItem getItmAbrir() {
        return itmAbrir;
    }

    public JMenuItem getItmCopiar() {
        return itmCopiar;
    }

    public JMenuItem getItmCortar() {
        return itmCortar;
    }

    public JMenuItem getItmDeshacer() {
        return itmDeshacer;
    }

    public JMenuItem getItmManual() {
        return itmManual;
    }

    public JMenuItem getItmNuevo() {
        return itmNuevo;
    }

    public JMenuItem getItmPegar() {
        return itmPegar;
    }

    public JMenuItem getItmRehacer() {
        return itmRehacer;
    }

    public JMenuItem getItmSave() {
        return itmSave;
    }

    public JMenuItem getItmSaveAs() {
        return itmSaveAs;
    }

    public JLabel getLblPosCaret() {
        return lblPosCaret;
    }

    public JPanel getPnlDesk() {
        return pnlDesk;
    }

    public JTextArea getTxtArea() {
        return txtArea;
    }

    public JLabel getLblLoggedUser() {
        return lblLoggedUser;
    }

    public JTextArea getTxtAreaRespuestas() {
        return txtAreaRespuestas;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }
}
