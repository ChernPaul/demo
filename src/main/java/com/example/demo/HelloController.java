package com.example.demo;
import com.messenger.Conversations;
import com.messenger.DataProcessing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

// TODO: в отдельный пакет
@Controller
public class HelloController {

    private static final String MODEL_NAME_ATTR = "name";

    @GetMapping("/greeting") // TODO: Магическую строку выделить в отдельный класс констант (или прямо внутри этого класса создать константы) (можно создать пакет с классами констант)
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World" /* TODO: Магическую строку выделить в отдельный класс констант  */) String name, Model model) {
        model.addAttribute(MODEL_NAME_ATTR/* TODO: Магическую строку выделить в отдельный класс констант  */, name);
        return "greeting"; // TODO: Магическую строку выделить в отдельный класс констант
    }

}
