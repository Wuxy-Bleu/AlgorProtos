package basicStructure;

//提取一个接口，接口中一般不管构造器的吧
//实现接口中的方法需要写@Override注解的   不过好像不写这个注解也没事。
public interface Bag {

    //TODO 它满足不了我的需求可以通过什么巧妙的设计搞定吗
/*    public void add(int item);

    public void add(int[] arr);

    public int size();

    public boolean isEmpty();*/

    void test();
}
//接口在我现在的理解完全就是一个模板，数据什么的都不共享，就是指定了一个规范而已。
//还有就是向上转型方便，实现了多态，很有用，但是怎么解释这个很有用就很难了。
