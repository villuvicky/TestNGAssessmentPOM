package pages;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonActions;


public class SalesForceHomePage{

	public static String homeWindow;
	private ChromeDriver driver;
	private Properties prop;

	public SalesForceHomePage(ChromeDriver driver,Properties prop){

		this.driver=driver;
		this.prop=prop;
	}

	public SalesForceHomePage toggleButtonClick() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement toggle = driver
				.findElement(By.xpath(prop.getProperty("SalesForceHomePage.toggle")));
		toggle.click();

		return this;

	}

	public SalesForceHomePage viewAllButtonClick() {

		WebElement viewAll = driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.viewAll")));
		viewAll.click();

		return this;
	}

	public SalesHomePage salesButtonClick() {

		WebElement sales = driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.sales")));
		sales.click();
		return new SalesHomePage(driver, prop);

	}

	public SalesHomePage compaignButtonClick() {

		WebElement campaigns = driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.campaigns")));
		driver.executeScript("arguments[0].click();", campaigns);
		return new SalesHomePage(driver, prop);
	}

	public SalesHomePage userProvisioningRequestsButtonClick() {

		WebElement userProvisioningRequests = driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.userProvisioningRequests")));
		driver.executeScript("arguments[0].click();", userProvisioningRequests);
		return new SalesHomePage(driver, prop);
	}

	public ServiceTerritoryHomePage serviceTerritoriesButtonClick() throws InterruptedException {

		WebElement serviceTerritories = driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.serviceTerritories")));
		driver.executeScript("arguments[0].click();", serviceTerritories);
		Thread.sleep(2000);
		return new ServiceTerritoryHomePage(driver, prop);

	}

	public MobileAppsPage mobilePublisher() {

		WebElement mobilePublisher=driver.findElement(By.
				xpath(prop.getProperty("SalesForceHomePage.mobilePublisher")
						)); 
		driver.executeScript("arguments[0].click();", mobilePublisher);

		homeWindow=driver.getWindowHandle();
		CommonActions.getwindow(driver, 1);
		return new MobileAppsPage(driver, prop);
	}

	public AppManagerPage clickCommunity() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement communityLink= driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.clickCommunity")));
		CommonActions.waitClickMethod(driver, communityLink);
		return new AppManagerPage(driver,prop);
	}

	public SalesHomePage clickContact() {

		WebElement contacts = driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.contact")));
		driver.executeScript("arguments[0].click();", contacts);
		return new SalesHomePage(driver, prop);
	}
	public SalesHomePage clickworkTypes() {

		WebElement workTypes = driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.workTypes")));
		driver.executeScript("arguments[0].click();", workTypes);
		return new SalesHomePage(driver, prop);
	}

	public SalesHomePage clickLead() {

		WebElement leads = driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.leads")));
		driver.executeScript("arguments[0].click();", leads);
		return new SalesHomePage(driver, prop);
	}

	public SalesForceHomePage clickNext(int count) {


		WebElement next=driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.next")));
		int i=0;

		while(i<count) {
			CommonActions.waitClickMethod(driver, next);
			i++;
		}
		return this;
	}

	public SalesForceCertificationsPage clickSystemStatus() {

		WebElement systemStatus=driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.systemStatus"))); 
		driver.executeScript("arguments[0].click();", systemStatus);
		homeWindow=driver.getWindowHandle();
		CommonActions.getwindow(driver, 1);
		return new SalesForceCertificationsPage(driver,prop);
	}

	public GooglePlayStorePage clicksalesForceGooglePlayStore() {

		WebElement salesForceGooglePlayStore=driver.findElement(By.xpath(prop.getProperty("SalesForceHomePage.salesForceGooglePlayStore"))); 
		driver.executeScript("arguments[0].click();", salesForceGooglePlayStore);
		homeWindow=driver.getWindowHandle();
		CommonActions.getwindow(driver, 1);
		return new GooglePlayStorePage(driver,prop);
	}


}
