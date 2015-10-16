import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup();

    @Test
    public void should_accept_missing_input() throws Exception {
        assertThat(server.answer(null), is("A"));
    }

    @Test
    public void should_add_numbers() throws Exception {
        assertThat(server.answer("what is the sum of 14 and 4"), is("18"));
    }

    @Test
    public void should_get_largest_of_two() throws Exception {
        assertThat(server.answer("which of the following numbers is the largest: 12, 15"), is("15"));
    }

    @Test
    public void should_get_largest_of_three() throws Exception {
        assertThat(server.answer("which of the following numbers is the largest: 12, 15, 17"), is("17"));
    }

    @Test
    public void should_return_no_cube() throws Exception {
        assertThat(server.answer("which of the following numbers is both a square and a cube: 36, 144"), is("None"));
    }

    @Test
    public void should_get_largest() throws Exception {
        assertThat(server.answer("which of the following numbers is the largest: 12, 15, 17"), is("17"));
    }

    @Test
    public void shoud_be_sean_connery() throws Exception {
        assertThat(server.answer("who played James Bond in the film Dr No"), is("Sean Connery"));
    }


    @Test
    public void should_be_7th_prime() throws Exception {
        assertThat(server.answer("what is the 7th number in the Fibonacci sequence"), is("13"));
    }

    @Test
    public void should_be_12th_prime() throws Exception {
        assertThat(server.answer("what is the 12th number in the Fibonacci sequence"), is("144"));
    }

    @Test
    public void should_be_10th_power_of_7() throws Exception {
        assertThat(server.answer("what is 10 to the power of 7"), is("1000000"));
    }
}
