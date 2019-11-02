public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);

    }

    @Override
    public E dequeue() {  //不管是什么类型的参数，只要删除就好了
        return array.removeFirst();
    }

    @Override
    public E getFront(E e) {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(); //这是字符串对象
        res.append("Queue: ");
        res.append("Front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 4 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}

