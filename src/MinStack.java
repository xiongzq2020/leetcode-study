import java.util.Objects;

/**
 * Description :
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
