package ch3;

public class Orange {
    /**
     * streams tutorial
     */
    private String color;
    private int weight;

    public Orange(String color, int weight) {
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
        return "streams.Organge: " +
                " color: " + getColor() +
                ", weight: " + getWeight();
    }
}
