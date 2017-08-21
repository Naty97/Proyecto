package Preguntas.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.Border;
import Preguntas.Pregunta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Tablero extends javax.swing.JFrame {

    Integer[][] matrizInt = new Integer[5][8];
    JLabel[][] matrizLb = new JLabel[5][8];
    private Timer time;
    private int conta = 0;
    JButton boton = new JButton();
    int puntos = 0;
    ArrayList<String> pregs = new ArrayList<String>();
    ArrayList<String> resps = new ArrayList<String>();
    int numero;

    public Tablero() {
        initComponents();
        setTitle("Preguntas y Respuestas");
        mosMat(matrizLb, matrizInt);
        jPanel1.setVisible(true);
        preguntas();
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
                    matrizLb[k][l].addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            JLabel obstaculo = (JLabel) e.getSource();
                            obstaculo.setIcon(new ImageIcon(this.getClass().getResource("/Iconos/espacio.jpg")));
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                    });
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

    public void preguntas() {

        Random aleaPregs = new Random();
        numero = (int) Math.floor(Math.random() * 50);
        pregs.add("El elemento básico de Java es el objeto?");
        resps.add("V");
        pregs.add("Las plantillas para crear objetos son denominadas instancias?");
        resps.add("F");
        pregs.add("Un objeto es un conjunto de variables?");
        resps.add("V");
        pregs.add("Un objeto particular se denomina una instancia?");
        resps.add("V");
        pregs.add("La encapsulación de variables consiste en liberar las varibles?");
        resps.add("F");
        pregs.add("Una clase es una plantilla que define variables?");
        resps.add("V");
        pregs.add("La herencia permite definir nuevas clases a partir de otras existentes?");
        resps.add("V");
        pregs.add("Las subclases heredan los estados de las superclases?");
        resps.add("V");
        pregs.add("Las clases derivadas se encuentran limitadas por los estados?");
        resps.add("F");
        pregs.add("Con Herencia se puede reutilizar el código?");
        resps.add("V");
        pregs.add("Con Herencia se pueden implementar superclases abstractas?");
        resps.add("V");
        pregs.add("Las superclases abstractas definen comportamientos genéricos?");
        resps.add("V");
        pregs.add("Un arrayList es lo mismo que una matriz?");
        resps.add("F");
        pregs.add("Las palabras reservadas son palabras que el compilador reconoce como especiales?");
        resps.add("V");
        pregs.add("El \"for\" sirve para recorrer matrices? ");
        resps.add("V");
        pregs.add("Un algoritmo es lo mismo que pseudocódigo?");
        resps.add("F");
        pregs.add("Un programa es la implementación del algoritmo en un lenguaje de programación?");
        resps.add("V");
        pregs.add("Un compilador genera un programa ejecutable a partir del código fuente?");
        resps.add("V");
        pregs.add("El mantenimiento adaptativo es la correción de defectos?");
        resps.add("F");
        pregs.add("Los Bytecodes son el lenguaje máquina de una máquina virtual?");
        resps.add("V");
        pregs.add("Los applets son programas independientes?");
        resps.add("F");
        pregs.add("El punto de entrada de un programa en Java es el main?");
        resps.add("V");
        pregs.add("Un Array es una estructura de datos que contiene datos de diferente tipo?");
        resps.add("F");
        pregs.add("El tamaño del Array se establece después de crearlo?");
        resps.add("F");
        pregs.add("A los arrays unidimensionales se les conoce como matrices?");
        resps.add("F");
        pregs.add("A los arrays bidimensionales se les conoce como vectores?");
        resps.add("F");
        pregs.add("Para declarar un array se utilizan paréntesis?");
        resps.add("F");
        pregs.add("Los arrays se crean sin el operador \"new\"?");
        resps.add("F");
        pregs.add("El tamaño se indica después de los corchetes?");
        resps.add("F");
        pregs.add("Un While hace la misma función que un Do - While?");
        resps.add("F");
        pregs.add("El primer lenguaje de alto nivel fue Java?");
        resps.add("F");
        pregs.add("If, else, for y while son funciones de acceso a datos?");
        resps.add("F");
        pregs.add("EOF (End of file) significa Empty or full?");
        resps.add("F");
        pregs.add("Los operadores relacionales se utilizan para suma y resta?");
        resps.add("F");
        pregs.add("El pseudocódigo es un lenguaje verdadero?");
        resps.add("F");
        pregs.add("Se comparar la variable int con una variable booleana?");
        resps.add("F");
        pregs.add("Java es un lenguaje orientado a objetos?");
        resps.add("V");
        pregs.add("File, edit, view son algunas funciones de NetBeans?");
        resps.add("V");
        pregs.add("NetBeans está hecho principalmente para el lenguaje de programacion java?");
        resps.add("V");
        pregs.add("La meanera correcta de utilizar un for es asi: for (i <= 10;  i++; int i = 1)?");
        resps.add("F");
        pregs.add("Operadores aritmeticos de java son los siguientes: +, -, *, /, % ?");
        resps.add("V");
        pregs.add("Es correcto importar el Scanner de esta manera: #import javax.util.Scanner?");
        resps.add("F");
        pregs.add("Estos son tipos de variables de java: int, char, String y byte ?");
        resps.add("V");
        pregs.add("Las llaves son imprescindibles en Java?");
        resps.add("V");
        pregs.add("En sí, Java es una colección de clases?");
        resps.add("V");
        pregs.add("Javadoc es el generador de documentación?");
        resps.add("V");
        pregs.add("Un String es para mostrar cadenas?");
        resps.add("V");
        pregs.add("Los operadores condicionales son los siguientes: <, >=, >=, >, ==?");
        resps.add("F");
        pregs.add("Operadores relacionales son los siguientes: <, >=, >=, >, == ");
        resps.add("V");
        pregs.add("Una lista es lo mismo que un arreglo?");
        resps.add("F");
        pregs.get(numero);
        resps.get(numero);
        txtPregs.setText(pregs.get(numero));
        System.out.print(resps);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tablero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnTrue = new javax.swing.JRadioButton();
        btnFalse = new javax.swing.JRadioButton();
        btnComprueba = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPregs = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        txtPuntos = new javax.swing.JLabel();
        txtConta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtCrono = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        txtTime = new javax.swing.JLabel();
        num1 = new javax.swing.JLabel();
        num2 = new javax.swing.JLabel();
        num3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        btnTrue.setText("Verdadero");
        btnTrue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrueActionPerformed(evt);
            }
        });

        btnFalse.setText("Falso");

        btnComprueba.setText("Comprobar");

        txtPregs.setColumns(20);
        txtPregs.setRows(5);
        jScrollPane1.setViewportView(txtPregs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnTrue, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFalse, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(btnComprueba, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFalse)
                    .addComponent(btnTrue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnComprueba, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtPuntos.setText("     Puntos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtConta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        txtCrono.setBackground(new java.awt.Color(255, 204, 204));

        btnStart.setText("Empezar");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Parar");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        txtTime.setText("Tiempo:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnStart)
                    .addComponent(btnStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(num2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(num1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(num3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(num2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStop)
                    .addComponent(num3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompruebaActionPerformed
        if (btnTrue.isSelected()) {
            System.out.print("Su respuesta es afirmativa");

        }
        if (btnFalse.isSelected()) {
            System.out.print("Su respuesta es negativa");
        }
    }//GEN-LAST:event_btnCompruebaActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conta++;
                txtCrono.setText(conta + "");
                if (conta >= 60) {
                    time.stop();
                }
            }

        });
        time.start();

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        time.stop();
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnTrueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrueActionPerformed
        {
            boton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {

                    System.out.print("La respuesta es correcta");

                }

            });

        }
    }

    private void btnCompruebaMouseClicked(java.awt.event.MouseEvent evt) {

        boolean afirmativo = btnTrue.isSelected();
        if (resps.get(numero).equals("V") && afirmativo) {
            System.out.print("Respuesta correcta");
            puntos++;
        } else if (resps.get(numero).equals("F") && !afirmativo) {
            System.out.print("Respuesta correcta");
            puntos++;
        } else {
            System.out.print("Respuesta incorrecta");
            if (puntos > 0) {
                puntos--;
            }
        }
        txtConta.setText(String.valueOf(puntos));
    }//GEN-LAST:event_btnTrueActionPerformed

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
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JRadioButton btnTrue;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel num1;
    private javax.swing.JLabel num2;
    private javax.swing.JLabel num3;
    private javax.swing.JPanel tablero;
    private javax.swing.JTextField txtConta;
    private javax.swing.JLabel txtCrono;
    private javax.swing.JTextArea txtPregs;
    private javax.swing.JLabel txtPuntos;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables
}
