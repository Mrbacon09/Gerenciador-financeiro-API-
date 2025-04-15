package main.java.gerenciador.financeiro.demo.dto;

public class ContaDTO {
    private String titular;
    private String numeroConta;
    private int saldo;

    // Getters e Setters
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
