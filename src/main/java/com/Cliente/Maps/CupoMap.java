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
	protected By btnBuscarCupo = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div/form/div/button");
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
	
	//Cupo Asignado
		protected By btnNit = By.xpath("//*[@id='criterio']/option[2]");
		protected By btnNit2 = By.xpath("//*[@id='criterio']");
		protected By cupogrid = By.xpath("//*[@id='tbClientes']/tbody/tr");
		protected By saldoUgrid = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/thead/tr");
		protected By particulargrid = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/tbody/tr[2]");
		protected By detallesgrid = By.xpath("//*[@id='tbClientes']/thead/tr[1]");
		protected By cupoDgrid = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/thead/tr");
		protected By saldoUUgrid = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/thead/tr");
		protected By valorgrid = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/tbody/tr[2]");
		protected By valorgrid2 = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/tbody/tr[3]");
		protected By valorgrid3 = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/tbody/tr[4]");
		protected By valorgrid4 = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[2]/div[2]/table/tbody/tr[1]");
		
	     // Modulo y submodulo
		protected By lblModulos = By.xpath("//*[@id='sidebar']/ul/li/div/a[contains(text(),'{0}')]");
		protected By lblsecciones = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[(text()='{0}')]");
		protected By txtNitCargue = By.xpath("//*[@id='termino']");
		protected By numeroTgrid = By.xpath("//*[@id='tbClientes']/thead/tr");
		protected By ModificartituloLiberado = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
		protected By lblModificarHistorico = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
		protected By btnCupoAlternativo = By.xpath("//*[@id='cupoAlternativo']");
		protected By btnCupoAlternativo2 = By.xpath("//*[@id='cupoAlternativo']/option[1]");
		protected By btnCupoAlternativo3 = By.xpath("//*[@id='cupoAlternativo']/option[2]");
		protected By txtTotal = By.xpath("//*[@id='cupoTotalDisabled']");
		protected By txtModificarNumero = By.xpath("//*[@id='Particular Arrendada_aprobado_2']");
		protected By btnGuardar = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/div[3]/div/button[1]");
		protected By btnAceptar = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
		protected By btnAceptarExpedir = By.cssSelector("body > div.swal2-container.swal2-center.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled");
		protected By btnAplicar = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button[2]");
		protected By alerta = By.xpath("//*[@id='toast-container']");
		protected By Ok = By.cssSelector("body > div.swal2-container.swal2-center.swal2-shown > div > div.swal2-actions > button.swal2-confirm.swal2-styled");
		protected By OkAutorizacion = By.cssSelector("body > modal-container > div > div > app-detalleautorizacion > div > div.modal-header > button");
		protected By MensajeAlerta = By.xpath("/html/body/div[3]/div/div[2]");
		
		//Detalles autorizacion
		protected By btnDetallesAutorizacion = By.xpath("//*[@id='flexCheckCheckedSi']");
		protected By btnVerDetalles = By.xpath("//*[@id='tbClientes']/tbody/tr[3]/td[5]/a");
	
}
