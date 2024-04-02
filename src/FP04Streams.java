import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*list.stream and stream.of, both returns referenceStream i.e. create wrappers, boxes and unboxes while intArray creates intStream
 * Create streams of some numbers*/
public class FP04Streams {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println(list.stream());

        System.out.println(Stream.of(1, 2, 3, 4, 5));

        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(intArray));
        System.out.println(Arrays.stream(intArray).sum());

        //10 is not included
        System.out.println(IntStream.range(1, 10).sum());
        //10 included
        System.out.println(IntStream.rangeClosed(1, 10).sum());
        //since we are iterating, we have to put limit until which we want to see results to avoid infinite loop
        System.out.println(IntStream.iterate(1, x -> x + 2).limit(10).boxed().collect(Collectors.toList()));
        //peek to peek into stream, without changing stream
        System.out.println(IntStream.iterate(1, x -> x + 2).peek(System.out::println).limit(10).boxed().collect(Collectors.toList()));
        //sum of multiples of 2 of first 10 numbers
        System.out.println(IntStream.iterate(2, x -> x * 2).limit(10).sum());
        //you cant directly collect it to list as it is int stream, you've to box it to create wrapper and then collect
        System.out.println(IntStream.iterate(2, x -> x * 2).limit(10).boxed().collect(Collectors.toList()));


        /*Factorial of a number*/
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        //0 as result exceeds limit
        System.out.println(IntStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));
        //- value as result exceeds limit
        System.out.println(LongStream.rangeClosed(1, 50).reduce(1, (x, y) -> x * y));
        //worked as it was in limit
        System.out.println(LongStream.rangeClosed(1, 20).reduce(1L, (x, y) -> x * y));
        //To handle such scenarios, we use BigInt
        System.out.println(IntStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }
}
