import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InicialPage {

	private DSL dsl;
		
	public InicialPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public WebElement sincronismo() {
		
		return dsl.sincronismologValido("italic");
		
	}
	
	public Boolean obtertextoLogadoComo() {
		
		return dsl.validarLoginSucesso(true);
		
	}
	
}
