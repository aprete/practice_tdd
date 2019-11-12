package mars_rover;

public enum Direction
{
    N, S, E, W;

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

}
