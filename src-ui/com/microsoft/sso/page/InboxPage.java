package com.microsoft.sso.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.microsoft.specs.Constant;

public class InboxPage extends AbstractPage {

	public InboxPage(WebDriver driver) {
		super(driver);
	}

	public InboxPage verifyUiElements(boolean checkChangedDob) {

		// Get all the elements that are clickable in the page
		List<WebElement> ele = driver.findElements(By.tagName("a"));
		for (WebElement webElement : ele) {
			System.out.println(webElement.getText());
		}

		// Get the xpath of the firstName
		List<WebElement> ele1 = driver.findElements(By.xpath("//section[1]"));
		for (WebElement webElement : ele1) {
			List<WebElement> pTagElements = webElement.findElements(By
					.tagName("p"));
			for (int i = 0; i < pTagElements.size(); i++) {
				List<WebElement> spanElements = pTagElements.get(i)
						.findElements(By.tagName("span"));
				for (int j = 0; j < spanElements.size(); j++) {
					if (spanElements.get(j).getText()
							.equals(Constant.ABOUTMEFIRSTNAME)) {

						assert (spanElements.get(j + 1).getText()
								.equals(Constant.ABOUTMENAMEVALUE));
					}
					if (spanElements.get(j).getText()
							.equals(Constant.ABOUTMELASTNAME)) {

						assert (spanElements.get(j + 1).getText()
								.equals(Constant.ABOUTMELASTVALUE));
					}
					if (spanElements.get(j).getText().equals(Constant.LANGUAGE)) {

						assert (spanElements.get(j + 1).getText()
								.equals(Constant.LANGUAGEVALUE));
					}
					if (spanElements.get(j).getText()
							.equals(Constant.COUNTRYREGION)) {

						assert (spanElements.get(j + 1).getText()
								.equals(Constant.COUNTRYVALUE));
					}
					if (spanElements.get(j).getText().equals(Constant.DOB)) {
						if (checkChangedDob) {
							assert (spanElements.get(j + 1).getText()
									.equals(Constant.DOBCHANGEDVALUE));
						} else {
							assert (spanElements.get(j + 1).getText()
									.equals(Constant.DOBVALUE));
						}
					}

				}
			}

		}

		return this;

	}

	public InboxPage verifyUpdatePersonalDetails() {
		driver.findElement(By.xpath("//section[1]/p[1]/a")).click();

		// Change the dob to 011,12,1958
		driver.findElement(By.id("dobDay")).sendKeys("11");
		driver.findElement(By.id("dobMonth")).sendKeys("12");
		driver.findElement(By.id("dobYear")).sendKeys("1958");
		driver.findElement(By.id("submit")).click();
		verifyUiElements(true);

		// Verify the label
		List<WebElement> getElems = driver.findElements(By
				.xpath("//div[4]/div/div/div[2]"));
		for (int i = 0; i < getElems.size(); i++) {
			assert (getElems.get(i).getText()
					.equals(Constant.UPDATEACCONTDETAILS));

		}

		return this;
	}
}
