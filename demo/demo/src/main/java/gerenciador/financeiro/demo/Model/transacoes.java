import java.util.Calendar;
import java.util.Date;

public abstract class transacoes{ // Classe abstrata transacoes, cria uma generalização para as transações
    
    private static int contador = 0; // Contador estático para quantidade de movimentações
    private int id; /*Obs.: para esse projeto, o id será definido pelo contador */
    private String titular; // Nome do titular da conta
    private String destinatario;   // Nome do destinatário de exemplo(definido anteriormente sempre como "Pessoa qualquer")
    private String numeroConta; // Número de identificação da conta
    private int valor; // Valor da transação (entrada ou saída)
    private String tipo; // Tipo da transação (entrada ou saída)
    private Date data; // Data da transação (para fins de praticidade, sempre será definida com a data atual)
    private boolean recorrente; // Indica se a transação se repete ou não
    private String categoria; // Categoria da transação (Mercado, combustível, lazer, etc.)
    private String fonte; // Fonte da transação (PIX, crédito, ou débito)

    public transacoes(int id, String titular,String destinatario, String numeroConta, int valor, String tipo, Date data, boolean recorrente, String categoria, String fonte) { // Construtor da classe
        this.id = contador; // Atribui o ID único à transação
        this.titular = titular;
        this.destinatario = destinatario;
        this.numeroConta = numeroConta;
        this.valor = valor;
        this.tipo = tipo;
        this.data = data; 
        this.recorrente = recorrente;
        this.categoria = categoria;
        this.fonte = fonte; // Atribui a fonte da transação
        contador++; // Incrementa o contador de movimentações
    }
/*getters e setters */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        data = Calendar.getInstance().getTime(); // Obtém a data atual
        return data; // Retorna o objeto Calendar diretamente
    }/* Obs.: Como a data de uma transação não muda, data não possui um setter */ 
    

    public boolean isRecorrente() { // Verifica se a transação é recorrente
        return recorrente;
    }
    public void setRecorrente(boolean recorrente) {
        this.recorrente = recorrente;
    }

    public static int getContador() {
        return contador;
    } // Retorna o valor do contador, que é estático e pertence à classe, não à instância
    
    public String getCategoria() {
        return categoria;
    } 
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFonte() {
        return fonte;
    } /*Obs.: Fonte será definida dentro de cada classe especializada, não precisando de um setter */

}
