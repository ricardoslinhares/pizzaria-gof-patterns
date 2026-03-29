# Sistema de Gerenciamento de Pizzaria

Aplicação Java que implementa 3 padrões de projeto GoF.

Padrões:
- Factory Pattern - para criar diferentes tipos de pizzas
- Strategy Pattern - para diferentes formas de pagamento  
- Observer Pattern - para notificar observadores sobre mudanças de status

## 1. Factory Pattern

Localização: `src/factory/PizzaFactory.java`

Como utilizar:
```java
Pizza pizza = PizzaFactory.criarPizza("calabresa", "Grande");
```

O padrão Factory centraliza a criação de pizzas. Em vez de criar diretamente com `new PizzaCalabresa()`, usamos a factory que retorna a pizza correta baseada no tipo.

Tipos de pizza suportados:
- Mozzarella
- Calabresa
- Vegetariana

## 2. Strategy Pattern

Localização: `src/payment/PagamentoStrategy.java`

Como utilizar:
```java
Pedido pedido = new Pedido(pizza);
pedido.setPagamento(new PagamentoCredito());
pedido.procesarPagamento();
```

O padrão Strategy permite escolher qual forma de pagamento será usada. A classe Pedido não precisa saber como cada pagamento funciona, apenas chama o método processar().

Formas de pagamento:
- Débito
- Crédito
- Dinheiro

## 3. Observer Pattern

Localização: `src/observer/PedidoObserver.java`

Como utilizar:
```java
Pedido pedido = new Pedido(pizza);
pedido.adicionarObservador(new ClienteNotificador());
pedido.adicionarObservador(new GarcomNotificador());
pedido.mudarStatus("Preparando");
```

O padrão Observer notifica automaticamente todos os observadores quando o status do pedido muda. 

Observadores implementados:
- ClienteNotificador - notifica o cliente
- GarcomNotificador - notifica a cozinha/garçom

## Estrutura

```
src/
├── model/         - classes de modelo (Pizza, Pedido)
├── factory/       - Factory Pattern
├── payment/       - Strategy Pattern  
├── observer/      - Observer Pattern
└── main/          - programa principal
```

## Como Compilar e Executar

```bash
# Compilar
javac -d bin src/model/*.java src/factory/*.java src/payment/*.java src/observer/*.java src/main/*.java

# Executar
java -cp bin main.Main
```

## O que o Programa Faz

1. Cria 3 pizzas diferentes usando Factory Pattern
2. Processa pagamento usando Strategy Pattern (3 formas diferentes)
3. Demonstra Observer Pattern com mudanças de status

O programa imprime na tela toda essa sequência para demonstrar os padrões funcionando.
