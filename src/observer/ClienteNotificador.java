package observer;

/**
 * ClienteNotificador - Implementação concreta do padrão Observer
 * Observa mudanças de status do pedido para notificar o cliente
 */
public class ClienteNotificador implements PedidoObserver {

    @Override
    public void atualizar(int numeroPedido, String statusAnterior, String statusNovo) {
        System.out.println("📱 [CLIENTE NOTIFICADO]");
        System.out.println("   Pedido #" + numeroPedido);
        System.out.println("   Status: " + statusAnterior + " → " + statusNovo);
        System.out.println("   Você recebeu uma mensagem SMS/Email!");
    }
}
