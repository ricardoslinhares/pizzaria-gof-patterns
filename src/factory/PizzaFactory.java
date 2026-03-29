package factory;

import model.Pizza;
import model.PizzaMozzarella;
import model.PizzaCalabresa;
import model.PizzaVegetariana;

/**
 * PizzaFactory - PADRÃO FACTORY PATTERN
 * 
 * Responsável por criar instâncias de pizzas baseado no tipo solicitado.
 * Isso encapsula a criação de objetos e facilita a manutenção futura.
 * 
 * Benefício: Se precisarmos mudar como uma pizza é criada, mudamos só aqui.
 */
public class PizzaFactory {

    /**
     * Método estático que cria a pizza apropriada baseado no tipo
     * 
     * @param tipo    Tipo de pizza: "mozzarella", "calabresa", "vegetariana"
     * @param tamanho Tamanho: "Pequena", "Média", "Grande"
     * @return Instância da pizza solicitada
     */
    public static Pizza criarPizza(String tipo, String tamanho) {
        tipo = tipo.toLowerCase();

        switch (tipo) {
            case "mozzarella":
                return new PizzaMozzarella(tamanho);

            case "calabresa":
                return new PizzaCalabresa(tamanho);

            case "vegetariana":
                return new PizzaVegetariana(tamanho);

            default:
                throw new IllegalArgumentException("Tipo de pizza inválido: " + tipo);
        }
    }
}
