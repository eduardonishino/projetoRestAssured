package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import utils.BaseUtils;

import java.util.ArrayList;
import java.util.List;

public class GenericSteps {

    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status){
        Assert.assertEquals(status, BaseUtils.getResponse().getStatusCode());

    }

    @Entao("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String key, String value){
        Assert.assertEquals(value,BaseUtils.getResponse().jsonPath().get(key));
    }

    @E("valido que recebo uma lista vazia no response")
    public void validoQueReceboUmaListaVaziaNoResponse() {
        Assert.assertEquals(new ArrayList<>(0), BaseUtils.getResponse().jsonPath().get());
    }
}
