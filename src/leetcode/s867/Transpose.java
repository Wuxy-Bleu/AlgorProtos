package leetcode.s867;

/*给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。*/

import java.util.Arrays;

//转置不一定是正方形的
public class Transpose {

    public static int[][] transpose(int[][] matrix) {
        int[][] newArr = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++)
            for (int j = 0; j < matrix.length; j++)
                newArr[i][j] = matrix[j][i];
        return newArr;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] transpose = transpose(matrix);
        for (int[] ele : transpose) {
            System.out.println(Arrays.toString(ele));
        }
    }
}
