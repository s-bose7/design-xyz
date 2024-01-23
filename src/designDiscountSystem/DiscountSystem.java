package designDiscountSystem;

import java.util.Date;
import java.util.List;

public class DiscountSystem {
	
	private Customer customer;
	private double couponCodeDiscount;
	private double standardTaxAmount;
	private double totalAmountPurchased;
	private boolean serviceDiscountApplied;
	private boolean productDiscountApplied;
	
	
	public DiscountSystem(
			Customer customer, 
			Date purchaseDate, 
			double totalAmountPurchased, 
			boolean serviceDiscountApplied,
			boolean productDiscountApplied
		) {
		
		this.customer = customer;
		this.totalAmountPurchased = totalAmountPurchased;
		this.serviceDiscountApplied = serviceDiscountApplied;
		this.productDiscountApplied = productDiscountApplied;
		this.standardTaxAmount = 0.05;
		this.couponCodeDiscount = 0.0;
	}
	
	
	private double applyStandardTaxAmountOnPurchase(double totalExpenseExcludingTaxes) {
		totalExpenseExcludingTaxes += totalExpenseExcludingTaxes*standardTaxAmount;
		return totalExpenseExcludingTaxes;
	}
	
	private boolean couponCodeValid(String coupon) throws Exception{
		/*If coupon present in DB and valid in terms of date, return true*/
		List<String[]> dbCoupons = Database.readAllCoupons();
		for(String[] dbCoupon : dbCoupons) {
			if(dbCoupon[0] == coupon) {
				this.couponCodeDiscount = Double.parseDouble(dbCoupon[3]);
				return true;
			}
		}
		return false;
	}
	
	private double getCouponCodeDiscount(String coupon) {
		return this.couponCodeDiscount;
	}
	
	public double totalExpenseIncludingTaxes() throws Exception {
		double totalExpenseExcludingTaxes = totalAmountPurchased;
		if(productDiscountApplied) {
			double discountAmount = DiscountRates.getProductDiscountRate();
			totalExpenseExcludingTaxes -= totalExpenseExcludingTaxes*discountAmount;
		}
		if(serviceDiscountApplied) {
			/* Based on the purchase frequency of the customer determine which service tier discount should apply */
		}
		if(customer.hasPromocode()) {
			String promocode = customer.getCoupon();
			/* Verify coupon against the coupons currently valid in the coupon database.
			 * If valid coupon then apply the corresponding discount on overall price; */
			if (couponCodeValid(promocode)) {
				double couponDiscount = getCouponCodeDiscount(promocode);
				totalExpenseExcludingTaxes -= totalExpenseExcludingTaxes*couponDiscount;
			}
			
		}
		double totalExpenseIncludingTaxes = applyStandardTaxAmountOnPurchase(totalExpenseExcludingTaxes);
		return totalExpenseIncludingTaxes;
	}

}
