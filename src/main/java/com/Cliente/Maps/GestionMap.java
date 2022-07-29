package com.Cliente.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class GestionMap extends BasePage {

	public GestionMap(WebDriver driver) {
		super(driver);
	}

	//---XPATH CAMBIANTE
	//protected By selectType = By.xpath("//*[@id='__next']/main/div[3]/form/div/div[3]/div/div[2]/div[{0}]/div[3]/button");
	
	// CREAR
	protected By btnCrearCliente = By.xpath("//*[@id='contenido']/app-main/clientes-home/div/div[2]/div/a");
	protected By txtNit = By.id("termino");
	protected By lblOpciones = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group/div/div/div/div/button[contains(text(),'{0}')]");
	protected By btnCrearInformacion = By.xpath("//*[@class='panel-collapse collapse in show']/div/div[2]/div[1]/div/a");
	protected By btnCancelarGestion = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/div/div/button[contains(text(),'Cancelar')]");
	protected By btnGuardarGestion = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/div/div/button[contains(text(),'Guardar')]");
	protected By btnModificarPoliza = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[3]/td[7]/a");
	protected By btnPolizaUsada= By.xpath("//*[@id='poliUsada']");
	protected By btnRazonSocial = By.xpath("//*[@id='criterio']/option[2]");
	
	protected By btnAccept = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	
	protected By btnModificarPoliza2 = By.xpath("//*[@id=\"contenido\"]/app-main/app-formulario/div/form/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[7]/a");
	protected By btnCancelarEdicion = By.xpath("//body/modal-container/div/div/clientes-poliza/div/form/div[2]/button[1]");
	protected By txtBusquedaAnular = By.xpath("//*[@id='titulo']");
	protected By BtnSeleccionarAnular = By.xpath("//*[@id='ngb-typeahead-6-0']");
	protected By BtnSeleccionAnular2 = By.xpath("/html/body/app-root/div/div/div/ng-component/div/app-filtrotitulo/form/div/div/ngb-typeahead-window/button");
	protected By SelectorRazonAnular  = By.xpath("/html/body/modal-container/div/div/ng-component/div/form/div[1]/div/select");
	
	protected By btnGuardarAnulacion = By.xpath("/html/body/modal-container/div/div/ng-component/div/form/div[2]/button[1]");
	
	protected By btnAceptarAnular = By.xpath("/html/body/div[3]/div/div[3]/button[1]");
	
	
	
	protected By btnanular = By.xpath("//*[@id='contenido']/ng-component/div/form/div[3]/div/button[1]");
	protected By txtValorGestion = By.xpath("//*[@id='poliValor']");
	protected By btnEstado = By.xpath("//*[@id='poliEstado']");
	protected By btnGuardar = By.xpath("//body/modal-container/div/div/clientes-poliza/div/form/div[2]/button[2]");
	protected By btnAceptar = By.xpath("//body/div[3]/div/div[3]/button[1]");
	protected By btnInfoPoliza= By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[2]/div/div[1]/div/div/button");
	protected By btnAutorizacionPendiente = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	
	
	protected By lblModulos = By.xpath("//*[@id='sidebar']/ul/li/div/a[contains(text(),'{0}')]");
	protected By lblsecciones = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[(text()='{0}')]");
	protected By txtBuscaTitulo = By.xpath("//*[@id='titulo']");
	protected By lblCodigoLiberacion = By.xpath("//app-filtrotitulo/form/div/div/ngb-typeahead-window/button");
	protected By CampoModificarLiberacion= By.xpath("//body/app-root/div/div/div/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[2]/div/div[2]/div/app-modificacion-autorizaciones/div[1]/table/tbody/tr[1]/td[5]/input");
	protected By btnGuardarLiberacion = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[2]/div/div[2]/div/app-modificacion-autorizaciones/div[3]/div/button");
	protected By AlertChangesSaved = By.xpath("//*[@id='toast-container']");
	
	// Datos de contacto
	protected By txtNombreDatosC = By.id("nombre");
	protected By txtCargoDatosC = By.id("cargo");
	protected By txtTelefotoDatosC = By.id("telefono");
	protected By txtCorreoDatosC = By.id("email");
	protected By lblEstadoDatosC = By.id("estado");
	protected By btnCancelarDatosC = By.xpath("//body/modal-container/div/div/clientes-contacto/div/form/div/button[contains(text(),'Cancelar')]");
	protected By btnGuardarDatosC = By.xpath("//body/modal-container/div/div/clientes-contacto/div/form/div/button[contains(text(),'Guardar')]");
	
	protected By lblNombreObligatorio = By.xpath("//body/modal-container/div/div/clientes-contacto/div/form/div/div[1]/div/div");
	protected By lblCargoObligatorio = By.xpath("//body/modal-container/div/div/clientes-contacto/div/form/div/div[2]/div/div");
	protected By lblTelefonoObligatorio = By.xpath("//body/modal-container/div/div/clientes-contacto/div/form/div/div[3]/div/div");
	
	// Información de Pólizas
	protected By txtAseguradoraPoliza = By.id("poliAseguradora");
	protected By txtNumeroAseguradoraPoliza = By.id("poliNumPoliza");
	protected By txtValorPoliza = By.id("poliValor");
	protected By txtVencimientoPoliza = By.id("poliVencimiento");
	protected By lblEstadoPoliza = By.id("poliEstado");
	protected By btnCancelarPoliza = By.xpath("//body/modal-container/div/div/clientes-poliza/div/form/div/button[contains(text(),'Cancelar')]");
	protected By btnGuardarPoliza = By.xpath("//body/modal-container/div/div/clientes-poliza/div/form/div/button[contains(text(),'Guardar')]");
	
	protected By lblAseguradoraObligatorio = By.xpath("//body/modal-container/div/div/clientes-poliza/div/form/div/div[1]/div/div");
	protected By lblNumeroPolizaObligatorio = By.xpath("//body/modal-container/div/div/clientes-poliza/div/form/div/div[2]/div/div");
	protected By lblValorObligatorio = By.xpath("//body/modal-container/div/div/clientes-poliza/div/form/div/div[3]/div/div");
	
	// Acreedores
	protected By lblOpcionAcreedores = By.xpath("//body/modal-container/div/div/clientes-acreedores/div/div/busqueda-cliente/form/div[1]/select");
	protected By txtNitAcreedores = By.xpath("//body/modal-container/div/div/clientes-acreedores/div/div/busqueda-cliente/form/div[2]/input");
	protected By btnCancelarAcreedores = By.xpath("//body/modal-container/div/div/clientes-acreedores/div/div/button[contains(text(),'Cancelar')]");
	protected By btnGuardarAcreedores = By.xpath("//body/modal-container/div/div/clientes-acreedores/div/div/button[contains(text(),'Guardar')]");
	
	// Tipo de Bodega
	protected By btnAgregarBodega = By.xpath("//body/modal-container/div/div/app-lista-bodegas/div/div/button[contains(text(),'Agregar')]");
	protected By btnCancelarBodega = By.xpath("//body/modal-container/div/div/app-lista-bodegas/div/div/button[contains(text(),'Cancelar')]");
	
	// Anexo
	protected By examinarArchivoAnexo = By.xpath("//input[contains(@formcontrolname,'anexArchivo')]");
	protected By txtDescripcionAnexo = By.id("anexDescripcion");
	protected By btnCancelarAnexo = By.xpath("//body/modal-container/div/div/clientes-anexo/div/form/div/button[contains(text(),'Cancelar')]");
	protected By btnAgregarAnexo= By.xpath("//body/modal-container/div/div/clientes-anexo/div/form/div/button[contains(text(),'Agregar')]");

	// MODIFICAR
	protected By btnModificarCliente = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/div[1]/a");
	
	// VER
	protected By btnVerCliente = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/div[2]/a");
	
	protected By lblNit = By.id("clieNit");
	protected By lblNombreRazon = By.id("clieRazonSocial");
	protected By lblDireccion = By.id("clieDireccion");
	protected By lblCiudad = By.id("clieCiudad");
	protected By lblTelefono = By.id("clieTelefono");
	protected By lblCorreo = By.id("clieCorreo");
	protected By lblNombreRepresentanteL = By.id("clieRepresentante");
	protected By lblEstado = By.id("estado");
	
	// CONSULTAR
	protected By txtConsultarNit = By.xpath("//input[contains(@formcontrolname,'termino')]");
	protected By btnBuscar = By.xpath("//*[@id='contenido']/app-main/clientes-home/div/form/button[(text() = ' Buscar ')]");
	protected By btnCriterioBusqueda = By.xpath("//*[@id='criterio']");
	
	
	
	
}
