package com.Visitas.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class ConsultarRegistroVisitaMap extends BasePage {

	public ConsultarRegistroVisitaMap(WebDriver driver) {
		super(driver);
	}

	protected By btnCrearRegistrarVisita = By.xpath("//*[@id='contenido']/app-index/app-consultar-visita/div/div[2]/div/a");
	protected By btnAccion = By.xpath("//*[@id='contenido']/app-index/app-registrar-visita/div/div/table/tbody/tr[1]/td/a");
	protected By lblOpciones = By.xpath("//app-registrar-visitas/div/form/accordion/accordion-group/div/div/div/div/button[contains(text(),'{0}')]");
	protected By txtNombreCliente = By.id("clieRazonSocial");
	protected By txtNitCliente = By.id("clieNitDisabled");
	protected By txtFechaVisita = By.id("fechaVisita");
	protected By txtNombreVisitador = By.id("nombreVisitador");
	protected By lblTomaAnalsisCalidad = By.xpath("//*[@formcontrolname='tomaAnalisisDeCalidad']");
	protected By lblPesajeAleatorio = By.xpath("//*[@formcontrolname='pesajeAleatorio']");
	protected By lblTomaRegistroFotografico = By.xpath("//*[@formcontrolname='tomaRegistroFotografico']");
	protected By lblAcompanamientoDirector = By.xpath("//*[@formcontrolname='acompanamientoDirector']");
	protected By txtEstadoSeguridadOA = By.id("estadoSeguridadOrdenAseo");
	protected By txtEstadoSeguridadMercancia = By.id("estadoSeguridadMercancia");
	protected By txtEstadoInstalacionesElectricas = By.id("estadoInstalacionesElectricas");
	protected By btnCancelarConsultarRegistroVisita = By.xpath("//*[@id='contenido']/app-index/app-registrar-visitas/div/form/div/div/button[contains(text(),'Cancelar')]");
	protected By lblRegistrarVisita = By.xpath("//*[@id='contenido']/app-index/app-registrar-visita/div/div/div/h5");
}
