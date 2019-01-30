package com.spartars.stackexchange.converter;

import com.spartars.stackexchange.model.StackExchangeQuestion;
import com.spartars.stackexchange.util.DateUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class QuestionConverter {

    public static List<StackExchangeQuestion> getStackExchangeQuestions(String response) {
        List<StackExchangeQuestion> questions = new ArrayList<StackExchangeQuestion>();
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray items = jsonResponse.getJSONArray("items");

        for (int i = 0; i < items.length(); i++) {
            JSONObject jsonObject = items.getJSONObject(i);
            questions.add(convertToStackExchangeQuestion(jsonObject));
        }

        return questions;
    }

    private static StackExchangeQuestion convertToStackExchangeQuestion(JSONObject questionJSON) {
        JSONObject owner = (JSONObject) questionJSON.get("owner");
        String title = (String) questionJSON.get("title");
        String ownerName = (String) owner.get("display_name");
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(((int) questionJSON.get("creation_date")) * 1000L);
        String creationDate = DateUtil.formatDate(calendar.getTime());
        boolean isAnswered = (boolean) questionJSON.get("is_answered");
        String link = (String) questionJSON.get("link");

        return new StackExchangeQuestion(title, ownerName, creationDate, isAnswered, link);
    }
}