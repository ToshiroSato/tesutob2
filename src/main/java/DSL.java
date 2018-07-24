import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {
	
private WebDriver driver;
	

	/*acho que esse construtor � para passar o driver como parametro para este
	m�todo que acho que � o m�todo que inicializa a classe DSL
	*/
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	/********* InputText ************/
	//neste m�todo � declarado o comando findElement j� junto com o sendKeys
	public void escrever(By by, String texto){
		driver.findElement(by).sendKeys(texto);
	}
	/*neste m�todo s�o atribu�dos os param�tros para os locators utilizados na classe teste
	que foram passados para o m�todo anterior*/
	public void escrever(String name_campo, String texto){
		escrever(By.name(name_campo), texto);
	}
	
	public String obterValorCampo(String name_campo) {
		return driver.findElement(By.name(name_campo)).getAttribute("value");
	}
	
	/********* Botao ************/	
	public void clicarBotao(String xpath_botao) {
		driver.findElement(By.xpath(xpath_botao)).click();
		
	}
	
	public String obterValueElemento(String xpath_botao) {
		return driver.findElement(By.xpath(xpath_botao)).getAttribute("value");
}
	/********* Sincronismo ************/
	
	public WebElement sincronismologInvalido(String xpath_spanSincr) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[@color='red']")));
		
	}
	
	public WebElement sincronismologValido(String className_logvalido) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.className("italic")));
		
	}
		
	/********* Span ************/
		
	public boolean obterConteudoSpan(Boolean xpath_span) {
		
		return driver.findElement(By.xpath("//font[@color='red']")).getText().startsWith("Your account may be");
		}
	
	/********* Nome do usuario na tela inicial ************/
	
	public boolean validarLoginSucesso(Boolean texto_logvalido) {
		
		return driver.findElement(By.className("italic")).getText().contains("hugo.toshiro");
		
	}
}