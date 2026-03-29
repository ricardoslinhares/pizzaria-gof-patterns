package observer;

/**
 * GarcomNotificador - Implementação concreta do padrão Observer
 * Observa mudanças de status do pedido para notificar o garçom/cozinha
 */
public class GarcomNotificador implements PedidoObserver {

    @Override
    public void atualizar(int numeroPedido, String statusAnterior, String statusNovo) {
        System.out.println("👨‍🍳 [COZINHA/GARÇOM NOTIFICADO]");
        System.out.println("   Pedido #" + numeroPedido);
        System.out.println("   Status: " + statusAnterior + " → " + statusNovo);

        if ("Preparando".equals(statusNovo)) {
            System.out.println("   AÇÃO: Começar a preparar a pizza!");
        } else if ("Pronto".equals(statusNovo)) {
            System.out.println("   AÇÃO: Pizza pronta! Chamar garçom para servir!");
        } else if ("Entregue".equals(statusNovo)) {
            System.out.println("   AÇÃO: Pedido entregue ao cliente!");
        }
    }
}
