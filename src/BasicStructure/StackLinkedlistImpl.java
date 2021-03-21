package BasicStructure;

//栈的链表实现，然后最重要的是，java中如何写链表呢，在其中写一个内部类node的方式，
//TODO 我感觉我下面的写法不如直接把链表提取出一个对象来，更方便啊。
public class StackLinkedlistImpl<T> implements Stack<T> {

    //头节点是空的，不存放任何数据。
    Node<T> head;
    //指向尾节点，为节点不为空，新增这个变量的话，代码很多地方需要修改了。getLastNode 这个方法直接不需要了
    Node<T> tail;

    public StackLinkedlistImpl() {
        //一开始实例化的栈，头节点为空，尾节点和头节点是同一个
        this.head = new Node<>();
        this.tail = this.head;
    }

    //这里是向后增加节点,这里使用的是尾插法
    @Override
    public void push(T item) {
        Node<T> newNode = new Node(item);
        this.tail.next = newNode;
        this.tail = newNode;
    }

    @Override
    public T pop() {
        //TODO　这是  内部类的私有成员变量也能访问到。
        T res = (T) this.tail.element;
        // 这怎么获取到尾节点的前一个节点啊？？直接循环遍历了
        Node<T> n = this.head;
        //感觉好蠢的代码啊...
        //TODO 在&&中 执行的顺序是什么，依次执行吗，如果不是的话，这句代码中，n.next为空，执行n.next.next会出现异常的。
        while (n.next != null && n.next.next != null)
            n = n.next;
        this.tail = n;
        this.tail.next = null;
        return res;
    }

    @Override
    public boolean isEmpty() {
        //TODO 这里有个老生常谈的问题，   java中，对象的比较，==和equals   什么时候比较地址，什么时候比较内容。
        return this.head == this.tail;
    }

    //获取长度比较麻烦，需要遍历整个链表。
    @Override
    public int size() {

        if (this.isEmpty() == true)
            return 0;
        else {
            int size = 0;
            for (Node<T> n = this.head; n.next != null; n = n.next)
                size++;
            return size;
        }
    }

    //这个是节点对象，其中的关键数据是泛型的
    //外部类可以访问到private内部类中的成员嘛。
    //TODO 即使内部类是private的，它所在的外部类也是可以实例化它的对象的，那么这个内部类对象中的各种private public成员都是可不可以访问的。
    //TODO 这是个单链表，接下去我要实现一个双向链表，会方便很多，能轻松获取到后一个节点和前一个节点。
    private class Node<T> {

        private Object element;
        private int index = -1;
        //这个在外部类可以访问到
        Node next = null;

        public Node() {
        }

        public Node(T item) {
            element = (Object) item;
        }
    }

//    //获取到尾节点，这里是private的，因为有pop这个函数可以获取到尾节点了。
//    //　但是pop和这个方法不就重复了，但是push之后调用pop又让我感觉不太对...
//    // 不一样，返回值不一样，但是还是让我感觉有点重复。   可以在搞个成员变量，指向尾节点。
//    private Node<T> getLastNode() {
//        Node<T> n = this.head;
//        while (n.next != null) {
//            n = n.next;
//        }
//        return n;
//    }
}
