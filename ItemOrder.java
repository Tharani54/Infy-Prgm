import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, ArrayList<String>> items = new HashMap <String, ArrayList<String>>();
		items.put("item 1", new ArrayList<String>(Arrays.asList("Order 1","Order 4")));
		items.put("item 2", new ArrayList<String>(Arrays.asList("Order 1","Order 2","Order 4")));
		items.put("item 3", new ArrayList<String>(Arrays.asList( "Order 3")));
		//items.put("item 4", new ArrayList<String>(Arrays.asList("Order 1","Order 4")));
	 
		List <Integer> maxVals= new ArrayList<Integer>();
		maxVals.add(0);
		
			 
		for (int c = 0 ; c < 2 ; c++) 
		 maxVals.add(items.values().stream().map(i -> i.size()).filter(j -> !maxVals.contains(j)).max(Integer::compare).get());
		
		
	      items.entrySet().stream().filter(i -> maxVals.contains(i.getValue().size())).forEach( f -> {
	    	  System.out.println(f.getKey() + " -> usuage count :  "+ f.getValue().size()  +"; corresponding Orders: "+f.getValue());
	      });

	}
}


