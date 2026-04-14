package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaPage {

    public static final Target INPUT_BUSQUEDA = Target.the("barra de búsqueda")
            .located(By.name("search"));
    public static final Target RESULTADOS = Target.the("nombres de productos encontrados")
            .located(By.cssSelector("h4 a"));
    public static final Target MSJ_NO_RESULTADOS = Target.the("mensaje de no resultados")
            .located(By.xpath("//p[contains(text(),'There is no product')]"));
}
