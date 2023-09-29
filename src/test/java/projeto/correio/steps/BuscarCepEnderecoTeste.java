package projeto.correio.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import projeto.correio.drivers.DriversDeConexoes;
import projeto.correio.pages.HomePage;
import projeto.correiros.navegadores.Navegadores;

public class BuscarCepEnderecoTeste extends DriversDeConexoes {

	String logradouroNome = "Rua Sérgio Souza Aranha de Gennaro";
	String bairro = "Jardim Castro Alves";
	String localidade = "São Paulo/SP";
	String Cep = "04842-145";
	String urlAbaResultado = "https://buscacepinter.correios.com.br/app/endereco/index.php?t";
	String urlAbaPrincipal = "https://www.correios.com.br/";
	String tituloBuscaCep = "Busca CEP";
	String respostaCepInvalido = "Dados não encontrado";
	String cepInvalido = "0000000";

	HomePage page = new HomePage();

	@Before
	public void iniciarTeste() {
		Navegadores.iniciarTeste();
	}

	@After
	public void finalizarTeste() {
		Navegadores.finalizarTeste();
	}

	@Dado("que informo um cep valido")
	public void queInformoUmCepValido() {
		page.informarCep(Cep);
	}

	@Quando("enviar o cep")
	public void enviarOCep() {
		page.submit();
		page.trocarAba(urlAbaResultado);
	}

	@Entao("valido os dados de endereco")
	public void validoOsDadosDeEndereco() throws InterruptedException {
		page.validarDadosEndereco(this.logradouroNome, bairro, localidade, Cep,"valido os dados de endereco");
		System.out.println(logradouroNome);
	}

	@Entao("retorno a tela para pesquisar pelo endereco")
	public void retornoATelaParaPesquisarPeloEndereco() throws InterruptedException {
		page.voltarAba(urlAbaPrincipal, logradouroNome);
		page.submit();
		page.trocarAba(urlAbaResultado);
		page.validarDadosEndereco(this.logradouroNome, this.bairro, this.localidade, this.Cep, "retorno a tela para pesquisar pelo endereco");

	}

	@Dado("que informo um endereco valido")
	public void queInformoUmEnderecoValido() {
		page.informarEndereco(logradouroNome);
	}

	@Quando("enviar o endereco")
	public void enviarOEndereco() {
		page.submit();
		page.trocarAba(urlAbaResultado);
	}

	@Entao("retorno a tela para pesquisar pelo bairro")
	public void retornoATelaParaPesquisarPeloBairro() throws InterruptedException {
		page.voltarAba(urlAbaPrincipal, Cep);
		page.submit();
		page.trocarAba(urlAbaResultado);
		page.validarDadosEndereco(this.logradouroNome, this.bairro, this.localidade, this.Cep, "retorno a tela para pesquisar pelo bairro");

	}

	@Dado("que não preencha o endereco ou cep")
	public void queNãoPreenchaOEnderecoOuCep() {
		page.informarCep("");
	}

	@Entao("valido se direcionou para nova busca")
	public void validoSeDirecionouParaNovaBusca() {
		page.validarTeste(this.tituloBuscaCep, "valido se direcionou para nova busca");
		;
	}

	@Dado("que informe um cep invalido")
	public void queInformeUmCepInvalido() {
		page.informarCep(this.cepInvalido);
	}

	@Entao("valido dados nao encontrados")
	public void validoDadosNaoEncontrados() {
		page.validarTeste(respostaCepInvalido, "valido dados nao encontrados");
	}

}
