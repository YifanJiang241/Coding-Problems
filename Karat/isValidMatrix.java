package Karat;

import java.util.*;


//给一个N*N的矩阵，判定是否是有效的矩阵。有效矩阵的定义是每一行或者每一列的数字都必须正好是1到N的数。输出一个bool。
public class isValidMatrix {
    public static boolean isValid(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            int rowMin = Integer.MAX_VALUE;
            int rowMax = Integer.MIN_VALUE;
            int colMin = Integer.MAX_VALUE;
            int colMax = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                int rowVal = matrix[i][j];
                int colVal = matrix[j][i];

                // Check for duplicates in the row
                if(!rowSet.contains(rowVal)){
                    rowSet.add(rowVal);
                } else {
                    return false;
                }
//                if (!rowSet.add(rowVal)) {
//                    return false;
//                }
                // Check for duplicates in the column
                if (!colSet.add(colVal)) {
                    return false;
                }

                // Update min and max for row and column
                rowMin = Math.min(rowMin, rowVal);
                rowMax = Math.max(rowMax, rowVal);
                colMin = Math.min(colMin, colVal);
                colMax = Math.max(colMax, colVal);
            }

            // Check the min and max values
            if (rowMin != 1 || rowMax != n || colMin != 1 || colMax != n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {4, 3, 2, 1},
                {2, 3, 4, 1},
                {3, 4, 1, 2},
                {1, 2, 3, 4}
        };

        System.out.println("Is the matrix valid? " + isValid(matrix));
    }
}

