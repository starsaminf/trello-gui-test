package com.trello.trello.ui;

import com.trello.trello.config.EnvironmentTrello;
import core.selenium.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * PageTransporter Class.
 */
public final class PageTransporter {
    private static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {
        PAGE_URL.put("LOGIN", "/login");
        PAGE_URL.put("HOME", "/home");
        PAGE_URL.put("BOARD", "/boards");
    }

    private PageTransporter() {

    }

    /**
     * Navigate to URL.
     * @param pageName
     */
    public static void navigateToPage(final String pageName) {
        navigateToUrl(EnvironmentTrello.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName.toUpperCase())));
    }

    /**
     * Navigate to URL.
     * @param url
     */
    private static void navigateToUrl(final String url) {
        try {
            WebDriverManager.getInstance().getWebDrive().navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new NullPointerException("This url is not valid :" + e.getMessage());
        }
    }
}
