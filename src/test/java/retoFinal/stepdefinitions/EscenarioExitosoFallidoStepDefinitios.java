package retoFinal.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import retoFinal.questions.Verificar;
import retoFinal.taks.Abrir;
import retoFinal.taks.Buscar;
import retoFinal.taks.BusquedaFallida;


public class EscenarioExitosoFallidoStepDefinitios {

    @Before
    public void iniciarEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

    //Primer escenario
    @Dado("^que Jhonatan ingresa a la tienda GW$")
    public void queJhonatanIngresaALaTiendaGW() {
        OnStage.theActorCalled("Jhonatan").wasAbleTo(Abrir.pagina());
    }

    @Cuando("^busca los productos GW$")
    public void buscaLosProductosGW() {
        OnStage.theActorInTheSpotlight().attemptsTo(Buscar.productos());
    }

    @Entonces("^verifica que se visualizen los productos buscados$")
    public void verificaQueSeVisualizenLosProductosBuscados() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Verificar.resultado(), Matchers.equalTo("Shorts Leisure")));
    }

    //segundo escenario
    @Dado("^que Jhonatan ingresa a la tienda GWBisicleta$")
    public void queJhonatanIngresaALaTiendaGWBisicleta() {
        OnStage.theActorCalled("Jhonatan").wasAbleTo(Abrir.pagina());
    }

    @Cuando("^busca los productos de la tienda GW$")
    public void buscaLosProductosDeLaTiendaGW() {
        OnStage.theActorInTheSpotlight().attemptsTo(BusquedaFallida.producto());
    }

    @Entonces("^verifica que no visualizen los productos buscados$")
    public void verificaQueNoVisualizenLosProductosBuscados() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Verificar.resultado(), Matchers.not("Shorts Leisure")));
    }





}
