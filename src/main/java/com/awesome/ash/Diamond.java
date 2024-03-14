package com.awesome.ash;

public class Diamond {
    private static final char CHAR_A = 'A';
    public static final int MINIMUM = 1;
    public static final int RESERVE_SPACE = 2;
    public static final int RESERVE_RESERVE_INDEX = 2;

    static char[][] draw(char input) {
        if (isInvalidInput(input)) {
            System.out.println(":(");
            return new char[][]{};
        }

        char alphabet = Character.toUpperCase(input);
        char[][] diamond = createATwoDimensionArray(alphabet);

        insertChar(alphabet, diamond);
        printDiamond(diamond);

        return diamond;
    }

    /**
     * Calculate blank char for each line such as
     * 0 --> 0
     * 1 --> 1
     * 2 --> 3
     * 3 --> 5
     * the final result is always an odd number such as 1,3,5,7,9
     *
     * @param line line number
     * @return total number of blank space
     */
    static int calculateBlankSpaces(int line) {
        int space = 0;
        for (int i = 1; i <= line; i++) {
            space = i == 1 ? 1 : space + 2;
        }

        return space;
    }

    private static char[][] createATwoDimensionArray(char alphabet) {
        int distance = alphabet - CHAR_A;
        int row = distance + MINIMUM;
        int column = distance == 0 ? 1 : calculateBlankSpaces(distance) + RESERVE_SPACE;
        return new char[row][column];
    }

    private static void printDiamond(char[][] arr) {
        printUpper(arr);
        printLower(arr);
    }

    private static void printUpper(char[][] arr) {
        for (char[] row : arr) {
            System.out.println(row);
        }
    }

    /**
     * Print the lower part of the diamond by printing the array in reverse order.
     * Exclude the last row array as the row to avoid printing duplicate line
     *
     * @param arr two-dimensional array to print
     */
    private static void printLower(char[][] arr) {
        int startIndex = arr.length - RESERVE_RESERVE_INDEX;
        for (int i = startIndex; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    /**
     * Insert characters in the given two dimension arrays in reverse order.
     * At the first iteration the given inputChar is entered in the first and last position of the array,
     * rest of the position are filled with spaces.In the subsequent iterations the function decrease the
     * inputChar value, increase starting position and decrease end position.
     *
     * @param inputChar a char range in between A to Z
     * @param arr       two dimension char array to place the chars
     */
    private static void insertChar(char inputChar, char[][] arr) {
        int charPosAtStart = 0;
        int charPosAtEnd = arr[0].length - 1;
        char charToPrint = inputChar;

        for (int i = arr.length - 1; i >= 0; i--) {
            char[] row = arr[i];
            for (int j = 0; j < row.length; j++) {
                if (j == charPosAtStart || j == charPosAtEnd) {
                    row[j] = charToPrint;
                } else {
                    row[j] = ' ';
                }

            }
            charPosAtStart++;
            charPosAtEnd--;
            charToPrint--;
        }
    }

    private static boolean isInvalidInput(char alphabet) {
        return !(Character.isUpperCase(alphabet) || Character.isLowerCase(alphabet));
    }
}
