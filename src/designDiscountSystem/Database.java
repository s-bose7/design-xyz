package designDiscountSystem;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;


public class Database {
	
	private static String couponPath = "D:\\LZ3\\LZ3-core-programming\\Java\\DesignXYZ\\src\\designDiscountSystem\\validCoupons.csv";
	
	public static List<String[]> readAllCoupons() throws Exception {
		try {
			CSVReader csvReader = new CSVReader(new FileReader(couponPath));
			List<String[]> rows = csvReader.readAll();
			csvReader.close();
			return rows;
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public static void writeCoupon(String[] coupon) throws Exception {
		try {
			List<String[]> data = readAllCoupons();
			CSVWriter csvWriter = new CSVWriter(new FileWriter(couponPath));
			String[] headerFields = {"Coupon", "validFrom", "validUpto", "discountPercentage"};
			if(data.isEmpty() || !data.get(0)[0].equals(headerFields[0])) {
				data.add(headerFields);
			}
			data.add(coupon);
			csvWriter.writeAll(data);
			System.out.println("New Coupons stored in DB");
			csvWriter.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
