package model;

/**
 * Classe abstrata Pizza - parte do padrão Factory Pattern
 * Define a interface comum para todas as pizzas
 */
public abstract class Pizza {
    protected String nome;
    protected double preco;
    protected String tamanho;
    protected String descricao;
    
    /**
     * Método abstrato que deve ser implementado por cada tipo de pizza
     */
    public abstract void preparar();
    
    // Getters
    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public String getTamanho() {
        return tamanho;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - R$ %.2f (%s)", tamanho, nome, preco, descricao);
    }
}
