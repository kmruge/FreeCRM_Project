package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.driverClass;

public class ElementFetch {
	public WebElement getWebEle(String path,String webEle)
	{
		switch(path)
		{
		case "Xpath":
			return BaseClass.driverClass.driver.findElement(By.xpath(webEle));
		}
		return null;
	}
}
