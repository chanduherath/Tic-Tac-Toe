/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktaktoe;

import JDBC.DBConnection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author JBHIFI
 */
public class GUI extends javax.swing.JPanel implements MouseListener {

    /**
     * Creates new form Easy
     */
    public static int mode;
    DBConnection dbcon;
    int[] state = new int[9];
    boolean playerState = true;
    String playername;
    ImageIcon pic1 = new ImageIcon(getClass().getResource("/Img/playerImg1.jpg"));
    ImageIcon pic2 = new ImageIcon(getClass().getResource("/Img/playerImg2.jpg"));
    ArrayList<Integer> list;
    int numofwins; // variables to store loses and wins
    int numofloses;
    int numofdraws;

    public GUI() {
        initComponents();
        dbcon = new DBConnection();
        jLabel1.addMouseListener(this);
        jLabel2.addMouseListener(this);
        jLabel3.addMouseListener(this);
        jLabel4.addMouseListener(this);
        jLabel5.addMouseListener(this);
        jLabel6.addMouseListener(this);
        jLabel7.addMouseListener(this);
        jLabel8.addMouseListener(this);
        jLabel9.addMouseListener(this);
        for (int i = 0; i < state.length; i++) {
            state[i] = 2;
        }
        lblwin.setText(Integer.toString(0));
        lbllose.setText(Integer.toString(0));
        lbldraw.setText(Integer.toString(0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblwin = new javax.swing.JLabel();
        lbllose = new javax.swing.JLabel();
        lbldraw = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblmode = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        btnStats = new javax.swing.JButton();
        btnNewGame = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(650, 450));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setText("Wins");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setText("Loses");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel12.setText("Draws");

        lblwin.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblwin.setText("0");

        lbllose.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbllose.setText("0");

        lbldraw.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbldraw.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblwin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbllose, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbldraw, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblwin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbllose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbldraw, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 490, 60));

        jPanel12.setOpaque(false);
        jPanel12.setLayout(null);

        lblmode.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblmode.setText("Mode");
        jPanel12.add(lblmode);
        lblmode.setBounds(19, 12, 150, 41);

        lblname.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblname.setText("Tic Tac Toe");
        jPanel12.add(lblname);
        lblname.setBounds(19, 71, 100, 41);

