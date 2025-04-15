package main.java.gerenciador.financeiro.demo.Controler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.controlefinanceiro.dto.ContaDTO;
import com.example.controlefinanceiro.dto.TransacaoDTO;
import com.example.controlefinanceiro.dto.CreditoDTO;
import com.example.controlefinanceiro.model.conta;
import com.example.controlefinanceiro.model.transacoes;
import com.example.controlefinanceiro.model.pix_debito;
import com.example.controlefinanceiro.model.credito;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    // "Banco" em memória: chaveada pelo número da conta.
    private Map<String, conta> contas = new HashMap<>();

    // Endpoint para cadastrar uma nova conta
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarConta(@RequestBody ContaDTO dto) {
        conta novaConta = new conta(dto.getTitular(), dto.getNumeroConta(), dto.getSaldo(), null);
        contas.put(dto.getNumeroConta(), novaConta);
        return ResponseEntity.ok("Conta cadastrada com sucesso!");
    }

    // Endpoint para adicionar uma transação de débito/PIX
    @PostMapping("/{numeroConta}/transacoes/debito")
    public ResponseEntity<?> adicionarDebito(@PathVariable String numeroConta, @RequestBody TransacaoDTO dto) {
        conta c = contas.get(numeroConta);
        if(c == null) {
            return ResponseEntity.notFound().build();
        }
        Date data = new Date();
        // Cria uma nova transação utilizando a classe pix_debito.
        // Note que o construtor exige: id, titular, destinatario, numeroConta, valor, tipo, data, recorrente, categoria, fonte.
        // Definimos "saida" para transações de débito e usamos "PIX" (pode ser customizado se necessário).
        pix_debito transacao = new pix_debito(conta.getId(), c.getTitular(), dto.getDestinatario(), c.getNumeroConta(),
                dto.getValor(), "saida", data, false, dto.getCategoria(), "PIX");
        
        // Adiciona a transação à conta: cria um mapa com a transação e chama o método setMovimentacoes
        HashMap<Integer, transacoes> mov = new HashMap<>();
        mov.put(conta.getId(), transacao);
        c.setMovimentacoes(mov);
        
        // Atualiza o saldo
        c.calculaSaldo(c.getSaldo());
        
        return ResponseEntity.ok("Transação de débito/Pix adicionada com sucesso!");
    }

    // Endpoint para adicionar uma transação de crédito
    @PostMapping("/{numeroConta}/transacoes/credito")
    public ResponseEntity<?> adicionarCredito(@PathVariable String numeroConta, @RequestBody CreditoDTO dto) {
        conta c = contas.get(numeroConta);
        if(c == null) {
            return ResponseEntity.notFound().build();
        }
        Date data = new Date();
        // Cria uma nova transação de crédito.
        credito transacao = new credito(conta.getId(), c.getTitular(), dto.getDestinatario(), c.getNumeroConta(),
                dto.getValor(), "saida", data, true, dto.getCategoria(), "credito", dto.getParcelas());
        // Chama o método para processar as parcelas (exibe no console)
        transacao.TerminoDasParcelas();
        
        HashMap<Integer, transacoes> mov = new HashMap<>();
        mov.put(conta.getId(), transacao);
        c.setMovimentacoes(mov);
        
        c.calculaSaldo(c.getSaldo());
        
        return ResponseEntity.ok("Transação de crédito adicionada com sucesso!");
    }

    // Endpoint para obter um relatório simplificado da conta
    @GetMapping("/{numeroConta}/relatorio")
    public ResponseEntity<?> getRelatorio(@PathVariable String numeroConta) {
        conta c = contas.get(numeroConta);
        if(c == null) {
            return ResponseEntity.notFound().build();
        }
        // Em vez de imprimir no console, monta uma resposta em string.
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Titular: ").append(c.getTitular()).append("\n");
        relatorio.append("Número da Conta: ").append(c.getNumeroConta()).append("\n");
        relatorio.append("Saldo Atual: ").append(c.getSaldo()).append("\n");
        relatorio.append("Verifique o console para a lista de transações (usada internamente no modelo).");
        return ResponseEntity.ok(relatorio.toString());
    }
}
