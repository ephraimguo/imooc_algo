# Segment Tree
> Let's image a senario.
>
> There is a wall with length N, every time you will choose a segment of the wall and paint it. Overlapping is possible.
>
> After M times painting, how many colors we will see on the wall
>
> After M times painting, how many colors we will see on the wall in range [i, j] 
>
> <img src="./img/seg-tree-1.png" alt="seg-tree-1" style="zoom:67%;" />

There will be 2 types of operation.

- paiting() -> update the range -> segment tree O(logN)
- query() -> query the result -> segment tree O(logN)

### Segment Query

> Let's say, you only want to query the color in between [i, j], or even not color array, you want to query an array of instance.
>
> Within [i, j], you need the max/min/sum of the instances
> <img src="./img/seg-tree-2.png" alt="seg-tree-sample" style="zoom:67%;" />
>
> However, the leaf node of segment tree is not always at the same level
>
> <img src="./img/seg-tree-3.png" alt="seg-tree-uneven" style="zoom:67%;" />
>
> Therefore, segment tree is not a complete / nearly complete binary tree.
>
> BUT, segment tree is a balance binary tree.

