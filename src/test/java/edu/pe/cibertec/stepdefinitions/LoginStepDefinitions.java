package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.tasks.IniciarSesionComo;
import screenplay.ui.LoginPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user navigates to the login page")
    public void navigateToLogin() {
        theActorCalled("Ismael").wasAbleTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/login")
        );
    }

    @When("the user enters email {string} and password {string}")
    public void enterCredentials(String email, String pass) {
        theActorInTheSpotlight().attemptsTo(
                IniciarSesionComo.conCredenciales(email, pass)
        );
    }

    @And("clicks on the login button")
    public void clickLogin() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(LoginPage.BTN_LOGIN)
        );
    }

    @Then("the user should see the name {string} in the page header")
    public void verifyUserName(String name) {
        theActorInTheSpotlight().should(
                seeThat("El encabezado de la cuenta",
                        Text.of(LoginPage.LBL_CONFIRMATION_HEADER), containsString("My Account"))
        );
    }

    @Then("the user should see the login error message {string}")
    public void verifyLoginErrorMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat(Text.of(LoginPage.LBL_ERROR_MESSAGE), containsString(message)));
    }
}
