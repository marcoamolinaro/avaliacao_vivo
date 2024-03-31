package com.vivo.corrida.controller;

import com.vivo.corrida.dto.CorridaDTO;
import com.vivo.corrida.helper.CSVHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/")
public class CorridaController {

    @GetMapping(value = "/teste")
    public String teste() {

        //List<CorridaDTO> corridas = new ArrayList<>();

        //corridas = CSVHelper.csvToOrders();

        return "Hello World!";
    }
}
