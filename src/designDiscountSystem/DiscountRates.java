package designDiscountSystem;

public class DiscountRates {
	
	private static double productDiscountRate = 0.1;
	private static double serviceDiscountPremium = 0.2;
	private static double serviceDiscountGold = 0.15;
	private static double serviceDiscountSilver = 0.1;
	
	
	public static double getServiceDiscountRate(String memberType) {
		memberType = memberType.toLowerCase();
		if(memberType.contentEquals(new StringBuffer("premium"))) {
			return serviceDiscountPremium;
		}else if(memberType.contentEquals(new StringBuffer("gold"))) {
			return serviceDiscountGold;
		}else {
			return serviceDiscountSilver;
		}
	}
	
	/* @AdminAccessOnly */
	public static void setServiceDiscountRate(String memberType, double newServiceDiscountRate) {
		memberType = memberType.toLowerCase();
		if(memberType.contentEquals(new StringBuffer("premium"))) {
			serviceDiscountPremium = newServiceDiscountRate;
		}else if(memberType.contentEquals(new StringBuffer("gold"))) {
			serviceDiscountGold = newServiceDiscountRate;
		}else {
			serviceDiscountSilver = newServiceDiscountRate;
		}
	}
	
	public static double getProductDiscountRate() {
		return productDiscountRate;
	}
	
	/* @AdminAccessOnly */
	public static void setProductDiscountRate(double newProductDiscountRate) {
		productDiscountRate = newProductDiscountRate;
	}
}
