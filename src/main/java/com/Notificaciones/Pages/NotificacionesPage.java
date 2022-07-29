package com.Notificaciones.Pages;

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

public class NotificacionesPage extends BasePage {

	By lblNotificaciones = By.xpath("//*[@id=\"sidebar\"]/ul/li[7]/div/a");
	By lblSeguridad = By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/div/a");
	By lblAsignar = By.xpath("//*[@id=\"sidebar\"]/ul/li[7]/div/ul/li/div/a");
	By lblSelectNotificaciones = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[3]");
	By lblSelectNotificaciones1 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[4]");
	By lblSelectNotificaciones2 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[5]");
	By lblSelectNotificaciones3 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[6]");
	By lblSelectNotificaciones4 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[7]");
	By lblSelectNotificaciones5 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[8]");//////////
	By lblSelectNotificaciones6 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[1]");
	By lblSelectNotificaciones7 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[2]");
	By lblSelectNotificaciones8 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[9]");
	By lblSelectNotificaciones9 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[10]");
	By lblSelectNotificaciones10 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[11]");
	By lblSelectNotificaciones11 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[12]");
	By lblSelectNotificaciones12 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[13]");
	By lblSelectNotificaciones13 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[14]");
	By lblSelectNotificaciones14 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[15]");
	By lblSelectNotificaciones15 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[16]");
	By lblSelectNotificaciones16 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[17]");
	By Seleccionar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select");
	By btnAgregar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[3]/div/a");
	By txtNombre = By.id("nombre");
	By btnBuscar = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/button[1]");
	By btnAsignar = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/table/tbody/tr[1]/td[2]/button");
	By btnAsignar1 = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/table/tbody/tr[2]/td[2]/button");
	By btnCancelar = By.xpath("/html/body/modal-container[2]/div/div/app-asignarn-modal/div/div[3]/div/button[2]");
	By btnConfirmar = By.xpath("/html/body/modal-container[2]/div/div/app-asignarn-modal/div/div[3]/div/button[1]");
	By btnAceptar = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnCancelar1 = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
	By btnConsultar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/form/table/tbody/tr[1]/td[5]/a[2]");
	By btnRegresar = By.xpath("/html/body/modal-container/div/div/app-detalles-modal/div/div[3]/button");
	By btnModificar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/form/table/tbody/tr[1]/td[5]/a[3]");
	By btnEditar = By.xpath("/html/body/modal-container/div/div/app-asignarn-modal/div/div[3]/div/button[1]");
	By btnEliminar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/form/table/tbody/tr[4]/td[5]/a[1]");
	By btnCheck = By.xpath("/html/body/modal-container[2]/div/div/app-asignarn-modal/div/div[2]/div[2]/table/tbody/tr/td[3]/div/input");
	By btnPaginacion = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/select");
	By selectPag = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/select/option[1]");
	By btnSig = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[10]/a");
	By btnAnt = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[2]/a");
	By btnFinal = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[11]/a");
	By btnInicial = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[1]/a");
	
	
	
	
	By btnSi = By.id("flexCheckChecked");
	By btnNo = By.id("flexCheckCheckedNo");
	By btnSiMasivo = By.id("flexCheckCheckedSi");
	By btnNoMasivo = By.id("flexCheckCheckedNot");
	By btnOK = By.xpath("/html/body/modal-container/div/div/app-detalleautorizacion/div/div[2]/div[2]/div/button");
	By txtCantidadLiberar=By.id("cantidadLiberar");
	By btnExpedir = By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/div/ul/li[1]/div/a");
	By Criterio = By.id("criterio");
	By CTitulo = By.xpath("//*[@id=\"criterio\"]/option[3]");
	By txtBuscar = By.id("termino");
	By ScrollAccion = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[9]");
	By lblLogAuditoria = By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/div/ul/li[4]/div/a");
	By btnCalendar1 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/div/button");
	By btnAgosto1 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]/option[8]");
	By btnDia1 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month-view/div[6]/div[4]/div");
	By btnCalendar2 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/div/button");
	By btnAgosto2 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]/option[8]");
	By btnDia2 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month-view/div[6]/div[4]/div");
	By btnLupa = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[3]/div/div/div");
	By txtUsuario = By.xpath("/html/body/modal-container/div/div/app-lista-usuarios/div/div[1]/div/div/div[2]/form/div[1]/input");
	By btnSeleccionar = By.xpath("/html/body/modal-container/div/div/app-lista-usuarios/div/div[2]/table/tbody/tr/td[5]/button");
	By btnBuscarLog = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/button[1]");
	By Pag2 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/tabla-paginacion/div/div/div/ngb-pagination/ul/li[4]/a");
	By Pag5 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/tabla-paginacion/div/div/div/ngb-pagination/ul/li[7]/a");
	By lblDescripcion = By.xpath("//*[@id=\"tbLogAuditoria\"]/tbody/tr[10]/td[8]");
	
	
	public NotificacionesPage(WebDriver driver) {
		super(driver);
	}
	
	// SCROLL
	/*@Step("Scroll vertibal abajo")
	public NotificacionesPage ScrollAbajo() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertibal abajo")
	public NotificacionesPage ScrollAbajo1() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Utilidades.waitInMs(1000);

		return this;
	}

	@Step("Scroll vertical arriba")
	public NotificacionesPage ScrollArriba() {

		Utilidades.waitInMs(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Deslizar Vertical Abajo")
	public NotificacionesPage ScrollAbajo2() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(btnConfirmar);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Deslizar Vertical Abajo")
	public NotificacionesPage ScrollAbajo3() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(btnPaginacion);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}
	
	@Step("Deslizar horizontal derecha")
	public NotificacionesPage ScrollDerecha1() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(lblDescripcion);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
	@Step("Evidencia")
	public NotificacionesPage Evidencias() {

		Utilidades.waitInMs(3000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Notificaciones")
	public NotificacionesPage Notificaciones() {

		Utilidades.waitInMs(3000);
		click(lblNotificaciones);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Asignar")
	public NotificacionesPage Asignar() {

		Utilidades.waitInMs(3000);
		click(lblAsignar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Cuadro par seleccionar notificaciones")
	public NotificacionesPage Seleccionar() {

		Utilidades.waitInMs(3000);
		click(Seleccionar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Creacion de Usuario")
	public NotificacionesPage SeleccionarNotificaciones() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Vencimiento de cupo - Alerta Preventiva")
	public NotificacionesPage SeleccionarNotificaciones1() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Vencimiento de cupo - Alerta Correctiva")
	public NotificacionesPage SeleccionarNotificaciones2() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Asignación cupo aprobado")
	public NotificacionesPage SeleccionarNotificaciones3() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones3);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Actualización cupo aprobado")
	public NotificacionesPage SeleccionarNotificaciones4() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones4);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Expedición de Título")
	public NotificacionesPage SeleccionarNotificaciones5() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones5);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Facturación juego prendario")
	public NotificacionesPage SeleccionarNotificaciones6() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones6);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Facturación almacenamiento")
	public NotificacionesPage SeleccionarNotificaciones7() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones7);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Vencimiento de título - Alerta Preventiva")
	public NotificacionesPage SeleccionarNotificaciones8() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones8);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Vencimiento de título - Alerta Correctiva")
	public NotificacionesPage SeleccionarNotificaciones9() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones9);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Vencimiento de póliza - Alerta Preventiva")
	public NotificacionesPage SeleccionarNotificaciones10() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones10);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Vencimiento de póliza - Alerta Correctiva")
	public NotificacionesPage SeleccionarNotificaciones11() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones11);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Liberación total de mercancía – Alerta")
	public NotificacionesPage SeleccionarNotificaciones12() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones12);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Liberación parcial de mercancía – Alerta")
	public NotificacionesPage SeleccionarNotificaciones13() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones13);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Faltante")
	public NotificacionesPage SeleccionarNotificaciones14() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones14);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Terminación de Transito (15 días)")
	public NotificacionesPage SeleccionarNotificaciones15() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones15);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Notificaciones Terminación de Transito (8 días)")
	public NotificacionesPage SeleccionarNotificaciones16() {

		Utilidades.waitInMs(3000);
		click(lblSelectNotificaciones16);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Agregar")
	public NotificacionesPage Agregar() {
		
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

	
	@Step("Buscar Usuario")
	public NotificacionesPage BuscarUsuario(String nombre) {

		Utilidades.waitInMs(3000);
		writeText(txtNombre, nombre);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Buscar")
	public NotificacionesPage Buscar() {

		Utilidades.waitInMs(3000);
		click(btnBuscar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Asignar")
	public NotificacionesPage BotonAsignar() {

		Utilidades.waitInMs(3000);
		click(btnAsignar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Asignar")
	public NotificacionesPage BotonAsignar1() {

		Utilidades.waitInMs(3000);
		click(btnAsignar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public NotificacionesPage BotonCancelar() {

		Utilidades.waitInMs(3000);
		click(btnCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Confirmar")
	public NotificacionesPage BotonConfirmar() {

		Utilidades.waitInMs(3000);
		click(btnConfirmar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar")
	public NotificacionesPage Aceptar() {

		Utilidades.waitInMs(2500);
		click(btnAceptar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Boton Cancelar")
	public NotificacionesPage BotonCancelar1() {

		Utilidades.waitInMs(3000);
		click(btnCancelar1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Scape")
	public NotificacionesPage Scape() {

		Utilidades.waitInMs(1500);
		driver.findElement(btnBuscar).sendKeys(Keys.ESCAPE);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Regresar")
	public NotificacionesPage Regresar() {

		Utilidades.waitInMs(2500);
		click(btnRegresar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Consultar")
	public NotificacionesPage Consultar() {

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
	
	@Step("Modificar")
	public NotificacionesPage Modificar() {

		Utilidades.waitInMs(3000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(btnModificar);
		action.moveToElement(element).perform();
		Utilidades.waitInMs(1500);
		click(btnModificar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Editar")
	public NotificacionesPage Editar() {

		Utilidades.waitInMs(2500);
		click(btnEditar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Eliminar")
	public NotificacionesPage Eliminar() {

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
	public NotificacionesPage Check() {

		Utilidades.waitInMs(3000);
		click(btnCheck);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Paginacion")
	public NotificacionesPage Paginacion() {

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
	public NotificacionesPage Sigiente() {

		Utilidades.waitInMs(1500);
		click(btnSig);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Anterior")
	public NotificacionesPage Anterior() {

		Utilidades.waitInMs(1500);
		click(btnAnt);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Final")
	public NotificacionesPage Final() {

		Utilidades.waitInMs(1500);
		click(btnFinal);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	
	
	@Step("Paginacion Inicial")
	public NotificacionesPage Inicial() {

		Utilidades.waitInMs(1500);
		click(btnInicial);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);
		
		return this;
	}	*/

}