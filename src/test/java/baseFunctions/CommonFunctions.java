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
//		Locator loginButton = page.locator("//div[text()='Login']");
//		loginButton.click();
//		Locator emailRadioButton = page.locator("(//div[text()='Email']//parent::div/../div[contains(@class,'css-1dbjc4n r-zso239') or (@class='css-1dbjc4n')])[1]");
//		emailRadioButton.click();
//		Locator emailfield = page.locator("//input[@data-testid='user-mobileno-input-box']");
//		emailfield.fill(prop.getProperty("emailId"));
//		Locator passwordfield = page.locator("//input[@data-testid='password-input-box-cta']");
//		passwordfield.fill(prop.getProperty("Password"));
//		Locator signIn = page.locator("//div[@data-testid='login-cta']");
//		signIn.click();
//		context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
	}

//	@AfterMethod
//	public void driverClose() {
//	//	page.close();
//		//playwright.close();
//	}

}
