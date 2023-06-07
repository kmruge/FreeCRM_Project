package PageObject;

import PageObjectElement.HomeElement;
import Util.ElementFetch;

public class HomePage {
	ElementFetch fetch=new ElementFetch();
	public void SignInButton()
	{
		fetch.getWebEle("Xpath", HomeElement.signIn).click();
	}
}
