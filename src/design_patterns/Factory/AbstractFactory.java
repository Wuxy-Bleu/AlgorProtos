package design_patterns.Factory;

public class AbstractFactory {

    //两种产品 接口
    public interface OperationController {
        void control();
    }

    public interface UIController {
        void display();
    }

    //下面的6个具体的产品 按照接口就分为两类，但是按照功能又分为 android iso windowsPhone 三种
    public class AndroidOperationController implements OperationController {
        @Override
        public void control() {
            System.out.println("AndroidOperationController");
        }
    }

    public class AndroidUIController implements UIController {
        @Override
        public void display() {
            System.out.println("AndroidInterfaceController");
        }
    }

    public class IosOperationController implements OperationController {
        @Override
        public void control() {
            System.out.println("IosOperationController");
        }
    }

    public class IosUIController implements UIController {
        @Override
        public void display() {
            System.out.println("IosInterfaceController");
        }
    }

    public class WpOperationController implements OperationController {
        @Override
        public void control() {
            System.out.println("WpOperationController");
        }
    }

    public class WpUIController implements UIController {
        @Override
        public void display() {
            System.out.println("WpInterfaceController");
        }
    }

    // 抽象工厂接口 接口中有生成两种产品的抽象方法
    // 下面按照功能实现了三种工厂
    //怎么这么绕呢
    public interface SystemFactory {
        public OperationController createOperationController();

        public UIController createInterfaceController();
    }

    public class AndroidFactory implements SystemFactory {
        @Override
        public OperationController createOperationController() {
            return new AndroidOperationController();
        }

        @Override
        public UIController createInterfaceController() {
            return new AndroidUIController();
        }
    }

    public class IosFactory implements SystemFactory {
        @Override
        public OperationController createOperationController() {
            return new IosOperationController();
        }

        @Override
        public UIController createInterfaceController() {
            return new IosUIController();
        }
    }

    public class WpFactory implements SystemFactory {
        @Override
        public OperationController createOperationController() {
            return new WpOperationController();
        }

        @Override
        public UIController createInterfaceController() {
            return new WpUIController();
        }
    }

}
