package com.awesome.ash;

public class Diamond {
    private static final char CHAR_A = 'A';
    public static final int MINIMUM = 1;
    public static final int CHAR_RESERVE_SPACE = 2;

    static char[][] draw(char input) {
        char alphabet = Character.toUpperCase(input);
        //System.out.println("input: " + inputChar);

        int distance = alphabet - CHAR_A;
        int row = distance + MINIMUM;
        int column = distance == 0 ? 1 : calculateBlankSpace(distance) + CHAR_RESERVE_SPACE;
        char[][] arr = new char[row][column];

        if(distance == 0) {
            arr[0][0]= alphabet;
        }

        insertChar(alphabet, arr);
        printDiamond(arr);

        return arr;
    }

    private static void printDiamond(char[][] arr) {
        printUpper(arr);
        printLower(arr);
    }

    private static void printUpper(char[][] arr) {
        for(char[] row: arr) {
            System.out.println(row);
        }
    }

    private static void printLower(char[][] arr) {
        int startIndex = arr.length - 2;
        for(int i = startIndex ; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    private static void insertChar(char inputChar, char[][] arr) {
        int charPosAtStart = 0;
        int charPosAtEnd = arr[0].length - 1;
        char charToPrint = inputChar;
        for(int i = arr.length -1; i >= 0; i-- ) {
            char[] dRow = arr[i];
            for (int j = 0; j< dRow.length; j++) {
                if(j == charPosAtStart || j == charPosAtEnd) {
                    dRow[j] = charToPrint;
                 } else {
                    dRow[j] = '-';
                }

            }
            charPosAtStart++;
            charPosAtEnd--;
            charToPrint--;
        }
    }

    static int calculateBlankSpace(int position) {
        int space = 0;
        for(int i = 1; i <= position; i++) {
            space = i == 1 ? 1 : space + 2;
        }

        return space;
    }
}
