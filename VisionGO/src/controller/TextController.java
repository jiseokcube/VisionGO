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
import java.util.Scanner;

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
    private static Scanner keyboard = new Scanner(System.in);

    public void start() throws Exception {
        System.out.println("Welcome to VisionGO");
        System.out.println(currentBoard.getBoard());
        play();
    }

    public void play() {

        while (!resign) {
            System.out.println("What would you like to do?\n"
                    + "1. Place Stone\n"
                    + "2. Skip\n"
                    + "3. Resign\n");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            switch (response){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    resign = true;
                    end();
                    break;
                default:
                    break;
            }

           /*
            (\_/)
            (o.o)!! 안뇽
            (___)0
            */
        }
    }
    public void end(){

    }
}
