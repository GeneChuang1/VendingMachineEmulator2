package com.gene.sample;

import items.AbstractItem;
import items.Coke;
import items.Pepsi;
import items.SnickersBar;
import items.Tags_ListOfItems;

public class StockBoy_FactoryPattern {
	public static int maximumCapacityPerItem= 2;

	public AbstractItem createInventory(String itemName){
		AbstractItem item = null;
		
		if(itemName.equals(Tags_ListOfItems.pepsi)){
			item= new Pepsi(); 
		} else if(itemName.equals(Tags_ListOfItems.coke)){
			item= new Coke(); 
		} else if(itemName.equals(Tags_ListOfItems.snickersBar)){
			item= new SnickersBar(); 
		}
		return item;
	}
	
	public int numberOfItemsStocked(){
		return maximumCapacityPerItem;
	}
}
