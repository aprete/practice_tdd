package mars_rover;

public class Rover {

    private Direction direction;
    private int y;
    private int x;

    public Rover(final int x, final int y, final String direction) {
        this.direction = Direction.create(direction);
        this.y = y;
        this.x = x;
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
        if (faceNorth())
        {
            this.direction = Direction.W;
        }
        else if (faceSouth())
        {
            this.direction = Direction.E;
        }
        else if (faceWest())
        {
            this.direction = Direction.S;
        }
        else
        {
            this.direction = Direction.N;
        }
    }

    private void rotateRight()
    {
        if (faceNorth())
        {
            this.direction = Direction.E;
        }
        else if (faceSouth())
        {
            this.direction = Direction.W;
        }
        else if (faceWest())
        {
            this.direction = Direction.N;
        }
        else
        {
            this.direction = Direction.S;
        }
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
            y += displacement;
        }
        else if (faceSouth())
        {
            y -= displacement;
        }
        else if (faceWest())
        {
            x -= displacement;
        }
        else
        {
            x += displacement;
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
    public String toString()
    {
        return "Rover [directionType=" + direction + ", y=" + y + ", x=" + x + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (direction == null ? 0 : direction.hashCode());
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Rover other = (Rover) obj;
        if (direction != other.direction)
        {
            return false;
        }
        if (x != other.x)
        {
            return false;
        }
        if (y != other.y)
        {
            return false;
        }
        return true;
    }
}
