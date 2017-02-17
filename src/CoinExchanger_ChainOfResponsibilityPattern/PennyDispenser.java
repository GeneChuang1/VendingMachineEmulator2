package CoinExchanger_ChainOfResponsibilityPattern;

import com.gene.sample.CustomerCash_Singleton;

public class PennyDispenser implements DispenserInterface{
	//private DispenserInterface nextInChain= new PennyDispenser();

	@Override
	public void calculateChange(CustomerCash_Singleton customerCash) {
		double cash= customerCash.getInstance().getCustomerCashCurrentBalance();
		int numPennies= (int) (cash/0.01);
		System.out.println("Here is " +numPennies+ " pennies. ");
		
		//Old Code- Works
		//double leftOverAmount= cash- (numPennies*0.01);
		//customerCash.updateCustomerCash(leftOverAmount);
		
		customerCash.getInstance().subtractMoney(numPennies*0.01);
		//nextInChain.calculateChange(customerCash);
	}
}
