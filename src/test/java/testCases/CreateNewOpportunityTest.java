package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NewOpportunityPage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;


public class CreateNewOpportunityTest extends BaseClass{

	private SalesForceHomePage salesForceHomePage;
	private SalesHomePage salesHomePage;
	private NewOpportunityPage newOpportunityPage;

	@BeforeClass(groups = { "Opportunity"})
	public void setSheetName() {

		sheetName="CreateNewOpportunity";
	}

	@Test(dataProvider = "fecthData",groups = { "Opportunity"})
	public void createNewOpportunityTest(String opportunityName, String stageType, String successMessage) {

		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().salesButtonClick();

		salesHomePage = new SalesHomePage(driver,initProp());
		salesHomePage.opportunityTab().newOpportunityButton();

		newOpportunityPage = new NewOpportunityPage(driver,initProp());
		newOpportunityPage.opportunityName(opportunityName).selectTodayDate().stage(stageType).saveButton();

		Assert.assertEquals(salesHomePage.opportunityCreatedMessage(), successMessage);

	}

}
