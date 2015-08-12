package lambdaexpressions;

import java.util.stream.Stream;

public class InfiniteStreamBuild {
	
	public static void main(String[] args) {
		
		    Stream.iterate(1, e -> e + 1)
		      .filter(e -> e % 2 == 0)
		      .limit(100)
		      .forEach(System.out::println);
		      
		
	}

}
