package edu.eci.arep.parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arep.parcial.service.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService;

    
    public MathController(MathService mathService){
        this.mathService = mathService; 
    }

    @GetMapping("/catalan")
    public ArrayList<Integer> getCatalan(@RequestParam Integer numero){
        return mathService.numerosCatalan(numero);
    }


}
