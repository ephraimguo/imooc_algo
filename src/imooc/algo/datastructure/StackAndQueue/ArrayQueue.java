package imooc.algo.datastructure.StackAndQueue;

public class ArrayQueue<E> implements Queue<E>{
    private DynamicArray<E> array;

    public ArrayQueue(int capacity) {
        this.array = new DynamicArray<>(capacity);
    }

    public ArrayQueue() {
        this.array = new DynamicArray<>();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    public int getCapacity() {
        return this.array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        this.array.addLast(e);
    }

    @Override
    public E dequeue() {
        return this.array.removeFirst();
    }

    @Override
    public E getFront() {
        return this.array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front -> [");
        for (int i = 0; i < this.array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != this.array.getSize()) {
                sb.append(',').append(' ');
            }
        }
        sb.append("] <- tail");
        return sb.toString();
    }
}
