package Karat;

import java.util.Arrays;

public class RectangleFinder {

    public static void main(String[] args) {
        int[][] board = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1}
        };

        int[] rectangle = findOneRectangle(board);
        if (rectangle.length == 0) {
            System.out.println("No rectangle found.");
        } else {
            System.out.println("Top-left corner: (" + rectangle[0] + ", " + rectangle[1] + ")");
            System.out.println("Bottom-right corner: (" + rectangle[2] + ", " + rectangle[3] + ")");
        }
    }

    public static int[] findOneRectangle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new int[0]; // No rectangle found
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    int width = 1;
                    int height = 1;

                    // Check the width
                    while (j + width < board[i].length && board[i][j + width] == 0) {
                        width++;
                    }
//                    while (i + height < board.length && board[i + height][j] == 0) {
//                        height++;
//                    }

                    // Check the height
                    boolean validRectangle = true;
                    while (i + height < board.length && validRectangle) {
                        for (int w = 0; w < width; w++) {
                            if (board[i + height][j + w] != 0) {
                                validRectangle = false;
                                break;
                            }
                        }
                        if (validRectangle) {
                            height++;
                        }
                    }

                    return new int[] {i, j, i + height - 1, j + width - 1};  // Return the coordinates
                }
            }
        }
        return new int[0];  // Return empty array if no rectangle is found
    }
}
