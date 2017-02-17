package items;

import java.util.ArrayList;
import java.util.Arrays;

public class SnickersBar extends AbstractItem{
	static private String itemID= (String) Tags_ListOfItems.snickersBar;
	static ArrayList<String> aliasNames= new ArrayList<>(Arrays.asList("SnickersBar", "snickers", "snicker", "Snickers", "Snicker", "SnickersBar", "SnickerBar", "Snickers Bar", "Snicker Bar", "snickersbar", "snickerbar", "snick", "s"));

	public SnickersBar(){
		super (itemID, 1, aliasNames);
	}
	
}
