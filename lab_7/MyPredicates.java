package lab_7;

import java.util.*;
import java.util.function.Predicate;

public class MyPredicates {
    public static <T> void remove(Collection<T> coll, Predicate<T> p) {
        coll.removeIf(p::test);
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> p) {
        coll.removeIf(obj -> !p.test(obj));
    }

    public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
        Set<T> result = new HashSet<>();
        for (T obj : coll) {
            if (p.test(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    public static <T> int find(Collection<T> coll, Predicate<T> p) {
        int index = 0;
        for (T obj : coll) {
            if (p.test(obj)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Predicate<Integer> evenPredicate = number -> number % 2 == 0;

        remove(numbers, evenPredicate);
        System.out.println(numbers);  // Output: [1, 3, 5]

        retain(numbers, evenPredicate);
        System.out.println(numbers);  // Output: [1, 3, 5]

        Set<Integer> evenNumbers = collect(numbers, evenPredicate);
        System.out.println(evenNumbers);  // Output: [1, 3, 5]

        int index = find(numbers, evenPredicate);
        System.out.println(index);  // Output: -1
    }


}
