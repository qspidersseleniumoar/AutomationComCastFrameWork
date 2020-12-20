package sample;

public class ConnectionOracle implements Connection{

	public Statement createSatement() {
		System.out.println("Oracle db implemation......");
		return null;
		
	}

}
