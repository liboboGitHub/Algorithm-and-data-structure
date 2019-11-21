public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>(); //基于最大堆实现优先队列
    }


    public int getSize() {
        return maxHeap.size();
    }


    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    //入队操作
    public void enqueue(E e) {
        maxHeap.add(e);
    }


    public E dequeue() {
        return maxHeap.extractMax();  //提出最大堆
    }

    public E getFront(E e) {
        return maxHeap.findMax();
    }
}
