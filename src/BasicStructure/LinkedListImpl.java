package BasicStructure;

import java.util.Iterator;

//TODO　其实有没有必要搞一个为空的头节点啊，尾节点就不是空的啊
//双向链表
public class LinkedListImpl<T> implements LinkedList<T> {

    Node<T> head;
    //尾节点这个指针暂时的用处也不大
    Node<T> tail;

    int size = 0; //有必要在链表内部维护一个size都需要调用有点麻烦

    public LinkedListImpl() {
        this.head = this.tail = new Node<>();
    }

    @Override
    public int size() {
        int index = 0;
        for (Node<T> n = this.head; n.next != null; n = n.next)
            index++;
        return index;
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    //插入到index节点之后  头节点index为0
    //每次插入得获取插入位置的前后两个节点
    @Override
    public boolean insert(T item, int index) {
        //如果Index超过范围insert当然失败了
        if (index > this.size() || index < 0)
            return false;
        //如果index=0 插入到头节点之后，直接头插法
        if (index == 0) {
            this.insertToHead(item);
            return true;
        }
        //如果index是最后一个节点，直接尾插法
        if (index == this.size()) {
            this.insertToTail(item);
            return true;
        }
        //剩下的只有在链表节点之间插入了 获取到的Node不可能为null
        Node<T> nodeBefore = this.getNode(index);
        Node<T> nodeAfter = this.getNode(index + 1);
        Node<T> newNode = new Node<>(item);

        newNode.previous = nodeBefore;
        newNode.next = nodeAfter;
        nodeBefore.next = newNode;
        nodeAfter.previous = newNode;
        return true;

    }

    //尾插法
    @Override
    public void insertToTail(T item) {
        Node<T> newNode = new Node<>(item);
        this.tail.next = newNode;
        newNode.previous = this.tail;
        this.tail = newNode;
    }

    //头插法
    @Override
    public void insertToHead(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.previous = this.head;
        newNode.next = this.head.next;
        //如果这是创建的第一个节点
        if (this.tail.element == null)
            this.tail = newNode;
        else {
            this.head.next.previous = newNode;
        }
        this.head.next = newNode;
    }


    //这个返回的是node中的元素，如果index超过范围，返回null,头节点为0
    @Override
    public T get(int index) {
        if (this.getNode(index) != null)
            return (T) this.getNode(index).element;
        else
            return null;
    }

    //这个直接返回node，如果index超过范围，返回null,最好是抛出异常啊
    private Node<T> getNode(int index) {

        if (index > this.size() || index < 0)
            return null;
        else if (index == 0)
            return this.head;
        else {
            Node<T> node = this.head;
            int flag = 0;
            while (node.next != null && flag != index) {
                node = node.next;
                flag++;
            }
            return node;
        }
    }

    //删除某一个节点,头节点为0，无法删除
    //删除插入操作
    @Override
    public boolean delNode(int index) {
        //如果Index超过范围或者想要删除头节点  del失败
        if (index > this.size() || index <= 0)
            return false;
        else if (index == this.size()) {
            //如果删除的是尾节点
            Node<T> del = getNode(index);
            Node<T> delBefore = getNode(index - 1);
            //jvm的垃圾回收机制，如果这个对象已经无法通过任何引用获得了，但是它本身内部还有个引用指向了另一个不会被回收的对象
            // ，这种情况会怎么样，就比如下面的情况下。
            delBefore.next = null;
            del.previous = null;
            this.tail = delBefore;
            return true;
        } else {
            Node<T> del = getNode(index);
            Node<T> delBefore = getNode(index - 1);
            Node<T> delAfter = getNode(index + 1);
            del.previous = del.next = null;
            delBefore.next = delAfter;
            delAfter.previous = delBefore;
            return true;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    //内部类，节点
    private class Node<T> {

        private Object element;
        private Node<T> previous;
        private Node<T> next;

        public Node() {
            this.element = null;
            //虽说是双向链表，但是我这个向前的指针没啥用处啊...
            // 之后再慢慢开发它的作用吧
            this.previous = null;
            this.next = null;
        }

        public Node(T element) {
            this.element = element;
        }
    }

    //内部类 迭代器
    //TODO 两个内部类之间的相互访问情况
    //TODO 内部类 外部类 初始化顺序和一些其他情况
    private class LinkedListIterator implements Iterator<T> {

        //TODO 为什么这个初始化不行啊，head是LinkedListImpl这个外部类的一个成员变量，只不过
        // 它是在构造器中初始化的，是不是因为内部类外部类初始化顺序的缘故导致的，但即使是那样，也不应该编辑器直接报错啊。
        //猜测应该是对泛型理解的错误，head虽然是Node<T>
        //TODO 或者说 我声明了两个Node<T>对象， 因为T不确定，所以这两个对象是没办法相互转换的，即使是强转也不安全
        //不懂，这里的问题大了
        //报错   Node<T> n = LinkedListImpl.this.head;
        //Object n = LinkedListImpl.this.head;  // 用Object装这个对象也不好，node中的next变量直接访问不到了
        //Node<T> n = (Node<T>) LinkedListImpl.this.head;  //最终解决办法，就是看起来很奇怪。

        //TODO 或者将LinkedListIterator<T>的泛型去掉就可以了  改为LinkedListIterator
        // 的确啊，迭代器的内部类的泛型也没啥用啊，泛型学的还不行,
        // 或者说 泛型是对整个class生效的，如果外部类声明了泛型，内部类就不需要声明了，注意了！！！
        Node<T> n = LinkedListImpl.this.head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            T element = (T) n.next.element;
            n = n.next;
            return element;
        }
        //TODO  对于迭代器的理解也还不够，foreach()中写的是 T item:LinkedListImpl某个实例
        // 而不是 LinkedListImpl<T> item:LinkedListImpl某个实例，
        // 这个东西和next的返回值是一致的
        // 还有对于迭代器的next方法了，把它理解为循环啊，循环中的指针每次循环要指向下一个啊，别忘了。
    }
}
