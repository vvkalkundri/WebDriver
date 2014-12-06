package com.microsoft.sso.page;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringKeyboard;

import com.microsoft.specs.Constant;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public LoginPage doLogin(WebDriver driver,String userName, String password) {
		driver.findElement(By.id("username")).sendKeys(Constant.USERNAME);
		driver.findElement(By.id("password")).sendKeys(Constant.PASSWORD);
		driver.findElement(By.id("loginsubmit")).click();
		 if( driver.getTitle().contains("We're updating the terms")){
			 	driver.findElement(By.id("iNext")).click();
		 }
		return this;
	}

	public LoginPage clickOnFacebook(WebDriver driver) throws IOException{
		driver.findElement(By.tagName("img")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Set<String> ele = driver.getWindowHandles();
		Iterator<String> it = ele.iterator();
		while(it.hasNext()){
			driver.switchTo().window(it.next());
		}
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File("C:\\Users\\kalkundr\\Desktop\\sele_ScreeenShotp.png"));
		driver.findElement(By.id("email")).sendKeys("ssode2012@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("$qwe123$");
		driver.findElement(By.id("u_0_1")).submit();
		return this;
	}
	public LoginPage verifygetLoginPageTitle(String title) {
		assertEquals(title, driver.getTitle());
		return this;
	}

}
