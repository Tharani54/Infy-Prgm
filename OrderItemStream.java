import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class OrderItemStream {
	static List<String> arr = new ArrayList<>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size =4;
		String[] key = new String[3];
	    Long[] Value = new Long[3];
		ArrayList<String> [] order= new ArrayList[size];
		int topcount = 2;
		//initializing
		 for ( int i = 0;i<size;i++) {
			 order[i]= new ArrayList<String>();
		 } 
		 //items are hard coded for now, but we can change the item list below and number
		 order[0].add("item 1");
		 order[0].add("item 2");
		 
				 
		 order[1].add("item 3");
		
		 order[2].add("item 2");
		 
		 order[3].add("item 1");
		 order[3].add("item 2");
		
		 					
		 ArrayList<String> arr = new ArrayList<String>();//list of all items
		 
		 for (int i = 0;i<size;i++) {
			for (int j=0;j<order[i].size();j++)
			{
				 arr.add(order[i].get(j));//adding all items to the list
			 }
		 }
		
		//to count the each item
		Map<String, Long> counts= arr.stream().collect(Collectors.groupingBy(e ->e, Collectors.counting()));
		//System.out.println(counts);
	    Map<String,Long> sort = counts
	    		.entrySet()
	    		.stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	    		.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1,e2)-> e1,LinkedHashMap::new));
	   // System.out.println(sort);
	     

		   
	     for (int i = 0;i<topcount;i++) {
	    	  key[i] = (String) sort.keySet().toArray()[i];
	    	  Value[i]= (Long) sort.values().toArray()[i];
	    
	    	  System.out.print(key[i] +" -> usuage count : " + Value[i]+ "; corresponding Orders: ");
	    	  for (int j = 0; j < size;j++) {
					if(order[j].contains(key[i])) {
					System.out.print("Order " + (j + 1) + " " );
					}
				}
				System.out.println();
		 }
	
	
  }
}


