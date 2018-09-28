package ch5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TraderApp {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//
//        Stream<Transaction> trans2011Sorted =
//                transactions.stream()
//                .filter(year -> year.getYear() == 2011)
//
    }
}
