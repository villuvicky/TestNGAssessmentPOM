package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SalesHomePage;
import utilities.CommonActions;
import pages.CampaignsPage;
import pages.SalesForceHomePage;

public class CreateCampaignAttachDocTest extends BaseClass{

	private SalesForceHomePage salesForceHomePage;
	private SalesHomePage SalesHomePage;
	private CampaignsPage campaignsPage;

	@BeforeClass
	public void setSheetName() {

		sheetName="CreateCampaignAttachDoc";
	}

	@Test(dataProvider = "fecthData")

	public void createCampain(String campaign, String SuccessMessage) throws InterruptedException, AWTException {
		
		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().salesButtonClick();

		SalesHomePage = new SalesHomePage(driver, initProp());
		SalesHomePage.campaignTab().searchCampaign(campaign).openCampaign(campaign);

		campaignsPage= new CampaignsPage(driver, initProp());
		campaignsPage.clickUploadButton();
		CommonActions.uploadFileRobot("C:\\Users\\villu\\TestLeaf\\myProject\\data\\Sample.pdf");
		campaignsPage.clickDoneButton();
		Assert.assertEquals(campaignsPage.getActualSuccessMessage(), SuccessMessage);

	}
}