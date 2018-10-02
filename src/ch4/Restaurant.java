package ch4;

import streams.Predicate;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Restaurant {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("confit de canard", false, 1000, Dish.Type.MEAT),
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
       // System.out.println(countDish);

        int countTotCalories =
                menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
      //  System.out.println("Total Calories: " + countTotCalories);
       // System.out.println(" number of dishes: " + menu.stream().count());

        Comparator<Dish> dishCaloryComparator =
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloryDish =
                menu.stream()
                .collect(maxBy(dishCaloryComparator));
   //    System.out.println("Most calory dish: " + mostCaloryDish);

        // print total calories
    //    int totalCal = menu.stream().collect(summingInt(Dish::getCalories));
        double avCal = menu.stream().collect(averagingInt(Dish::getCalories));
        //using reduce with collect
     //   int totalCal = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        // get total cal by mapping and reducing
     //   int totalCal = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get(); // not safe when list is empty
        int totalCal = menu.stream().mapToInt(Dish::getCalories).sum(); // in this case the best solution
   //     System.out.println("total: " + totalCal);
        //old fashion way
        double res = 0;
        int num = menu.size();
        for(int i = 0; i <menu.size(); i++) {
            res +=  menu.get(i).getCalories();
        }
 //       System.out.println("old school: " + res/num);

        IntSummaryStatistics menusStats =
                menu.stream().collect((summarizingInt(Dish::getCalories)));
      //  System.out.println("summary stats: " + menusStats);

        String shortMenu2 = menu.stream().map(Dish::getName).collect(joining());
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
     //   String shortMenu3 = menu.stream().collect( reducing(d1, d2) -> d1.getName() )).get();
    //    System.out.println("Shortmenu: " + shortMenu2);

        //Grouping
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        //System.out.println("DishesbyType: " +dishesByType);

        Map<Dish.CalLevel, List<Dish>> dishesByCalLevel = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() < 500) return Dish.CalLevel.DIET;
            else if (dish.getCalories() <= 700) return Dish.CalLevel.NORMAL;
            else return Dish.CalLevel.FATTY;
        }));
        System.out.println("Dishes by Calorie level: " + dishesByCalLevel);
    }
}
