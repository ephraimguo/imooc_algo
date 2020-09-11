# Recursion and LinkedList
> Recursion is IMPORTANT!!

- Basically, recursion is a divide-conquer strategy.
> When the problem is very primitive, then we can solve it
> 
> For example, sum an array 
>
> `Sum(arr[0...n-1]) = arr[0] + Sum(arr[1, n-2])` a summation divid to a number + a smaller summation 
>
> ![recursive-arr-sum](./img/recursive-arr-sum.png)
```java
/**
 *
 * @param arr target array
 * @param l left boundary
 * @return sum of the array
 */
private static int sum(int[] arr, int l) {
    if (l == arr.length) { // the most primitive problem
        return 0;
    }
    
    // convert the original problem to a smaller problem
    return arr[l] + sum(arr, l + 1); 
}
```
> The most important part is how to divide the original problem to smaller problem

### OMG! Recursive & LinkedList
> recall: what is a linked list?
>  ![recall-linked-list](./img/recall-linked-list.png)
> actually now we can see it like
>
> 0 -> [ Here is a shorter linked list start from 1 ] so on and so forth.
 