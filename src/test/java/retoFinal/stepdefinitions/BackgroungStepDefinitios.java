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
import retoFinal.taks.Buscar;
import retoFinal.taks.BusquedaFallida;

public class BackgroungStepDefinitios {

    @Before
    public void iniciarEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^Jhonatan ingresa a la pagina Gwbicycles$")
    public void jhonatanIngresaALaPaginaGwbicycles() throws Exception {
        OnStage.theActorCalled("Jhonatan").wasAbleTo(Abrir.pagina());
    }

    @Cuando("^busca los Shorts Leisure en la pagina Gwbicycles$")
    public void buscaLosShortsLeisureEnLaPaginaGwbicycles() throws Exception {
        OnStage.theActorInTheSpotlight().attemptsTo(Buscar.productos());
    }

    @Entonces("^verifica que se visualizen los (.*) buscadoss$")
    public void verificaQueSeVisualizenLosShortsLeisureBuscadoss(String producto) throws Exception {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Verificar.resultado(), Matchers.equalTo(producto)));
    }

    @Cuando("^busca los Shorts Leisure en la pagina Gw$")
    public void buscaLosShortsLeisureEnLaPaginaGw() throws Exception {
        OnStage.theActorInTheSpotlight().attemptsTo(BusquedaFallida.producto());
    }

    @Entonces("^verifica que no visualizen los (.*) buscado$")
    public void verificaQueNoVisualizenLosShortsLeisureBuscado(String producto) throws Exception {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Verificar.resultado(), Matchers.not(producto)));
    }

}

