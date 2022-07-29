package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirVerPage extends BasePage {

	// MODIFICAR
	By btnVer = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[1]/td[9]/div/a[2]");
	By btnVer1 = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[8]/td[9]/div/a[2]");
	By btnCancelar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button");
	By InformacionG = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[1]/div/div[1]");
	By VCDM = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]");
	By Plazos = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[3]/div/div[1]");
	By Poliza = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[4]/div/div[1]");
	By tipoMercancia = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[5]/div/div[1]");
	By Mercancias = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[1]");
	By Tarifas = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[7]/div/div[1]");
	
	
	public ExpedirVerPage(WebDriver driver) {
		super(driver);
	}

	// INGRESAR A MODULO VER
	/*@Step("Deslizar horizontal derecha")
	public ExpedirVerPage ScrollDerecha() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[1]/td[9]/div/a[3]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}
	
	@Step("Deslizar horizontal derecha")
	public ExpedirVerPage ScrollDerecha1() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[8]/td[9]/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}
	
	@Step("Deslizar horizontal derecha")
	public ExpedirVerPage ScrollDerechaOpcion2() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[1]/td[9]/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}

	@Step("Etiqueta Ver Titulo")
	public ExpedirVerPage EtiquetaVerTitulo() {

		Utilidades.waitInMs(3000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[1]/td[9]/div/a[2]"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Ver")
	public ExpedirVerPage Ver() {

		Utilidades.waitInMs(3000);
		click(btnVer);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Ver")
	public ExpedirVerPage Ver1() {

		Utilidades.waitInMs(3000);
		click(btnVer1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Informacion General del Titulo")
	public ExpedirVerPage IGT() {

		Utilidades.waitInMs(3000);
		click(InformacionG);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("VCDM")
	public ExpedirVerPage VCDM() {

		Utilidades.waitInMs(3000);
		click(VCDM);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Plazos")
	public ExpedirVerPage Plazos() {

		Utilidades.waitInMs(3000);
		click(Plazos);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Poliza")
	public ExpedirVerPage Poliza() {

		Utilidades.waitInMs(3000);
		click(Poliza);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	
	@Step("Tipo de Mercancia")
	public ExpedirVerPage TipoMercancia() {

		Utilidades.waitInMs(3000);
		click(tipoMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Mercancia")
	public ExpedirVerPage Mercancia() {

		Utilidades.waitInMs(3000);
		click(Mercancias);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Tarifa")
	public ExpedirVerPage Tarifa() {

		Utilidades.waitInMs(3000);
		click(Tarifas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Botón Cancelar")
	public ExpedirVerPage Cancelar() {

		Utilidades.waitInMs(3000);
		click(btnCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}*/
}