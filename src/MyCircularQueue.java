import java.util.Objects;

/**
 * Description :
 *
 * 题目: 设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 * 思路:
 *  本题中最好使用数组存储数据, 其中记录头指针和尾指针
 *  如果队列对空, 则头指针和尾指针都为null
 *
 *  Front: 从队首获取元素。如果队列为空，返回 -1 。
 *       如果head不为null, 返回head的数据
 *
 *  Rear: 获取队尾元素。如果队列为空，返回 -1 。
 *      tail不为null时返回tail位置的数据
 *
 *  enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 *      如果没有满, 则tail+1或者tail为最后一个元素在0位置加一个数据, tail移动
 *
 *  deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 *      删除队列head的元素
 *
 *  isEmpty(): 检查循环队列是否为空。
 *      头指针或者尾指针为null
 *
 *  isFull(): 检查循环队列是否已满。
 *      head -1 = tail 或者 tail为最后一个元素, 而head为第一个元素
 * @author : xiongzq
 * @date : 2021-12-21
 */
class MyCircularQueue {

    private Integer[] array;

    private Integer head;
    private Integer tail;

    public MyCircularQueue(int k) {
        this.array = new Integer[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            tail = 0;
            head = 0;
            array[tail] = value;
            return true;
        }
        tail = (tail + 1) % array.length;
        array[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (tail.equals(head)) {
            array[tail] = null;
            tail = null;
            head = null;
            return true;
        }

        array[head] = null;
        head = (head + 1) % array.length;
        return true;
    }

    public int Front() {
        return Objects.isNull(head) ? -1 : array[head];
    }

    public int Rear() {
        return Objects.isNull(tail) ? -1 : array[tail];
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    public boolean isFull() {
        if (tail == null || head == null) {
            return false;
        }
        return (tail + 1) % array.length == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */