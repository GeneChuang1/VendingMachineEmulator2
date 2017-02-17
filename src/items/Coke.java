package items;

import java.util.ArrayList;
import java.util.Arrays;

public class Coke extends AbstractItem{
	
	static private String itemID= Tags_ListOfItems.coke;
	static ArrayList<String> aliasNames= new ArrayList<>(Arrays.asList("Coke", "Coca Cola", "coke", "Coca-Cola", "c", "Cola", "cola"));;
	
	public Coke(){
		super (itemID, 0.50, aliasNames);
	}
	
}
