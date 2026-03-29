package payment;

/**
 * PagamentoStrategy - Interface do PADRÃO STRATEGY PATTERN
 * 
 * Define o contrato que todas as estratégias de pagamento devem seguir.
 * Permite trocar a estratégia de pagamento em tempo de execução.
 * 
 * Benefício: Novas formas de pagamento podem ser adicionadas sem mudar a classe
 * Pedido.
 */
public interface PagamentoStrategy {

    /**
     * Processa o pagamento com a estratégia implementada
     * 
     * @param valor Valor a ser pago
     * @return true se o pagamento foi bem-sucedido
     */
    boolean processar(double valor);

    /**
     * Retorna o nome da estratégia de pagamento
     */
    String getNome();
}
