package basicStructure;

import java.util.Arrays;
import java.util.Iterator;
public class StackArrImpl<T> implements Stack<T> {


    public StackArrImpl() {
        //其实下面两个东西的初始化可以放在这里
    }

    //这次不采用private T[] elements = null; 这种写法，而是使用Object[]
    //注意哦      T a = new T(); 泛型是没办法实例化的。
    private Object[] elements = new Object[5];    //长度随意写的
    private int poniter = -1;   //这个一开始设为-1，是为了pop的时候方便
    //TODO 这个就是指向栈顶的指针了，有更好的设计吗

    @Override
    public void push(T item) {
        this.poniter++;
        //如果栈未满，直接push进去，如果满了，调用resize再push
        if (this.poniter == this.elements.length) {
            //resize为多少我也是随便设的。    resize为两倍
            this.resize(this.elements.length * 2);
        }
        this.elements[this.poniter] = item;    //T自动转Object
    }

    @Override
    public T pop() {
        return (T) this.elements[this.poniter--];
    }

    @Override
    public boolean isEmpty() {
        return this.poniter == -1;
    }

    @Override
    public int size() {
        return this.poniter + 1;
    }

    //接口中是默认访问权限，实现类中是private 会报错，那怎么办，只能不把这个方法写在接口中了。
    // 接口中定义的方法好像都必须是默认访问权限或者public的
    //TODO　p85 栈数组大小调整 该如何设计
    private void resize(int max) {
        Object[] newArr = new Object[max];
        for (int i = 0; i < this.elements.length; i++)
            newArr[i] = this.elements[i];
        this.elements = newArr;
    }

    @Override
    public String toString() {
        return "StackArrImpl{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

}
