package imooc.algo.structures.graph;

import java.util.Vector;

public class DenseGraph implements Graph {
    private int n; // number of vertices
    private int m; // number of edges
    private boolean directed; // a directed graph or not
    private Vector<Vector<Boolean>> g; // graph matrix

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;

        this.directed = directed;
        this.g = new Vector<>();
        for (int i = 0; i < n; i++) {
            Vector<Boolean> temp = new Vector<>();
            for (int j = 0; j < n; j++) {
                temp.add(false);
            }
            g.add(temp);

        }
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    /**
     * add an edge in between v and w
     *
     * @param v, vertex v
     * @param w, vertex w
     */
    public void addEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);

        if (hasEdge(v, w)) {
            return;

        }

        g.get(v).set(w, true);
        if (!directed) {
            g.get(w).set(v, true);

        }

        m++;

    }

    public Iterable<Integer> adj(int v) {
        assert (v >= 0 && v < n);

        Vector<Integer> adjEdges = new Vector<>();

        for (int i = 0; i < g.get(v).size(); i++) {
            if (g.get(v).get(i)) {
                adjEdges.add(i);
            }
        }

        return adjEdges;
    }

    public boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        return g.get(v).get(w);
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ": \t");
            for (int j = 0; j < g.get(i).size(); j++) {
                System.out.print(g.get(i).get(j) + "\t");
            }
            System.out.println();

        }
    }
}



















