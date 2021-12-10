package Task7.flower;

import java.io.Serializable;
import java.util.Objects;

public class Flower implements Serializable {
    private String name;
    private int stalkLength;
    private String origin;

    public Flower(String name, int stalkLength, String origin) {
        this.name = name;
        this.stalkLength = stalkLength;
        this.origin = origin;
    }

    public Flower() {}

    @Override
    public String toString() {
        return "Flower " +
                "is " + name +
                ", the height of the stalk " + stalkLength +
                " and the origin country is " + origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return stalkLength == flower.stalkLength &&
                Objects.equals(name, flower.name) &&
                Objects.equals(origin, flower.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stalkLength, origin);
    }
}