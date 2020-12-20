package pac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;





public class SampleJDBCCode {

	public static void main(String[] args) throws SQLException, IOException {
	   //step-1 : register the databade Driver
		        Driver driverref = new Driver();
		        DriverManager.registerDriver(driverref);
		        
	   //step-2 : get the connection to data base
		        FileInputStream fis = new FileInputStream("./dataBaseConfig.properties");
		        Properties p = new Properties();
		        p.load(fis);
		       
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", p);
		        
	   //step 3 : issue create statement object
		        Statement stat = con.createStatement();
		        
	   //step 4 : execute Query
		        ResultSet result = stat.executeQuery("select * from project");
		        
		        while(result.next()) {
		        	System.out.println(result.getString(1) + "\t"+result.getString(2) + "\t"+result.getString(4));
		        	
		        }

	   //step 5 : close the connection	
		        con.close();

	}

}
