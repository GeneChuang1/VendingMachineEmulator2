package CoinExchanger_ChainOfResponsibilityPattern;

import com.gene.sample.CustomerCash_Singleton;

public interface DispenserInterface {

		//public void setNextChain(DispenserInterface nextDispenser);
		public void calculateChange(CustomerCash_Singleton customerCash);
}
