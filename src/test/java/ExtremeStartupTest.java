import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup();

    @Test
    public void should_accept_missing_input() {
        assertThat(server.answer(null), is("A"));
    }

    @Test
    public void should_add_numbers() {
        assertThat(server.answer("what is the sum of 14 and 4"), is("18"));
    }

    @Test
    public void should_get_largest_of_two() {
        assertThat(server.answer("which of the following numbers is the largest: 12, 15"), is("15"));
    }

    @Test
    public void should_get_largest_of_three() {
        assertThat(server.answer("which of the following numbers is the largest: 12, 15, 17"), is("17"));
    }

    @Test
    public void should_return_no_cube() {
        assertThat(server.answer("which of the following numbers is both a square and a cube: 36, 144"), is("None"));
    }

    @Test
    public void shoud_be_sean_connery() {
        assertThat(server.answer("who played James Bond in the film Dr No"), is("Sean Connery"));
    }

}
