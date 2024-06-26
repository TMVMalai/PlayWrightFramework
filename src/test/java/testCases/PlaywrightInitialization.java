package testCases;

import org.playwright.dataproviderclass.DataProviderClasses;
import org.testng.annotations.Test;

import java.util.Map;

import org.playwright.modules.Modules;

import baseFunctions.CommonFunctions;

public class PlaywrightInitialization extends CommonFunctions {

    @Test(enabled = true, groups = "Regression", dataProviderClass = DataProviderClasses.class, dataProvider = "getJsonData")
    public void signupFunctionality(Object data) {
        Map<String, Object> testData = (Map<String, Object>) data;
        Modules m = new Modules(testData, page);
        System.out.println("Perform Login");
        m.testClickFunctionality();
    }


}
