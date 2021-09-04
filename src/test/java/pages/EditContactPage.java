package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditContactPage {

	private ChromeDriver driver;
	private Properties prop;

	public EditContactPage(ChromeDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}

	public EditContactPage enterTitle(String titleValue) {

		WebElement title= driver.findElement(By.xpath(prop.getProperty("EditContactPage.title")));
		title.clear();
		title.sendKeys(titleValue);
		return this;
	}
	public EditContactPage enterBirthDay(String birthDay) {

		WebElement birthDate= driver.findElement(By.xpath(prop.getProperty("EditContactPage.birthDate")));
		birthDate.clear();
		birthDate.sendKeys(birthDay);
		return this;
	}
	public EditContactPage selectSource() {

		WebElement leadSourceDropDown= driver.findElement(By.xpath(prop.getProperty("EditContactPage.leadSourceDropDown")));
		driver.executeScript("arguments[0].click();", leadSourceDropDown);
		WebElement leadSource=driver.findElement(By.xpath(prop.getProperty("EditContactPage.leadSource")));
		leadSource.click();
		return this;
	}
	public EditContactPage enterPhoneNumber(String phoneNumber) {

		WebElement phoneNumberBox=driver.findElement(By.xpath(prop.getProperty("EditContactPage.phoneNumberBox")));
		phoneNumberBox.clear();
		phoneNumberBox.sendKeys(phoneNumber);

		String enteredNumber=phoneNumberBox.getAttribute("value");
		System.out.println("Entered phone number "+enteredNumber);
		return this;
	}
	
	public EditContactPage saveContact() throws InterruptedException {

		WebElement SaveChanges=driver.findElement(By.xpath(prop.getProperty("EditContactPage.SaveChanges")));
		SaveChanges.click();
		Thread.sleep(2000);
		return this;
	}
	


}
