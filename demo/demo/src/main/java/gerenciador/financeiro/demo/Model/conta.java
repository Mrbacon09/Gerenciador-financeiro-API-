
import java.util.HashMap;


public class conta { 

    private static int contador = 0; // Contador estático para quantidade de movimentações
    private String titular; // Nome do titular da conta
    private String numeroConta; // Número da conta
    private int saldo; // Saldo da conta
    private Lista_transacao <transacoes> listaMovimentacao = new Lista_transacao<>(); // Cria uma nova lista do Arquivo Lista_transacao para armazenar as movimentações da conta

    public conta (String titular, String numeroConta, int saldo, HashMap<Integer,transacoes> movimentacoes) { // Método para criar uma conta
        
        this.numeroConta = numeroConta; // Atribui o número da conta à conta
        this.titular = titular; // Atribui o nome do titular à conta
        this.saldo = saldo; // Atribui o saldo à conta

        System.out.println("/*----------Bem-vindo ao sistema de gerenciamento de contas!----------*/");// Exibe as informações do constructor
        if(titular == null || titular.isEmpty()) { // Verifica se o nome do titular é nulo ou vazio
            System.out.println("Nome do titular inválido!"); // Exibe mensagem de erro
            return;
        } else {
            System.out.println("Nome do titular da conta: " + this.getTitular()); 
        }
        
        if (numeroConta == null || numeroConta.length() < 5 || !numeroConta.matches("\\d+")) { // Verifica se o número da conta é nulo, possui menos de 5 caracteres ou contém caracteres não numéricos
            System.out.println("Número da conta inválido!"); // Exibe mensagem de erro
            return;
        } else {
            
            System.out.println("Número da conta: " + this.getNumeroConta()); // Exibe o número da conta
        }

        System.out.println("Saldo inicial: " + this.getSaldo()); // Exibe o saldo inicial da conta
        System.out.println("/*--------------------*/\n");
    }

    public int getSaldo() { // getter do saldo da conta
        return saldo; 
    }
    public void setSaldo(int saldo) { // Setter do saldo da conta
        this.saldo = saldo; 
    }

    public String getTitular() { // Método para obter o nome do titular da conta
        return titular; 
    }

    public String getNumeroConta() { // Método para obter o número da conta
        return numeroConta; 
    }

    public void setMovimentacoes(HashMap<Integer, transacoes> movimentacao) { // Método para adicionar as movimentações da conta em um mapa
        if (movimentacao == null) { // Verifica se a movimentação é nula
            System.out.println("Movimentações inválidas!"); // Exibe mensagem de erro
            return;
        }
        else{
            movimentacao.put(contador, movimentacao.get(contador)); // Adiciona a movimentação ao mapa a partir do contador
            listaMovimentacao.adicionarTransacao(movimentacao.get(contador)); // Adiciona a movimentação à lista de movimentações
            contador++; // Incrementa o contador de movimentações
        }
        
        
    }

    public static int getId(){ // Método para obter o ID da movimentação
        int id = contador;
        return id; 
    }

    public void imprimirRelatorio(){
        listaMovimentacao.imprimirTransacao(); // Método chama a Lista_transacao para imprimir o relatório de movimentações
    }

    public int calculaSaldo(int saldo){ // Método chama a Lista_transacao para calcular o saldo da conta
        this.saldo = listaMovimentacao.calcularSaldo(saldo); //atualiza o saldo da conta  
        return this.saldo; // Retorna o saldo da conta
    }


}