package com.microsoft.sso.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class PageUtil {
	
	private static final int IMPLICIT_WAIT_IN_SECONDS = 2;
	private static final int EXPLICIT_WAIT_IN_SECONDS = 5;
	
	public static void wait(WebDriver driver) throws InterruptedException{
		wait(driver,IMPLICIT_WAIT_IN_SECONDS);
	}
	
	public static void wait(WebDriver driver,int secs) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(EXPLICIT_WAIT_IN_SECONDS,TimeUnit.SECONDS);

	}

}
