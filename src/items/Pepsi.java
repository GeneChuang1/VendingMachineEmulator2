package items;

import java.util.ArrayList;
import java.util.Arrays;

public class Pepsi extends AbstractItem {
	static private String itemID= Tags_ListOfItems.pepsi;
	static ArrayList<String> aliasNames= new ArrayList<>(Arrays.asList("Pepsi", "Pepsi Cola", "pepsi", "p"));;

	public Pepsi(){
		super (itemID, 0.25, aliasNames);
	}
	
}
