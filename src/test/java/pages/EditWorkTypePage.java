package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditWorkTypePage {

	private ChromeDriver driver;
	private Properties prop;

	public EditWorkTypePage(ChromeDriver driver,Properties prop) {

		this.driver=driver;
		this.prop=prop;
	}

	public EditWorkTypePage enterStartTime(String startTime) {

		WebElement startTimeBox = driver.findElement(By.xpath(prop.getProperty("EditWorkTypePage.startTimeBox")));
		startTimeBox.clear();
		startTimeBox.sendKeys(startTime);
		return this;
	}
	public EditWorkTypePage enterEndTime(String endTime) {

		WebElement endTimeBox = driver.findElement(By.xpath(prop.getProperty("EditWorkTypePage.endTimeBox")));
		endTimeBox.clear();
		endTimeBox.sendKeys(endTime);
		return this;
	}
	
	public EditWorkTypePage saveWorkType() {

		WebElement saveButton = driver.findElement(By.xpath(prop.getProperty("EditWorkTypePage.saveButton")));
		saveButton.click();
		return this;
	}
}
