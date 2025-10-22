package edu.eci.arep.parcial.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    private ArrayList<Integer> resultado = null;
    private ArrayList<Integer> resultado2 = null;

    public ArrayList<Integer> numerosCatalan(Integer numero){
        Integer sumatoria = 1;

        for (Integer i = 1; i <= numero - 1; i++){
            Integer actual = i * (sumatoria - 1 - i);
            sumatoria += actual;
            resultado.add(sumatoria);
            System.out.println(resultado);
        }

        for (Integer i = 1; i <= numero - 1; i++){
            Integer actual2 = 1/(i+1)*((2*i)/i);
            resultado2.add(actual2);
            System.out.println(resultado2);

        }
        return resultado2;
    }

}
