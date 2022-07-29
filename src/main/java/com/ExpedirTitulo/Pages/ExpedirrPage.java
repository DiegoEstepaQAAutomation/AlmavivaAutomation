package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirrPage extends BasePage {

	// TITULO OPCIONES MENU
	By btnTitulo = By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/div/a");
	By btnExpedir = By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/div/ul/li[1]/div/a");

	// PRIMERAS OPCIONES
	By btnCrearTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[2]/div/a");
	By ListaNitNombreRazonSocial = By.xpath("//*[@id=\"criterio\"]");
	By lblNIT = By.xpath("//*[@id=\"criterio\"]/option[1]");
	By lblNombreRazonSocial = By.xpath("//*[@id=\"criterio\"]/option[2]");
	By lblTitulo = By.xpath("//*[@id=\"criterio\"]/option[3]");
	By lblFecha = By.xpath("//*[@id=\"criterio\"]/option[4]");
	By txtIngreseNitNombreRazonSocial = By.id("termino");
	By SeleccionarNitNombreRazonSocial = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/busqueda-cliente/form/div[2]/ngb-typeahead-window/button");
	By btnCancelarCrear = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button[3]");
	By btnGuardarCrear = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button[1]");
	By btnOkDatosEntrada = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnAceptar = By.xpath("/html/body/div[3]/div/div[3]/button[1]");
	By btnCancelarOpcion2 = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	By btnUltimaPaginacion = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[11]/a");
	By btnSiguientePaginacion = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[10]/a");
	By btnAnteriorPaginacion = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[2]/a");
	By btnPrimeraPaginacion = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[1]/a");
	By btnFilasPag = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/select");
	By btn5Filas = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/select/option[1]");
	By InformacionG = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[1]/div/div[1]");
	By VCDM = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]");
	By Plazos = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[3]/div/div[1]");
	By Poliza = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[4]/div/div[1]");
	By tipoMercancia = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[5]/div/div[1]");
	By Mercancias = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[1]");
	By Tarifas = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[7]/div/div[1]");
	
	

	public ExpedirrPage(WebDriver driver) {
		super(driver);
	}

	// SCROLL
	/*@Step("Scroll vertibal abajo")
	public ExpedirPage ScrollAbajo() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertibal abajo")
	public ExpedirPage ScrollAbajo1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertical arriba")
	public ExpedirPage ScrollArriba() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Evidencia")
	public ExpedirPage Evidencia() {

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}

	// INGRESAR A MODULO TITULO / EXPEDIR
	@Step("Ingresar al modulo Titulo")
	public ExpedirPage Titulo() {

		Utilidades.waitInMs(3000);
		click(btnTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Ingresar al Sub modulo Expedir")
	public ExpedirPage Expedir() {

		Utilidades.waitInMs(3000);
		click(btnExpedir);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	// PRIMERAS OPCIONES
	@Step("Etiqueta Crear Titulo")
	public ExpedirPage EtiquetaCrearTitulo() {

		Utilidades.waitInMs(3000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[2]/div/a"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Crear Titulo")
	public ExpedirPage CrearTitulo() {

		Utilidades.waitInMs(3000);
		click(btnCrearTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar NIT")
	public ExpedirPage SeleccionarNIT() {

		Utilidades.waitInMs(3000);
		click(lblNIT);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Nombre / Razón Social")
	public ExpedirPage SeleccionarNombreRazonSocial() {

		Utilidades.waitInMs(3000);
		click(lblNombreRazonSocial);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Filtro de busqueda NIT / Nombre/Razón Social")
	public ExpedirPage IngreseNitNombreRazonSocial(String nit) {

		Utilidades.waitInMs(3000);
		writeText(txtIngreseNitNombreRazonSocial, nit);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clear filtro de busqueda NIT / Nombre / Razón Social")
	public ExpedirPage ClearIngreseNitNombreRazonSocial() {

		Utilidades.waitInMs(1000);
		clear(txtIngreseNitNombreRazonSocial);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Seleccionar NIT / Nombre o Razón Social")
	public ExpedirPage SeleccionarNitNombreRazonSocial() {

		Utilidades.waitInMs(3000);
		click(SeleccionarNitNombreRazonSocial);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Guardar crear")
	public ExpedirPage GuardarCrear() {

		Utilidades.waitInMs(3000);
		click(btnGuardarCrear);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Cancelar crear")
	public ExpedirPage CancelarCrear() {

		Utilidades.waitInMs(3000);
		click(btnCancelarCrear);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Ok 'Faltan datos de entrada'")
	public ExpedirPage OkFalanDatosEntrada() {

		Utilidades.waitInMs(3000);
		click(btnOkDatosEntrada);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Aceptar")
	public ExpedirPage Aceptar() {

		Utilidades.waitInMs(3000);
		click(btnAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(500);

		return this;
	}

	@Step("Cancelar opción 2")
	public ExpedirPage CancelarOpcion2() {

		Utilidades.waitInMs(3000);
		click(btnCancelarOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Siguiente Paginacion")
	public ExpedirPage SiguientePag() {

		Utilidades.waitInMs(3000);
		click(btnSiguientePaginacion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Anterior Paginacion")
	public ExpedirPage AnteriorPag() {

		Utilidades.waitInMs(3000);
		click(btnAnteriorPaginacion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Ultima Paginacion")
	public ExpedirPage UltimaPag() {

		Utilidades.waitInMs(3000);
		click(btnUltimaPaginacion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Primera Paginacion")
	public ExpedirPage PrimeraPag() {

		Utilidades.waitInMs(3000);
		click(btnPrimeraPaginacion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Filas de Paginacion")
	public ExpedirPage FilasPag() {

		Utilidades.waitInMs(3000);
		click(btnFilasPag);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
		click(btn5Filas);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Informacion General del Titulo")
	public ExpedirPage IGT() {

		Utilidades.waitInMs(3000);
		click(InformacionG);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("VCDM")
	public ExpedirPage VCDM() {

		Utilidades.waitInMs(3000);
		click(VCDM);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Plazos")
	public ExpedirPage Plazos() {

		Utilidades.waitInMs(3000);
		click(Plazos);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Poliza")
	public ExpedirPage Poliza() {

		Utilidades.waitInMs(3000);
		click(Poliza);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	
	@Step("Tipo de Mercancia")
	public ExpedirPage TipoMercancia() {

		Utilidades.waitInMs(3000);
		click(tipoMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Mercancia")
	public ExpedirPage Mercancia() {

		Utilidades.waitInMs(3000);
		click(Mercancias);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Tarifa")
	public ExpedirPage Tarifa() {

		Utilidades.waitInMs(3000);
		click(Tarifas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}*/
}