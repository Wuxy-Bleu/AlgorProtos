package basicStructure;

public class BagObj {

    private Object[] elements = new Object[5];
    private int size = 0;

    public BagObj() {
    }

    //TODO int[]就没办法用来初始化BagObj吗，要的是个对象数组，我这个是个基本类型数组，但不是可以自动装箱吗
    //这种为什么会报错啊  int[] arr = {6, 7, 8, 9, 0};   BagObj bag2 = new BagObj((Object[]) arr);
    //这个是因为arr被识别成了一个对象，而它要求的是一个对象数组，但是我不知道强转为啥不成功
    public BagObj(Object[] arr) {
        elements = arr;
        size = arr.length;
    }

    public BagObj(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
    }

    //这个是基本类型的话，可以自动装箱的
    //TODO 可以传null进去吗，尝试之后发现会抛出异常，null算是一个object吗,null不可以赋给一个object？？？
//    BagObj bag = new BagObj();
//    Object o = bag.get(1);      但是这种写法完全没有问题，一开始默认初始化了所有元素为null
    //TODO null当然可以作为参数传递的
    //找到问题所在了，如果我猜的没错的话，传入null自动调用了下面的重载方法，导致了空指针异常
    //也就是add(Object[] arr)  可以为什么会这样呢。
    public void add(Object item) {
        System.out.println(item);
        Object[] newArr = new Object[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = elements[i];
        }
        newArr[newArr.length - 1] = item;
        elements = newArr;
        this.size++;
    }

    //如果是对象数组会调用这个方法，但是如果传入的是基本类型数组会调用上面的同名方法
    //但是这个是怎么自动识别的呢？？ => 这个就涉及jvm了
    public void add(Object[] arr) {
        Object[] newArr = new Object[this.size + arr.length];
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

    //TODO 这里必须修改为如果i不在数组范围内，抛出异常，因为Object[]中可以有任何值，超出范围返回null是不合理的。
    public Object get(int i) {
        if (i < this.size && i >= 0) {
            return elements[i];
        } else
            return null;
    }

}
