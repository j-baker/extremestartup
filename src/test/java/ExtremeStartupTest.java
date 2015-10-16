import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup();

    @Test
    public void should_accept_missing_input() {
        assertEquals(server.answer(null), "A");
    }

    @Test
    public void should_add_numbers() {
        assertEquals(server.answer("what is the sum of 14 and 4"), "18");
    }

    @Test
    public void should_get_largest_of_two() {
        assertEquals(server.answer("which of the following numbers is the largest: 12, 15"), "15");
    }

    @Test
    public void should_get_largest_of_three() {
        assertEquals(server.answer("which of the following numbers is the largest: 12, 15, 17"), "17");
    }

    @Test
    public void should_return_no_cube() {
        assertEquals(server.answer("which of the following numbers is both a square and a cube: 36, 144"), "None");
    }

    @Test
    public void shoud_be_sean_connery() {
        assertEquals(server.answer("who played James Bond in the film Dr No"), "Sean Connery");
    }

}
