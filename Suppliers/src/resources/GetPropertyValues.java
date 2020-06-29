package resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {
String total="";
InputStream inputStream;
public String getProp() throws IOException {
	try {
		Properties prop=new Properties();
		String propFName="config.properties";
		inputStream=getClass().getClassLoader().getResourceAsStream(propFName);
		if(inputStream!=null) {
			prop.load(inputStream);
		}
		else {
			throw new FileNotFoundException("Property file"+propFName+"is not found");
		}
		String Driver_Class=prop.getProperty("Driver_Class");
		String JDBC_URL=prop.getProperty("JDBC_URL");
		total="Driver_Class"+Driver_Class+"JOBC_URL"+JDBC_URL;
		System.out.println(total);
	} catch (Exception e) {
		System.out.println("Exception" +e);
	}finally {
		inputStream.close();
	}
	return total;
}
}
