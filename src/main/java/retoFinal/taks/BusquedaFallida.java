package retoFinal.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import retoFinal.userinterface.PaginaLocalizadora;

public class BusquedaFallida implements Task {

    private PaginaLocalizadora paginaLocalizadora;

    public static BusquedaFallida producto() {
        return Tasks.instrumented(BusquedaFallida.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(paginaLocalizadora.LUPA),
                Enter.theValue("Camisilla Interior Spider").into(paginaLocalizadora.CAMPOBUSCAR),
                Click.on(paginaLocalizadora.BUSCANDO));actor.attemptsTo();
    }
}
