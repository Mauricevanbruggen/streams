package primeProj;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.*;

public class ToListCollector implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
      return ArrayList<T>::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return null;
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
