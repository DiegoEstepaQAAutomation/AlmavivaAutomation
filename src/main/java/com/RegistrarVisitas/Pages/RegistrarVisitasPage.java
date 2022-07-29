package com.RegistrarVisitas.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.ExpedirTitulo.Pages.ExpedirrPage;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class RegistrarVisitasPage extends BasePage {

	By lblVisitas = By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/div/a");
	By btnRV = By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/div/ul/li[2]/div/a");
	By btnRegistrarV = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visita/div/div[2]/div/a");
	By txtBuscar = By.id("termino");
	By lblTipo = By.id("//*[@id=\"contenido\"]/app-index/app-registrar-visita/div/form/div[1]/select");
	By lblCliente1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-registrar-visita/div/form/div[1]/select/option[3]");
	By lblCliente2 = By.xpath("//*[@id=\"contenido\"]/app-index/app-registrar-visita/div/form/div[1]/select/option[2]");
	By lblBodegas = By.xpath("//*[@id=\"contenido\"]/app-index/app-registrar-visita/div/form/div[1]/select/option[1]");
	
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
	
	By lblSelectNotificaciones15 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[16]");
	By lblSelectNotificaciones16 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[17]");
	By Seleccionar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select");
	By btnAgregar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[3]/div/a");
	By txtNombre = By.id("nombre");
	By btnBuscar = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/button[1]");
	By btnAsignar = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/table/tbody/tr[1]/td[2]/button");
	By btnConfirmar = By.xpath("/html/body/modal-container[2]/div/div/app-asignarn-modal/div/div[3]/div/button[1]");
	
	
	By btnConsultar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/form/table/tbody/tr[1]/td[5]/a[2]");
	By btnEditar = By.xpath("/html/body/modal-container/div/div/app-asignarn-modal/div/div[3]/div/button[1]");
	By btnEliminar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/form/table/tbody/tr[4]/td[5]/a[1]");
	By btnCheck = By.xpath("/html/body/modal-container[2]/div/div/app-asignarn-modal/div/div[2]/div[2]/table/tbody/tr/td[3]/div/input");
	By btnPaginacion = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/select");
	By selectPag = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/select/option[1]");
	By btnSig = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[10]/a");
	By btnAnt = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[2]/a");
	By btnFinal = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[11]/a");
	By btnInicial = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[1]/a");
	
	
	public RegistrarVisitasPage(WebDriver driver) {
		super(driver);
	}
	
	// SCROLL
	/*@Step("Scroll vertibal abajo")
	public RegistrarVisitasPage ScrollAbajo() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertibal abajo")
	public RegistrarVisitasPage ScrollAbajo1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertical arriba")
	public RegistrarVisitasPage ScrollArriba() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Scroll vertical arriba")
	public RegistrarVisitasPage ScrollArriba1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Deslizar Vertical Abajo")
	public RegistrarVisitasPage ScrollAbajo2() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(btnConfirmar);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Deslizar Horizontal a la derecha")
	public RegistrarVisitasPage ScrollDerecha() {
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(lblDiferenciaValor);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Evidencia")
	public RegistrarVisitasPage Evidencias() {

		Utilidades.waitInMs(3000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Visitas")
	public RegistrarVisitasPage Visitas() {

		Utilidades.waitInMs(4000);
		click(lblVisitas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Registro de Visita")
	public RegistrarVisitasPage RV() {

		Utilidades.waitInMs(3000);
		click(btnRV);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Registrar Visita")
	public RegistrarVisitasPage RegistrarV() {
		
		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnRegistrarV);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Boton Registrar Visita")
	public RegistrarVisitasPage BotonRegistrarV() {

		Utilidades.waitInMs(3000);
		click(btnRegistrarV);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Buscar")
	public RegistrarVisitasPage Buscar(String nit) {

		Utilidades.waitInMs(3000);
		writeText(txtBuscar, nit);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Tipo de busqueda")
	public RegistrarVisitasPage TipoBusqueda() {

		Utilidades.waitInMs(3000);
		click(lblTipo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Modificar")
	public RegistrarVisitasPage Modificar2() {
		
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
	public RegistrarVisitasPage Modificar3() {
		
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
	public RegistrarVisitasPage RegistroVista() {

		Utilidades.waitInMs(3000);
		click(btnRegistroVisita);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General del Cliente")
	public RegistrarVisitasPage IGC() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralC);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General de la Bodega")
	public RegistrarVisitasPage IGB() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralB);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Condiciones de Bodega")
	public RegistrarVisitasPage CodicionesBodega() {

		Utilidades.waitInMs(3000);
		click(btnCondicionesBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Titulo")
	public RegistrarVisitasPage Titulo() {

		Utilidades.waitInMs(3000);
		click(btnTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Modificacion Registro de Visita")
	public RegistrarVisitasPage ModificacionRegistroVisita() {

		Utilidades.waitInMs(3000);
		click(btnModificacionRegistroVisita);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General del Cliente")
	public RegistrarVisitasPage IGC1() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralC1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General de la Bodega")
	public RegistrarVisitasPage IGB1() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralB1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Condiciones de Bodega")
	public RegistrarVisitasPage CodicionesBodega1() {

		Utilidades.waitInMs(3000);
		click(btnCondicionesBodega1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Titulo")
	public RegistrarVisitasPage Titulo1() {

		Utilidades.waitInMs(3000);
		click(btnTitulo1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Cantidad Hallada")
	public RegistrarVisitasPage ClearCH() {

		Utilidades.waitInMs(3000);
		clear(txtCantidadHallada1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cantidad Hallada")
	public RegistrarVisitasPage CantidadHallada(String cantidadHallada) {

		Utilidades.waitInMs(3000);
		writeText(txtCantidadHallada1, cantidadHallada);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Guardar")
	public RegistrarVisitasPage Guardar() {

		Utilidades.waitInMs(3000);
		click(btnGuardar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public RegistrarVisitasPage BotonCancelar() {

		Utilidades.waitInMs(3000);
		click(btnCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar")
	public RegistrarVisitasPage Aceptar() {

		Utilidades.waitInMs(2500);
		click(btnAceptar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public RegistrarVisitasPage BotonCancelar1() {

		Utilidades.waitInMs(3000);
		click(btnCancelar1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public RegistrarVisitasPage ClearNombreVisitador() {

		Utilidades.waitInMs(3000);
		clear(NombreVisitador);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public RegistrarVisitasPage ClearDireccionOficina() {

		Utilidades.waitInMs(3000);
		clear(DireccionOficina);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public RegistrarVisitasPage ClearESOA() {

		Utilidades.waitInMs(3000);
		clear(ESOA);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public RegistrarVisitasPage ClearESM() {

		Utilidades.waitInMs(3000);
		clear(ESM);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public RegistrarVisitasPage ClearEIE() {

		Utilidades.waitInMs(3000);
		clear(EIE);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Terminación de Transito (15 días)")
	public RegistrarVisitasPage SeleccionarNotificaciones15() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones15);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Terminación de Transito (8 días)")
	public RegistrarVisitasPage SeleccionarNotificaciones16() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones16);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Agregar")
	public RegistrarVisitasPage Agregar() {
		
		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnAgregar);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(1500);
		click(btnAgregar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Buscar")
	public RegistrarVisitasPage Buscar() {

		Utilidades.waitInMs(3000);
		click(btnBuscar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Asignar")
	public RegistrarVisitasPage BotonAsignar() {

		Utilidades.waitInMs(3000);
		click(btnAsignar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	

	
	@Step("Boton Confirmar")
	public RegistrarVisitasPage BotonConfirmar() {

		Utilidades.waitInMs(3000);
		click(btnConfirmar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	

	

	
	@Step("Scape")
	public RegistrarVisitasPage Scape() {

		Utilidades.waitInMs(1500);
		driver.findElement(btnBuscar).sendKeys(Keys.ESCAPE);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Regresar")
	public RegistrarVisitasPage Regresar() {

		Utilidades.waitInMs(2500);
		click(btnRegresar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Consultar")
	public RegistrarVisitasPage Consultar() {

		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnConsultar);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(1500);
		click(btnConsultar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	
	@Step("Eliminar")
	public RegistrarVisitasPage Eliminar() {

		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnEliminar);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(1500);
		click(btnEliminar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Check")
	public RegistrarVisitasPage Check() {

		Utilidades.waitInMs(3000);
		click(btnCheck);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Paginacion")
	public RegistrarVisitasPage Paginacion() {

		Utilidades.waitInMs(3000);
		click(btnPaginacion);
		Utilidades.waitInMs(1500);
		click(selectPag);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Paginacion Siguiente")
	public RegistrarVisitasPage Sigiente() {

		Utilidades.waitInMs(1500);
		click(btnSig);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Anterior")
	public RegistrarVisitasPage Anterior() {

		Utilidades.waitInMs(1500);
		click(btnAnt);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Final")
	public RegistrarVisitasPage Final() {

		Utilidades.waitInMs(1500);
		click(btnFinal);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Inicial")
	public RegistrarVisitasPage Inicial() {

		Utilidades.waitInMs(1500);
		click(btnInicial);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	

	@Step("Paginacion del titulo")
	public RegistrarVisitasPage Pag5() {

		Utilidades.waitInMs(1500);
		click(lblPag5);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Regresar")
	public RegistrarVisitasPage BotonRegresar() {

		Utilidades.waitInMs(1500);
		click(btnRegresar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	*/
}