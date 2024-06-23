package org.playwright.modules;

import java.util.Map;

import org.framework.playwright.utils.UtilityClass;
import org.playwright.pages.DemoPage;

import com.microsoft.playwright.Page;


public class Modules extends UtilityClass{
	Page page;
	DemoPage searchPage;
	Map<String, Object> data;

	public Modules(Map<String, Object> data, Page page) {
		this.searchPage = new DemoPage(page);
		this.data = data;
	}

	public void testClickFunctionality() {
		searchPage.clickCheckBox();
		System.out.println(searchPage.getUserNames());
		searchPage.clickAllUserNames();
	}
	
	
}
