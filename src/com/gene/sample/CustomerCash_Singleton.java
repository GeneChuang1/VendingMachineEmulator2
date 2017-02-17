package com.gene.sample;

public class CustomerCash_Singleton {
	private static CustomerCash_Singleton instance= null;
	private double customerCash=0;
	
	private CustomerCash_Singleton(){
	}
	
	public static CustomerCash_Singleton getInstance(){
		if(instance == null) {
			instance = new CustomerCash_Singleton();
	    }
		return instance;
	}

	public double getCustomerCashCurrentBalance(){
		return Math.round(customerCash*100)/100d;
		//return this.customerCash;
	}
	
	public void addMoreMoney(double cash){
		double result= customerCash+ cash;
		customerCash= Math.round(result*100)/100d;
		
		//customerCash= customerCash+ cash;
	}
	
	public void subtractMoney(double cash){
		double result= customerCash- cash;
		customerCash= Math.round(result*100)/100d;

		//customerCash= customerCash- cash;
	}
	
	public void updateCustomerCash(double newBalance){
		customerCash= Math.round(newBalance*100)/100d;
		//customerCash= newBalance;
	}

}
