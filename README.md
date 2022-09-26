# PUCPR - Atividade Somativa 2 de Fundamentos de Programação Orientada a Objetos

Seguimos a abordagem de implementar uma loja de jogos e eletrônicos, onde a mesma contém as seguintes entidades:

* Produto: Classe abstrata que implementa a interface Serializable e é utilizada para representar todos os tipos de produtos que a loja contém. Ela conta com atributos de ID, Nome, Descrição e Preço.
* Jogo: Classe que herda Produto e é utilizada para representar os Jogos disponíveis na loja. Conta com atributos de Desenvolvedora, Gênero do jogo e faixa etária mínima, além de todos os atributos da classe Produto.
* Eletrônico: Classe que herda Produto e é utilizada para representar os Eletrônicos disponíveis na loja (Consoles, Controles, etc.). Conta com atributos de Marca, Modelo e Condição (Novo, Seminovo ou Usado), além de todos os atributos da classe Produto.
* Assinatura: Classe que herda Produto e é utilizada para representar os Serviços de Assinatura disponíveis à venda na loja. Conta com atributos de Nome do Serviço, Quantidade de dias e código de ativação, além de todos os atributos da classe Produto.
