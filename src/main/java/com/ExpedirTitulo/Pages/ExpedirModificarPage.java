package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirModificarPage extends BasePage {

	// MODIFICAR
	By btnModificar = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[1]");
	By btnModificar1 = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[9]/td[9]/div/a[1]");
	By lblInformacionGeneralTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[1]/div/div[1]/div/div/button");
	By lblVerCertificadoDepositoMercancia = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblPlazos = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	By lblPoliza = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[4]/div/div[1]/div/div/button");
	By lblTipoMercancia = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[5]/div/div[1]/div/div/button");
	By lblMercancias = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[1]/div/div/button");
	By lblTarifas = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[7]/div/div[1]/div/div/button");
	By cbxMercanciaTransito = By.xpath("//*[@id=\"mercanciaTransito\"]");
	By btnAceptarMercanciaTransito = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnGuardar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button[1]");
	By btnAceptarGuardarRegistro = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnCancelarGuardarRegistro = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
	By btnAceptarModificacionTipoBodega = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnAceptarRealizarModificacion = By.xpath("/html/body/div/div/div[3]/button[1]");
	By lblVerBonoPrenda = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By btnImprimirGrabado = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[1]/td[9]/div/a[3]");
	By btnImprimirAplicado = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[3]");
	By btnAplicar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button[2]");
	By btnCancelarModificar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button[2]");
	
	public ExpedirModificarPage(WebDriver driver) {
		super(driver);
	}

	// INGRESAR A MODULO MODIFICAR
	/*@Step("Etiqueta Modificar Titulo")
	public ExpedirModificarPage EtiquetaModificarTitulo() {

		Utilidades.waitInMs(3000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[1]/td[9]/div/a[1]"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Deslizar vertical abajo")
	public ExpedirModificarPage Scroll() {

		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Deslizar vertical abajo")
	public ExpedirModificarPage Scroll2() {

		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Deslizar vertical arriba")
	public ExpedirModificarPage ScrollVerticalArriba() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)");
		Utilidades.waitInMs(1000);
		
		return this;
	}

	@Step("Deslizar horizontal derecha")
	public ExpedirModificarPage ScrollDerecha() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Deslizar horizontal derecha")
	public ExpedirModificarPage ScrollDerechaOpcion2() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr[1]/td[9]/div/a[3]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Evidencia")
	public ExpedirModificarPage Evidencia() {
		
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
		
		return this;
	}

	@Step("Clic Modificar Titulo")
	public ExpedirModificarPage ModificarTitulo() {

		Utilidades.waitInMs(3000);
		click(btnModificar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clic Modificar Titulo")
	public ExpedirModificarPage ModificarTitulo1() {

		Utilidades.waitInMs(3000);
		click(btnModificar1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Mercancía en Tránsito")
	public ExpedirModificarPage MercanciaTransito() {

		Utilidades.waitInMs(3000);
		click(cbxMercanciaTransito);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		try {
			js.executeScript("window.scrollBy(0,500)");
		}catch (Exception e) {
			click(btnGuardar);
			Utilidades.waitInMs(2000);
			click(btnAceptarGuardarRegistro);
			Utilidades.waitInMs(2000);
			Utilidades.screenshot();
			Utilidades.waitInMs(3000);
		}
		click(btnGuardar);
		Utilidades.waitInMs(2000);
		click(btnAceptarGuardarRegistro);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Aceptar Mercancía en Tránsito")
	public ExpedirModificarPage AceptarMercanciaTransito() {

		Utilidades.waitInMs(3000);
		click(btnAceptarMercanciaTransito);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Guardar")
	public ExpedirModificarPage Guardar() {

		Utilidades.waitInMs(3000);
		click(btnGuardar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Guardar / Aceptar")
	public ExpedirModificarPage GuardarAceptar() {

		Utilidades.waitInMs(3000);
		click(btnAceptarGuardarRegistro);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Guardar / Cancelar")
	public ExpedirModificarPage GuardarCancelar() {

		Utilidades.waitInMs(3000);
		click(btnCancelarGuardarRegistro);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aplicar")
	public ExpedirModificarPage Aplicar() {

		Utilidades.waitInMs(3000);
		click(btnAplicar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar modificación Tipo de Bodega")
	public ExpedirModificarPage AceptarModificacionTipoBodega() {

		Utilidades.waitInMs(3000);
		click(btnAceptarModificacionTipoBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar - Está seguro de realizar la modificación?")
	public ExpedirModificarPage AceptarSeguroRealizarModificacion() {

		Utilidades.waitInMs(3000);
		click(btnAceptarRealizarModificacion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Desplegar Ver Bono de Prenda")
	public ExpedirModificarPage DesplegarVerBonoPrenda() {

		Utilidades.waitInMs(3000);
		click(lblVerBonoPrenda);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir Grabado")
	public ExpedirModificarPage ImprimirGrabado() {

		Utilidades.waitInMs(3000);
		click(btnImprimirGrabado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Imprimir Aplicado")
	public ExpedirModificarPage ImprimirAplicado() {

		Utilidades.waitInMs(3000);
		click(btnImprimirAplicado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cancelar Modificar")
	public ExpedirModificarPage CancelarModificar() {

		Utilidades.waitInMs(3000);
		click(btnCancelarModificar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}*/
}