package Algorithm.C2_sort;

public class SelectionSort implements Sort {
    //这里数组传进去操作之后，返回后改变会保留下来嘛
    //TODO 更改保留下来了，见testSelection_01的测试方法中的结果，关于java值传递和引用传递之后在慢慢学习
    @Override
    public void sortAscend(Comparable[] arr) {
        int N = arr.length;
        int min;

        for (int i = 0; i < N; i++) {
            min = i;
            for (int j = i + 1; j < N; j++) {
                if (compare(arr[min], arr[j]) == 1)
                    min = j;
            }
            exchange(arr, min, i);
        }
    }
}
