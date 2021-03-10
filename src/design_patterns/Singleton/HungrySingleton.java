package design_patterns.Singleton;

public class HungrySingleton {
    //其实lazy的类似，不过final保证了 没法重新赋值
    private static final HungrySingleton instance = new HungrySingleton();
    //只是为了将构造器private才写出来
    private HungrySingleton() {
    }
    public static HungrySingleton getInstance() {
        return instance;
    }
}