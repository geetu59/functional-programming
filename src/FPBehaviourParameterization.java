import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*1. Trying to print even and odd nos but code is redundant. Only thing which changes is the condition which we have
put in filter. So, let's take out that condition in a variable and move rest of the code to method. This is called
Behaviour parameterization i.e. you are putting logic as param of method*/
public class FPBehaviourParameterization {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 6, 34, 89, 56, 45, 12, 6);
        print(list, number1 -> number1 % 2 == 0);
        print(list, number -> number % 2 != 0);
        System.out.println(mapAndCreateNewList(list, number -> number * number));
        System.out.println(mapAndCreateNewList(list, number -> number * number*number));
        System.out.println(mapAndCreateNewList(list, number -> number + number));
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> list, Function<Integer, Integer> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    private static void print(List<Integer> list, Predicate<Integer> predicate) {
        list.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

}
