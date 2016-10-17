package Takistusjooks.MainGame;

import java.util.Arrays;

/**
 * Created by Maie on 15/10/2016.
 */
public class Konsoolil {
    // private (ainult sellest klassist saadav
    // static - always accessible (even without class)
    // final - see muutuja enam ei muutu
    private static final int HEIGHT = 2;
    private static final int WIDTH = 8;
    private static final int PLAYERPOSITION = 1;

    private static int[][] lvl = new int[HEIGHT][WIDTH]; // miks siin pole final?
    private static int playerHeight = 1;

    // 0 - taust
    // 1 - takistus
    // 2 - mängija

    public static void main(String[] args) {           // Reaalse mängu n-ö Master-meetod
        while(true) {                                  // tekitab lõputu tsükli
            gameMove();                                // reaalsed liigutused mängus
            printGrid();                               // trükib mänguväljaku
            if(isPlayaDed()) {                         // kui isPlayaDed vastab tõele (== true), siis trükib sõnumi
                System.out.println("You be dead!");
                return;                                // kui isPlayaDed ei vasta tõele (== false), siis tsükkel kordub
            }
        }
    }

    private static void gameMove() {          //mängulaua meetod
        for (int i = 0; i < WIDTH; i++) {     // i on alguses 0. Kui i on väiksem kui mängu laius, siis lisa 1 juurde.
            if(lvl[1][i] == 1) {              // kui positsioonil 1;i on 1, siis:
                if(i == 0) {                  // kui i on seejuures 0, siis
                    lvl[1][WIDTH-1] = 1;      // mine tagantpoolt ühe võrra ettepoole
                } else {
                    lvl[1][i - 1] = 1;
                }
                lvl[1][i] = 0;
                return;  // not break - exit the method and into printGrid()
            }
        }
        lvl[1][WIDTH-1] = 1;
    }

    private static boolean isPlayaDed() {
        if(lvl[1][PLAYERPOSITION] == 1 && playerHeight == 1) {
            return true;
        }        else {
            return false;
        }
    }

    private static void printGrid() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if(j == PLAYERPOSITION && i == playerHeight) {
                    System.out.print("2");
                } else {
                    System.out.print(lvl[i][j]);
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
