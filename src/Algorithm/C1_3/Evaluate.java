package Algorithm.C1_3;

import BasicStructure.Stack;
import BasicStructure.StackLinkedlistImpl;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//p80 双栈计算表达式求值
//表达式从文件中读取。
public class Evaluate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = readFileLine("D:\\test.txt");

        System.out.println(cal(readFileLine("D:\\test.txt").split("\\s+")));

        while (scanner.hasNextLine()) {
            //TODO 这里导致了写表达式的时候 每个词都必须用空格隔开 1+1算不出来 1 + 1才能算 ...这怎么办啊
            //就算是两个括号之间都必须有空格，而且末尾一定要有个) 要不然还算不出来。这里要搞下去太复杂了
            String[] str = scanner.nextLine().split("\\s+");
            //这和C++不一样了，main方法只能直接调用一个静态方法了,没办法调用成员方法
            Double cal = cal(str);
            System.out.println(cal);
        }
    }

    //我这里就感觉很不舒服，为了main中测试这个方法而设为static的，但是其实这个方法没必要是static的，
    // 因为static作为全局的方法，但这个方法其他地方用不到，
    // 但是不作为静态方法，main中调用就需要实例化一个对象再调用，都在一个类中，还需要这个操作就让我很不舒服
    public static Double cal(String[] str) {
        Stack<Double> nums = new StackLinkedlistImpl<>();
        Stack<String> operators = new StackLinkedlistImpl<>();

        //TODO 关于Java的正则表达式的部分  Pattern Matcher要去学习了
        //TODO 关于Java判断一个字符串是数字有很多方法，可以自己思考下
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        Matcher matcher = null;
        //循环遍历每一个字符串
        for (String s : str) {
            matcher = pattern.matcher(s);
            //如果字符串是数字的话，直接压栈
            if (matcher.matches())
                nums.push(Double.valueOf(s));
                //如果不是数字，做一系列操作
            else {
                //这里只是为了体验下switch，其实这里if也可以的。
                switch (s) {
                    case "(":
                        break;
                    case "+":
                    case "-":
                    case "*":
                        operators.push(s);
                        break;
                    case ")":
                        double n1 = nums.pop();
                        double n2 = nums.pop();
                        String opera = operators.pop();
                        if (opera.equals("+"))
                            nums.push(n1 + n2);
                        if (opera.equals("-"))
                            nums.push(n2 - n1);
                        if (opera.equals("*"))
                            nums.push(n1 * n2);
                    default:
                        break;
                }
            }
        }
        return nums.pop();
    }

    //TODO  Java的IO学的很不好啊
    //利用BufferedReader.readLine每次从文件中读取一行数据
    public static String readFileLine(String filePath) {
        File file = new File(filePath);
        String res = null;
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
//                String lineContent = null;
//                while ((lineContent = br.readLine()) != null) {
//                    System.out.println(lineContent);
//                }
//                res = br.readLine();
                br.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("no this file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("io exception");
                e.printStackTrace();
            }
        }
        return res;
    }
}


