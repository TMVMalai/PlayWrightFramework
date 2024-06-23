package testCases;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.playwright.modules.Modules;

import baseFunctions.CommonFunctions;

public class PlaywrightInitialization extends CommonFunctions {

	@Test(enabled = true, groups = "Regression")
	public void searchVedioFunctionaly() {
		Map<String, Object> testData = new HashMap<String, Object>();
		Modules m = new Modules(testData, page);
		System.out.println("Login Completed");
		//m.testClickFunctionality();
	}
	

}
