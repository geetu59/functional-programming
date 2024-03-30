import java.util.List;

/* 1. SUm of all numbers
* */
public class FP02 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 6, 34, 89, 56, 45);
        System.out.println(sum(list));
    }
    //a=accumulator(containing sum till now) b=next number to be added
    public static int add(int a, int b){
        return a+b;
    }
    private static int sum(List<Integer> list) {
        //0 to initialise the value
        return list.stream().reduce(0, FP02::add);
    }
}
