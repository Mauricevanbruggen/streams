package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static streams.AbstrPredicate.filter;


public class AppleMain  {

    public static void main(String[] args) {
        List<Apple> inventory =  Arrays.asList(new Apple("green", 80),
                                                    new Apple("green", 155),
                                                    new Apple("red", 120));

        List<Apple> heavyApples = filter(inventory, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(heavyApples);

        AppleGreenColorPredicate groen = new AppleGreenColorPredicate();

     //   List<Apple> greenApples2 = filterApple(inventory, (Apple a) -> "green".equals(a.getColor()));
  //      System.out.println(greenApples2);

//        printAppleList(testList, new AppleFancy());
//        printAppleList(testList, new AppleSimple());


    }

//    public static List <Apple> filterApple(List <Apple> inv , ApplePredicate pred ) {
//        List <Apple> res = new ArrayList<>();
//        for(Apple apple : inv) {
//            if(pred.test(apple)) {
//                res.add(apple);
//            }
//        }
//        return res;
//    }

//    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
//        List<T> result = new ArrayList<>();
//        for(T e :list) {
//            if(p.test(e)) {
//                result.add(e);
//            }
//        }
//        return result;
//    }

    public static void printAppleList(List <Apple> inv, AppleFormat format) {
        for(Apple apple : inv) {
            String out = format.accept(apple);
            System.out.println(out);
        }
    }

}

