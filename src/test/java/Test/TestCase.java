package Test;

import org.testng.annotations.Test;

import BaseClass.driverClass;
import PageObject.HomePage;
import PageObject.LogInPage;

public class TestCase extends driverClass {
	HomePage hpage=new HomePage();
	LogInPage lpage=new LogInPage();
	@Test
	void run()
	{
		hpage.SignInButton();
		lpage.LoginVerification();
		lpage.credentialEntering();
	}
}
