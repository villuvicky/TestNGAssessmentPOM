package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class DeleteOpportunityTest extends BaseClass{

	@BeforeClass(groups = { "Opportunity"})
	public void setSheetName() {

		sheetName="DeleteOpportunity";
	}

	@Test(dataProvider = "fecthData")
	public void deleteOpportunityTest(String opportunityName,String deleteMessage ) throws InterruptedException {
		SalesForceHomePage salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.toggleButtonClick().
		viewAllButtonClick().
		salesButtonClick();
		
		SalesHomePage salesHomePage = new SalesHomePage(driver, initProp());
		salesHomePage.opportunityTab().searchOpportunity(opportunityName).opportunityDropDown(opportunityName).clickDelete().confirmDelete();
		
		Assert.assertEquals(salesHomePage.deleteOpportunityMessage(), deleteMessage);
	}
}