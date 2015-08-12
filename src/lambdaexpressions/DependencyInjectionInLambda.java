package lambdaexpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DependencyInjectionInLambda {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Predicate<Integer> isEven = number -> number %2 == 0;
		
		System.out.println("Sum of all the numbers = "+ totalValues(numbers, e -> true));
		System.out.println("Sum of all even numbers = "+totalValues(numbers, isEven));
	}
	
	
	// Predicate is getting injected to the totalValues method, it is kind of strategy pattern
	public static int totalValues(List<Integer> numbers, Predicate<Integer> selector)
	{
		return numbers.stream()
				      .filter(selector)
				      .reduce(0, Math::addExact);
		
	}

}
