package dsalgo.dynamicProgramming;

/**
 * 
 * Find longest common subsequence recursively and iteratively
 * 
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "aabd";
        String s2 = "aabdbadc";

        int s1Len = s1.length();
        int s2Len = s2.length();

        System.out.println("Recursive: LCS length: " + getLCSLengthRecursively(s1, s1Len - 1, s2, s2Len - 1));
        System.out.println("Recursive: LCS: " + getLCSRecursively(s1, s1Len - 1, s2, s2Len - 1, ""));

        System.out.println("Iterative: LCS length: " + getLCSLengthIteratively(s1, s2));
        System.out.println("Recursive: LCS: " + getLCSIteratively(s1, s2));
    }

    /**
     * Get length of longest common subsequence
     * 
     * @param s1 string 1
     * @param i  index variable to iterate s1
     * @param s2 string s2
     * @param j  index variable to iterate s1
     * @return max LCS length
     */
    private static int getLCSLengthRecursively(String s1, int i, String s2, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + getLCSLengthRecursively(s1, i - 1, s2, j - 1);
        }

        return Math.max(getLCSLengthRecursively(s1, i, s2, j - 1), getLCSLengthRecursively(s1, i - 1, s2, j));
    }

    private static String getLCSRecursively(String s1, int i, String s2, int j, String lcs) {
        if (i < 0 || j < 0) {
            return lcs;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            String updatedLCS = s1.charAt(i) + lcs;
            return getLCSRecursively(s1, i - 1, s2, j - 1, updatedLCS);
        }

        String lcs1 = getLCSRecursively(s1, i, s2, j - 1, lcs);

        String lcs2 = getLCSRecursively(s1, i - 1, s2, j, lcs);

        return lcs1.length() > lcs2.length() ? lcs1 : lcs2;
    }

    private static int getLCSLengthIteratively(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 2];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[len1][len2];
    }

    private static String getLCSIteratively(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 2];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // construct the LCS string
        StringBuilder sb = new StringBuilder();

        int i = len1;
        int j = len2;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }
}
