import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class ArrayMerge {
	public static void main (String[] args)    
	
	{   
		
		List<Integer> arr1 = new ArrayList<Integer>(List.of(2,3,4,5,7,5,8,9,5));
		List<Integer> arr2 = new ArrayList<Integer>(List.of(1,5,9));
		arr1.addAll(arr2);
	  
		List<Integer> ResultArray =Stream.concat( arr1.stream().filter(i -> !i.equals(5)),  
				arr1.stream().filter(i -> i.equals(5))).collect(Collectors.toList()) ;
		System.out.println(ResultArray);
	}
 
}
