package com.gene.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import items.AbstractItem;

//http://localhost:8080/github-webhook/
public class Customer_View {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Customer_View customer = new Customer_View();
		VendingMachine_Controller mVendingMachine = new VendingMachine_Controller();
		mVendingMachine.powerOn(true);

		do {
			customer.getCash(mVendingMachine, br);
			customer.selectItem(mVendingMachine, br);
		} while (customer.continueOrNot(mVendingMachine, br));

		System.out.print("Here is your change: \n");
		mVendingMachine.cashOutAndGetChange();
		//System.out.println(mVendingMachine.cashOutAndGetChange());
	}

	private void getCash(VendingMachine_Controller mVendingMachine, BufferedReader br) {
		boolean invalidResponse = true;
		CustomerCash_Singleton customerCash;
		do {
			System.out.print("Give me money= ");
			try {
				double cash = Double.parseDouble(br.readLine());
				mVendingMachine.putMoneyIn(cash);
				invalidResponse=false;
			} catch (NumberFormatException | IOException nfe) {
				System.out.println("Invalid Format!");
			}
		} while (invalidResponse);
	}

	private void selectItem(VendingMachine_Controller mVendingMachine, BufferedReader br)
			throws NumberFormatException, IOException {
		System.out.println("Select the item you want.");
		String desiredItem = br.readLine();

		AbstractItem customerItem = mVendingMachine.getItem(desiredItem);
		if (customerItem != null) {
			System.out.println("You just bought a " + customerItem.getName());
		}
	}

	private boolean continueOrNot(VendingMachine_Controller mVendingMachine, BufferedReader br) throws IOException {
		boolean invalidResponse = true;
		do {
			System.out.println("You still have: " + mVendingMachine.getCashInSystem());
			System.out.println("Do you want to purchase more items?");
			String yesOrNo = br.readLine();
			if (yesOrNo.equals("y") || yesOrNo.equals("Y") || yesOrNo.equals("yes") || yesOrNo.equals("Yes")) {
				invalidResponse = false;
				return true;
			} else if (yesOrNo.equals("n") || yesOrNo.equals("N") || yesOrNo.equals("no")|| yesOrNo.equals("No")) {
				invalidResponse = false;
				return false;
			} else {
				System.out.println("Sorry, please enter a valid answer");
			}
		} while (invalidResponse);
		return false; // Should never reach this
	}
}
