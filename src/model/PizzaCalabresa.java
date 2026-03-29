package model;

/**
 * Pizza Calabresa - Implementação concreta do padrão Factory
 */
public class PizzaCalabresa extends Pizza {

    public PizzaCalabresa(String tamanho) {
        this.nome = "Pizza Calabresa";
        this.tamanho = tamanho;
        this.descricao = "Calabresa com cebola e queijo";

        if ("Pequena".equals(tamanho)) {
            this.preco = 30.00;
        } else if ("Média".equals(tamanho)) {
            this.preco = 40.00;
        } else if ("Grande".equals(tamanho)) {
            this.preco = 50.00;
        }
    }

    @Override
    public void preparar() {
        System.out.println("Preparando pizza calabresa... Colocando calabresa e cebola...");
    }
}
