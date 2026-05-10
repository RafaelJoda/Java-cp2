# Sistema de Logística para Entregas (E-commerce)

## 👥 Integrantes do Grupo


* **Integrantes:**
* Davi Alves dos Santos - RM: 566279
* Diego Zandonadi - RM: 561488
* Rafael Joda da Costa e Silva - RM: 561939
* Henrique de Lima Martins - RM: 561876
* Luis Miguel Gonçalves Pinto - RM: 561232



---

## 🛠️ Decisões de Modelagem

A modelagem foi pensada para permitir a escalabilidade do sistema, separando responsabilidades e garantindo que novos tipos de transporte possam ser adicionados com facilidade.

### 1. Herança e Classes Abstratas

Utilizamos a classe abstrata `Entregador` para reunir atributos comuns (nome, ID, capacidade) e métodos que todos os entregadores compartilham.

* 
**Classes Envolvidas:** `Entregador` (Base), `EntregadorMoto`, `EntregadorBicicleta` e `EntregadorCarro` (Subclasses).


* 
**Problema Resolvido:** Evita a duplicação de código e estabelece uma base rígida para que diferentes veículos tenham comportamentos específicos (como velocidades e custos distintos).



### 2. Interfaces

Implementamos a interface `Gerenciavel` (ou nome similar presente no código) para definir comportamentos de execução de entrega.

* 
**Vantagem:** Permite que diferentes entidades do sistema (não apenas entregadores, mas possivelmente empresas parceiras futuras) sigam um contrato padrão de execução de serviço, garantindo polimorfismo.



### 3. Polimorfismo (Sobrescrita e Sobrecarga)

* 
**Sobrescrita (@Override):** Cada tipo de entregador sobrescreve o método de cálculo de tempo ou custo, refletindo sua realidade logística (ex: uma bicicleta é mais lenta que um carro).


* 
**Sobrecarga:** O método de atualização de status foi sobrecarregado para permitir atualizar apenas o status simples ou atualizar o status acompanhado de uma observação/motivo.



---

## 🚀 Como Executar o Projeto

1. **Pré-requisitos:** Certifique-se de ter o Java JDK 17 ou superior instalado.
2. **Clonagem:** Clone o repositório:
```bash
git clone https://github.com/RafaelJoda/Java-cp2.git

```


3. **Compilação:** Navegue até a pasta do projeto e compile as classes:
```bash
javac src/*.java

```


4. **Execução:** Inicie o sistema através da classe `Main`:
```bash
java src.Main

```


5. 
**Interação:** Utilize o menu interativo no console para cadastrar entregadores, criar pedidos e gerenciar o fluxo de entregas.
