package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import testCases.BaseClass;
import utilities.CommonActions;


public class ServiceTerritoryHomePage{
	private ChromeDriver driver;
	private Properties prop;
	
	public ServiceTerritoryHomePage(ChromeDriver driver, Properties prop) {
		
		this.driver=driver;
		this.prop=prop;
	}
	
	public NewServiceTerritoryPage newTerritoryOption() {
		
		WebElement newTerritory = driver.findElement(By.xpath(prop.getProperty("ServiceTerritoryHomePage.newTerritory")));
		newTerritory.click();
		return new NewServiceTerritoryPage(driver, prop);
	}
	
	public String newTerritoryCreatedMessage() {
		
		WebElement messageElement= driver
				.findElement(By.xpath(prop.getProperty("ServiceTerritoryHomePage.messageElement")));
		
		CommonActions.waitVisibleMethod(driver, messageElement);
		return messageElement.getText();
	}
}
