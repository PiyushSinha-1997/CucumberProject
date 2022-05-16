package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverfactory;
	private ConfigReader configreader;
	private WebDriver driver;
	Properties prop;

	@Before(order = 0)
	public void getproperty() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}

	@Before(order = 1)
	public void launchbrowser() {
		String browsername = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browsername);
	}

	@After(order = 0)
	public void quitbrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void teardown(Scenario sc) {
		if (sc.isFailed()) {
			String screenshotname1 = sc.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcepath, "image/png", screenshotname1);
		}
	}
}
