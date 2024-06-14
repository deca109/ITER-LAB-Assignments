/**
 * Ques 1 : Write a Java Program to implement Coin Exchange.
 */

/**
 * ALGORITHM
 * 
 function coinChange(coins, amount):
    dp = ARRAY of size (amount + 1)
    dp[0] = 1
    for each coin in coins:
        for i from coin to amount:
            dp[i] = dp[i] + dp[i - coin]
    return dp[amount]
 */

/**
 * CODE
 */

import java.util.*;
public class CoinExchange {
	public static void main(String args[]) {
		int denominations[]= {1,2,5};
		int sum=7;
		System.out.println("Least number of coins required = " + solver(sum,denominations));
	}
	public static int solver(int sum,int[] coins) {
		int[][] dp=new int[coins.length+1][sum+1];
		dp[0][0]=1;
		
		for(int i=1;i<=coins.length;i++) {
			for(int j=0;j<=sum;j++) {
				dp[i][j]+=dp[i-1][j]; //using coins other than current coin
				if(j-coins[i-1]>=0)
				dp[i][j]+=dp[i][j-coins[i-1]]; //using the current coin
			}
		}
		return dp[coins.length][sum];
	}
}

/**
 * OUTPUT
 *
 * Number of ways to make change for 12 is : 13
 */
