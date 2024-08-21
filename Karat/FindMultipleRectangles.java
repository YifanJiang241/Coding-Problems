package Karat;

import java.util.ArrayList;
import java.util.List;

public class FindMultipleRectangles {
    public static List<int[][]> findMultipleRectangles(int[][] board) {
        List<int[][]> rectangles = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return rectangles;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    // Start of a new rectangle
                    int height = 0;
                    int width = 0;

                    // Determine the width by checking contiguous zeros in the row
                    while (j + width < board[0].length && board[i][j + width] == 0) {
                        width++;
                    }
                    while (i + height < board.length && board[i + height][j] == 0) {
                        height++;
                    }

                    // Determine the height by checking contiguous zeros in the column
//                    boolean validColumn = true;
//                    while (i + height < board.length && validColumn) {
//                        for (int w = 0; w < width; w++) {
//                            if (board[i + height][j + w] != 0) {
//                                validColumn = false;
//                                break;
//                            }
//                        }
//                        if (validColumn) {
//                            height++;
//                        }
//                    }

                    // Mark all cells within the rectangle to avoid re-processing
                    for (int h = 0; h < height; h++) {
                        for (int w = 0; w < width; w++) {
                            board[i + h][j + w] = 1;
                        }
                    }

                    // Store top-left and bottom-right coordinates of the rectangle
                    rectangles.add(new int[][]{{i, j}, {i + height - 1, j + width - 1}});
                }
            }
        }
        return rectangles;
    }

    public static void main(String[] args) {
        int[][] board = {
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0}
        };

        List<int[][]> rectangles = findMultipleRectangles(board);
        for (int[][] rectangle : rectangles) {
            System.out.println("Top-left: (" + rectangle[0][0] + ", " + rectangle[0][1] + "), " +
                    "Bottom-right: (" + rectangle[1][0] + ", " + rectangle[1][1] + ")");
        }
    }
}
