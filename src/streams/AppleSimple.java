package streams;

public class AppleSimple implements AppleFormat {
    public String accept (Apple apple) {
        String out = apple.getWeight() > 150 ? "heavy " :
                "light";
        return "A " + out + " " + apple.getWeight() + " apple";
    }
}
