package projeto.correio.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		// Caminhos das features
		features = "src/test/resources/features",

		// Nome da package que estão os steps
		glue = "projeto.correio.steps",

		// Nags que serão executados
		tags = "@regressao",

		// Validar se está em planejamento ou execução
		dryRun = false,

		// Colorir o console
		monochrome = false,

		// Deixar o método no padrão Java
		snippets = SnippetType.CAMELCASE,

		// Pretty dormatar conselo padrão cucumber e html status repot html ou json
		plugin = { "pretty", "html:target/status-report.html" })


public class Executa {

}
