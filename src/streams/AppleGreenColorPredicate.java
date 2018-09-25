package streams;

public class AppleGreenColorPredicate implements ApplePredicate {
  public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}
