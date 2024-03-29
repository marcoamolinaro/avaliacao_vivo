package com.vivo.corrida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/")
public class CorridaController {

    @GetMapping(value = "/teste")
    public String teste() {
        return "Hello World!";
    }
}
