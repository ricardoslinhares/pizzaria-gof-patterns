package payment;

/**
 * PagamentoDinheiro - Implementação concreta do padrão Strategy
 * Estratégia de pagamento em dinheiro
 */
public class PagamentoDinheiro implements PagamentoStrategy {

    @Override
    public boolean processar(double valor) {
        System.out.println("💵 Processando pagamento em DINHEIRO...");
        System.out.println("   Valor: R$ " + String.format("%.2f", valor));
        System.out.println("   Cliente pagando em dinheiro...");
        System.out.println("   ✓ Pagamento em dinheiro recebido com sucesso!");
        return true;
    }

    @Override
    public String getNome() {
        return "Dinheiro";
    }
}
