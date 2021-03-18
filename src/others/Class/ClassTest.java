package others.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ClassTest {

    public String str = "fahsl;dgla";

    public ClassTest() {
    }

    public ClassTest(String str) {
        this.str = str;
    }

    public static void main(String[] args) throws IllegalAccessException, Exception {
        Class aClass = null;
        try {
            aClass = Class.forName("others.Class.ClassTest");   //jdbc常用
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<ClassTest> bClass = ClassTest.class;
        Class<? extends ClassTest> cClass = new ClassTest().getClass();

        System.out.println(aClass == bClass);
        System.out.println(bClass == cClass);

        System.out.println(bClass instanceof Class);

        System.out.println(Map.class.isInstance(new HashMap<>()));

        try {
            ClassTest o = (ClassTest) aClass.newInstance();
            System.out.println(o instanceof ClassTest);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ClassTest classTest = bClass.newInstance();

        Constructor<ClassTest> constructor = null;
        try {
            constructor = bClass.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        ClassTest classTest1 = null;
        try {
            classTest1 = constructor.newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(classTest1.str);

        Constructor<ClassTest> constructor1 = bClass.getConstructor(String.class);
        ClassTest classTest2 = constructor1.newInstance();
        System.out.println(classTest2.str);

        Method[] declaredMethods = bClass.getDeclaredMethods();



    }
}
