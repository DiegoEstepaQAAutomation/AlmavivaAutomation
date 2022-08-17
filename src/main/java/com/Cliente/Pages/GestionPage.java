package com.Cliente.Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Cliente.Maps.GestionMap;

import java.io.File;
import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class GestionPage extends GestionMap {

	Object[] x;
	boolean val;
	int t = 15;

	//Strings de anulaciones
	String Anulaciones ="547059, 547060, 547061,547062,547063,547064,547065,547066,547067,547068 ";
	
	public GestionPage(WebDriver driver) {
		super(driver);
	}
	
	//Validaciones de obligatoriedad de campos
	@Step("Obligatoriedad de campos Datos de contacto")
	public GestionPage obligatoriedadCamposDatosC(File folderPath, String datosContacto) throws Exception {

		x = new Object[3];
		x[0] = lblNombreObligatorio;
		x[1] = lblCargoObligatorio;
		x[2] = lblTelefonoObligatorio;
		
		//Paso a paso para la edicion de datos de contacto
		click(btnCrearCliente, folderPath, "Se ingresa a crear Cliente");
		click(locatorVariable(lblOpciones, datosContacto), folderPath, "Se ingresa a la opción Datos de contacto");
		click(btnCrearInformacion, folderPath, "Se ingresa a crear Datos de Contacto");
		click(txtNombreDatosC, folderPath, "Obligatoriedad campo Nombre");
		click(txtCargoDatosC, folderPath, "Obligatoriedad campo Cargo");
		click(txtTelefotoDatosC, folderPath, "Obligatoriedad campo Teléfono");
		click(txtCorreoDatosC, folderPath, "Obligatoriedad campo Correo");
		
		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados");
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		
		//Click en cancelar y se cierra datos de contacto
		click(btnCancelarDatosC, folderPath, "Se ingresa a cancelar Datos de Contacto");
		click(locatorVariable(lblOpciones, datosContacto), folderPath, "Se cierra a la opción Datos de contacto");
		return this;
	}
	
	//paso a paso en los campos de poliza
	@Step("Obligatoriedad de campos Información de Pólizas")
	public GestionPage obligatoriedadCamposPoliza(File folderPath, String informacionPolizas) throws Exception {

		x = new Object[3];
		x[0] = lblAseguradoraObligatorio;
		x[1] = lblNumeroPolizaObligatorio;
		x[2] = lblValorObligatorio;
		
		//se validan los campos de informacion de poliza
		click(locatorVariable(lblOpciones, informacionPolizas), folderPath, "Se ingresa a la opción Información de Pólizas");
		click(btnCrearInformacion, folderPath, "Se ingresa a crear Información de Pólizas");
		click(txtAseguradoraPoliza, folderPath, "Obligatoriedad campo Aseguradora");
		click(txtNumeroAseguradoraPoliza, folderPath, "Obligatoriedad campo N° de Póliza");
		click(txtValorPoliza, folderPath, "Obligatoriedad campo Valor");
		click(txtVencimientoPoliza, folderPath, "Obligatoriedad campo Vencimieneto");

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados");
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		//Se cancela la edicion de poliza 
		click(btnCancelarPoliza, folderPath, "Se ingresa a cancelar Información de Pólizas");
		click(locatorVariable(lblOpciones, informacionPolizas), folderPath, "Se cierra a la opción Información de Pólizas");
		click(btnCancelarGestion, folderPath, "Se cancela la información");
		return this;
	}

	//Paso a paso para llegar al boton crear cliente
	@Step("Crear cliente")
	public GestionPage crearCliente(File folderPath, String nitC) throws Exception {

		//Se da click en crear cliente y se cancela la gestion 
		click(btnCrearCliente, folderPath, "Se ingresa a crear Cliente");
		writeText(txtNit, nitC, folderPath, "Se digita Nit");
		enter(txtNit);
		scrollElementV(folderPath, btnCancelarGestion, "Se dirige a la opción cancelar");
		return this;
	}
	
	//Formulario de creacion de datos de contacto
	@Step("Datos de contacto")
	public GestionPage datosContacto(File folderPath, String datosContacto, String nombre, String cargo, String telefono, String correo, String estadoDC) throws Exception {
		
		//Se llenan los campos de creacion de contacto 
		click(locatorVariable(lblOpciones, datosContacto), folderPath, "Se ingresa a la opción Datos de contacto");
		click(btnCrearInformacion, folderPath, "Se ingresa a crear Datos de Contacto");
		writeText(txtNombreDatosC, nombre, folderPath, "Se digita en el campo Nombre");
		writeText(txtCargoDatosC, cargo, folderPath, "Se digita en el campo Cargo");
		writeText(txtTelefotoDatosC, telefono, folderPath, "Se digita en el campo Teléfono");
		writeText(txtCorreoDatosC, correo, folderPath, "Se digita en el campo Correo");
		//Se selecciona estado y se guardan cambios
		selectElementList(lblEstadoDatosC, estadoDC, folderPath, "Se selecciona el Estado");
		click(btnGuardarDatosC, folderPath, "Se guarda la información");
		click(locatorVariable(lblOpciones, datosContacto), folderPath, "Se cierra a la opción Datos de contacto");
		return this;
	}
	
	//Paso a paso de informacion de polizas
	@Step("Información de Pólizas")
	public GestionPage informacionPolizas(File folderPath, String informacionPolizas, String aseguradora, String nPoliza, String valor, String vencimiento, String estadoIF) throws Exception {

		//Verificacion de informacion de polizas y guardado de poliza
		click(locatorVariable(lblOpciones, informacionPolizas), folderPath, "Se ingresa a la opción Información de Pólizas");
		click(btnCrearInformacion, folderPath, "Se ingresa a crear Información de Pólizas");
		writeText(txtAseguradoraPoliza, aseguradora, folderPath, "Se digita en el campo Aseguradora");
		writeText(txtNumeroAseguradoraPoliza, nPoliza, folderPath, "Se digita en el campo Número de Póliza");
		writeText(txtValorPoliza, valor, folderPath, "Se digita en el campo Valor");
		writeText(txtVencimientoPoliza, vencimiento, folderPath, "Se digita en el campo Vencimiento");
		selectElementList(lblEstadoPoliza, estadoIF, folderPath, "Se selecciona el Estado");
		click(btnGuardarPoliza, folderPath, "Se guarda la información");
		click(locatorVariable(lblOpciones, informacionPolizas), folderPath, "Se cierra a la opción Información de Pólizas");
		return this;
	}
	
	//Paso a paso de la creacion de acreedores
	@Step("Acreedores")
	public GestionPage acreedores(File folderPath, String acreedores, String nitA, String campoNit) throws Exception {

	//Se ingresa a la opcion de acreedores, se selecciona una opcion dentro del menu de acreedores, se escribe un nit y se guarda	
		click(locatorVariable(lblOpciones, acreedores), folderPath, "Se ingresa a la opción Acreedores");
		click(btnCrearInformacion, folderPath, "Se ingresa a crear Acreedores");
		selectElementList(lblOpcionAcreedores, nitA, folderPath, "Se selecciona el Estado");
		writeText(txtNitAcreedores, campoNit, folderPath, "Se digita en el campo Nit");
		//Metodo para simular el teclado y dar enter
		enter(txtNitAcreedores);
		click(btnGuardarAcreedores, folderPath, "Se guarda la información");
		click(locatorVariable(lblOpciones, acreedores), folderPath, "Se cierra a la opción Información de Pólizas");
		return this;
	}
	
	//Paso a paso del tipo de bodega 
	@Step("Tipo de Bodega")
	public GestionPage tipoBodega(File folderPath, String tipoBodega) throws Exception {
		
		//Click en tipo de bodega y en menu tipo de bodega
		click(locatorVariable(lblOpciones, tipoBodega), folderPath, "Se ingresa a la opción Acreedores");
		click(btnCrearInformacion, folderPath, "Se ingresa a la opción Tipo de Bodega");
		// este es un ciclo o bucle que va adicionando una casilla o numero en una parte en especifico del xpath cuando cambia selecciona un tipo de oficina diferente cada vez que hace el ciclo
		for (int i = 1; i <= 3; i++) {
			click(By.xpath("//body/modal-container/div/div/app-lista-bodegas/div/div/table/tbody/tr["+ i +"]/td[5]/div/input"), folderPath, "Se agrega oficina: " + i);
			waitInMs(1000);
		}
		//Se agrega bodega y se cierra el campo bodega
		click(btnAgregarBodega, folderPath, "Se agrega la bodega");
		click(locatorVariable(lblOpciones, tipoBodega), folderPath, "Se cierra a la opción Tipo de Bodega");
		return this;
	}
	
	//Paso a paso de cargue de anexo 
	@Step("Anexo")
	public GestionPage anexo(File folderPath, String anexo, String archivo, String descripcion) throws Exception {

		click(locatorVariable(lblOpciones, anexo), folderPath, "Se ingresa a la opción Anexo");
		click(btnCrearInformacion, folderPath, "Se ingresa a la opción Anexo");
		fileUpload(examinarArchivoAnexo, archivo, folderPath, "Se carga el archivo");
		writeText(txtDescripcionAnexo, descripcion, folderPath, "Se digita en el campo Descripción");
		click(btnAgregarAnexo, folderPath, "Se agrega la información");
		click(locatorVariable(lblOpciones, anexo), folderPath, "Se cierra a la opción Anexo");
		return this;
	}
	
	//Modificacion de cliente 
	@Step("Modificar cliente")
	public GestionPage modificarCliente(File folderPath) throws Exception {

		scrollElementH(folderPath, btnModificarCliente, "Se desplaza hasta la opción Modificar cliente");
		etiquetas(btnModificarCliente, folderPath, "Etiqueta Modificar cliente");
		click(btnModificarCliente, folderPath, "Se ingresa a modificar Cliente");
		return this;
	}
	
	//Paso a paso de ver un cliente
	@Step("Ver cliente")
	public GestionPage verCliente(File folderPath) throws Exception {

		//Se da click en visualizar un cliente
		scrollElementH(folderPath, btnVerCliente, "Se desplaza hasta la opción Ver cliente");
		etiquetas(btnVerCliente, folderPath, "Etiqueta Ver cliente");
		click(btnVerCliente, folderPath, "Se ingresa a ver cliente");

		//Mediante el metodo enabled se verifica que los campos sean editables o no 
		isEnabled(lblNit, folderPath, "Campo Nit No editable");
		isEnabled(lblNombreRazon, folderPath, "Campo Nombre/Razón Social No editable");
		isEnabled(lblDireccion, folderPath, "Campo Dirección No editable");
		isEnabled(lblCiudad, folderPath, "Campo Ciudad No editable");
		isEnabled(lblTelefono, folderPath, "Campo Teléfono No editable");
		isEnabled(lblCorreo, folderPath, "Campo Correo No editable");
		isEnabled(lblNombreRepresentanteL, folderPath, "Campo Nombre Representante Legal No editable");
		isEnabled(lblEstado, folderPath, "Campo Estado No editable");
		return this;
	}
	
	@Step("Consultar cliente")
	public GestionPage consultaCliente(File folderPath, String nom50, String nit) throws Exception {

		
		//Se escribe un valor random alfabetico en minuscula, se toma este string con valor random alfabetico y se escribe en el nit
		String nitt = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String n = driver.findElement(By.xpath("//input[contains(@formcontrolname,'termino')]")).getAttribute("maxlength");

		if (n.contains(nom50)) {
			//se imprime el mensaje de que los campos tienen un maximo de 50 caracteres al validarlo como una variable que tiene el maxlength 
			printConsole("Los campos contienen el maximo de 50 caracteres");
			writeText(txtConsultarNit, nitt, folderPath, "Se ingresa texto de 50 caracteres");
			clear(txtConsultarNit, folderPath, "Se eliminar texto antes digitado");
			writeText(txtConsultarNit, nit, folderPath, "Se ingresa nit");
			click(btnBuscar, folderPath, "Se busca el usuario digitado");
			//Se busca el titulo
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}
		return this;
	}
	
	//Ejecucion del caso principal 547065
	@Step("Consultar cliente")
	public GestionPage ClientePoliza_547065(File folderPath, String CriterioRazonSocial, 
			String Cliente,String ModuloT,String informacionPolizas,String SubModuloLiberacion,
			String TituloConLiberacionesPendientes,String AutoriPend,String Anular,
			String Titulouseradmin,String tituloPorAnular) throws Exception 
	{
		
		//Se valida primero un cliente con poliza usada
		click(btnCriterioBusqueda, folderPath, "click en criterio de busqueda");
		click(btnRazonSocial, folderPath, "click en razon social");
		writeText(txtConsultarNit, Cliente, folderPath, "Se ingresa cliente");
		scrollElementH(folderPath, btnModificarCliente, "Se desplaza hasta la opción Modificar cliente");
		//etiquetas(btnModificarCliente, folderPath, "Etiqueta Modificar cliente");
		//Se valida la variable booleanna del boton de poliza usada
		boolean EditarLabel = validarElemento(btnPolizaUsada, 10);
		ValidacionObjeto(EditarLabel, "547060 validacion de poliza usada", folderPath);
		//se ingresa a modificar y se da click en informacion de poliza
		click(btnModificarCliente, folderPath, "Se ingresa a modificar Cliente");
		desplazarseVertical(0, 500);
		click(btnInfoPoliza, folderPath,  "Se ingresa a la opción Información de Pólizas");
		click(btnModificarPoliza2, folderPath, "click en modificar poliza");
		
		//Se valida mediante variable booleana el boton de poliza usada luego de modificar la poliza
		boolean Poliusada = validarElemento(btnPolizaUsada, 10);
		ValidacionObjeto(Poliusada, "547059,547063,547061,547064 validacion de poliza usada,caso exitoso 547059,547063,547064,547061", folderPath);
		isEnabled(btnPolizaUsada, folderPath, "547062 campo no editable caso exitoso");
		//Se valida el cuadro de texto de valor gestion al enviarlo a una variable booleana
		boolean PoliValor = validarElemento(txtValorGestion, 10);
		ValidacionObjeto(PoliValor, "547066 validacion de poliza usada,caso exitoso 547066,547065", folderPath);
		listRandom(btnEstado, folderPath, "caso 547067,547066 exitoso cambio de esado poliza");
		
		//txtValorGestion
		
		//Se guarda y aceptan los cambios
		click(btnGuardar, folderPath, "Click en cancelar");
		click(btnAccept, folderPath, "click en aceptar");
		
		//Se ingresa a titulos expedir y se consulta si se puede modificar una liberacion
		click(locatorVariable(lblModulos, ModuloT), folderPath, "Se ingresa a la opción Anexo");
		click(locatorVariable(lblsecciones, SubModuloLiberacion), folderPath, "Se ingresa a la opción Anexo");
		writeText(txtBuscaTitulo, TituloConLiberacionesPendientes, folderPath, "Se digita el titulo a buscar");
		click(lblCodigoLiberacion, folderPath, "");
		click(btnAutorizacionPendiente,folderPath, "click en Liberacion");
		//Se validan el boton modificar liberacion y la alerta de cambios realizados con exito
		boolean ModificarCantidad = validarElemento(CampoModificarLiberacion, 10);
		ValidacionObjeto(ModificarCantidad, "547059 validacion de liberacion usada", folderPath);
		
		click(btnGuardarLiberacion, folderPath, "click en guardar cambios");
		boolean Alerta = validarElemento(AlertChangesSaved, 10);
		ValidacionObjeto(Alerta, "caso  exitoso  cambios realizados", folderPath);
		//Se dirige al submodulo de anular y se digita un titulo por anular, se valida el boton anular y se selecciona una raon por la que anular el titulo
		click(locatorVariable(lblsecciones, Anular), folderPath, "Se ingresa a la opción Anexo");
		writeText(txtBusquedaAnular, tituloPorAnular, folderPath, "Escribir titulo a anular");
		click(BtnSeleccionAnular2, folderPath, "click en buscar titulo a  anular 547065");
		scrollElementV(folderPath, btnanular, "Scroll al boton anular");
		boolean BotonAnular = validarElemento(btnanular, 10);
		ValidacionObjeto(BotonAnular, "caso  exitoso  cambios realizados", folderPath);
		click(btnanular, folderPath, "click en anular");
		listRandom(SelectorRazonAnular, folderPath, "Se selecciona la razon por la que se anula");
		
		//Se Guarda la anulacion y se aceptan cambios
		click(btnGuardarAnulacion, folderPath, "click en guardar anulacion caso 547065 exitoso");
		click(btnAceptarAnular, folderPath, "click en aceptar ");
		
		screenshot(folderPath ,"Estos son los casos: " + Anulaciones);
		
		//CampoModificarLiberacion
		
		
		
		return this;
		
	}
	
	
	
	
	
	
	
}




































//codigo de alejandra beltran