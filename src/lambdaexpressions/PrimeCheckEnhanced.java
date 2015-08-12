package lambdaexpressions;

import java.util.stream.IntStream;


public class PrimeCheckEnhanced {
	
	public static void main(String[] args) {
		
		System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime(4));
		System.out.println(isPrime(5));
		System.out.println(isPrime(6));
	}

	private static boolean isPrime(final int number) {
		
		return number>1 &&
			   IntStream.range(2, number)
			            .noneMatch(PrimeCheckEnhanced::isDivisble);
	}
	
	public static boolean isDivisble(int number)
	{
	  return number % 2 == 0;	
		
	}

}
