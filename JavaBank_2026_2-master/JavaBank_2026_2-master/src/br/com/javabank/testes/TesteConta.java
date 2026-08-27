package br.com.javabank.testes;

import br.com.javabank.modelo.Conta;

public class TesteConta {
        // ATALHO MAIN ==> PSVM + TAB
    public static void main(String[] args) {
        //INSTANCIAÇÃO
        Conta c1 = new Conta();
        Conta c2 = new Conta();

        //objeto c1
        c1.titular = "Juca";
        c1.numero = 1000;
        c1.saldo = 500;

        //obeto c2
        c2.titular = "Bafonildo";
        c2.saldo = 5000;
        c2.numero = 67;

        System.out.println("Saldo C1: " + c1.saldo);
        System.out.println("Saldo C2: " + c2.saldo);
    }
}
