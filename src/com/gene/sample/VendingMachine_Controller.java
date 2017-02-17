package com.gene.sample;

import exceptions.CashInsufficientException;
import exceptions.OutOfStockException;
import exceptions.UnknownItemException;
import items.AbstractItem;
import items.Pepsi;
import items.Tags_ListOfItems;

public class VendingMachine_Controller {
	private Inventory_Model inventory;
	boolean isOn = false;

	public void powerOn(boolean isOn) {
		this.isOn = isOn;
		inventory = new Inventory_Model();
		createInventory();
		displayInventory();
	}

	private void createInventory() {
		inventory.add(Tags_ListOfItems.pepsi);
		inventory.add(Tags_ListOfItems.coke);
		inventory.add(Tags_ListOfItems.snickersBar);
	}

	private void displayInventory() {
		inventory.displayInventory();
	}

	public void putMoneyIn(double customerCash) {
		inventory.putMoneyIn(customerCash);
	}

	public AbstractItem getItem(String desiredItem) {
		try {
			if (isInteger(desiredItem)) {
				int desiredItemNum = Integer.parseInt(desiredItem);
				return inventory.getItemByNum(desiredItemNum);
			} else {
				return inventory.getItemByName(desiredItem);
			}

		} catch (OutOfStockException | IndexOutOfBoundsException | CashInsufficientException |UnknownItemException e) {
			if(e instanceof OutOfStockException){
				String itemName= ((OutOfStockException) e).getOutOfStockItemName();
				System.out.println("Sorry, the current item is not available.");
				System.out.println("The system is calling the StockBoy to fill the inventory.");
				inventory.add(itemName);
				System.out.println("Okay, the stock of " + itemName+ " has been re-filled.");
				System.out.println("You may now purchase more " + itemName+ ". \n");
			} else if (e instanceof IndexOutOfBoundsException || e instanceof UnknownItemException){
				System.out.println("Sorry, that's not one of the number choices \n");
			} else if (e instanceof CashInsufficientException){
				System.out.println("Sorry, the amount of money you gave is not enough to cover the cost of the items.");
			} 
			//e.printStackTrace();
		}
		return null; //Shouldn't come here;
	}

	public boolean getOnOffState() {
		return this.isOn;
	}

	public void cashOutAndGetChange() {
		inventory.cashOutAndGetChange();
	}
	
	
	public double getCashInSystem(){
		return inventory.getCashInSystem();
	}

	private boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
}
