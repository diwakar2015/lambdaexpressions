package lambdaexpressions;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class StreamExamples {

	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		long startMili = Calendar.getInstance().getTimeInMillis();
		// This will take around 10 seconds to give the sum of all the numbers, as every time we calling the method doubleIt it sleeps for 1 sec
		System.out.println("Total sum is using sequential :"+
				values.stream()
				      .mapToInt(StreamExamples::doubleIt)
				      .sum());
		
		long endMili = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Time taken is for sequential processing  :"+ ((endMili-startMili)/1000.0) + " seconds");
		startMili = Calendar.getInstance().getTimeInMillis();
		// This will take around 1-2 seconds only to give the sum of all the numbers, as we are processing parallel.
				System.out.println("Total sum is using parallel:"+
						values.parallelStream()
						      .mapToInt(StreamExamples::doubleIt)
						      .sum());
				 endMili = Calendar.getInstance().getTimeInMillis();
				 System.out.println("Time taken is for parallel processing  :"+ ((endMili-startMili)/1000.0) + " seconds");
	}
	
	public static int doubleIt(int number)
	{
		// Sleeping for 1 sec everytime this method is called
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		}
		
		return number * 2;
		
	}
	
}
