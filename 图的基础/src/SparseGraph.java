import java.util.Vector;

// 稀疏图 - 邻接表
public class SparseGraph implements Graph {
    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;    // 是否为有向图
    private Vector<Integer>[] g; // 向量数组（对象数组，相当于每一个行为一个向量）

    // 构造方法
    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = (Vector<Integer>[]) new Vector[n];
        // 初始化每个向量 （每一个向量想当于一个动态数组）
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
    }

    // 返回节点个数
    public int V() {
        return n;
    }

    // 返回边的个数
    public int E() {
        return m;
    }

    // 向图中添加一个边
    public void addEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v != w && !directed)
            g[w].add(v);

        m++;
    }

    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++)
            if (g[v].elementAt(i) == w)
                return true;
        return false;
    }

    @Override
    // 显示图的信息
    public void show() {

        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++)
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }


    // 返回图某一个节点的所有领边
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }


}
