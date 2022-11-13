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

    public static float[][] swapRows(float[][] array, int row1, int row2) {
        float[] tempRow = array[row1];

        array[row1] = array[row2];
        array[row2] = tempRow;

        System.out.println("swapped row " + row1 + " with row " + row2);
        return array;
    }

    public static int getNextPivotRow(float[][] array, int currentRow, int currentCol) {
        int rows = array.length;

        for (int i = currentRow; i < rows; i++) {
            if (array[i][currentCol] != 0) {
                System.out.println("next pivot row: " + i);
                return i;
            }
        }
        System.out.println("no next pivotrow\n");
        return rows;
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

        // get float from equationsStrings in new float array
        float[][] equations = new float[rows][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns + 1; j++) {
                equations[i][j] = Float.parseFloat(equationStrings[i][j]);
            }
        }

        printer(equations);

        // create gauss-like matrix
        int noPreviousPivotCount = 0;
        for (int col = 0; col < columns; col++) {
            int nextPivotRow = getNextPivotRow(equations, col, col);

            // check if theres a potential pivotRow
            if (nextPivotRow >= rows) {
                noPreviousPivotCount++;
                continue;
            }
            // check if the next pivotRow is at the top
            if (nextPivotRow != col)
                swapRows(equations, nextPivotRow, col);

            // check if the next pivot row is on top if there was no pivot before
            if (noPreviousPivotCount > 0 && nextPivotRow != col - noPreviousPivotCount)
                swapRows(equations, nextPivotRow, col - noPreviousPivotCount);

            // reset noPreviousPivotCount since all the checks with it are done and there is
            // a pivot
            noPreviousPivotCount = 0;

            // start looping the rows
            for (int row = col + 1; row < rows; row++) {
                // check if number below pivot is already 0
                if (equations[row][col] == 0) {
                    System.out.println("skipped x calculation beacause 0 under pivot");
                    continue;
                }

                // calculate x to make the number below the pivot go to 0
                float a = equations[col][col];
                float b = equations[row][col];
                float x = -(b / a);
                System.out.println("x = " + x);

                // multiply that x to all elements in a row
                for (int i = 0; i <= columns; i++) {
                    equations[row][i] += equations[col][i] * x;
                }

                printer(equations);
            }
            System.out.println();
        }
        printer(equations);
        // gauss-like matrix stored in equations

        // get values for a, b, c, ....
        // check if solvable:
        boolean[] isSolvable = new boolean[rows];
        Arrays.fill(isSolvable, false);
        for (int row = 0; row < rows; row++) {
            if (equations[row][columns] != 0) {
                for (int col = 0; col < columns; col++) {
                    if (equations[row][col] != 0)
                        isSolvable[row] = true;
                }
            } else
                isSolvable[row] = true;
        }
        for (int i = 0; i < isSolvable.length; i++) {
            if (isSolvable[i] == false) {
                System.out.println("not solvable");
                System.exit(0);
            }
        }

        // its solvable
        // next check which rows are all 0
        boolean[] allZeroLines = new boolean[rows];
        Arrays.fill(allZeroLines, false);
        first: for (int row = rows - 1; row >= 0; row--) {
            for (int col = 0; col < columns; col++) {
                if (equations[row][col] != 0) {
                    allZeroLines[row] = false;
                    break first;
                }
                allZeroLines[row] = true;
            }
        }
        System.out.println("all zero: " + Arrays.toString(allZeroLines));

        // start solving
        
    }
}