package BasicStructure;

//所有的方法都是public的
//TODO  链表该操作节点还是节点中的实际数据呢。  在外部看来肯定是操作数据了。   内部可以有些私有方法操作节点。
public interface LinkedList<T> extends Iterable<T>{

    public int size();

    public boolean isEmpty();

    //插入到index节点之后  头节点index为0
    public boolean insert(T item, int index);

    //尾插法
    public void insertToTail(T item);
    //头插法
    public void insertToHead(T item);

    public T get(int index);

    public boolean delNode(int index);
}
