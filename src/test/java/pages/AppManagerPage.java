package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AppManagerPage {

	private ChromeDriver driver;
	private Properties prop;

	public AppManagerPage(ChromeDriver driver,Properties prop){

		this.driver=driver;
		this.prop=prop;
	}
	
	public AppManagerPage loadElementsNew() {
		
		List<WebElement> currentList=driver.findElements(By.xpath(prop.getProperty("AppManagerPage.currentList")));
		
		for (int i=0;i<currentList.size(); i++) {
			
			currentList.get(currentList.size()-1).click();
			currentList=driver.findElements(By.xpath(prop.getProperty("AppManagerPage.currentList")));
			System.out.println(i);
			System.out.println(currentList.size());
		}
		return this;
		
	}
	
	
	public AppManagerPage getApplicationNames() {

		List<String> appNames= new ArrayList<String>();
		List<WebElement> appNamesElement=driver.findElements(By.xpath(prop.getProperty("AppManagerPage.appNamesElement")));

		for (WebElement webElement : appNamesElement) {
			appNames.add(webElement.getText());
		}
		System.out.println(appNames);

		return this;
	}

	public AppManagerPage getDeveloperNames() {

		List<String> Names= new ArrayList<String>();

		List<WebElement> developerNamesElement=driver.findElements(By.xpath(prop.getProperty("AppManagerPage.developerNamesElement")));

		for (WebElement webElement : developerNamesElement) {
			Names.add(webElement.getText());
		}

		System.out.println(Names);
		return this;
	}
}
