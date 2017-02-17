package exceptions;

public class OutOfStockException extends Exception {
	String itemName;
	public OutOfStockException(String itemName) {
	    super();
	    this.itemName= itemName;
	}

	public String getOutOfStockItemName(){
		return itemName;
	}
}
