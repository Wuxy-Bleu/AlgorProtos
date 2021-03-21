package others.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {

    FileIOTest() {
    }


    public static void main(String[] args) {
        String path = " ";
        File file = new File(path);
        File[] arr = file.listFiles();


        try {
            FileWriter writer = new FileWriter("D:\\log.txt");
            for (File f :
                    arr) {
                System.out.println(f.getPath());
                System.out.println(f.getName());
                writer.write(f.getName() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
