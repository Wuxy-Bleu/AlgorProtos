package others.thread;


import java.util.concurrent.locks.*;

//两个线程 一个顺序循环输出1~26  一个顺序循环的输出a~z 并且要求单个交替的输出 1a2b3c....
//如何让两个线程交替运行呢
public class PrintInTurn {

    private static boolean flag = true;  //0 打印数字 1打印字幕

//    public static void main(String[] args) {
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true)
//                    for (int i = 1; i < 27; i++) {
//                        synchronized (this) {   //锁住的是当前的对象空间，
//                            if (!flag)
//                                try {
//                                    this.wait();
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//
//                            System.out.println("printNumber 输出" + i);
//                            flag = !flag;
//                            this.notify();
//
//                        }
//                    }
//            }
//        }, "printNumber").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true)
//                    for (int i = 0; i < 26; i++) {
//
//                        synchronized (this) {
//                            if (flag) {
//                                try {
//                                    this.wait();
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            System.out.println("print letter 输出" + (char) (i + 65));
//                            flag = !flag;
//                            this.notify();
//
//                        }
//                    }
//            }
//        }, "printletter").start();
//    }

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();

    private static int count = 0;

    public static void main(String[] arg) {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10000; i++) {
                        synchronized (this) {
                            this.notify();
                            this.wait();
                        }
                        count++;
                        System.out.println("t1 " + count);
                    }
                    synchronized (this) {
                        this.notify();
                    }
                } catch (Throwable e) {
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10000; i++) {
                        synchronized (this) {
                            this.notify();
                            this.wait();
                        }
                        count++;
                        System.out.println("t2 " + count);
                    }
                    synchronized (this) {
                        this.notify();
                    }
                } catch (Throwable e) {
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println("count: " + count);
    }

}
