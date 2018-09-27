package streams;

import java.util.ArrayList;
import java.util.List;

abstract class TestPredicate implements Predicate {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) { // uses the method test of Predicate
                result.add(e);
            }
        }
        return result;
    }
}