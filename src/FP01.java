import java.util.List;
import java.util.stream.Collectors;

/*Implement a few problems using structured and FP approach(focus on what to do): stream, filter, fore.
 * 1. Print list
 * 2. Print even nos
 * 3. Print courses
 * 4. Print courses containing the word "Spring"
 * 5. Print courses whose name as atleast 4 letters*/
public class FP01 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 6, 34, 89, 56, 45);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "GCP", "Azure");
        printNumbersFunctional(list);
        printEvenNumbersFunctional(list);
        printAllCourses(courses);
        printCoursesHavingSpring(courses, "Spring");
        printCoursesWithMoreThanFourLetters(courses);
        printCubesOfOddNumbers(list);
        printNumberOfCharsInEachCourse(courses);
    }

    private static void printNumberOfCharsInEachCourse(List<String> courses) {
        System.out.println(courses.stream().map(course-> course+ " " + course.length()).collect(Collectors.toList()));
    }

    private static void printCubesOfOddNumbers(List<Integer> list) {
        System.out.println(list.stream().filter(number -> number % 2 != 0)
                .map(number -> number * number * number).collect(Collectors.toList()));
    }

    private static void printCoursesWithMoreThanFourLetters(List<String> courses) {
        System.out.println(courses.stream().filter(course-> course.length()>=4).collect(Collectors.toList()));
    }

    private static void printCoursesHavingSpring(List<String> courses, String s) {
        courses.stream().filter(course-> course.equals(s)).forEach(System.out::println);
    }

    private static void printAllCourses(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }

    private static void printEvenNumbersFunctional(List<Integer> list) {
        list.stream().filter(number->number%2==0).forEach(System.out::println);
    }

    private static void printNumbersFunctional(List<Integer> list) {
        list.forEach(System.out::println);
    }
}
