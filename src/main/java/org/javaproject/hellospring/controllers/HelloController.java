package org.javaproject.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloController {

    @RequestMapping(value="")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type = 'text' name = 'name' />" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");

        return "Hello " + name;
    }

    @RequestMapping(value = "bonjour", method = RequestMethod.GET)
    @ResponseBody
    public String createMessage(){
        String html = "<form method='post'>" +
                "<input type = 'text' name = 'name' />" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='French'>French</option>" +
                "<option value='German'>German</option>" +
                "<option value='Italian'>Italian</option></select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "bonjour", method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(HttpServletRequest request) {
        String language = request.getParameter("language");
        String name = request.getParameter("name");
        String hello = "hello";
        switch (language) {
            case "English":
                hello = "Hello";
                break;
            case "Spanish":
                hello = "Hola";
                break;
            case "French":
                hello = "Bonjour";
                break;
            case "German":
                hello = "Hallo";
                break;
            case "Italian":
                hello = "Ciao";
                break;
        }
        String html = hello + " " + name;
        return html;
    }


    @RequestMapping(value="goodbye")
    public String goodbye(){
        return "redirect:/";
    }
}
