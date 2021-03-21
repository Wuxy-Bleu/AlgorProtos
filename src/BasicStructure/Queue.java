package BasicStructure;

//队列貌似也不需要被遍历啊
public interface Queue<T> /**extends Iterable<T>**/ {
    void enqueue(T item);

    T dequeue();

    boolean isEmpty();

    int size();
}
