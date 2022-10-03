import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vanim\\SeleniumWorkspace\\Introduction\\src\\data.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		if(prop.getProperty("browser").contains("chrome"))
			prop.setProperty("browser", "firefox");
		else
			prop.setProperty("browser", "chrome");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\vanim\\SeleniumWorkspace\\Introduction\\src\\data.properties");
		prop.store(fos, null);
		
	}

}
