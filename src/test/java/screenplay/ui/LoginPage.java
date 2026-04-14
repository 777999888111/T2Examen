package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target INPUT_EMAIL = Target.the("campo email")
            .located(By.id("input-email"));
    public static final Target INPUT_PASSWORD = Target.the("campo password")
            .located(By.id("input-password"));
    public static final Target BTN_LOGIN = Target.the("botón login")
            .located(By.xpath("//input[@value='Login']"));
    public static final Target LBL_ERROR_MESSAGE = Target.the("mensaje de error de login")
            .located(By.cssSelector(".alert-danger"));
    public static final Target LBL_CONFIRMATION_HEADER = Target.the("encabezado de mi cuenta")
            .located(By.xpath("//h2[contains(text(),'My Account')]"));
}
