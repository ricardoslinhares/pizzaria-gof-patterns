# Apresentação - Sistema de Pizzaria

## Autoria

Este projeto é individual e referente à Atividade Processual 3 da disciplina Padrões de Projetos do curso de Análise e Desenvolvimento de Sistemas do IPOG.

## Resumo do Projeto

Desenvolvi um sistema de gerenciamento de pizzaria em Java que implementa 3 padrões de projeto GoF para demonstrar na prática como esses padrões funcionam.

## Padrões Implementados

### 1. Factory Pattern

**O que faz:**
Cria as pizzas de forma centralizada. Em vez de fazer `new PizzaCalabresa()` várias vezes, usamos a PizzaFactory que cria a pizza correta baseado no tipo.

**Benefício:**
Se precisar adicionar um novo tipo de pizza no futuro, só preciso adicionar uma nova classe e modificar a factory. O resto do código não precisa ser alterado.

**Desafio:**
No início pensei em fazer cada classe criar a si mesma, mas isso espalharia a lógica de criação em vários lugares. A factory centraliza tudo em um só lugar.

### 2. Strategy Pattern

**O que faz:**
Permite escolher qual forma de pagamento usar (débito, crédito ou dinheiro). A classe Pedido não precisa saber como cada forma funciona, só chama o método processar().

**Benefício:**
Se no futuro a empresa quiser aceitar PIX ou boleto, é só criar uma nova classe de pagamento sem mexer na classe Pedido.

**Desafio:**
A parte mais complicada foi entender que cada estratégia faz a mesma coisa (processar) mas de formas diferentes. Isso permite trocar uma estratégia por outra sem quebrar o código.

### 3. Observer Pattern

**O que faz:**
Notifica automaticamente o cliente e o garçom quando o status do pedido muda (Recebido → Preparando → Pronto → Entregue).

**Benefício:**
Se precisar notificar outros observadores (tipo o gerente ou a entrega), é só criar uma nova classe e registrá-la no pedido.

**Desafio:**
Entendi que o padrão desacopla quem muda (Pedido) de quem quer saber das mudanças (observadores). Eles não se conhecem, só se comunicam através da interface.

## Como o Sistema Funciona

1. Cria 3 pizzas diferentes usando Factory
2. Cria 3 pedidos com diferentes formas de pagamento usando Strategy
3. Registra observadores em um pedido
4. Muda o status do pedido várias vezes
5. Os observadores são notificados automaticamente cada vez

## O que Aprendemos

- Os padrões não são complicados se entender o problema que eles resolvem
- Factory centraliza criação
- Strategy permite trocar algoritmos
- Observer desacopla quem muda de quem quer saber
- Código fica mais fácil de manter e estender

## Conclusão

O projeto funcionou! Consegui implementar os 3 padrões de forma que fazem sentido no contexto de uma pizzaria. Cada padrão resolveu um problema real:

- Factory resolveu o problema de criar diferentes tipos de pizzas
- Strategy resolveu o problema de ter diferentes formas de pagamento
- Observer resolveu o problema de notificar múltiplos sistemas quando algo muda

No futuro, esses padrões vão facilitar quando precisar adicionar novos tipos de pizza, novas formas de pagamento ou novos observadores.
