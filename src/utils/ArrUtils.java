package utils;


public class ArrUtils {

    //在一行输出数组的所有元素，前提该元素实现了toString
    public static void printArr(Object[] arr) {
        for (Object element : arr) {
            System.out.print(element + " - ");
        }
        System.out.println("");
    }
    /*用不到，Arrays提供了相关的方法*/

}
