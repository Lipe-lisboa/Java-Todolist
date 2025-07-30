# Banco de dados para ser usado nos teste

## 
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>**

## spring.datasource.url=jdbc:h2:mem:testdb


# Abilitar o WebCliente

##
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
        <scope>test</scope>
    </dependency>**


## swagger
Contratos de API (controladores, endpoints), e gera uma interface para visualizar tudo isso
##
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.6.0</version>
    </dependency>

http://localhost:8080/swagger-ui/index.html
