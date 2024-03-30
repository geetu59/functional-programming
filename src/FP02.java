import java.util.List;

/* 1. Sum of all numbers
 * 2. Try printing results
 * 3. Min of all numbers*/
public class FP02 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 6, 34, 89, 56, 45);
        System.out.println(sum(list));
        System.out.println(print(list));
        System.out.println(min(list));
    }

    private static int min(List<Integer> list) {
        return list.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
    }

    private static int print(List<Integer> list) {
        //return list.stream().reduce(0, (x,y)->x);
        return list.stream().reduce(0, (x, y) -> y);
    }

    //a=aggregate(containing sum till now) b=next number to be added
    public static int add(int aggregate, int nextNumber) {
        return aggregate + nextNumber;
    }

    private static int sum(List<Integer> list) {
        //0 to initialise the value
        //return list.stream().reduce(0, FP02::add);
        //since we can also use lamba exp where we can pass params and compute result and hence using it, hence we will use it
        //return list.stream().reduce(0, (x,y)->x+y);
        //since Integer.sum is present, we can avoid using our custom method
        return list.stream().reduce(0, Integer::sum);
    }
}
