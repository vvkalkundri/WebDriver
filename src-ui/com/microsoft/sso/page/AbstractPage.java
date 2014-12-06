package com.microsoft.sso.page;


import junit.framework.TestResult;

import org.openqa.selenium.WebDriver;
public class AbstractPage implements Page{
	
 	protected static WebDriver driver;
	
	
	 public AbstractPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	@Override
	public void open() throws InterruptedException {
		PageUtil.wait(driver);
       		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTitle() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int countTestCases() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void run(TestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
