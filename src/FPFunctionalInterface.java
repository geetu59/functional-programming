import java.util.List;
import java.util.Random;
import java.util.function.*;

/*Functional Interface: Interface with one abstract method and can have multiple static/default method.
 * Eg: 1. filter has Predicate which accepts one param and returns boolean
 * 2. map has Function which takes one param and returns whatever reqd. Function<Integer, String> fn=x->x+" ",
 * so here first type is parameter and second is return type in Function<Integer, String>
 * 3. fore has Consumer which takes param but doesnt return anything
 * reduce has BinaryOperator which takes 2 params and returns reqd result
 * 4. Supplier which returns value but doesnt take any param
 * 5. UnaryOperator which takes one param and returns type of same param. Subset of Function
 * All of them are present inside util.function package. You'll see classes like IntBinaryOperator, IntFunction, IntConsumer,
 * IntPredicate, IntSupplier. All of them represent operations using the primitives of respective class. The reason why we need
 * this is becaz we are using wrapper classes in Function<Integer> and hence there is boxing unboxing happens so to avoid that
 * we have IntFunction and similarly other classes
 * 6. BiPredicate BiFunction BiConsumer, all takes 2 params and working is same as that of respective claases. */
public class FPFunctionalInterface {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 6, 34, 89, 56, 45, 12, 6);
        System.out.println(sum(list));
        sumOfSquaresOfEvenNumbers(list);
        Supplier<Integer> supply = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(1000);
            }
        };
        System.out.println(supply.get());

        UnaryOperator<Integer> unaryOperator = x -> 3 * x;
        System.out.println(unaryOperator.apply(10));
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
