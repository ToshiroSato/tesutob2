import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
=======
>>>>>>> 3ff57ee98062d0222b6c71c60e00768bcc4f99f8

public class LoginPage {
	
	/* acho que o lance de usar o ~Page, seria:
	 * CONCEITO DE DEPENDENCIAS - REFATORAR TUDO QUE PRECISA QUANDO ALTERAR UM SÓ COMPONENTE
	 * "FORÇAR" O REUSO
	*/
	
	private DSL dsl;
	
	public LoginPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setUserName(String username) {
		dsl.escrever("username", username);
	}
	
	public void setSenha(String password) {
		dsl.escrever("password", password);
	}
	
<<<<<<< HEAD
	public void setBottom(String botao) {
		dsl.clicarBotao("//*[@value='Login']");
	}
	
	/*public void logar() {
		dsl.clicarBotao("//*[@value='Login']");
	}*/
	
=======
	public void logar() {
		dsl.clicarBotao("//*[@value='Login']");
	}
	
>>>>>>> 3ff57ee98062d0222b6c71c60e00768bcc4f99f8
	public String obterUsername() {
		
		return dsl.obterValorCampo("username");
	}
	
	public String obterPassword() {
		
		return dsl.obterValorCampo("password");
<<<<<<< HEAD
	}
	
	public String validarClick() {
		
		return dsl.obterValueElemento("//*[@value='Login']");
	}
	
	public WebElement sincronismo() {
		
		return dsl.sincronismologInvalido("//font[@color='red']");
=======
>>>>>>> 3ff57ee98062d0222b6c71c60e00768bcc4f99f8
		
	}
	
	public Boolean obterMsgErro() {
		
		return dsl.obterConteudoSpan(true);
		
	}
	
}
