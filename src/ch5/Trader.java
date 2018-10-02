package ch5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Trader {

    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String toString(){
        return "Trader: "+this.name + " in " + this.city;
    }

    public static class TraderApp {
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

            List <Transaction> trans2011Sorted =
                    transactions.stream()
                            .filter(transaction -> transaction.getYear() == 2011)
                            .sorted(comparing(Transaction::getValue).reversed())
                            .collect(toList());
            System.out.println("all transactions of 2011 sorted low to high: " + trans2011Sorted);

            List <String> cities =
                    transactions.stream()
                    .map(transaction -> transaction.getTrader().getCity())
                    .collect(toList());

            System.out.println("List all unique cities: " + cities);

            List<Trader> camBTraders =
                    transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
            System.out.println("All the traders from cambridge: " + camBTraders);

                    String allTraders =
                    transactions.stream()
                    .map(transaction -> transaction.getTrader().getName())
                    .distinct()
                    .sorted()
                    .collect(joining());
                  //  .reduce("", (n1, n2) -> n1 + n2);
            System.out.println("All traders: " + allTraders);

            boolean traderMilan =
                    transactions.stream()
                            .anyMatch(transaction -> transaction.getTrader()
                                    .getCity()
                                    .equals("Milan"));
            System.out.println("Is there a Trader in Milan? " + traderMilan);

            transactions.stream()
                    .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);

            Optional<Integer> highestValue =
                    transactions.stream()
                    .filter(t -> t.getTrader()
                            .getName()
                            .equals("Mario"))
                    .map(Transaction::getValue)
                    .reduce(Integer::min);
            System.out.println("Lowest value by Mario: " + highestValue);

            Optional<Transaction> lowestVal =
                    transactions.stream()
                    .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
            System.out.println("Lowest value of all transactions: " + lowestVal);

            Optional<Transaction> betterIMplLow =
                    transactions.stream()
                    .min(comparing(Transaction::getValue));
            System.out.println("same as before but better implmented: " + betterIMplLow);
        }





    }
}
