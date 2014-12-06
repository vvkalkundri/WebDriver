package com.microsoft.sso.page;

import com.microsoft.specs.Constant;
import com.microsoft.specs.TestBase;

public class NavigateTo extends TestBase{
	
	public static LoginPage navigateToSignInPage(){
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
   
	public static InboxPage navigateToInboxPage(){
		
		InboxPage inBoxPage = new InboxPage(driver);
		LoginPage loginPage = navigateToSignInPage();
		loginPage.doLogin(driver, Constant.USERNAME, Constant.PASSWORD);
		return inBoxPage;
	}
}
