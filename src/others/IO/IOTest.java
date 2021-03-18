package others.IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class IOTest {

    private static String fileAddr = "C:\\Users\\matte\\Desktop\\请求报文.txt";

    public static void main(String[] args) throws InterruptedException {
//        readTest2();
//        writeTest();

        try {
            consoleRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] intToBytes(int value) {
        byte[] src = new byte[4];
        src[3] = (byte) ((value >> 24) & 0xFF);
        src[2] = (byte) ((value >> 16) & 0xFF);
        src[1] = (byte) ((value >> 8) & 0xFF);
        src[0] = (byte) (value & 0xFF);
        return src;
    }

    public static void readTest() {

        InputStream fileIn = null;
        try {
            fileIn = new FileInputStream(fileAddr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            for (; ; ) {
                int n = fileIn.read(); // 反复调用read()方法，直到返回-1
                if (n == -1) {
                    break;
                }
                System.out.println(new String(intToBytes(n), StandardCharsets.UTF_8)); // 打印byte的值
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileIn != null) {
                try {
                    fileIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readTest2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File("C:\\Users\\matte\\Desktop\\QQ图片20200929153630.png");
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                byte[] chars = new byte[100];

                try {
                    while (true) {
                        int res = fileInputStream.read(chars);
                        if (res == -1)
                            break;
                        System.out.print(new String(chars, Charset.forName("UTF-8")));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }

    public static void writeTest() {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("D:\\nihao.txt", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            try {
                outputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try {
            outputStream.write(358627389);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void consoleRead() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String read = scanner.nextLine();
            if (read.equals("end"))
                break;
            System.out.println(read);
        }
    }
}
