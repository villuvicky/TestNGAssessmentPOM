package pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdministratorOverviewPage {

	String logoSRC;

	URL imageURL;

	BufferedImage saveImage;

	private ChromeDriver driver;
	private Properties prop;

	public AdministratorOverviewPage(ChromeDriver driver,Properties prop){
		
		this.driver=driver;
		this.prop=prop;
	}
	public AdministratorOverviewPage salesForceArchitect() {

		WebElement salesforceArchitect=driver.findElement(By.xpath(prop.getProperty("AdministratorOverviewPage.salesforceArchitect")));
		salesforceArchitect.click();
		return this;
	}

	public AdministratorOverviewPage salesForceArchitectDescription() {

		String text= driver.findElement(By.xpath(prop.getProperty("AdministratorOverviewPage.salesForceArchitectDescription"))).getText();
		System.out.println(text);
		return this;
	}

	public AdministratorOverviewPage geTtechnicalArchitectLogo() throws IOException {


		WebElement technicalArchitectLogo = driver.findElement(By.xpath(prop.getProperty("AdministratorOverviewPage.technicalArchitectLogo")));

		logoSRC = technicalArchitectLogo.getAttribute("src");

		imageURL = new URL(logoSRC);

		saveImage = ImageIO.read(imageURL);

		ImageIO.write(saveImage, "png", new File("./Screenshots/technicalArchitectLogo.png"));

		return this;
	}

	public AdministratorOverviewPage getSolutionArchitectLogo() throws IOException {

		WebElement solutionArchitectLogo =   driver.findElement(By.xpath(prop.getProperty("AdministratorOverviewPage.solutionArchitectLogo")));

		logoSRC = solutionArchitectLogo.getAttribute("src");

		imageURL = new URL(logoSRC);

		saveImage = ImageIO.read(imageURL);

		ImageIO.write(saveImage, "png", new File("./Screenshots/solutionArchitectLogo.png"));

		return this;
	}

	public AdministratorOverviewPage listOfCertification() {

		List<WebElement> certificateElements= driver.findElements(By.xpath(prop.getProperty("AdministratorOverviewPage.certificateElements")));

		List<String> certificates= new ArrayList<String>();

		for (WebElement webElement : certificateElements) {
			certificates.add(webElement.getText());
		}

		System.out.println(certificates);

		driver.switchTo().window(SalesForceHomePage.homeWindow);
		return this;
	}
}
