
import java.util.Date;

/*Obs.: Neste projeto, transações de débito ou pix serão tanto entrada quanto saída*/

public class pix_debito extends transacoes{ // Classe que representa uma transação de débito e PIX (especialização da classe transacoes)

    private String fonte; // Fonte da transação (PIX ou débito)

    public pix_debito(int id, String titular,String destinatario, String numeroConta, int valor, String tipo, Date data,boolean recorrente,String categoria,String fonte) { // Construtor da classe
        super(id,titular,destinatario, numeroConta, valor, tipo, data, recorrente,categoria,fonte); // Chama o construtor da classe pai (transacoes)
        recorrente = false; // Débito sempre será não recorrente para fins de pratcidade e reforça isso caso dado venha errado
        this.fonte = fonte.toUpperCase(); //mudança da fonte para maiúscula para evitar erros de digitação

        if(this.fonte == "PIX"){ // Verifica se a fonte é PIX
            System.out.println("Transação de PIX registrada com sucesso! Anexar comprovante"); // Exibe mensagem de sucesso
        } 
        else { // Caso contrário,será tratada como débito
            System.out.println("Transação de débito registrada com sucesso! Banco notificado"); // Exibe mensagem de sucesso   
        }
    } 
}
