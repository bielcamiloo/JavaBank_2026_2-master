package br.com.javabank.modelo;

public class Conta {
    public int numero;
    public String titular;
    public double saldo;

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean sacar(double valor) {
        // %% ==> AND
        // || ==> OR
        // ! ==> NOT
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
}

