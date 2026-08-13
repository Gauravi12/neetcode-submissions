class Solution {
    public int numDecodings(String s) {

        if (s.length() == 0) return 0;

        int n = s.length();

        // dp[i] = number of ways to decode from index i
        int[] dp = new int[n + 1];

        // Reached the end successfully
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {

            // Current digit is 0 → cannot decode alone
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // Take current digit alone
            dp[i] = dp[i + 1];

            // Try taking TWO digits
            if (i + 1 < n) {

                int num = (s.charAt(i) - '0') * 10
                        + (s.charAt(i + 1) - '0');

                // Two digit number must be 10 to 26
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}