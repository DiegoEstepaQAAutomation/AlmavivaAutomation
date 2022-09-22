package com.Cliente.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class CupoMap extends BasePage {

	public CupoMap(WebDriver driver) {
		super(driver);
	}

	// CREAR
	protected By btnCrearCupo = By.xpath("//*[@id='contenido']/app-main/cupo-home/div/div/div/a");
	protected By txtNit = By.xpath("//*[@formcontrolname='termino']");
	protected By btnCupo = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div/form/div/button");
	protected By lblCupoAlternativo = By.id("cupoAlternativo");
	protected By ModalidadesDeCupo = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[3]/div/div/h5");
	
	// Modalidades de cupo
	// Propia
	protected By txtCupoAPropia = By.id("Propia_aprobado_0");
	protected By txtFechaAPropia = By.id("Propia_fechaAprobacion_0");
	protected By txtDiasCAPropia = By.id("Propia_modalidadCupo_0");
	protected By txtNumeroAPropia = By.id("Propia_acta_0");
	
	// Particular
	protected By txtCupoAParticular = By.id("Particular_aprobado_1");
	protected By txtFechaAParticular = By.id("Particular_fechaAprobacion_1");
	protected By txtDiasCAParticular = By.id("Particular_modalidadCupo_1");
	protected By txtNumeroAParticular = By.id("Particular_acta_1");
	
	// Particular arrendada
	protected By txtCupoAParticularA = By.id("Particular Arrendada_aprobado_2");
	protected By txtFechaAParticularA = By.id("Particular Arrendada_fechaAprobacion_2");
	protected By txtDiasCAParticularA = By.id("Particular Arrendada_modalidadCupo_2");
	protected By txtNumeroAParticularA = By.id("Particular Arrendada_acta_2");
	
	// Transito
	protected By txtCupoATransito = By.id("Transito_aprobado_3");
	protected By txtFechaATransito = By.id("Transito_fechaAprobacion_3");
	protected By txtDiasCATransito = By.id("Transito_modalidadCupo_3");
	protected By txtNumeroATransito = By.id("Transito_acta_3");

	// OPCIONES
	protected By lblOpciones = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group/div/div/div/div/button[contains(text(),'{0}')]");

	// MERCANCIA
	protected By btnCrearMercancia = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[1]/div/div/div/div/div/div/a");
	protected By lblTipoMercancia = By.id("mercancia");
	protected By lblUnidadMedida = By.id("umedida");
	protected By btnCancelarMercancia = By.xpath("//body/modal-container/div/div/mercancia-cupo/div/form/div/button[contains(text(),'Cancelar')]");
	protected By btnGuardarMercancia = By.xpath("//body/modal-container/div/div/mercancia-cupo/div/form/div/button[contains(text(),'Guardar')]");
	
	// ACREEDOR
	protected By btnCrearAcreedor = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[2]/div/div/div/div/div/div/a");
	protected By btnGuardarAcreedor = By.xpath("//body/modal-container/div/div/acreedor-cupo/div/div/div/button[contains(text(),'Guardar')]");
	protected By btnAceptarAcreedorYaAsociado = By.xpath("//body/div/div/div/button[contains(text(),'Aceptar')]");

	// MODIFICAR
	protected By btnModificarCupo = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[7]/div/a");
		
	// VER
	protected By btnVerCupo = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[7]/div/div/a");
	protected By lblCriterio = By.id("criterio");
	protected By txtConsultarNit = By.id("termino");
	protected By CampoSolicitud = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form[2]/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/table/thead/tr/th[1];");
	
	protected By btnCancelar = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[3]/div/button");
	protected By btnSearch = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form[2]/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/button");
	protected By btnGuardar = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[3]/div/button[1]");
	
	protected By btnAceptarGuardar= By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	protected By GridValoresScav = By.xpath("/html/body/app-root/div/div/div/app-main/app-formulario/div/form[2]/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/table/tbody/tr");
	protected By AlertaBusqueda = By.xpath("//*[@id='toast-container']");
	protected By txtFichaAprobacion = By.xpath("//*[@id='numRef']");
	
	protected By GridScav = By.xpath("/html/body/app-root/div/div/div/app-main/app-formulario/div/form[2]/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/table/thead/tr");
	
	protected By btnVisualizarScav = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form[2]/accordion/app-integracion-scav/accordion-group/div/div[1]/div/div/button");
	
}
