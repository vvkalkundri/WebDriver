package com.microsoft.sso.inbox;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.microsoft.specs.TestBase;
import com.microsoft.sso.page.InboxPage;
import com.microsoft.sso.page.NavigateTo;

public class InboxTest extends TestBase {

	/**
	 * This test case tests the UI elements in the Inbox of live id
	 * 
	 * @throws InterruptedException
	 */
	@Test
	 public void testInboxUI() {
	 InboxPage inboxPage = NavigateTo.navigateToInboxPage();
	 inboxPage.verifyUiElements(false);
	 WebElement dragEle = driver.findElement(By.id("test"));
	 WebElement dropEle = driver.findElement(By.id("destination"));
	 Actions act = new Actions(driver);
	 Actions dragAndDrop = act.clickAndHold(dragEle);
	 //.moveToElement(dropEle);
	 dragAndDrop.release(dropEle);
	 dragAndDrop.build();
	 
	
	 }

//	 @Test
//	 public void testEditPersonalDetails() {
//	 InboxPage inboxPage = NavigateTo.navigateToInboxPage();
//	 inboxPage.verifyUpdatePersonalDetails();
//	 //inbox.
//	
//	 }
	
	

	

}
