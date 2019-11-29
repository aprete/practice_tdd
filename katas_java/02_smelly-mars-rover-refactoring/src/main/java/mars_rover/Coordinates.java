package mars_rover;

import java.util.Objects;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates moveAlongY(final int displacement)
    {
        return new Coordinates(x, y + displacement);
    }

    public Coordinates moveAlongX(final int displacement)
    {
        return new Coordinates(x + displacement, y);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
