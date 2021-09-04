package pages;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NewContactPage{

	private ChromeDriver driver;
	private Properties prop;
	public NewContactPage(ChromeDriver driver, Properties prop) {

		this.driver=driver;
		this.prop=prop;
	}

	public NewContactPage salutation(String salutationValue) {

		WebElement salutationDropdown=driver.findElement(By.xpath(prop.getProperty("NewContactPage.salutationDropdown")));
		salutationDropdown.click();

		WebElement salutation=driver.findElement(By.xpath(String.format("//span[text()='Salutation']//following::a[@title='%s']",salutationValue)));
		salutation.click();
		return this;
	}

	public NewContactPage firstName(String contactFirstName) {

		WebElement firstName=driver.findElement(By.xpath(prop.getProperty("NewContactPage.firstName")));
		firstName.sendKeys(contactFirstName);
		return this;
	}

	public NewContactPage lastName(String contactLastName) {

		WebElement lastName=driver.findElement(By.xpath(prop.getProperty("NewContactPage.lastName")));
		lastName.sendKeys(contactLastName);
		return this;
	}

	public NewContactPage saveNewContact() throws InterruptedException {

		WebElement saveButon= driver.findElement(By.xpath(prop.getProperty("NewContactPage.saveButon")));
		saveButon.click();
		Thread.sleep(3000);
		return this;
	}


}
