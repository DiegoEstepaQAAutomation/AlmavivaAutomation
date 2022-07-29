package com.ConsultaRegistroVisita.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.demoautomatizacion.Pages.BasePage;

public class CRVisitasPage extends BasePage {

	By lblVisitas = By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/div/a");
	By btnRV = By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/div/ul/li[2]/div/a");
	By txtBuscar = By.id("termino");
	By lblTipo = By.id("tipo");
	By lblVer = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[1]/td[5]/a[1]");
	By lblVer1 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[2]/td[5]/a[1]");
	By lblModificar = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[1]/td[5]/a[2]");
	By lblModificar1 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[2]/td[5]/a[2]/i");
	By lblModificar2 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[10]/td[5]/a[2]");
	By btnRegistroVisita = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[1]/accordion-group/div/div[1]/div/div/button");
	By btnInformacionGeneralC = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[2]/accordion-group/div/div[1]/div/div/button");
	By btnInformacionGeneralB = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[3]/accordion-group/div/div[1]/div/div/button");
	By btnCondicionesBodega = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[4]/accordion-group/div/div[1]/div/div/button");
	By btnTitulo = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[5]/accordion-group/div/div[1]/div/div/button");
	By lblDiferenciaValor = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[5]/accordion-group/div/div[2]/div/div[2]/table/thead/tr/th[9]");
	By lblPag5 = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[5]/accordion-group/div/div[2]/div/div[3]/div/div/select/option[1]");
	By btnRegresar = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/div/div/button");
	By txtCantidadHallada = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[5]/accordion-group/div/div[2]/div/div[2]/table/tbody/tr/td[6]/input");
	By btnModificacionRegistroVisita = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[1]/accordion-group/div/div[1]/div/div/button");
	By btnInformacionGeneralC1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[2]/accordion-group/div/div[1]/div/div/button");
	By btnInformacionGeneralB1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[3]/accordion-group/div/div[1]/div/div/button");
	By btnCondicionesBodega1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[4]/accordion-group/div/div[1]/div/div/button");
	By btnTitulo1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[5]/accordion-group/div/div[1]/div/div/button");
	By txtCantidadHallada1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[5]/accordion-group/div/div[2]/div/div[2]/table/tbody/tr/td[6]/input");
	By btnGuardar = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/div/div/button[1]");
	By btnCancelar = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/div/div/button[2]");
	By btnAceptar = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnCancelar1 = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
	By NombreVisitador = By.id("nombreVisitador");
	By DireccionOficina = By.id("bodeDireccion");
	By ESOA = By.id("estadoSeguridadOrdenAseo");
	By ESM = By.id("estadoSeguridadMercancia");
	By EIE = By.id("estadoInstalacionesElectricas");
	
	public CRVisitasPage(WebDriver driver) {
		super(driver);
	}
	
	// SCROLL
	/*@Step("Scroll vertibal abajo")
	public CRVisitasPage ScrollAbajo() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertibal abajo")
	public CRVisitasPage ScrollAbajo1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertical arriba")
	public CRVisitasPage ScrollArriba() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Scroll vertical arriba")
	public CRVisitasPage ScrollArriba1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Deslizar Horizontal a la derecha")
	public CRVisitasPage ScrollDerecha() {
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(lblDiferenciaValor);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Evidencia")
	public CRVisitasPage Evidencias() {

		Utilidades.waitInMs(3000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Visitas")
	public CRVisitasPage Visitas() {

		Utilidades.waitInMs(4000);
		click(lblVisitas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Registro de Visita")
	public CRVisitasPage RV() {

		Utilidades.waitInMs(3000);
		click(btnRV);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Buscar")
	public CRVisitasPage Buscar(String nit) {

		Utilidades.waitInMs(3000);
		writeText(txtBuscar, nit);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Tipo de busqueda")
	public CRVisitasPage TipoBusqueda() {

		Utilidades.waitInMs(3000);
		click(lblTipo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Ver Detalles")
	public CRVisitasPage VerDetalles() {
		
		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(lblVer);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Boton Ver Detalles")
	public CRVisitasPage Ver1() {

		Utilidades.waitInMs(2500);
		click(lblVer);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Ver Detalles")
	public CRVisitasPage VerDetalles1() {
		
		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(lblVer1);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
		click(lblVer1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Modificar")
	public CRVisitasPage Modificar() {
		
		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(lblModificar);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Boton Modificar")
	public CRVisitasPage Modificar1() {

		Utilidades.waitInMs(3000);
		click(lblModificar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Modificar")
	public CRVisitasPage Modificar2() {
		
		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(lblModificar1);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
		click(lblModificar1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Modificar")
	public CRVisitasPage Modificar3() {
		
		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(lblModificar2);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
		click(lblModificar2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Seleccionar Registro de Visita")
	public CRVisitasPage RegistroVista() {

		Utilidades.waitInMs(3000);
		click(btnRegistroVisita);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General del Cliente")
	public CRVisitasPage IGC() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralC);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General de la Bodega")
	public CRVisitasPage IGB() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralB);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Condiciones de Bodega")
	public CRVisitasPage CodicionesBodega() {

		Utilidades.waitInMs(3000);
		click(btnCondicionesBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Titulo")
	public CRVisitasPage Titulo() {

		Utilidades.waitInMs(3000);
		click(btnTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Modificacion Registro de Visita")
	public CRVisitasPage ModificacionRegistroVisita() {

		Utilidades.waitInMs(3000);
		click(btnModificacionRegistroVisita);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General del Cliente")
	public CRVisitasPage IGC1() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralC1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General de la Bodega")
	public CRVisitasPage IGB1() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralB1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Condiciones de Bodega")
	public CRVisitasPage CodicionesBodega1() {

		Utilidades.waitInMs(3000);
		click(btnCondicionesBodega1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Titulo")
	public CRVisitasPage Titulo1() {

		Utilidades.waitInMs(3000);
		click(btnTitulo1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Cantidad Hallada")
	public CRVisitasPage ClearCH() {

		Utilidades.waitInMs(3000);
		clear(txtCantidadHallada1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cantidad Hallada")
	public CRVisitasPage CantidadHallada(String cantidadHallada) {

		Utilidades.waitInMs(3000);
		writeText(txtCantidadHallada1, cantidadHallada);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Guardar")
	public CRVisitasPage Guardar() {

		Utilidades.waitInMs(3000);
		click(btnGuardar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public CRVisitasPage BotonCancelar() {

		Utilidades.waitInMs(3000);
		click(btnCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar")
	public CRVisitasPage Aceptar() {

		Utilidades.waitInMs(2500);
		click(btnAceptar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public CRVisitasPage BotonCancelar1() {

		Utilidades.waitInMs(3000);
		click(btnCancelar1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public CRVisitasPage ClearNombreVisitador() {

		Utilidades.waitInMs(3000);
		clear(NombreVisitador);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public CRVisitasPage ClearDireccionOficina() {

		Utilidades.waitInMs(3000);
		clear(DireccionOficina);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public CRVisitasPage ClearESOA() {

		Utilidades.waitInMs(3000);
		clear(ESOA);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public CRVisitasPage ClearESM() {

		Utilidades.waitInMs(3000);
		clear(ESM);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public CRVisitasPage ClearEIE() {

		Utilidades.waitInMs(3000);
		clear(EIE);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Regresar")
	public CRVisitasPage Regresar() {

		Utilidades.waitInMs(2500);
		click(btnRegresar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Paginacion del titulo")
	public CRVisitasPage Pag5() {

		Utilidades.waitInMs(1500);
		click(lblPag5);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}*/	

}