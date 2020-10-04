package imooc.algo.datastructure.segmenttree;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        // SegmentTree<Integer> segTree = new SegmentTree<>(nums, Integer::sum);
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b);

        System.out.println(segTree);
    }
}
