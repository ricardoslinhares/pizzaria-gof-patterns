package model;

/**
 * Pizza Vegetariana - Implementação concreta do padrão Factory
 */
public class PizzaVegetariana extends Pizza {

    public PizzaVegetariana(String tamanho) {
        this.nome = "Pizza Vegetariana";
        this.tamanho = tamanho;
        this.descricao = "Brócolis, pimentão, cebola e tomate";

        if ("Pequena".equals(tamanho)) {
            this.preco = 28.00;
        } else if ("Média".equals(tamanho)) {
            this.preco = 38.00;
        } else if ("Grande".equals(tamanho)) {
            this.preco = 48.00;
        }
    }

    @Override
    public void preparar() {
        System.out.println("Preparando pizza vegetariana... Cortando os vegetais...");
    }
}
