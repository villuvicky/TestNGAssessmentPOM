package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utilities.CommonActions;


public class SalesHomePage {

	private ChromeDriver driver;
	private Properties prop;
	public static String parentWindow;
	private String unqiueContactName;
	private String workTypeName;

	public SalesHomePage(ChromeDriver driver,Properties prop) {

		this.driver=driver;
		this.prop=prop;
	}

	public SalesHomePage opportunityTab() {

		WebElement opportunities = driver.findElement(By.xpath(prop.getProperty("SalesHomePage.opportunities")));
		driver.executeScript("arguments[0].click();", opportunities);
		return this;
	}

	public SalesHomePage campaignTab() {

		WebElement campaigns = driver.findElement(By.xpath(prop.getProperty("SalesHomePage.campaigns")));
		driver.executeScript("arguments[0].click();", campaigns);
		return this;
	}



	public NewOpportunityPage newOpportunityButton() {

		WebElement newOpportunities = driver.findElement(By.xpath(prop.getProperty("SalesHomePage.newOpportunities")));
		newOpportunities.click();
		return new NewOpportunityPage(driver, prop);

	}


	public SalesHomePage opportunityDropDown(String opportunityName) {

		WebElement dropdown= driver.findElement(By.xpath(String.format("//a[@title='%s']//ancestor::tr//td[8]", opportunityName)));

		CommonActions.waitClickMethod(driver, dropdown);

		return this;
	}

	public NewOpportunityPage OpenExistingOpportunity() {

		WebElement editOppurtunity=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.edit")));
		editOppurtunity.click();

		return new NewOpportunityPage(driver, prop);
	}

	public SalesHomePage clickDelete() {

		WebElement delete=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.deleteButton")));
		delete.click();
		return this;
	}

	public SalesHomePage confirmDelete() {

		WebElement confirmDelete=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.confirmDelete")));
		confirmDelete.click();
		return this;
	}

	public String opportunityCreatedMessage() {

		WebElement messageElement=driver
				.findElement(By.xpath(prop.getProperty("SalesHomePage.messageElement")));

		CommonActions.waitVisibleMethod(driver, messageElement);

		return messageElement.getText();
	}

	public String editOpportunityMessage(String opportunityName,String stageType) {

		WebElement actualStage=driver.findElement(By.xpath(String.format("(//a[@title='%s']//ancestor::tr/td[5])[1]/span/span[text()='%s']", opportunityName,stageType)));
		CommonActions.waitVisibleMethod(driver, actualStage);
		return actualStage.getText();
	}


	public String deleteOpportunityMessage() {

		WebElement deletedMessageElement =driver.findElement(By.xpath(prop.getProperty("SalesHomePage.deletedMessageElement")));

		CommonActions.waitVisibleMethod(driver, deletedMessageElement);
		return deletedMessageElement.getText();

	}

	public SalesHomePage searchOpportunity(String Name) throws InterruptedException {

		WebElement search=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.searchOpportunity")));
		CommonActions.waitClickMethod(driver, search);
		search.sendKeys(Name);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		return this;
	}
	public SalesHomePage searchCampaign(String Name) throws InterruptedException {

		WebElement search=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.searchCampaign")));
		CommonActions.waitClickMethod(driver, search);
		search.sendKeys(Name);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		return this;
	}
	public SalesHomePage searchLead(String Name) throws InterruptedException {

		WebElement search=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.searchLead")));
		CommonActions.waitClickMethod(driver, search);
		search.sendKeys(Name);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		return this;
	}

	public CampaignsPage openCampaign(String campaignName) throws InterruptedException{

		WebElement campaignRow=driver.findElement(By.xpath(String.format("(//tr//a[@title='%s'])[1]",campaignName)));
		Thread.sleep(2000);
		CommonActions.waitClickMethod(driver, campaignRow);
		return new CampaignsPage(driver, prop);
	}
	public UserProvisioningRequestsPage clickClassicView() {

		WebElement classicView= driver.findElement(By.xpath(prop.getProperty("SalesHomePage.classicView")));
		CommonActions.waitClickMethod(driver, classicView);
		parentWindow= driver.getWindowHandle();
		CommonActions.getwindow(driver, 1);
		return new UserProvisioningRequestsPage(driver, prop);
	}

	public SalesHomePage loadAllContacts() {

		List<WebElement> currentList=driver.findElements(By.xpath(prop.getProperty("SalesHomePage.allConatctsLoad")));

		for (int i=0;i<currentList.size(); i++) {
			currentList.get(currentList.size()-1).click();
			currentList=driver.findElements(By.xpath(prop.getProperty("SalesHomePage.allConatctsLoad")));
		}

		return this;
	}

