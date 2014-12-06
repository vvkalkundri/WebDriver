package com.microsoft.specs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase extends TestCase {
	protected static WebDriver driver;
	public static String URL;

	@Before
	public void setUp() throws IOException {
        String location = System.getProperty("user.dir") + "\\src-ui\\com\\microsoft\\config";
		File file = new File(location+ "\\" +"Configuration.properties");
		FileInputStream f1 = new FileInputStream(file);
		
		Properties properties = new Properties();
		properties.load(f1);
		String homeurl = properties.getProperty("MICROSOFTURL");
		

		if (Constant.FF)
			driver = new FirefoxDriver();
		else if (Constant.CHROME == true)
			driver = new ChromeDriver();
		else
			driver = new InternetExplorerDriver();
		URL = homeurl;
		driver.navigate().to(URL);

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
