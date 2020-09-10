package imooc.algo.structures.unionfind;

public class UnionFind3 {
    private Integer[] parent;
    private Integer[] sz; // sz[i]: nocdes count of collection wilth root i
    private int count;

    public UnionFind3(int count) {
        this.count = count;
        parent = new Integer[count];
        sz = new Integer[count];

        for (int i = 0; i < count; i++) {
            sz[i] = 1;
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

        //parent[pRoot] = qRoot;
        if (sz[pRoot] < sz[qRoot]) {
            parent[qRoot] = qRoot;
            sz[pRoot] += sz[qRoot];

        } else {
            parent[qRoot] = pRoot;
            sz[qRoot] = sz[pRoot];

        }

    }
}























