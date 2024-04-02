import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*We are trying to use lambda expressions on custom objects
 * 1. allMatch-> if the whole list fulfils the condition
 * 2. anyMatch-> if any item of the list fulfils the condition
 * 3. noneMatch -> if none of the items fulfils the condition
 * 4. Comparator.comparing -> to sort values
 * 5. limit(n) -> show n values
 * 6. skip(n) -> skip n values
 * 7. takeWhile() -> take items until you didnt encounter the element which doesnt match the given condition. Then you
 * stop even if you've elements which matches the condition after that
 * 8. dropWhile() -> ddrop elements until you didnt find element which fulfils the condition
 * 9. max -> gets the list provided by comparator and returns last element of the list
 * 10 min -> gets the list provided by comparator and returns first element of the list. Hardly matters it is large or small
 * 11. findFirst -> the first element out of filter or sort
 * 12. findAny -> any element out of filter
 * 13. sum -> filter and then map to find sum of values
 * 14. average -> filter and then map to find avg of values
 * 15. count-> count to find total number
 * 16 groupingBy -> group by specific value of items of list*/
@AllArgsConstructor
@Getter
@ToString
class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;
}

public class FP03CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        System.out.println(courses.stream()
                .allMatch(course -> course.getReviewScore() > 95));
        System.out.println(courses.stream()
                .anyMatch(course -> course.getReviewScore() > 95));
        System.out.println(courses.stream()
                .noneMatch(course -> course.getReviewScore() > 95));

        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getNumberOfStudents)
                        .thenComparing(Course::getReviewScore)
                        .reversed())
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getReviewScore))
                .limit(5).collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getReviewScore))
                .skip(3)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore()>95)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore()>95)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .max(Comparator.comparing(Course::getReviewScore).reversed()));
        System.out.println(courses.stream()
                .min(Comparator.comparing(Course::getReviewScore).reversed()));
        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore()>95)
                .findFirst());
        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore()>95)
                .findAny());

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore()>95)
                .mapToInt(Course::getNumberOfStudents)
                .sum());

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore()>95)
                .mapToInt(Course::getNumberOfStudents)
                .average());

        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore()>95)
                //.mapToInt(Course::getNumberOfStudents)
                .count());

        //how many courses fulfiled that criteria
        System.out.println(courses.stream()
                .filter(course -> course.getReviewScore()>95)
                .mapToInt(Course::getNumberOfStudents)
                .max());

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory())));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory(), Collectors.counting())));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory(),
                        Collectors.maxBy(Comparator.comparing(course -> course.getReviewScore())))));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory(),
                        Collectors.mapping(course -> course.getName(), Collectors.toList()))));
    }

}
