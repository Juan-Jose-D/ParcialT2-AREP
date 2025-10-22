package edu.eci.arep.parcial.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public List<BigInteger> numerosCatalan(int numero) {
        List<BigInteger> resultado = new ArrayList<>();

        for (int n = 0; n < numero; n++) {
            BigInteger catalan = factorial(2 * n)
                    .divide(factorial(n + 1).multiply(factorial(n)));
            resultado.add(catalan);
        }

        return resultado;
    }

    private BigInteger factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}


}
