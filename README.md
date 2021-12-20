# RetoFinalAutomatizacionGwbicycles con Screenplay
El siguiente reto consiste en realizar la automatización con el patron Screenplay de la pagina web https://gwbicycles.com/, la cual debe realizar los siguientes puntos:
> - Buscar los 5 productos no desde el excel sino desde el feature con examples
> - Utilizar un Background para realizar como mínimo 2 escenarios.
> - Realizar un escenario fallido y uno exitoso sin examples.

## Conceptos tecnicos
> ### Selenium
>Es una herramienta de código abierto para la automatización de pruebas,de navegadores web, Selenium nos proporciona una herramienta con la cual podremos grabar y/o reproducir, editar y depurar casos de prueba, con la cual nos permitirá ejecutar las pruebas repetidamente las veces que sean necesarias. 
> >Ref: (https://inmediatum.com/blog/piensa-digital/que-es-selenium-y-para-que-sirve/).
> ### Selenium Webdriver
> Selenium Webdriver es el sucesor de Selenium RC, por lo cual es una herramienta que permite automatizar pruebas UI (User Interface) o Interfaz de usuario de aplicaciones Web pero se basa en un enfoque más moderno y estable que la versión de Selenium RC, por lo que Webdriver a diferencia de RC no utiliza middleware sino controla el navegador comunicándose directamente con él.
> >Ref: (https://inmediatum.com/blog/piensa-digital/que-es-selenium-y-para-que-sirve/).
> ### Cucumber
> Cucumber es una herramienta para implementar metodologías como el Behaviour Driven Development (BDD) o desarrollo basado en comportamiento, que permite ejecutar descripciones funcionales en texto plano como pruebas de software automatizadas.
Estas descripciones funcionales se escriben en un lenguaje específico de dominio, legible por el área de negocio, denominado Gherkin, que soporta más de 60 idiomas. Gherkin sirve simultáneamente como documentación de apoyo al desarrollo y a las pruebas automatizadas.
> >Ref: (https://www.pragma.com.co/blog/junit-vs.-cucumber-herramientas-de-automatizacion-de-pruebas)
> ### Gherkin
> El lenguaje Gherkin define la estructura y una sintaxis básica para la descripción de las pruebas que pueden ser entendidas tanto por los integrantes técnicos del equipo como así también por los Analistas/PO o quien quiera que este como representante del cliente. De esta manera mientras se generan pruebas se esta generando documentación viva que describe perfectamente como se comporta el sistema enriqueciendo y manteniendo la documentación.
> >Ref: (https://josepablosarco.wordpress.com/2015/03/11/lenguaje-gherkin/)
> ### Screenplay
> El patrón de screenplay tiene un enfoque de desarrollo encaminado por comportamiento Behaviour Driven Development (BDD). Esta no es una herramienta para testing sino una estrategia de desarrollo que se enfoca en prevenir defectos en lugar de encontrarlos en un ambiente controlado, tal y como se explica en el artículo BDD para la automatización de pruebas
> >Ref: (https://www.pragma.com.co/academia/lecciones/conceptos-basicos-para-una-ejecucion-en-screenplay)

> ### 
>
> >Ref: ()
## IntelliJ, IDE ultilizado para el desarrollo
`IntelliJ IDEA es un IDE inteligente y sensible al contexto para trabajar con Java y otros lenguajes JVM como Kotlin, Scala y Groovy en todo tipo de aplicaciones. Además, IntelliJ IDEA Ultimate puede ayudarle a desarrollar aplicaciones web de pila completa, gracias a sus potentes herramientas integradas, compatibilidad con JavaScript y tecnologías relacionadas, y compatibilidad avanzada con marcos de trabajo populares como Spring, Spring Boot, Jakarta EE, Micronaut, Quarkus y Helidon. Además, puede ampliar IntelliJ IDEA con complementos gratuitos desarrollados por JetBrains, lo que le permite trabajar con otros lenguajes de programación, como Go, Python, SQL, Ruby o PHP.`
> Ref: (https://www.jetbrains.com/es-es/idea/)

### Estructura del Proyecto

> El proyecto esta estructurado de la sigueinte manera: 
```java
+ gradle
+ idea
+ build
+ gradle
- history
-- src
--- main
----- java
------ RetoFinal 
    ------+ exceptions
    ------+ interactions
    ------+ model
    ------+ questions
    ------+ tasks
    ------+ userinterface
    ------+ util
    ---- resourse
--- test
------ java
------ RetoFinal 
    -------+ runners
    -------+ stepdefinitions
    -------+ tasks
------ resourse
-------+ driver
-------+ features
+ target
```
> Trabajar en términos de páginas no es muy bueno, y quienes dicen lo anterior son los mismos que le dieron
origen a POM ya que este surgió porque anteriormente las personas codificaban en modo Espagueti con
Selenium, entonces ellos mismos vieron que al analizar este modelo a las luz de la aplicación de los Pilares
y los Principios para que estos pilares se cumplan, se dieron cuenta que no se estaba haciendo y fue allí
cuando surge ScreenPlay, donde básicamente encontramos que es una evolución del modelo POM que
cambia de paradigma un poco. Este modelo lo vamos a trabajar con el conjunto de librerías de
SerenityBDD. Las capas de la arquitectura son:

### 1.    Taks: son un grupo de interacciones (Acciones de Alto Nivel).
> -    - Acciones de Alto Nivel: Una acción de Alto nivel se caracteriza porque no habla entérminos de clic o select, es simplemente un verbo amplio. Ejm: Login, Comprar, Buscar.Etc.
```java
package retoFinal.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import retoFinal.userinterface.PaginaUrl;

public class Abrir implements Task {

    private PaginaUrl paginaUrl;
    public static Abrir pagina() {
        return Tasks.instrumented(Abrir.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(paginaUrl));
    }
}

```
```java
package retoFinal.taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import retoFinal.userinterface.PaginaLocalizadora;

public class Buscar implements Task {

    private PaginaLocalizadora paginaLocalizadora;

    public static Buscar productos() {
        return Tasks.instrumented(Buscar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(paginaLocalizadora.LUPA),
                Enter.theValue("Shorts Leisure").into(paginaLocalizadora.CAMPOBUSCAR),
                Click.on(paginaLocalizadora.BUSCANDO));
    }

}
```
```java
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
```
### 2.  Questions: son lo assert a llevar a cabo para asegurar el cumplimiento de ciertos parámetros.

```java
package retoFinal.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import retoFinal.userinterface.PaginaLocalizadora;

public class Verificar implements Question {

    public static Verificar resultado() {return new Verificar();}

    @Override
    public Object answeredBy(Actor actor) {

        String texto = Text.of(PaginaLocalizadora.RESPUESTA).viewedBy(actor).asString();
        String[] s = texto.split(" ");
        String output ="";

        for (String word : s){
            String temp="";
            for (int i=0; i<word.length(); i++){
                if (i==0){
                    temp+=(word.charAt(i)+"").toUpperCase();
                }else {
                    temp+=(word.charAt(i)+"").toLowerCase();
                }
            }
            output+=temp+" ";
        }
        System.out.println(output);

        return output.trim();
    }
}

```
### 3. User Interface: las UI son el mapeo de la interfaz, donde capturaremos todos los elementos con los cuales podríamos llegar a interactuar durante la automatización. Además, se le puede añadir la URL donde se iniciará la prueba.


```java
package retoFinal.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://gwbicycles.com/")
public class PaginaUrl extends PageObject {
}
```
```java
package retoFinal.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaLocalizadora {

    public static final Target LUPA = Target.the("BOTON BUSCAR").located(By.xpath("//a[contains(@href,'/search')]"));
    public static final Target CAMPOBUSCAR = Target.the("ELEMENTO A BUSCAR").located(By.xpath("//input[contains(@placeholder,'buscar en nuestra tienda')]"));
    public static final Target BUSCANDO = Target.the("BOTON DE CAJA DE TEXTO").located(By.xpath("//button[contains(@type,'submit')]"));
    public static final Target RESPUESTA = Target.the("MENSAJE DE RESPUESTA").located(By.xpath("//div[contains(@class,'grid-product__meta')]/div[@class='grid-product__title grid-product__title--heading']"));
}
```

### 4. Capa Model: Colocamos objetos de negocio (Clase Persona, Clase Tarjeta de Crédito,
Clase Transacción, es decir, debemos crear objetos o entes, hagamos abstracción y no
estemos creando Métodos con 6 o más parámetros ya que es preferible.
```java
package retoFinal.model;

public class RetoGwbicyclesData {

    private String strProducto;

    public String getStrProducto() { return strProducto; }

    public void setStrProducto(String strProducto) { this.strProducto = strProducto; }
    
}
```
### 5. Runners: es el ejecutor de los features, tags, glue (donde se encuentra el step definition)

```java
package retoFinal.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions (
        features = "src/test/resources/features",
        tags = "@HU",
        glue = "retoFinal.stepdefinitions",
        snippets = SnippetType.CAMELCASE )

public class RunnerTags {

}
```

### 4. StepDefinitions: los Step Definitions son la traducción de los features a código. Los métodos que se utilizaran son los features (historias de usuario),
por lo tanto, iremos a la clase “RunnerTags”, le daremos clic derecho sobre ésta, y en la opción “Run as” escogemos “JUnit Test”.
```java
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
```

```java
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

```

```java
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
```

### 6. Features: los features son las historias de usuario que se llevarán a cabo en las pruebas y proveerá los métodos que utilizaremos más adelante para los StepDefinitions.
```java
#language:es
#Autor: Jhonatan Paternina Rojas

@HU
Característica: HU-001 Buscar productos en gwbicycles
  yo como usuario de gwbicycles
  quiero buscar cinco productos para ver los nombres en pantalla

  @scenario1
  Esquema del escenario: Buscar productos
    Dado que me encuentro en la pagina de Gwbicycles
    Cuando busque los <strProducto>
    Entonces podre ver los <strProducto> en pantalla
    Ejemplos:
      | strProducto |
      | Shorts Leisure                        |
      | Camisilla Interior Spider             |
      | Pantaloneta Plug Sport Sin Cargaderas |
      | Medias Colombia                       |
      | Chaqueta Camo Reflective              |
```

```java
#language: es
#Autor: Jhonatan Paternina

@HU
Característica: Verificar los productos de la tienda GW
  Como Usuario Quiero ver los productos Para colocarselos a mi bicicleta

  Antecedentes:
    Dado Jhonatan ingresa a la pagina Gwbicycles

  @caso1
  Esquema del escenario: visualiza los productos exitosamente
    Cuando busca los <strProducto> en la pagina Gwbicycles
    Entonces verifica que se visualizen los <strProducto> buscadoss
    Ejemplos:
      | strProducto    |
      | Shorts Leisure |

  @caso2
  Esquema del escenario: visualiza los productos de manera fallida
    Cuando busca los <strProducto> en la pagina Gw
    Entonces verifica que no visualizen los <strProducto> buscado
    Ejemplos:
      | strProducto    |
      | Shorts Leisure |
```
```java
#language: es
#Autor: Jhonatan Paternina
@HU
Característica: Verificar los productos de la tienda GW
  Como Usuario Quiero ver los productos Para colocarselos a mi bicicleta

  @caso1
  Escenario: visualiza los productos exitosamente
    Dado que Jhonatan ingresa a la tienda GW
    Cuando busca los productos GW
    Entonces verifica que se visualizen los productos buscados


  @caso2
  Escenario: visualiza los productos de manera fallida
    Dado que Jhonatan ingresa a la tienda GWBisicleta
    Cuando busca los productos de la tienda GW
    Entonces verifica que no visualizen los productos buscados
```
