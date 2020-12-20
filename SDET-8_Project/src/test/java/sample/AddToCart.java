package sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCart {
	
	@Test(dataProvider = "getDataForAddToCartTest")
	public void addToCart(String catg , String version , int qty) {
		System.out.println("execute add to cart");
	}
	
	@DataProvider
	public Object[][] getDataForAddToCartTest() {
		Object[][] objArr = new Object[4][3];
		
		objArr[0][0] = "iphone";
		objArr[0][1] = "XR";
		objArr[0][2] = 10;
		
		objArr[1][0] = "nokia";
		objArr[1][1] = "1100";
		objArr[1][2] = 20;
		
		objArr[2][0] = "samsumg";
		objArr[2][1] = "a50";
		objArr[2][2] = 100;
		
		objArr[3][0] = "realm3";
		objArr[3][1] = "a50";
		objArr[3][2] = 100;
		return objArr;
		
	}

}
