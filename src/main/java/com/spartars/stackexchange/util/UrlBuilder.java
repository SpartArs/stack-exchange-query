package com.spartars.stackexchange.util;

public class UrlBuilder {

    private final static String ROOT_URL = "http://api.stackexchange.com/2.2/search?";
    private static final String ORDER = "order=";
    private static final String SORT = "&sort=";
    private static final String IN_TITLE = "&intitle=";
    private static final String SITE = "&site=stackoverflow";

    public static String buildUrl(String order, String sort, String intitle) {
        StringBuilder url = new StringBuilder();
        url = url.append(ROOT_URL);
        url = url.append(ORDER);
        url = url.append(order);
        url = url.append(SORT);
        url = url.append(sort);
        url = url.append(IN_TITLE);
        url = url.append(intitle);
        url = url.append(SITE);

        return url.toString();
    }
}