package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();

        String[][] cinemaMap = new String[rows + 1][seatsInRow + 1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seatsInRow; j++) {
                if (i == 0 && j == 0) {
                    cinemaMap[i][j] = "  ";
                } else if (i == 0) {
                    cinemaMap[i][j] = j + " ";
                } else if (j == 0) {
                    cinemaMap[i][j] = i + " ";
                } else {
                    cinemaMap[i][j] = "S ";
                }
            }
        }

        int menuItem = -1;
        do {
            System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit");
            menuItem = scanner.nextInt();
            if (menuItem == 1) {
                showTheSeats(cinemaMap);
            } else if (menuItem == 2) {
                buyingTicket(cinemaMap);
            }
        } while (menuItem != 0);
        

        if (menuItem == 0) {
            return;
        } 
    }

    public static void showTheSeats(String[][] array) {
        System.out.println("Cinema:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(array[i][j]);
                } else if (i == 0) {
                    System.out.print(array[i][j]);
                } else if (j == 0) {
                    System.out.print(array[i][j]);
                } else {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void buyingTicket (String[][] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        array[rowNumber][seatNumber] = "B ";
        System.out.println(array[rowNumber + 1][seatNumber + 1]);

        int rows = (array.length - 1);
        int seatsInRow = (array[0].length - 1);
        int seats = rows * seatsInRow;
        int dollars = 0;
        int ticketPrice = 0;

        int smallerhalfRow = 0;
        if (seats <=60) {
            ticketPrice = 10;
        } else {
            if (rows % 2 == 0) {
                if (rowNumber <= rows / 2 ) {
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }
            } else { 
                if (rowNumber <= Math.round(rows / 2) ) {
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }
            }
        }
    
        System.out.print("Ticket price: $" + ticketPrice); 
        System.out.println();
    }
}
