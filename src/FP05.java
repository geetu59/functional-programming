import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 1.create tuples with same length
 * Fn Programming helps in performance as you can run parallel streams.
 * 2. Eg of intermediate operations being lazy*/
public class FP05 {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "API", "Spring Boot", "Microservices", "AWS", "GCP", "Azure");
        //to print list items separated by ,
        //String.join(",", courses)
        System.out.println(courses.stream().collect(Collectors.joining(",")));

        //to print chars of all items in single go
        //output->[ ["s","s","s","s","s","s"], ["s","s","s"], ... ]
        System.out.println(courses.stream()
                .map(course -> course.split(""))
                .collect(Collectors.toList()));
        //this will work as we use flatMap, it will flaten the response of map
        System.out.println(courses.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList()));
        //remove duplicate alphabets
        System.out.println(courses.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()));

        //tuples with same length i.e. pair up each of the course elements with each other and the pair which has same lengths, print those
        List<String> courses2 = List.of("Spring", "API", "Spring Boot", "Microservices", "AWS", "GCP", "Azure");
        //creating tuples
        /*courses2.stream().map(course2->List.of(course, course2)) -> Stream<List<Courses>> where List contains 2 items, one of course 1 and other of course 2
         * i.e. stream.of(List.of(Spring, API), List.of(Spring, Spring Boot), ...). Now, outer map provides you with stream of course, so Stream<Stream<List<Courses>>>
         * then you are collecting to list, so it is List<Stream<List<Courses>>> to remove the stream, we need to do flatMap*/
        System.out.println(courses.stream().map(course -> courses2.stream().map(course2 -> List.of(course, course2))).collect(Collectors.toList()));

        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream()
                        .filter(course2 -> !(course.length() == course2.length()))
                        .map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));


        //Lazy operations
        /* As you see, the first peek's response, the moment it finds element>11, it simply stops there. SO fn programming is efficient. It knows
        it needs one element and hence it starts looking for one element at a time.
        If you remove findFirst, you'll see there's only stream, so peek, map, filter, these are intermediate fns,
        they do not execute until they know they have some terminal fn*/
        courses.stream().peek(System.out::println)
                .filter(course -> course.length() > 11)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst();
    }
}
