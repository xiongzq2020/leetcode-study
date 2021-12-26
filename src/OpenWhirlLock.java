import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * Description :
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * <p>
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * 提示：
 * 1 <=deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 *
 * @author : xiongzq
 * @date : 2021-12-23
 */
public class OpenWhirlLock {

    HashSet<String> processedSet = new HashSet<>();
    Queue<String> waitProcessQueue = new LinkedList<>();

    public int openLock(String[] deadends, String target) {
        if (Objects.equals(target, "0000")) {
            return 0;
        }

        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendsSet.contains("0000")) {
            return -1;
        }
        waitProcessQueue.add("0000");
        processedSet.add("0000");

        int floor = 0;
        while (!waitProcessQueue.isEmpty()) {

            int size = waitProcessQueue.size();

            for (int i = 0; i < size; i++) {
                String currentNode = waitProcessQueue.poll();
                if (Objects.equals(currentNode, target)) {
                    return floor;
                }

                // 将八个子节点添加到队列和set中
                for (int j = 0; j < 4; j++) {
                    String addStr = currentNode.substring(0, j) + ((currentNode.charAt(j) == '9') ? "0" : (currentNode.charAt(j) - '0' + 1)) + currentNode.substring(j + 1);
                    String minStr = currentNode.substring(0, j) + ((currentNode.charAt(j) == '0') ? "9" : (currentNode.charAt(j) - '0' - 1)) + currentNode.substring(j + 1);

                    if (!processedSet.contains(addStr) && !deadendsSet.contains(addStr)) {
                        waitProcessQueue.offer(addStr);
                        processedSet.add(addStr);
                    }
                    if (!processedSet.contains(minStr) && !deadendsSet.contains(minStr)) {
                        waitProcessQueue.offer(minStr);
                        processedSet.add(minStr);
                    }
                }
            }
            floor++;
        }

        return -1;
    }
}
