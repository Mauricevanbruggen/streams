package streams;

public class AppleFancy implements AppleFormat {
    public String accept(Apple apple) {
        String chararcteristic = apple.getWeight() > 150 ? "heavy" :
                "light";
        return "A " + chararcteristic + " "
                + apple.getColor() + " apple";
     }
}
