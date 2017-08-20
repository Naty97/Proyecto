package Preguntas.interfaz;

import java.awt.Color;
import java.util.Random;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;


public class Tablero extends javax.swing.JFrame {

    Integer[][] matrizInt = new Integer[5][8];
    JLabel[][] matrizLb = new JLabel[5][8];

    public Tablero() {
        initComponents();
        setTitle("Preguntas y Respuestas");
        mosMat(matrizLb, matrizInt);
//        cargarBotones();
    }

//    public void cargarBotones() {
//        int posicionX = 0;
//        int posicionY = 0;
//        for (int i = 0; i < 4; i++) {
//            for (int x = 0; x < 4; x++) {
//                JButton boton = new JButton();
//                boton.setSize(50, 50);
//                boton.setLocation(posicionX, posicionY);
//                boton.setText(String.format("%s %s", i, x));
//                tablero.add(boton);
//                posicionX = posicionX + 65;
//            }
//            posicionY = posicionY + 60;
//            posicionX = 0;
//        }
//    }
    public void llenarMatriz() {
        int h = 0;
        int n = 0;
        Random rn = new Random();
        int conta = 0;
        for (int i = 0; i < 5; i++) {
            for (int x = 0; x < 8; x++) {
                matrizInt[i][x] = 0;
            }
        }
        int m = (int) Math.floor(Math.random() * 5);
        int o = (int) Math.floor(Math.random() * 8);
        matrizInt[0][0] = 2;
        matrizInt[m][o] = 4;
        matrizInt[4][7] = 5;
        while (conta < 10) {
            h = (int) Math.floor(Math.random() * 5);
            n = (int) Math.floor(Math.random() * 8);
            if (matrizInt[h][n] == 0) {
                matrizInt[h][n] = 1;
                conta++;
            }
        }
    }

    public void mosMat(JLabel[][] matrizLb, Integer[][] matrizInt) {
        llenarMatriz();
        int n = 80;
        int m = 80;
        Border bordo = BorderFactory.createLineBorder(Color.black, 2);
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 8; l++) {
                if (matrizInt[k][l] == 0) {
                    ImageIcon espacio = new ImageIcon(this.getClass().getResource("/Iconos/espacio.jpg"));
                    matrizLb[k][l] = new JLabel();
                    matrizLb[k][l].setBounds(n, m, 80, 80);
                    matrizLb[k][l].setIcon(espacio);
                    matrizLb[k][l].setBorder(bordo);
                    tablero.add(matrizLb[k][l]);
                } else if (matrizInt[k][l] == 1) {
                    ImageIcon camino = new ImageIcon(this.getClass().getResource("/Iconos/obstaculo.jpg"));
                    matrizLb[k][l] = new JLabel();
                    matrizLb[k][l].setBounds(n, m, 80, 80);
                    matrizLb[k][l].setIcon(camino);
                    matrizLb[k][l].setBorder(bordo);
                    tablero.add(matrizLb[k][l]);

                } else if (matrizInt[k][l] == 2) {
                    ImageIcon usuario = new ImageIcon(this.getClass().getResource("/Iconos/usuario.jpg"));
                    matrizLb[k][l] = new JLabel();
                    matrizLb[k][l].setBounds(n, m, 80, 80);
                    matrizLb[k][l].setIcon(usuario);
                    matrizLb[k][l].setBorder(bordo);
                    tablero.add(matrizLb[k][l]);
                } else if (matrizInt[k][l] == 4) {
                    ImageIcon comodin = new ImageIcon(this.getClass().getResource("/Iconos/comodin.jpg"));
                    matrizLb[k][l] = new JLabel();
                    matrizLb[k][l].setBounds(n, m, 80, 80);
                    matrizLb[k][l].setIcon(comodin);
                    matrizLb[k][l].setBorder(bordo);
                    tablero.add(matrizLb[k][l]);
                } else if (matrizInt[k][l] == 5) {
                    ImageIcon meta = new ImageIcon(this.getClass().getResource("/Iconos/meta.jpg"));
                    matrizLb[k][l] = new JLabel();
                    matrizLb[k][l].setBounds(n, m, 80, 80);
                    matrizLb[k][l].setIcon(meta);
                    matrizLb[k][l].setBorder(bordo);
                    tablero.add(matrizLb[k][l]);
                }
                n = n + 80;
            }
            n = 80;
            m = m + 80;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tablero = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPregs = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        txtComo = new javax.swing.JTextField();
        btnTrue = new javax.swing.JRadioButton();
        btnFalse = new javax.swing.JRadioButton();
        btnComprueba = new javax.swing.JButton();
        txtPuntos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConta = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txtPregs.setColumns(20);
        txtPregs.setRows(5);
        jScrollPane2.setViewportView(txtPregs);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtComo))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtComo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        btnTrue.setText("Verdadero");

        btnFalse.setText("Falso");

        btnComprueba.setText("Comprobar");
        btnComprueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompruebaActionPerformed(evt);
            }
        });

        txtPuntos.setText("           Puntos");

        txtConta.setColumns(20);
        txtConta.setRows(5);
        jScrollPane1.setViewportView(txtConta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 4, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnTrue, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFalse, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnComprueba, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrue)
                    .addComponent(btnFalse))
                .addGap(18, 18, 18)
                .addComponent(btnComprueba, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCompruebaActionPerformed

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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprueba;
    private javax.swing.JRadioButton btnFalse;
    private javax.swing.JRadioButton btnTrue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel tablero;
    private javax.swing.JTextField txtComo;
    private javax.swing.JTextArea txtConta;
    private javax.swing.JTextArea txtPregs;
    private javax.swing.JLabel txtPuntos;
    // End of variables declaration//GEN-END:variables
}
