package sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.commonutils.ExcelUtility;

public class AddToCart2 {
	ExcelUtility elib = new ExcelUtility();
	@Test(dataProvider = "getDataForAddToCartTest")
	public void addToCart(String catg , String version , Object qty) {
		System.out.println("execute add to cart");
	}
	
	@DataProvider
	public Object[][] getDataForAddToCartTest() throws Throwable {
	
		
		int rowCount = elib.getRowCount("addToCartTest");
		Object[][] objArr = new Object[rowCount][3];
		
		
		for(int i=0; i<rowCount;i++) {
			objArr[i][0] = elib.getExcelData("addToCartTest", i, 0);
			objArr[i][1] = elib.getExcelData("addToCartTest", i, 1);
			objArr[i][2] = elib.getExcelData("addToCartTest", i,2);
		}
		return objArr;
		
	}

}
