package mars_rover;

import java.util.Objects;

public class Rover
{

    private static final int DISPLACEMENT = 1;

    private Direction direction;

    Coordinates coordinates;

    public Rover(final int x, final int y, final String direction)
    {
        this.direction = Direction.create(direction);
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(final String commandsSequence)
    {
        for (int i = 0; i < commandsSequence.length(); ++i)
        {
            String command = commandsSequence.substring(i, i + 1);

            execute(command);
        }
    }

    public void execute(String command)
    {
        if (command.equals("l"))
        {
            this.direction = direction.rotateLeft();
        }
        if (command.equals("r"))
        {
            this.direction = direction.rotateRight();
        }
        if (command.equals("f"))
        {
            coordinates = direction.move(coordinates, DISPLACEMENT);
        }
        if (command.equals("b"))
        {
            coordinates = direction.move(coordinates, -DISPLACEMENT);
        }
    }

    @Override
    public String toString()
    {
        return "Rover{" + "direction=" + direction + ", coordinates=" + coordinates + '}';
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Rover rover = (Rover) o;
        return direction == rover.direction && Objects.equals(coordinates, rover.coordinates);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(direction, coordinates);
    }
}
