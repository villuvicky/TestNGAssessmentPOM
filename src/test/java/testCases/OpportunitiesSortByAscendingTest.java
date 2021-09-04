package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class OpportunitiesSortByAscendingTest extends BaseClass{
	
	private SalesForceHomePage salesForceHomePage;
	private SalesHomePage salesHomePage;
	
	@Test()
	public void OpportunitiesSortByAscending() throws InterruptedException {
		

		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().salesButtonClick();

		salesHomePage = new SalesHomePage(driver,initProp());
		salesHomePage.opportunityTab().clickdisplayOption().clicktableView().loadAllOpportunities();
		
		Assert.assertTrue(salesHomePage.isDatesSorted());
		
	}

}
