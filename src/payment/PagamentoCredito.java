package payment;

/**
 * PagamentoCredito - Implementação concreta do padrão Strategy
 * Estratégia de pagamento por cartão de crédito
 */
public class PagamentoCredito implements PagamentoStrategy {

    @Override
    public boolean processar(double valor) {
        System.out.println("💳 Processando pagamento por CRÉDITO...");
        System.out.println("   Valor: R$ " + String.format("%.2f", valor));
        System.out.println("   Consultando limite do cartão...");
        System.out.println("   Processando transação...");
        System.out.println("   ✓ Pagamento por crédito autorizado com sucesso!");
        return true;
    }

    @Override
    public String getNome() {
        return "Cartão de Crédito";
    }
}
