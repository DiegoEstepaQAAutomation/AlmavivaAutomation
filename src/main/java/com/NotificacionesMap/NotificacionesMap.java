package com.NotificacionesMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class NotificacionesMap  extends BasePage { 
	
	
	
	
	public NotificacionesMap(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//*[@id="contenido"]/app-asignar-notificacion/div/div[3]/div/a
	
	//*[@id="contenido"]/app-asignar-notificacion/div/div[2]/select
	
	protected By lblModificarHistorico = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	protected By btnAgregarNuevo = By.xpath("//*[@id='contenido']/app-asignar-notificacion/div/div[3]/div/a");
	protected By txtNitRazonSocial = By.id("termino");
	
	
	protected By lblNotificaciones2 = By.xpath("//*[@id='contenido']/app-asignar-notificacion/div/div[2]/select");
	protected By lblNotificaciones = By.xpath("//*[@id='sidebar']/ul/li[7]/div/a");
	protected By txtBuscarNuevaNotificacion = By.xpath("//*[@id='nombre']");
	protected By btnBuscarUsusarioNotificacion = By.xpath("//body/modal-container/div/div/app-asignar-modal/div/form/button[1]");
	protected By btnAsignarA = By.xpath("//body/modal-container/div/div/app-asignar-modal/div/form/table/tbody/tr[1]/td[2]/button");
	protected By chxAsignacion = By.xpath("//body/modal-container[2]/div/div/app-asignarn-modal/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/div/input"); //el primer tr al cambiarlo se desplaza de un checkbox a otro
	protected By btnConfirm = By.xpath("//body/modal-container[2]/div/div/app-asignarn-modal/div/div[3]/div/button[1]"); //cambiar a uno
	protected By alertaLiberacion = By.xpath("//*[@id='toast-container']");
	
	
	protected By btnConfirmAcept = By.xpath("//body/div[2]/div/div[3]/button[1]");
	
	protected By lblModulos = By.xpath("//*[@id='sidebar']/ul/li/div/a[contains(text(),'{0}')]");
	protected By lblsecciones = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[(text()='{0}')]");
	protected By BuscarTitulo = By.xpath("//body/app-root/div/div/div/main-titulos/titulos-home/div/form/div[2]/input");
	protected By ModificartituloLiberado = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	protected By ModificarCupo = By.xpath("//*[@id='tbClientes']/tbody/tr/td[7]/div/a");
	
	
	protected By btnCriterio = By.xpath("//*[@id='criterio']");
	protected By GridCupo = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/thead/tr");
	protected By TituloModulo = By.xpath("//*[@id='sidebar']/ul/li[4]/div/a");
	protected By SeccionModuloExpedir = By.xpath("//*[@id='sidebar']/ul/li[4]/div/ul/li[1]/div/a");
	protected By DaysBox = By.xpath("//*[@id='Propia_modalidadCupo_0']");
	protected By GridTitulo = By.xpath("//*[@id='tbClientes']/tbody/tr");
	
	
	
	
	
	protected By lblSeguridad = By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/div/a");
	protected By lblAsignar = By.xpath("//*[@id=\"sidebar\"]/ul/li[7]/div/ul/li/div/a");
	protected By lblSelectNotificaciones = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[3]");
	protected By lblSelectNotificaciones1 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[4]");
	protected By lblSelectNotificaciones2 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[5]");
	protected By lblSelectNotificaciones3 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[6]");
	protected By lblSelectNotificaciones4 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[7]");
	protected By lblSelectNotificaciones5 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[8]");//////////
	protected By lblSelectNotificaciones6 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[1]");
	protected By lblSelectNotificaciones7 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[2]");
	protected By lblSelectNotificaciones8 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[9]");
	protected By lblSelectNotificaciones9 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[10]");
	protected By lblSelectNotificaciones10 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[11]");
	protected By lblSelectNotificaciones11 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[12]");
	protected By lblSelectNotificaciones12 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[13]");
	protected By lblSelectNotificaciones13 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[14]");
	protected By lblSelectNotificaciones14 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[15]");
	protected By lblSelectNotificaciones15 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[16]");
	protected By lblSelectNotificaciones16 = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select/option[17]");
	protected By Seleccionar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[2]/select");
	protected By btnAgregar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/div[3]/div/a");
	protected By txtNombre = By.id("nombre");
	protected By btnBuscar = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/button[1]");
	protected By btnAsignar = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/table/tbody/tr[1]/td[2]/button");
	protected By btnAsignar1 = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/table/tbody/tr[2]/td[2]/button");
	protected By btnCancelar = By.xpath("/html/body/modal-container[2]/div/div/app-asignarn-modal/div/div[3]/div/button[2]");
	protected By btnConfirmar = By.xpath("/html/body/modal-container[2]/div/div/app-asignarn-modal/div/div[3]/div/button[1]");
	protected By btnAceptar = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	protected By btnCancelar1 = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
	protected By btnConsultar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/form/table/tbody/tr[1]/td[5]/a[2]");
	protected By btnRegresar = By.xpath("/html/body/modal-container/div/div/app-detalles-modal/div/div[3]/button");
	protected By btnModificar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/form/table/tbody/tr[1]/td[5]/a[3]");
	protected By btnEditar = By.xpath("/html/body/modal-container/div/div/app-asignarn-modal/div/div[3]/div/button[1]");
	protected By btnEliminar = By.xpath("//*[@id=\"contenido\"]/app-asignar-notificacion/div/form/table/tbody/tr[4]/td[5]/a[1]");
	protected By btnCheck = By.xpath("/html/body/modal-container[2]/div/div/app-asignarn-modal/div/div[2]/div[2]/table/tbody/tr/td[3]/div/input");
	protected By btnPaginacion = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/select");
	protected By selectPag = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/select/option[1]");
	protected By btnSig = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[10]/a");
	protected By btnAnt = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[2]/a");
	protected By btnFinal = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[11]/a");
	protected By btnInicial = By.xpath("/html/body/modal-container/div/div/app-asignar-modal/div/form/tabla-paginacion/div/div/div/ngb-pagination/ul/li[1]/a");
	
	
	
	
	protected By btnSi = By.id("flexCheckChecked");
	protected By btnNo = By.id("flexCheckCheckedNo");
	protected By btnSiMasivo = By.id("flexCheckCheckedSi");
	protected By btnNoMasivo = By.id("flexCheckCheckedNot");
	protected By btnOK = By.xpath("/html/body/modal-container/div/div/app-detalleautorizacion/div/div[2]/div[2]/div/button");
	protected By txtCantidadLiberar=By.id("cantidadLiberar");
	protected By btnExpedir = By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/div/ul/li[1]/div/a");
	protected By Criterio = By.id("criterio");
	
	protected By CTitulo = By.xpath("//*[@id='criterio']/option[3]");
	
	protected By BTitulo = By.xpath("//*[@id='nombre']");
	
	//*[@id="nombre"]
	protected By txtBuscar = By.id("termino");
	protected By ScrollAccion = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[9]");
	protected By lblLogAuditoria = By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/div/ul/li[4]/div/a");
	protected By btnCalendar1 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/div/button");
	protected By btnAgosto1 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]/option[8]");
	protected By btnDia1 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month-view/div[6]/div[4]/div");
	protected By btnCalendar2 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/div/button");
	protected By btnAgosto2 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]/option[8]");
	protected By btnDia2 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month-view/div[6]/div[4]/div");
	protected By btnLupa = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[3]/div/div/div");
	protected By txtUsuario = By.xpath("/html/body/modal-container/div/div/app-lista-usuarios/div/div[1]/div/div/div[2]/form/div[1]/input");
	protected By btnSeleccionar = By.xpath("/html/body/modal-container/div/div/app-lista-usuarios/div/div[2]/table/tbody/tr/td[5]/button");
	protected By btnBuscarLog = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/button[1]");
	protected By Pag2 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/tabla-paginacion/div/div/div/ngb-pagination/ul/li[4]/a");
	protected By Pag5 = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/tabla-paginacion/div/div/div/ngb-pagination/ul/li[7]/a");
	protected By lblDescripcion = By.xpath("//*[@id=\"tbLogAuditoria\"]/tbody/tr[10]/td[8]");
	

}
