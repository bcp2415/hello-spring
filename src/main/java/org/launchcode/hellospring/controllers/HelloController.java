package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    // Create a handler that handles requests of form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String lang) {
        return createMessage(name, lang);
    }

    // Create a handler that handles requests of form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='POST'>" +  // submit request to /hello
                "<input type='text' name='name'>" +
                "<select name='lang' id='lang-select'>" +
                "<option value='en'>English</option>" +
                "<option value='ro'>Romanian</option>" +
                "<option value='la'>Latin</option>" +
                "<option value='ger'>German</option>" +
                "<option value='hu'>Hungarian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String lang) {
        if (lang.equals("en")) {
            return "Hello, " + name + "!";
        } else if (lang.equals("ro")) {
            return "Bună ziua, " + name + "!";
        } else if (lang.equals("la")) {
            return "Salve, " + name + "!";
        } else if (lang.equals("ger")) {
            return "Guten Tag, " + name + "!";
        } else if (lang.equals("hu")) {
            return "Szia, " + name + "!";
        } else return "Get lost!";
    }

}
