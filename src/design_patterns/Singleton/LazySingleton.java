package design_patterns.Singleton;

public class LazySingleton {
    //volatile 关键是线程相关的
    //private保证了类外访问不到，static保证了这个类自己的对象是单实例的
    private static volatile LazySingleton instance = null;

    private LazySingleton() {
    }    //private 避免类在外部被实例化 todo 有关 private构造器的知识可以去学习下

    //synchronized 是线程相关的
    //这个就是获取类的单实例的方法了，static保证不需要实例化类就可以调用，public是肯定的，这个方法就是给人用的
    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
