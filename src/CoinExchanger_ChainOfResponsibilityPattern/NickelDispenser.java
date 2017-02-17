package CoinExchanger_ChainOfResponsibilityPattern;

import com.gene.sample.CustomerCash_Singleton;

public class NickelDispenser implements DispenserInterface{
	private DispenserInterface nextInChain= new PennyDispenser();

	@Override
	public void calculateChange(CustomerCash_Singleton customerCash) {
		double cash= customerCash.getInstance().getCustomerCashCurrentBalance();
		int numNickels= (int) (cash/0.05);
		System.out.println("Here is " +numNickels+ " nickels. ");
		
		//Old Code- Works
		//double leftOverAmount= cash- (numNickels*0.05);
		//customerCash.updateCustomerCash(leftOverAmount);
		
		customerCash.getInstance().subtractMoney(numNickels*0.05);
		nextInChain.calculateChange(customerCash);
	}
}
