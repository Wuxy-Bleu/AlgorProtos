package design_patterns;

interface Target {
    public void request();
}

//适配者接口
class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}

//类适配器类
public class ClassAdapter extends Adaptee implements Target {
    public void request() {
        specificRequest();
    }
}

class MainAdapter{
    public static void main(String[] args) {

    }
}
//这代码很简单，但是没搞懂 想干嘛