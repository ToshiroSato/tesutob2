import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.commons.io.FileUtils;

public class TesteLogin {
	
	@Rule
	public TestName testName = new TestName();
		
	@Test
	// cen�rio 1: usu�rio informado incorreto; senha informada correta;
	public void testeUserIncorreto1() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://mantis-prova.base2.com.br/login_page.php");
		driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("uincorreto");
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("tesutotr@cker");
		WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
		botao.click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/font")).getText().startsWith("Your account may be"));
		
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		driver.quit();
		
		}
	
	@Test
	// cen�rio 2: usu�rio informado incorreto; senha informada incorreta;
	public void testeUserIncorreto2() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://mantis-prova.base2.com.br/login_page.php");
		driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("uincorreto");
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("sincorreta");
		WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
		botao.click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/font")).getText().startsWith("Your account may be"));
		
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		driver.quit();
		
		}
	
	@Test
	// cen�rio 3: usu�rio informado incorreto; senha n�o informada;
	public void testeUserIncorreto3() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://mantis-prova.base2.com.br/login_page.php");
		driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("uincorreto");
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("");
		WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
		botao.click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/font")).getText().startsWith("Your account may be"));
		
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		driver.quit();
		
		}
	
	@Test
	// cen�rio 4: usu�rio n�o informado; senha informada correta;
	public void testeUserNaoInform() throws IOException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://mantis-prova.base2.com.br/login_page.php");
		driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("");
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("tesutotr@cker");
		WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
		botao.click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/font")).getText().startsWith("Your account may be"));
		
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
		
		driver.quit();
		
		}
	
	@Test
	// cen�rio 5: senha informada incorreta; usu�rio informado correto;
		public void testeSenhaIncorreta1() throws IOException{
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("http://mantis-prova.base2.com.br/login_page.php");
			driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("hugo.toshiro");
			driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("sincorreta");
			WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
			botao.click();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/font")).getText().startsWith("Your account may be"));
			
			
			TakesScreenshot ss = (TakesScreenshot) driver;
			File arquivo = ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
			
			driver.quit();
			
			}
	
	@Test
	// cen�rio 6: senha informada incorreta; usu�rio n�o informado;
		public void testeSenhaIncorreta2() throws IOException{
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("http://mantis-prova.base2.com.br/login_page.php");
			driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("");
			driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("sincorreta");
			WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
			botao.click();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/font")).getText().startsWith("Your account may be"));
			
			
			TakesScreenshot ss = (TakesScreenshot) driver;
			File arquivo = ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
			
			driver.quit();
			
			}
	
	@Test
	// cen�rio 7: usuario informado correto; senha n�o informada;
		public void testeSenhaIncorreta3() throws IOException{
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("http://mantis-prova.base2.com.br/login_page.php");
			driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("hugo.toshiro");
			driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("");
			WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
			botao.click();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/font")).getText().startsWith("Your account may be"));
			
			
			TakesScreenshot ss = (TakesScreenshot) driver;
			File arquivo = ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
			
			driver.quit();
			
			}
	
	@Test
	// cen�rio 8: usuario e senha n�o informados;
		public void userEsenhaNaoInform() throws IOException{
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("http://mantis-prova.base2.com.br/login_page.php");
			driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("");
			driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("");
			WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
			botao.click();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/font")).getText().startsWith("Your account may be"));
			
			
			TakesScreenshot ss = (TakesScreenshot) driver;
			File arquivo = ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
			
			driver.quit();
			
			}
	@Test
	// cen�rio 9: usuario e senha informado corretamente;
			public void userEsenhaCorretos() throws IOException{
				WebDriver driver = new FirefoxDriver();
				driver.manage().window().setSize(new Dimension(1200, 765));
				driver.get("http://mantis-prova.base2.com.br/login_page.php");
				driver.findElement(By.xpath("//tbody//*[1]")).sendKeys("hugo.toshiro");
				driver.findElement(By.xpath("//tbody/tr[3]/td[2]/*[1]")).sendKeys("tesutotr@cker");
				WebElement botao = driver.findElement(By.xpath("//table/tbody//*[@class='button']"));
				botao.click();	
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Logged in as: hugo.toshiro"));
				
				
				TakesScreenshot ss = (TakesScreenshot) driver;
				File arquivo = ss.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(arquivo, new File(testName.getMethodName()+".jpg"));
				
				driver.quit();
				
				}
			}