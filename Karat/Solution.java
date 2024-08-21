package Karat;

import java.util.*;

public class Solution {
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up

    public static List<int[]> findExit(char[][] board, int[] start) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> exits = new ArrayList<>();

        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            // Check if it's a valid exit
            if ((x == 0 || x == m-1 || y == 0 || y == n-1) && !(x == start[0] && y == start[1])) {
                exits.add(new int[]{x, y});
                continue; // Continue to find all exits at the shortest distance
            }

            // Explore the four possible directions
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == '0' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return exits; // Returns all exits found or an empty list if none
    }

    public static void main(String[] args) {
        char[][] board = {
                {'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}
        };
        int[] start = {2, 0}; // Example start point

        List<int[]> exits = findExit(board, start);
        if (exits.isEmpty()) {
            System.out.println("No exit found.");
        } else {
            for (int[] exit : exits) {
                System.out.println("Exit found at: (" + exit[0] + ", " + exit[1] + ")");
            }
        }
    }
}
