package items;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class AbstractItem {
	private String itemID;
	private ArrayList<String> itemNames;
	private double itemPrice=0;
	//private int currentAmount=0;
	
	AbstractItem(String itemId, double itemPrice, ArrayList<String> aliasNames){
		this.itemID= itemId;
		this.itemPrice= itemPrice;
		itemNames= aliasNames;
	}
	
	public String getName(){
		return itemID;
		//return this.itemNames.get(0);
	}
	
	public boolean checkIsAlias(String name){
		for (int i=0; i!= itemNames.size(); i++){
			if(itemNames.get(i).equals(name)){
				return true;
			}
		}
		return false;
	}

	public double getPrice(){
		return this.itemPrice;
	}
	
	//public void setNumberOfUnits(int numberItemsToAdd){
	//	currentAmount= numberItemsToAdd;
	//}
}
