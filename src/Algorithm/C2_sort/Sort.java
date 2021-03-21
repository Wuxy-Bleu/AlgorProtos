package Algorithm.C2_sort;

import java.util.Random;

//所有排序算法实现类的顶层接口，它操作的主要是实现了Comparable接口的类组成的数组
//TODO  我这里疑惑的是这里我是否需要对sort接口使用泛型，毕竟Comparable接口时泛型的
//如果使用了泛型，那么某个排序算法只能对某一种类型的数组使用了。
//TODO 但是不使用泛型，实际应用排序算法的时候会不会出什么问题，之后再考虑把
//泛型其实不是作用在排序算法身上的，而是作用在需要排序的类身上的
public interface Sort {

    //TODO 有一个问题，exchange和compare两个方法我只想让实现了接口的类内部访问，但是接口不可以用private修饰方法怎么办
    //所以我用了接口的默认方法
    //TODO 但是这个默认方法只有在它的实现类内部可以调用，我希望它是private的，但是Private不能修饰这个地方
    //我希望只有实现类内部才可以访问，即使是实现类的实例，在外部也访问不到，在外部没办法直接调用。但是好像做不到
    //TODO 所以根据我上面的需求，可能接口的默认方法这个东西不符合我的需求，默认方法开发出来是用作接口升级的，
    // 我这里的需求可能用抽象类更好 我这里需要思考一下。
    //如果要求类内和子类可以随便访问，类外 包内  包外都不可以访问   貌似做不到的
    //包内 类外无法访问 就只能是private的，但是这时子类又无法访问，那只能用get方法，那么get方法什么权限呢，还是很矛盾，治标不治本

    //交换数组中的某两个元素
    default void exchange(Comparable[] arr, int i, int j) {
        try {
            Comparable tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        } catch (Exception e) {
            System.out.println(e + " in exchange");
        }
    }

    //TODO 测试发现，接口的【默认】方法，不写public默认就是public的，在包外可以访问这个方法，
    // 但是这个是不是由于接口时public造成的，还不知道，还有其他的普通方法是不是也是同样默认public的也未知。
    //比较数组中的两个元素，主要利用Comparable接口中的CompareTo方法   > 1 , =  0 , < -1
    default int compare(Comparable a, Comparable b) {
        return a.compareTo(b);
    }

    //这就是最重要的排序算法了
    void sortAscend(Comparable[] arr) throws Exception;

    //展示的方法
    default void showArr(Comparable[] arr) {
        //这边要求arr中的元素实现了toString方法
        //TODO 还有一个问题这里对foreach的理解不够啊，java中的数组当然可以用foreach了
        // ，我还在犹豫Comparable具体的那个实现类要不要实现迭代器.....
        for (Comparable a : arr) {
            System.out.println(a);
        }
    }

    //是否排序成功
//    boolean isSorted(Comparable[] arr);

    //判断一个数组是否已排序的方法，静态方法，一个sort的工具方法
    //这个判断实在是不准啊。。 随机找一个数组中一个值，判断它的后一个是不是 >= 它 就判断了一次
    static boolean isSorted(Comparable[] arr) {
        int randomNum = new Random().nextInt(arr.length);
        return arr[randomNum + 1].compareTo(arr[randomNum]) == -1 ? false : true;
    }

}
