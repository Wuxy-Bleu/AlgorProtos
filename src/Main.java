import basicStructure.*;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BagV1 bag = new BagV1();
        //数组的两种初始化方式，还有第三种指定长度，由jvm默认初始化 int[] arr = new int[5];
        //这种最基础的东西就不需要每次都写了
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 0};

        BagV1 bag2 = new BagV1(arr);
        BagV1 bag3 = new BagV1(arr2, arr2.length);

        int[] arr3 = {1, 2, 3};
        BagV1 bag4 = new BagV1(arr3);
        int[] arr4 = {1, 2, 3, 4, 5, 6};
        BagV1 bag5 = new BagV1(arr4);

        System.out.println(bag);

        bag.add(100);
        bag.add(200);
        bag.add(300);
        bag.add(arr);
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());
    }
}

//哇 怎么在这儿使用测试类啊，每次都需要新写一个类，新写一个main方法太蠢了
class testBagObj {
    public static void main(String[] args) {
        BagObj bag = new BagObj();
        Object o = bag.get(1);
        //测试初始化
        Integer[] arr2 = {1, 2, 3, 4, 5, 6};
        BagObj bag2 = new BagObj(arr2);
        BagObj bag3 = new BagObj(arr2, arr2.length);
        //测试插入不同类型的数组
        Double[] arr3 = {1.2, 3.2, 42.1, 42.6};
        String[] arr4 = {"2334", "gsf", "gesrfg"};
        //int[]会被视为一个对象传入
        int[] arr = {1, 2, 3, 4, 5, 6, 0};
        bag.add(arr);

        bag.add(100);  //自动装箱
        bag.add(new Object());
        bag.add(new BagObj());
        //Integer数组   Double数组  String数组  null都没问题
        bag.add(arr2);
        bag.add(arr3);
        bag.add(arr4);
//        bag.add(null);   这个会报错
        bag.add(new Object[]{"fasdf", null, new int[]{1, 2, 3, 4}, new HashMap<String, String>(1)});
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());

        System.out.println(bag.get(18));
    }
}

class TestBagIterator {
    public static void main(String[] args) {
        //测试三个初始化
        BagWithIterable bag = new BagWithIterable();
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        BagWithIterable bag2 = new BagWithIterable(arr);
        BagWithIterable bag3 = new BagWithIterable(arr, arr.length);
        //测试add
        bag.add(new Object[]{1, "234", new int[]{1, 2, 3, 4}, new Integer[]{12, 54, 64}, null, new Object()});
        bag.add(arr);
        //测试其他方法
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());
        System.out.println(bag.get(2));
        System.out.println(bag.get(3));
        System.out.println(bag.get(4));
        //测试迭代器foreach
        for (Object o : bag) {
            System.out.println(o);
        }
        //测试迭代器的逻辑是否正确
        Iterator<Object> iterator = bag.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class TestBagGeneric {
    public static void main(String[] args) {
        //BagGeneric<Integer> bag = new BagGeneric();
        //BagGeneric bag = new BagGeneric<Integer>();
        //BagGeneric bag = new BagGeneric();
        //TODO  竟然这三种写法都不会报错，前两种我还能理解，但是最后一种，这不是很奇怪吗...
        //所以说泛型仅仅是一个类型检查罢了吗？？
        BagGeneric<Integer> bag = new BagGeneric<Integer>();
        BagGeneric<String> bag2 = new BagGeneric<String>(new String[]{"a", "b", "c", "d"});
        //测试add
        bag.add(123);
        bag.add(345);
        bag.add(new Integer[]{111, 222});
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());
        System.out.println(bag.get(3));
        //测试迭代器
        for (Integer o : bag) {
            System.out.println(o);
        }
        Iterator iterator = bag.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}

class TestStackArr {
    public static void main(String[] args) {
        Stack<String> stack = new StackArrImpl<>();
        stack.push("1");
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.push("2");
        stack.push("3");
        stack.push("gheshdnvskf");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}

class testStackLinked {
    public static void main(String[] args) {
        Stack<String> stack = new StackLinkedlistImpl<>();
        System.out.println(stack.isEmpty());
        stack.push("hfjkasd");
        stack.push("1111");
        stack.push("2222");
        stack.push("33333");
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}

class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedListImpl<>();
        list.insertToTail("123");
        list.insertToTail("456");
        list.insertToTail("789");

        LinkedList<String> list2 = new LinkedListImpl<>();
        System.out.println(list2.size());
        System.out.println(list2.isEmpty());
        list2.insertToHead("111");
        list2.insertToHead("222");
        list2.insertToHead("333");
        System.out.println(list2.size());
        System.out.println(list2.isEmpty());
        list2.insertToTail("44444");
        list2.insertToTail("55555");
        list2.insertToTail("66666");
        list2.insertToHead("asdfav");
        list2.insertToTail("bbbbbbbbbbbbbb");
        System.out.println(list2.size());
        System.out.println(list2.get(1));
        System.out.println(list2.get(4));
        System.out.println(list2.get(100));


        list2.insert("qwe", 0);
        list2.insert("asd", 1);
        list2.insert("zxc", 5);
        list2.insert("rty", 54);
        System.out.println("=======================================================");

        for (String l : list2) {
            System.out.println(l);
        }

        list2.delNode(0);
        list2.delNode(1);
        list2.delNode(6);
        list2.delNode(100);
        System.out.println("=======================================================");
        for (String l : list2) {
            System.out.println(l);
        }

    }
}

class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new QueueImpl<>();
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.enqueue("11111");
        queue.enqueue("222222");
        queue.enqueue("3333333");
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }
}

class TestWatch {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();

        int res = 0;
        for (int i = 0; i < 100000000; i++)
            res += i;
        System.out.println(watch.period());
    }
}