package modulo.produto;

import Pojo.ComponentePojo;
import Pojo.ProdutoPojo;
import Pojo.UsuarioPojo;
import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do Modulo de Produto ")
public class ProdutoTest {
    private String token;

    @BeforeEach
    public void beforeEach() {
        // Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        // port = 8080;
        basePath = "lojinha";

        // obter o token do usuario admin
        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(UsuarioDataFactory.criarUsuarioAdministrador())
        .when()
                .post("/v2/login")
        .then()
            .extract()
                .path("data.token");
        //System.out.println(token);
    }
    @Test
    @DisplayName("Validar que o valor do produto igual a 0.00 não e permitido")
    public void testValidarLimitesZeradoProibidoValorProduto() {
        // Tentar inserir um produto com valor o.oo e validar que a mensagem de erro foi apresentada e o
        // status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarprodutoComumValorigualA(0.00))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
    }

    @Test
    @DisplayName("Validar que o valor do produto igual a 7000.01 não e permitido")
    public void testValidarLimitesMaiorSeteMilProibidoValorProduto(){

        //System.out.println(token);
        // Tentar inserir um produto com valor o.oo e validar que a mensagem de erro foi apresentada e o
        // status code retornado foi 422
        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarprodutoComumValorigualA(7000.01))
            .when()
                .post("/v2/produtos")
            .then()
                .assertThat()
                    .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);


    }
}