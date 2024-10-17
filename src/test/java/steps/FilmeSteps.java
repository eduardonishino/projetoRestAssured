package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import maps.FilmesMaps;
import utils.BaseUtils;

import java.util.HashMap;
import java.util.Map;

public class FilmeSteps {

    @Dado("que tenha um payload valido da API de Filme")
    public void queTenhaUmPayloadValidoDaAPIDeFilme(){
        FilmesMaps.initAll();
    }

    @Quando("realizo uma requisicao do tipo POST de Filme")
    public void realizoUmaRequisicaoDoTipoPOSTDeFilme(){
        BaseUtils.post(FilmesMaps.getHeader(), FilmesMaps.getFilmes(), ContentType.JSON, "filmes");
    }

    @Entao("armazeno o id que recebo do response de Filme")
    public void armazenoOIdQueReceboDoResponseDeFilme(){
        FilmesMaps.id = BaseUtils.getResponse().jsonPath().get("id");

    }

    @Quando("realizo uma requisicao do tipo GET de Filme atraves do nome")
    public void realizoUmaRequisicaoDoTipoGETDeFilmeAtravesDoNome() {
        Map<String, Object> param = new HashMap<>();
        String nome = FilmesMaps.getFilmes().get("nome").toString();
        param.put("nome",nome);

        BaseUtils.get(FilmesMaps.getHeader(),param,"filmes");
    }

    @E("altero o indice {int} da lista de categoria de filem com os valores")
    public void alteroOIndiceDaListaDeCategoriaDeFilemComOsValores(int indice, Map<String, String> map) {
        FilmesMaps.getListCategoria().get(indice).putAll(map);
    }

    @Quando("realizo uma requisicao do tipo PUT de Filme")
    public void realizoUmaRequisicaoDoTipoPUTDeFilme() {
        BaseUtils.put(FilmesMaps.getHeader(), FilmesMaps.getFilmes(),
                ContentType.JSON, "filmes/" + FilmesMaps.id);
    }

    @Quando("realizo uma requisicao do tipo DELETE de Filme")
    public void realizoUmaRequisicaoDoTipoDELETEDeFilme() {
        BaseUtils.delete(FilmesMaps.getHeader(), FilmesMaps.getFilmes(),"filmes/" + FilmesMaps.id);
    }
}
