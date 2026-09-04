package br.com.javabank.testes;

import br.com.javabank.modelo.Conta;

public class TesteConta {
        // ATALHO MAIN ==> PSVM + TAB
    public static void main(String[] args) {
        //INSTANCIAÇÃO
        Conta c1 = new Conta(1000,"Juca");
        Conta c2 = new Conta(1001, "Ana");
        Conta c3 = c1;
        Conta c4 = new Conta(1001,"Ana");

        //objeto c1
        c1.setTitular("Juca Pereira");
        //c1.numero = 1000;
        //c1.saldo = 500;

        //obeto c2
        //c2.numero = 1001;
        //c2.titular = "Ana";
        //c2.saldo = 1200;

        //c3.titular = "Edgar";

        //Objeto c4
        //c4.numero = 1001;
        //c4.titular = "Ana";
        //c4.saldo = 1200;

        System.out.println("Saldo C1: " + c1.getSaldo());
        System.out.println("Saldo C2: " + c2.getSaldo());

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        c3.setTitular("Edgar");

        System.out.println(c3.getTitular());
        System.out.println(c1.getTitular());

        System.out.println(c2.getSaldo() == c4.getSaldo());
        System.out.println(c2.getNumero() == c4.getNumero());
        System.out.println(c2.getTitular() == c4.getTitular());
        System.out.println(c2 == c4);
        System.out.println(c1 == c3);

        System.out.println("Saldo atual [c1]: " + c1.getSaldo());
        c1.depositar(500);
        System.out.println("Saldo atual [c1]: " + c1.getSaldo());
        c1.sacar(300);
        System.out.println("Saldo atual [c1]: " + c1.getSaldo());
        //c1.saldo -= 500000;
        System.out.println("Saldo atual [c1]: " + c1.getSaldo());
    }
}
