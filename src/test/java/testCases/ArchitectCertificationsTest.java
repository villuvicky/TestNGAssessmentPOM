package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pages.AdministratorOverviewPage;
import pages.MobileAppsPage;
import pages.SalesForceHomePage;


public class ArchitectCertificationsTest extends BaseClass{

	private SalesForceHomePage salesForceHomePage;
	private MobileAppsPage mobileAppsPage;
	private AdministratorOverviewPage administratorOverviewPage;
	@Test
	public void acrchitectCertifications() throws IOException, InterruptedException {

		salesForceHomePage = new SalesForceHomePage(driver, prop);
		salesForceHomePage.mobilePublisher();

		mobileAppsPage = new MobileAppsPage(driver, prop);
		mobileAppsPage.resources().salesForceCertification();

		administratorOverviewPage=new AdministratorOverviewPage(driver, prop);
		administratorOverviewPage.salesForceArchitect().
		salesForceArchitectDescription().getSolutionArchitectLogo().
		geTtechnicalArchitectLogo().listOfCertification();
	}
}