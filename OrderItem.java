import java.util.*;
public class OrderItem{
    public static void main(String[] args) {
        int size= 4; //Order size
        ArrayList < String > [] order = new ArrayList[size];

        // initializing 
        for (int i = 0; i < size; i++) {
        	order[i] = new ArrayList < String > ();
        }
        //items are hard coded for now, but we can change the item list below and number of orders line#4.
        order[0].add("item1");
        order[0].add("item2");
        order[1].add("item3");
        order[2].add("item2");
        order[3].add("item1");
        order[3].add("item2");

        ArrayList < String > allItems = new ArrayList < String > (); //list of all items

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < order[i].size(); j++) {
                allItems.add(order[i].get(j)); //adding all items to the list
            }
        }

        String[] topitem = new String[2]; //to store top two items
        int[] topitemCount = new int[2]; // to store top two items' count
        int topCount1 = 0;
        int topCount2 = 0;

        for (int c = 0; c < allItems.size(); c++) { //logic to find top two items
            int tempCount = Collections.frequency(allItems, allItems.get(c));

            if (tempCount > topCount1) {
                topCount2 = topCount1;
                topitem[1] = topitem[0];
                topitemCount[1] = topitemCount[0];
                topCount1 = tempCount;
                topitem[0] = allItems.get(c);
                topitemCount[0] = tempCount;
            } 
            else if (tempCount > topCount2 && tempCount < topCount1) {
                topCount2 = tempCount;
                topitem[1] = allItems.get(c);
                topitemCount[1] = tempCount;
            }
        }

        for (int i = 0; i < 2; i++) { //Final output
            System.out.print(topitem[i] + " -> usage count : " + topitemCount[i] + "; Corresponding Orders: ");
            for (int j = 0; j < size ;j++) {
                if (order[j].contains(topitem[i])) {
                    System.out.print("Order" + (j + 1) + " ");
                }
            }
            System.out.println();
            
            //Assuming the count of each item will nt over lap
        }
    }
}