package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.CommonActions;

public class MobileAppsPage{
	
	private ChromeDriver driver;
	private Properties prop;

	public MobileAppsPage(ChromeDriver driver, Properties prop){

		this.driver=driver;
		this.prop=prop;
	}

	public MobileAppsPage resources() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ele=(WebElement)driver.executeScript("return document.querySelector('#c360-hgf-nav').shadowRoot.querySelector('header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)')");
		driver.executeScript("arguments[0].click();", ele);
		return this;
	}
	
	public AdministratorOverviewPage salesForceCertification() throws InterruptedException {
		
		WebElement ele=(WebElement)driver.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1)\")");
		driver.executeScript("arguments[0].click();", ele);
		CommonActions.getwindow(driver, 2);

		return new AdministratorOverviewPage(driver,prop);
	}
}

