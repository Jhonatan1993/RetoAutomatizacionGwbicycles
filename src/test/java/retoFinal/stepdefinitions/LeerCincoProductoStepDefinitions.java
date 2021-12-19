package retoFinal.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.junit.Before;
import retoFinal.questions.Verificar;
import retoFinal.taks.Abrir;
import retoFinal.tasks.BuscarProducto;


public class LeerCincoProductoStepDefinitions {
    @Before
    public void iniciarEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que me encuentro en la pagina de Gwbicycles$")
    public void queMeEncuentroEnLaPaginaDeGwbicycles() throws Exception {
        OnStage.theActorCalled("Jhonatan").wasAbleTo(Abrir.pagina());
    }

    @Cuando("^busque los (.*)$")
    public void busqueLosPro(String producto) throws Exception {

        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProducto.the(producto));
    }

    @Entonces("^podre ver los (.*) en pantalla$")
    public void podreVerLosNombresEnPantalla(String producto) throws Exception {

        //OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(RetoGwbicyclesData.get(0).getStrProducto())));
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Verificar.resultado(), Matchers.equalTo(producto)));
    }

}
