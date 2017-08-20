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
    private boolean juegoIniciado;

    private Competencia competencia = new Competencia();
    private List<Competidor> competidores;
    private List<Estadistica> estadisticas;

    /**
     * Creates new form Piscina
     */
    public Piscina() {
        initComponents();
        agregarNadadores();
        piscina.setFocusable(true);
        setTitle("Competencias de Natación");
        System.out.println(piscina.getWidth());
        this.getContentPane().setBackground(Color.cyan);
        piscina.setBackground(Color.CYAN);
        /*carril1.setBackground(Color.BLACK);
        carril1.setOpaque(true);
        carril2.setBackground(Color.BLACK);
        carril2.setOpaque(true);
        carril3.setBackground(Color.BLACK);
        carril3.setOpaque(true);
        carril5.setBackground(Color.BLACK);
        carril5.setOpaque(true);*/
//        carril1.setBackground(Color.BLACK); 
    }

    public Piscina(Competencia competencia) {
        initComponents();
        this.competencia = competencia;
        this.competidores = competencia.getCompetidores();
        this.juegoIniciado = false;
        agregarNadadores();
        agregarCarriles();
        this.btnReiniciar.setEnabled(false);
        //agregarEstadisticas();
        piscina.setFocusable(true);
        setTitle("Competencias de Natación");
        System.out.println(piscina.getWidth());
        this.getContentPane().setBackground(Color.cyan);
        piscina.setBackground(Color.CYAN);
        /*carril1.setBackground(Color.BLACK);
        carril1.setOpaque(true);
        carril2.setBackground(Color.BLACK);
        carril2.setOpaque(true);
        carril3.setBackground(Color.BLACK);
        carril3.setOpaque(true);
        carril5.setBackground(Color.BLACK);
        carril5.setOpaque(true);*/
//        carril1.setBackground(Color.BLACK); 
    }

    private void agregarCarriles() {
        int posiciony = 110;
        JLabel carril;
        for (int i = 0; i < 5; i++) {
            carril = new JLabel();
            carril.setSize(piscina.getWidth(), 10);
            carril.setOpaque(true);
            carril.setBackground(Color.RED);
            carril.setLocation(0, posiciony);
            piscina.add(carril);
            posiciony = posiciony + 80;
        }
    }

    private void agregarNadadores() {
        int indice = 1;
        JLabel competidor;
        JLabel nombre;
        int posiciony = 50;
        for (Competidor item : competidores) {
            competidor = new JLabel();
            competidor.setSize(50, 50);
            competidor.setLocation(75, posiciony);
            competidor.setIcon(
                    new javax.swing.ImageIcon(
                            getClass().getResource(String.format("/Iconos/nadador%d.png", indice))));
            competidor.setOpaque(true);
            competidor.setText(item.getNombre());
            piscina.add(competidor);
            nadadores.add(competidor);
            nombre = new JLabel();
            nombre.setSize(50, 50);
            nombre.setLocation(10, posiciony);
            nombre.setOpaque(true);
            nombre.setBackground(Color.WHITE);
            nombre.setText(item.getNombre());
            piscina.add(nombre);
            posiciony = posiciony + 80;
            indice++;
        }
    }

    public void agregarEstadisticas() {
        Estadistica estadistica;
        for (Competidor item : competidores) {
            estadistica = new Estadistica(item.getId());
            estadisticas.add(estadistica);
        }
    }

    public int calcularFinal() {
        return piscina.getWidth() - 50;
    }

    private void iniciarJuego() {
        this.btnJugar.setEnabled(false);
        if (!this.juegoIniciado) {
            this.juegoIniciado = true;
            for (Competidor item : competidores) {
                item.generarMovimiento();
            }
            mover();
        }
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

    private void registrarTiempo() {
        this.competencia.registrarTiempo(tiempo);
    }
    
    private void reiniciarJuego() {
        int posiciony = 50;
        for (JLabel item : nadadores) {
            item.setLocation(75, posiciony);
            posiciony = posiciony + 80;
        }
        this.btnJugar.setEnabled(true);
        this.btnReiniciar.setEnabled(false);
        tiempo = 0;
        refrescarTiempo();
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
                } else {
                    item.aumentarPerdidas();
                }

            }
        }
        System.out.println(String.format("Tiempo de la carrera : %d", tiempo));
        registrarTiempo();
        this.juegoIniciado = false;
        this.btnReiniciar.setEnabled(true);
        System.out.println(String.format("Cantidad de empates : %d", competencia.getCantidadEmpates()));
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
        cronometro = new javax.swing.JLabel();
        carril4 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        piscina.setMaximumSize(new java.awt.Dimension(100, 410));
        piscina.setName(""); // NOI18N
        piscina.setPreferredSize(new java.awt.Dimension(100, 410));
        piscina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                piscinaKeyPressed(evt);
            }
        });

        cronometro.setText("  0");

        btnJugar.setText("Comenzar");
        btnJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJugarMouseClicked(evt);
            }
        });
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReiniciarMouseClicked(evt);
            }
        });
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout piscinaLayout = new javax.swing.GroupLayout(piscina);
        piscina.setLayout(piscinaLayout);
        piscinaLayout.setHorizontalGroup(
            piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carril4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(piscinaLayout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(btnReiniciar)
                .addGap(33, 33, 33)
                .addComponent(btnJugar)
                .addGap(122, 122, 122)
                .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        piscinaLayout.setVerticalGroup(
            piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(piscinaLayout.createSequentialGroup()
                .addGroup(piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(piscinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnJugar)
                        .addComponent(btnReiniciar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(carril4)
                .addGap(62, 62, 62))
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

    }//GEN-LAST:event_piscinaKeyPressed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed

    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugarMouseClicked
        iniciarJuego();
    }//GEN-LAST:event_btnJugarMouseClicked

    private void btnReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReiniciarMouseClicked
        reiniciarJuego();
    }//GEN-LAST:event_btnReiniciarMouseClicked

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReiniciarActionPerformed

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
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JLabel carril4;
    private javax.swing.JLabel cronometro;
    private javax.swing.JPanel piscina;
    // End of variables declaration//GEN-END:variables
}
