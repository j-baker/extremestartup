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
    public void should_get_largest() {
        assertEquals(server.answer("which of the following numbers is the largest: 12, 15"), "15");
    }
}
