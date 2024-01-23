package designDiscountSystem;

import java.util.Date;

public class PurchaseOrder {
	
	private Customer customer;
	private Date purchaseDate;
	private double serviceExpense;
	private double productExpense;
	private boolean serviceDiscountApplied;
	private boolean productDiscountApplied;
	
	public PurchaseOrder(Customer customer, Date purchaseDate, double serviceExpense, double productExpense) {
		this.customer = customer;
		this.purchaseDate = purchaseDate;
		this.serviceExpense = serviceExpense;
		this.productExpense = productExpense;
	}
	
	public double netPurchasedPrice() throws Exception {
		double totalAmountPurchased = serviceExpense + productExpense;
		if(serviceExpense > 0.0) serviceDiscountApplied = true;
		if(productExpense > 0.0) productDiscountApplied = true;
		DiscountSystem ds = new DiscountSystem(customer, purchaseDate, totalAmountPurchased, serviceDiscountApplied, 
			productDiscountApplied
		);
		return ds.totalExpenseIncludingTaxes();
	}
	
	public String toString() {
		return "";
	}
}
