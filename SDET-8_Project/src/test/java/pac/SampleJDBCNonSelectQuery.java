package pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box.Filler;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		int result=0;
		try {
	   //step-1 : register the databade Driver
		        Driver driverRef = new Driver();
		        DriverManager.registerDriver(driverRef);
		        
	   //step-2 : get the connection to data base
		         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		        
	   //step 3 : issue create statement object
		        Statement stat = con.createStatement();
		        
	   //step 4 : execute Query
		         result= stat.executeUpdate("insert into project values('TY_PROJ_991', 'Avi', '04/11/2020', 'autotmation','Completed',20)");
		       
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			   //step 5 : close the connection	
			 if(result==1) {
		        	System.out.println("project created");
		        }else {
		        	System.err.println("project not created");
		        }
	        con.close();
	        System.out.println("close Connection");
		}



	}

}
