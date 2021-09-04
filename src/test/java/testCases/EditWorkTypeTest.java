package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.EditWorkTypePage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class EditWorkTypeTest extends BaseClass{
	
	private SalesForceHomePage salesForceHomePage;
	private SalesHomePage salesHomePage;
	private EditWorkTypePage editWorkTypePage;
	private String workTypeName;
	
	@BeforeClass
	public void setSheetName() {

		sheetName="EditWorkType";
	}

	@Test(dataProvider = "fecthData")
	public void EditWorkType(String startTime, String endTime) throws InterruptedException {
		
		salesForceHomePage = new SalesForceHomePage(driver, initProp());
		salesForceHomePage.toggleButtonClick().
		viewAllButtonClick().clickworkTypes();

		salesHomePage = new SalesHomePage(driver, initProp());
		workTypeName=salesHomePage.getFirstworkTypeName();
		salesHomePage.clickWorkTypeDropDown().clickEditWorkType();
		
		editWorkTypePage = new EditWorkTypePage(driver, initProp());
		editWorkTypePage.enterStartTime(startTime).enterEndTime(endTime).saveWorkType();
		
		String expectedMessage=String.format("Work Type \"%s\" was saved.",workTypeName);
		
		Assert.assertEquals(salesHomePage.getWorkTypeEditedMessage(), expectedMessage);
	}
}