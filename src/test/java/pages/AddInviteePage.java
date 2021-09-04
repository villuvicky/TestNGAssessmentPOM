package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonActions;

public class AddInviteePage {

	private ChromeDriver driver;
	private Properties prop;
	public AddInviteePage(ChromeDriver driver,Properties prop) {
		this.driver= driver;
		this.prop=prop;
	}

	public AddInviteePage searchInvitee(String name){

		driver.switchTo().frame("searchFrame");

		WebElement enterName=driver.findElement(By.xpath(prop.getProperty("AddInviteePage.enterName")));
		enterName.sendKeys(name);

		CommonActions.enterButton(driver);

		driver.switchTo().defaultContent();
		return this;
	}

	public AddInviteePage addInvitee(){

		driver.switchTo().frame("resultsFrame");

		WebElement contact=driver.findElement(By.xpath(prop.getProperty("AddInviteePage.contact"))); 
		contact.click();
		return this;
	}


}
