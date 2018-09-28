package ch3;

import streams.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunStuff {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("A", "B", "C", "D", "V", "A", "H", "E", "B");
        System.out.println(myList);
        myList.sort(String::compareTo);
        System.out.println(myList);

        BiFunction<String, Integer, Apple> ap2 = Apple::new;
        ap2.apply("green", 12098);
        BiFunction<String, Integer, Apple> ap3 = Apple::new;
        ap3.apply("yellow",112389);

        Comparator<Apple> app = Comparator.comparing((Apple apple) -> apple.getWeight());
        System.out.println(app.toString());


    }
}
