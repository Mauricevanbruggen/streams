package streams;

import java.util.List;

abstract class AcceptStringPredicate implements Format {
    public static <T>void printStuff(List<T> list, Format<T> f) {
        for(T e : list) {
           System.out.println(f.accept(e));
        }
    }
}
