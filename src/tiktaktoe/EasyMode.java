/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktaktoe;

import JDBC.DBConnection;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author JBHIFI
 */
public class EasyMode extends GUI {


    DBConnection datacon;
    
    int numofwins;
    int numofloses;
    int numofdraws;

    public EasyMode(String name) {
        GUI.mode = 0;
        list = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        numofwins = 0;
        numofloses = 0;
        numofdraws = 0;
        datacon = new DBConnection();
        if (name.equals("")) {
            this.playername = "Player1";
        } else {
            this.playername = name;
        }
        updateLables(playername);

    }

    @Override
    public void mouseClicked(MouseEvent me) {

        int panelNum = Integer.parseInt(me.getComponent().getName());
        list.remove(list.indexOf(panelNum));
        updateArray(panelNum);
        updateWindow(panelNum, pic1);
        boolean win = checkWinningMoment();
        boolean draw = checkdraw();
        if (win) {
            numofwins++;
            updateDatabase(playername, numofwins, numofloses, numofdraws);
        }
        if (draw) {
            numofdraws++;
            updateDatabase(playername, numofwins, numofloses, numofdraws);
        }
        showMessage(win, draw, playerState);
        if (win || draw) {
            lockScreen();
            updateStats(numofwins, numofloses, numofdraws,playername);
        }
        playerState = false;

        if (!win && !draw) {
            panelNum = getRandomNumber();
            list.remove(list.indexOf(panelNum));
            updateArray(panelNum);
            updateWindow(panelNum, pic2);
            win = checkWinningMoment();
            draw = checkdraw();
            if (win) {
                numofloses++;
                updateDatabase(playername, numofwins, numofloses, numofdraws);
            }
            if (draw) {
                numofdraws++;
                updateDatabase(playername, numofwins, numofloses, numofdraws);
            }
            showMessage(win, draw, playerState);
            if (win || draw) {
                lockScreen();
                updateStats(numofwins, numofloses, numofdraws,playername);
            }
        }
        playerState = true;
    }

    int getRandomNumber() {
        Random r = new Random();
        int random = list.get(r.nextInt(list.size()));
        return random;
    }

    void updateDatabase(String playername, int win, int loss, int draw) {
        System.out.println("calling database here....................");
    }  
   
}
