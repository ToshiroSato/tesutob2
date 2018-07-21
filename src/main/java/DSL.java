import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {
	
private WebDriver driver;
	

	/*acho que esse construtor é para passar o driver como parametro para este
	método que acho que é o método que inicializa a classe DSL
	*/
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	/********* InputText ************/
	//neste método é declarado o comando findElement já junto com o sendKeys
	public void escrever(By by, String texto){
		driver.findElement(by).sendKeys(texto);
	}
	/*neste método são atribuídos os paramêtros para os locators utilizados na classe teste
	que foram passados para o método anterior*/
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
	
	/*public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[@color='red']")));
	
	*/
	public WebElement aplicarSincronismo(String xpath_spanSincr) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//font[@color='red']")));
		
	}
	
	/********* Span ************/
	
	/*Assert.assertTrue(driver.findElement(By.xpath("//font[@color='red']"))
	 * .getText().startsWith("Your account may be"));
	*/
	public boolean obterConteudoSpan(Boolean xpath_span) {
		
		return driver.findElement(By.xpath("//font[@color='red']")).getText().startsWith("Your account may be");
		}
	}