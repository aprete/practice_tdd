package mars_rover;

import java.util.Objects;

public class Rover {

    private Direction direction;
    Coordinates coordinates;

    public Rover(final int x, final int y, final String direction) {
        this.direction = Direction.create(direction);
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(final String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l"))
            {
                rotateLeft();
            }
            if (command.equals("r"))
            {
                rotateRight();
            }
            if (command.equals("f"))
            {
                moveForwards();
            }
            if (command.equals("b"))
            {
                moveBackwards();
            }
        }
    }

    private void rotateLeft()
    {
        this.direction = direction.rotateLeft();
    }

    private void rotateRight()
    {
        this.direction = direction.rotateRight();
    }

    private void moveForwards()
    {
        int displacement = 1;
        move(displacement);
    }

    private void moveBackwards()
    {
        int displacement = -1;
        move(displacement);
    }

    private void move(final int displacement)
    {
        if (faceNorth())
        {
            coordinates = coordinates.moveAlongY(displacement);
        }
        else if (faceSouth())
        {
            coordinates = coordinates.moveAlongY(-displacement);
        }
        else if (faceWest())
        {
            coordinates = coordinates.moveAlongX(-displacement);
        }
        else
        {
            coordinates = coordinates.moveAlongX(displacement);
        }
    }

    private boolean faceWest()
    {
        return direction.equals(Direction.W);
    }

    private boolean faceSouth()
    {
        return direction.equals(Direction.S);
    }

    private boolean faceNorth()
    {
        return direction.equals(Direction.N);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", coordinates=" + coordinates +
                '}';
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
        Rover rover = (Rover) o;
        return direction == rover.direction &&
                Objects.equals(coordinates, rover.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, coordinates);
    }
}
