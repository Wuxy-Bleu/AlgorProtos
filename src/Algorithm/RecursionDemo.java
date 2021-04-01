package Algorithm;

import BasicStructure.Stack;
import BasicStructure.StackArrImpl;
import utils.SmallUtils;

//写些简单的递归算法
public class RecursionDemo {

    //1加到100的递归代码
    public static int addTo(int n) {
        if (n == 1) {
            return 1;
        } else {
            return addTo(n - 1) + n;
        }
    }

    //递归生成一个值== 索引的Int数组
    //n从0开始
//    public static int[] generArr(int n) {
//        int[] arr = new int[100];
//        if (n == 100)
//            return arr;
//        else {
//            arr[n] = n;
//            generArr(++n);
//        }
//        return arr;
//    }

    //得到一个数组的最大值，先用基本类型简单数组测试
    //在递归方法中最好不要声明局部变量？？？？？  不一定
    //参数是数组左右两边的索引，但是一定是0和arr.length-1啊
    public static int maxInArr(int[] arr, int l, int n) {
        if (l == n)
            return arr[n];
        else {
            int a = arr[l];
            int b = maxInArr(arr, l + 1, n);
            if (a > b)
                return a;
            else
                return b;
        }
    }

    //fibonacci数列  输出 这个我倒是写出来了 这个比较简单
    //i j是数列开头的两个数
    public static void fibonacci(int i, int j, int n) {
        //可是怎么输出第一次进去的两个1呢？？？  暂时没办法
//        System.out.println(i);
//        System.out.println(j);
        if (n > 0) {
            System.out.println(i + j);
            fibonacci(j, i + j, n - 1);
        }
    }

    //hanoi 汉诺塔算法
    public static void hanoi() {
        //这个玩意用递归做有些奇怪吧
        // https://www.bilibili.com/video/BV1rs411Y76X/?spm_id_from=333.788.recommend_more_video.0
        //网上有用二进制来做的
    }

    //倒序输出一个正整数  12345 => 54321  这个感觉用栈来做更好啊
    //非递归的算法
    public static void reversePrint(int n) {
        //关于泛型的写法，前后都加上<>，还有泛型不可以是基本类型，
        //todo 泛型的raw use
        Stack<Integer> nums = new StackArrImpl<>();

        //这里的实现感觉不是很好，先全部整除了一遍得到位数，接下来再重新循环整除
        //卧槽 用取余啊.... 真的蠢
        int numOfDigits = SmallUtils.numOfDigits(n);
        numOfDigits--; /*平方的次数应该是位数-1*/
        while (numOfDigits >= 0) {
            int firstNumber = n / (int) Math.pow(10, numOfDigits);
            nums.push(firstNumber);
            n -= Math.pow(10, numOfDigits) * firstNumber;
            numOfDigits--;
        }
        //向上转型 todo 这里注意一个问题，接口 = new 实现类 接口是无法调用实现类特有的方法的
        //但是这里如果 接口调用的是实现类的继承的object的方法，比如这里的toString(), 就是可以调用的，因为interface继承于Object吧
        //但是没法直接在接口中重写这个toString 而是每一个实现类都得重写toString
//        System.out.println(nums.toString());

        //todo 在这里，如何设计终止条件啊 不可能通过异常来判断吧...
        while (true) {
            System.out.print(nums.pop());
        }
    }

    //如何利用递归来实现呢
    //递归的方法的话，如何判断一个正整数是否合法啊
    //得另外在搞个方法主要写递归吧，这里来调用那个递归方法。
    public static void reversePrintWithRecur(int n) {
        if (n > 0) {
            System.out.println(n % 10);
            reversePrintWithRecur(n / 10);
        }
    }

    //输入一个字符串，打印出该字符串中字符的所有排列。
    // 例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
    static public void arrangeSort(char[] chars, int begin, int length) {
        //首先先要从字符串中拿到所有的单个字符
        //然后其实就是排列组合罢了，但是这个也太复杂了,我自己想不出来啊

        if (begin == length - 1) {//输出这个排列
            for (int i = 0; i < length; i++) {
                System.out.print(chars[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = begin; i < length; i++) {
                char tmp = chars[i];
                chars[i] = chars[begin];
                chars[begin] = tmp;//一次挑选n个字母中的一个,和前位置替换
                arrangeSort(chars, begin + 1, length);                      //再对其余的n-1个字母一次挑选
                tmp = chars[i];
                chars[i] = chars[begin];
                chars[begin] = tmp;    //再换回来
            }
        }
        //todo 这种算法的实现没有考虑到 如果包含相同的元素，如何排除掉
    }

    public static void main(String[] args) {
//        System.out.println(addTo(100));
//        System.out.println(maxInArr(new int[]{1, 213, 3, 4, 34, 6, 6, 7}, 0, 7));
//        fibonacci(1, 1, 34);
//        reversePrint(123456);
//        System.out.println(SmallUtils.numOfDigits(17234895));
//        reversePrintWithRecur(123);
//        System.out.println(01234);
        char[] chars = "./;][".toCharArray();
        arrangeSort(chars, 0, chars.length);
    }


}
