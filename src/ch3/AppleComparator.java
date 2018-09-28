package ch3;

import streams.Apple;
import java.lang.Integer;
import java.util.Comparator;

public class AppleComparator implements Comparator<Apple> {
    public int compare(Apple app1 , Apple app2) {
        Integer a  = app1.getWeight();
        Integer b = app2.getWeight();
        return a.compareTo(b);
    }
}
