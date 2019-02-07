package com.spartars.stackexchange.converter;

import com.spartars.stackexchange.model.StackExchangeQuestion;
import com.spartars.stackexchange.util.DateUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class QuestionConverter {

    private static final String ITEMS = "items";
    private static final String QUESTION_AUTHOR = "owner";
    private static final String QUESTION_AUTHOR_NAME = "display_name";
    private static final String QUESTION_TITLE = "title";
    private static final String QUESTION_CREATION_DATE = "creation_date";
    private static final String QUESTION_IS_ANSWERED = "is_answered";
    private static final String QUESTION_LINK = "link";

    public static List<StackExchangeQuestion> getStackExchangeQuestions(String response) {
        List<StackExchangeQuestion> questions = new ArrayList<>();
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray items = jsonResponse.getJSONArray(ITEMS);

        for (int i = 0; i < items.length(); i++) {
            JSONObject jsonObject = items.getJSONObject(i);
            questions.add(convertToStackExchangeQuestion(jsonObject));
        }

        return questions;
    }

    private static StackExchangeQuestion convertToStackExchangeQuestion(JSONObject questionJSON) {
        JSONObject owner = (JSONObject) questionJSON.get(QUESTION_AUTHOR);
        String title = (String) questionJSON.get(QUESTION_TITLE);
        String ownerName = (String) owner.get(QUESTION_AUTHOR_NAME);
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(((int) questionJSON.get(QUESTION_CREATION_DATE)) * 1000L);
        String creationDate = DateUtil.formatDate(calendar.getTime());
        boolean isAnswered = (boolean) questionJSON.get(QUESTION_IS_ANSWERED);
        String link = (String) questionJSON.get(QUESTION_LINK);

        return new StackExchangeQuestion(title, ownerName, creationDate, isAnswered, link);
    }
}