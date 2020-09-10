package imooc.algo.datastructure.StackAndQueue;

import java.util.Iterator;
import java.util.Stack;

public class ImplementQueueByStack<E> {
    private Stack<E> loader;
    private Stack<E> container;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueByStack() {
        this.loader = new Stack<>();
        this.container = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(E x) {
        this.loader.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public E pop() {
        while (this.loader.iterator().hasNext()) {
            this.container.push(this.loader.iterator().next());
        }

        return this.container.pop();
    }

    /**
     * Get the front element.
     */
    public E peek() {
        while (this.loader.iterator().hasNext()) {
            this.container.push(this.loader.iterator().next());
        }

        return this.container.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        while (this.loader.iterator().hasNext()) {
            this.container.push(this.loader.iterator().next());
        }

        return this.loader.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            s.push(i);
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

}
