import C2_sort.*;
import leetcode.s27.RemoveElement;
import utils.ArrUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AlgorTest {


    //这里对于泛型的运用越加的熟练了  将这个测试用的MyDate类作为内部类，而且还是public的内部类
    public class MyDate implements Comparable<MyDate> {

        private int year;
        private int month;
        private int day;

        @Override
        public String toString() {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}';
        }

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        //如果this > o  1  , =  0  , <  -1
        //TODO ?? 为什么这里o能拿到它的私有成员啊？？？
        @Override
        public int compareTo(MyDate o) {
            if (this.year > o.year)
                return 1;
            else if (this.year == o.year) {
                if (this.month > o.month)
                    return 1;
                else if (this.month == o.month) {
                    if (this.day > o.day)
                        return 1;
                    else if (this.day == o.day)
                        return 0;
                    else
                        return -1;
                } else
                    return -1;
            } else
                return -1;
        }
    }

    private MyDate[] date = new MyDate[]{new MyDate(43, 2, 3), new MyDate(4, 2, 335), new MyDate(4, 2, 3),
            new MyDate(1, 2, 3), new MyDate(1, 4, 1),
            new MyDate(6, 2, 3), new MyDate(6, 2, 3)};

    //todo 如何生成随机的int数组，还有int数组有实现comparable接口吗
    //基本类型的数组没有实现comparable接口，改为用包装类

    private Double[] doubleRandomArr = new Double[3];

    public AlgorTest() {
/*        //这个玩意有没有直接生成数组，还需要搞个构造器编译赋值
        //可以搞个工具类
        for (Double ele : doubleRandomArr) {
            //Java还有一个Random对象，功能更强
            ele = Math.random();
        }*/
        for (int i = 0; i < doubleRandomArr.length; i++) {
            doubleRandomArr[i] = Math.random();
        }
    }

    @org.junit.Test
    public void testSelection_01() {
        Sort s = new SelectionSort();
//        s.sortAscend(date);
        s.showArr(date);
    }

    @org.junit.Test
    public void testInsertion02() {
        SortAbstract sort = new InsertionSort();
        sort.sort(date);
        sort.show(date);
    }

    //TODO 为何内部类都被推荐为static
    class SortImpl implements Sort {

        @Override
        public void sortAscend(Comparable[] arr) throws Exception {
            System.out.println("fjalsdkgalhfslg");
            throw new Exception("jjjjjj");
        }
    }

    @org.junit.Test
    public void testException01() {
        Sort sort = new SortImpl();
        try {

            MyDate[] arr = {
                    new MyDate(43, 2, 3), new MyDate(4, 2, 335), new MyDate(4, 2, 3),
                    new MyDate(1, 2, 3), new MyDate(1, 4, 1),
                    new MyDate(6, 2, 3)
            };
//            sort.sortAscend
            sort.exchange(arr, 1, 20);

            sort.compare(arr[100], arr[10]);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        } finally {
            System.out.println("---- finally 一定会被执行");
        }
    }

    @org.junit.Test
    public void testShellSort01() {

        System.out.println(1 / 2);

        Sort shellSort = new ShellSort();
        try {
            ArrUtils.printArr(doubleRandomArr);
            shellSort.sortAscend(doubleRandomArr);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            shellSort.sortAscend(date);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        shellSort.showArr(doubleRandomArr);
    }

    @org.junit.Test
    public void testMergeSort() {
        MergerSort mergeSort = new MergerSort();
        Comparable[] merge = mergeSort.merge(
                new Integer[]{1, 12, 4, 789, 2, 6, 4, 5, 5},
                new Integer[]{2, 4, 5, 7, 8, 13243, 53});
        ArrUtils.printArr(merge);
    }

    @org.junit.Test
    public void test_leetcode27() {
        int[] arr = new int[]{
                1, 2, 3, 4, 5, 1, 1, 1, 1, 1, 1
        };
        int i = RemoveElement.removeElement(arr, 1);
        System.out.println(i + " " + Arrays.toString(arr));

    }

    @org.junit.Test
    public void test_mergedSort() throws Exception {
        MergerSort sort = new MergerSort();

        int[] arr = {112, 23, 62, 21, 5, 6, 2, 532, 534, 4, 5, 5, 5, 23, 7, 8, 9};
        sort.sortAscend(arr);
        System.out.println(Arrays.toString(arr));
    }

    @org.junit.Test
    public void test_isSorted() {
        Integer[] arr = {3, 2, 1};
        System.out.println(Sort.isSorted(arr));
    }

}
