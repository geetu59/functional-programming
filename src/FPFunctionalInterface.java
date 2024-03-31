import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*Functional Interface: Interface with one abstract method and can have multiple static/default method.
* Eg: filter has predicate which accepts one param and returns boolean
* map has function which takes one param and returns whatever reqd
* fore has consumer which takes param but doesnt return anything
* reduce has BinaryOperator which takes 2 params and returns reqd result
* supplier which returns value but doesnt have any param*/
public class FPFunctionalInterface {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 6, 34, 89, 56, 45, 12, 6);
        System.out.println(sum(list));
        sumOfSquaresOfEvenNumbers(list);
    }

    private static void sumOfSquaresOfEvenNumbers(List<Integer> list) {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * number;
            }
        };

        Consumer<Integer> println = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        list.stream()
                .filter(predicate)
                .map(function)
                .forEach(println);
    }

    /*To check which functional interface is getting used, extract that part  into variable and then create object of it
    and override abstract method and add your logic*/
    private static int sum(List<Integer> list) {
        BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        return list.stream().reduce(0, sum);
    }
}
