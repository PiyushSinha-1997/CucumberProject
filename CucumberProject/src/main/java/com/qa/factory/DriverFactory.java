package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.util.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		System.out.println("browser value is :" + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			} else if (browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new SafariDriver());
		}

		else {
			System.out.println("Please pass the correct browser :" + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Wait.implicitly_wait, TimeUnit.SECONDS);
			return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
}