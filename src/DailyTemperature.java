import java.util.Objects;
import java.util.Stack;

/**
 * Description :
 *
 * 每日温度
 * 请根据每日 气温 列表 temperatures，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 *
 * 提示：
 * 1 <=temperatures.length <= 105
 * 30 <=temperatures[i]<= 100
 *
 * 思路
 *      创建一个栈存储数组的下标, 遍历循环数组,
 *          while 栈不顶的值 < 数组当前循环的值
 *              如果当前值大于栈顶元素的值, 则返回的数组对应下标为栈顶的值, 对应的天数为当前下标和栈顶存储的下标差
 *          将数组循环的当前值添加到栈中
 *
 * @author : xiongzq
 * @date : 2021-12-27
 */
public class DailyTemperature {

    Stack<Integer> stack = new Stack<>();

    public int[] dailyTemperatures(int[] temperatures) {
        int[] resultArray = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            int currentNodeValue = temperatures[i];
            while (!stack.isEmpty() && Objects.nonNull(stack.peek()) && temperatures[stack.peek()] < currentNodeValue) {
                Integer topNode = stack.pop();
                resultArray[topNode] = i - topNode;
            }

            stack.push(i);
        }

        Integer topValue = stack.pop();
        if (Objects.nonNull(topValue)) {
            resultArray[topValue] = 0;
        }

        return resultArray;
    }
}
