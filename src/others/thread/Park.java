package others.thread;

//假设车库有3个车位 可以停车，写一个程序模拟多个用户开车离开，停车入库的效果。注意：车位有车时不能停车


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

//车位，可以停进来，可以开出去
public class Park {

    //每一个车库有个名字
    public String parkName = "default park";

    //车位, 元素是车主的名字
    private String[] space = new String[1000];
    private int flag = -1; //标志位，车位还剩几个

    ReentrantLock lock = new ReentrantLock();

    public Park() {

        //初始车位都是空的
//        for (int i = 0; i < 3; i++) {
//            space[i] = null;
//        }
    }

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public void add() {
        lock.lock();
        try {
            if (flag == space.length - 1)
                System.out.println(Thread.currentThread().getName() + "  停满了，请等待有车开出去");
            else {
                System.out.println("___________________" + Thread.currentThread().getName() + " 停第" + (flag + 1) + "车位");
                space[++flag] = Thread.currentThread().getName();
            }
        } finally {
            lock.unlock();
        }
    }

    public String remove() {
        lock.lock();
        try {
            if (flag == -1) {
                System.out.println(Thread.currentThread().getName() + " 没有车，请停车进来");
                return null;
            } else {
                System.out.println("___________________" + Thread.currentThread().getName() + " 开出去第" + flag + "车位的车");
                String car = space[flag];
                space[flag] = null;
                flag--;
                return car;
            }
        } finally {
            lock.unlock();
        }
    }
}

//这是用户，搞多个用户，每个用户要么不停 停车，要么不停开车出来
class Custom implements Runnable {

    private Park park;

    public Custom(Park park) {
        this.park = park;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            park.add();
        }
    }
}

class CarSolution {
    public static void main(String[] args) {

        Park park = new Park();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //一个人不停开车进来
                for (int i = 0; i < 1000; i++) {
                    park.add();
                }
            }
        }, "小明").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //一个人不停开车进来
                for (int i = 0; i < 1000; i++) {
                    park.add();
                }
            }
        }, "小张").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                //一个人不停 开车出去
                for (int i = 0; i < 1000; i++) {
                    park.remove();
                }
            }
        }, "小红").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                //一个人不停 开车出去
                for (int i = 0; i < 1000; i++) {
                    park.remove();
                }
            }
        }, "小王").start();

        System.out.println(Thread.currentThread().getName());
    }
}
