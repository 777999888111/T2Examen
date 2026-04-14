package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroPage {

    public static final Target INPUT_FIRSTNAME = Target.the("campo nombre")
            .located(By.id("input-firstname"));
    public static final Target INPUT_LASTNAME = Target.the("campo apellido")
            .located(By.id("input-lastname"));
    public static final Target INPUT_EMAIL = Target.the("campo email")
            .located(By.id("input-email"));
    public static final Target INPUT_TELEPHONE = Target.the("campo teléfono")
            .located(By.id("input-telephone"));
    public static final Target INPUT_PASSWORD = Target.the("campo password")
            .located(By.id("input-password"));
    public static final Target INPUT_CONFIRM = Target.the("campo confirmar password")
            .located(By.id("input-confirm"));
    public static final Target CHECK_PRIVACY = Target.the("checkbox política de privacidad")
            .located(By.name("agree"));
    public static final Target BTN_CONTINUE = Target.the("botón continuar")
            .located(By.xpath("//input[@value='Continue']"));
    public static final Target LBL_SUCCESS_TITLE = Target.the("título de cuenta creada")
            .located(By.cssSelector("#content h1"));
}
