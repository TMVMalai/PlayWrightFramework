package org.framework.playwright.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.framework.playwright.utils.Logger.*;
import static org.framework.playwright.utils.Logger.logFailed;

public class BaseClass extends UtilityClass {
    protected Page page;

    public BaseClass(Page page) {
        this.page = page;
        initElements(page, this);
    }

    public static void click(Locator locator, String elementName) {
        locator.click();
    }

    public static void sendText(Locator locator, String Textmessage) {
        locator.fill(Textmessage);
    }

    public static void assertEquals(int expected, int actual) {
        if (expected == actual) {
            logPassed(String.valueOf(expected), String.valueOf(actual));
        } else {
            logFailed(String.valueOf(expected), String.valueOf(actual));
        }
    }

    public static void assertEquals(char expected, char actual) {
        if (expected == actual) {
            logPassed(String.valueOf(expected), String.valueOf(actual));
        } else {
            logFailed(String.valueOf(expected), String.valueOf(actual));
        }
    }

    public static void assertEquals(boolean expected, boolean actual) {
        if (expected == actual) {
            logPassed(String.valueOf(expected), String.valueOf(actual));
        } else {
            logFailed(String.valueOf(expected), String.valueOf(actual));
        }
    }

    public static <T> void assertEquals(List<T> expected, List<T> actual) {
        if (expected.equals(actual)) {
            logPassed(expected.toString(), actual.toString());
        } else {
            logFailed(expected.toString(), actual.toString());
        }
    }

    public static <T> void assertEquals(Set<T> expected, Set<T> actual) {
        if (expected.equals(actual)) {
            logPassed(expected.toString(), actual.toString());
        } else {
            logFailed(expected.toString(), actual.toString());
        }
    }

    public static <K, V> void assertEquals(Map<K, V> expected, Map<K, V> actual) {
        if (expected.equals(actual)) {
            logPassed(expected.toString(), actual.toString());
        } else {
            logFailed(expected.toString(), actual.toString());
        }
    }
}
