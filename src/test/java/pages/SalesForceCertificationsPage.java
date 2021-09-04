package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SalesForceCertificationsPage {

	private ChromeDriver driver;
	private Properties prop;
	
	public SalesForceCertificationsPage(ChromeDriver driver, Properties prop){

		this.driver=driver;
		this.prop=prop;
	}

	public SalesForceCertificationsPage clickDropdown() {

		WebElement dropDown=driver.findElement(By.xpath(prop.getProperty("SalesForceCertificationsPage.dropDown")));
		
		driver.executeScript("arguments[0].click();", dropDown);
		//dropDown.click();

		return this;
	}
	public SalesForceCertificationsPage clickcomplianceOption() {

		WebElement complianceOption=driver.findElement(By.xpath(prop.getProperty("SalesForceCertificationsPage.complianceOption")));
		complianceOption.click();
		return this;
	}
	public SalesForceCertificationsPage clickshowFilter() {

		WebElement showFilter = driver.findElement(By.xpath(prop.getProperty("SalesForceCertificationsPage.showFilter")));
		showFilter.click();

		return this;
	}
	public SalesForceCertificationsPage clicknonProfit() {

		WebElement nonProfit= driver.findElement(By.xpath(prop.getProperty("SalesForceCertificationsPage.nonProfit")));
		nonProfit.click();

		return this;
	}
	public SalesForceCertificationsPage getCertificationsSize() {

		List<WebElement> totalElements=driver.findElements(By.xpath(prop.getProperty("SalesForceCertificationsPage.totalElements")));
		int totalCertificates=totalElements.size();
		System.out.println("The total non profit certificates are "+totalCertificates);

		return this;
	}
	public boolean isClearFilterPresent() {

		WebElement clearFilter= driver.findElement(By.xpath("//button[normalize-space()='Clear filters']"));

		if(clearFilter.isDisplayed())
			return true;

		else
			return false;

	}
}
