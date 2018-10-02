package streams;

        import java.util.Arrays;
        import java.util.List;
        import java.util.function.BiFunction;

        import static streams.TestPredicate.filter;
        import static streams.AcceptStringPredicate.printStuff;


public class AppleMain {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 155),
                new Apple("red", 120));
        Runnable r = () -> {
            System.out.println("------------------");
        };
        printStuff(inventory, (Apple apple) -> apple.toString());
        r.run();
        List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        printStuff(redApples, (Apple apple) -> (redApples.toString()));
        r.run();
        List<Apple> heavyApples = filter(inventory, (Apple apple) -> 150 < apple.getWeight());
        printStuff(heavyApples, (Apple apple) -> (heavyApples.toString()));

        System.out.println(filter(inventory, (Apple a) -> a.getColor().equals("")));

        BiFunction<String, Integer, Apple> redApple = Apple::new;
        redApple.apply("green", 12098);


    }
}

