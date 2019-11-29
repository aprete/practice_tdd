package mars_rover;

public enum Direction
{
    N {
        @Override
        public Direction rotateLeft() {
            return Direction.W;
        }

        @Override
        public Direction rotateRight() {
            return Direction.E;
        }
    }, S {
        @Override
        public Direction rotateLeft() {
            return Direction.E;
        }

        @Override
        public Direction rotateRight() {
            return Direction.W;
        }
    }, E {
        @Override
        public Direction rotateLeft() {
            return Direction.N;
        }

        @Override
        public Direction rotateRight() {
            return Direction.S;
        }
    }, W {
        @Override
        public Direction rotateLeft() {
            return Direction.S;
        }

        @Override
        public Direction rotateRight() {
            return Direction.N;
        }
    };

    public static Direction create(final String directionEnconding)
    {
        if ("S".equals(directionEnconding))
        {
            return S;
        }
        if ("E".equals(directionEnconding))
        {
            return E;
        }
        if ("W".equals(directionEnconding))
        {
            return W;
        }
        if ("N".equals(directionEnconding))
        {
            return N;
        }

        throw new IllegalArgumentException();
    }

    abstract public Direction rotateLeft();

    abstract public Direction rotateRight();
}
