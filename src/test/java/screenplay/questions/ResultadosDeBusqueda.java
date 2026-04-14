package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import java.util.Collection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.ui.BusquedaPage;

public class ResultadosDeBusqueda implements Question<Collection<String>> {

    public static ResultadosDeBusqueda mostrados() {
        return new ResultadosDeBusqueda();
    }

    @Override
    public Collection<String> answeredBy(Actor actor) {
        return Text.ofEach(BusquedaPage.RESULTADOS).answeredBy(actor);
    }
}
