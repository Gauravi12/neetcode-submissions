class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int maxlen = 0;
        int start = 0;
        int end = 0;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                // One character
                if (i == j) {
                    dp[i][j] = true;
                }

                // Two or more characters
                else if (s.charAt(i) == s.charAt(j)) {

                    // Two characters
                    if (j - i == 1) {
                        dp[i][j] = true;
                    }

                    // More than two characters
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) {

                    int len = j - i + 1;

                    if (len > maxlen) {
                        maxlen = len;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}