	public SalesHomePage searchUniqueContactAndClickDropDown() {

		List<String> contactsName= new ArrayList<String>();

		Set<String> sets= new LinkedHashSet<String>();

		List<WebElement>allNames=driver.findElements(By.xpath(prop.getProperty("SalesHomePage.allNames")));

		for (WebElement webElement : allNames) {

			contactsName.add(webElement.getText());
			sets.add(webElement.getText());
		}

		for (String name : sets) {

			int searchSize=driver.findElements(By.xpath("//table/tbody/tr/th/span/a[text()='"+name+"']")).size();

			System.out.println(searchSize);

			if(searchSize==1) {

				unqiueContactName = name;

				System.out.println(unqiueContactName);

				driver.findElement(By.xpath(String.format("//a[@title='%s']//ancestor::tr/td[8]/span",unqiueContactName))).click();

				break;

			}
		}
		return this;
	}

	public EditContactPage clickEditContact() {

		WebElement editContact=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.edit")));
		editContact.click();
		return new EditContactPage(driver,prop);
	}

	public String getPhoneNumber() {

		WebElement actualNumber= driver.findElement(By.xpath(String.format("(//th[@title='Phone']//following::a[@title='%s']//ancestor::tr//td[5]/span/span)[1]", unqiueContactName)));
		System.out.println("Actual phone number "+actualNumber.getText());
		return actualNumber.getText();
	}

	public String getFirstworkTypeName() {

		workTypeName = driver.findElement(By.xpath(prop.getProperty("SalesHomePage.workTypeName"))).getText();
		return workTypeName;
	}

	public SalesHomePage clickWorkTypeDropDown() {

		WebElement dropDown = driver.findElement(By.xpath(prop.getProperty("SalesHomePage.WorkTypedropDown")));
		dropDown.click();
		return this;
	}

	public EditWorkTypePage clickEditWorkType() {

		WebElement editWorkType=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.edit")));
		editWorkType.click();
		return new EditWorkTypePage(driver, prop);
	}

	public String getWorkTypeEditedMessage() {

		WebElement WorkTypeEditedmessageElement= driver.findElement(By.xpath(prop.getProperty("SalesHomePage.WorkTypeEditedmessageElement")));

		CommonActions.waitVisibleMethod(driver, WorkTypeEditedmessageElement);

		return WorkTypeEditedmessageElement.getText();

	}

	public SalesHomePage leadDropdown(String leadName) {

		WebElement dropdown= driver.findElement(By.xpath(String.format("(//a[@title='%s']//ancestor::tr//td[10])[1]", leadName)));
		dropdown.click();
		return this;
	}

	public SalesHomePage clickdisplayOption() {

		WebElement displayOption=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.displayOption")));
		displayOption.click();
		return this;
	}
	public SalesHomePage clicktableView() {

		WebElement tableView=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.tableView")));
		tableView.click();
		int i=1;

		while(i<3) {

			WebElement ascendingOrder=driver.findElement(By.xpath(prop.getProperty("SalesHomePage.ascendingOrder")));
			ascendingOrder.click();
			i++;

		}

		return this;
	}

	public SalesHomePage loadAllOpportunities() throws InterruptedException {
		
		Thread.sleep(2000);

		List<WebElement> currentList=driver.findElements(By.xpath(prop.getProperty("SalesHomePage.allOpportunitiesLoad")));

		for (int i=0;i<currentList.size(); i++) {
			//currentList.get(currentList.size()-1).click();
			driver.executeScript("arguments[0].click();", currentList.get(currentList.size()-1));
			currentList=driver.findElements(By.xpath(prop.getProperty("SalesHomePage.allOpportunitiesLoad")));
		}

		return this;
	}

	public boolean isDatesSorted() {

		List<WebElement> allElementsDate= driver.findElements(By.xpath(prop.getProperty("SalesHomePage.allElementsDate")));

		List<String> actualDates= new LinkedList<String>();

		for (WebElement webElement : allElementsDate) {

			actualDates.add(webElement.getText());

			System.out.println(webElement.getText());
		}


		List<String> sortedDates= new LinkedList<String>();


		for (String string : actualDates) {


			SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
			Date date = null;
			try {
				date = format.parse(string);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			sortedDates.add(format.format(date));
			
			System.out.println(format.format(date));

		}


		if(sortedDates.equals(actualDates))
			return true;

		else
			return false;
	}

}
