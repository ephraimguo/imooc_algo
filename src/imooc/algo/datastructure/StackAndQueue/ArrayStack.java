package imooc.algo.datastructure.StackAndQueue;

public class ArrayStack<E> implements Stack<E> {
    DynamicArray<E> array;

    public ArrayStack(int capacity) {
        this.array = new DynamicArray<>(capacity);
    }

    public ArrayStack() {
        this.array = new DynamicArray<>();
    }

    @Override
    public void push(E e) {
        this.array.addLast(e);
    }

    @Override
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    public E peek() {
        return this.array.getLast();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public int getCapacity() {
        return this.array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append('[');
        for (int i = 0; i < this.array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != this.array.getSize()) {
                sb.append(',').append(' ');
            }
        }
        sb.append("] <- top");
        return sb.toString();
    }
}
