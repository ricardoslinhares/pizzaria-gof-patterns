package model;

import java.util.ArrayList;
import java.util.List;
import payment.PagamentoStrategy;
import observer.PedidoObserver;

/**
 * Classe Pedido - Integra Strategy Pattern (pagamento) e Observer Pattern
 * (notificações)
 * 
 * Esta classe é o "coração" do sistema que coloca em prática 2 dos 3 padrões:
 * - Strategy Pattern: Estratégia de pagamento pode ser trocada
 * - Observer Pattern: Notifica observadores quando status muda
 */
public class Pedido {
    private static int contador = 0;
    private int numero;
    private Pizza pizza;
    private String status;
    private PagamentoStrategy estratagiaPagemento;
    private List<PedidoObserver> observadores;

    public Pedido(Pizza pizza) {
        this.numero = ++contador;
        this.pizza = pizza;
        this.status = "Recebido";
        this.observadores = new ArrayList<>();
    }

    /**
     * Strategy Pattern: Define a estratégia de pagamento a ser usada
     */
    public void setPagamento(PagamentoStrategy estrategia) {
        this.estratagiaPagemento = estrategia;
    }

    /**
     * Observer Pattern: Registrar um observador para ser notificado
     */
    public void adicionarObservador(PedidoObserver observador) {
        observadores.add(observador);
        System.out.println("   ✓ Observador registrado!");
    }

    /**
     * Observer Pattern: Notificar todos os observadores sobre mudança de status
     */
    private void notificarObservadores(String statusNovo) {
        String statusAnterior = this.status;
        this.status = statusNovo;

        System.out.println("\n--- Notificando observadores ---");
        for (PedidoObserver obs : observadores) {
            obs.atualizar(numero, statusAnterior, statusNovo);
        }
        System.out.println("--- Fim das notificações ---\n");
    }

    /**
     * Muda o status e notifica todos os observadores
     */
    public void mudarStatus(String novoStatus) {
        System.out.println("➤ Mudando status do pedido #" + numero + " para: " + novoStatus);
        notificarObservadores(novoStatus);
    }

    /**
     * Processa o pagamento usando a estratégia definida
     */
    public void procesarPagamento() {
        if (estratagiaPagemento == null) {
            System.out.println("❌ Erro: Nenhuma estratégia de pagamento foi definida!");
            return;
        }

        System.out.println("\n==== PROCESSANDO PAGAMENTO ====");
        System.out.println("Pedido: #" + numero);
        System.out.println("Pizza: " + pizza.getNome());
        System.out.println("Valor Total: R$ " + String.format("%.2f", pizza.getPreco()));
        System.out.println("Forma de Pagamento: " + estratagiaPagemento.getNome());
        System.out.println("---");

        // Strategy Pattern: A estratégia realiza o pagamento
        estratagiaPagemento.processar(pizza.getPreco());
        System.out.println("=============================\n");
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Pedido #%d [%s] - %s (R$ %.2f)",
                numero, status, pizza.getNome(), pizza.getPreco());
    }
}
