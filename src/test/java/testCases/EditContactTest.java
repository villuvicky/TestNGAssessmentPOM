package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.EditContactPage;
import pages.SalesForceHomePage;
import pages.SalesHomePage;

public class EditContactTest extends BaseClass{


		static String unqiueContactName ;
		private SalesForceHomePage salesForceHomePage;
		private SalesHomePage salesHomePage;
		private EditContactPage editContactPage;

		@BeforeClass
		public void setSheetName() {

			sheetName="EditContact";
		}

		@Test(dataProvider = "fecthData")
		public void EditContact(String titleValue, String birthDay, String phoneNumber) throws InterruptedException {

			salesForceHomePage = new SalesForceHomePage(driver, initProp());
			salesForceHomePage.toggleButtonClick().viewAllButtonClick().clickContact();
			
			salesHomePage=new SalesHomePage(driver, initProp());
			salesHomePage.loadAllContacts().searchUniqueContactAndClickDropDown().clickEditContact();
			
			editContactPage= new EditContactPage(driver,initProp());
			editContactPage.enterTitle(titleValue).enterBirthDay(birthDay).selectSource().
			enterPhoneNumber(phoneNumber).saveContact();
			
			Assert.assertEquals(salesHomePage.getPhoneNumber(), phoneNumber);
		
		}
	}