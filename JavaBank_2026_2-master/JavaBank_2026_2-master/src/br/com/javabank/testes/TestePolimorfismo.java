package br.com.javabank.testes;

import br.com.javabank.modelo.Corrente;

public class TestePolimorfismo {
    public static void main(String[] args) {
        Corrente cc1 = new Corrente(1000, "Juca", 500);
        Corrente cc2 = new Corrente(1000, "Juca", 500);


        System.out.println(cc1);
        System.out.println(cc1.hashCode());
    }
}
