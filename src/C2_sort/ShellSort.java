package C2_sort;

//希尔排序  递增序列为  N/2 (N/2)/2 ...  1
public class ShellSort implements Sort {
    @Override
    public void sortAscend(Comparable[] arr) throws Exception {
        //类中的方法中使用final，很少自己主动的使用final static 试一下
        final int N = arr.length;
        int h = N / 2;
        while (h != 0) {
            for (int i = h; i < N; i++) {
                for (int j = i; j - h >= 0 && compare(arr[j], arr[j - h]) == -1; j -= h) {
                    System.out.println(j);
                    exchange(arr, j, j - h);
                }
            }
            h /= 2;
        }
    }
}

//总算搞定了希尔排序，但是我的递增序列是比较简单的，数组长度不断/2 但是算法书上的递增序列为啥是那样子的？？？
//p163 这个就是我暂时不能理解的了
//递增数列的选择难道是这个算法的难点所在吗