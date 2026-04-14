package screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static screenplay.ui.RegistroPage.*;

public class RegistrarseComo  implements Task {

    private final String firstName, lastName, email, phone, password;

    public RegistrarseComo(String firstName, String lastName, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public static RegistrarseComo conDatos(String firstName, String lastName, String email, String phone, String password) {
        return instrumented(RegistrarseComo.class, firstName, lastName, email, phone, password);
    }

    @Override
    @Step("{0} se registra con los datos de #firstName #lastName")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(INPUT_FIRSTNAME),
                Enter.theValue(lastName).into(INPUT_LASTNAME),
                Enter.theValue(email).into(INPUT_EMAIL),
                Enter.theValue(phone).into(INPUT_TELEPHONE),
                Enter.theValue(password).into(INPUT_PASSWORD),
                Enter.theValue(password).into(INPUT_CONFIRM)
        );
    }

}
