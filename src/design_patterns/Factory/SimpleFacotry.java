package design_patterns.Factory;

public class SimpleFacotry {

    public interface Product {
        void show();
    }

    //具体产品：ProductA
    static class ConcreteProduct1 implements Product {
        public void show() {
            System.out.println("具体产品1显示...");
        }
    }

    //具体产品：ProductB
    static class ConcreteProduct2 implements Product {
        public void show() {
            System.out.println("具体产品2显示...");
        }
    }

    //这就是做一个枚举的作用
    final class Const {
        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
        static final int PRODUCT_C = 2;
    }

    // 工厂类 有一个静态的工厂方法，用来生成对象的。 这个很好懂
    // 然后就是 接口+多个实现类的方式，选择生产哪个对象，放在内部类这里只是为了方便吧。
    // 为啥实现类都是 静态内部类呢，因为工厂方法是静态的，静态工厂 new 内部类对象，那这个对象必须是static的
    /* 但是如果静态方法调用普通的类 那就没啥问题; 静态方法调用内部类，就必须是静态的  （因为内部类 要看作是当前类的一个成员）  */
    public static Product Factory(int kind) {
        switch (kind) {
            case Const.PRODUCT_A:
                return new ConcreteProduct1();
            case Const.PRODUCT_B:
                return new ConcreteProduct2();
        }
        return null;
    }
}
//todo 关于内部类的知识  static，private修饰class只能是内部类
// 把成员内部类当成是一个成员变量吧

/*  静态内部类和那个啥 代码块要区分开
    代码块主要分为了 静态代码块和构造代码块，这个之后再说吧
* */

/* 成员内部类，也就是类中，但是方法外，
        可以用四种访问权限修饰，但是有啥区别暂未知，可以用static,final修饰。
        这种类跟普通类基本类似，其中可以用成员变量，有方法。 实例化方式和普通的类不太一样
            如果在当前所在的外部类中，6个修饰符修饰的都可以直接new出来
            Outer o = new Outer(); Inner i = o.new Inner(); 外部类之外是这种实例化方式

        普通内部类  可以访问所在Outer class所有的东西         但是不能声明任何static的东西
        静态内部类  只能访问所在的Outer class静态的成员和方法     可以声明static和非static的东西
        最后就是 两者实例化方式的不同了，静态内部类可以单独实例化 Inner i = new Outer.Inner();

        静态内部类一般也就工厂模式中用得到了吧
 */

/*  局部内部类和匿名内部类
    局部内部类就是 方法中的内部类，
    匿名内部类就是   new class { } new的时候直接声明的东西
 * */

/* 内部类还有可能是接口，抽象类，枚举 这些玩意*/

