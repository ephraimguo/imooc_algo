package imooc.algo.structures.graph;

public class Main {

    public static void main(String[] args) {
        String file1 = "/Users/ephraim/IntellijProj/imooc_algo_bobo/src/imooc/algo/structures/graph/testG2.txt";

        SparseGraph g1 = new SparseGraph(6, false);
        ReadGraph readGraph1 = new ReadGraph(g1, file1);
        System.out.println("test G1 in Sparse Graph:");
        Component<SparseGraph> c1 = new Component<>(g1);
        System.out.println("component counts " + c1.count());
        g1.show();

        System.out.println();

        DenseGraph g2 = new DenseGraph(8, false);
        ReadGraph readGraph2 = new ReadGraph(g2, file1);
        System.out.println("test G2 in Dense Graph");
        Component<DenseGraph> c2 = new Component<>(g2);
        System.out.println("component counts " + c2.count());
        g2.show();
    }

}
