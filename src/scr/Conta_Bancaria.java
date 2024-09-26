package scr;

//Criação classe conta Bancária

public class Conta_Bancaria {
    private double saldo;
    private int contadorConsultas;

    //Construtor chama as variaveis
    public Conta_Bancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        this.contadorConsultas = 0;
    }

    //método depositar que cobra 1% de taxa sobre o valor depositado pelo cliente
    public void depositar(double valor) {
        double taxa = valor * 0.01;
        saldo += valor - taxa;
    }

    // identifiquei pelo boolean se há saldo na conta, e ainda acresci o valor de juros de 0.5%
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            // 0.5% de taxa 
            double taxa = valor * 0.005;
            saldo -= valor + taxa;
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    //coloquei um contador de consultas para realizar a contagem de quantas vezes o cliente consulta a conta e debita 10 centavos ao acrescer da contagem em 5
    public double consultarSaldo() {
        contadorConsultas++;
        if (contadorConsultas % 5 == 0) {
            saldo -= 0.10;
        }
        return saldo;
    }


public class Main {
    public static void main(String[] args) {
        Conta_Bancaria conta = new Conta_Bancaria(1000);

        conta.depositar(1200);
        System.out.println("Saldo após depósito: " + conta.consultarSaldo());

        conta.sacar(438);
        System.out.println("Saldo após saque: " + conta.consultarSaldo());

        // Se o cliente consultar 5 vezes para verificar a cobrança da taxa
        for (int i = 0; i < 5; i++) {
            conta.consultarSaldo();
        }
        System.out.println("Saldo após 5 consultas: " + conta.consultarSaldo());
    }
}
}
