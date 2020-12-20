package pac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		//step 1 : get the java representation Object of the Physical File
		FileInputStream fis = new FileInputStream("./dataBaseConfig.properties");
		//step 2 : load all the Key in to Java Object using Properties class
		Properties p = new Properties();
		p.load(fis);
		//step 3 : using getProperty("key") read the value
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));
	}

}
