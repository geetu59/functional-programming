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
 * 4. Comparator.comparing -> to sort values*/
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
    }

}
