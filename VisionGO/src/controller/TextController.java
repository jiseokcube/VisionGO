/*
 * File Name: TextController.java
 * Project: VisionGO
 * Author: Chloe Choi
 * Start Date: 12/25/2016
 * End Date:
 * Description: This is the class that outputs the game in text format.
 */

package controller;

import model.Board;
import model.Stone;

import java.util.ArrayList;

public class TextController {
    private String player = "Black";
    private int numTurns = 1;
    private ArrayList<Stone> movesMade = new ArrayList<Stone>();
    private int capturedByWhite = 0;
    private int capturedByBlack = 0;
    private boolean skippedOnce = false;
    private Board currentBoard = new Board();
    private Board previousBoard;
    private boolean resign = false;

    public void start() throws Exception {
        System.out.println("Welcome to VisionGO");
        System.out.println(currentBoard.getBoard());
        play();
    }

    public void play() {

        while (!resign) {
           /*
            (\_/)
            (o.o)!! 안뇽
            (___)0
            */
        }
    }
}
