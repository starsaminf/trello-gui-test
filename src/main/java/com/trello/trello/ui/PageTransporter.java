package com.trello.trello.ui;

import com.trello.trello.config.EnvironmentTrello;
import core.selenium.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class PageTransporter {
    private static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {
        PAGE_URL.put("LOGIN", "/login");
        PAGE_URL.put("HOME", "/home");
        PAGE_URL.put("BOARD", "/boards");
    }

    public static void navigateToPage(final String pageName) throws MalformedURLException {
        navigateToUrl(EnvironmentTrello.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName.toUpperCase())));
    }

    private static void navigateToUrl(final String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDrive().navigate().to(new URL(url));
    }
}
