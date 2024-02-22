package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configReader;

public class MyHooks {
	
	
    WebDriver driver;
	
	@Before
	public void setup() {
		Properties prop = configReader.intializeProperties();
		DriverFactory.intializeBrowser(prop.getProperty("browsername"));
		driver=DriverFactory.getDriver();;
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}
	@After
	public void teardown(Scenario scenerio) {
		
		String scenerioName = scenerio.getName().replaceAll(" ","_");
		if(scenerio.isFailed()) {
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenerio.attach(srcScreenshot,"image/png", scenerioName);
			
			
		}
		
		driver.quit();
	}
}
