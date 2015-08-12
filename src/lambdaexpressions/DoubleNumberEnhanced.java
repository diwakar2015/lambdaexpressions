package lambdaexpressions;

import java.util.Arrays;
import java.util.List;


public class DoubleNumberEnhanced {
	
public static void main(String[] args) {
	
	// Find the double of the first even number greater than 3
	
	List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
		
	System.out.println(values.stream()
	       .filter(DoubleNumberEnhanced::isGreaterThan3)
	       .filter(DoubleNumberEnhanced::isEven)
	       .map(DoubleNumberEnhanced::doubleNumber)
	       .findFirst()
	       .get());
	}

public static boolean isGreaterThan3(int number) {
	return number > 3;
}

public static boolean isEven(int number)
{
	return number % 2==0;
	
}

public static int doubleNumber(int number)
{
	return number*2;
}

}
