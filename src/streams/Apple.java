package streams;

public class Apple {
    /**
     * streams tutorial
     */
    private String color;
    private int weight;

    public Apple(String color, int weight) {
       this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "streams.Apple: " +
                " color: " + getColor() +
                ", weight: " + getWeight();
    }


}
