package com.spartars.stackexchange.model;

import org.springframework.stereotype.Component;

@Component
public class StackExchangeQuery {

    private String intitle;
    private String sort;
    private String order;

    public String getIntitle() {
        return intitle;
    }

    public void setIntitle(String intitle) {
        this.intitle = intitle;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}

