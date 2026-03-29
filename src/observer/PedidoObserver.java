package observer;

/**
 * PedidoObserver - Interface do PADRÃO OBSERVER PATTERN
 * 
 * Define o contrato que todos os observadores de pedidos devem seguir.
 * Permite notificar múltiplos observadores quando o status de um pedido muda.
 * 
 * Benefício: Desacopla a classe Pedido dos observadores. Novos observadores
 * podem ser adicionados sem modificar a classe Pedido.
 */
public interface PedidoObserver {

    /**
     * Chamado quando o status do pedido muda
     * 
     * @param numeroPedido   Número do pedido
     * @param statusAnterior Status anterior
     * @param statusNovo     Status novo
     */
    void atualizar(int numeroPedido, String statusAnterior, String statusNovo);
}
