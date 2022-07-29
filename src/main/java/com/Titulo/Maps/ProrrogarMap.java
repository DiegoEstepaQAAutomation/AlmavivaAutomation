package com.Titulo.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class ProrrogarMap extends BasePage {

	public ProrrogarMap(WebDriver driver) {
		super(driver);
	}

	protected By lblTitulo = By.xpath("//*[@id='sidebar']/ul/li[4]/div/a");
	protected By lblSeguridad = By.xpath("//*[@id='sidebar']/ul/li[1]/div/a");
	protected By lblProrrogar = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[contains(text(),'Prorrogar')]");

	protected By txtCodigoTitulo = By.id("titulo");

	protected By texttitulo = By.xpath("//*[@id='titulo']");

	// *[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[1]/div/div[1]/div/div/button

	protected By SeleccionarCodigoTitulo = By.cssSelector("#ngb-typeahead-0-0 > .ng-star-inserted");
	protected By lblInformacionBasicaTitulo = By.xpath(
			"//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[1]/div/div[1]/div/div/button");
	protected By lblBonoPrenda = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	protected By txtplazoDeposito = By.id("plazoDeposito");
	protected By txtplazoCredito = By.id("plazoCredito");
	protected By txtplazoCertificado = By.id("plazoCertificado");
	protected By btnGuardar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-prorroga/div/div[2]/div/button[1]");
	protected By btnAceptar = By.xpath("/html/body/div[3]/div/div[3]/button[1]");
	protected By btnCancelar1 = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	protected By btnCancelar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-prorroga/div/div[2]/div/button[2]");
	protected By Pag2 = By.xpath(
			"/html/body/app-root/div/div/div/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/div/div/ngb-pagination/ul/li[5]/a");
	protected By PrimeraPag = By.xpath(
			"/html/body/app-root/div/div/div/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/div/div/ngb-pagination/ul/li[1]/a");
	protected By FilasPag = By.xpath(
			"//*[@id=\"contenido\"]/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/div/div/select");
	protected By Filas1 = By.xpath(
			"//*[@id=\"contenido\"]/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/div/div/select/option[1]");
	protected By lblCDM = By.xpath(
			"//*[@id=\"contenido\"]/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	protected By btnPagina5 = By.xpath(
			"//*[@id=\"contenido\"]/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/div/div/select/option[1]");
	protected By btnFinal = By.xpath(
			"//*[@id=\"contenido\"]/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/div/div/ngb-pagination/ul/li[6]/a");
	protected By btnInicial = By.xpath(
			"//*[@id=\"contenido\"]/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/div/div/ngb-pagination/ul/li[1]/a");

	// PRORROGA VALIDACIONES

	protected By lblNit = By.xpath("//*[@id='nit']");
	protected By lblRazonSocial = By.xpath("//*[@id='nombreRazonSocial']");
	protected By lblDireccion = By.xpath("//*[@id='direccion']");
	protected By lblCiudad = By.xpath("//*[@id='ciudad']");
	protected By lblFechaExpedicion = By.xpath("//*[@id='fechaExpedicion']");
	protected By lblOficinaExpedicion = By.xpath("//*[@id='oficinaExpedicion']");
	protected By lblTipoBodega = By.xpath("//*[@id='tipoBodega']");
	protected By OptionDetalleMercancia = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	protected By lblValorInicial = By.xpath("//*[@id='valorInicialCredito']");
	protected By lblMercanciaInicial = By.xpath("//*[@id='mercanciaInicial']");
	protected By lblValorMercanciaTitulo = By.xpath("//*[@id='valorInicialMercancia']");
	protected By lblSaldo = By.xpath("//*[@id='valorSaldoMercancia']");
	protected By lblrelacionCredito = By.xpath("//*[@id='relacionCreditoMercancia']");
	protected By lblSaldoCredito = By.xpath("//*[@id='saldoCredito']");
	protected By lblSaldoTitulo = By.xpath("//*[@id='saldoTitulo']");
	protected By lblLiberacionesEjecutadas = By.xpath("//*[@id='totalLiberacionesEjecutadas']");
	protected By CertificadoDepositoMercancia = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	protected By lblPlazoDeposito = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[3]/div/div[2]/div/form/div[2]/div[3]/div");
	protected By lblNuevaFecha = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[3]/div/div[2]/div/form/div[3]/div[3]/div");
	protected By btnGuardarProrroga = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/div[2]/div/button[1] ");
	protected By btnCancelarProrroga = By.xpath("//body/div[3]/div/div[3]/button[2]");

	protected By NumberProrroga = By.xpath("//*[@id='tbClientes']/tbody/tr[10]/td[1]");
	
	protected By txtNitCargue = By.xpath("//*[@id='termino']");
	
	protected By lblModificarHistorico = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	
	protected By NumberProrrogaValida = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]");
	
	protected By lblBusquedaProrroga = By.xpath("//form/div/div/ngb-typeahead-window/button");

	// OTROS
	
	

	protected By btnExpedir = By.xpath("//*[@id=\"sidebar\"]/ul/li[4]/div/ul/li[1]/div/a");
	protected By Criterio = By.id("criterio");
	protected By CTitulo = By.xpath("//*[@id=\"criterio\"]/option[3]");
	protected By txtBuscar = By.id("termino");
	protected By btnBuscar = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/form/button[1]");
	protected By ScrollAccion = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[9]");
	protected By lblLogAuditoria = By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/div/ul/li[4]/div/a");
	protected By btnCalendar1 = By
			.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/div/button");
	protected By btnAgosto1 = By.xpath(
			"//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]/option[8]");
	protected By btnDia1 = By.xpath(
			"//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[1]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month-view/div[6]/div[4]/div");
	protected By btnCalendar2 = By
			.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/div/button");
	protected By btnAgosto2 = By.xpath(
			"// *[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]/option[8]");
	protected By btnDia2 = By.xpath(
			"//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[2]/div/ngb-datepicker/div[2]/div/ngb-datepicker-month-view/div[6]/div[4]/div");
	protected By btnLupa = By
			.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/div/div[3]/div/div/div");
	protected By txtUsuario = By
			.xpath("/html/body/modal-container/div/div/app-lista-usuarios/div/div[1]/div/div/div[2]/form/div[1]/input");
	protected By btnSeleccionar = By
			.xpath("/html/body/modal-container/div/div/app-lista-usuarios/div/div[2]/table/tbody/tr/td[5]/button");
	protected By btnBuscarLog = By.xpath("//*[@id=\"contenido\"]/app-main/logauditoria-home/div/form/button[1]");
	protected By Pag5 = By.xpath(
			"//*[@id=\"contenido\"]/app-main/logauditoria-home/div/tabla-paginacion/div/div/div/ngb-pagination/ul/li[7]/a");
	protected By lblDescripcion = By.xpath("//*[@id=\"tbLogAuditoria\"]/tbody/tr[10]/td[8]");

	// CREAR
	protected By a = By.id("");
}
