import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int topcount = 2;
		Map<String, ArrayList<String>> orders = new HashMap <String, ArrayList<String>>();
		
		orders.put("order 1", new ArrayList<String>(Arrays.asList("item 1", "item 2")));
		orders.put("order 2", new ArrayList<String>(Arrays.asList( "item 3")));
		orders.put("order 3", new ArrayList<String>(Arrays.asList( "item 2")));
		orders.put("order 4", new ArrayList<String>(Arrays.asList("item 1", "item 2")));
        //End of inputs
		//System.out.println(orders);
        // list to store all items from all orders
		ArrayList<String> allItems = new ArrayList<String>();
        // storing all it
		orders.values().stream().forEach(i -> allItems.addAll(i));
        
		//count of each items
		Map<String, Long> itemsCount= allItems.stream().collect(Collectors.groupingBy(e ->e, Collectors.counting()));
		//System.out.println(itemsCount);
		
		List <Long> maxVals= new ArrayList<Long>();
		maxVals.add((long) 0);
		
		Map < String, Long > topItems = new HashMap < String, Long > (); // key-value pair of frequently ordered items & its frequency

		// logic to fetch frequent items and frequency
		for (int c = 0 ; c < topcount ; c++) { 
		
		Long maxCount = itemsCount.values().stream().filter(i -> !maxVals.contains(i)).max(Long::compare).get();
		
		Map<String, Long> topItem = itemsCount.entrySet().stream().filter(j -> (j.getValue()==maxCount))
				.collect(Collectors.toMap(map -> map.getKey(),map -> map.getValue()))	;
		maxVals.add(maxCount);
		//System.out.println(topItem);
		topItems.putAll(topItem);
		}
	     //Printing corresponding Orders of the frequent items
		topItems.entrySet().stream().sorted(Map.Entry.comparingByValue()).sorted(Map.Entry.comparingByKey()).forEach( i -> {
			System.out.print( i.getKey()+" -> usuage count : " + i.getValue()  +"; corresponding Orders: ");
			orders.entrySet().stream().filter(o -> o.getValue().contains(i.getKey())).forEach (f -> {
				System.out.print(f.getKey()+ " ");
			});
			
			System.out.println();
		});
		
	}
}
