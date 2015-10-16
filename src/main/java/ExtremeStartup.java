import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExtremeStartup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("q");

        System.out.println("A request has arrived:");
        System.out.println(parameter);

        resp.getWriter().write(answer(parameter));
    }
    
    Optional<String> tryAnswer(String parameter) {
        Matcher additionMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(parameter);
        if (additionMatcher.matches()) {
            return Optional.of(String.valueOf(Integer.parseInt(additionMatcher.group(1))
                    + Integer.parseInt(additionMatcher.group(2))));
        }
		return Optional.empty();
    }

    String answer(String parameter) {
        if (parameter == null)
            return "A";

		Optional<String> tryAnswer = tryAnswer(parameter);
		if (tryAnswer.isPresent()) {
			return tryAnswer.get();
		}
        
        Matcher additionMatcher3 = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(parameter);
        if (additionMatcher3.matches()) {
            return String.valueOf(Integer.parseInt(additionMatcher3.group(1))
                    + Integer.parseInt(additionMatcher3.group(2)));
        }

        Matcher additionMatcher2 = Pattern.compile(".*which of the following numbers is the largest: (\\*)").matcher(parameter);
        if (additionMatcher2.matches()) {
        	return "" + largest(additionMatcher2.group(1));
        }
       
        System.err.println("Unknown q" + parameter);
        return "A";
    }

    int largest(String s) {
    	String [] split = s.split(", ");
    	int max = Integer.MIN_VALUE;
    	for (int i = 0; i < split.length; i++) {
    		max = Math.max(max, Integer.parseInt(split[i]));
    	}
    	return max;
    }
}
