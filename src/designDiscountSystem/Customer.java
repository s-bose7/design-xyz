package designDiscountSystem;

public class Customer {
	
	private String customerName;
	private boolean customerIsMember;
	private String memberType;
	private boolean hasCoupon;
	private String coupon;
	
	public Customer(String name) {
		this.customerName = name;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getMemberType() {
		if(!isMember()) {
			return "Regular user";
		}
		return memberType;
	}
	
	public void setMember(String memberType) {
		customerIsMember = true;
		this.memberType = memberType;
	}
	
	public boolean isMember() {
		return customerIsMember;
	}
	
	public boolean hasPromocode() {
		return hasCoupon;
	}
	
	public String getCoupon() {
		if(!hasPromocode()) {
			return "";
		}
		return coupon;
	}
	
	public void setCoupon(String coupon) {
		hasCoupon = true;
		this.coupon = coupon;
	}
	
}
