
//堆的设计
//1.堆的特点：完全二叉树，父亲节点大于其左右孩子节点。  （利用数组的索引结构来实现）
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data; //定义数组类的引用

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //将任意一个数组整理成堆的形式
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    //返回堆中元素的的个数
    public int size() {
        return data.getSize();
    }

    //堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回根节点的索引
    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("已经是跟节点，位置非法");
        }
        return (index - 1) / 2;
    }

    //左子树
    public int leftChild(int index) {
        return index * 2 + 1;

    }

    //右子树
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆中添加一个元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);

    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);

        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("位置非法");
        }
        return data.get(0);
    }

    //从堆中取出元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) { //传入的是节点索引
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            //该节点的左右节点先比较，选出最大者
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //取出最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax(); //找到最大元素
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}
