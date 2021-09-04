package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AttachFilePage {
	private ChromeDriver driver;
private Properties prop;

	public AttachFilePage(ChromeDriver driver, Properties prop) {
		this.driver= driver;
		this.prop=prop;
	}
	
	public AttachFilePage chooseFile(String location){

		WebElement chooseFile= driver.findElement(By.xpath(prop.getProperty("AttachFilePage.chooseFile")));
		chooseFile.sendKeys(location);
		return this;
	}
	
	public AttachFilePage attachFile(){

		WebElement attachFile=driver.findElement(By.xpath(prop.getProperty("AttachFilePage.attachFile")));
		driver.executeScript("arguments[0].click();", attachFile);
		return this;
	}
	

	public AttachFilePage uploadFileDone(){

		WebElement doneButton= driver.findElement(By.xpath(prop.getProperty("AttachFilePage.doneButton")));
		driver.executeScript("arguments[0].click();", doneButton);
		return this;
	}
}
