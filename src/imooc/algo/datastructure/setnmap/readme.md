# Set

```java
interface Set<E> {
  void add(E);
  void remove(E);
  boolean contains(E);
  int getSize();
  boolean isEmpty();
}
```

> A set can be implemented by __Binary Search Tree__ or __Linked List__

- By __Binary Search Tree__
  - Time complexity of `add()`, `remove()`, `contains()` are __O(log n)__
- By __Linked List__
  - Time complexity of `add()`, `remove()`, `contains()` are __O(n)__

Time complexity of different implementation are significantlly different.



# Map

> In programming languages, __map__ is more like a dictionary other than the mathematic concept.
>
> A __Key-Value__ pair data structure.
>
> A map can be implemented by __Binary Search Tree__ or __Linked List__
>
> 

```java
class Node { // bst node
  K key;
  V value;
  Node left;
  Node right;
}

class Node { // or we can use linked list
  K key;
  V value;
  Node next;
}

// hence we can design the interface as below:
interface Map<K, V> {
  void add(K, V);
  V remove(K);
  V set(K, V);
  V get(K);
  boolean contains(K);
  int getSize();
  boolean isEmpty();
}
```

> Due to having __Key-Value__ data type, more functions are able to be defined