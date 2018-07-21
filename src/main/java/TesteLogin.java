import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class TesteLogin {
	
	private WebDriver driver;
	private DSL dsl;
	private LoginPage page;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://mantis-prova.base2.com.br/login_page.php");
		dsl = new DSL (driver);
		page = new LoginPage (driver);
	}
	
	@After
	public void finaliza(){
		
		driver.quit();
	}
	
	@Rule
	public TestName testName = new TestName();
	
	@Test
	// cenário 1: usuário informado incorreto; senha informada correta;
	public void testeUserIncorreto1() throws IOException{
		/*page.setUserName("uincorreto");
		Assert.assertEquals("uinconrreto", page.obterUsername());*/
		dsl.escrever("username", "uincorreto"); /*muito mais fácil - visão de usuário: casos de testes e código + limpo*/
		Assert.assertEquals("uincorreto", dsl.obterValorCampo("username"));
		dsl.escrever("password", "tesutotr@cker");
		Assert.assertEquals("tesutotr@cker", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		Assert.assertEquals("Login", dsl.obterValueElemento("//*[@value='Login']"));
		dsl.aplicarSincronismo("//font[@color='red']");
		Assert.assertTrue(dsl.obterConteudoSpan(null));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		}
	
	@Test
	// cenário 2: usuário informado incorreto; senha informada incorreta;
	public void testeUserIncorreto2() throws IOException{
		dsl.escrever("username", "uincorreto");
		Assert.assertEquals("uincorreto", dsl.obterValorCampo("username"));
		dsl.escrever("password", "sincorreta");
		Assert.assertEquals("sincorreta", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		Assert.assertEquals("Login", dsl.obterValueElemento("//*[@value='Login']"));
		dsl.aplicarSincronismo("//font[@color='red']");
		Assert.assertTrue(dsl.obterConteudoSpan(null));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		}
	
	@Test
	// cenário 3: usuário informado incorreto; senha não informada;
	public void testeUserIncorreto3() throws IOException{
		dsl.escrever("username", "uincorreto");
		Assert.assertEquals("uincorreto", dsl.obterValorCampo("username"));
		dsl.escrever("password", "");
		Assert.assertEquals("", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		Assert.assertEquals("Login", dsl.obterValueElemento("//*[@value='Login']"));
		dsl.aplicarSincronismo("//font[@color='red']");
		Assert.assertTrue(dsl.obterConteudoSpan(null));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		}
	
	@Test
	// cenário 4: usuário não informado; senha informada correta;
	public void testeUserNaoInform() throws IOException{
		dsl.escrever("username", "");
		Assert.assertEquals("", dsl.obterValorCampo("username"));
		dsl.escrever("password", "tesutotr@cker");
		Assert.assertEquals("tesutotr@cker", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		Assert.assertEquals("Login", dsl.obterValueElemento("//*[@value='Login']"));
		dsl.aplicarSincronismo("//font[@color='red']");
		Assert.assertTrue(dsl.obterConteudoSpan(null));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		}
	
	@Test
	// cenário 5: senha informada incorreta; usuário informado correto;
	public void testeSenhaIncorreta1() throws IOException{
		dsl.escrever("username", "hugo.toshiro");
		Assert.assertEquals("hugo.toshiro", dsl.obterValorCampo("username"));
		dsl.escrever("password", "sincorreta");
		Assert.assertEquals("sincorreta", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		Assert.assertEquals("Login", dsl.obterValueElemento("//*[@value='Login']"));
		dsl.aplicarSincronismo("//font[@color='red']");
		Assert.assertTrue(dsl.obterConteudoSpan(null));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		}
	
	@Test
	// cenário 6: senha informada incorreta; usuário não informado;
	public void testeSenhaIncorreta2() throws IOException{
		dsl.escrever("username", "");
		Assert.assertEquals("", dsl.obterValorCampo("username"));
		dsl.escrever("password", "sincorreta");
		Assert.assertEquals("sincorreta", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		Assert.assertEquals("Login", dsl.obterValueElemento("//*[@value='Login']"));
		dsl.aplicarSincronismo("//font[@color='red']");
		Assert.assertTrue(dsl.obterConteudoSpan(null));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
			
		}
	
	@Test
	// cenário 7: usuario informado correto; senha não informada;
	public void testeSenhaIncorreta3() throws IOException{
		
		dsl.escrever("username", "hugo.toshiro");
		Assert.assertEquals("hugo.toshiro", dsl.obterValorCampo("username"));
		dsl.escrever("password", "");
		Assert.assertEquals("", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		Assert.assertEquals("Login", dsl.obterValueElemento("//*[@value='Login']"));
		dsl.aplicarSincronismo("//font[@color='red']");
		Assert.assertTrue(dsl.obterConteudoSpan(null));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
			
		}
	
	@Test
	// cenário 8: usuario e senha não informados;
	public void userEsenhaNaoInform() throws IOException{
		dsl.escrever("username", "");
		Assert.assertEquals("", dsl.obterValorCampo("username"));
		dsl.escrever("password", "");
		Assert.assertEquals("", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		Assert.assertEquals("Login", dsl.obterValueElemento("//*[@value='Login']"));
		dsl.aplicarSincronismo("//font[@color='red']");
		Assert.assertTrue(dsl.obterConteudoSpan(null));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
			
		}
	@Test
	// cenário 9: usuario e senha informado corretamente;
	public void userEsenhaCorretos() throws IOException{
		dsl.escrever("username", "hugo.toshiro");
		Assert.assertEquals("hugo.toshiro", dsl.obterValorCampo("username"));
		dsl.escrever("password", "tesutotr@cker");
		Assert.assertEquals("tesutotr@cker", dsl.obterValorCampo("password"));
		dsl.clicarBotao("//*[@value='Login']");	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("italic")));
		Assert.assertTrue(driver.findElement(By.className("italic")).getText().contains("hugo.toshiro"));
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
				
		}
			}