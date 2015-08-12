package lambdaexpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class LazyLoading {

	public static void main(String[] args) {
		
		//Create a predicate
		//Predicate<Integer> isGT3 = number -> number > 3;

		//Create a function which takes Integer and return Predicate
		//Below function takes an integer and return a predicate which is for checking the number greather than provided number
		
		Function<Integer, Predicate<Integer>> isGreatherThan = pivot -> number -> number > pivot;
		
		// Find the double of the first even number greater than 3

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		final Stream<Integer> temp = values.stream()
				//.filter(isGT3)
				.filter(isGreatherThan.apply(4))
				.filter(LazyLoading::isEven)
				.map(LazyLoading::doubleIt);
		// If you do not call the findFirst and get() methods, the above checking will never occur. that is lazy evaluation
		//Comment below line and see the output
		
		System.out.println(temp.findFirst().get());

	}

/*	public static boolean isGreaterThan3(int number) {
		System.out.println("isGreaterThan3 "+ number);
		return number > 3;
	}*/

	public static boolean isEven(int number)
	{
		System.out.println("isEven "+ number);
		return number % 2==0;

	}

	public static int doubleIt(int number)
	{
		System.out.println("doubeIt "+ number);
		return number*2;
	}

}

//output:
/*
isGreaterThan3 1
isGreaterThan3 2
isGreaterThan3 3
isGreaterThan3 4
isEven 4
doubeIt 4
8
 */