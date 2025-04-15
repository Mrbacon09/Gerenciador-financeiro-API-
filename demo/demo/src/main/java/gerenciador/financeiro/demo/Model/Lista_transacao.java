import java.util.ArrayList;
import java.util.List;


public class Lista_transacao<T extends transacoes> implements exibicao{ // Declaração genérica da classe que engloba as classes filhas de transacoes e implementa a interface exibicao
    private List<T> transacoes = new ArrayList<>(); // cria lista de transações

    public void adicionarTransacao(T transacao) { // Adiciona uma transação à lista
        transacoes.add(transacao);
    }
    @Override
    public void imprimirTransacao(){ // Método para imprimir informações de cada transação
        if(transacoes.isEmpty()){ // Verifica se a lista de transações está vazia
            System.out.println("Nenhuma movimentação registrada!"); // Exibe mensagem se a lista estiver vazia
            return; // Retorna para evitar erro de execução
        }
        else{
            System.out.println("/----------LISTA DE TRANSAÇÕES-----------/");
        for (T transacao : transacoes) {
            
            System.out.println("ID: " + transacao.getId());
            System.out.println("Titular: " + transacao.getTitular());
            System.out.println("Número da Conta: " + transacao.getNumeroConta());
            System.out.println("Tipo de Transação: " + transacao.getFonte());
            System.out.println("Valor: " + transacao.getValor());
            System.out.println("Tipo: " + transacao.getTipo());
            System.out.println("Destinatário: " + transacao.getDestinatario());
            System.out.println("Data: " + transacao.getData());
            System.out.println("Recorrente: " + (transacao.isRecorrente() ? "Sim" : "Não"));
            System.out.println("Categoria: " + transacao.getCategoria());
            System.out.println("/--------------------------------------/\n");

        }
        }
        
    }

    @Override
    public int calcularSaldo(int saldo_inicial){
        
        int saldo_anterior = saldo_inicial; // Saldo inicial da conta
        int novo_saldo = saldo_inicial; // Novo saldo que será atualizado
        System.out.println("/----------VERIFICAÇÃO DE SALDO-----------/");
        for(T transacao : transacoes){
            if(transacao.getTipo().equals("entrada")){ // Verifica se a transação é uma entrada
                novo_saldo += transacao.getValor(); // Se for, soma o valor ao saldo
            } else if (transacao.getTipo().equals("saida")){ // Se não for uma entrada, verifica se é uma saída
                novo_saldo -= transacao.getValor(); // Se for, subtrai o valor do saldo
            }
        }

        System.out.println("Saldo anterior: " + saldo_anterior); // Exibe o saldo anterior
        if(novo_saldo < 0){
            System.out.println("Saldo negativo! Regularizar conta!"); // Exibe mensagem se o saldo for negativo
            System.out.println("Novo saldo: " + novo_saldo); // Exibe o novo saldo
        }
        else{
            System.out.println("Novo saldo: " + novo_saldo); // Exibe o novo saldo
        }
        System.out.println("Total de Movimentações: " + transacoes.size()); // Exibe o número de movimentações
        System.out.println("/-----------------------------------------/\n");        

        return novo_saldo; // Retorna o novo saldo para próxima verificação

    }

}
