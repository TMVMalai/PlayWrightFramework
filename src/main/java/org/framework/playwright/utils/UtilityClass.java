package org.framework.playwright.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.framework.playwright.annotations.FindBy;
import org.framework.playwright.constants.FrameWorkConstants;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;package org.framework.playwright.utils;

import java.util.*;

import org.framework.playwright.annotations.FindBy;
import org.framework.playwright.constants.FrameWorkConstants;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Paths;

import static org.framework.playwright.utils.Logger.*;

public class UtilityClass {

    private static final Logger log = LoggerFactory.getLogger(UtilityClass.class);
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;
    public static BrowserContext context;
    public static Properties prop;

    static {
        prop = new Properties();
        String propath = FrameWorkConstants.PROP_PATH;
        try (FileInputStream fis = new FileInputStream(propath)) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Page initialization() {
        playwright = Playwright.create();
        String browserChoice = prop.getProperty("browser");
        boolean headless;
        if (prop.getProperty("Headless").equals("true")) {
            headless = true;
        } else {
            headless = false;
        }
        switch (browserChoice.toLowerCase()) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                System.out.println("Chrome Browser Started Successfully");
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                System.out.println("fire Fox Browser Started Successfully");
        }

        context = browser.newContext();
        page = context.newPage();
        page.navigate(prop.getProperty("url"));
        return page;
    }

    public static void switchToWindowIndex(int index) {
        List<Page> allPages = context.pages();
        Page reqWindow = allPages.get(index);
        if (index < 0 || index >= allPages.size()) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        reqWindow.bringToFront();
    }

    public static void close() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    public static List<Locator> getLocators(Locator element) {
        List<Locator> elements = new ArrayList<>();
        int count = element.count();
        for (int i = 0; i < count; i++) {
            elements.add(element.nth(i));
        }
        return elements;
    }

    public static void removeElements(List<Locator> elements) {
        for (int i = elements.size(); i >= 0; i--) {
            Locator element = elements.get(i);
            element.click();
        }
    }

    public static void initElements(Page page, Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.getType().isAssignableFrom(Locator.class)) {
                if (field.isAnnotationPresent(FindBy.class)) {
                    FindBy findBy = field.getAnnotation(FindBy.class);
                    String selector = findBy.xpath();

                    if (!selector.isEmpty()) {
                        try {
                            field.setAccessible(true);
                            field.set(obj, page.locator(selector));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Paths;

public class UtilityClass {

	public static Playwright playwright;
	public static Browser browser;
	public static Page page;
	public static BrowserContext context;
	public static Properties prop;

	static {
		prop = new Properties();
		String propath = FrameWorkConstants.PROP_PATH;
		try (FileInputStream fis = new FileInputStream(propath)) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Page initialization() {
		playwright = Playwright.create();
		String browserChoice = prop.getProperty("browser");
		boolean headless;
		if(prop.getProperty("Headless").equals("true")) {
			headless = true;
		}
		else {
			headless = false;
		}
		switch (browserChoice.toLowerCase()) {
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
			System.out.println("Chrome Browser Started Successfully");
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
			System.out.println("fire Fox Browser Started Successfully");
		}

		context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("loginDataPath")));
		page = context.newPage();
		page.navigate(prop.getProperty("url"));
		return page;
	}

	public static void switchToWindowIndex(int index) {
		List<Page> allPages = context.pages();
		Page reqWindow = allPages.get(index);
		if (index < 0 || index >= allPages.size()) {
			throw new IllegalArgumentException("Invalid index: " + index);
		}
		reqWindow.bringToFront();
	}

	public static void close() {
		if (browser != null) {
			browser.close();
		}
		if (playwright != null) {
			playwright.close();
		}
	}
	
	 public static List<Locator> getLocators(Locator element){
			List<Locator> elements = new ArrayList<>();
			int count = element.count();
			for(int i=0;i<count;i++) {
				elements.add(element.nth(i));
			}
			return elements;
		}

	public static void sendText(Locator element, String value) {
		element.fill(value);
	}

	public static void removeElements(List<Locator> elements) {
		for (int i = elements.size(); i >= 0; i--) {
			Locator element = elements.get(i);
			element.click();
		}
	}

	public static void initElements(Page page, Object obj) {
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.getType().isAssignableFrom(Locator.class)) {
				if (field.isAnnotationPresent(FindBy.class)) {
					FindBy findBy = field.getAnnotation(FindBy.class);
					String selector = findBy.xpath();

					if (!selector.isEmpty()) {
						try {
							field.setAccessible(true);
							field.set(obj, page.locator(selector));
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
