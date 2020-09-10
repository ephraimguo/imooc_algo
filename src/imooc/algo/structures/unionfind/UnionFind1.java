package imooc.algo.structures.unionfind;

public class UnionFind1 {

    private Integer[] id;
    private int count;

    public UnionFind1(int count) {
        this.count = count;
        id = new Integer[count];

        for (int i = 0; i < count; i++) {
            id[i] = i;
        }

    }

    public void showId() {
        for (int i = 0; i < count; i++){
            System.out.println("id: " + id[i] + ", element is " + i);
        }
    }

    public Integer find(int p) {
        assert (p >= 0 && p < count);
        return id[p];
    }

    public boolean isConnected(int p, int q) {
        return (find(p).equals(find(q)));

    }

    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < count; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}



















