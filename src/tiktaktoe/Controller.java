/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktaktoe;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controller extends GUI {

    //gameXO is the game  
    static String[] gameXO = new String[9];
    //_sdepth is used to control the depth  
    static int sdepth;

    public Controller(String name) {//reInitialise the gameXO when i create a new controller  
        numofwins = 0;
        numofloses = 0;
        numofdraws = 0;
        GUI.mode = 1;
        for (int i = 0; i < 9; i++) {
            gameXO[i] = " ";
        }
        if (name.equals("")) {
            this.playername = "Player1";
        } else {
            this.playername = name;
        }
        updateLables(playername);
    }
//inverse: this method is used to toggle between level (Min and Max)

    public String inverse(String level) { //inverse level from MIN to MAX  
        return (level.equals("MIN")) ? "MAX" : "MIN";
    }

//getScore: this method calculates the score.
//-If player O (computer) wins, the score is +1,
//-If player X (player) wins, the score is -1,
//-If game draw, the score is 0.
    public int getScore(String[] demo) { //return the score:  
        //if X win return -1;  
        //if O win return 1;  
        //else return 0, this mean draw  
        if ((demo[0].equalsIgnoreCase("x") && demo[1].equalsIgnoreCase("x") && demo[2].equalsIgnoreCase("x")) || (demo[3].equalsIgnoreCase("x") && demo[4].equalsIgnoreCase("x") && demo[5].equalsIgnoreCase("x"))
                || (demo[6].equalsIgnoreCase("x") && demo[7].equalsIgnoreCase("x") && demo[8].equalsIgnoreCase("x")) || (demo[0].equalsIgnoreCase("x") && demo[3].equalsIgnoreCase("x") && demo[6].equalsIgnoreCase("x"))
                || (demo[1].equalsIgnoreCase("x") && demo[4].equalsIgnoreCase("x") && demo[7].equalsIgnoreCase("x")) || (demo[2].equalsIgnoreCase("x") && demo[5].equalsIgnoreCase("x") && demo[8].equalsIgnoreCase("x"))
                || (demo[0].equalsIgnoreCase("x") && demo[4].equalsIgnoreCase("x") && demo[8].equalsIgnoreCase("x")) || (demo[2].equalsIgnoreCase("x") && demo[4].equalsIgnoreCase("x") && demo[6].equalsIgnoreCase("x"))) {
            return -1;
        }
        if ((demo[0].equalsIgnoreCase("o") && demo[1].equalsIgnoreCase("o") && demo[2].equalsIgnoreCase("o")) || (demo[3].equalsIgnoreCase("o") && demo[4].equalsIgnoreCase("o") && demo[5].equalsIgnoreCase("o"))
                || (demo[6].equalsIgnoreCase("o") && demo[7].equalsIgnoreCase("o") && demo[8].equalsIgnoreCase("o")) || (demo[0].equalsIgnoreCase("o") && demo[3].equalsIgnoreCase("o") && demo[6].equalsIgnoreCase("o"))
                || (demo[1].equalsIgnoreCase("o") && demo[4].equalsIgnoreCase("o") && demo[7].equalsIgnoreCase("o")) || (demo[2].equalsIgnoreCase("o") && demo[5].equalsIgnoreCase("o") && demo[8].equalsIgnoreCase("o"))
                || (demo[0].equalsIgnoreCase("o") && demo[4].equalsIgnoreCase("o") && demo[8].equalsIgnoreCase("o")) || (demo[2].equalsIgnoreCase("o") && demo[4].equalsIgnoreCase("o") && demo[6].equalsIgnoreCase("o"))) {
            return 1;
        }
        return 0;
    }

    //gameDraw: this method is used to check if the game is draw
    public boolean drawGame(String[] demo) {
        //test if the game is draw.  
        //if demo is full, this mean that game is draw  
        //if demo still has empty square, this mean that the game isn't finished  
        for (int i = 0; i < 9; i++) {
            if (demo[i].equals(" ")) {
                return false;
            }
        }
        return true;
    }

    //gameOver: this method is used to check if there is a winner
    public boolean gameOver(String[] demo) {//if the score of the game is 0 then return false else we have a winner  
        return (getScore(demo) != 0) ? true : false;
    }

    //genere_succ: this method is used to generate successors.
    public ArrayList<String[]> genere_succ(String[] demo, String level) {//generate successor  
        //if level is MAX, generate successor with o (o in lowercase)  
        //if level is MIN, generate successor with x (x in lowercase)
        //if demo has no successor, return null  
        ArrayList<String[]> succ = new ArrayList<String[]>();
        for (int i = 0; i < demo.length; i++) {
            if (demo[i].equals(" ")) {
                String[] child = new String[9];
                for (int j = 0; j < 9; j++) {
                    child[j] = demo[j];
                }
                if (level.equals("MAX")) {
                    child[i] = "o";
                } else {
                    child[i] = "x";
                }
                succ.add(child);
            }
        }
        return (succ.size() == 0) ? null : succ;
    }

    //getResult: this method is used to choose the appropriate score. 
    //This mean if the level is Max we have to choose the highest score, 
    //but if level is Min we choose the lowest score.
    public ResultMM getResult(ArrayList<ResultMM> listScore, String level) {//this method is used to get the appropriate score  
        //if level is MAX, i search for the higher score in the nearer depth  
        //if level is MIN, i search for the lowest score in the nearer depth  
        ResultMM result = listScore.get(0);
        if (level.equals("MAX")) {
            for (int i = 1; i < listScore.size(); i++) {
                if ((listScore.get(i).getScore() > result.getScore())
                        || (listScore.get(i).getScore() == result.getScore() && listScore.get(i).depth < result.depth)) {
                    result = listScore.get(i);
                }
            }
        } else {
            for (int i = 1; i < listScore.size(); i++) {
                if ((listScore.get(i).getScore() < result.getScore())
                        || (listScore.get(i).getScore() == result.getScore() && listScore.get(i).depth < result.depth)) {
                    result = listScore.get(i);
                }
            }
        }
        return result;
    }

    //MinMax: this is the principal function that calls all the above methods.
    public ResultMM MinMax(String[] demo, String level, int fils, int depth) {/*MinMax algorithm  
         * 1- generate successor  
         * 2- if no successor or game is finished return score   
         * 3- if there is successor  
         *      a) apply MinMax for each successor  
         *     b) after recursive call, i return the good score  
         */

        //1---------------  

        ArrayList<String[]> children = genere_succ(demo, level);
        //2------------------    
        if (children == null || gameOver(demo)) {
            return new ResultMM(demo, getScore(demo), depth);
        } else {//3------------------   
            ArrayList<ResultMM> listScore = new ArrayList<ResultMM>();
            //pass into each child  
            for (int i = 0; i < children.size(); i++) {//3 a)---------------  
                listScore.add(MinMax(children.get(i), inverse(level), 1, depth + 1));
            }
            //3 b)----------------  
            ResultMM res = getResult(listScore, level);
            if (fils == 1) {
                res.updateMatrix(demo);
            }
            return res;
        }
    }

    //MakeMove: the method that calls the MiniMax method.
    public int makeMove(int index) {     /*Step to do in this method  
         *1- update gameXO. put X in the gameXO[index]  
         *2- test if game is finished (draw or X win)  
         *3- call MinMax algorithm and return the score and return the best position for O  
         *4- update gameXO. put O in its position  
         *5- test if game is finished (draw or O win)  
         */
        //return -1 to know that player X wins  
        //return -2 to know that the game is draw  
        //1  

        gameXO[index] = "X";
        updateWindow(index + 1, pic1);
        //2  
        if (gameOver(gameXO)) {
            return -1;
        }
        if (drawGame(gameXO)) {
            return -2;
        }
        //3  
        ResultMM res = MinMax(gameXO, "MAX", 0, 0);
        int i = res.getIntrus();
        //4  
        gameXO[i] = "O";
        updateWindow(i + 1, pic2);
        //5  
        // return i+20 to know that o wins (i used this method for programming issues)  
        // retrun i-30 to know that the game is draw (i used this method for programming issues)  
        if (gameOver(gameXO)) {
            return i + 20;
        }
        if (drawGame(gameXO)) {
            return i - 30;
        }
        return i;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int panelNum = Integer.parseInt(me.getComponent().getName());
        int result = makeMove(panelNum - 1);
        showMessage(result);
    }

    void showMessage(int result) {
        if (result == -1) {
            JOptionPane.showMessageDialog(this, "You Win the Game");
            numofwins++;
            lockScreen();
            resettoBegining();
        }
        if (result == -2 || result < 0) {
            JOptionPane.showMessageDialog(this, "Game Drawn");
            lockScreen();
            numofdraws++;
            resettoBegining();
        }
        if (result > 20) {
            JOptionPane.showMessageDialog(this, "You Lost the Game");
            lockScreen();
            numofloses++;
            resettoBegining();
        }
        if (result == -1 || result == -2 || result < 0 || result > 20) {
            updateStats(numofwins, numofloses, numofdraws, playername);
        }
    }

    void resettoBegining() {
        for (int i = 0; i < 9; i++) {
            gameXO[i] = " ";
        }
    }

}
