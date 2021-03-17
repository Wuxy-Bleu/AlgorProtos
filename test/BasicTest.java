import org.apache.logging.log4j.core.util.JsonUtils;
import org.junit.Test;
import others.FileIOTest;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class BasicTest {

    class Person implements Cloneable {

        String str = "123";

        Person() {
        }

        Person(String str) {
            this.str = str;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Person tmp = new Person();
            tmp.str = this.str;
            return tmp;
        }
    }

    class Me extends Person {
        Me() {
            super("123");
        }
    }

    private interface a {

    }


    @Test

    public void testObject() {
        Person object = new Person();
        Person clone = null;
        try {
            clone = (Person) object.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(object.str == clone.str);
    }

    @Test
    public void testString() {
        String str1 = "123";
        String str2 = "123";
        String str3 = new String("123");
        String str4 = new String("123");
        System.out.println(str1 == str2);
        System.out.println(str3 == str4);
        System.out.println(str1 == str3);

        String[] res = "12345".split("76");
    }

    @Test
    public void testArray() {


    }


    @Test
    public void testStream() {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");
        list.add("王力宏");
        list.add("陶喆");
        list.add("林俊杰");

        Stream<Integer> stream = list.stream()
                .filter(t -> t.toLowerCase() == "1")
                .map(String::length);
        stream.forEach(System.out::println);

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream() // 创建流
                .filter(s -> s.startsWith("c")) // 执行过滤，过滤出以 c 为前缀的字符串
                .map(String::toUpperCase) // 转换成大写
                .sorted() // 排序
                .forEach(System.out::println); // for 循环打印


    }


    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("执行线程1" + i);
            }

        }
    }

    @Test
    public void testThread() {

        MyThread thread = new MyThread();

        thread.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("执行主线程" + i);
        }

    }

    class MyThread2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println("执行线程2 " + i);
            }
        }
    }

    @Test
    public void testThread2() {
        new Thread(new MyThread2()).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("主线程 " + i);
        }
    }

    class SellTickets implements Runnable {
        private int ticketNums = 10;

        public SellTickets() {
        }

        public SellTickets(int ticketNums) {
            this.ticketNums = ticketNums;
        }

        @Override
        public synchronized void run() {
            while (ticketNums > 0) {

//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums + "张票");
            ticketNums--;
        }
    }


    @Test
    public void testThread3() {
        SellTickets sellTickets = new SellTickets(30);

        Thread thread = new Thread();

        new Thread(sellTickets, "小明").start();
        new Thread(sellTickets, "小红").start();
        new Thread(sellTickets, "小蓝").start();


        Thread.State state = thread.getState();

    }

    DateFormat dateFormat;

    @Test
    public void testDate() throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(new Date().toString() + Thread.currentThread().getState().toString());
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + Thread.currentThread().getState().toString());
                }
            }
        });
//        thread1.start();
//        thread1.join();

        System.out.println("main");

        new Thread(() -> {
            System.out.println(Calendar.getInstance().get(Calendar.MINUTE));   //工厂模式
        }).start();

        new Thread(() -> {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()).getTime() + 10000000));
        }).start();

        Thread.sleep(4000);


    }

}