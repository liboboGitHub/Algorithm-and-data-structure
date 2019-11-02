public interface UF {
    int getSize(); //连通分量的个数

    boolean isConnected(int p, int q); // 如果 p和 q 存在于同一个分量中则返回true

    void unionElements(int p, int q); // 在p和q之间添加一条连接
}
