package CoinExchanger_ChainOfResponsibilityPattern;

import com.gene.sample.CustomerCash_Singleton;

public class DimeDispenser implements DispenserInterface {
	private DispenserInterface nextInChain= new NickelDispenser();

	@Override
	public void calculateChange(CustomerCash_Singleton customerCash) {
		double cash= customerCash.getInstance().getCustomerCashCurrentBalance();
		int numDimes= (int) (cash/0.1);
		System.out.println("Here is " +numDimes+ " dimes. ");
		
		//Old Code- Works
		//double leftOverAmount= cash- (numDimes*0.1);
		//customerCash.updateCustomerCash(leftOverAmount);
		
		customerCash.getInstance().subtractMoney(numDimes*0.1);
		nextInChain.calculateChange(customerCash);
	}
}
