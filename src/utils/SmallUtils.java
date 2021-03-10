package utils;

public class SmallUtils {

    //得到一个int正整数的位数
    public static int numOfDigits(int n) {
        //todo 这里比较麻烦的是去判断传入的数字在int的正整数范围内
        int nums = 0;
        for (int i = n; i / 10 != 0; i /= 10)
            nums++;
        return nums + 1; /*再加一个个数位*/
    }

/*    //从一个字符串中拿到所有的单个字符  没必要，java se存在相关方法
    static public char[] getCharsFromString(String string) {

    }*/




}
