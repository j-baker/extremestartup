import java.io.IOException;
import java.math.BigInteger;
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
        System.out.println("Request");
        
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
    
    Optional<String> plus(String parameter) {
        Matcher additionMatcher3 = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(parameter);
        if (additionMatcher3.matches()) {
            return Optional.of(String.valueOf(Integer.parseInt(additionMatcher3.group(1))
                    + Integer.parseInt(additionMatcher3.group(2))));
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

		Optional<String> x = multiply(parameter);
		if (x.isPresent()) {
			return x.get();
		}
        
        Matcher additionMatcher3 = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(parameter);
        if (additionMatcher3.matches()) {
            return String.valueOf(Integer.parseInt(additionMatcher3.group(1))
                    + Integer.parseInt(additionMatcher3.group(2)));
        }

        Matcher additionMatcher2 = Pattern.compile(".*which of the following numbers is the largest: (\\\\*)").matcher(parameter);
        if (additionMatcher2.matches()) {
        	return "" + largest(additionMatcher2.group(1));
        }

        Matcher j = Pattern.compile(".*which of the following numbers is the largest: (\\*)").matcher(parameter);
        if (j.matches()) {
        	return "" + whichOneIsSquareAndCube(j.group(1));
        }

		Optional<String> a = memoize(".*who played James Bond in the film Dr No", "Sean Connery", parameter);
		if (a.isPresent()) {return a.get();}

		Optional<String> b = memoize(".*which city is the Eiffel tower in", "Paris", parameter);
		if (b.isPresent()) {return b.get();}

        
        Matcher c = Pattern.compile(".*which of the following numbers are primes: (\\*)").matcher(parameter);
        if (c.matches()) {
        	return "" + whichOnesArePrimes(j.group(1));
        }

		Optional<String> d = memoize(".*who is the Prime Minister of Great Britain", "David Cameron", parameter);
		if (d.isPresent()) {return d.get();}
        
        System.err.println("Unknown q" + parameter);
        return "A";
    }

    private Optional<String> memoize(String string, String string2, String parameter) {
        Matcher l = Pattern.compile(string).matcher(parameter);
        if (l.matches()) {
        	return Optional.of(string2);
        }
		return Optional.empty();
	}

	private Optional<String> multiply(String parameter) {
        Matcher additionMatcher3 = Pattern.compile(".*what is (\\d+) multiplied by (\\d+)").matcher(parameter);
        if (additionMatcher3.matches()) {
            return Optional.of(String.valueOf(Integer.parseInt(additionMatcher3.group(1))
                    * Integer.parseInt(additionMatcher3.group(2))));
        }
        return Optional.empty();
	}
	
	String whichOnesArePrimes(String s) {
        String[] split = s.split(", ");
        String result = "";
        for (int i = 0; i < split.length; i++) {
            if (BigInteger.valueOf((Integer.parseInt(split[i]))).isProbablePrime(100)) {
                return "" + Integer.parseInt(split[i]) + ", ";
            }
        }
        return result.substring(0, result.length() - 2);
    }

	int largest(String s) {
    	String [] split = s.split(", ");
    	int max = Integer.MIN_VALUE;
    	for (int i = 0; i < split.length; i++) {
    		max = Math.max(max, Integer.parseInt(split[i]));
    	}
    	return max;
    }
    boolean isSquare(int i) {
        int j = 0;
        while (j*j < i) {
            j++;
        }
        if (j*j == i) {
            return true;
        }
        return false;
    }

    boolean isCube(int i) {
        int j = 0;
        while (j*j*j < i) {
            j++;
        }
        if (j*j*j == i) {
            return true;
        }
        return false;
    }

    boolean isSquareAndCube(int i) {
        return isSquare(i) && isSquare(i);
    }

    String whichOneIsSquareAndCube(String s) {
        String[] split = s.split(", ");
        for (int i = 0; i < split.length; i++) {
            if (isSquareAndCube(Integer.parseInt(split[i]))) {
                return "" + Integer.parseInt(split[i]);
            }
        }
        return "" + Integer.MAX_VALUE;
    }
}
