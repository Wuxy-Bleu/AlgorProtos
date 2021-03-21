package Algorithm.C2_sort;


//插入排序   一个动图 https://www.runoob.com/w3cnote/insertion-sort.html
public class InsertionSort extends SortAbstract {


    @Override
    public void sort(Comparable[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && -1 == compare(arr[j], arr[j - 1]); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }

    public void sort02(Comparable[] arr) {
        int N = arr.length;
    }
}
