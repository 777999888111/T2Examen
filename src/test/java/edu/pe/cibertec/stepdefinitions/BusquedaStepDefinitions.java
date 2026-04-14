package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.questions.ResultadosDeBusqueda;
import screenplay.tasks.BuscarProducto;
import screenplay.ui.BusquedaPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class BusquedaStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user is on the OpenCart home page")
    public void onHomePage() {
        theActorCalled("Juan").wasAbleTo(Open.url("https://naveenautomationlabs.com/opencart/"));
    }

    @When("the user searches for the product {string}")
    public void searchProduct(String producto) {
        theActorInTheSpotlight().attemptsTo(BuscarProducto.conNombre(producto));
    }

    @Then("the user should see at least one result with the name {string}")
    public void verifyResult(String expectedName) {
        theActorInTheSpotlight().should(
                seeThat(ResultadosDeBusqueda.mostrados(), hasItem(containsString(expectedName)))
        );
    }

    @Then("the user should see the message {string} for search")
    public void verifyNoResultsMessage(String expectedMessage) {
        theActorInTheSpotlight().should(
                seeThat(Text.of(BusquedaPage.MSJ_NO_RESULTADOS), containsString(expectedMessage))
        );
    }
}
