package com.spartars.stackexchange.question;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class QuestionQuery {

    private String url;

    public QuestionQuery(String url) {
        this.url = url;
    }

    public String getQuestions() {

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        String result = restTemplate.getForObject(this.url, String.class);

        return result;
    }
}
