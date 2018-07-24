import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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

public class TesteLoginValido {
	
	private WebDriver driver;
	private LoginPage lpage;
	private InicialPage inipage;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://mantis-prova.base2.com.br/login_page.php");
		lpage = new LoginPage (driver);
		inipage = new InicialPage (driver);
	}
	
	@After
	public void finaliza(){
		
		driver.quit();
	}
	
	@Rule
	public TestName testName = new TestName();
	
	@Test
	// cenário 9: usuario e senha informados corretamente;
	public void userEsenhaCorretos() throws IOException{
		lpage.setUserName("hugo.toshiro");
		Assert.assertEquals("hugo.toshiro", lpage.obterUsername());
		lpage.setSenha("tesutotr@cker");
		Assert.assertEquals("tesutotr@cker", lpage.obterPassword());
		lpage.setBottom("//*[@value='Login']");
		inipage.sincronismo();
		Assert.assertTrue(inipage.obtertextoLogadoComo());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		}	
	}
