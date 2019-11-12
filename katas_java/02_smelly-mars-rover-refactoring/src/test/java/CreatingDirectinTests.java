
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mars_rover.Direction;

public class CreatingDirectinTests
{
    @Test
    public void creating_directions_given_their_econding()
    {
        assertEquals(Direction.create("N"), Direction.N);
        assertEquals(Direction.create("S"), Direction.S);
        assertEquals(Direction.create("E"), Direction.E);
        assertEquals(Direction.create("W"), Direction.W);
    }

    @Test(expected = IllegalArgumentException.class)
    public void trying_to_create_an_unknown_direction_encoding()
    {
        Direction.create("X");
    }
}
