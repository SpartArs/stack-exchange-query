package com.spartars.stackexchange.model;

import org.springframework.stereotype.Component;

@Component
public class StackExchangeQuestion {

    private String title;
    private String owner;
    private String creationDate;
    private boolean isAnswered;
    private String link;

    public StackExchangeQuestion() {
    }

    public StackExchangeQuestion(String title, String owner, String creationDate, boolean isAnswered, String link) {
        this.title = title;
        this.owner = owner;
        this.creationDate = creationDate;
        this.isAnswered = isAnswered;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
