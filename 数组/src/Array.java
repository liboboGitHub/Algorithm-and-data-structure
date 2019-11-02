//基于Java的数组的二次封装（动态的）
//使用泛型(除基本类型外的所有类型）
public class Array<E> {
    private E[] data;       //存储数据
    private int size;       //有多少个有效的数据

    //构造方法，传入数组容量
    public Array(int capacity) {
        data = (E[]) new Object[capacity];  //new不了泛型的的数组
        size = 0;

    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    //无参数的构造函数
    public Array() {
        this(10);
    }

    //获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后添加一个新的元素
    public void addLast(E e) {
        add(size, e);
    }

    //向第一个位置插入元素
    public void addFirst(E e) {
        add(0, e);
    }

    //插入到指定位置
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            //参数错误
            throw new IllegalArgumentException("Add failed,index>=0,and index<=size.");
        }
        if (size == data.length) {
            resize(2 * data.length); //扩容2倍
        }


        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }

    //扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity]; //定义一个新的数组
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    //获取
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is Illegal");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    } //不用data[size-1],防止数组越界

    public E getFirst() {
        return get(0);
    }

    //修改
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is Illegal");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找元素，并且返回数组的下标
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1; //位置不合法
    }

    //删除某一个元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed,Index is Illegal");
        }
        E rem = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //缩容
        if (size == data.length / 4 && data.length != 0) {
            resize(data.length / 2);
        }
        return rem;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }


    //交换
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("位置非法");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override  //输出数组类（某个对象）的详细信息
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }


}
