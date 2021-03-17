package others.thread;

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

class ThreadMain {
    public static void main(String[] args) {
        ThreadTest runnable = new ThreadTest(30);
        new Thread(runnable, "david").start();
        new Thread(runnable, "nacy").start();
        new Thread(runnable, "mike").start();

        new Thread(runnable, "john").start();

        System.out.println("nihao");

    }
}
