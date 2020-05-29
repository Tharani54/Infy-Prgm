import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;

public class ArrayMerge {
	public static void main (String[] args)    
	
	{   
	Integer[] arr1 = new Integer[] {2,3,4,5,7,5,8,9,5};   
	Integer[] arr2 = new Integer[]{1,5,6}; 
	Object[] arr3 = resultarray(arr1,arr2);
	System.out.println("Merged array: "+ Arrays.toString(arr3));  
	
	}    
		
	public static <T> Object[] resultarray(T[] arr1, T[] arr2)   
	{   
	return Stream.of(arr1,arr2).flatMap(Stream::of).toArray();  		
	}
		  
}
	
