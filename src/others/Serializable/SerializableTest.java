package others.Serializable;

import java.io.*;

public class SerializableTest implements Serializable {
    private String name = "no";

    public static void main(String[] args) {

        File file = new File("D:\\nihao.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SerializableTest test = new SerializableTest();
        try {
            oos.writeObject(test);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
