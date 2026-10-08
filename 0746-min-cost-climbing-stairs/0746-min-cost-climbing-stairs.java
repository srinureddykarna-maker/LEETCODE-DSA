class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(n-1,cost,dp),solve(n-2,cost,dp));
        
    }
    int solve(int n , int[] cost,int[] dp){
        if(n == 1 || n == 0){
            return cost[n];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] =cost[n] +  Math.min(solve(n-1,cost,dp),solve(n-2,cost,dp));
        return dp[n];
    }
}