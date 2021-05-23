# Considerações Iniciais
Esse projeto está sendo desenvolvido com Spring Boot e Maven. Para rodá-lo, é necessário uma IDE que suporte ambas as tecnologias. As mais usadas para esse fim são IntelliJ e Eclipse. Com o ambiente configurado, basta baixar o projeto via git bash ou fazer o download do ZIP, descompactá-lo e importar para a IDE de sua preferência.

Após importar o projeto execute-o como um projeto Spring Boot.

Para facilitar a usabilidade e os testes, o banco de dados usado é o H2 e alguns dados foram inseridos. Para usar a API, você pode usar o Postman ou a interface do Swagger UI disponível em http://localhost:8080/swagger-ui.html (desde que o programa esteja sendo executado).

O banco de dados H2 está disponível em http://localhost:8080/h2-console. Cada vez que o programa é reiniciado, o banco apaga todos os dados que foram inseridos. Não foi colocado senha para acessar o banco, e o usuário é "sa" (sem as aspas).

## Endpoints
Há quatro endpoints no projeto e com eles podemos
* Fazer uma nova operação/câmbio de moedas
* Obter os dados de todas as operações feitas com sucesso
* Adicionar uma nova moeda ou sobrescrever uma já existente
* Criar um cliente no banco


### Fazer uma nova operação/câmbio de moedas
Para fazer uma operação de câmbio, é necessário que o usuário insira o Id do cliente que está efetuando essa operação, a moeda origem, a moeda de destino e o valor que o cliente quer converter. O valor de serviceBill (taxa de serviço) é opcional, se ele não for passado na requisição o padrão é 10%.

Essa é uma requisição POST feita no endpoint http://localhost:8080/operation/new e o valor convertido sempre terá um desconto do valor real, pois é cobrada uma taxa de serviço de 10% para cada operação. Essa requisição deve ser um JSON no formato mostrado logo abaixo

````
{
    "customer": {
        "id": 1
    },
    "currencyIn": "EUR",
    "currencyOut": "PLN",
    "originalPrice": 1000.00, 
    "serviceBill": 0.1
}
````

No Postman
![image](https://user-images.githubusercontent.com/38019738/119270979-cc015680-bbd5-11eb-912a-d8c03be2f296.png)
Tanto a moeda de entrada quanto a de saída devem seguir o padrão ISO 4217.

Para ver o valor guardado no Banco de Dados, acesse http://localhost:8080/h2-console e clique em Connect
![image](https://user-images.githubusercontent.com/38019738/119271111-75e0e300-bbd6-11eb-88a0-7e86d4eee755.png)


Depois de se conectar ao Banco De Dados H2, vá até TB_OPERATION do lado esquerdo da tela (1) e clique em Run (2)
![image](https://user-images.githubusercontent.com/38019738/119271386-aecd8780-bbd7-11eb-927f-8997d2adbb56.png)

Por fim, veja o resultado na tabela do banco de dados H2
![image](https://user-images.githubusercontent.com/38019738/119271502-3a471880-bbd8-11eb-875d-14c7bf328ceb.png)

A forma de visualizar no Banco de Dados as moedas que já estão cadastradas e os clientes já cadastrados é semelhante, a diferença é que temos que entrar em TB_CURRENCY se quisermos ver as moedas e suas cotações cadastradas e TB_CUSTOMER se quisermos ver os clientes cadastrados no banco.


### Obter os dados de todas as operações feitas com sucesso
Para visualizar todos os dados que estão gravados no banco, você pode acessar http://localhost:8080/operation/all através do navegador, do Postman (usando o método GET) ou ainda da interface grafica do Swagger UI.

### Adicionar uma nova moeda ou sobrescrever uma já existente
Para adicionar uma nova moeda ou sobrescrever uma já existente no banco uma requisição do tipo POST deve ser feita para http://localhost:8080/currency/new. Essa requisição deve ser um JSON no formato mostrado logo abaixo
````
{
  "name": "Dólar Canadense",
  "code": "CAD",
  "priceQuote": 4.45
}
````

### Adicionar um novo cliente ao banco
Para adicionar um novo cliente ao banco, uma requisição do tipo POST deve ser feita em http://localhost:8080/customer/new. Essa requisição deve ser um JSON no formato mostrado logo abaixo
````
{
  "name": "Algum Nome Legal"
}
````
