package com.gene.sample;

import java.util.ArrayList;
import java.util.HashMap;

import CoinExchanger_ChainOfResponsibilityPattern.GetChangeMachine;
import exceptions.CashInsufficientException;
import exceptions.OutOfStockException;
import exceptions.UnknownItemException;
import items.AbstractItem;

public class Inventory_Model {
	private static ArrayList<AbstractItem> inventory= new ArrayList<AbstractItem>();
	private static HashMap<String, Integer> quantityOfEachItem= new HashMap<String, Integer>();
	StockBoy_FactoryPattern mStockBoy= new StockBoy_FactoryPattern();
	private CustomerCash_Singleton customerCash;
	int quantityOrdered=1;
	
	public void add(String itemToAdd){
		inventory.add(mStockBoy.createInventory(itemToAdd));
		setQuantityForItem(itemToAdd);
	}
	
	private void setQuantityForItem(String item){
		quantityOfEachItem.put(item, mStockBoy.numberOfItemsStocked());
	}
	
	void displayInventory(){
		System.out.println("The current inventory is:"); 
		System.out.println("1) Item= "+ inventory.get(0).getName()+ ", Price= $"+ inventory.get(0).getPrice()+", Quantity in stock= " + quantityOfEachItem.get(inventory.get(0).getName()));
		System.out.println("2) Item= "+ inventory.get(1).getName()+ ", Price= $"+ inventory.get(1).getPrice()+", Quantity in stock= " + quantityOfEachItem.get(inventory.get(1).getName()));
		System.out.println("3) Item= "+ inventory.get(2).getName()+ ", Price= $"+ inventory.get(2).getPrice()+", Quantity in stock= " + quantityOfEachItem.get(inventory.get(2).getName()));
	}
	
	public AbstractItem getItemByName(String desiredItem) throws OutOfStockException, CashInsufficientException, UnknownItemException {
		AbstractItem customerItem = null;

		for (int i=0; i!= inventory.size(); i++){
			AbstractItem checkForAlias= inventory.get(i);
			boolean isAliasName= checkForAlias.checkIsAlias(desiredItem);
			
			if(isAliasName){
				customerItem= inventory.get(i);
			}
		}
		
		if (customerItem==null){
			throw new UnknownItemException();
		}
		
		boolean response1= checkSufficientQuantity(customerItem.getName(), quantityOrdered);
		boolean response2= checkSufficientFunds (customerItem, quantityOrdered);
		if (response1 && response2){
			updateInventory(customerItem.getName(), quantityOrdered);
			
			double newBalance= customerCash.getInstance().getCustomerCashCurrentBalance()- (customerItem.getPrice()*quantityOrdered);
			customerCash.getInstance().updateCustomerCash(newBalance);
			//customerCash= customerCash- (customerItem.getPrice()*quantityOrdered);  //OriginalCode
			return customerItem;
		} 
		return null; //Will hit this if quantityOrdered is greater than current stockQuantity of that item.
	}

	public AbstractItem getItemByNum(int desiredItem) throws OutOfStockException, CashInsufficientException{		
		AbstractItem customerItem= inventory.get(desiredItem-1);
		boolean response1= checkSufficientQuantity(customerItem.getName(), quantityOrdered);
		boolean response2= checkSufficientFunds (customerItem, quantityOrdered);
		if (response1 && response2){
			updateInventory(customerItem.getName(), quantityOrdered);
			double newBalance= customerCash.getInstance().getCustomerCashCurrentBalance()- (customerItem.getPrice()*quantityOrdered); 
			customerCash.getInstance().updateCustomerCash(newBalance);
					//customerCash= customerCash- (customerItem.getPrice()*quantityOrdered); //OriginalCode
			return customerItem;
		} 
		return null; //Will hit this if quantityOrdered is greater than current stockQuantity of that item.
	}
	
	private boolean checkSufficientQuantity(String itemName, int updateAmount) throws OutOfStockException{
		int currentAmount= quantityOfEachItem.get(itemName);
		if (currentAmount<= 0)throw new OutOfStockException(itemName);
		
		if (currentAmount-updateAmount >= 0){
				return true;
		} else {
			System.out.println("Sorry, we don't have enough of that item to fill your order");
			System.out.println("Please choose a different item. \n");
			return false;
		}
	}
	
	private boolean checkSufficientFunds(AbstractItem customerItem, int quantityOrdered) throws CashInsufficientException{
		double totalPrice= customerItem.getPrice()* quantityOrdered;
		if (customerCash.getInstance().getCustomerCashCurrentBalance()>totalPrice){
			return true;
		}else{
			throw new CashInsufficientException();
		}
	}

	private void updateInventory(String itemName, int amountTaken){
		int currentAmount= quantityOfEachItem.get(itemName);
		quantityOfEachItem.replace(itemName, (currentAmount-amountTaken));			
	}
	
	public void putMoneyIn(double cash){
		customerCash.getInstance().addMoreMoney(cash);
		//this.customerCash=this.customerCash+ customerCash; //Original Code
		System.out.println("Your current amount= "+ this.customerCash.getInstance().getCustomerCashCurrentBalance());
	}

	public double cashOutAndGetChange(){
		GetChangeMachine customerChange = new GetChangeMachine(customerCash);

		return 0;
		//Original Code
		//double tempHolder= customerCash;
		//customerCash=0;
		//return tempHolder;
	}
	
	public double getCashInSystem(){
		return customerCash.getInstance().getCustomerCashCurrentBalance();
	}
}

