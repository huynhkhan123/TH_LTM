/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class frmLab02_2 extends javax.swing.JFrame {

    /**
     * Creates new form frmLab02_2
     */
    public frmLab02_2() {
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

        jLabel1 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtString = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtText = new javax.swing.JTextArea();
        btnReadBinary = new javax.swing.JButton();
        btnWriteBinary = new javax.swing.JButton();
        btnReadText = new javax.swing.JButton();
        btnWriteText = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("path:");

        jLabel2.setText("string:");

        txtText.setColumns(20);
        txtText.setRows(5);
        jScrollPane1.setViewportView(txtText);

        btnReadBinary.setText("read file binary");
        btnReadBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadBinaryActionPerformed(evt);
            }
        });

        btnWriteBinary.setText("write file binary");
        btnWriteBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteBinaryActionPerformed(evt);
            }
        });

        btnReadText.setText("read file text");
        btnReadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadTextActionPerformed(evt);
            }
        });

        btnWriteText.setText("write file text");
        btnWriteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReadBinary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReadText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnWriteBinary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnWriteText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPath)
                            .addComponent(txtString, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReadBinary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWriteBinary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReadText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWriteText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReadBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadBinaryActionPerformed
        // TODO add your handling code here:
        byte[] a;
        File file;
        try {
            file = new File(txtPath.getText());
            FileInputStream fi = new FileInputStream(file);
            a = new byte[fi.available()];
            fi.read(a);
            fi.close();
            
            txtText.setText(new String(a));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnReadBinaryActionPerformed

    private void btnWriteBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteBinaryActionPerformed
        // TODO add your handling code here:
        byte[] a = new byte[20];
        File file;
        char[] s = txtString.getText().toCharArray();
        for(int i = 0; i < s.length; i++){
            a[i] = (byte)s[i];
        }
        
        try {
            file = new File(txtPath.getText());
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(a);
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnWriteBinaryActionPerformed

    private void btnWriteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteTextActionPerformed
        // TODO add your handling code here:
        try {
            FileWriter fw = new FileWriter(new File(txtPath.getText()));
            fw.write(txtString.getText());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnWriteTextActionPerformed

    private void btnReadTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadTextActionPerformed
        // TODO add your handling code here:
        try {
            FileReader fr = new FileReader(new File(txtPath.getText()));
            StringBuffer sb = new StringBuffer();
            char[] ca = new char[5];
            while(fr.ready()){
                int len = fr.read(ca);
                sb.append(ca, 0, len);
            }
            fr.close();
            txtText.setText(sb +"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnReadTextActionPerformed

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
            java.util.logging.Logger.getLogger(frmLab02_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLab02_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLab02_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLab02_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLab02_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReadBinary;
    private javax.swing.JButton btnReadText;
    private javax.swing.JButton btnWriteBinary;
    private javax.swing.JButton btnWriteText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtString;
    private javax.swing.JTextArea txtText;
    // End of variables declaration//GEN-END:variables
}
