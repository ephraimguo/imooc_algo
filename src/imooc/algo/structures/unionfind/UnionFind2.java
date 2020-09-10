package imooc.algo.structures.unionfind;

/**
 * description: Quick Union for Union Find
 */
public class UnionFind2 {
    private Integer[] parent;
    private int count;

    public UnionFind2(int count) {
        this.count = count;
        parent = new Integer[count];

        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }

    }

    public boolean isConnected(int p, int q) {
        return (find(p) == (find(q)));
    }

    public void showId() {
        for (int i = 0; i < count; i++){
            System.out.println("id: " + parent[i] + ", element is " + i);
        }
    }

    public int find(int p ) {
        assert (p >= 0 && p < count);
        while (p != parent[p]) {
            p = parent[p];
        }

        return p;
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;

    }

}
