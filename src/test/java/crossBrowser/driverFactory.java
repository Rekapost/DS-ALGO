package crossBrowser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Loggerload;
public class driverFactory {
	public static WebDriver driver;
	//private static Logger logger = (Logger) LogManager.getLogger();
	//private static final Logger logger= (Logger) LogManager.getLogger(Loggerload.class);
	public WebDriver initializeDrivers(String browser) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		FileInputStream stream=new FileInputStream("C:\\Users\\Reka\\eclipse-workspace\\DS_ALGO_NN\\src\\test\\resources\\config.properties");
		Properties properties=new Properties();
		properties.load(stream);		
		//String browser=properties.getProperty("BROWSER");
		String driverLocation=properties.getProperty("CHROME_DRIVER_LOCATION");	 
		if(browser.equalsIgnoreCase("chrome"))
		{
			Loggerload.info("Testing on chrome");
			System.setProperty("webdriver.chrome.driver", driverLocation);
			driver =new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			Loggerload.info("Testing on firefox");
			System.setProperty("webdriver.gecko.driver", driverLocation);
			driver =new FirefoxDriver();	
		}
		 else if (browser.equalsIgnoreCase("safari")) {
			 Loggerload.info("Testing on safari");
			//WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();	
		}
		 else if (browser.equalsIgnoreCase("edge")) {
			 Loggerload.info("Testing on Edge");
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		// Set Page load timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
		return driver;	
	}
	
	public void closeallDriver() {
		driver.close();	
	}

	public static WebDriver getdriver() {
		return driver;
	}

}
