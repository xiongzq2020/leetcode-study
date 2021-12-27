/**
 * description
 *
 * 完全平方数
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 解法二:
 *      使用动态规划解决, 定义一个一维数组dp[], dp[i]为i最小的平方数和的个数最小
 *      其中 dp[i] = dp[x + j * j] + 1
 *      变换一下方式  dp[i] = dp[i - j * j] + 1的最小值
 *
 * @author Xiongzq
 * @date 2021/12/27 19:51
 */
public class PerfectSquareNumberDynamicProgramming {

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
