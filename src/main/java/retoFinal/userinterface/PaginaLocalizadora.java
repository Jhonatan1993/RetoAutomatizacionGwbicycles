package retoFinal.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaLocalizadora {

    public static final Target LUPA = Target.the("BOTON BUSCAR").located(By.xpath("//a[contains(@href,'/search')]"));
    public static final Target CAMPOBUSCAR = Target.the("ELEMENTO A BUSCAR").located(By.xpath("//input[contains(@placeholder,'buscar en nuestra tienda')]"));
    public static final Target BUSCANDO = Target.the("BOTON DE CAJA DE TEXTO").located(By.xpath("//button[contains(@type,'submit')]"));
    public static final Target RESPUESTA = Target.the("MENSAJE DE RESPUESTA").located(By.xpath("//div[contains(@class,'grid-product__meta')]/div[@class='grid-product__title grid-product__title--heading']"));
}
