package cinema;

import java.util.*;

public class Cinema {

    static int price(int countSeats, int numRow, int numRows) {
        if (countSeats > 60) {
            if (numRow > numRows / 2) {
                return 8;
            }
        }
        return 10;
    }


    static public void menu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = scanner.nextInt();
        int choice = 0;
        cinemaHall o = new cinemaHall(numRows, numSeats);
        char[][] cinema = new char[numRows][numSeats];
        do {
            menu();
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    o.draw();
                    break;
                case 2:
                    boolean flag = true;
                    do {
                        System.out.println("Enter a row number:");
                        int numRow = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int numSeat = scanner.nextInt();
                        System.out.println();
                        if (numRow > numRows || numSeat > numSeats) {
                            System.out.println("Wrong input!");
                            System.out.println();
                        } else if (o.getFreeSeats(numRow, numSeat)) {
                            o.addSeat(numRow, numSeat);
                            flag = false;
                        } else {
                            System.out.println("That ticket has already been purchased!");
                            System.out.println();
                        }
                    } while (flag);
                    break;
                case 3:
                    System.out.printf("Number of purchased tickets: %d%n", o.getNumOfPurchTic());
                    System.out.printf("Percentage: %.2f%%%n", o.getPerc());
                    System.out.printf("Current income: $%d%n",o.getCurInc());
                    System.out.printf("Total income: $%d%n", o.getTotInc());
                    break;
            }
        } while (choice != 0);

    }
}




