package com.microsoft.sso.specs.login;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;

import com.microsoft.specs.Constant;
import com.microsoft.specs.TestBase;
import com.microsoft.sso.page.LoginPage;
import com.microsoft.sso.page.NavigateTo;

public class LoginTest extends TestBase {

	/**
	 * This test case tests the launching of the Live ID UI
	 * @throws IOException 
	 */
	@Test
	public void testSignInPageUI() {
		LoginPage loginPage = NavigateTo.navigateToSignInPage();
		loginPage.verifygetLoginPageTitle(Constant.NOKIAHOMEPAGETITLE);
		loginPage.doLogin(driver, Constant.USERNAME, Constant.PASSWORD);
         
	}

//	@Test
//	public void testInboxContents() throws IOException {
//		LoginPage loginPage = NavigateTo.navigateToSignInPage();
//		loginPage.clickOnFacebook(driver);
//	}

}
