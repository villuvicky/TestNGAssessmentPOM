package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.NewOpportunityPage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class EditOpportunityTest extends BaseClass{

	private SalesForceHomePage salesForceHomePage;
	private SalesHomePage salesHomePage;
	private NewOpportunityPage newOpportunityPage;

	@BeforeClass(alwaysRun = true)
	public void setSheetName() {

		sheetName="EditOpportunity";
	}

	@Test(dataProvider = "fecthData")
	public  void editOpportunityTest(String opportunityName,String stageType, String deliveryStatus, String descriptionValue) throws InterruptedException  {


		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.toggleButtonClick().
		viewAllButtonClick().salesButtonClick();

		salesHomePage = new SalesHomePage(driver, initProp());
		salesHomePage.opportunityTab().searchOpportunity(opportunityName).opportunityDropDown(opportunityName).OpenExistingOpportunity();

		newOpportunityPage = new NewOpportunityPage(driver,initProp());
		newOpportunityPage.selectTomorrowDate().stage(stageType).deliveryStatus(deliveryStatus).description(descriptionValue).saveButton();

		Assert.assertEquals(salesHomePage.editOpportunityMessage(opportunityName, stageType), stageType);


	}
}