        btnStats.setBackground(new java.awt.Color(204, 204, 255));
        btnStats.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnStats.setText("Stats");
        btnStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatsActionPerformed(evt);
            }
        });
        jPanel12.add(btnStats);
        btnStats.setBounds(19, 146, 117, 48);

        btnNewGame.setBackground(new java.awt.Color(153, 255, 153));
        btnNewGame.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnNewGame.setText("New Game");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });
        jPanel12.add(btnNewGame);
        btnNewGame.setBounds(19, 253, 117, 48);

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 190, 340));

        jPanel11.setBackground(new java.awt.Color(0, 51, 51));
        jPanel11.setOpaque(false);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setName("1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(104, 104));

        jLabel1.setName("1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 11, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setName("3"); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(104, 104));

        jLabel3.setName("3"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 11, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel9.setName("9"); // NOI18N

        jLabel9.setName("9"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 229, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setName("2"); // NOI18N

        jLabel2.setName("2"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 11, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel8.setName("8"); // NOI18N

        jLabel8.setName("8"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 229, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setName("7"); // NOI18N

        jLabel7.setName("7"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 229, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setName("4"); // NOI18N

        jLabel4.setName("4"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 122, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setName("6"); // NOI18N

        jLabel6.setName("6"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 122, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setName("5"); // NOI18N

        jLabel5.setName("5"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 122, -1, -1));

        add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 350, 340));

        jButton1.setBackground(new java.awt.Color(0, 204, 102));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 110, 37));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back3.png"))); // NOI18N
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatsActionPerformed
        // TODO add your handling code here:
        Vector<Vector<String>> twod = viewDatabase();       
        SingleStats h1 = new SingleStats(twod);
        h1.setVisible(true);
    }//GEN-LAST:event_btnStatsActionPerformed

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        // TODO add your handling code here:
        reset();//reset the screen when starting a new game
        activateScreen();
        list = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }


    }//GEN-LAST:event_btnNewGameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame)SwingUtilities.getRoot(this);
        frame.dispose();
        MainMenu.frm1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnStats;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbldraw;
    private javax.swing.JLabel lbllose;
    private javax.swing.JLabel lblmode;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblwin;
    // End of variables declaration//GEN-END:variables

    void updateArray(int number) {
        if (state[number - 1] == 2) {
            if (this.playerState == true) {
                state[number - 1] = 0;
            } else {
                state[number - 1] = 1;
            }
        }
    }

    public void updateWindow(int number, ImageIcon pic1) {//set to appear image on lables
        switch (number) {
            case 1:
                jLabel1.setIcon(pic1);
                jLabel1.setHorizontalAlignment(jLabel1.CENTER);
                jLabel1.setVerticalAlignment(jLabel1.CENTER);
                jLabel1.removeMouseListener(this);
                break;
            case 2:
                jLabel2.setIcon(pic1);
                jLabel2.setHorizontalAlignment(jLabel1.CENTER);
                jLabel2.setVerticalAlignment(jLabel1.CENTER);
                jLabel2.removeMouseListener(this);
                break;
            case 3:
                jLabel3.setIcon(pic1);
                jLabel3.setHorizontalAlignment(jLabel1.CENTER);
                jLabel3.setVerticalAlignment(jLabel1.CENTER);
                jLabel3.removeMouseListener(this);
                break;
            case 4:
                jLabel4.setIcon(pic1);
                jLabel4.setHorizontalAlignment(jLabel1.CENTER);
                jLabel4.setVerticalAlignment(jLabel1.CENTER);
                jLabel4.removeMouseListener(this);
                break;
            case 5:
                jLabel5.setIcon(pic1);
                jLabel5.setHorizontalAlignment(jLabel1.CENTER);
                jLabel5.setVerticalAlignment(jLabel1.CENTER);
                jLabel5.removeMouseListener(this);
                break;
            case 6:
                jLabel6.setIcon(pic1);
                jLabel6.setHorizontalAlignment(jLabel1.CENTER);
                jLabel6.setVerticalAlignment(jLabel1.CENTER);
                jLabel6.removeMouseListener(this);
                break;
            case 7:
                jLabel7.setIcon(pic1);
                jLabel7.setHorizontalAlignment(jLabel1.CENTER);
                jLabel7.setVerticalAlignment(jLabel1.CENTER);
                jLabel7.removeMouseListener(this);
                break;
            case 8:
                jLabel8.setIcon(pic1);
                jLabel8.setHorizontalAlignment(jLabel1.CENTER);
                jLabel8.setVerticalAlignment(jLabel1.CENTER);
                jLabel8.removeMouseListener(this);
                break;
            case 9:
                jLabel9.setIcon(pic1);
                jLabel9.setHorizontalAlignment(jLabel1.CENTER);
                jLabel9.setVerticalAlignment(jLabel1.CENTER);
                jLabel9.removeMouseListener(this);
        }
    }

    public boolean checkWinningMoment() {//check whether the is a winning moment
        if (state[0] == state[1] && state[1] == state[2] && state[1] != 2) {
            return true;
        } else if (state[0] == state[3] && state[3] == state[6] && state[3] != 2) {
            return true;
        } else if (state[0] == state[4] && state[4] == state[8] && state[4] != 2) {
            return true;
        } else if (state[1] == state[4] && state[4] == state[7] && state[4] != 2) {
            return true;
        } else if (state[2] == state[5] && state[5] == state[8] && state[5] != 2) {
            return true;
        } else if (state[2] == state[4] && state[4] == state[6] && state[4] != 2) {
            return true;
        } else if (state[3] == state[4] && state[4] == state[5] && state[4] != 2) {
            return true;
        } else if (state[6] == state[7] && state[7] == state[8] && state[7] != 2) {
            return true;
        }
        return false;
    }

    boolean checkdraw() {//check whether there is a draw moment
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 2) {
                return false;
            }
        }
        if (checkWinningMoment()) {
            return false;
        }
        return true;
    }

    void showMessage(boolean foo, boolean draw, boolean playerstate) {//showing relevent message
        if (foo) {
            if (playerState == true) {
                JOptionPane.showMessageDialog(this, "You Win the Game");
            } else {
                JOptionPane.showMessageDialog(this, "You lost the Game");
            }
        }
        if (draw) {
            JOptionPane.showMessageDialog(this, "The game drawn.");
        }
    }
    
    void updateLables(String name){
        if(mode==0){
            lblmode.setText("Easy Mode");
        }else if(mode==1){
            lblmode.setText("Hard Mode");
        }
        lblname.setText(name);
    }

    void reset() {//reset the game window to begining
        jLabel1.setIcon(null);
        jLabel2.setIcon(null);
        jLabel3.setIcon(null);
        jLabel4.setIcon(null);
        jLabel5.setIcon(null);
        jLabel6.setIcon(null);
        jLabel7.setIcon(null);
        jLabel8.setIcon(null);
        jLabel9.setIcon(null);
        for (int i = 0; i < state.length; i++) {
            state[i] = 2;
        }
        this.playerState = true;
    }

    void lockScreen() {//lock the screen when it should not be allowed to click
        jLabel1.removeMouseListener(this);
        jLabel2.removeMouseListener(this);
        jLabel3.removeMouseListener(this);
        jLabel4.removeMouseListener(this);
        jLabel5.removeMouseListener(this);
        jLabel6.removeMouseListener(this);
        jLabel7.removeMouseListener(this);
        jLabel8.removeMouseListener(this);
        jLabel9.removeMouseListener(this);

    }

    void activateScreen() {
        jLabel1.addMouseListener(this);
        jLabel2.addMouseListener(this);
        jLabel3.addMouseListener(this);
        jLabel4.addMouseListener(this);
        jLabel5.addMouseListener(this);
        jLabel6.addMouseListener(this);
        jLabel7.addMouseListener(this);
        jLabel8.addMouseListener(this);
        jLabel9.addMouseListener(this);

    }

    void updateStats(int wins, int loses, int draws, String name) {
        lblwin.setText(Integer.toString(wins));
        lbllose.setText(Integer.toString(loses));
        lbldraw.setText(Integer.toString(draws));
        updateDatabase(wins, loses, draws, name);
    }

    void updateDatabase(int wins, int loses, int draws, String player) {//writing data into database
        String sql = "";
        if (mode == 0) {
            sql = "UPDATE easymode SET wins = '" + wins + "' ,loses = '" + loses + "' ,draws = '" + draws + "' WHERE name = '" + player + "' ORDER BY easymode.id DESC LIMIT 1";
            dbcon.putData(sql);
        } else if (mode == 1) {
            sql = "UPDATE hardmode SET wins = '" + wins + "' ,loses = '" + loses + "' ,draws = '" + draws + "' WHERE name = '" + player + "' ORDER BY hardmode.id DESC LIMIT 1";
            dbcon.putData(sql);
        }
    }

    Vector<Vector<String>> viewDatabase() {//veiwing the database
        Vector<Vector<String>> twod = new Vector<Vector<String>>();
        try {
            String sql  = "";
            if (GUI.mode == 0) {
                sql = "SELECT * from tictaktoe.easymode ";
            } else if (GUI.mode == 1) {
                sql = "SELECT * from tictaktoe.hardmode ";
            }
            ResultSet rset = dbcon.getData(sql);
            while (rset.next()) {
                Vector<String> row = new Vector<String>();
                int w = rset.getInt("wins");
                row.add(Integer.toString(w));
                int l = rset.getInt("loses");
                row.add(Integer.toString(l));
                int d = rset.getInt("draws");
                row.add(Integer.toString(d));
                String n = rset.getString("name");
                row.add(n);
                twod.add(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);

        }
        return twod;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
