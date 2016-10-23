package Takistusjooks.MainGame;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Maie on 15/10/2016.
 */
public class Konsoolil {
    // private - ainult sellest klassist saadav
    // static - always accessible (even without class)
    // final - see muutuja enam ei muutu
    private static final int HEIGHT = 2;        // mängulaua kõrgus
    private static final int WIDTH = 8;         // mängulaua laius
    private static final int PLAYERPOSITION = 1;    // kus asub mänguväljal mängija

    private static int[][] lvl = new int[HEIGHT][WIDTH]; // miks siin pole final? sest massiiv?
    private static int playerHeight = 1; // Pole final, sest mängu jooksul muutub

    // 0 - taust
    // 1 - takistus
    // 2 - mängija

    public static void main(String[] args) throws InterruptedException {           // Reaalse mängu n-ö Master-meetod
        while(true) {                                  // tekitab lõputu tsükli
            gameMove();                                // reaalsed liigutused mängus
            Thread.sleep(1000);
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
                    lvl[1][i - 1] = 1;        // muul juhul (ehk i ei ole null) mine ühe võrra ettepoole - selle väärtus on nüüd 1
                }
                lvl[1][i] = 0;                // eelmine väärtus on nüüd 0 ehk väärtus 1 liigub vasakult paremale
                return;  // not break - exit the method and into printGrid()
            }
        }
        lvl[1][WIDTH-1] = 1;                  // alustab otsast, ehk määrab rea viimaseks numbriks 1
    }

    private static boolean isPlayaDed() {       // kontrollib, kas mängija on surnud
        if(lvl[1][PLAYERPOSITION] == 1 && playerHeight == 1) {  // kui SAMAAEGSELT on mängija asukoht võrdne 1-ga (gameMove)
            return true;                                        // ja kõrgus on samuti 1 (ehk esimene rida), siis surnud
        }        else {
            return false;
        }
    }

    private static void printGrid() {           // Joonistab maatriksi konsoolile
        for (int i = 0; i < HEIGHT; i++) {      // i-d tuleb siis joonistada, kuni see on kõrguse suurune
            for (int j = 0; j < WIDTH; j++) {   // j-i tuleb joonistada, kuni see on vastavalt lai
                if(j == PLAYERPOSITION && i == playerHeight) {  // kui koordinaadid vastvad mängija asukohale, trükkida 2
                    System.out.print("2");
                } else {                         // muul juhul tavaline maatriks
                    System.out.print(lvl[i][j]);
                }
            }
            System.out.println(""); // trükib read eraldi ridadele (erinevad i väärtused)
        }
        System.out.println(""); // trükib erinevate laudade vahele tühimiku, et oleks kergem lugeda
    }
}
