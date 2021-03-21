package Algorithm.C2_sort;

import java.util.Arrays;

//这里的实现上有些问题，第一个就是归并排序实现Sort根本没有用
public class MergerSort implements Sort {

    private static int[] tmp;

    public void sortAscend(int[] arr) throws Exception {
        tmp = new int[arr.length];
/*        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }*/     //这个不能自作聪明在这里进行的，唉，想多了
        sortAscend(arr, 0, arr.length - 1);
    }

    //这个递归太难了，我看懂都花了很久啊
    private void sortAscend(int[] arr, int lo, int hi) {
        if (lo < hi) {
            sortAscend(arr, lo, (lo + hi) / 2);
            sortAscend(arr, (lo + hi) / 2 + 1, hi);
            merge(arr, lo, (lo + hi) / 2, hi);
        }
    }

    private void merge(int[] arr, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++)
            this.tmp[i] = arr[i];

        for (int i = lo, j = mid + 1, k = lo; i <= mid || j <= hi; k++)
            if (i > mid)
                arr[k] = this.tmp[j++];
            else if (j > hi)
                arr[k] = this.tmp[i++];
            else {
                if (this.tmp[i] >= this.tmp[j])
                    arr[k] = this.tmp[j++];
                else
                    arr[k] = this.tmp[i++];
            }
    }

    //将两个已经排好序的数组合并
    public Comparable[] merge(Comparable[] arr1, Comparable[] arr2) {
        Comparable[] mergedArr = new Comparable[arr1.length + arr2.length];
        for (int i = 0, index1 = 0, index2 = 0; i < mergedArr.length; i++) {
            if (index1 >= arr1.length) {
                mergedArr[i] = arr2[index2];
                index2++;
            } else if (index2 >= arr2.length) {
                mergedArr[i] = arr1[index1];
                index1++;
            } else {
                if (compare(arr1[index1], arr2[index2]) == -1) {
                    mergedArr[i] = arr1[index1];
                    index1++;
                } else {
                    mergedArr[i] = arr2[index2];
                    index2++;
                }
            }
        }
        return mergedArr;
    }

    @Override
    public void sortAscend(Comparable[] arr) throws Exception {

    }

    public static void main(String[] args) throws Exception {
        MergerSort sort = new MergerSort();

        int[] arr = {23, 112, 62, 21};
        sort.sortAscend(arr);
        sort.merge(arr, 0, 1, 2);
        System.out.println(Arrays.toString(arr));
    }
}