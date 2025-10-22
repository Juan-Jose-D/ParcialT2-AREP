package edu.eci.arep.parcial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public List numerosCatalan(int numero) {
        List resultado = new ArrayList<>();

        for (int n = 0; n < numero; n++) {
            int catalan = factorial(2 * n)/(factorial(n + 1) * (factorial(n)));
            resultado.add(catalan);
        }

        return resultado;
    }

    private int factorial(int n) {
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial = factorial * (i);
        }
        return factorial;
    }
}

