package main;

import model.Pizza;
import model.Pedido;
import factory.PizzaFactory;
import payment.*;
import observer.ClienteNotificador;
import observer.GarcomNotificador;

/**
 * Main.java - Demonstração de uso dos 3 padrões GoF
 * 
 * Este programa demonstra:
 * 1. FACTORY PATTERN - Criação de pizzas
 * 2. STRATEGY PATTERN - Estratégias de pagamento
 * 3. OBSERVER PATTERN - Notificações de status de pedido
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GERENCIAMENTO DE PIZZARIA     ║");
        System.out.println("║     Demonstração de Padrões GoF (3/23)     ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // ============================================================
        // 1️⃣ FACTORY PATTERN - Criando pizzas usando a factory
        // ============================================================
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║  1. FACTORY PATTERN - Criando Pizzas          ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        System.out.println("Criando 3 pizzas diferentes usando PizzaFactory...\n");

        Pizza pizza1 = PizzaFactory.criarPizza("mozzarella", "Média");
        Pizza pizza2 = PizzaFactory.criarPizza("calabresa", "Grande");
        Pizza pizza3 = PizzaFactory.criarPizza("vegetariana", "Pequena");

        System.out.println("Pizza 1: " + pizza1);
        System.out.println("Pizza 2: " + pizza2);
        System.out.println("Pizza 3: " + pizza3);

        pizza1.preparar();

        // ============================================================
        // 2️⃣ STRATEGY PATTERN - Testando diferentes estratégias de pagamento
        // ============================================================
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║  2. STRATEGY PATTERN - Testando Pagamentos    ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        // Criar pedido 1 com pagamento por débito
        Pedido pedido1 = new Pedido(pizza1);
        System.out.println("Pedido 1 criado: " + pedido1);

        // Definir estratégia de pagamento (Strategy)
        pedido1.setPagamento(new PagamentoDebito());
        pedido1.procesarPagamento();

        // Criar pedido 2 com pagamento por crédito
        Pedido pedido2 = new Pedido(pizza2);
        System.out.println("Pedido 2 criado: " + pedido2);
        pedido2.setPagamento(new PagamentoCredito());
        pedido2.procesarPagamento();

        // Criar pedido 3 com pagamento em dinheiro
        Pedido pedido3 = new Pedido(pizza3);
        System.out.println("Pedido 3 criado: " + pedido3);
        pedido3.setPagamento(new PagamentoDinheiro());
        pedido3.procesarPagamento();

        // ============================================================
        // 3️⃣ OBSERVER PATTERN - Notificações de mudança de status
        // ============================================================
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║  3. OBSERVER PATTERN - Sistema de Notificação ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        System.out.println("Registrando observadores para o Pedido #1...\n");

        // Registrar observadores no pedido1
        ClienteNotificador clienteNotificador = new ClienteNotificador();
        GarcomNotificador garcomNotificador = new GarcomNotificador();

        pedido1.adicionarObservador(clienteNotificador);
        pedido1.adicionarObservador(garcomNotificador);

        // Simular mudanças de status - os observadores serão notificados
        // automaticamente
        System.out.println("\nSimulando ciclo de vida do pedido...\n");

        pedido1.mudarStatus("Preparando");
        pedido1.mudarStatus("Pronto");
        pedido1.mudarStatus("Entregue");

        // ============================================================
        // 📊 RESUMO FINAL
        // ============================================================
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║               RESUMO FINAL                    ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        System.out.println("✓ Factory Pattern: Criou 3 tipos de pizzas de forma centralizada");
        System.out.println("✓ Strategy Pattern: Processou 3 pagamentos com estratégias diferentes");
        System.out.println("✓ Observer Pattern: Notificou observadores sobre mudanças de status");
        System.out.println("\n✅ Demonstração concluída com sucesso!\n");
    }
}
