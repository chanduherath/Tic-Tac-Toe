/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktaktoe;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author JBHIFI
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    static JFrame m;
    static FillForm frm1;
    static JFrame network;

    public MainMenu() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTwoPlayerMode = new javax.swing.JButton();
        btnNetworkMode = new javax.swing.JButton();
        btnEasyMode = new javax.swing.JButton();
        btnHardMode = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(650, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTwoPlayerMode.setBackground(new java.awt.Color(255, 102, 0));
        btnTwoPlayerMode.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnTwoPlayerMode.setText("Two Player Mode");
        btnTwoPlayerMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoPlayerModeActionPerformed(evt);
            }
        });
        getContentPane().add(btnTwoPlayerMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, 49));

        btnNetworkMode.setBackground(new java.awt.Color(204, 102, 0));
        btnNetworkMode.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnNetworkMode.setText("Play via Network");
        btnNetworkMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetworkModeActionPerformed(evt);
            }
        });
        getContentPane().add(btnNetworkMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 183, 48));

        btnEasyMode.setBackground(new java.awt.Color(153, 51, 0));
        btnEasyMode.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnEasyMode.setText("Easy");
        btnEasyMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEasyModeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEasyMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 183, 49));

        btnHardMode.setBackground(new java.awt.Color(204, 102, 0));
        btnHardMode.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnHardMode.setText("Hard");
        btnHardMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHardModeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHardMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 183, 46));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton1.setText("Quit Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, -1, 46));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTwoPlayerModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoPlayerModeActionPerformed
        // TODO add your handling code here:
        frm1 = new FillForm("TwoPlayerMode");
        frm1.setVisible(true);
        

    }//GEN-LAST:event_btnTwoPlayerModeActionPerformed

    private void btnNetworkModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetworkModeActionPerformed
        Game1 gamepanel = new Game1();       
        network = new JFrame();
//        network.setUndecorated(true);
        network.setContentPane(gamepanel);
        network.pack();
        network.setTitle("Tik Tak Toe");
        network.setVisible(true);
        network.setLocationRelativeTo(null);
        network.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_btnNetworkModeActionPerformed

    private void btnEasyModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEasyModeActionPerformed
        frm1 = new FillForm("easy");
        frm1.setVisible(true);
    }//GEN-LAST:event_btnEasyModeActionPerformed

    private void btnHardModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHardModeActionPerformed
        frm1 = new FillForm("hard");
        frm1.setVisible(true);
    }//GEN-LAST:event_btnHardModeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                m = new MainMenu();
                m.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEasyMode;
    private javax.swing.JButton btnHardMode;
    private javax.swing.JButton btnNetworkMode;
    private javax.swing.JButton btnTwoPlayerMode;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}