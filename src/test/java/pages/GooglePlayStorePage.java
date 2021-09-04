package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GooglePlayStorePage {

	private ChromeDriver driver;
	private Properties prop;

	public GooglePlayStorePage(ChromeDriver driver, Properties prop){

		this.prop=prop;
		this.driver=driver;
	}

	public GooglePlayStorePage clickConfirm() {

		WebElement confirm=driver.findElement(By.xpath(prop.getProperty("GooglePlayStorePage.confirm")));
		confirm.click();
		return this;
	}

	public String getTextValue() {

		String actualText=driver.findElement(By.xpath(prop.getProperty("GooglePlayStorePage.actualText"))).getText();
		return actualText;
	}

	public boolean isInstallButtonPresent() {

		WebElement install= driver.findElement(By.xpath(prop.getProperty("GooglePlayStorePage.install")));

		if(install.isDisplayed())
			return true;

		else
		return false;
	}
}
