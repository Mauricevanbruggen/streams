package ch4;

import streams.Predicate;

import java.lang.reflect.Type;

public class Dish {

    private final String name;
    private final boolean vega;
    private final int calories;
    private final Type type;
 //   private final CalLevel calLevel;


    public Dish(String name, boolean vega, int calories, Type type) {
        this.name = name;
        this.vega = vega;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVega() {
        return vega;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }



    public enum Type { MEAT, FISH, OTHER}

    public enum CalLevel {DIET, NORMAL, FATTY}

    public enum isGood {GOOD, BAD}
}
