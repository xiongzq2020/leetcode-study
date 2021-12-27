import java.util.LinkedList;
import java.util.Queue;

/**
 * Description :
 *  给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *  给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *  完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
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
 *  思路:
 *      广度优先计算完全平方数
 *          本题中相当于一个树, 其中树的层数就是个数, 也就是返回值, 当前节点的值 = 上一个节点的值 + i * i
 * @author : xiongzq
 * @date : 2021-12-26
 */
public class PerfectSquareNumberBFS {

    Queue<Integer> waitProcessQueue = new LinkedList<>();

    public int numSquares(int n) {
        int floor = 0;

        waitProcessQueue.offer(0);

        int size = 1;

        while (!waitProcessQueue.isEmpty()) {

            int currentFloorSize = size;
            floor++;

            for (int j = 0; j < currentFloorSize; j++) {

                Integer currentNode = waitProcessQueue.poll();
                size--;

                for (int i = 1; i * i <= n; i++) {
                    int nextNode = currentNode + i * i;
                    if (nextNode == n) {
                        return floor;
                    }

                    if (nextNode > n) {
                        break;
                    }

                    waitProcessQueue.offer(nextNode);
                    size++;
                }
            }
        }
        return -1;
    }

}
