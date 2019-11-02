// 图的接口
public interface Graph {

    public int V(); // 返回节点的个数

    public int E(); // 返回边的个数

    public void addEdge(int v, int w); // 向两个节点之间添加一条边

    boolean hasEdge(int v, int w);   // 判断两个节点之间是否有边

    void show(); // 可视化打印

    public Iterable<Integer> adj(int v); // 求节点的所有的相邻边
}
