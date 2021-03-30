package others.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest implements Runnable {

    private static int ticketNums = 10;

    public ThreadTest() {
    }

    public ThreadTest(int ticketNums) {
        this.ticketNums = ticketNums;
    }

    @Override
    public void run() {
        while (ticketNums > 0) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums + "张票");
            this.ticketNums--;
        }
    }
}

class RunTask implements Runnable {

    private int sharedNum = 0;

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                System.out.println(String.format("thread %s 执行第 %s 次 sharedNum = %s",
                        Thread.currentThread().getName(), i + 1, sharedNum++));
            }
        }
    }
}

class ThreadMain {
    public static void main(String[] args) {

        RunTask runTask = new RunTask();
        for (int i = 0; i < 4; i++) {
            new Thread(runTask, String.valueOf(i)).start();
        }

        System.out.println("main thread 。。。。。。。。。。。。。。。。。。。。。。。。");

    }
}
