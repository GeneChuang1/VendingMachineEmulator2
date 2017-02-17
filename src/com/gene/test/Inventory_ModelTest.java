package com.gene.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gene.sample.Inventory_Model;

import exceptions.CashInsufficientException;
import exceptions.OutOfStockException;
import exceptions.UnknownItemException;
import items.AbstractItem;
import items.Coke;

public class Inventory_ModelTest {
	static Inventory_Model myInventory_Model;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myInventory_Model= new Inventory_Model();
	}

	@Before
	public void setUp() throws Exception {
	}

	/*@Test
	//AbstractItem getItemByName(String desiredItem)
	public void test() throws OutOfStockException, CashInsufficientException, UnknownItemException {
		Object result= myInventory_Model.getItemByName("Coke");
		assertEquals(Coke.class, result);
	}
*/
}
