package main.java.gerenciador.financeiro.demo.dto;

public class CreditoDTO extends TransacaoDTO {
    private int parcelas;

    public int getParcelas() {
        return parcelas;
    }
    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
}
