package Algorithm.C2_sort;
//{ 接口类和类中的方法只能是public的，不写默认就是public的 } TODO 这句话是错误的，方法另说，接口本身可以是public和包访问权限
//TODO 简直是误导人，接口可以是public的，但是不写就是包访问权限，包外是访问不到的，我服了。
//TODO 接口中的方法访问权限只能用 public 或者不写修饰
//接口类不可以用static , final修饰，那能修饰的只有一个public
//接口中全部是抽象方法，但是如果用default或者static修饰方法，就可以在接口中写实现
//接口的默认方法是可以被重写的

//jdk1.8之后，接口中的方法可以用default和static修饰，就可以写实现了   default用来解决接口实现的问题
//默认方法其实就是类似于  所有的实现类继承了一个public方法，人手一份

//现在的场景是所有的实现类都必须实现几个方法，但是只有一个方法有变化，其他的方法实现都是一样的，所以考虑到了接口的default方法
//但是我突然想到抽象类，这个岂不是一样的....
//在我的这个需求中，接口和抽象类都是可以的，貌似

//抽象类必须至少有一个抽象方法，但是类中非抽象方法可以有实现，
//反过来，如果一个类中有抽象方法，那么该类必须是抽象类，类定义上必须写abstract关键字
//TODO 同样的网上的回答误导人，抽象类只能用public修饰，但是不写默认是包访问权限的
// 而抽象类的方法可以用任意修饰符修饰  三个权限的 static final都可以   这个就比接口丰富一些了

//没想到我还需要总结这些东西，由小到大
// private只有本类能访问，即使是子类都无法访问，类外 也就是它的实例化对象了 无法访问
// 包访问权限，本类可以访问，同一个包内随便访问，但是不是同一个包就无法访问了，即使是继承了这个类不同包都无法访问
//              同一个包内public 包外private, 同一个包 类内 子类  类外都行，包外 哪都不行
// 所以就有了protected  同一个包随便访问，不同包如果是继承的话就可以访问了
// 包内 public 包外  子类可以访问，包外不行 就比上面多加了个权限
//public 随便访问
//还要注意一点，无法访问不代表，这个数据就不存在了，private的成员还是可以通过get方法获取的，继承的话也是全部继承下来了

public abstract class SortAbstract {

    void exchange(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    int compare(Comparable a, Comparable b) {
        return a.compareTo(b);
    }

    abstract public void sort(Comparable[] arr);

    public void show(Comparable[] arr) {
        for (Comparable a : arr) {
            System.out.println(a);
        }
    }

    public boolean isSorted(Comparable[] arr) {
        return true;
    }

}
