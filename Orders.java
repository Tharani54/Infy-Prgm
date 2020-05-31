import java.util.*;
import java.util.stream.*;
public class Orders {
    public static void main(String[] args) {
        int topCount = 2;
        Map < String, ArrayList < String >> orders = new HashMap < String, ArrayList < String >> ();
        orders.put("Order 1", new ArrayList < String > (Arrays.asList("item1", "item3", "item5")));
        orders.put("Order 2", new ArrayList < String > (Arrays.asList("item1", "item2", "item4")));
        orders.put("Order 3", new ArrayList < String > (Arrays.asList("item4", "item6")));
        orders.put("Order 4", new ArrayList < String > (Arrays.asList("item1", "item5")));
        // End of inputs

        ArrayList < String > allItems = new ArrayList < String > (); // list to store all items from all orders
        
        orders.values().stream().forEach(i -> allItems.addAll(i)); // storing all items
        System.out.println(orders);

        Map < String, Long > itemsCount = allItems.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting())); // key-value pair of items & its frequency

        List < Long > maxVals = new ArrayList < Long > ();
        maxVals.add((long) 0);

        Map < String, Long > topItems = new HashMap < String, Long > (); // key-value pair of frequently ordered items & its frequency

        for (int c = 0; c < topCount; c++) { // logic to fetch frequent items and frequency
            Long maxCount = itemsCount.values().stream().filter(i -> !maxVals.contains(i)).max(Long::compare).get();

            Map < String, Long > topItem = itemsCount.entrySet().stream().filter(j -> j.getValue() == maxCount)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

            maxVals.add(maxCount);
            topItems.putAll(topItem);
        }

        //printing corresponding Orders of the frequent items
        topItems.entrySet().stream().sorted(Map.Entry. < String, Long > comparingByValue().reversed()).sorted(Map.Entry.comparingByKey()).forEach(i -> {
            System.out.print(i.getKey() + " -> usage count: " + i.getValue() + "; Corresponding Orders: ");
            orders.entrySet().stream().sorted(Map.Entry.comparingByKey()).filter(o -> o.getValue().contains(i.getKey())).forEach(fo -> {
                System.out.print(fo.getKey() + " ");
            });
            System.out.println();
        });
    }
}