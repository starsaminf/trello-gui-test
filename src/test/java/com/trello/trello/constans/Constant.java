package com.trello.trello.constans;

import com.trello.trello.config.EnvironmentTrello;

public final class Constant {
    private static final String BASE_URL = EnvironmentTrello.getInstance().getBaseUrl();
    private static final String BASE_URL_API = "https://api.trello.com/1";

    private Constant() {

    }

    /**
     * Gets the uri of login page.
     *
     * @return as string the uri of login page.
     */
    public static String getLoginPageURL() {
        return BASE_URL + "/login";
    }


}
