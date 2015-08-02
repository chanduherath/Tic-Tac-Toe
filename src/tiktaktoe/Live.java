/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktaktoe;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author JBHIFI
 */
public class Live extends TwoPlayer {

    

   
    int player1wins;
    int player2wins;
    int draws;
    String playername1 = null;
    String playername2 = null;
    
    
    public Live(String name1, String name2) {
        playerState = true;
        player1wins = 0;
        player2wins = 0;
        draws = 0;
       
         state = new int[9];
        if (name1.equals("")) {
            this.playername1 = "Player1";
        } else {
            this.playername1 = name1;
        }
        if (name2.equals("")) {
            this.playername2 = "Player2";
        } else {
            this.playername2 = name2;
        }
        for (int i = 0; i < state.length; i++) {
            state[i] = 2;
        }
        updateLables(playername1, playername2);
    }

    @Override
    public void mouseClicked(MouseEvent me) {


        int panelNum = Integer.parseInt(me.getComponent().getName()); 
        updateArray(panelNum);
        if (playerState) {
            updateWindow(panelNum, pic1);
        } else {
            updateWindow(panelNum, pic2);
        }

        boolean win = checkWinningMoment();
        boolean draw = checkdraw();
        if (win && playerState) {
            player1wins++;
        }
        else if(win && !playerState){
            player2wins++;
        }
        if (draw) {
            draws++;
        }
        showMessage(win, draw, playerState);
        if (win || draw) {
            lockScreen();        
            updateStats(player1wins, player2wins,draws);
            updateDatabase(player1wins, player2wins, draws, playername1, playername2);
        }
        playerState = !playerState;
    }

    void updateArray(int number) {
        if (state[number - 1] == 2) {
            if (this.playerState == true) {
                state[number - 1] = 0;
            } else {
                state[number - 1] = 1;
            }
        }
    }
    

    void showMessage(boolean foo, boolean draw, boolean playerstate) {
        if (foo) {
            if (playerState == true) {
                JOptionPane.showMessageDialog(this, playername1 + " Wins the Game");
            } else {
                JOptionPane.showMessageDialog(this, playername2 + " Wins the Game");
            }
        }
        if (draw) {
            JOptionPane.showMessageDialog(this, "The game drawn.");
        }
    }

    public boolean checkWinningMoment() {
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
    
    boolean checkdraw() {
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
}
