package pac;

import java.util.Date;
import java.util.Random;

public class SampleDateTest {

	public static void main(String[] args) {
		
		
		  Date dateObj = new Date(); 
		  String curentSystemtDate = dateObj.toString(); 
          System.out.println(curentSystemtDate);    //Fri Dec 11 15:51:55 IST 2020
          String[] arr = curentSystemtDate.split(" ");
          String day = arr[0];
          String date = arr[2];
          String month = arr[1];
          String year = arr[5];
          
		
			/*
			 * Random random = new Random(); int i = random.nextInt(10000); //
			 * System.out.println(i);
			 * 
			 * //createCustomer String cutomerName = "HDFC_"+i;
			 * System.out.println(cutomerName);
			 * 
			 * // add five Product & get the count String intialcount = "5"; // remove two
			 * product from the Cart String finalcount = "3";
			 * 
			 * int intCount = Integer.parseInt(intialcount); int intFinlCount =
			 * Integer.parseInt(finalcount);
			 */
		 

		

	}

}
