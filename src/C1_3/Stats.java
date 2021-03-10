package C1_3;

import basicStructure.Bag;
import basicStructure.BagGeneric;
import basicStructure.BagWithIterable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

//p77  用Bag实现计算所有标准输入console 中所有double值的平均值
//TODO 最主要的是学习，java读取标准输入流
public class Stats {

    public static void main(String[] args) {

        BagGeneric<Double> bag = new BagGeneric<>();
        InputStream in = System.in;
//        try {
//            //System.in.read()   每次返回一个字节，而且回车才会刷新流，所以每次都会把回车的ascii码也返回了
//            // 很不方便的方式
//            while (true) {
//                int read = in.read();
//                System.out.println(read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //这个就会好用很多了，Scanner类将标准输入流封装了，每次返回一行，且自动删去行末的回车字符，返回的是String
        Scanner scanner = new Scanner(in);
        System.out.println("请输入需要计算的值，以空格分隔，回车结束");
        //循环 读取一行的数字并计算平均值
        while (scanner.hasNextLine()) {
            String res = scanner.nextLine();
            //TODO 这个是java的正则表达式，这个需要去学一下，split以一个或多个空格分隔字符串
            String[] str = res.split("\\s+");
            for (String s : str) {
                bag.add(Double.valueOf(s));
            }
            //计算平均值，这里我还不如直接给bag的实现加一个相加的方法
            Double sum = 0.0;
            for (Double b : bag) {
                sum += b;
            }
            System.out.println(sum / bag.size());
        }
    }
}

