import java.util.Objects;

/**
 * Description :
 *
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 思路
 *      使用一个内部类记录当前节点的值和当前节点下栈的最小值
 *
 * @author : xiongzq
 * @date : 2021-12-27
 */
class MinStack {

    Node[] stack = new Node[100000];

    int min = Integer.MAX_VALUE;
    int size = 0;

    public MinStack() {
    }

    public void push(int val) {
        Node notd = new Node();
        min = Math.min(min, val);
        notd.setValue(val);
        notd.setNodeMin(min);

        min = Math.min(val, min);
        stack[size++] = notd;
    }

    public void pop() {
        if (size == 0) {
            return;
        }

        stack[--size] = null;
        if (size == 0) {
            min = Integer.MAX_VALUE;
        } else {
            Node node = stack[size - 1];
            min = node.getNodeMin();
        }
    }

    public int top() {
        Node node = stack[size - 1];
        return Objects.isNull(node) ? -1 : node.getValue();
    }

    public int getMin() {
        return min;
    }

    class Node {
        int value;

        int nodeMin;

        public Node() {
        }

        public Node(int value, int nodeMin) {
            this.value = value;
            this.nodeMin = nodeMin;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getNodeMin() {
            return nodeMin;
        }

        public void setNodeMin(int nodeMin) {
            this.nodeMin = nodeMin;
        }
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
