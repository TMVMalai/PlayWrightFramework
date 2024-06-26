package baseFunctions;

import java.nio.file.Paths;

import org.framework.playwright.utils.UtilityClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonFunctions extends UtilityClass {

	@BeforeMethod
	public void login() {
		page = initialization();
	}

	@AfterMethod
	public void driverClose() {
		page.close();
		playwright.close();
	}

}
