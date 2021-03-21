package BasicStructure;

//队列是先进先出的，
public class QueueImpl<T> implements Queue<T> {

    LinkedList<T> elements = null;

    public QueueImpl() {
        this.elements = new LinkedListImpl<>();
    }

    //入队列
    @Override
    public void enqueue(T item) {
        elements.insertToTail(item);
    }

    //出队列
    @Override
    public T dequeue() {
        T res = elements.get(1);
        elements.delNode(1);
        return res;
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }
}
