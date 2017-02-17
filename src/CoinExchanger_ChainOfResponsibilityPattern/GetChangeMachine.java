package CoinExchanger_ChainOfResponsibilityPattern;

import com.gene.sample.CustomerCash_Singleton;

public class GetChangeMachine {
	
	public GetChangeMachine(CustomerCash_Singleton customerCash){
		QuarterDispenser quarterDispenser= new QuarterDispenser();		
		quarterDispenser.calculateChange(customerCash);
	}
}
