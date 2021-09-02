/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripto2021.hokkinon;

import com.kripto2021.hokkinon.affine.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author PERSONAL
 */
public class App extends javax.swing.JFrame {
    private File inputFile;
    private Scanner fileReader;
    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        
        this.algorithmChoiceComboBox.addItem(new ComboBoxItem("Affine"));
        this.algorithmChoiceComboBox.addItem(new ComboBoxItem("Playfair"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uploadFile = new javax.swing.JFileChooser();
        algorithmChoiceComboBox = new javax.swing.JComboBox<>();
        cipherteksTextAreaContainer = new javax.swing.JScrollPane();
        cipherteksTextArea = new javax.swing.JTextArea();
        plainteksTextAreaContainer = new javax.swing.JScrollPane();
        plainteksTextArea = new javax.swing.JTextArea();
        key = new javax.swing.JTextField();
        plainteksLabel = new javax.swing.JLabel();
        keyLabel = new javax.swing.JLabel();
        plainteksLabel1 = new javax.swing.JLabel();
        popUp = new javax.swing.JPanel();
        uploadPlainteksButton = new javax.swing.JButton();
        saveCipherteksButton = new javax.swing.JButton();
        savePlainteksButton = new javax.swing.JButton();
        uploadCipherteksButton = new javax.swing.JButton();

        uploadFile.setName("uploadFile"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hokkinon");
        setName("App"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        algorithmChoiceComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        algorithmChoiceComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algorithmChoiceComboBoxActionPerformed(evt);
            }
        });

        cipherteksTextArea.setColumns(20);
        cipherteksTextArea.setRows(5);
        cipherteksTextAreaContainer.setViewportView(cipherteksTextArea);

        plainteksTextArea.setColumns(20);
        plainteksTextArea.setRows(5);
        plainteksTextArea.setMargin(new java.awt.Insets(0, 0, 0, 0));
        plainteksTextAreaContainer.setViewportView(plainteksTextArea);

        key.setText("Key");

        plainteksLabel.setText("plainteks:");

        keyLabel.setText("key:");

        plainteksLabel1.setText("cipherteks:");

        javax.swing.GroupLayout popUpLayout = new javax.swing.GroupLayout(popUp);
        popUp.setLayout(popUpLayout);
        popUpLayout.setHorizontalGroup(
            popUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );
        popUpLayout.setVerticalGroup(
            popUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        uploadPlainteksButton.setText("Upload");
        uploadPlainteksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadPlainteksButtonActionPerformed(evt);
            }
        });

        saveCipherteksButton.setText("Save");

        savePlainteksButton.setText("Save");

        uploadCipherteksButton.setText("Upload");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(algorithmChoiceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 266, Short.MAX_VALUE))
                    .addComponent(popUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cipherteksTextAreaContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(keyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(key))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(plainteksLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(uploadCipherteksButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveCipherteksButton))
                            .addComponent(plainteksTextAreaContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(plainteksLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadPlainteksButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savePlainteksButton)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plainteksLabel)
                            .addComponent(uploadPlainteksButton)
                            .addComponent(savePlainteksButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plainteksTextAreaContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(key)
                            .addComponent(keyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plainteksLabel1)
                            .addComponent(saveCipherteksButton)
                            .addComponent(uploadCipherteksButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cipherteksTextAreaContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(algorithmChoiceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(popUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void algorithmChoiceComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algorithmChoiceComboBoxActionPerformed
        ComboBoxItem selected = (ComboBoxItem) this.algorithmChoiceComboBox.getSelectedItem();
        
        System.out.println(selected);
        if (selected.value().equals("Affine")) {
            this.popUp.removeAll();
            this.popUp.revalidate();
            this.popUp.repaint();

            this.popUp.add(new AffinePanel());
            this.popUp.revalidate();
            this.popUp.repaint();
        }
    }//GEN-LAST:event_algorithmChoiceComboBoxActionPerformed

    private void uploadPlainteksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadPlainteksButtonActionPerformed
        // TODO add your handling code here:
        try {
            this.inputFile = null;
            this.fileReader = null;
            
            this.uploadFile.showOpenDialog(this);
            this.inputFile = uploadFile.getSelectedFile();
            System.out.println(this.inputFile.getPath());
            System.out.println(this.inputFile.getAbsolutePath());
            System.out.println(this.inputFile.getParent());
            System.out.println(this.inputFile.getName());
            
            this.fileReader = new Scanner(this.inputFile);
        }
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_uploadPlainteksButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboBoxItem> algorithmChoiceComboBox;
    private javax.swing.JTextArea cipherteksTextArea;
    private javax.swing.JScrollPane cipherteksTextAreaContainer;
    private javax.swing.JTextField key;
    private javax.swing.JLabel keyLabel;
    private javax.swing.JLabel plainteksLabel;
    private javax.swing.JLabel plainteksLabel1;
    private javax.swing.JTextArea plainteksTextArea;
    private javax.swing.JScrollPane plainteksTextAreaContainer;
    private javax.swing.JPanel popUp;
    private javax.swing.JButton saveCipherteksButton;
    private javax.swing.JButton savePlainteksButton;
    private javax.swing.JButton uploadCipherteksButton;
    private javax.swing.JFileChooser uploadFile;
    private javax.swing.JButton uploadPlainteksButton;
    // End of variables declaration//GEN-END:variables
}
