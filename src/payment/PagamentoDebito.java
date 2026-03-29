package payment;

/**
 * PagamentoDebito - Implementação concreta do padrão Strategy
 * Estratégia de pagamento por cartão de débito
 */
public class PagamentoDebito implements PagamentoStrategy {

    @Override
    public boolean processar(double valor) {
        System.out.println("💳 Processando pagamento por DÉBITO...");
        System.out.println("   Valor: R$ " + String.format("%.2f", valor));
        System.out.println("   Autorizando na máquina de débito...");
        System.out.println("   ✓ Pagamento por débito autorizado com sucesso!");
        return true;
    }

    @Override
    public String getNome() {
        return "Cartão de Débito";
    }
}
