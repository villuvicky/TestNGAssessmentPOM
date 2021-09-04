package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.CommonActions;

public class ClassicPage {

	private ChromeDriver driver;
	private Properties prop;

	public ClassicPage(ChromeDriver driver,Properties prop) {
		this.driver= driver;
		this.prop=prop;
	}

	public ClassicPage clickCreateNew(){

		WebElement createNew=driver.findElement(By.xpath(prop.getProperty("ClassicPage.createNew")));
		CommonActions.waitClickMethod(driver, createNew);
		return this;
	}

	public CreateEventPage clickCreateNewEvent(){

		WebElement event=driver.findElement(By.xpath(prop.getProperty("ClassicPage.event")));
		CommonActions.waitClickMethod(driver, event);
		return new CreateEventPage(driver, prop);
	}

}
