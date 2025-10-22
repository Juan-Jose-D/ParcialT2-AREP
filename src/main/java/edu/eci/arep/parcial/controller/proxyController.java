package edu.eci.arep.parcial.controller;

import java.util.List;
import java.io.IOException;
import java.net.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class proxyController {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL =  "http://localhost:8081/index.html";
    private static final String GET_URL2 =  "http://localhost:8082/index.html";

    @GetMapping
    public void getCatalan(@RequestParam Integer numero) throws IOException{

        URL obj;
        try {
            obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        } catch (MalformedURLException e) {
            obj = new URL(GET_URL2);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            e.printStackTrace();
        }
    }
}
