package com.selenium.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {
	private Properties prop = new Properties();
	private WebDriver driver = null;
	private WebDriverWait wait = null;

	public UtilityClass() {
		this.loadProperties();
		this.loadGlobalVariables();
		this.loadDrivers();

	}

	private void loadProperties() {
		try {
			prop.load(new FileReader("src/test/resources/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);

	}

	public void loadGlobalVariables() {
		GlobalVariables.browserName = this.getProperty("browserName");
		GlobalVariables.url = this.getProperty("url");
		GlobalVariables.timeout = Integer.parseInt(this.getProperty("timeout"));
	}

	private void loadDrivers() {
		if ("firefox".equals(GlobalVariables.browserName)) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {

			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.timeout));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

}
