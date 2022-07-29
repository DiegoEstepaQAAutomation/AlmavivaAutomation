package com.ProgramarVisita.Pages;

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

public class ProgramarVisitasPage extends BasePage {

	By lblVisitas = By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/div/a");
	By lblProgramarVista = By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/div/ul/li[1]/div/a");
	By btnProgramar = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-agenda/div/div[2]/div/button");
	By btnSi = By.xpath("//*[@id=\"contenido\"]/app-index/app-programar-visita/div/table/tbody/tr[1]/td[3]/div/a[1]");
	By lblSeleccionarFecha = By.xpath("/html/body/modal-container/div/div/app-modal-agendar/div/div[2]/form/div/app-calendar/full-calendar/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[5]/td[2]/div");
	By lblSeleccionarFecha1 = By.xpath("/html/body/modal-container/div/div/app-modal-agendar/div/div[2]/form/div/app-calendar/full-calendar/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[4]/td[4]/div");
	By lblSeleccionarFecha2 =By.xpath("/html/body/modal-container/div/div/app-modal-agendar/div/div[2]/form/div/app-calendar/full-calendar/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[4]/td[6]/div");
	By btnCancelar = By.xpath("/html/body/modal-container/div/div/app-modal-agendar/div/div[2]/div/button[2]");
	By btnGuardar = By.xpath("/html/body/modal-container/div/div/app-modal-agendar/div/div[2]/div/button[1]");
	By btnNo = By.xpath("//*[@id=\"contenido\"]/app-index/app-programar-visita/div/table/tbody/tr[1]/td[3]/div/a[2]");
	By btnGuardar1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-programar-visita/div/div[3]/div/button[1]");
	By btnCancelar1 = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
	By btnAceptar = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnCancelar2 = By.xpath("//*[@id=\"contenido\"]/app-index/app-programar-visita/div/div[3]/div/button[2]");
	By btnRegresar = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-agenda/div/div[4]/div/button");
	By btnPaginacion = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-agenda/div/div[3]/div/div/select");
	By selectPag = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-agenda/div/div[3]/div/div/select/option[1]");
	
	By btnCondicionesBodega = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[4]/accordion-group/div/div[1]/div/div/button");
	By btnTitulo = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[5]/accordion-group/div/div[1]/div/div/button");
	By lblDiferenciaValor = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[5]/accordion-group/div/div[2]/div/div[2]/table/thead/tr/th[9]");
	By lblPag5 = By.xpath("//*[@id=\"contenido\"]/app-index/app-consultar-visitas/div/form/accordion[5]/accordion-group/div/div[2]/div/div[3]/div/div/select/option[1]");
	By txtCantidadHallada = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[5]/accordion-group/div/div[2]/div/div[2]/table/tbody/tr/td[6]/input");
	By btnModificacionRegistroVisita = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[1]/accordion-group/div/div[1]/div/div/button");
	By btnInformacionGeneralC1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[2]/accordion-group/div/div[1]/div/div/button");
	By btnInformacionGeneralB1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[3]/accordion-group/div/div[1]/div/div/button");
	By btnCondicionesBodega1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[4]/accordion-group/div/div[1]/div/div/button");
	By btnTitulo1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[5]/accordion-group/div/div[1]/div/div/button");
	By txtCantidadHallada1 = By.xpath("//*[@id=\"contenido\"]/app-index/app-modificar-visitas/div/form/accordion[5]/accordion-group/div/div[2]/div/div[2]/table/tbody/tr/td[6]/input");
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
	By btnSig = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[10]/a");
	By btnAnt = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[2]/a");
	By btnFinal = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[11]/a");
	By btnInicial = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[1]/a");
	
	
	public ProgramarVisitasPage(WebDriver driver) {
		super(driver);
	}
	
