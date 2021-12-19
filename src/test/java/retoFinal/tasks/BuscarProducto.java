package retoFinal.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import retoFinal.userinterface.PaginaLocalizadora;

public class BuscarProducto implements Task{

    private String strProducto;

    public BuscarProducto(String strProducto) {
        this.strProducto = strProducto;
    }

    public static BuscarProducto the(String strProducto) {
        return Tasks.instrumented(BuscarProducto.class, strProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(PaginaLocalizadora.LUPA),
                Enter.theValue(strProducto).into(PaginaLocalizadora.CAMPOBUSCAR),
                Click.on(PaginaLocalizadora.BUSCANDO));

    }
}
