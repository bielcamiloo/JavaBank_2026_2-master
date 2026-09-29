package br.com.javabank.modelo;

public class Poupanca extends Conta{
    private double taxaJuros;

    public Poupanca(int numero,
                    String titular,
                    double taxaJuros){
        super(numero, titular);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros(){
        return taxaJuros;
    }

    public double calcularRendimento(){
        return (getSaldo() * taxaJuros) / 100;
    }
}
