package imooc.algo.structures.graph;

import java.util.Vector;

public class SparseGraph implements Graph{
    private Integer n;
    private Integer m;
    private Vector<Vector<Integer>> g;
    private boolean directed;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;

        this.g = new Vector<>();
        for (int i = 0; i < n; i++) {
            this.g.add(new Vector<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        assert (v >= 0 && v < m);
        assert (w >= 0 && w < m);

        if (hasEdge(v, w)) {
            return;
        }

        g.get(v).add(w);
        if (!directed) {
            g.get(w).add(v);
        }

        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < m);
        assert (w >= 0 && w < m);

        for (Integer vertex : g.get(v)) {
            if (vertex == w) {
                return true;
            }
        }

        return false;
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ": \t");
            for (int j = 0; j < g.get(i).size(); j++) {
                System.out.print(g.get(i).get(j) + "\t");
            }
            System.out.println();

        }
    }

    public Iterable<Integer> adj(int v) {
        assert (v >= 0 && v < m);
        return g.get(v);
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

}
