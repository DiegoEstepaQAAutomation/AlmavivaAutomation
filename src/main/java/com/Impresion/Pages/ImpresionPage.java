package com.Impresion.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.ExpedirTitulo.Pages.ExpedirModificarPage;
import com.ExpedirTitulo.Pages.ExpedirrPage;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ImpresionPage extends BasePage {

	// TITULO OPCIONES MENU
	By btnTitulo = By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/div/a");
	By btnExpedir = By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/div/ul/li[1]/div/a");

	// PRIMERAS OPCIONES
	By btnCrearTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[2]/div/a");
	By ListaNitNombreRazonSocial = By.id("criterio");
	By lblNIT = By.xpath("//*[@id=\"criterio\"]/option[1]");
	By lblNombreRazonSocial = By.xpath("//*[@id=\"criterio\"]/option[2]");
	By lblTitulo = By.xpath("//*[@id=\"criterio\"]/option[3]");
	By lblFecha = By.xpath("//*[@id=\"criterio\"]/option[4]");
	By txtIngreseNitNombreRazonSocial = By.id("termino");
	By btnModificar = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[1]");
	By btnVer = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[2]");
	By btnImprimir = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[3]");
	By btnImprimirCDMA = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[1]/div[2]/div/button[1]");
	By btnImprimirCDMB = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[1]/div[2]/div/button[2]");
	By btnImprimirBonoA = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[2]/div[2]/div/button[1]");
	By btnImprimirBonoB = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[2]/div[2]/div/button[2]");
	By btnAceptar = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnImprimirTalonA = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[3]/div[2]/div/button[1]");
	By btnImprimirTalonB = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[3]/div[2]/div/button[2]");
	By PagAdelante = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[10]/a"); 
	By PagAtras = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[2]/a"); 
	By PagFinal = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[11]/a");
	By PagPrincipio = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[1]/a");
	By Pag25 = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/select/option[3]"); 
	By lblNumeroTitulo = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[1]");
	By lblNit = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[2]");
	By lblNombreRazonS = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[3]");
	By lblTipoBodega = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[4]");
	By lblTipoTitulo = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[5]");
	By lblTipoMercancia = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[6]");
	By lblValorMercancia = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[7]");
	By lblEstado = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[8]");
	
	
	By SeleccionarNitNombreRazonSocial = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/busqueda-cliente/form/div[2]/ngb-typeahead-window/button");
	By btnCancelarCrear = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button[3]");
	
	public ImpresionPage(WebDriver driver) {
		super(driver);
	}

	// SCROLL
	/*@Step("Scroll vertibal abajo")
	public ImpresionPage ScrollAbajo() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertibal abajo")
	public ImpresionPage ScrollAbajo1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertical arriba")
	public ImpresionPage ScrollArriba() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Scroll vertical arriba")
	public ImpresionPage ScrollArriba1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Deslizar horizontal derecha")
	public ImpresionPage ScrollDerecha() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[3]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Deslizar horizontal derecha")
	public ImpresionPage ScrollDerecha1() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[10]/td[9]/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Deslizar horizontal derecha")
	public ImpresionPage ScrollDerecha2() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}

	@Step("Evidencia")
	public ImpresionPage Evidencia() {

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}

	// INGRESAR A MODULO TITULO / EXPEDIR
	@Step("Ingresar al modulo Titulo")
	public ImpresionPage Titulo() {

		Utilidades.waitInMs(3000);
		click(btnTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Ingresar al Sub modulo Expedir")
	public ImpresionPage Expedir() {

		Utilidades.waitInMs(3000);
		click(btnExpedir);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	// PRIMERAS OPCIONES
	
	@Step("Seleccionar NIT")
	public ImpresionPage SeleccionarNIT() {

		Utilidades.waitInMs(3000);
		click(lblNIT);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Nombre / Razón Social")
	public ImpresionPage SeleccionarNombreRazonSocial() {

		Utilidades.waitInMs(3000);
		click(lblNombreRazonSocial);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Titulo")
	public ImpresionPage SeleccionarTitulo() {

		Utilidades.waitInMs(3000);
		click(lblTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Fecha")
	public ImpresionPage SeleccionarFecha() {

		Utilidades.waitInMs(3000);
		click(lblFecha);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Filtro de busqueda NIT / Nombre/Razón Social")
	public ImpresionPage IngreseConsulta(String nit) {

		Utilidades.waitInMs(3000);
		writeText(txtIngreseNitNombreRazonSocial, nit);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clear filtro de busqueda NIT / Nombre / Razón Social")
	public ImpresionPage ClearConsulta() {

		Utilidades.waitInMs(1000);
		clear(txtIngreseNitNombreRazonSocial);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Etiqueta Modificar Titulo")
	public ImpresionPage EtiquetaModificarTitulo() {

		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnModificar);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Etiqueta Ver Titulo")
	public ImpresionPage EtiquetaVerTitulo() {

		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnVer);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Etiqueta Imprimir Titulo")
	public ImpresionPage EtiquetaImprimirTitulo() {

		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnImprimir);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir titulo")
	public ImpresionPage ImprimirTitulo() {

		Utilidades.waitInMs(2000);
		click(btnImprimir);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir CMD A")
	public ImpresionPage ImprimirTituloCMDA() {

		Utilidades.waitInMs(2000);
		click(btnImprimirCDMA);
		Utilidades.waitInMs(10000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir CMD B")
	public ImpresionPage ImprimirTituloCMDB() {

		Utilidades.waitInMs(2000);
		click(btnImprimirCDMB);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir Bono A")
	public ImpresionPage ImprimirTituloBonoA() {

		Utilidades.waitInMs(2000);
		click(btnImprimirBonoA);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir Bono B")
	public ImpresionPage ImprimirTituloBonoB() {

		Utilidades.waitInMs(2000);
		click(btnImprimirBonoB);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar Bono A")
	public ImpresionPage AceptarBonoA() {

		Utilidades.waitInMs(2000);
		click(btnAceptar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir Talon A")
	public ImpresionPage ImprimirTituloTalonA() {

		Utilidades.waitInMs(2000);
		click(btnImprimirTalonA);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir Talon B")
	public ImpresionPage ImprimirTituloTalonB() {

		Utilidades.waitInMs(2000);
		click(btnImprimirTalonB);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Scape Imprimir borrador")
	public ImpresionPage Scape() {

		Utilidades.waitInMs(1500);
		driver.findElement(btnImprimirTalonB).sendKeys(Keys.ESCAPE);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Scape Impresion")
	public ImpresionPage Scape1() throws AWTException {

		Utilidades.waitInMs(5500);
		Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE); r.keyRelease(KeyEvent.VK_ESCAPE);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion sigiente")
	public ImpresionPage PagSig() {

		Utilidades.waitInMs(2000);
		click(PagAdelante);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Paginacion Atras")
	public ImpresionPage PagAtras() {

		Utilidades.waitInMs(2000);
		click(PagAtras);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Paginacion Final")
	public ImpresionPage PagFinal() {

		Utilidades.waitInMs(2000);
		click(PagFinal);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Paginacion Principal")
	public ImpresionPage PagPrincipal() {

		Utilidades.waitInMs(2000);
		click(PagPrincipio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Paginacion 25")
	public ImpresionPage SelectPag() {

		Utilidades.waitInMs(2000);
		click(Pag25);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Ordenar Numero de titulo")
	public ImpresionPage OrdenarNT() {

		Utilidades.waitInMs(2000);
		click(lblNumeroTitulo);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Ordenar NIT")
	public ImpresionPage OrdenarNIT() {

		Utilidades.waitInMs(2000);
		click(lblNit);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Ordenar Nombre/Razon Social")
	public ImpresionPage OrdenaNRS() {

		Utilidades.waitInMs(2000);
		click(lblNombreRazonS);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Ordenar Tipo Bodega")
	public ImpresionPage OrdenaTB() {

		Utilidades.waitInMs(2000);
		click(lblTipoBodega);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Ordenar Tipo Titulo")
	public ImpresionPage OrdenaTT() {

		Utilidades.waitInMs(2000);
		click(lblTipoTitulo);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Ordenar Tipo Mercancia")
	public ImpresionPage OrdenaTM() {

		Utilidades.waitInMs(2000);
		click(lblTipoMercancia);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Ordenar Valor Mercancia")
	public ImpresionPage OrdenaVM() {

		Utilidades.waitInMs(2000);
		click(lblValorMercancia);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Ordenar Estado Titulo")
	public ImpresionPage OrdenaET() {

		Utilidades.waitInMs(2000);
		click(lblEstado);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
//////////////////////////////////////////////////////	
	
	
	
	
	
	@Step("Seleccionar NIT / Nombre o Razón Social")
	public ImpresionPage SeleccionarNitNombreRazonSocial() {

		Utilidades.waitInMs(3000);
		click(SeleccionarNitNombreRazonSocial);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Etiqueta Crear Titulo")
	public ImpresionPage EtiquetaCrearTitulo() {

		Utilidades.waitInMs(3000);

		Actions action = new Actions(driver);
		WebElement element = driver
				.findElement(By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[2]/div/a"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Crear Titulo")
	public ImpresionPage CrearTitulo() {

		Utilidades.waitInMs(3000);
		click(btnCrearTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}*/

}