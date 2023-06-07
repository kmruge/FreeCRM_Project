package PageObject;

import org.testng.Assert;

import PageObjectElement.LogInPageElement;
import Util.ElementFetch;

public class LogInPage {
	ElementFetch fetch=new ElementFetch();
	public void LoginVerification()
	{
		Assert.assertTrue(fetch.getWebEle("Xpath", LogInPageElement.LoginVerificarion).isDisplayed(),"Failed at Login Page Navigation");
	}
	public void credentialEntering()
	{
		fetch.getWebEle("Xpath", LogInPageElement.email).sendKeys("ABC@gmail.com");
		fetch.getWebEle("Xpath", LogInPageElement.passWord).sendKeys("123456");
	}
}
