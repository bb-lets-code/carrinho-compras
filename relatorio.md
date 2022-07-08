#  Relatório

O projeto contém funcionalidades de um e-commerce, possuindo as Classes de Client (PersonPF ou PersonPJ), Product, Cart, Order, Purchase, Cards e Address.
Dessa forma, foram feitas as funcionalidades de adicionar, remover, atualizar e visualizar produtos do carrinho, cadastro de cliente, realização de pedido, podendo escolher
formas de pagamento e, por fim, a realização da compra.

Para as funcionalidades do carrinho foram utilizados alguns padrões de projeto, como: 

* Observer - todas as vezes que for adicionado ou removido ou atualizado um produto no carrinho, o service de recalcular o total é notificado. 
* Singleton - para as classes de calcular taxas, frete e promoção, databases.
* 1º príncipio SOLID (Single responsibility principle) - Para todas as classes de calcular taxas, frete e promoção. Dessa forma, separa as responsabilidades
de cada uma delas.


Para a adição de produtos por meio da memória foi modelado o padrão de projeto Factory Method para que o usuário possa ter opção de
carregar produtos na aplicação de origens diferentes utilizando o arquivo confi.propeties onde a chave "origemDadosProducts" deve preenchida com o tupo de armazenamento que será utilizado pelo software.

Foi criado o repository que permite a manipulação dos dados (CRUD) de Client, Product e Purchase na memória.

Para a criação da Order foram utilizados os padrões de projeto Builder e Template Method, com o objetivo de garantir que a Order será criada com uma ordem estabelecida.

Além disso, criou-se um verificador de dados para os clientes que segue o padrão Chain of Responsability. No momento, apenas é verificado se o CPF e CNPJ possuem o número correto de dígitos, mas caso sejam necessárias outras verificações elas podem ser facilmente adicionadas. Nesse caso, cada validação é aplicada ao cliente, uma de cada vez.
