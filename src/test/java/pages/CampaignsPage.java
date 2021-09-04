package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import utilities.CommonActions;

public class CampaignsPage{

	private ChromeDriver driver;
	private Properties prop;
	public CampaignsPage(ChromeDriver driver, Properties prop) {

		this.driver=driver;
		this.prop=prop;
	}

	public NewContactPage newContact() {

		WebElement newContact=driver.findElement(By.xpath(prop.getProperty("CampaignsPage.newContact")));
		newContact.click();
		return new NewContactPage(driver, prop);
	}

	public CampaignsPage campaignMembers() {

		CommonActions.actionsMethod(driver, driver.findElement(By.xpath(prop.getProperty("CampaignsPage.campaignMembers"))));
		return this;
	}

	public CampaignsPage addContactForCampaignOption() {
		WebElement addContact=driver.findElement(By.xpath(prop.getProperty("CampaignsPage.addContact")));
		driver.executeScript("arguments[0].click();", addContact);
		return this;
	}

	public CampaignsPage addContactForCampaign(String fullName) throws InterruptedException {

		WebElement searchContact=driver.findElement(By.xpath(prop.getProperty("CampaignsPage.searchContact")));
		searchContact.sendKeys(fullName);
		CommonActions.act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

		WebElement add=driver.findElement(By.xpath(String.format("//tr[1]//th//span//a[@title='%s']//preceding::td[1]/span/span/label[@class='slds-checkbox']",fullName)));
		driver.executeScript("arguments[0].click();", add);

		WebElement nextButton= driver.findElement(By.xpath(prop.getProperty("CampaignsPage.nextButton")));
		nextButton.click();

		WebElement status= driver.findElement(By.xpath(prop.getProperty("CampaignsPage.status")));
		CommonActions.waitVisibleMethod(driver, status);

		WebElement submit= driver.findElement(By.xpath(prop.getProperty("CampaignsPage.submit")));
		submit.click();
		return this;
	}

	public boolean isAddedContactPresent(String fullName) {

		WebElement viewAllContacts= driver.findElement(By.xpath(prop.getProperty("CampaignsPage.viewAllContacts")));
		CommonActions.waitClickMethod(driver, viewAllContacts);

		int size= driver.findElements(By.xpath(String.format("//a[@title='%s']//following::tr[1]/td[8]/span[1]",fullName))).size();

		if (size>=1) {
			return true;
		}
		else
			return false;
	}

	public CampaignsPage clickUploadButton() throws InterruptedException{

		WebElement uploadFiles=driver.findElement(By.xpath(prop.getProperty("EditCampaignPage.uploadFiles")));
		uploadFiles.click();
		Thread.sleep(2000);
		return this;
	}

	public CampaignsPage clickDoneButton(){

		WebElement doneButton=driver.findElement(By.xpath(prop.getProperty("EditCampaignPage.doneButton")));
		CommonActions.waitClickMethod(driver, doneButton);
		return this;
	}

	public String getActualSuccessMessage() {

		WebElement messageElement=driver
				.findElement(By.xpath(prop.getProperty("EditCampaignPage.messageElement")));

		CommonActions.waitVisibleMethod(driver, messageElement);

		return messageElement.getText();
	}

	public CampaignsPage clickCampaignMembers(){

		WebElement campaignMembers = driver.findElement(By.xpath(prop.getProperty("CampaignsPage.campaignMembers")));
		CommonActions.waitClickMethod(driver, campaignMembers);
		return this;
	}

	public boolean isLeadPresent(String leadName) {

		int leadSize = driver.findElements(By.xpath(String.format("//span[@title='Name']/following::a[@title='%s']",leadName))).size();

		if (leadSize == 0) {
			return true;}
		else {
			return false;}
	}
}




