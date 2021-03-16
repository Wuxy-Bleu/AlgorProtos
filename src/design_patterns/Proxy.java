package design_patterns;
/*
* 所谓的设计模式，简单的代码实例是真的简单的过分啊
* 这个代理模式就是类似于aop一样的东西啊，这个叫做静态代理吧 动态代理还是要用到Class 反射的
*
* 就一个接口，一个实现类实现了接口中的某一个方法，但是想要调用这个实现类的这个方法不直接new它再调用
* 而是实现这个接口的一个Proxy类，Proxy类中实例化之前的实现类，再在重写的方法中调用这个实现类的重写方法....
* 绕了一圈
* */


//抽象主题
interface Subject {
    void Request();
}

//真实主题
class RealSubject implements Subject {
    public void Request() {
        System.out.println("访问真实主题方法...");
    }
}


//代理
public class Proxy implements Subject {
    private RealSubject realSubject;

    public void Request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }

    public void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}

class Main{
    public static void main(String[] args) {

    }
}



