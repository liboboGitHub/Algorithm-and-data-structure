//链表
public class LinkedList<E> {
    private class Node {  //内部类
        public E e;
        public Node next;  //引用,相当于指针（存放下一个节点在内存中的地址）

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);

        }

        @Override
        public String toString() {
            return e.toString();
        }


    }

    private Node dummyHead; //虚拟的头结点（保证每个节点都有前驱）
    private int size;


    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    //在链表中间添加一个元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("加入失败，位置非法");
        }
        Node prev = dummyHead; //第一个前驱
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        size++;
    }

    //在链表尾添加一个元素
    public void addLast(E e) {
        add(size, e);
    }

    //在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    //获得链表的第index个位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("加入失败，位置非法");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    //获得第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //修改
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("设置失败，位置非法");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //链表的删除
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除失败，位置非法");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    //从链表删除元素e
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    public E removeFirst() {
        return remove(0);
    }

    public E lastFirst() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }

        res.append("NULL");
        return res.toString();
    }

}






