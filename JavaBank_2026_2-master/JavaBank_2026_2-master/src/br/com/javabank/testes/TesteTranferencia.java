package br.com.javabank.testes;

import br.com.javabank.modelo.Conta;

public class TesteTranferencia {
    public static void main(String[] args) {
        Conta c1 = new Conta(1001, "Juarez");
        Conta c2 = new Conta(1002, "Bia");

        System.out.printf("Saldo do %s: R$ %.2f", c1.getTitular(), c1.getSaldo());
        System.out.printf("\nSaldo do %s: R$ %.2f\n", c2.getTitular(), c2.getSaldo());

        System.out.println("\nDeposito de R$ 3000,00");
        c1.depositar(3000);

        System.out.printf("\nSaldo do %s: R$ %.2f", c1.getTitular(), c1.getSaldo());
        System.out.printf("\nSaldo do %s: R$ %.2f", c2.getTitular(), c2.getSaldo());

        System.out.println("\nJuarez transferiu 1000 reais para Bia\n");
        c1.transferir(10000, c2);

        System.out.printf("\nSaldo do %s: R$ %.2f", c1.getTitular(), c1.getSaldo());
        System.out.printf("\nSaldo do %s: R$ %.2f", c2.getTitular(), c2.getSaldo());
    }
}