	// SCROLL
	/*@Step("Scroll vertibal abajo")
	public ProgramarVisitasPage ScrollAbajo() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertibal abajo")
	public ProgramarVisitasPage ScrollAbajo1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertical arriba")
	public ProgramarVisitasPage ScrollArriba() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Scroll vertical arriba")
	public ProgramarVisitasPage ScrollArriba1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Deslizar Vertical Abajo")
	public ProgramarVisitasPage ScrollAbajo2() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(btnConfirmar);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Deslizar Horizontal a la derecha")
	public ProgramarVisitasPage ScrollDerecha() {
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(lblDiferenciaValor);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Evidencia")
	public ProgramarVisitasPage Evidencias() {

		Utilidades.waitInMs(3000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Visitas")
	public ProgramarVisitasPage Visitas() {

		Utilidades.waitInMs(4000);
		click(lblVisitas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Programar Visita")
	public ProgramarVisitasPage Programar() {

		Utilidades.waitInMs(3000);
		click(lblProgramarVista);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("boton Programar")
	public ProgramarVisitasPage BotonProgramar() {
		
		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnProgramar);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
		click(btnProgramar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Agendar \"Si\"")
	public ProgramarVisitasPage Si() {

		Utilidades.waitInMs(3000);
		click(btnSi);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Fecha para agendar")
	public ProgramarVisitasPage SelectFecha() {

		Utilidades.waitInMs(2500);
		click(lblSeleccionarFecha);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Fecha para agendar")
	public ProgramarVisitasPage SelectFecha1() {

		Utilidades.waitInMs(2500);
		click(lblSeleccionarFecha1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Fecha para agendar")
	public ProgramarVisitasPage SelectFecha2() {

		Utilidades.waitInMs(2500);
		click(lblSeleccionarFecha2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public ProgramarVisitasPage BotonCancelar() {

		Utilidades.waitInMs(3000);
		click(btnCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Guardar")
	public ProgramarVisitasPage Guardar() {

		Utilidades.waitInMs(3000);
		click(btnGuardar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Agendar \"No\"")
	public ProgramarVisitasPage No() {

		Utilidades.waitInMs(3000);
		click(btnNo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Guardar")
	public ProgramarVisitasPage Guardar1() {

		Utilidades.waitInMs(3000);
		click(btnGuardar1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar")
	public ProgramarVisitasPage Aceptar() {

		Utilidades.waitInMs(2500);
		click(btnAceptar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public ProgramarVisitasPage BotonCancelar1() {

		Utilidades.waitInMs(3000);
		click(btnCancelar1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public ProgramarVisitasPage BotonCancelar2() {

		Utilidades.waitInMs(3000);
		click(btnCancelar2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Regresar")
	public ProgramarVisitasPage Regresar() {

		Utilidades.waitInMs(3000);
		click(btnRegresar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Paginacion")
	public ProgramarVisitasPage Paginacion() {

		Utilidades.waitInMs(3000);
		click(btnPaginacion);
		Utilidades.waitInMs(1500);
		click(selectPag);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
//	@Step("Ver Detalles")
//	public ProgramarVisitasPage VerDetalles1() {
//		
//		Utilidades.waitInMs(3000);
//		Actions action = new Actions(driver);
//		WebElement element = driver.findElement(lblVer1);
//		action.moveToElement(element).perform();
//		Utilidades.waitInMs(1000);
//		Utilidades.screenshot();
//		Utilidades.waitInMs(1000);
//		click(lblVer1);
//		Utilidades.waitInMs(2000);
//		Utilidades.screenshot();
//		Utilidades.waitInMs(2000);
//		
//		return this;
//	}
//	
	
	@Step("Seleccionar Condiciones de Bodega")
	public ProgramarVisitasPage CodicionesBodega() {

		Utilidades.waitInMs(3000);
		click(btnCondicionesBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Titulo")
	public ProgramarVisitasPage Titulo() {

		Utilidades.waitInMs(3000);
		click(btnTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Modificacion Registro de Visita")
	public ProgramarVisitasPage ModificacionRegistroVisita() {

		Utilidades.waitInMs(3000);
		click(btnModificacionRegistroVisita);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General del Cliente")
	public ProgramarVisitasPage IGC1() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralC1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Informacion General de la Bodega")
	public ProgramarVisitasPage IGB1() {

		Utilidades.waitInMs(3000);
		click(btnInformacionGeneralB1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Condiciones de Bodega")
	public ProgramarVisitasPage CodicionesBodega1() {

		Utilidades.waitInMs(3000);
		click(btnCondicionesBodega1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Titulo")
	public ProgramarVisitasPage Titulo1() {

		Utilidades.waitInMs(3000);
		click(btnTitulo1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Cantidad Hallada")
	public ProgramarVisitasPage ClearCH() {

		Utilidades.waitInMs(3000);
		clear(txtCantidadHallada1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cantidad Hallada")
	public ProgramarVisitasPage CantidadHallada(String cantidadHallada) {

		Utilidades.waitInMs(3000);
		writeText(txtCantidadHallada1, cantidadHallada);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public ProgramarVisitasPage ClearNombreVisitador() {

		Utilidades.waitInMs(3000);
		clear(NombreVisitador);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public ProgramarVisitasPage ClearDireccionOficina() {

		Utilidades.waitInMs(3000);
		clear(DireccionOficina);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public ProgramarVisitasPage ClearESOA() {

		Utilidades.waitInMs(3000);
		clear(ESOA);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public ProgramarVisitasPage ClearESM() {

		Utilidades.waitInMs(3000);
		clear(ESM);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("")
	public ProgramarVisitasPage ClearEIE() {

		Utilidades.waitInMs(3000);
		clear(EIE);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Terminación de Transito (15 días)")
	public ProgramarVisitasPage SeleccionarNotificaciones15() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones15);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Terminación de Transito (8 días)")
	public ProgramarVisitasPage SeleccionarNotificaciones16() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones16);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Agregar")
	public ProgramarVisitasPage Agregar() {
		
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
	public ProgramarVisitasPage Buscar() {

		Utilidades.waitInMs(3000);
		click(btnBuscar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Asignar")
	public ProgramarVisitasPage BotonAsignar() {

		Utilidades.waitInMs(3000);
		click(btnAsignar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	

	
	@Step("Boton Confirmar")
	public ProgramarVisitasPage BotonConfirmar() {

		Utilidades.waitInMs(3000);
		click(btnConfirmar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	

	

	
	@Step("Scape")
	public ProgramarVisitasPage Scape() {

		Utilidades.waitInMs(1500);
		driver.findElement(btnBuscar).sendKeys(Keys.ESCAPE);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	

	@Step("Consultar")
	public ProgramarVisitasPage Consultar() {

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
	public ProgramarVisitasPage Eliminar() {

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
	public ProgramarVisitasPage Check() {

		Utilidades.waitInMs(3000);
		click(btnCheck);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	

	
	@Step("Paginacion Siguiente")
	public ProgramarVisitasPage Sigiente() {

		Utilidades.waitInMs(1500);
		click(btnSig);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Anterior")
	public ProgramarVisitasPage Anterior() {

		Utilidades.waitInMs(1500);
		click(btnAnt);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Final")
	public ProgramarVisitasPage Final() {

		Utilidades.waitInMs(1500);
		click(btnFinal);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Inicial")
	public ProgramarVisitasPage Inicial() {

		Utilidades.waitInMs(1500);
		click(btnInicial);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	

	@Step("Paginacion del titulo")
	public ProgramarVisitasPage Pag5() {

		Utilidades.waitInMs(1500);
		click(lblPag5);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Regresar")
	public ProgramarVisitasPage BotonRegresar() {

		Utilidades.waitInMs(1500);
		click(btnRegresar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	*/
}