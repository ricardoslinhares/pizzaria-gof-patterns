package model;

/**
 * Pizza Mozzarella - Implementação concreta do padrão Factory
 */
public class PizzaMozzarella extends Pizza {
    
    public PizzaMozzarella(String tamanho) {
        this.nome = "Pizza Mozzarella";
        this.tamanho = tamanho;
        this.descricao = "Queijo derretido com molho de tomate";
        
        // Preço varia por tamanho
        if ("Pequena".equals(tamanho)) {
            this.preco = 25.00;
        } else if ("Média".equals(tamanho)) {
            this.preco = 35.00;
        } else if ("Grande".equals(tamanho)) {
            this.preco = 45.00;
        }
    }
    
    @Override
    public void preparar() {
        System.out.println("Preparando pizza mozzarella... Espalhando queijo...");
    }
}
