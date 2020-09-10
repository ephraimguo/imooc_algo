package imooc.algo.datastructure.StackAndQueue;

public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void enqueue(E e) {
        if ((this.tail + 1) % this.data.length == front) {
            this.resize(this.getCapacity() * 2);
        }

        this.data[tail] = e;
        this.tail = (this.tail + 1) % this.data.length;
        this.size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < this.size; i++) {
            newData[i] = data[(i + this.front) % data.length];
        }

        this.data = newData;
        this.front = 0;
        this.tail = this.size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }

        E ret = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front + 1) % this.data.length;
        this.size--;

        if (size == this.getCapacity() / 4 && this.getCapacity() / 2 != 0) {
            this.resize(this.getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return this.data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size: %d, capacity: %d\n", this.size, this.getCapacity()));
        sb.append("front -> [");
        for (int i = front; i != tail; i = (i + 1) % this.data.length) {
            sb.append(this.data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(',').append(' ');
            }
        }
        sb.append("] <- tail");
        return sb.toString();
    }
}
