package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	static Properties pro;
	
	public static Properties readProperties() {
		File file = new File("./data.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pro;
	}
	

}
