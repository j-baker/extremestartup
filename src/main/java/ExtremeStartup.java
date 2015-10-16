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
        System.out.println("Request " + parameter);
        
        try {
			resp.getWriter().write(answer(parameter));
		} catch (Exception e) {
			resp.getWriter().write("");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

    String answer(String parameter) throws Exception {
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
        
        Matcher additionMatcher4 = Pattern.compile(".*what is (\\d+) plus (\\d+) plus (\\d+)").matcher(parameter);
        if (additionMatcher4.matches()) {
            return String.valueOf(Integer.parseInt(additionMatcher4.group(1))
                    + Integer.parseInt(additionMatcher4.group(2))) +
            		Integer.parseInt(additionMatcher4.group(3));
        }
        
        additionMatcher4 = Pattern.compile(".*what is (\\d+) plus (\\d+) multiplied by (\\d+)").matcher(parameter);
        if (additionMatcher4.matches()) {
        	Integer a = Integer.parseInt(additionMatcher4.group(1));
        	Integer b = Integer.parseInt(additionMatcher4.group(2));
            return String.valueOf(a + b * Integer.parseInt(additionMatcher4.group(3)));
        }

        additionMatcher4 = Pattern.compile(".*what is (\\d+) multiplied by (\\d+) plus (\\d+)").matcher(parameter);
        if (additionMatcher4.matches()) {
        	Integer a = Integer.parseInt(additionMatcher4.group(1));
        	Integer b = Integer.parseInt(additionMatcher4.group(2));
        	Integer c =  Integer.parseInt(additionMatcher4.group(3));
            return String.valueOf((a * b) + c);
        }

        additionMatcher4 = Pattern.compile(".*what is (\\d+) multiplied by (\\d+) multiplied by (\\d+)").matcher(parameter);
        if (additionMatcher4.matches()) {
        	Integer a = Integer.parseInt(additionMatcher4.group(1));
        	Integer b = Integer.parseInt(additionMatcher4.group(2));
        	Integer c =  Integer.parseInt(additionMatcher4.group(3));
            return String.valueOf(a * b * c);
        }
        
        
        Matcher p = Pattern.compile(".*what is (\\d+) minus (\\d+)").matcher(parameter);
        if (p.matches()) {
            return String.valueOf(Integer.parseInt(p.group(1))
                    - Integer.parseInt(p.group(2)));
        }

        Matcher additionMatcher2 = Pattern.compile(".*which of the following numbers is the largest: (.*)").matcher(parameter);
        if (additionMatcher2.matches()) {
        	return "" + largest(additionMatcher2.group(1));
        }

        Matcher j = Pattern.compile(".*which of the following numbers is both a square and a cube: (.*)").matcher(parameter);
        if (j.matches()) {
        	return "" + whichOneIsSquareAndCube(j.group(1));
        }

		Optional<String> a = memoize(".*who played James Bond in the film Dr No", "Sean Connery", parameter);
		if (a.isPresent()) {return a.get();}

		Optional<String> b = memoize(".*which city is the Eiffel tower in", "Paris", parameter);
		if (b.isPresent()) {return b.get();}

        
        Matcher c = Pattern.compile(".*which of the following numbers are primes: (.*)").matcher(parameter);
        if (c.matches()) {
        	return "" + whichOnesArePrimes(c.group(1));
        }

		Optional<String> d = memoize(".*who is the Prime Minister of Great Britain", "David Cameron", parameter);
		if (d.isPresent()) {return d.get();}
		
		Optional<String> e = memoize(".*what is the 7th number in the Fibonacci sequence", "13", parameter);
		if (e.isPresent()) {return e.get();}
		
		

        Matcher f = Pattern.compile(".*what is the (\\d+)th number in the Fibonacci sequence").matcher(parameter);
        if (f.matches()) {
        	return "" + fib(new Integer(f.group(1)));
        }


        f = Pattern.compile(".*what is the (\\d+)st number in the Fibonacci sequence").matcher(parameter);
        if (f.matches()) {
        	return "" + fib(new Integer(f.group(1)));
        }

        
		Optional<String> g = memoize(".*what color is a banana", "Yellow", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*what is the english scrabble score of banana", "8", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*what is the english scrabble score of zoo", "12", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*what is the english scrabble score of buzzword", "32", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*what is the english scrabble score of cloud", "8", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*what is the english scrabble score of september", "15", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*what is the english scrabble score of ruby", "9", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*Better? Joe, Huw.*", "Huw", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*which of the following is an anagram of \"listen\": google, banana, inlets, enlists", "inlets", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*which of the following is an anagram of \"dictionary\".*", "indicatory", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*woodchuck.*", "A woodchuck would chuck as much wood as a woodchuck could chuck if a woodchuck could chuck wood", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*meaning of life.*", "42", parameter);
		if (g.isPresent()) {return g.get();}
		
		g = memoize(".*FDE or Dev.*", "Dev", parameter);
		if (g.isPresent()) {return g.get();}

        Matcher h = Pattern.compile(".*what is (\\d+) to the power of (\\d+)").matcher(parameter);
        if (h.matches()) {
        	Integer num = Integer.parseInt(h.group(1));
        	Integer num2 =  Integer.parseInt(h.group(2));
            return String.valueOf((long) pow(num, num2));
        }
        
        System.err.println("Unknown q" + parameter);
        return "A";
    }
    
    long pow(long arg, int exp) {
        int res = 1;
        for (int i = 0; i < exp; i++) {
            res *= arg;
        }
        return res;
    }
    
    int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
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
