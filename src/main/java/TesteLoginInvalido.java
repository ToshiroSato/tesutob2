import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

public class TesteLoginInvalido {
	
	private WebDriver driver;
	private LoginPage page;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://mantis-prova.base2.com.br/login_page.php");
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
		page.setUserName("uincorreto");
		Assert.assertEquals("uincorreto", page.obterUsername());
		page.setSenha("tesutotr@cker");
		Assert.assertEquals("tesutotr@cker", page.obterPassword());
		page.setBottom("//*[@value='Login']");
		Assert.assertEquals("Login", page.validarClick());
		page.sincronismo();
		Assert.assertTrue(page.obterMsgErro());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		}
	
	@Test
	// cenário 2: usuário informado incorreto; senha informada incorreta;
	public void testeUserIncorreto2() throws IOException{
		page.setUserName("uincorreto");
		Assert.assertEquals("uincorreto", page.obterUsername());
		page.setSenha("sincorreta");
		Assert.assertEquals("sincorreta", page.obterPassword());
		page.setBottom("//*[@value='Login']");
		Assert.assertEquals("Login", page.validarClick());
		page.sincronismo();
		Assert.assertTrue(page.obterMsgErro());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		}
	
	@Test
	// cenário 3: usuário informado incorreto; senha não informada;
	public void testeUserIncorreto3() throws IOException{
		page.setUserName("uincorreto");
		Assert.assertEquals("uincorreto", page.obterUsername());
		page.setSenha("");
		Assert.assertEquals("", page.obterPassword());
		page.setBottom("//*[@value='Login']");
		Assert.assertEquals("Login", page.validarClick());
		page.sincronismo();
		Assert.assertTrue(page.obterMsgErro());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		}
	
	@Test
	// cenário 4: usuário não informado; senha informada correta;
	public void testeUserNaoInform() throws IOException{
		page.setUserName("");
		Assert.assertEquals("", page.obterUsername());
		page.setSenha("tesutotr@cker");
		Assert.assertEquals("tesutotr@cker", page.obterPassword());
		page.setBottom("//*[@value='Login']");
		Assert.assertEquals("Login", page.validarClick());
		page.sincronismo();
		Assert.assertTrue(page.obterMsgErro());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		}
	
	@Test
	// cenário 5: senha informada incorreta; usuário informado correto;
	public void testeSenhaIncorreta1() throws IOException{
		page.setUserName("hugo.toshiro");
		Assert.assertEquals("hugo.toshiro", page.obterUsername());
		page.setSenha("sincorreta");
		Assert.assertEquals("sincorreta", page.obterPassword());
		page.setBottom("//*[@value='Login']");
		Assert.assertEquals("Login", page.validarClick());
		page.sincronismo();
		Assert.assertTrue(page.obterMsgErro());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		}
	
	@Test
	// cenário 6: senha informada incorreta; usuário não informado;
	public void testeSenhaIncorreta2() throws IOException{
		page.setUserName("");
		Assert.assertEquals("", page.obterUsername());
		page.setSenha("sincorreta");
		Assert.assertEquals("sincorreta", page.obterPassword());
		page.setBottom("//*[@value='Login']");
		Assert.assertEquals("Login", page.validarClick());
		page.sincronismo();
		Assert.assertTrue(page.obterMsgErro());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		}
	
	@Test
	// cenário 7: usuario informado correto; senha não informada;
	public void testeSenhaIncorreta3() throws IOException{
		page.setUserName("hugo.toshiro");
		Assert.assertEquals("hugo.toshiro", page.obterUsername());
		page.setSenha("");
		Assert.assertEquals("", page.obterPassword());
		page.setBottom("//*[@value='Login']");
		Assert.assertEquals("Login", page.validarClick());
		page.sincronismo();
		Assert.assertTrue(page.obterMsgErro());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));		
		}
	
	@Test
	// cenário 8: usuario e senha não informados;
	public void userEsenhaNaoInform() throws IOException{
		page.setUserName("");
		Assert.assertEquals("", page.obterUsername());
		page.setSenha("");
		Assert.assertEquals("", page.obterPassword());
		page.setBottom("//*[@value='Login']");
		Assert.assertEquals("Login", page.validarClick());
		page.sincronismo();
		Assert.assertTrue(page.obterMsgErro());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		}
			}