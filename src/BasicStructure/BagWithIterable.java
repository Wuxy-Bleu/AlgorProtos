package BasicStructure;

import java.util.Iterator;

//TODO 迭代器的代码还可以优化，使用隐藏内部类，也就是return new BagObjIterator();这里直接定义一个内部类，还可以进一步用Lambda表达式优化

//TODO 这两个接口不加泛型会出错的吧   泛型这边有大量的问题，比如泛型的中括号什么时候可以省略，省略会出错吗，还有一个非泛型的类实现了一个泛型接口。
//所以一般不会用非泛型类实现迭代器的吧
//等等，不仅仅是省略的问题了 TODO 我的这个需求在实现这两个接口的时候，泛型该填什么，是Object吗？ 还有这两个接口的泛型是有一定联系的
//如果迭代器实现一次必须实现两个接口的话，其实整个泛型的选择应该根据 next的返回值来决定的！！！   我自己这样想的
//当然如果是不同的实现方式会有不同的设计
public class BagWithIterable implements Iterable<Object> {

    private Object[] elements = new Object[5];
    private int size = 0;

    //这是Iterable接口唯一需要实现的方法，其他的两个有默认实现
    //这个方法的唯一作用就是返回当前类的迭代器
    //TODO 貌似这个可迭代接口的唯一作用就是让它可以用foreach
    //TODO 这个方法返回值的泛型可以省略吗
    @Override
    public Iterator<Object> iterator() {
        return new BagObjIterator();
    }

    public BagWithIterable() {
    }

    public BagWithIterable(Object[] arr) {
        elements = arr;
        size = arr.length;
    }

    public BagWithIterable(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
    }

    //TODO 内部类慢慢学吧
    //这个就是iterable唯一方法返回的类，所以一般都是这种写法吗，外部的数据结构的类实现了iterable，在搞一个内部类专门实现iterator吗，
    //而这个内部类完全与具体的业务没有关联。
    //内部类是private的 会有什么影响
    private class BagObjIterator implements Iterator<Object> {

        private int index = 0;

        //下面是iterator接口必须实现的两个方法，还有几个有默认实现
        //TODO 注意理解，这里实现的这两个方法主要的就是用来遍历外部类中的elements数组了。
        //TODO 有关于内部类获取到外部类的this
        @Override
        public boolean hasNext() {
            //好奇怪，慢慢接受吧
            return index != BagWithIterable.this.size;
        }

        @Override
        public Object next() {
            return BagWithIterable.this.elements[index++];
        }
    }

    public void add(Object item) {
        Object[] newArr = new Object[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = elements[i];
        }
        newArr[newArr.length - 1] = item;
        elements = newArr;
        this.size++;
    }

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
