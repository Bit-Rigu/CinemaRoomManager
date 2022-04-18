package cinema;
import java.util.*;

import static cinema.Cinema.price;

public class cinemaHall {
     static int numRows;
     static int numSeats;
     private char[][] cinema;
     private boolean[][] freeSeats;
     private int numOfPurchTic = 0;
     private double perc = 0;
     private int curInc = 0;
     private int totInc = 0;

    public int getNumOfPurchTic() {
        return numOfPurchTic;
    }

    public double getPerc() {
        return perc;
    }

    public int getCurInc() {
        return curInc;
    }

    public int getTotInc() {
        return totInc;
    }

    public boolean getFreeSeats(int numRow,int numSeat) {
        return freeSeats[numRow - 1][numSeat - 1];
    }

    cinemaHall(int numRows, int numSeats) {
        this.numRows = numRows;
        this.numSeats = numSeats;
        cinema = new char[numRows][numSeats];
        freeSeats = new boolean[numRows][numSeats];
        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < numSeats; j++) {
                cinema[i][j] = 'S';
                freeSeats[i][j] = true;
                totInc +=price(numRows * numSeats, i + 1, numRows);
            }
        }

    }

    public void draw() {
        System.out.println("Cinema:");
        for(int i = 0; i <= numRows; i++) {
            for (int j = 0; j <= numSeats; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print("  ");
                    } else {
                        System.out.print(j + " ");
                    }
                }
                if (j == 0 && i != 0) {
                    System.out.print(i + " ");
                }
                if (j != 0 && i != 0) {
                    System.out.print(cinema[i - 1][j - 1] + " ");
                }
            }
            System.out.println();
        }
    }

    public void addSeat(int numRow, int numSeat) {

                System.out.println("Ticket price: $" +
                        price(numRows * numSeats, numRow, numRows));

                cinema[numRow - 1][numSeat - 1] = 'B';
                freeSeats[numRow - 1][numSeat - 1] = false;
                numOfPurchTic++;
                perc =  (double) numOfPurchTic / (numRows * numSeats) * 100;
                curInc += price(numRows * numSeats, numRow, numRows);

            }
}
