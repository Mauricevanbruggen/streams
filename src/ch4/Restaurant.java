package ch4;

import streams.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Restaurant {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

//        List<String> threeHighCal =
//                menu.stream()
//                .filter(d -> d.getCalories() > 13)
//                .map(Dish::getName)
//                .limit(9)
//                .collect(toList());
//        System.out.println(threeHighCal);
//
//        List<String> names =
//                menu.stream()
//                .filter(d -> {
//                    System.out.println("filtering " + d.getName());
//                    return d.getCalories() > 300;
//                })
//                .map(d -> {
//                    System.out.println("mapping " + d.getName());
//                    return d.getName();
//                })
//                        //.skip(2)
//                .limit(6)
//                .collect(toList());
//        System.out.println(names);

        List<Integer> calories =
                menu.stream()
                        .map(Dish::getCalories)
                        .sorted()
                        .collect(toList());

        //      System.out.println(calories);

        //Old ways
        List<Dish> vega = new ArrayList<>();
        for (Dish d : menu) {
            if (d.isVega()) {
                vega.add(d);
            }
        }
        boolean isHealthy = menu.stream()
                .noneMatch(d -> d.getCalories() > 10000 );
 //       System.out.println("isHealty " + isHealthy);


        // using negation on boolean function
        List<Dish> nonVegaDishes =
                menu.stream()
                        .filter(d -> !(d.isVega()))
                        .collect(toList());
        //      System.out.println(nonVegaDishes);


        List<String> words = Arrays.asList("Beer", "wine", "Vodka", "Cola");

        List<String> uniqueWords =
                words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
              //  .distinct()
                .collect(toList());
 //       System.out.println("words: " + words);
 //      System.out.println("unique: " + uniqueWords);

        List<Integer> nmbs = Arrays.asList(1,2,3,4,5,6);

        List<Integer> squares =
        nmbs.stream()
        .map(n -> n*n)
        .collect(toList());

    //    System.out.println(squares);

        List<Integer> set1 = Arrays.asList(1,2,3);
        List<Integer> set2 = Arrays.asList(3,4);

        List<int []> pairs =
            set1.stream()
            .flatMap(i ->
                    set2.stream()
                        .filter(j -> (i + j ) %3 == 0)
                        .map(j -> new int[] {i,j})
            )
            .collect(toList());
     //   System.out.println(pairs);
        List<Integer> someNumbers = Arrays.asList(1,4,6,12,2,6,7);
        Optional<Integer> firstDivByEight =
                someNumbers.stream()
                .filter(x -> x % 2 == 0)
                .findAny();



    //   System.out.println("firstdiv: " + firstDivByEight);
        List<Integer> numbers2 = Arrays.asList(2, 3, 6, 1, 5, 8, 10);
        Optional<Integer> maxNumb = numbers2.stream().reduce((a, b) -> (a - b ));
 //       System.out.println("maxNum: " + maxNumb);

        int  countDish =
        menu.stream()
            .map( d -> 1) // map each element into number 1
            .reduce(0, (a, b) -> a + b);
        System.out.println(countDish);
    }
}
