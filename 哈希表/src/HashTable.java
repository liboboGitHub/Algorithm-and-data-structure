import java.util.TreeMap;


// 个人理解：将要存储的键值对中的键通过哈希函数生成一个哈希索引作为哈希表（实质是一个Map类型的数组）的索引，
// 如果生成的索引值相同则放到之前的Map（其实也可以是链表）中，不同则存入新的Map中，将哈希表的大小加一。
public class HashTable<K, V> {

    private static final int upperTol = 10;     // 上界
    private static final int lowerTol = 2;      // 下界
    private static final int initCapacity = 7;  // 初始容量

    private TreeMap<K, V>[] hashtable;
    private int size;
    private int M;

    public HashTable(int M) {        // 这是初始化哈希表的容量，并不是哈希表的实际的大小，注意是表
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];  // 实例化哈希对象数组
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    /*获取哈希索引的方法，哈希函数，将普通键值对的键（可能是其他类型）转换为数组的索引*/
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {  // 拉链法
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= upperTol * M) {
                resize(2 * M);
            }
        }

    }

    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            ret = map.remove(key);      // 键值相同的键值对会被全部删除
            size--;

            if (size < lowerTol * M && M / 2 >= initCapacity)
                resize(M / 2);
        }
        return ret;
    }


    public void set(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }


    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    /*扩容 & 缩容操作 */
    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++)
            newHashTable[i] = new TreeMap<>();

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }

        this.hashtable = newHashTable;
    }


}
