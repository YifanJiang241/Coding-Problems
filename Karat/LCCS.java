package Karat;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// 输出两个user的最长连续且相同的访问记录。

public class LCCS {
    public static List<String> longestCommonContinuousHistory(String[] user1, String[] user2) {
        int m = user1.length;
        int n = user2.length;

        // dp array to store the length of the longest common subarray ending at user1[i-1] and user2[j-1]
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = -1;

        // Build the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (user1[i - 1].equals(user2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                System.out.print(" " + dp[i][j]);
            }
        }



        // Extract the longest common subarray from user1
        if (maxLength == 0) return new ArrayList<>();
        String[] result = Arrays.copyOfRange(user1, endIndex - maxLength + 1, endIndex + 1);
        return new ArrayList<>(Arrays.asList(result));
    }

    public static void main(String[] args) {
        String[] user1 = {"3234.html", "xys.html", "7hsaa.html"};
        String[] user2 = {"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};

        List<String> result = longestCommonContinuousHistory(user1, user2);
        System.out.println(result);

    }
}
