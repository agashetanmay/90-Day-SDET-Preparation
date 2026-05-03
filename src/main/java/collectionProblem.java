import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class collectionProblem {

	public static  Map<String, Integer> hmap = new HashMap<>();
	
	public static void sortbykey()
    {
        // TreeMap to store values of HashMap
        TreeMap<String, Integer> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(hmap);

        // Display the TreeMap which is naturally sorted
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) 
            System.out.println("Key = " + entry.getKey() + 
                         ", Value = " + entry.getValue());        
    }

	public static void main(String[] args) {
		
		hmap.put("cvb", 123);
		hmap.put("cvb", 222);
		hmap.put("ert", 333);
		hmap.put("mhjk", 444);
		hmap.put("asdfg", 555);
		
		
		sortbykey();

	}

}
