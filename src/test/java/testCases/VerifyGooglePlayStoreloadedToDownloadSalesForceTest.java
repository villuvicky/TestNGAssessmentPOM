package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePlayStorePage;
import pages.SalesForceHomePage;

public class VerifyGooglePlayStoreloadedToDownloadSalesForceTest extends BaseClass{

	static String expectedText="SalesforceA";	
	private SalesForceHomePage salesForceHomePage;
	private GooglePlayStorePage googlePlayStorePage;
	
	
	@Test()
	public void VerifyGooglePlayStoreloadedToDownloadSalesForceATest() {
		
		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.clickNext(2).clicksalesForceGooglePlayStore();
		
		googlePlayStorePage=new GooglePlayStorePage(driver, initProp());
		googlePlayStorePage.clickConfirm();
		Assert.assertEquals(googlePlayStorePage.getTextValue(),expectedText);
		
		Assert.assertTrue(googlePlayStorePage.isInstallButtonPresent());
		

		driver.close();
		driver.switchTo().window(SalesForceHomePage.homeWindow);
	}
}