package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.LoginMap;
import utils.BaseUtils;

import java.util.HashMap;
import java.util.Map;

public class CategoriaSteps {
    Map<String, String> header = new HashMap<>();

    @Dado("que tenha um payload valido da API de Categoria")
    public void queTenhaUmPayloadDaAPIDeCategoria(){
        header.put("Authorization", "Bearer "+ LoginMap.token);

    }
    @Quando("realizo uma requisicao do tipo GET de Categoria")
    public void realizoUmaRequisicaoDoTipoGETDeCategoria(){
        BaseUtils.get(header,"categorias");

    }

    @E("que tenha um header com o campo {string} com valor {string}")
    public void queTenhaUmHeaderComOCampoComValor(String key, String value) {
        header.put(key, value);
    }
}
