# Code Challenge

## Instruções para rodar o projeto
1. Acesse a pasta docker-compose e rode o seguinte comando para subir os containers necessários: <b>docker-compose up -d</b>
2. Instale o jdk correspondente </br>
  <b> a. Windows:</b> </i> </br>
     --> Faça o download do <a href="https://www.oracle.com/br/java/technologies/downloads/">Java 17</a> </br>
     --> Adicione o java nas variaveis de ambiente do sistema. Adicione JAVA_HOME e o caminho do java instalado. </br>
  <b> b. Linux and Mac: </b> </br>
    --> Use o sdkman para adicionar o jdk de forma totalmente automatica </br>
3. Para iniciar o projeto rode os seguintes comandos: <b>./gradlew build ./gradlew bootRun</b>
4. O projeto irá subir na porta 8080, sendo assim o acesso as endpoints deve ser nessa porta, exemplo: <b>http://localhost:8080</b>
5. Existe somente uma endpoint que é para a criação do seguro: <b>POST /v1/seguros<b/> </br>
```bash
  curl --location --request POST 'http://localhost:8080/v1/seguros' \
  --header 'Content-Type: application/json' \
  --data-raw '{
    "nome": "Seguro Vida",
    "categoria" : "AUTO",
    "preco_base": 45.76
  }'
```

## Decisões tomadas para o projeto

1. Rest </br>
--> Para design rest, utilizei o <a href="https://en.wikipedia.org/wiki/Richardson_Maturity_Model">modelo</a> de Richardson, usando somente o nível 2, pois é um projeto simples
2. Validação do request body </br>
--> Usei o @Valid e Jakarta para validar se campos forem nulos, vazios e ou zerados, isso não foi mencionado no enunciado, mas decidi colocar para manter a consistências dos dados de entrada
3. Banco de dados </br>
--> Optei pro SQL Server por ser um banco de dados que me familiarizo mais, porém poderia ser algum banco NoSQL dependendo do contexto da aplicaçao, como é uma aplicação simples, uma tabela ia atender perfeitamente
4. Cálculo de tarifa </br>
--> Utilizei o padrão de projeto strategy para o cálculo das tarifas, como são muitos calculos diferentes num mesmo segmento esse padrão atende e se surgir mais um tipo de cálculo a extensão é aplicada ao invés da modificação, respeitando o principio OCP do solid
5. Testes </br>
--> JUNIT 5 para testes e SpringBootTest para teste de integração, Teste de integração funcionaria também com TestContainers, porém como temos somente um ponto de integração externa que é o banco de dados, optei por algo mais simples, mas que também resolveria a cobertura e testabilidade
--> Jacoco para o report de cobertura de testes
