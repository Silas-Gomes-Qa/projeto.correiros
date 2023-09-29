package projeto.correio.metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import projeto.correio.drivers.DriversDeConexoes;

public class MetodosDeTestes extends DriversDeConexoes {

	/**
	 * Método responsável por escrever em um elemento Web.
	 * 
	 * @param elemento
	 * @param texto
	 * @param passo
	 * @author Silas Gomes
	 */
	public void escrever(By elemento, String texto, String passo) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.err.println("Erro no passo " + passo);
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}
	}

	/**
	 * Métdo responsável por clicar em um elemento Web.
	 * 
	 * @param elemento
	 * @param passo
	 * @author Silas Gomes
	 */
	public void clicar(By elemento, String passo) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.err.println("Erro no passo " + passo);
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}

	}

	/**
	 * Métdo responsável por validar um texto de elemento Web.
	 * 
	 * @param elemento
	 * @param passo
	 * @author Silas Gomes
	 */
	public void validarTexto(By elemento, String textoEsperado, String passo) {
		try {
			String textoCapturado = driver.findElement(elemento).getText();
			assertEquals(textoEsperado, textoCapturado);
		} catch (Exception e) {
			System.err.println("Erro no passo " + passo);
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}
	}

	/**
	 * Método responsável por validar url
	 * 
	 * @param urlEsperada
	 * @param passo
	 * @author Silas Gomes
	 */
	public void validarUrl(String urlEsperada, String passo) {
		try {
			String urlEncontrada = driver.getCurrentUrl();
			assertEquals(urlEsperada, urlEncontrada);
		} catch (Exception e) {
			System.err.println("Erro no passo " + passo);
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}

	}

	/**
	 * Método responsável por trocar de aba do browser
	 * 
	 * @author Silas Gomes
	 */
	public void trocarAba() {
		try {
			String janelaPrincipal = driver.getWindowHandle();
			Set<String> todasJanelas = driver.getWindowHandles();

			for (String janela : todasJanelas) {
				if (!janelaPrincipal.equals(janela)) {
					driver.switchTo().window(janela);

				}
			}
		} catch (Exception e) {
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}
	}

	/**
	 * Método respossável por confirmar o preenchimento.
	 * 
	 * @param elemento
	 * @author Silas Gomes
	 */
	public void submit(By elemento) {
		try {
			driver.findElement(elemento).submit();
		} catch (Exception e) {
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}
	}

	/**
	 * Método responsável por limpar o preenchimento de um campo.
	 * 
	 * @param elemento
	 * @author Silas Gomes
	 */
	public void limparTexto(By elemento) {
		try {
			driver.findElement(elemento).clear();
		} catch (Exception e) {
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}
	}

	/**
	 * Método responsável por fechar janela atual e voltar para janela principal.
	 * 
	 * @author Silas Gomes
	 */
	public void fecharAbaAtual() {
		try {

			String janela = driver.getWindowHandle();
			Set<String> todasJanelas = driver.getWindowHandles();
			for (String janelaPrincipal : todasJanelas) {
				if (!janela.equals(janelaPrincipal)) {
					driver.close();
					driver.switchTo().window(janelaPrincipal);

				}
			}

		} catch (Exception e) {
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}

	}

	/**
	 * Método responsável se elemento está visível
	 * 
	 * @param elemento
	 * @return
	 * @author Silas Gomes
	 */
	public boolean aguardarElemento(By elemento) {
		try {
			return driver.findElement(elemento).isDisplayed();
		} catch (Exception e) {
			System.err.println("Causa do erro " + e.getCause());
			System.out.println("Mensagem de erro " + e.getMessage());
		}
		return true;
	}
	
	/**
	 * Método responsável por capturar evidência de teste e salvar na pasta evidências.
	 * 
	 * @param historia
	 * @param nomeDoArquivo
	 * @author Silas Gomes
	 */
	public void capturarTela(String historia, String nomeDaEvidencia) {
		String timestamp = new SimpleDateFormat("ddMMYYYY").format(new Date());
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot,
					new File("./evidencias/" + historia + "/" + timestamp + "/" + nomeDaEvidencia + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}