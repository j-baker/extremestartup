import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup();

    @Test
    public void should_accept_missing_input() {
        assertThat(server.answer(null), equalTo("team name"));
    }

    @Test
    public void should_add_numbers() {
        assertThat(server.answer("what is the sum of 14 and 4"), equalTo("18"));
    }

    @Test
    public void should_get_largest() {
        assertThat(server.answer("which of the following numbers is the largest: 12, 15, 17"), is("17"));
    }
}
