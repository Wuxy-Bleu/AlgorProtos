package Algorithm.C3_Search;

import utils.SmallUtils;

import java.util.Arrays;

public class BinarySearch {

    public static boolean search(int[] arr, int target) {
        //二分查找
        int left = 0;
        int right = arr.length - 1;
        boolean exist = false;
        //折半查找不可能left right相等，最终情况为  x x+1，
        // 这时候就会进入target是否 == left的判断，然后折半进入死循环
        while (left < right) {
            if (target < arr[(left + right) / 2])
                right = (left + right) / 2;
            else if (target == arr[(left + right) / 2]) {
                //最终情况等下 再折半还是取到left
                exist = true;
                break;
            } else if (left == (left + right) / 2)
                break;
            else
                left = (left + right) / 2;
        }
        if (arr[right] == target)
            exist = true;

        return exist;
    }

    //比上面自己写的稍微优化，返回target在数组中的位置，如果不存在返回-1
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > arr[mid])
                left = mid + 1;
            else if (target == arr[mid])
                return mid;
            else
                right = mid - 1;
        }
        return -1;
    }

    //递归的二分查找，写不出来
    public static boolean  searchRecursion(int[] arr, int left, int right, int target) {
        if (left != (left + right) / 2)
            if (target < arr[(left + right) / 2])
                searchRecursion(arr, 0, (0 + arr.length - 1) / 2, target);

        return true;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 74, 674, 8756, 76666};
        int i = binarySearch(ints, 76666);
        System.out.println(i);
    }
}
