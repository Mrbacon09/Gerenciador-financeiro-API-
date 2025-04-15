package main.java.gerenciador.financeiro.demo.dto;

public class TransacaoDTO {
    private int valor;
    private String destinatario; 
    private String categoria; // ex.: "Salário", "Transferência", etc.

    // Getters e Setters
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
