import org.openqa.selenium.WebDriver;

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
	
	public void logar() {
		dsl.clicarBotao("//*[@value='Login']");
	}
	
	public String obterUsername() {
		
		return dsl.obterValorCampo("username");
	}
	
	public String obterPassword() {
		
		return dsl.obterValorCampo("password");
		
	}
	
	public Boolean obterMsgErro() {
		
		return dsl.obterConteudoSpan(true);
		
	}
	
}
