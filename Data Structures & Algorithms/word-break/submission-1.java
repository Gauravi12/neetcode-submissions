class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp , false);

        dp[0] = true;

        for(int i=0;i<dp.length-1;i++){
            if(dp[i] != true){
                continue;
            }
            for(int j=i+1;j<dp.length;j++){
                String word = s.substring(i , j);
                boolean umm = wordDict.contains(word);
                if(umm){
                    dp[j] = true;
                }
            }
        }

        return dp[s.length()];

    }
}
