package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CampaignsPage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class DeleteLeadCampaignTest extends BaseClass{
	
	private SalesForceHomePage salesForceHomePage;
	private SalesHomePage salesHomePage;
	private CampaignsPage campaignsPage;
	
	@BeforeClass
	public void setSheetName() {
		
		sheetName="DeleteLeadCampaign";
	}

	@Test(dataProvider = "fecthData")
	public void deleteLeadCampaign(String leadName, String campaignName) throws InterruptedException {
		
		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().clickLead();
		
		salesHomePage= new SalesHomePage(driver, initProp());
		salesHomePage.searchLead(leadName).leadDropdown(leadName).clickDelete().confirmDelete()
		.campaignTab().searchCampaign(campaignName).openCampaign(campaignName);
		
		campaignsPage= new CampaignsPage(driver, initProp());
		campaignsPage.clickCampaignMembers();
		
		Assert.assertTrue(campaignsPage.isLeadPresent(leadName));
	}
}