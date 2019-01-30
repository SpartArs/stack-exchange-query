package com.spartars.stackexchange.util;

public class UrlBuilder {

    private final static String ROOT_URL = "http://api.stackexchange.com";
    private static final String SITE = "&site=stackoverflow";

    public static String buildUrl(String order, String sort, String intitle) {
        StringBuilder url = new StringBuilder();
        url = url.append(ROOT_URL);
        url = url.append("/2.2/search?");
        url = url.append("order=");
        url = url.append(order);
        url = url.append("&sort=");
        url = url.append(sort);
        url = url.append("&intitle=");
        url = url.append(intitle);
        url = url.append(SITE);

        return url.toString();
    }
}
