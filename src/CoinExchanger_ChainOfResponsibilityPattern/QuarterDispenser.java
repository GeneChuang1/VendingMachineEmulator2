package CoinExchanger_ChainOfResponsibilityPattern;

import com.gene.sample.CustomerCash_Singleton;

public class QuarterDispenser implements DispenserInterface{
	private DispenserInterface nextInChain= new DimeDispenser();

	@Override
	public void calculateChange(CustomerCash_Singleton customerCash) {
		double cash= customerCash.getInstance().getCustomerCashCurrentBalance();
		int numQuarters= (int) (cash/0.25);
		System.out.println("Here is " +numQuarters+ " quarters. ");
		
		//Old Code-works
		//double leftOverAmount= cash- (numQuarters*0.25);
		//customerCash.updateCustomerCash(leftOverAmount);
		
		customerCash.getInstance().subtractMoney(numQuarters*0.25);
		nextInChain.calculateChange(customerCash);
	}
}
