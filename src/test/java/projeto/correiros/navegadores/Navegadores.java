package projeto.correiros.navegadores;

import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import projeto.correio.drivers.DriversDeConexoes;

public class Navegadores extends DriversDeConexoes{

	@BeforeAll
	public static void iniciarTeste() {
		String ambiente = "https://www.correios.com.br/";
		WebDriverManager.edgedriver().setup();
		driver  = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(ambiente);
	}
	
	
	public static void finalizarTeste() {
		driver.quit();
	}
}
