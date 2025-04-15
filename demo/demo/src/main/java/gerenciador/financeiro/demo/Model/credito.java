import java.util.Calendar;
import java.util.Date;

/*Ob.: Para simplificação,neste projeto transações de crédito serão apenas saídas*/

public class credito extends transacoes{ //especialização da classe transacoes para representar transações de crédito
    
    private int parcelas = 1; // Cria uma variável para armazenar o número de parcelas(iniciada com 1 para evitar divisão por zero)
    private int valorParcela = 0; // Cria uma variável para armazenar o valor da parcela
    private String fonte = "Crédito"; // Cria uma variável para armazenar a fonte da transação (Crédito)
    public credito(int id, String titular,String destinatario, String numeroConta, int valor, String tipo, Date data,boolean recorrente,String categoria,String fonte, int parcelas) { // Construtor da classe credito que herda de transacoes
        super(id,titular,destinatario, numeroConta, valor, tipo, data, recorrente,categoria,fonte); // Chama o construtor da classe pai (transacoes)
        tipo = "saída"; // Transações de crédito sempre serao saídas
        this.parcelas = parcelas; // Atribui o número de parcelas
        this.valorParcela = valor / parcelas; // Calcula o valor da parcela
        recorrente = true; // Define como recorrente
    } 

    public int getParcelas() { // getter para obter o número de parcelas
        return parcelas;
    }/*Obs.: Neste projeto não será possível mudar o número de parcelas */
    public void TerminoDasParcelas() { // Método para calcular o término das parcelas
        if (parcelas <= 0 ||(parcelas == 1 && valorParcela <= 0)) { //Verifica se o número de parcelas ou o valor é menor ou igual a zero
            System.out.println("Todas as parcelas foram pagas!");
        } else { //Se as parecelas forem válidas, calcula o mês de término do pagamento
            Calendar data_termino = Calendar.getInstance(); // Cria um objeto Calendar para obter a data atual
            data_termino.add(Calendar.MONTH, parcelas); // Adiciona o número de parcelas(meses) à data atual
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy"); // Formata a data para exibição
            System.out.println("Compra no carão de crédito no valor de " + this.getValor() + "aprovada! Atualizando saldo...\n"); // Exibe mensagem de sucesso
            System.out.println("Parcelas restantes: " + parcelas + "\nValor da parcela: " + valorParcela + "\nData de término: " + sdf.format(data_termino.getTime()) + "\n"); // Exibe o número de parcelas restantes e a data de término
        }
    } 

    public String getFonte() { // Método getter para obter a fonte da transação
        return fonte; // Retorna a fonte da transação
    } 

}
