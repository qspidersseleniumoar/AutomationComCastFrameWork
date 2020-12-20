package sample;

class DriverManager{   
	 static  Connection c1 = null;     //java.sql    
        private DriverManager() {}
        
	  public static Connection getConnection(String dbname){
		  if(dbname.contentEquals("testyantra")) {
		    c1 = new ConnectionTy();
	      }else if(dbname.equals("oracle")) {
	    	c1 = new ConnectionOracle();  
	      }else if(dbname.equals("db2")) {
	    	c1 = new ConnectionDB2();  
	      }

		return c1;
	   }
}


interface Connection {                                          // API
	public Statement createSatement();		

}
interface Statement{
	public void executeQury();
}



public class Run {
	public static void main(String[] args) {
		Connection c1 = DriverManager.getConnection("orcale");
		Statement s = c1.createSatement();
		}
}