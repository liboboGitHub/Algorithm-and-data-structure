//二分搜索树(数据具有可比性)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root; //根节点
    private int size; //树中的元素个数

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加（递归算法）
    public void add(E e) {
        root = add(root, e);
    }

    //递归的方法（1.递归终止条件的判断，2.递归调用）
    private Node add(Node node, E e) {
        //递归终止条件的判断
        if (node == null) {
            return new Node(e); //如果根节点是空的话，直接返回一个新的空节点（引用类型）
        }
        //递归调用
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;

    }

    //查询
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) { //二分搜索树直接为空
            return false;
        }
        //递归终止
        if (e.compareTo(node.e) == 0) { //做减法
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e); //输出表示已经访问了
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历(从小到大的顺序)
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.println(node.e); //输出表示已经访问了
        preOrder(node.right);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e); //输出表示已经访问了
    }

    //前序遍历的非递归写法

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

    }

    //层序遍历（广度优先遍历）
    public void levalOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }

    }

    //获得最小值（二分搜索树）
    public E minmum() {
        if (size == 0) {
            throw new IllegalArgumentException("二分搜索树为空");
        }
        return minmum(root).e;
    }

    private Node minmum(Node node) {
        if (node.left == null) {  //递归终止条件的判断
            return node;
        }

        //递归调用

        return minmum(node.left);
    }

    //获得二叉树的最大值
    public E maxmum() {
        if (size == 0) {
            throw new IllegalArgumentException("二分搜索树为空");
        }
        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        if (node.right == null) {  //递归终止条件的判断
            return node;
        }

        //递归调用
        return minmum(node.right);
    }


    //删除二分搜索树的最小值(返回最小值)

    public E removeMin() {
        E ret = minmum();
        root = removeMin(root);
        return ret;

    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    //删除二分搜索树的最大值(并且返回根节点,就是删除得那个节点）
    public E removeMax() {
        E ret = maxmum();

        root = removeMax(root);
        return ret;


    }

    //递归写法，并且返回删除的节点
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null; //让node与二分搜索树想离
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }


    //在二分搜索树中删除任意节点（重点）
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {   //待删除节点的左子树为空
                Node rightNode = node.right;  //用于返回的新的根节点
                node.right = null; //让该节点与整个二分搜索树脱节（这是一种写的方式）
                size--;
                return rightNode;
            }
            if (node.right == null) {  //待删除节点的右子树为空
                Node leftNode = node.left;  //用于返回的新的根节点
                node.left = null;      //让该节点与整个二分搜索树脱节（这是一种写的方式）
                size--;
                return leftNode;
            }

            //删除的节点左右都不为空（待删除节点的右子树的最小节点作为新的根节点，或者左子树的最大节点作为新的根节点）。
            Node n = minmum(node.right);
            n.right = removeMin(node.right);
            n.left = node.left;
            node.left = node.right = null;

            return n;

        }
    }


}

