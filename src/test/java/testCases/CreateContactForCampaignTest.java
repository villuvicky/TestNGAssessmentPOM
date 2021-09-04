package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CampaignsPage;
import pages.NewContactPage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class CreateContactForCampaignTest extends BaseClass{
	
	private SalesForceHomePage salesForceHomePage;
	private SalesHomePage salesHomePage;
	private CampaignsPage campaignsPage;
	private NewContactPage newContactPage;
	
	@BeforeClass
	public void setSheetName() {
		
		sheetName="CreateContactForCampaign";
	}

	@Test(dataProvider = "fecthData")
	public void createContactForCampaignTest(String campaign,String salutationValue, String contactFirstName, String contactLastName,String fullName) throws InterruptedException {

		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().compaignButtonClick();
		
		salesHomePage= new SalesHomePage(driver, initProp());
		salesHomePage.searchCampaign(campaign).openCampaign(campaign);
		
		campaignsPage = new CampaignsPage(driver, initProp());
		campaignsPage.newContact();
		
		newContactPage = new NewContactPage(driver, initProp());
		newContactPage.salutation(salutationValue).firstName(contactFirstName).lastName(contactLastName).saveNewContact();
		
		campaignsPage.campaignMembers().addContactForCampaignOption().addContactForCampaign(fullName);
		Assert.assertTrue(campaignsPage.isAddedContactPresent(fullName));
	}
}