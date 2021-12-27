import java.util.Objects;
import java.util.Stack;

/**
 * Description :
 *
 *  有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 *  思路:
 *      创建一个栈, 循环遍历传入的字符串, 如果当前字符和栈顶的括号想匹配, 则弹栈, 否则则压栈
 *
 * @author : xiongzq
 * @date : 2021-12-27
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(currentChar);
                continue;
            }

            Character topChar = stack.peek();

            char matchBrackets = getMatchBrackets(topChar);

            if (Objects.equals(matchBrackets, currentChar)) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }


        return stack.isEmpty();
    }

    /**
     * 获取匹配的括号
     */
    private char getMatchBrackets(char c) {
        switch (c) {
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return '-';
        }
    }
}
