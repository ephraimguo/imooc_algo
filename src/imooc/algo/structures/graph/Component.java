package imooc.algo.structures.graph;

import java.util.Vector;

public class Component<T extends Graph> {
    private Graph G;
    private Vector<Boolean> visited;
    private int[] id;

    int ccount;

    public Component(Graph G) {
        this.G = G;
        this.visited = new Vector<>();
        this.id = new int[G.V()];

        for (int i = 0; i < G.V(); i++) {
            this.visited.add(false);
            this.id[i] = -1;
        }

        for (int i = 0; i < G.V(); i++) {
            if (!this.visited.get(i)) {
                dfs(i);
                ccount++;
            }

        }
    }

    public int count() {
        return ccount;
    }

    public boolean isConnected(int v, int w) {
        assert (v >= 0 && v < G.V());
        assert (w >= 0 && w < G.V());
        return id[v] == id[w];
    }

    private void dfs(int v) {
        visited.set(v, true);
        id[v] = ccount;

        for (Integer i : G.adj(v)) {
            if (!visited.get(i)) {
                dfs(i);
            }
        }

    }
}
