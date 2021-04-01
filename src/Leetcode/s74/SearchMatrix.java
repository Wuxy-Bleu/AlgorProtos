package Leetcode.s74;

import java.util.Arrays;

/*编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。*/
public class SearchMatrix {

    //正好让我来实现一些简单的有序查找算法吗...
    public static boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        int hei = matrix.length;
        //先将二位数组平铺，一定得是矩阵
        int[] matr = new int[len * hei];
        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < len; j++) {
                matr[i * len + j] = matrix[i][j];
            }
        }
        //二分查找
        int left = 0;
        int right = len * hei - 1;
        boolean exist = false;
        //折半查找不可能left right相等，最终情况为  x x+1，
        // 这时候就会进入target是否 == left的判断，然后折半进入死循环
        while (left < right) {
            if (target < matr[(left + right) / 2])
                right = (left + right) / 2;
            else if (target == matr[(left + right) / 2]) {
                //最终情况等下 再折半还是取到left
                exist = true;
                break;
            } else if (left == (left + right) / 2)
                break;
            else
                left = (left + right) / 2;
        }
        if (matr[right] == target)
            exist = true;

        return exist;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 5}, {223, 4356, 314, 123}};
        System.out.println(searchMatrix(matrix, 3));
    }

}
