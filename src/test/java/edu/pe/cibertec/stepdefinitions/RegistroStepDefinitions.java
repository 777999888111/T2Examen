package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.tasks.RegistrarseComo;
import screenplay.ui.RegistroPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class RegistroStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user navigates to the register page")
    public void navigatesToRegisterPage() {
        theActorCalled("Ismael").wasAbleTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void fillsForm(String fname, String lname, String email, String phone, String pass) {
        theActorInTheSpotlight().attemptsTo(
                RegistrarseComo.conDatos(fname, lname, email, phone, pass)
        );
    }

    @And("accepts the privacy policy")
    public void acceptsPrivacy() {
        theActorInTheSpotlight().attemptsTo(Click.on(RegistroPage.CHECK_PRIVACY));
    }

    @And("clicks on continue")
    public void clicksContinue() {
        theActorInTheSpotlight().attemptsTo(Click.on(RegistroPage.BTN_CONTINUE));
    }

    @Then("the user should see the registration success message {string}")
    public void verifyRegistrationMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat(Text.of(RegistroPage.LBL_SUCCESS_TITLE), equalTo(message)));
    }
}
