package org.playwright.pages;

import java.util.List;

import org.framework.playwright.annotations.FindBy;
import org.framework.playwright.utils.UtilityClass;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoPage extends UtilityClass {

	public Page page;

	public DemoPage(Page page) {
		this.page = page;
		initElements(page, this);
	}

	@FindBy(xpath = "//a[text()='Joe.Root']//parent::td/..//following-sibling::td//input[@type='checkbox']")
	private Locator element;

	@FindBy(xpath = "//a[text()='Username']//ancestor::thead/following-sibling::tbody//tr//td[2]")
	private Locator userNames;

	public void clickCheckBox() {
		element.click();
	}

	public List<String> getUserNames() {
		List<String> userNamesList = userNames.allTextContents();
		return userNamesList;
	}

	public void clickAllUserNames() {
		List<Locator> elements = getLocators(userNames);
		for (Locator ele : elements) {
			ele.click();
		}
	}

}
