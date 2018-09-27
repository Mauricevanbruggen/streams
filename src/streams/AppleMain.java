package streams;

import java.util.ArrayList;
import java.util.List;

public class AppleMain {

    public static void main(String[] args) {
        List<Apple> testList = new ArrayList<>();
        AppleGreenColorPredicate green = new AppleGreenColorPredicate();
        AppleWeightPredicate weight = new AppleWeightPredicate();

        Apple apple1 = new Apple("green", 101);
        Apple apple2 = new Apple("red", 101);
        Apple apple3 = new Apple("yellow", 101);
        Apple apple4 = new Apple("green", 10);
        Apple apple5 = new Apple("yellow", 10);
        Apple apple6 = new Apple("green", 1212);
        Apple apple7 = new Apple("green", 12389);
        Apple apple8 = new Apple("green", 10123789);
        testList.add(apple1);
        testList.add(apple2);
        testList.add(apple3);
        testList.add(apple4);
        testList.add(apple5);
        testList.add(apple6);
        testList.add(apple7);
        testList.add(apple8);
        filterApple(testList, green);
        System.out.println(testList);
        System.out.println(filterApple(testList, weight));
    }

    public static List <Apple> filterApple(List <Apple> inv , ApplePredicate pred ) {
        List <Apple> res = new ArrayList<>();
        for(Apple apple : inv) {
            if(pred.test(apple)) {
                res.add(apple);
            }
        }
        return res;
    }

    public static void printAppleList(List <Apple> inv, ApplePredicate pred) {
        for(Apple apple : inv) {
            String out =
        }
    }
}
