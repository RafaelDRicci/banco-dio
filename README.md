# Banco Digital

Projeto desenvolvido para o desafio de projeto  [Criando um Banco Digital com Java e Orientação a Objetos](https://web.dio.me/lab/criando-um-banco-digital-com-java-e-orientacao-objetos/learning/1f5144ac-ae5d-4a25-a8cd-dd36cdbd0809).

O projeto trata-se de um exercício de Java e Orientação a Objetos, no qual foi desenvolvido um Banco Digital. Foi mapeado Interface e Classes para representar dois tipos de conta (Corrente e Poupança). Além de uma classe Cliente e Banco. 

Como foi sugerido durante as Vídeo Aulas do projeto, foi acrescentado o Lombok no projeto e utilizado conforme julgado necessário. 

Também foram criados funcionalidades para a classe conta, além das demonstradas durante as aulas.

## Funcionalidades Extras

* A ideia para melhorar o projeto, foi desenvolver a classe Banco de forma que os clientes não interagissem diretamente com as contas. 

* O Banco seria uma forma mais segura e indireta para os clientes utilizarem suas contas, simulando uma aplicação web ou mobile de um banco digital real. 

* Todos os métodos das Contas estão presentes em Banco, em que é necessário informa a agência e o número da conta para realizar determinadas funcionalidades.

  * Depositar -> agência e número como parâmetro
  * Sacar -> agência, número e id do cliente dono da conta
  * Transferir -> conta para transferência, agência, número e id do cliente dono da conta
  * Informações da conta -> agência e número como parâmetro

* Além desses métodos, foi implementado a funcionalidade de exibir todas as contas e todos os clientes

* Também foram criadas 3 Exception para:

  * Conta não encontrada, a partir da agência e número
  * Saldo insuficiente, no caso das operações sacar e transferir
  * Conta não pertence ao cliente, no caso de uma conta existir mas não seja do cliente

  
