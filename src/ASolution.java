/**
 * Description :
 *
 * @author : xiongzq
 * @date : 2021-12-22
 */
public class ASolution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
