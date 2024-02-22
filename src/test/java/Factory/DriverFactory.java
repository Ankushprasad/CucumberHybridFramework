package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	static WebDriver driver=null;
	public static void intializeBrowser(String browsername) {
		if(browsername.equals("Chrome")) {
			 driver=new ChromeDriver();
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}
}
