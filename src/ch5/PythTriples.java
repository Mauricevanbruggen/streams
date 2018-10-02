package ch5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythTriples {
    public static void main(String[] args) {

        /**
         * Okay, what’s the flatMap about? First, you create a numeric range from 1 to 100 to
         * generate values for a. For each given value of a you’re creating a stream of triples.
         * Mapping a value of a to a stream of triples would result in a stream of streams! The
         * flatMap method does the mapping and also flattens all the generated streams of
         * triples into a single stream. As a result you produce a stream of triples. Note also
         * that you change the range of b to be a to 100. There’s no need to start the range at
         * the value 1 because this would create duplicate triples (for example, (3, 4, 5) and
         * (4, 3, 5))
         */

        //create pytagoran triples
        Stream<int []> pytriples =
                IntStream.rangeClosed(1, 100).boxed() // use a range from 1 - 100 boxed is used to convert numstream back to stream
                        .flatMap(a ->
                                IntStream.rangeClosed(a ,100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0) // use filter to include only ints
                                        .mapToObj(b ->
                                                new int [] {a, b, (int)Math.sqrt(a * a + b *b)})
                        );

        //in pystream 2 filter after mapping to reduce calculations
        Stream<double []> pytriples2 =
                IntStream.rangeClosed(1, 100).boxed() // use a range from 1 - 100 boxed is used to convert numstream back to stream
                        .flatMap(a ->
                                IntStream.rangeClosed(a ,100)
                                         .mapToObj(
                                                 b -> new double [] {a, b, Math.sqrt(a * a + b *b)})
                                .filter(t -> t[2] % 1 == 0));

  //      pytriples2.limit(10)
//                .forEach(t ->
//                        System.out.println("triplets: " + t[0] + ", " + t[1] + ", " + t[2]));

        Stream.iterate(0, n -> n + 2)
                .limit(50)
                .forEach(System.out::println);

    }
}
