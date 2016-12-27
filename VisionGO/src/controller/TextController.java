/*
 * File Name: TextController.java
 * Project: VisionGO
 * Author: Chloe Choi
 * Start Date: 12/25/2016
 * End Date:
 * Description: This is the class that outputs the game in text format.
 */


/*
 *(\_/)
 *(o.o)!!! 안뇽
 *(___)0
 */
package controller;

import model.Board;
import model.InvalidMoveException;
import model.Stone;

import java.util.ArrayList;
import java.util.Scanner;

public class TextController {
    //player variable also works as numTurns
    private static int player = 1;
    private static ArrayList<Stone> movesMade = new ArrayList<Stone>();
    private static Board currentBoard = new Board();
    private static Board previousBoard;
    private static boolean resign = false;
    private static boolean skippedOnce = false;
    private static Scanner keyboard = new Scanner(System.in);

    public static void start() throws Exception {
        System.out.println("Welcome to VisionGO");

        play();
    }

    public static void play() {
        while (!resign) {
            System.out.println(currentBoard.getBoard());
            if (player % 2 != 0) {
                System.out.println("Black's Turn:");
            } else {
                System.out.println("White's Turn:");
            }
            System.out.println("What would you like to do?\n"
                    + "1. Place Stone\n"
                    + "2. Skip\n"
                    + "3. Resign\n");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            switch (response) {
                case 1:
                    place();
                    break;
                case 2:
                    if (skippedOnce) {
                        end(currentBoard.determineWinner());
                    } else {
                        skippedOnce = true;
                        player++;
                    }
                    break;
                case 3:
                    resign = true;
                    end(player++);
                    break;
                default:
                    break;
            }
        }
    }

    public static void place() {
        previousBoard = currentBoard;
        System.out.println("Where do you want to place your stone?\n"
                + "Row: ");
        int row = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Column: ");
        int col = keyboard.nextInt();
        keyboard.nextLine();
        try {
            currentBoard.makeMove(row, col);
            skippedOnce = false;
            player++;
        } catch (InvalidMoveException e) {
            place();
        }
    }

    public static void end(int winner) {
        String color;
        if (winner % 2 == 0) {
            color = "White";
        } else {
            color = "Black";
        }
        System.out.println(color + " wins\nScore: " + currentBoard.calculateScore());
    }
}
