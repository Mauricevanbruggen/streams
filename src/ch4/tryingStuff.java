package ch4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class tryingStuff {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("Hallo" , "Hoe " , " is " , " met je ");
        Stream <String> s = myList.stream();
        s.forEach(System.out::println);
    }
}
