package com.spartars.stackexchange.controller;

import com.spartars.stackexchange.converter.QuestionConverter;
import com.spartars.stackexchange.model.StackExchangeQuery;
import com.spartars.stackexchange.model.StackExchangeQuestion;
import com.spartars.stackexchange.question.QuestionQuery;
import com.spartars.stackexchange.util.UrlBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class QueryController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String queryForm(Model model) {
        model.addAttribute("stackExchangeQuery", new StackExchangeQuery());
        return "query";
    }


    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String querySubmit(@ModelAttribute StackExchangeQuery query, Model model) {

        String url = UrlBuilder.buildUrl(query.getOrder(), query.getSort(), query.getIntitle());
        QuestionQuery questionQuery = new QuestionQuery(url);
        String questionsString = questionQuery.getQuestions();
        List<StackExchangeQuestion> questions = QuestionConverter.getStackExchangeQuestions(questionsString);

        model.addAttribute("stackExchangeQuestion", new StackExchangeQuestion());
        model.addAttribute("questions", questions);

        return "result";
    }
}
