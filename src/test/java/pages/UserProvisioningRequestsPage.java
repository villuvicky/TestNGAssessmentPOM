package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.CommonActions;

public class UserProvisioningRequestsPage {

	private ChromeDriver driver;
	private Properties prop;

	public UserProvisioningRequestsPage(ChromeDriver driver, Properties prop) {

		this.driver=driver;
		this.prop=prop;
	}

	public UserProvisioningRequestsPage clickCreateNewView() {

		WebElement createNewView=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.createNewView")));
		CommonActions.waitClickMethod(driver, createNewView);
		return this;
	}

	public UserProvisioningRequestsPage enterViewName(String viewName) {

		WebElement viewNameBox=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.viewNameBox")));
		viewNameBox.sendKeys(viewName);

		System.out.println(viewNameBox.getAttribute("value"));
		return this;
	}

	public UserProvisioningRequestsPage enterUniqueName(String viewUniqueName) {

		WebElement viewUniqueNameBox=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.viewUniqueNameBox")));
		System.out.println(viewUniqueNameBox.getAttribute("value"));

		viewUniqueNameBox.clear();

		viewUniqueNameBox.sendKeys(viewUniqueNameBox.getText()+ viewUniqueName);
		System.out.println(viewUniqueNameBox.getAttribute("value"));
		return this;
	}

	public UserProvisioningRequestsPage ownerCheckBox() {


		WebElement ownerCheckBox=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.ownerCheckBox")));

		if(!(ownerCheckBox.isSelected()))
			ownerCheckBox.click();

		return this;
	}

	public UserProvisioningRequestsPage selectNameDropDown(String value) {

		WebElement dropDown1=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.dropDown1")));
		CommonActions.selectMethod(dropDown1, "text", value);
		return this;
	}

	public UserProvisioningRequestsPage getOperatorDropdownValues() {

		WebElement operatorDropDown=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.operatorDropDown")));
		CommonActions.getDropDownValues(operatorDropDown,"operatorDropDown");
		return this;
	}

	public UserProvisioningRequestsPage selectCreateDateDropDownInAdditional(String value) {

		WebElement availableFieldsDropDown=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.availableFieldsDropDown")));
		CommonActions.selectMethod(availableFieldsDropDown, "text", value);
		System.out.println("value selected");
		return this;
	}
	public UserProvisioningRequestsPage getavailableFieldsDropDownValues() {

		WebElement availableFieldsDropDown=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.availableFieldsDropDown")));
		CommonActions.getDropDownValues(availableFieldsDropDown, "availableFieldsDropDown");
		return this;
	}
	public UserProvisioningRequestsPage getSelectedFieldsDropDownDropdownValues() {

		WebElement SelectedFieldsDropDown=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.SelectedFieldsDropDown")));
		CommonActions.getDropDownValues(SelectedFieldsDropDown, "SelectedFieldsDropDown");
		return this;
	}

	public UserProvisioningRequestsPage selectCreateDateDropDownInAvailable(String value) {

		WebElement availableFieldsDropDown=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.availableFieldsDropDown")));
		CommonActions.selectMethod(availableFieldsDropDown, "text", value);
		return this;
	}
	public UserProvisioningRequestsPage clickAddField() {

		WebElement add=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.add")));
		add.click();
		return this;
	}

	public boolean verifyFieldAdded() {

		WebElement SelectedFieldsDropDown=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.SelectedFieldsDropDown")));

		if(CommonActions.getDropDownValues(SelectedFieldsDropDown, "SelectedFieldsDropDown").contains("Created Date"))
		{
			return true;
	}
		else {
			return false;
		}
	}
	public UserProvisioningRequestsPage clickRestricted() {

		WebElement  restrictVisibility=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.restrictVisibility")));
		if(!(restrictVisibility.isSelected()))
			restrictVisibility.click();

		return this;
	}

	public UserProvisioningRequestsPage clickSaveRequest() {

		WebElement save=driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.save")));
		save.click();
		return this;
	}

	public String verifyViewName() {

		return driver.findElement(By.xpath(prop.getProperty("UserProvisioningRequestsPage.verifyViewName"))).getText();
	}

	public UserProvisioningRequestsPage getTitleOfWindow() {

		String title=driver.getTitle();
		System.out.println(title);
		return this;
	}

	public UserProvisioningRequestsPage closeOtherWindows() {
		CommonActions.closeOtherWindowsMethod(driver);
		return this;
	}

}
