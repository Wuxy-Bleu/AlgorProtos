package design_patterns;

//所谓的原型模型不过是实现了Cloneable接口（这个接口是空的）和重写了Object的clone方法 的一个类罢了
public class Prototype implements Cloneable {

    Prototype() {
        System.out.println("具体原型创建成功！");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Prototype) super.clone();
    }
}

//原型模式的测试类
class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype obj1 = new Prototype();
        Prototype obj2 = (Prototype) obj1.clone();
        System.out.println("obj1==obj2?" + (obj1 == obj2));
    }
}

