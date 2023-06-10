package baseContainer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utilities.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase2 {
    public static WebDriver driver; // Initiate our driver
	public static Properties config = new Properties(); //Initiate our config file
	public static FileInputStream fis1; // file reader
	//public static FileInputStream fis2; // file reader its optional you can decide to use fis1 for both
	public static Properties OR  = new Properties(); //Initiate browser
	//public static Properties dataSaver  = new Properties();
	public static String browser; //Amenity codes
	Utility utils = new Utility(); //Get the location of our project 
	String projectlocation = System.getProperty("user.dir");
	
	@BeforeTest
	public void setup() {				// creating a method
	if(driver == null) {
			try {
				fis1 = new FileInputStream(projectlocation+"\\src\\main\\resources\\propertyFile\\config.properties"); //connecting with our file ie config.properties file
			} catch(FileNotFoundException e) {     //error management
				e.printStackTrace();
			}
			try {
				config.load(fis1);
			} catch(IOException m) {  //calling our config.file again 
				m.printStackTrace();
			}
			try {
				fis1 = new FileInputStream(projectlocation+"\\src\\main\\resources\\propertyFile\\OR.properties"); //connecting with the file OR.properties & the project 
			} catch(FileNotFoundException orf) {     //error management                         //location define so for others to be able to work on 
				orf.printStackTrace();
			}
			try {
				OR.load(fis1);
			} catch(IOException orn) {
				orn.printStackTrace();
			}	
			//try {
			//	fis2 = new FileInputStream(projectlocation+"\\src\\main\\resources\\propertyFile\\config.properties"); //connecting with the file OR.properties & the project 
			//} catch(FileNotFoundException orf) {     //error management                         //location define so for others to be able to work on 
			//	orf.printStackTrace();
			//}
			//try {
			//	OR.load(fis2);
		//	} catch(IOException orn) {
		//		orn.printStackTrace();
			//}
		}
	if (System.getenv("browser") != null && System.getenv("browser").isEmpty()) {  // calling blank or an invalid browser
			
		browser = System.getenv("browser");
		}
	else {
		browser = config.getProperty("browser"); //calling our browser ie our config.properties
		}
		config.setProperty("browser", browser);
	
	if(config.getProperty("browser").equals("Firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(); 
	}
	else if (config.getProperty("browser").equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	driver.get(config.getProperty("baseURL"));
}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
