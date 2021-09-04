package pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonActions;

public class UserMenuPage{
	
	private ChromeDriver driver;
	private Properties prop;

	public UserMenuPage(ChromeDriver driver,Properties prop){

		this.driver=driver;
		this.prop=prop;
	}

	public UserMenuPage clickUserMenu() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement userMenuIcon=driver.findElement(By.xpath(prop.getProperty("UserMenuPage.userMenuIcon")));
		CommonActions.waitClickMethod(driver, userMenuIcon);
		return this;
	}

	public ClassicPage clickClassicView() {

		WebElement classicView= driver.findElement(By.xpath(prop.getProperty("UserMenuPage.classicView")));
		CommonActions.waitClickMethod(driver, classicView);
		return new ClassicPage(driver, prop);
	}

	public UserMenuPage logOut() {

		WebElement logOut=driver.findElement(By.xpath(prop.getProperty("UserMenuPage.logOut")));
		CommonActions.waitClickMethod(driver, logOut);
		return this;
	}

}
