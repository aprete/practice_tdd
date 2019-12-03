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

        @Override
        protected Coordinates move(final Coordinates coordinates, final int displacement)
        {
            return coordinates.moveAlongY(displacement);
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

        @Override
        protected Coordinates move(final Coordinates coordinates, final int displacement)
        {
            return coordinates.moveAlongY(-displacement);
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

        @Override
        protected Coordinates move(final Coordinates coordinates, final int displacement)
        {
            return coordinates.moveAlongX(displacement);
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

        @Override
        protected Coordinates move(final Coordinates coordinates, final int displacement)
        {
            return coordinates.moveAlongX(-displacement);
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

    protected abstract Coordinates move(Coordinates coordinates, int displacement);
}
