package basicStructure;

import java.util.ArrayList;
import java.util.Iterator;

//TODO  记录下 泛型数组、内部类，泛型接口

//泛型的实现，一边写一遍熟悉吧
//TODO Iterable的泛型是否可以不写，直接从实现类的泛型中获取到
//真正的泛型反而没有Object[]的实现灵活，T的类型确定了，那么只能存放这一类型的数据，TODO 嗯？ T是Object会咋样
public class BagGeneric<T> implements Iterable<T> {

    //泛型在编译后的代码中是不存在的，所以泛型无法实例化，
    //TODO　那么这种写法不也是有点不合理吗，既然无法实例化，为什么可以声明一个T[]类型呢？？
    private T[] elements = null;
    private int size;

    public BagGeneric() {
    }

    //我去，我之前还没注意到，如果构造器不是public的话，在包外就无法实例化这个类啊 必须是public的
    public BagGeneric(T[] arr) {
        elements = arr;
        size = arr.length;
    }

    @Override
    public Iterator iterator() {
        return new BagGenericIterator();
    }

    //这个地方 接口和实现类的泛型就算是全部省略了 TODO 也没啥事  ....
    //TODO我感觉这里的泛型还是得加上去   还有iterator方法返回这个内部类Iterator这里
    private class BagGenericIterator implements Iterator {

        private int index = 0;

        //TODO 在这个地方   return index != BagGeneric<T>.this.size; 这样写会报错
        @Override
        public boolean hasNext() {
            return index != BagGeneric.this.size;
        }

        @Override
        public T next() {
            return BagGeneric.this.elements[index++];
        }
    }

    public void add(T item) {
        //泛型是没办法这样子实例化的，会报错，
        //那么就意味着在这个数据结构中，底层保存的元素最好不要用T[]来存放了
//        T[] newArr = new T[this.size];
        //TODO 那么这里数组add的实现，必须构建一个新的数组，所以这里要想办法绕过泛型的这个特性
        //TODO 我的设计是底层元素依旧是T[]类型的，但是add方法中全程使用Object[]来存放所有数据，再在最后强转  评估下这个方法，
        // 而且还有很多中设计可以实现这个需求，比如将底层的元素用Object[]存放，等等。
        Object[] newArr = new Object[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = this.elements[i];          //这里是将T强转为了Object
        }
        newArr[this.size] = item;                   //这里是将T强转为了Object
        this.elements = (T[]) newArr;              //这里是将Object[]强转为了T[]
        this.size++;
    }

    public void add(T[] arr) {
        Object[] newArr = new Object[this.size + arr.length];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = this.elements[i];
        }
        for (int i = 0; i < arr.length; i++) {
            newArr[i + this.size] = arr[i];
        }
        this.elements = (T[]) newArr;
        this.size += arr.length;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public T get(int i) {
        return elements[i];
    }

}
