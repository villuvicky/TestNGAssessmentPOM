package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SalesForceCertificationsPage;
import pages.SalesForceHomePage;

public class NonProfitCertificationsTest extends BaseClass{

	private SalesForceHomePage salesForceHomePage;
	private SalesForceCertificationsPage salesForceCertificationsPage ;
	@Test()
	public void NonProfitCertifications() {

		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.clickNext(3).clickSystemStatus();
		
		salesForceCertificationsPage= new SalesForceCertificationsPage(driver, initProp());
		salesForceCertificationsPage.clickDropdown().clickcomplianceOption().clickshowFilter()
		.clicknonProfit().getCertificationsSize();
		Assert.assertTrue(salesForceCertificationsPage.isClearFilterPresent());
		
		driver.close();
		driver.switchTo().window(SalesForceHomePage.homeWindow);
	}
}