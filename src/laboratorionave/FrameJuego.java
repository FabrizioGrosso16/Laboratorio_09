/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laboratorionave;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author User001
 */
public class FrameJuego extends javax.swing.JFrame {

    private int balaX, balaY;
    private boolean balaEnMovimiento = false;
    private Timer timer;
    private ArrayList<Enemigo> enemigos = new ArrayList<>();
    private Timer enemigoTimer;
    private Random random;
     private int tankeX = 140;
    private int tankeY = 210;
    


  public FrameJuego() {
    initComponents();
    random = new Random();
    enemigoTimer = new Timer(2000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int enemigoWidth = Enemigo.getPreferredSize().width;
        int x = random.nextInt(jPanel1.getWidth() - enemigoWidth); 
        int velocidad = 2; 
        Enemigo enemigo = new Enemigo(x, 0, velocidad);
        enemigos.add(enemigo);
        jPanel1.add(enemigo); 
        jPanel1.revalidate();
    }
});
enemigoTimer.setRepeats(true);
enemigoTimer.start();

    Timer gameTimer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moverEnemigos();
        }
    });
    gameTimer.start();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tanke = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Enemigo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(500, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 300));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tanke.setBackground(new java.awt.Color(102, 102, 102));
        tanke.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        tanke.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 14, -1, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        tanke.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        jPanel1.add(tanke, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 110, -1));

        Enemigo.setBackground(new java.awt.Color(0, 0, 0));
        Enemigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnemigoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout EnemigoLayout = new javax.swing.GroupLayout(Enemigo);
        Enemigo.setLayout(EnemigoLayout);
        EnemigoLayout.setHorizontalGroup(
            EnemigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        EnemigoLayout.setVerticalGroup(
            EnemigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(Enemigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        
    }//GEN-LAST:event_jPanel1KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      int movimiento = 5;

        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            int newX = tanke.getX() - movimiento;
            if (newX >= 0) {
                tanke.setBounds(newX, tanke.getY(), tanke.getWidth(), tanke.getHeight());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            int newX = tanke.getX() + movimiento;
            int frameWidth = getWidth();
            if (newX + tanke.getWidth() <= frameWidth) {
                tanke.setBounds(newX, tanke.getY(), tanke.getWidth(), tanke.getHeight());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            int newY = tanke.getY() - movimiento;
            if (newY >= 0) {
                tanke.setBounds(tanke.getX(), newY, tanke.getWidth(), tanke.getHeight());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int newY = tanke.getY() + movimiento;
            int frameHeight = getHeight();
            if (newY + tanke.getHeight() <= frameHeight) {
                tanke.setBounds(tanke.getX(), newY, tanke.getWidth(), tanke.getHeight());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            balaEnMovimiento = true;
            balaX = tanke.getX() + (tanke.getWidth() / 2) - (Enemigo.getWidth() / 2);
            balaY = tanke.getY() - Enemigo.getHeight();
            Enemigo.setBounds(balaX, balaY, Enemigo.getWidth(), Enemigo.getHeight());
            Enemigo.setVisible(true);

            if (timer == null) {
                timer = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (balaEnMovimiento) {
                            balaY -= movimiento;
                            Enemigo.setBounds(balaX, balaY, Enemigo.getWidth(), Enemigo.getHeight());
                            if (balaY < 0) {
                                balaEnMovimiento = false;
                                Enemigo.setVisible(false);
                            }
                        }
                    }
                });
                timer.start();
            }
        } 
    }//GEN-LAST:event_formKeyPressed

    private void EnemigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnemigoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnemigoKeyPressed
  private void moverEnemigos() {
    for (Enemigo enemigo : enemigos) {
        enemigo.mover();
        if (enemigo.verificaColision(tankeX, tankeY, tanke.getWidth(), tanke.getHeight())) {
            finalizarJuego();
        }
    }
}

private void finalizarJuego() {
    enemigoTimer.stop();
    JOptionPane.showMessageDialog(this, "Juego Terminado");System.exit(0);
}

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
            java.util.logging.Logger.getLogger(FrameJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Enemigo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel tanke;
    // End of variables declaration//GEN-END:variables
}
