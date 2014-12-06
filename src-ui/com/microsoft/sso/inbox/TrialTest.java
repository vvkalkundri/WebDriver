package com.microsoft.sso.inbox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TrialTest {
	WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() {

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		driver.navigate().to("http://jqueryui.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testDragAndDrop() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"))
				.click();
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);

		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(dragElement)
				.moveToElement(dropElement).release(dropElement).build();
		dragAndDrop.perform();

		List<WebElement> ele = driver.findElements(By.id("droppable"));
		for (int i = 0; i < ele.size(); i++) {
			String value = ele.get(i).findElement(By.tagName("p")).getText();
			if (value.equals("Dropped!")) {
				System.out.println("The image was dropped at the position ");
			}
		}

		driver.close();

	}
//
//	@Test
//	public void testFileUpload() {
//
//		driver.findElement(By.xpath(".//*[@id='sidebar']/aside[2]/ul/li[4]/a"))
//				.click();
//		WebElement frame = driver.findElement(By.className("demo-frame"));
//		driver.switchTo().frame(frame);
//		driver.findElement(By.id("datepicker")).click();
//		while( getMonths().equals("January") && getYears().equals("2015")){
//			driver.findElement(By.id("ui-datepicker-div")).click();
//		}
//		
//
//	}
//
//	private String getMonths() {
//		String month = driver.findElement(
//				By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[1]"))
//				.getText();
//
//		return month;
//
//	}
//	
	
//	@Test
//	public void testDate() throws InterruptedException{
//        WebDriver driver = new FirefoxDriver();
//        int found = 0;
//        driver.navigate().to("http://www.redbus.in/?xtor=SEC-1010[redBus+Branded]-GOO-[redBus+(E)]--S-redbus&gclid=CI_-itL-iMICFQOSjgodvDYA_Q");
//        driver.findElement(By.id("txtOnwardCalendar")).click();
//        WebElement datePicker = driver.findElement(By.id("rbcal_txtOnwardCalendar"));
//        List<WebElement> rows = datePicker.findElements(By.tagName("tr"));
//        for (int i =0 ;i< rows.size();i++) {
//                  if( found == 0){
//                           
//                  
//                  List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
//                  for (WebElement colEle : cols) {
//                           
//                           if(colEle.getText().equals("24")){
//                                     colEle.click();
//                                     found = 1;
//                           }
//                  }
//                  
//                  
//        }
//        }         
//        Thread.sleep(1000);
//        driver.close();
//        
//
//
//
//
//	}

	private String getYears() {
		String year = driver.findElement(
				By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[2]"))
				.getText();
		return year;
	}

}
