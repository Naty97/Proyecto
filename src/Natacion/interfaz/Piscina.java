/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Natacion.interfaz;

import Natacion.Competencia;
import Natacion.Competidor;
import Natacion.Estadistica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Usuario
 */
public class Piscina extends javax.swing.JFrame {

    int tiempo = 0;
    List<JLabel> nadadores = new ArrayList();
    private Competencia competencia;
    private List<Competidor> competidores;

    /**
     * Creates new form Piscina
     */
    public Piscina() {
        initComponents();
        agregarNadadores();
        piscina.setFocusable(true);
        setTitle("Competencias de Natación");
        System.out.println(nadador1.getWidth());
        System.out.println(piscina.getWidth());
        this.getContentPane().setBackground(Color.cyan);
        piscina.setBackground(Color.CYAN);
        carril1.setBackground(Color.BLACK);
        carril1.setOpaque(true);
        carril2.setBackground(Color.BLACK);
        carril2.setOpaque(true);
        carril3.setBackground(Color.BLACK);
        carril3.setOpaque(true);
        carril5.setBackground(Color.BLACK);
        carril5.setOpaque(true);
//        carril1.setBackground(Color.BLACK); 
    }

    public Piscina(Competencia competencia) {
        initComponents();
        this.competencia = competencia;
        this.competidores = competencia.getCompetidores();
        agregarNadadores();
        piscina.setFocusable(true);
        setTitle("Competencias de Natación");
        System.out.println(nadador1.getWidth());
        System.out.println(piscina.getWidth());
        this.getContentPane().setBackground(Color.cyan);
        piscina.setBackground(Color.CYAN);
        carril1.setBackground(Color.BLACK);
        carril1.setOpaque(true);
        carril2.setBackground(Color.BLACK);
        carril2.setOpaque(true);
        carril3.setBackground(Color.BLACK);
        carril3.setOpaque(true);
        carril5.setBackground(Color.BLACK);
        carril5.setOpaque(true);
//        carril1.setBackground(Color.BLACK); 
    }

    private void agregarNadadores() {
        int posiciony = 10;
        for (Competidor item : competidores) {
            JLabel label = new JLabel();
            label.setSize(50, 50);
            label.setLocation(0, posiciony);
            label.setBackground(Color.RED);
            label.setOpaque(true);
            label.setText(item.getNombre());
            piscina.add(label);
            nadadores.add(label);
            posiciony = posiciony + 60;
        }
    }

    public int calcularFinal() {
        return piscina.getWidth() - 50;
    }
    
    private void iniciarJuego() {
        for (Competidor item : competidores) {
            item.generarMovimiento();
        }
        mover();
    }

    public void mover() {
        final int finalPiscina = calcularFinal();
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JLabel item : nadadores) {
                    if (item.getX() >= finalPiscina) {
                        finalJuego();
                        ((Timer) e.getSource()).stop();
                        return;
                    } else {
                        int indice = nadadores.indexOf(item);
                        item.setLocation(
                                item.getX() + competidores.get(indice).getMovimiento(),
                                item.getY());
                    }
                }
                tiempo++;
                refrescarTiempo();
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    public void finalJuego() {
        final int finalPiscina = calcularFinal();
        List<Integer> contGanadores = new ArrayList();
        for (JLabel item : nadadores) {
            if (item.getX() >= finalPiscina) {
                contGanadores.add(nadadores.indexOf(item));
            }
        }
        if (contGanadores.size() > 1) {
            System.out.println("Han habido varios ganadores");
            List<Competidor> ganadores = new ArrayList();
            for (Integer item : contGanadores) {
                ganadores.add(competidores.get(item));
            }
            String ganador = competencia.multiplesGanadores(ganadores);
            System.out.println(ganador);
            competencia.aumentarCantidadEmpates();
        } else {
            System.out.println("El ganador es " + nadadores.get(contGanadores.get(0)).getText());
            for (Estadistica item : competencia.getEstadisticas()) {
                if (item.getIdCompetidor() == competidores.get(contGanadores.get(0)).getId()) {
                    item.aumentarRecord();
                }
                else {
                    item.aumentarPerdidas();
                }
            }
        }
    }

    public void refrescarTiempo() {
        cronometro.setText(String.valueOf(tiempo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        piscina = new javax.swing.JPanel();
        nadador1 = new javax.swing.JLabel();
        cronometro = new javax.swing.JLabel();
        nadador2 = new javax.swing.JLabel();
        nadador3 = new javax.swing.JLabel();
        nadador4 = new javax.swing.JLabel();
        nadador5 = new javax.swing.JLabel();
        carril1 = new javax.swing.JLabel();
        carril2 = new javax.swing.JLabel();
        carril3 = new javax.swing.JLabel();
        carril4 = new javax.swing.JLabel();
        carril5 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        piscina.setMaximumSize(new java.awt.Dimension(100, 410));
        piscina.setName(""); // NOI18N
        piscina.setPreferredSize(new java.awt.Dimension(100, 410));
        piscina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                piscinaKeyPressed(evt);
            }
        });

        nadador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nadador1.png"))); // NOI18N
        nadador1.setAlignmentY(0.0F);

        cronometro.setText("  0");

        nadador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nadador2.png"))); // NOI18N

        nadador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nadador3.png"))); // NOI18N

        nadador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nadador4.png"))); // NOI18N

        nadador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nadador5.png"))); // NOI18N

        btnJugar.setText("Comenzar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout piscinaLayout = new javax.swing.GroupLayout(piscina);
        piscina.setLayout(piscinaLayout);
        piscinaLayout.setHorizontalGroup(
            piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carril1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(carril2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(carril4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(carril3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(piscinaLayout.createSequentialGroup()
                .addGroup(piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nadador5)
                    .addComponent(nadador4))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(piscinaLayout.createSequentialGroup()
                .addGroup(piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nadador2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nadador1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nadador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(carril5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(piscinaLayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(btnJugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        piscinaLayout.setVerticalGroup(
            piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piscinaLayout.createSequentialGroup()
                .addGroup(piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJugar))
                .addGap(8, 8, 8)
                .addComponent(nadador1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(carril1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nadador2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(carril2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(nadador3)
                .addGap(28, 28, 28)
                .addComponent(carril3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nadador4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(carril5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(carril4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nadador5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(piscina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(piscina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void piscinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_piscinaKeyPressed
        iniciarJuego();
    }//GEN-LAST:event_piscinaKeyPressed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed

    }//GEN-LAST:event_btnJugarActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Piscina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Piscina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Piscina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Piscina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Piscina piscina = new Piscina();
                piscina.setVisible(true);
//                 piscina.mover();
            }
        });
    }
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JLabel carril1;
    private javax.swing.JLabel carril2;
    private javax.swing.JLabel carril3;
    private javax.swing.JLabel carril4;
    private javax.swing.JLabel carril5;
    private javax.swing.JLabel cronometro;
    private javax.swing.JLabel nadador1;
    private javax.swing.JLabel nadador2;
    private javax.swing.JLabel nadador3;
    private javax.swing.JLabel nadador4;
    private javax.swing.JLabel nadador5;
    private javax.swing.JPanel piscina;
    // End of variables declaration//GEN-END:variables
}
