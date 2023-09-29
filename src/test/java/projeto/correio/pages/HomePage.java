package projeto.correio.pages;

import org.openqa.selenium.By;

import projeto.correio.drivers.DriversDeConexoes;
import projeto.correio.metodos.MetodosDeTestes;

public class HomePage extends DriversDeConexoes {

	MetodosDeTestes metodo = new MetodosDeTestes();

	By campoPesquisaCep = By.id("relaxation");
	By dadosLogradouro = By.xpath("//td[@data-th='Logradouro/Nome']");
	By dadosBairro = By.xpath("//td[@data-th='Bairro/Distrito']");
	By dadosLocalidade = By.xpath("//td[@data-th='Localidade/UF']");
	By dadosCep = By.xpath("//td[@data-th='CEP']");
	By tituloBuscarCep = By.xpath("//h2[text()='Busca CEP']");
	By btnNovaBusca = By.id("btn_nbusca");
	By responseCepInvalido = By.xpath("//h6[text()='Dados não encontrado']");

	public void informarCep(String cep) {
		metodo.escrever(campoPesquisaCep, cep, "Preenchendo Cep");
	}

	public void informarEndereco(String endereco) {
		metodo.escrever(campoPesquisaCep, endereco, "Preenchendo Endereço ");
	}

	public void validarDadosEndereco(String logradouroNome, String bairro, String localidade, String cep, String nomeDoTeste) throws InterruptedException {
		metodo.aguardarElemento(btnNovaBusca);
		metodo.validarTexto(dadosLogradouro, logradouroNome, "Validando logradouro");
		metodo.validarTexto(dadosBairro, bairro, "Validando logradouro");
		metodo.validarTexto(dadosLocalidade, localidade, "Validando logradouro");
		metodo.validarTexto(dadosCep, cep, "Validando logradouro");
		metodo.capturarTela("Busca Cep ou Endereço", nomeDoTeste);

	}

	public void submit() {
		metodo.submit(campoPesquisaCep);
	}

	public void trocarAba(String url) {
		metodo.trocarAba();
		metodo.validarUrl(url, "Validando URL aba resultado endereço");

	}

	public void voltarAba(String url, String textoCapturado) {
		metodo.fecharAbaAtual();
		metodo.validarUrl(url, "Validando URL aba Principal");
		metodo.limparTexto(campoPesquisaCep);
		metodo.escrever(campoPesquisaCep, textoCapturado, "Preenchendo com endereço capturado");
	}
	
	public void validarTeste(String texto, String nomeDoTeste) {
		if(texto.equals("Dados não encontrado")) {
			metodo.validarTexto(responseCepInvalido, texto, "Validando pesquisa");
		}else {
			metodo.validarTexto(tituloBuscarCep, texto, "Validando pesquisa");
		}
		metodo.capturarTela("Busca Cep ou Endereço", nomeDoTeste);
		
	}

}
