package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonActions;

public class CreateEventPage {

	private ChromeDriver driver;
	private String parentWindow;
	private Properties prop;

	public CreateEventPage(ChromeDriver driver, Properties prop) {
		this.driver= driver;
		this.prop=prop;
	}

	public CreateEventPage enterSubject(String subject){

		WebElement subjectBox=driver.findElement(By.xpath(prop.getProperty("CreateEventPage.subjectBox")));
		subjectBox.sendKeys(subject);
		return this;
	}

	public CreateEventPage enterStartDate(){

		WebElement startDate=driver.findElement(By.xpath(prop.getProperty("CreateEventPage.startDate")));
		startDate.clear();

		startDate.sendKeys(CommonActions.selectDate(1));

		return this;
	}

	public CreateEventPage enterEndDate(){

		WebElement endDate=driver.findElement(By.xpath(prop.getProperty("CreateEventPage.endDate")));
		endDate.clear();

		endDate.sendKeys(CommonActions.selectDate(2));

		return this;
	}

	public AddInviteePage clickAddToInvitees() {

		WebElement addToInvitees=driver.findElement(By.xpath(prop.getProperty("CreateEventPage.addToInvitees")));
		addToInvitees.click();

		parentWindow= driver.getWindowHandle();
		CommonActions.getwindow(driver, 1);

		return new AddInviteePage(driver, prop);
	}

	public AttachFilePage clickAttachFile(){

		driver.switchTo().window(parentWindow);

		WebElement attachFileOption=driver.findElement(By.xpath(prop.getProperty("CreateEventPage.attachFileOption")));
		attachFileOption.click();

		CommonActions.getwindow(driver, 1);
		return new AttachFilePage(driver, prop);
	}

	public boolean isFileUploaded(String fileName){

		driver.switchTo().window(parentWindow);

		WebElement uploadedFileName= driver.findElement(By.xpath(prop.getProperty("CreateEventPage.uploadedFileName")));

		if(uploadedFileName.getText().equals(fileName)) {

			return true;
		}

		return false;
	}

	public CreateEventPage clickSaveButton() {

		WebElement saveEventButon=driver.findElement(By.xpath(prop.getProperty("CreateEventPage.saveEventButon")));
		saveEventButon.click();
		return this;
	}

}
