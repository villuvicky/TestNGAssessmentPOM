package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SalesForceHomePage;
import pages.SalesHomePage;
import pages.UserProvisioningRequestsPage;

public class CreateNewUserProvisioningRequestTest extends BaseClass{

	private SalesForceHomePage salesForceHomePage;
	private SalesHomePage salesHomePage;
	private UserProvisioningRequestsPage userProvisioningRequestsPage;
	@BeforeClass
	public void setSheetName() {

		sheetName="CreateNewUserProvisioningReques";
	}

	@Test(dataProvider = "fecthData")
	public void createNewUserProvisioningRequestTest(String viewName, String viewUniqueName) throws InterruptedException {

		salesForceHomePage = new SalesForceHomePage(driver,initProp());
		salesForceHomePage.toggleButtonClick().viewAllButtonClick().userProvisioningRequestsButtonClick();

		salesHomePage = new SalesHomePage(driver,initProp());
		salesHomePage.clickClassicView();

		userProvisioningRequestsPage= new UserProvisioningRequestsPage(driver,initProp());
		userProvisioningRequestsPage.clickCreateNewView().enterViewName(viewName).enterUniqueName(viewUniqueName)
		.ownerCheckBox().selectNameDropDown("Name").getOperatorDropdownValues().selectCreateDateDropDownInAdditional("Created Date").getSelectedFieldsDropDownDropdownValues()
		.clickAddField();
		Assert.assertTrue(userProvisioningRequestsPage.verifyFieldAdded());
		userProvisioningRequestsPage.clickRestricted().clickSaveRequest();

		Assert.assertEquals(userProvisioningRequestsPage.verifyViewName(), viewName);

		userProvisioningRequestsPage.getTitleOfWindow().closeOtherWindows();
	}
}