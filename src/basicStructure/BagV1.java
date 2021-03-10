package basicStructure;

/**
 * 对于bag数据结构的实现初版
 *
 * @author wuxy
 */
//不使用接口的实现
public class BagV1{

    //对于暂不支持泛型的实现，暂定只能保存int类型的元素。后来尝试使用Object数组
    //这个数组的长度暂定为5，没有任何理由
    //TODO 这个长度最好作为一个常量放在类中，具体实现暂时没有想法
    //int数组默认初始化为全为0
    //TODO 这样子初始化好吗
    private int[] elements = new int[5];               //变量暂为默认权限

    //elements成员虽然一开始填满了0，但是其实现在还没有长度，所以bag的长度不能以数组的长度作数，而是需要一个单独的size变量
    //TODO 基本类型的数据成员基本不会这样子初始化吧，而且不需要初始化也是0啊，这里好吗
    private int size = 0;    //size设置为private的，会另外搞个size()方法
    //（这里的设计没有任何理由，如果size是public的现在对我的需求没有任何影响）

    //注意如果写了有参构造器，而没有写无参构造器，那么默认就不存在无参构造
    //所以如果需要，必须显式写出来，即使是空的。
    //构造器全部都是public的
    public BagV1() {
    }

    /**
     * 利用某一个数组初始化bag
     *
     * @param arr
     */
    //不需要无参构造器，因为默认都给赋好了
    public BagV1(int[] arr) {   //构造器的参数名一般和对应的成员变量名一样吧
        //在普通变量的情况下，elements只是一个引用而已
        //即使传递的数组的长度不同，也无所谓，直接赋值不会出问题，指向的内存地址改变了
        //TODO 但是这符合我的本意吗，是否要将它改为final类型的，但是改为final就没法间接改变数组长度了吧
        //我先将它设为private的，这样子如果类的内部规范写法，外部就没法随便改变这个结构
        elements = arr;
        size = arr.length;
    }

    //同上，不过将初始化时可以将数组的长度直接传入
    public BagV1(int[] elements, int size) {
        this.elements = elements;
        this.size = size;
    }

    /**
     * 往数组中增加一个元素,向后新增，也就是bag插入是由顺序的吧
     * TODO 往数组中增加元素其实就是构造一个新的数组，将变量指向新的数组，这是个很常见的需求，可以试着封装一个方法
     * TODO 用一个数组来构造另一个数组的方法也可以封装一下
     *
     * @param item
     * @return
     */
    public void add(int item) {                  //暂时所有的业务方法都是public的,因为现在所有的方法包外是需要访问的
        int[] newArr = new int[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = elements[i];
        }
        newArr[newArr.length - 1] = item;
        elements = newArr;
        this.size++;
    }

    //向后插入一个数组,方法重载
    public void add(int[] arr) {
        int[] newArr = new int[this.size + arr.length];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = elements[i];
        }
        for (int i = 0; i < arr.length; i++) {
            newArr[this.size + i] = arr[i];
        }
        elements = newArr;
        this.size += arr.length;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }
}







