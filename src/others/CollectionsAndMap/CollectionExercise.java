package others.CollectionsAndMap;

/*输入5个数，装入容器中ArrayList，将数从小到大输出，从大到小输出，随机输出*/


import java.util.*;
import java.util.stream.Stream;

public class CollectionExercise {

    static class FiveNums {
        public void solution() {
            System.out.println("enter 5 numbers ,split by space");
            //获取输入的数字存入list
            Scanner scanner = new Scanner(System.in);
            String[] s = scanner.nextLine().split("\\s+");
            List<String> strings = Arrays.asList(s);
//迭代器遍历List转存到另一个List
            List<Integer> ins = new LinkedList<>();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext())
                ins.add(Integer.parseInt(iterator.next()));
            ins.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });

            strings.sort((o1, o2) -> o1.compareTo(o2));
//            Stream<String> sorted = strings.stream().sorted(Comparator.reverseOrder());
//            sorted.forEach(System.out::println);
            System.out.println(ins.toString());

        }
    }


    public static void main(String[] args) {
        FiveNums fiveNums = new FiveNums();
        fiveNums.solution();
    }
}
