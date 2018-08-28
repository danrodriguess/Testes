package unipeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.Assert;

public class LoginUnipe {
	
	private WebDriver driver;
	
	@Before
	public void inicilizador() {
		driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	static By campoNome = By.id("elementosForm:nome");
	static By campoSobrenome = By.id("elementosForm:sobrenome");
	static By buttonSexo = By.id("elementosForm:sexo:0");
	static By checkCarne = By.id("elementosForm:comidaFavorita:0");
	static By checkPizza = By.id("elementosForm:comidaFavorita:2");
	static By escolaridade = By.id("elementosForm:escolaridade");
	static By esportes = By.id("elementosForm:esportes");
	
	static By buttonCadastro = By.id("elementosForm:cadastrar");
	
	@Test
	public void campoDeTreinamento() {
		driver.findElement(campoNome).sendKeys("Israel");
		driver.findElement(campoSobrenome).sendKeys("Araujo");
		driver.findElement(buttonSexo).click();
	}
	
	@Test
	public void cadastro() {
		
		driver.findElement(campoNome).sendKeys("Israel");
		driver.findElement(campoSobrenome).sendKeys("Araujo");
		driver.findElement(buttonSexo).click();
		driver.findElement(checkCarne).click();
		driver.findElement(checkPizza).click();
		
		WebElement element = driver.findElement(escolaridade);
		Select combo = new Select(element);
		combo.selectByVisibleText("Superior");
		
		WebElement elementEsportes = driver.findElement(esportes);
		Select comboEsporte = new Select(elementEsportes);
		comboEsporte.selectByVisibleText("Futebol");
		comboEsporte.selectByVisibleText("Corrida");
		comboEsporte.selectByVisibleText("Karate");
		
		driver.findElement(buttonCadastro).click();
		
		Assert.assertTrue("Cadastrado!", driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue("Israel", driver.findElement(By.id("descNome")).getText().endsWith("Israel"));
		Assert.assertEquals("Sobrenome: Araujo", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Futebol Corrida Karate", driver.findElement(By.id("descEsportes")).getText());
		
		
	}

}
