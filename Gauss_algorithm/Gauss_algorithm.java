package Gauss_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Gauss_algorithm {
    public static void printer(float[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" };
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col + 1 == cols) {
                    System.out.print("| ");
                    System.out.printf("%4.1f ", array[row][col]);
                } else {
                    System.out.printf("%4.1f%s ", array[row][col], chars[col]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // initialize size
        System.out.print("Gleichungssystem Größe (RowsxColumns): ");
        String[] size = myScanner.nextLine().split("x");
        int rows = Integer.parseInt(size[0]);
        int columns = Integer.parseInt(size[1]);

        System.out.println("rows: " + rows + ", columns: " + columns);

        // get equations
        String[][] equationStrings = new String[rows][columns + 1];
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter equation " + (i + 1) + ": (a b c d e) ");
            equationStrings[i] = myScanner.nextLine().split(" ");
            // System.out.println(Arrays.toString(equationString));
        }

        float[][] equations = new float[rows][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns + 1; j++) {
                equations[i][j] = Float.parseFloat(equationStrings[i][j]);
            }
        }

        printer(equations);

        for (int col = 0; col < columns; col++) {
            for (int row = col + 1; row < rows; row++) {

                float a = equations[col][col];
                float b = equations[row][col];
                float x = -(b / a);
                System.out.println("x = " + x);

                for (int i = 0; i <= columns; i++) {
                    equations[row][i] += equations[col][i] * x;
                }

                printer(equations);
            }
        }
    }
}