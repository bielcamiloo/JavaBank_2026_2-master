package br.com.javabank.testes;

import br.com.javabank.modelo.Corrente;
import br.com.javabank.modelo.Poupanca;

public class TesteHeranca {
    public static void main(String[] args) {
        Corrente cc1 = new Corrente(2001, "Lucas", 500);
        Poupanca cp1 = new Poupanca(2002, "Marlene", 1);

        cc1.depositar(500);
        cp1.depositar(500);

        cc1.sacar(600);
        cp1.sacar(600);

        System.out.println("Titular: " + cc1.getTitular());
        System.out.println("Saldo: " + cc1.getSaldo());
        System.out.println("Limite: R$" + cc1.getLimite());
        System.out.println();
        System.out.println("Titular: " + cp1.getTitular());
        System.out.println("Saldo: " + cp1.getSaldo());
        System.out.println("Juros: " + cp1.getTaxaJuros() + "%");
        System.out.println("Rendimento: " + cp1.calcularRendimento());
    }
}
