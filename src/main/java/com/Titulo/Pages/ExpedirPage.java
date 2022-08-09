package com.Titulo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.Titulo.Maps.ExpedirMap;
import java.io.File;
import io.qameta.allure.Step;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import utilities.GenerarReportePdf;

public class ExpedirPage extends ExpedirMap {

	Object[] x;
	boolean val;
	int t = 15;
	
	
	String ValidacionCargue = "542369, 542370, 542371";
	String ValidacionTitulos = "543825";
	String ValidarLiberacion = "543826, 543828, 543832, 543827";
	String ValidarMercanciaLiberada = "543829, 543830";
	String ObjetoPresente = "543831,543832";
	String Historico = "546943, 546944, 546945, 546946, 546947, 546948, 546949, 546950";

	String Prorrogas = "546952";
	String Polizas ="547049, 547050, 547051, 547054, 547055"; 
	String FechaGeneracion="545511, 545512, 545513, 545514 ";
	String HU30 ="545511, 545512, 545513, 545514 ";
	String Edicion ="545515, 545516, 545517 ";
	
	String CP03 = "550319, 550320,550321, 552082, 552086, 552087";
	
	String Aplicador="554748,554763,554749,554750,554751";
	
	public ExpedirPage(WebDriver driver) {
		super(driver);
	}
	
	

	@Step("Crear expedir")
	public ExpedirPage crearExpedir(File folderPath, String n, String t, String o, String informacionG)
			throws Exception {

		String tb = null;

		n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();

		writeText(txtNitCliente, n);
		click(btnBuscarCliente);
		scrollElementH(btnVerCliente);
		click(btnVerCliente);
		click(lblTipoBodegaCliente);

		t = driver.findElement(By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText();
		o = driver.findElement(By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[5]")).getText();

		if (t.equals("Propia")) {
			tb = "Propia";
		} else if (t.equals("Particular")) {
			tb = "Particular";
		} else if (t.equals("ParticularArrendada")) {
			tb = "Particular Arrendada";
		} else if (t.equals("Transito")) {
			tb = "Tránsito";

			click(lblTitulo);
			click(lblExpedir);

			etiquetas(btnCrearExpedir, folderPath, "Etiqueta Crear expedir");
			click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir");
			writeText(txtNitRazonSocial, n, folderPath, "Se ingresa el dato Nit");
			click(seleccionarNitRazon);
			waitInMs(2000);
			click(locatorVariable(lblOpciones, informacionG), folderPath, "Click en elemento");
			scrollDown();
			waitInMs(500);
			selectElementList(lblOficinaResponsable, o);
			selectElementList(lblTipoBodega, tb);
			click(lblBodega);
			click(lblBodegaOpcion, folderPath, "click en opcion");

		} else {
			printConsole("Error");
			Assert.fail("Error");
		}
		return this;
	}
	
	
	
	@Step("Crear expedir")
	public ExpedirPage tipoOperacion(File folderPath, String n, String t, String o, String infogeneraltitulo)
			throws Exception 
	
	
	
	{
		
		n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();

		writeText(txtNitCliente, n);
		click(btnBuscarCliente);

		click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir");
		writeText(txtNitRazonSocial, n, folderPath, "Se ingresa el dato Nit");
		click(seleccionarNitRazon);
		waitInMs(2000);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en elemento");
		scrollDown();

		
		
		
		
		return this;
		
	}

	
//////HU16 CONTINU
	@Step("Hu16")
 public ExpedirPage LpnDtlnumCoincidan1(File folderPath,String TipoDeBodega,String estadoA,String Mercancias,
 		String Lista,String Lpm,
 		String dataBDD,
 		String SubModuloExpedir,
 		//String dataBDD2
 		String Lista1) throws Exception {


     writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo");
     searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia");
     scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
     searchElementGrid(FrameofGridClient1, estadoA, folderPath,"Se valida estado titulo aplicada");
     click(btnModificar, folderPath, "Click en modificar cliente");
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ");
     desplazarseVertical(0, 250);
     searchElementGrid(FrameofGridList, Lista, folderPath,"Se valida la lista ");
     desplazarseVertical(0, 500);
     click(btnSelectFiltro, folderPath, "click selecfiltro");
     click(btnFiltro, folderPath, "click filtro"); 
     //searchElementGridExcel2(FrameofGridExcel, folderPath,"Se lee LA TABLA");
     //searchElementGridExcel(FrameofGridExcel, folderPath,"Se lee LA TABLA");
     captureScreen(folderPath, dataBDD);
     click(locatorVariable(btnActualizarLpm, Lpm), folderPath, "Click en Actualizar Lpm ");
     click(btnActualizarCantidades, folderPath, "click Actualizar Cantidades");
     boolean validarAlertaCargue = validarElemento(AlertaCargue, 10);
		ValidacionObjeto(validarAlertaCargue, "Validacion", folderPath);
		
		//cp02
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo");
		searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia");
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
     searchElementGrid(FrameofGridClient1, estadoA, folderPath,"Se valida estado titulo aplicada");
     click(btnModificar, folderPath, "Click en modificar cliente");
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ");
     desplazarseVertical(0, 500);
     click(btnSelectFiltro, folderPath, "click selecfiltro");
     click(btnFiltro, folderPath, "click filtro"); 
     //captureScreen(folderPath, dataBDD2);
     searchElementGrid(FrameofGridList1, Lista1, folderPath,"Se valida la fila de la lista ");
     captureScreen(folderPath, dataBDD);
     click(locatorVariable(btnActualizarLpm, Lpm), folderPath, "Click en Actualizar Lpm ");
     click(btnActualizarCantidades, folderPath, "click Actualizar Cantidades");
     boolean validarAlertaCargue1 = validarElemento(AlertaCargue, 10);
		ValidacionObjeto(validarAlertaCargue1, "Validacion", folderPath);
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo");
		searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia");
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		click(btnModificar, folderPath, "Click en modificar cliente");
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ");
     //desplazarseVertical(0, 300);
     boolean validarProducto = validarElemento(lblProductos, 10);
		ValidacionObjeto(validarProducto, "Validacion de los productos", folderPath);
		scrollElementH(folderPath, lblCJ, "scroll");
		boolean cantidadSaldo = validarElemento(lblCantidadSaldo, 10);
		ValidacionObjeto(cantidadSaldo, "Validacion de Cantidad Saldo", folderPath);
		

     return this;
	}

	//////////////////// HU07

	@Step("Ver Titulo Expedir")
	public ExpedirPage ValidacionExpedirFormulario1_556552(File folderPath, String Empresa2, String InfGTitulo,
			String NumeroTitulo, String SubModuloExpedir) throws Exception {
		
		click(btnCrearExpedir, folderPath, "click en crearExpedir");
		click(btnNit2, folderPath, "click en Razon");
		click(btnNit, folderPath, "click en Razon Social");
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		click(btnSelecClaro, folderPath, "click en Claro");
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		desplazarseVertical(0,300);
		searchElementGrid1(txtNumeroTitulo, NumeroTitulo, folderPath, "Se valida el numero de titulos");
		desplazarseVertical(0,300);
		click(btnIngreso, folderPath, "Se verifica Division de ingreso");
		listRandom(btnIngreso, folderPath, "caso  exitoso 556550,556551, Se verifica Division de ingreso");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		click(btnSalirSinGuardar, folderPath, "Salir sin Guardar");
		
		return this;
	}
	 
	/////////HU07  Contunuacion
	
	@Step("Ver Titulo Expedir")
	public ExpedirPage ValidacionExpedirDivisionIngresos(File folderPath, String InfGTitulo, String ingreso, 
			String aplicar, String SubModuloExpedir, String OficnaExpedicion, String oficinaAlmacenamiento,
			String estadoA) throws Exception {
		
		
		writeText(txtNitCargue, "1795");
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		click(btnModificar, folderPath, "Click en modificar cliente");
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		desplazarseVertical(0,600);
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso");
		click(lblDivisionIngreso2, folderPath, "click en si");
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso");
		desplazarseVertical(0,300);
		writeText(btnPorcentajeEx, "50", folderPath, "Se escribe el Porcentaje Expedicion");
		writeText(btnPorcentajeAlm, "60", folderPath, "Se escribe el Porcentaje Almacenamiento");
		click(locatorVariable(btnAplicar, aplicar), folderPath, "Click en Aplicar");
		click(btnAceptar, folderPath, "click en Aceptar cambios ");
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
     ValidacionObjeto(alertaCreadaAplicada, "Validacion de la suma del porcentaje deben ser 100 caso exitoso 556554 ", folderPath);
     
     //cp06
     click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
     writeText(txtNitCargue, "1795");
     scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
     click(btnModificar, folderPath, "Click en modificar cliente");
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		desplazarseVertical(0,600);
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso");
		click(lblDivisionIngreso3, folderPath, "click en NO");
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso");
		desplazarseVertical(0,300);
		searchElementGrid(txtOficinaExpedicion, OficnaExpedicion, folderPath, "556555,Se valida Oficina expedicion");
		searchElementGrid(txtOficinaAlmacenamiento, oficinaAlmacenamiento, folderPath, "556555,Se valida porcentaje expedicion");
		boolean CodigoSapExp = validarElemento(txtCodigoSapExp, 10);
     ValidacionObjeto(CodigoSapExp, "Validacion del Codigo Sap Expedicion caso exitoso 556557 ", folderPath);
     writeText(txtCodigoSapExp, "WDV753", folderPath, "Se escribe el Codigo Sap Expedicion");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		
		//cp07
		writeText(txtNitCargue, "1905");
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		searchElementGrid1(ClientEstatus1, estadoA, folderPath,"Se valida estado de titulo como Aplicado Caso 556556");
		click(btnVisualizarImpresiones, folderPath, "click en impresiones");
		boolean btnImpresionBonoprenda = validarElemento(ImpresionBonoprenda, 10);
		boolean btnImpresionBonoprendaB = validarElemento(ImpresionBonoprendaB, 10);
		boolean btnImpresionCDM = validarElemento(ImpresionCDM, 10);
		boolean btnImpresionCDMB = validarElemento(ImpresionCDMB, 10);
		boolean btnImpresionA = validarElemento(ImpresionA, 10);
		boolean btnImpresionB = validarElemento(ImpresionB, 10);
		ValidacionObjetos(btnImpresionBonoprenda, btnImpresionBonoprendaB,"caso exitoso 556556 se valida impresion",folderPath);
		ValidacionObjetos(btnImpresionCDM, btnImpresionCDMB,"caso exitoso 556556 se valida impresion",folderPath);
		ValidacionObjetos(btnImpresionA, btnImpresionB,"caso exitoso 556556 se valida impresion",folderPath);

		return this;
	}
	
	
	
	

	@Step("Bono de Prenda")
	public ExpedirPage bono(File folderPath, String bono, String nitB, String nitBono, String diasPlazo)
			throws Exception {

		click(lblTipoTitulo);
		click(lblTipoTituloBono, folderPath, "Click en tipo titulo de bono");
		click(locatorVariable(lblOpciones, bono), folderPath, "Click en opciones titulo");
		click(btnCrearBono, folderPath, "Click en crear bono");
		selectElementList(lblNitNombreCertificado, nitB);
		writeText(txtNitNombreBono, nitBono, folderPath, "Se escribe Nit");
		click(seleccionarNitNombreBono);
		writeRandomNum(txtCapitalInicial, 4);
		writeText(txtDiasPlazo, diasPlazo, folderPath, "Se escribe Dias de plazo");
		writeRandomAlp(txtTipoInteres, 35);
		writeRandomNum(txtValorInteres, 10);
		writeRandomAlp(txtFrecuencia, 20);
		click(btnGuardarBono, folderPath, "Click en guardar bono");
		click(btnAceptarBono, folderPath, "Click en aceptar bono");
		waitInMs(500);
		click(locatorVariable(lblOpciones, bono), folderPath, "");
		return this;
	}

	@Step("Certificado de Depósito de Mercancía")
	public ExpedirPage certificado(File folderPath, String certificado, String nitCertificado, String nitC,
			String tipoEndoso) throws Exception {

		// Long day = Long.valueOf(new
		// SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));

		click(locatorVariable(lblOpciones, certificado), folderPath, "Click en opciones titulo");
		click(btnCrearCertificado, folderPath, "Click en crear bono");
		selectElementList(lblNitNombreCertificado, nitCertificado);
		writeText(txtNitNombre, nitC, folderPath, "Se escribe Nit");
		click(seleccionarNitNombre);
		selectElementList(lblTipoEndoso, tipoEndoso);
		// FALTA FECHA
		// click(txtFechaEndoso);
		
	

		//click(btnGuardarEndoso, folderPath, "");
		waitInMs(20000);
		// click(locatorVariable(lblOpciones, certificado), folderPath, "");
		return this;
	}

	@Step("Plazos")
	public ExpedirPage plazos(File folderPath, String plazos, String pCertificado, String pContrato) throws Exception {

		click(locatorVariable(lblOpciones, plazos), folderPath, "Click en opciones titulo");
		writeText(txtPlazoCertificado, pCertificado, folderPath, "Se escribe plazo certificado");
		writeText(txtPlazoContatro, pContrato, folderPath, "Se escribe plazo contrato");
		click(locatorVariable(lblOpciones, plazos), folderPath, "Click en opciones titulo");
		return this;
	}

	@Step("Póliza")
	public ExpedirPage poliza_547049(File folderPath, String poliza) throws Exception {

		
		click(locatorVariable(lblModulos, " Título "), folderPath, "Click en opciones titulo");
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en opciones titulo");
		writeText(txtNitCliente, "1661", folderPath, "escribir titulo cliente");
		click(btnModificar, folderPath, "Click en modificar cliente");
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en menu opciones poliza");
		listRandom(lblPoliza, folderPath, "Se selecciona valor random,caso exitoso 547049,547050,547051,547054,547055");
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en menu opciones poliza");
		return this;
	}

	@Step("Tipo de Mercancía")
	public ExpedirPage tipoMercancia(File folderPath, String tipoMercancia) throws Exception {

		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en menu opciones tipos de mercancia");
		listRandom(lblTipoMercancia, folderPath, "Se selecciona valor random");
		writeRandomAlp(txtDescripcionGeneral, 40);
		writeRandomNum(txtMerma, 4);
		listRandom(lblAplicaCondicion, folderPath, "Se selecciona valor random");
		writeRandomAlp(txtObservaciones, 10);
		scrollUp();
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia");
		return this;
	}

	@Step("Mercancías 'Individual'")
	public ExpedirPage mercanciasIndividual(File folderPath, String mercancias, String cargueI) throws Exception {

		click(locatorVariable(lblOpciones, mercancias), folderPath, "Click en opciones tipo mercancias");
		selectElementList(lblTipoCargue, cargueI, folderPath, "Se selecciona valor de lista");
		click(btnCrearCargueIndividual, folderPath, "Click en crear mercancia");
		writeRandomAlp(txtDetalleMercancia, 40);
		listRandom(lblUnidadMedida, folderPath, "Se selecciona valor random de la lista");
		listRandom(lblUnidadMedidaSuper, folderPath, "Se selecciona valor random de la lista");
		writeRandomNum(txtValorConversion, 2);
		writeRandomNum(txtCantidad, 18);
		writeRandomNum(txtValorUnitario, 28);
		writeText(txtFechaVencimientoMercancia, datePlusYear(3));
		writeRandomAlp(txtObservacionMercancia, 100);
		click(btnGuardarMercancia, folderPath, "Click en guardar mercancia");
		click(btnAceptarMercancias, folderPath, "Click en aceptar mercancia");
		click(locatorVariable(lblOpciones, mercancias), folderPath, "Se selecciona valor de opciones");
		return this;
	}

	@Step("Tarifas")
	public ExpedirPage tarifas(File folderPath, String tarifas) throws Exception {

		click(locatorVariable(lblOpciones, tarifas), folderPath, "Click en opciones tarifas");
		writeRandomNum(txtTarifa, 15);
		writeRandomNum(txtMinima, 50);
		click(locatorVariable(lblOpciones, tarifas), folderPath, "Click en opciones tarifas");
		return this;
	}

	@Step("Guardar expedir")
	public ExpedirPage guardarExpedir(File folderPath) throws Exception {

		click(btnGuardarExpedir, folderPath, "Click en Guardar y expedir");
		return this;
	}

	@Step("Imprimir")
	public ExpedirPage imprimir(File folderPath, String titulo) throws Exception {

		writeText(txtBuscarTitulo, titulo);
		click(btnBuscarTitulo, folderPath, "Click en buscar titulo");
		scrollElementH(btnImprimir);
		etiquetas(btnImprimir, folderPath, "Se evidencia etiqueta imprimir");
		click(btnImprimir, folderPath, "Click en buscar imprimir");
		
		val = validarElemento(lblImprimirOriginal, t);

	    if (Boolean.FALSE.equals(val)) {
	    	GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + lblImprimirOriginal);
	        Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + lblImprimirOriginal);
	    }
		escape();
		return this;
	}
	
	@Step("Modificar expedir")
	public ExpedirPage modificarExpedir(File folderPath, String titulo, String poliza, String tipoMercancia) throws Exception {
		
		writeText(txtBuscarTitulo, titulo);
		click(btnBuscarTitulo, folderPath, "Click en buscar titulo");
		scrollElementH(btnImprimir);
		etiquetas(btnModificar, folderPath, "Se evidencia etiqueta modificar expedicion");
		click(btnModificar, folderPath, "Click en modificar");

		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en opciones poliza");
		listRandom(lblPoliza, folderPath, "Se selecciona un objeto random");
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en opciones poliza");
		
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia");
		listRandom(lblTipoMercancia, folderPath, "Se selecciona elemento random de la lista");
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia");
		click(btnGuardarExpedir, folderPath, "Click en Guardar y expedir");
		click(btnAceptarGuardarModificar, folderPath, "Click en Guardar y modificar");
		
		val = validarElemento(lblGudadoExitoso, t);

	    if (Boolean.FALSE.equals(val)) {
	    	GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + lblGudadoExitoso);
	        Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + lblGudadoExitoso);
	    }
		return this;
	}
	
	@Step("Ver expedir")
	public ExpedirPage verExpedir(File folderPath) throws Exception {

		scrollElementH(folderPath, btnVerExpedir, "Se desplaza hasta la opción Ver expedir");
		etiquetas(btnVerExpedir, folderPath, "Etiqueta Ver expedir");
		click(btnVerExpedir, folderPath, "Se ingresa a ver expedir");

		isEnabled(txtNit, folderPath, "Campo Nit No editable");
		isEnabled(txtNombreRazon, folderPath, "Campo Nombre/Razón social No editable");
		isEnabled(txtDireccion, folderPath, "Campo Dirección No editable");
		isEnabled(txtCiudad, folderPath, "Campo Ciudad No editable");
		isEnabled(txtTelefono, folderPath, "Campo Teléfono No editable");
		isEnabled(txtCorreo, folderPath, "Campo Correo No editable");
		return this;
	}
	
	
	//VALIDACIONES DE SEGUNDA HISTORIA DE USUARIO SOBRE TITULOS Y LIBERACIONES
	
	
	@Step("Ver expedir")
	public ExpedirPage ExpedirCancelar(File folderPath,String TituloCancelado,String Mercancias,String EstadoC,String CantInicial,String CantActual) throws Exception 
	{
		
		writeText(txtBuscar, TituloCancelado,folderPath, "Se escribe Id de titulo ");
		click(btnBusquedaTitulo, folderPath, "click busqueda titulo");
		scrollElementH(folderPath, ModificarCancelado, "Se desplaza hasta el elemento deseado");
		
		searchElementGrid1(ClientEstatus1, EstadoC, folderPath, "Se valida estado de titulo como cancelado Caso 543825");
		click(VisualizarCancelado, folderPath, "click sobre modificar elemento");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		scrollElementV(folderPath, btnCantidadInicial, "Se desplaza hasta el elemento");
		
		
		searchElementGrid1(ClienteMercanciaState, CantInicial, folderPath, "Caso 543825 exitoso se validan campos");
		searchElementGrid1(ClienteMercanciaState, CantActual, folderPath, "Caso 543825 exitoso se validan campos");
		
		screenshot(folderPath ,"Estos son los casos: " + ValidacionTitulos);
		return this;
	}

	
	@Step("Ver expedir")
	public ExpedirPage ValidacionLiberacion_543826(File folderPath,String TituloLiberacion,
			String Detalle,String EstadoC,String CantInicial,String CantActual,
			String LiberarCantidad,String Sinicial,String TituloHistorico,String TituloLiberacionInicial,String Mercancias ) throws Exception 
	{
		

		
		
		
		
		writeText(txtBuscaTitulo, TituloLiberacion, folderPath, "Se digita el titulo a buscar");
		click(lblCodigoLiberacion, folderPath, "");
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en detalle  Mercancias");
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Cant. Inicial"), "Se desplaza hasta el campo detalle de mercancia");
		searchElementGrid1(ClienteMercanciaState, CantInicial, folderPath, "Caso 543826 exitoso se validan campos");
		searchElementGrid1(ClienteMercanciaState, CantActual, folderPath, "Caso 543826 exitoso se validan campos");
		searchElementGrid1(ClienteMercanciaState, LiberarCantidad, folderPath, "Caso 543826 exitoso se validan campos");
		searchElementGrid1(ClienteMercanciaState, Sinicial, folderPath, "Caso 543826 exitoso se validan campos");
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Valor Total"), "Click en opciones titulo");
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Acción"), "Click en opciones titulo");
		
		
		click(locatorVariable(lblsecciones,"Expedir"),folderPath, "click en Liberacion");
		
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar, 546945 se consulta titulo en estado cancelado o aplicado");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		searchElementGrid1(AlternativeGridstatus, EstadoC, folderPath, "Se valida el estado aplicado del titulo del caso 546943");

		
	
		click(locatorVariable(lblsecciones,"Liberación"),folderPath, "click en Liberacion");
		writeText(txtBuscaTitulo, TituloHistorico, folderPath, "Se digita el titulo a buscar");
		click(lblCodigoLiberacion, folderPath, "");
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en detalle  Mercancias");
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Cant. Inicial"), "Se desplaza hasta el campo detalle de mercancia");
		searchElementGrid1(ClienteMercanciaState, CantInicial, folderPath, "Caso 543827 exitoso se validan campos");
		searchElementGrid1(ClienteMercanciaState, CantActual, folderPath, "Caso 543827 exitoso se validan campos");
		searchElementGrid1(ClienteMercanciaState, Sinicial, folderPath, "Caso 543827 exitoso se validan campos");
		click(locatorVariable(lblsecciones,"Liberación"),folderPath, "click en Liberacion");
		

		
		
		screenshot(folderPath ,"Estos son los casos: " + ValidarLiberacion);
		
		return this;
		
	}
	
	@Step("Ver expedir")
	public ExpedirPage ValidacionMercanciaLiberada(File folderPath,String TituloLiberado,
			String Detalle,String CantInicial,String CantActual,String TituloCancelado ) throws Exception 
	{ 
		writeText(BuscarTitulo, TituloLiberado);
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza hasta la opción modificar ");
        click(ModificartituloLiberado, folderPath, "Se da click sobre modificar ");
        scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias");
        click(locatorVariable(lblOpciones2, " Mercancías "), folderPath, "Click en Mercancias");
		searchElementGrid1(ClienteMercanciaState, CantInicial, folderPath, "Caso 543829,543830 exitoso se validan campos, Se valida que el valor esta en 0");
		searchElementGrid1(ClienteMercanciaState, CantActual, folderPath, "Caso 543829,543830 exitoso se validan campos, Se valida que el valor esta en 0");
        
        scrollElementV(folderPath, btnCancelar, "Se desplaza hasta la opcion cancelar");
		click(btnCancelar, folderPath, "Click en cancelar");
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en la seccion de liberacion");
		writeText(TxtTituloLiberacion, TituloCancelado, folderPath, "");
		click(btnBuscarLiberacion, folderPath, "click en la liberacion a buscar");
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en Mercancias");
		click(btnOkLiberacion, folderPath, "click en aceptar liberacion");
		
		boolean validarbtncargarf = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(validarbtncargarf, "Se valida que el titulo ya no tiene liberaciones del caso 543829 caso exitoso",folderPath);
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en la seccion expedir");
		writeText(BuscarTitulo, TituloLiberado);
		scrollElementH(folderPath, VisualizarTitulo, "Se desplaza hasta la opción Ver cupo");
		
		click(VisualizarTitulo, folderPath, "Se ingresa a ver Cupo");
		scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias");
	    click(locatorVariable(lblOpciones2, " Mercancías "), folderPath, "Click en Mercancias");
	    scrollElementV(folderPath, btnCancelar, "click en la opcion cancelar");
	    
	    //desplazarseVertical(0, 400);
			
	    click(btnCancelar, folderPath, "Click en cancelar");
	
		screenshot(folderPath ,"Estos son los casos: " + ValidarMercanciaLiberada);
		
		
		
		return this;
		
		
	}
	
	
	@Step("Ver expedir")
	public ExpedirPage ObjetoPresente(File folderPath,String TituloaLiberar,String Detalle) throws Exception 
	{ 
		
		
		writeText(txtBuscaTitulo, TituloaLiberar, folderPath, Detalle);
		click(lblCodigoLiberacion, folderPath, Detalle);
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en Mercancias");
		
		scrollElementV(folderPath, btnDone, "Se desplaza hasta el boton ok");
		scrollElementH(folderPath, cbxAccion, "Se desplaza hasta el checkbox de accion");
		click(cbxAccion, folderPath, "Se da click sobre el checkbox de accion del caso 543831");
		
		/*click(btnDone, folderPath, "caso 543831 exitoso");
		
		desplazarseVertical(600, 0);
		
		writeText(txtBuscaTitulo, TituloaLiberar, folderPath, "");
		
		click(lblCodigoLiberacion, folderPath, "");
		
		scrollElementV(folderPath, btnDone, "");
		
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en Mercancias");
		searchElementGrid1(ClienteMercanciaState, CantInicial, folderPath, "Caso 543829,543830,543831 exitoso se validan campos, Se valida que el valor esta en 0");
		searchElementGrid1(ClienteMercanciaState, CantActual, folderPath, "Caso 543829,543830,543831,543832 exitoso se validan campos, Se valida que el valor esta en 0");
		
		click(locatorVariable(lblsecciones,"Expedir"),folderPath,""))
		writeText(txtBuscaTitulo, TituloaLiberar, folderPath, "");
		
		click(locatorVariable(lblOpciones2, " Mercancia "), folderPath, "Click en Mercancias");
			*
		*/
		
		screenshot(folderPath ,"Estos son los casos: " + ObjetoPresente);
		
		return this;
		
	}
	
	@Step("Ver expedir")
	public ExpedirPage ValidacionExpedirLiberacion(File folderPath,String TituloLiberado,String Detalle,String Mercancias) throws Exception 
	{ 
		
		writeText(txtBuscaTitulo, TituloLiberado, folderPath, "Se digita el titulo a buscar");
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza al elemento");
		click(ModificartituloLiberado, folderPath, "click en modificar articulo");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		scrollElementV(folderPath, btnObservarTitulo, "Se desplaza hasta la opcion observar titulo");
		click(btnObservarTitulo, folderPath, "click en observar titulo");
		click(btnCancelarvista, folderPath, "click en cancelar vista");
		
		
		
		
		
		return this;
		
		
	}
	
	
	
	
	
	
	
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage BodegaCargue(File folderPath,String NitClienteAsociado,String Mercancias) throws Exception {
		

		
		
		scrollElementH(folderPath, btnModificarCliente, "Se desplaza hasta el boton modificar cliente");
		click(ModificarCancelado, folderPath, NitClienteAsociado);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias);
		scrollElementH(folderPath, ModificarAplicado, "Se desplaza hasta el boton modificar cliente");
		click(ModificarAplicado, folderPath, Mercancias);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias);
		
		scrollElementH(folderPath, ModificarAnulado, "Se desplaza hasta el boton modificar cliente");
		scrollElementV(folderPath, ModificarAnulado, "Se desplaza hasta el boton modificar cliente");
		click(ModificarAnulado, folderPath, Mercancias);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias);
	
		
		
		return this;
	}
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage ValidacionExpedicion_542372(File folderPath,String NitClienteAsociado,String TipoDato,String InformacionGeneral,
			String DetalleMercancia,String Plazo,String Poliza,
			String TipodeMercancia,String Mercancias,String Route,
			String RouteA,String RouteB,String ModuloT,String SubModuloExpedir,
			String TipoBodega,String ValorBuscado,String RouteC ) throws Exception {

		//x = new Object[2];
		
		//x[0] = btnDescargar;
		//x[1] = btnCargue;
		
		
		writeText(BuscarCliente, NitClienteAsociado, folderPath, "Se busca cliente asociado");
		
		click(btnModificarcliente, folderPath, "click en modificar cliente");
		
		desplazarseVertical(0,600);
		//
		scrollElementV(folderPath, Tipobodega, "");
		click(Tipobodega, folderPath, "");
		
		
		
		searchElementGrid(FilaElemento2, ValorBuscado, folderPath, "Se encuentra Validacion de Bodega propia y wms, Caso 542372,542369");
		
		
		
		
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		//selectElementList(lblTipoDeDato, TipoDato);
		writeText(txtNitCargue, "1604", folderPath, "Se escribe el nit que se desea buscar ");
		
		scrollElementH(folderPath, lblModificarHistorico, "Scroll hacia elemento");
		
		click(lblModificarHistorico, folderPath, "click en modificar");
		
		//scrollElementV(folderPath, lblRegistro, "Se dezplaza hacia el ultimo registro");
		//scrollElementH(folderPath, ModificarRegistro, "Se dezplaza hacia modificar registro");
		//click(ModificarRegistro, folderPath, "Click en modificar registro");
		waitInMs(10);
		
		
		desplazarseVertical(0,300);
		click(locatorVariable(lblOpciones, InformacionGeneral), folderPath, "Click en menu opciones poliza y se visualizan los datos necesarios caso 542370,542372");
		click(locatorVariable(lblOpciones, InformacionGeneral), folderPath, "Click en menu opciones poliza");
		
		click(DetalleMercancia2, folderPath, "Click en Detalle Mercancia y se visualizan los datos necesarios caso 542370,542372");
		click(DetalleMercancia2, folderPath, "Click detalle mercancia");
		
		//click(locatorVariable(lblOpciones, DetalleMercancia), folderPath, "Click en Detalle Mercancia y se visualizan los datos necesarios caso 542370,542372");
		
		//click(locatorVariable(lblOpciones, DetalleMercancia), folderPath, "Click en Detalle Mercancia");
		
		desplazarseVertical(0,250);
		click(locatorVariable(lblOpciones, Plazo), folderPath, "Click en Plazo y se visualizan los datos necesarios caso 542370,542372");
		click(locatorVariable(lblOpciones, Plazo), folderPath, "Click en Plazo");
		
		click(locatorVariable(lblOpciones, Poliza), folderPath, "Click en menu opciones poliza y se visualizan los datos necesarios caso 542370,542372");
		click(locatorVariable(lblOpciones, Poliza), folderPath, "Click en menu opciones poliza");
		
		desplazarseVertical(0,300);
		
		click(locatorVariable(lblOpciones, TipodeMercancia), folderPath, "Click en tipo de mercancia y se visualizan los datos necesarios caso 542370,542372");
		click(locatorVariable(lblOpciones, TipodeMercancia), folderPath, "Click en tipo de mercancia");
		
		desplazarseVertical(0,300);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias, Se valida el funcionamiento de la seccion mercancias del caso 542369");
		
		
		
		scrollElementV(folderPath, btnDescargar, "Se dezplaza hasta elemento el caso 542369 es exitoso ");
		boolean validarbtndescarga = validarElemento(btnDescargar, 10);
		
		boolean validarbtncargar = validarElemento(btnCargue1, 10);
		
		
		ValidacionObjetos(validarbtndescarga,validarbtncargar," Se valida la presencia de los botones de carge y descargue de archivos", folderPath);
		
		click(btnDescargar, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		
		
		waitInMs(3);
		
		fileUpFull(btnCargue, Route);
		boolean validarAlertaCargueerrado = validarElemento(AlertaCargue,10);
		ValidacionObjeto(validarAlertaCargueerrado,"caso 542371 se valida la existencia de la alerta de cargue no exitoso, no aparece una alerta de error sino de advertencia por tanto el caso 542371 falla", folderPath);
		
		fileUpFull(btnCargue, RouteA);
		boolean validarAlertaCargue = validarElemento(AlertaCargue,10);
		ValidacionObjeto(validarAlertaCargue,"caso 542370 es exitoso ,542373 es exitoso,542375 se valida la existencia de la alerta de cargue exitoso, 542375 cargue de datos decimales esta prueba falla porque si permitio realizar la carga de archivos, Caso 542378 exitoso se carga esa cantidad de mercancias", folderPath);
		fileUpFull(btnCargue, RouteB);
		
		boolean validarAlertaCargue2 = validarElemento(AlertaCargue,10);
		ValidacionObjeto(validarAlertaCargue2,"casos exitosos 542370,542373,542376, se valida la existencia de la alerta de cargue exitoso,caso 542376 falla porque no esta la tabla de calculo, valida cargue de caso 542377", folderPath);
			
		
		//No se puede jamas automatizar la creacion perpetua de titulos debido a que estos solo cambian de estado y no es posible borrarlos como tal
		
		//click(btnAplicar, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		//click(btnAceptar, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		//click(btnSafe, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		//click(btnAceptar, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		//boolean validarAlertaCargue = validarElemento(AlertaCargue,10);
		//ValidacionObjeto(validarAlertaCargue,"caso 542370 se valida la existencia de la alerta de cargue exitoso, caso 542377 es exitoso en el guardado de cargue", folderPath);
		
		scrollElementV(folderPath, CheckBox, "Se dezplaza hasta checkbox, Se valido el funcionamiento de la funcion de cargue masivo y el checkbox del caso 542369, datos caso 542372,checkbox cargados 542374");
		
		fileUpFull(btnCargue, RouteC);
		
		boolean validarAlertaCargue3 = validarElemento(AlertaCargue,10);
		
		ValidacionObjeto(validarAlertaCargue3,"caso 542492 exitoso se valida el mensaje de cargue exitoso de un archivo con cantidades negativas", folderPath);
		
		
		return this;
	}
	
	//VALIDACION DE HISTORICOS 
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage ValidacionHistorico_546943(File folderPath,
			String TituloHistorico,String DetalleMercancia,String EstadoC,
			String Mercancias,String ValidarVisualizacionLiberacion,
			String CantInicial,String CantActual,String LiberarCantidad,String Sinicial,String etiquetaPoliza,
			String  poliza,String TituloEjemplo,
			String TituloIncompleto,String TituloCancelado,String Producto
			) throws Exception {
		
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar, 546945 se consulta titulo en estado cancelado o aplicado");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		searchElementGrid1(AlternativeGridstatus, EstadoC, folderPath, "Se valida el estado aplicado del titulo del caso 546943");
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en Mercancias");
		writeText(TxtTituloLiberacion, TituloHistorico, folderPath, "Se digita titulo de liberacion");
		click(btnSearchLiberacionButton, folderPath, "click en modificar");
		
		
		click(DetalleMercancialbl, folderPath, "Click en Mercancias");
		//scrollElementV(folderPath, btnClose, "scroll hacia boton cerrar");
		searchElementGrid1(ClienteMercanciaState, CantInicial, folderPath, "caso 546943 exitoso se puede observar informacion");
		searchElementGrid1(ClienteMercanciaState, CantActual, folderPath, "caso 546943 exitoso se puede observar informacion");
		searchElementGrid1(ClienteMercanciaState, LiberarCantidad, folderPath, "caso 546943 exitoso se puede observar informacion");
		searchElementGrid1(ClienteMercanciaState, Sinicial, folderPath, "caso 546943 exitoso se puede observar informacion");
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en Mercancias");
		writeText(BuscarCliente, "1651", folderPath, "Se digita titulo de liberacion");
		click(lblVisualizarTitulo, folderPath, "Click en visualizar");
		
		desplazarseVertical(0, 600);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		click(btnVisualizarLiberacionGrid, folderPath, "click en visualizacion");
		searchElementGrid1(gridLiberacion, ValidarVisualizacionLiberacion, folderPath, "caso 546943 exitoso se puede observar informacion");
		click(btnClose, folderPath, "cerrar consulta");
		
		
		scrollElementH(folderPath, lblVisualizarHistorico, "");
		boolean btnVisualizarHistorico = validarElemento(lblVisualizarHistorico, 10);
		ValidacionObjeto(btnVisualizarHistorico,"caso 546943,546947 se valida existencia de boton visualizar ", folderPath);
		click(lblVisualizarHistorico, folderPath, "click en visualizar liberacion,546945 se visualiza cantidad inicial");
		click(btnClose, folderPath, "cerrar consulta");
		
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en Mercancias");
		writeText(txtNitCargue, TituloCancelado, folderPath, "Se escribe el titulo a buscar,546946 se consulta estado diferente a aplicado");
		scrollElementH(folderPath, lblVisualizarTitulo, "Se desplaza hasta modificar titulo");
		click(lblModificarHistorico, folderPath, "click en modificar");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0, 500);
		
		scrollElementH(folderPath, btnVisualizarLiberacion, "Se desplaza hasta elemento");
		click(btnVisualizarLiberacion, folderPath, "Click en visualizar");
		searchElementGrid1(ClienteMercanciaState, CantInicial, folderPath, "caso 543825,543827, 543829,543830,546944,546945,546946 exitoso se puede observar informacion");
		searchElementGrid1(ClienteMercanciaState, CantActual, folderPath, "caso 543825,543829,543827,543830,546944,546945,546946 exitoso se puede observar informacion");
		click(btnClose, folderPath, "cerrar consulta");
		
		//GridLiberacionesHistoricos
		//screenshot(folderPath ,"Estos son los casos: " + Historico);
		
		return this;
	}
	
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage UsuarioAdmin(File folderPath,String etiquetaPoliza,String  poliza, 
			String TituloHistorico,String SeccionA,String usuario2,
			String TituloGrabado,String TituloIncompleto,
			String Mercancias,String ModuloS) throws Exception {
		
		
		
		
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		//boolean validarbtndescargaE = validarElemento(btnDescargar, 10);
		//boolean validarbtncargarE = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		
		//ValidacionObjetos(validarbtncargarE,validarbtndescargaE,"542494 Se valida la no presencia de los botones de carge y descargue de archivos el caso 542494 es exitoso", folderPath);
		
		
		desplazarseVertical(0, 400);
		//POLIZA
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias");
		desplazarseVertical(0, 400);
		desplazarseVertical(0, 300);	
		click(btnCancelar, folderPath, "click en cancelar");
		
		
		writeText(txtNitCargue, TituloGrabado, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		boolean validarbtndescarga = validarElemento(btnDescargar, 10);
		boolean validarbtncargar = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		
		ValidacionObjetos(validarbtndescarga,validarbtncargar,"542493 Se valida la presencia de los botones de carge y descargue de archivos", folderPath);
		
		
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias");
		desplazarseVertical(0, 400);
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias");
		
		
		desplazarseVertical(0, 400);
		click(btnCancelar, folderPath, "click en cancelar");
		
			
		writeText(txtNitCargue, TituloIncompleto, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		boolean validarbtndescargaf = validarElemento(btnDescargar, 10);
		boolean validarbtncargarf = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		ValidacionObjetos(validarbtndescargaf,validarbtncargarf,"542493 Se valida la presencia de los botones de carge y descargue de archivos", folderPath);
		
		scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		
		
		scrollElementH(folderPath, ModificarMercancia, Mercancias);
		click(ModificarMercancia, folderPath, "click en visualizar liberacion");
		
		
		writeText(btnCalendar, "07072022", folderPath, "");
		click(btnGuardarCambios, folderPath, "");
		click(btnSeguroCambiar, folderPath, "");
		click(btnOkay, folderPath, "");
		
		click(btnCloseMercaciaEdicion, folderPath, "");
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
	
		click(btnCancelar, folderPath, "click en cancelar");	
		
		
		click(locatorVariable(lblModulos, ModuloS),folderPath,"");
		click(locatorVariable(lblsecciones, SeccionA),folderPath,"");
		writeText(SearchUsuary, usuario2, folderPath, "");

		screenshot(folderPath ,"Estos son los casos: " + Historico);
		
		
		return this;
		
		
	}
	
	//var dateControl = document.querySelector(btnTableofdates);
			//dateControl.value = "2017-06-01";
		
	//HU30 Verificacion de edicion de fechas con usuario super admin
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage UsuarioEditarAdmin_545511(File folderPath,String usuario2,String ModuloT,String SubModuloExpedir,
			String Titulobonoprenda,String infogeneraltitulo,String lblbonoprenda,
			String LapsoTiempo,String TituloNoEditable,String TituloEstadoAnulado,String Mercancias,String tipoUser ) throws Exception {
		
		
		writeText(SearchUsuary, usuario2, folderPath, "");
		searchElementGrid1(GridUsuario, tipoUser, folderPath, "Se valida tipo de usuario superadmin casos 545511, 545512, 545513, 545514");
		click(btnVisualizarUsuario, folderPath, "Click en visualizar usuario");
		scrollElementV(folderPath, txtEmailUsuario, "scroll hasta elemento deseado");
		
		
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitCargue, Titulobonoprenda, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo, Se visualiza campo fecha casos 545511, 545512, 545513, 545514");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo, Se visualiza campo fecha casos 545511, 545512, 545513, 545514");
		
		//desplazarseVertical(0, 600);
		click(btnVerBonoPrenda, folderPath, "Click en ver bono prenda,casos exitosos 545511, 545512, 545513, 545514, el elemento actualmente no permite realizar accion alguna sobre el pero es editable y cambia de acuerdo al caso");
		//scrollElementH(folderPath, FechaVencimiento, "scroll hasta elemento casos exitosos 545511, 545512, 545513, 545514, el elemento actualmente no permite realizar accion alguna sobre el pero es editable y cambia de acuerdo al caso");
		click(btnVerBonoPrenda, folderPath, "Click en ver bono prenda");
		
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en tiempo de prenda");
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en tiempo de prenda");
		
		
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");		
		writeText(txtNitCargue, TituloNoEditable, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo,Se visualiza fecha no editable 545513 ");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo");
		
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitCargue, Titulobonoprenda, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		
		boolean btnImpresion = validarElemento(btnVisualizarImpresiones, 10);
		ValidacionObjeto(btnImpresion, "Caso 545514 se valida boton impresiones", folderPath);
		
		click(btnVisualizarImpresiones, folderPath, "click en impresiones");
		
		
		
		boolean btnImpresionA = validarElemento(ImpresionA, 10);
		boolean btnImpresionCDM = validarElemento(ImpresionCDM, 10);
		ValidacionObjetos(btnImpresionA,btnImpresionCDM,"caso exitoso 545515, 545516, 545517 se valida impresion", folderPath);
		
		
		boolean btnImpresionBonoprenda = validarElemento(ImpresionBonoprenda, 10);
		ValidacionObjeto(btnImpresionBonoprenda,"caso exitoso 545515, 545516, 545517 se valida impresion", folderPath);
		
		//click(ImpresionA, folderPath, "click en impresion");
		//click(ImpresionCDM, folderPath, "click en impresion");
		//click(ImpresionBonoprenda, folderPath, "click en impresion");
			
		//screenshot(folderPath ,"Estos son los casos: " + FechaGeneracion);
		
		
		
		return this;
	}
	
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage UsuarioAplicador_554763(File folderPath,String usuario2,String ModuloT,String SubModuloExpedir,String titulograbado,
			String Titulobonoprenda,String infogeneraltitulo,
			String SubModuloExpedir1,String ModuloT1,String aplicador,String SeccionPerfil,String UsuarioAplicador ) throws Exception {
		
		
		
		click(locatorVariable(lblModulos, " Seguridad "),folderPath,"click en la seccion perfil");
		click(locatorVariable(lblsecciones, "Roles"),folderPath,"click en la seccion perfil");
		writeText(SearchRole, UsuarioAplicador, folderPath, "");
		searchElementGrid1(GridRoles, UsuarioAplicador, folderPath, "Se valida tipo de usuario aplicador caso 554748 ");
		click(btnVisualizarRolesExistentes, folderPath, "click en rol");
		
		//searchElementGrid(GridRol, aplicador, folderPath, "Se valida que el usuario sea aplicador");
		
		click(locatorVariable(lblsecciones, SeccionPerfil),folderPath,"click en la seccion perfil");
		writeText(txtBusquedaUsuario, aplicador, folderPath, "Se busca el perfil de aplicador");
		searchElementGrid(GridDePerfiles, aplicador, folderPath, "Se valida la existencia del perfil de aplicador 554763,554749");
		click(btnModificarPerfil, folderPath, "Click en modificar perfil");
			
		click(lblTitulo,folderPath,"click en la seccion perfil");
		click(lblExpedir,folderPath,"click en la seccion expedir");
		
		
		
		writeText(txtBuscarTitulo, titulograbado, folderPath, "buscar titulo con bodega propia, y estado grabado ");
		click(lblModificarHistorico, folderPath, "click en modificar titulo ");
		
		
		time(17);
		
		desplazarseVertical(0, 700);
		
		click(btnAplicar, folderPath, "click en aplicar");
		click(btnAceptarCambios, folderPath, "click en aceptar");
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso 554751 ,554763 ", folderPath);
		
		
		
		
		
		click(locatorVariable(lblsecciones, "Expedir"),folderPath,"click en la seccion perfil");
	
		writeText(txtBuscarTitulo, titulograbado, folderPath, "buscar titulo con bodega propia, y estado grabado ");
		click(lblModificarHistorico, folderPath, "click en modificar titulo ");
		
		time(17);
		desplazarseVertical(0, 700);
		
		
		
		click(btnSafe, folderPath, "guardar titulo ");
		click(btnAceptarCambios, folderPath, "click en aceptar");
		boolean alertaCreada = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(alertaCreada, "Validacion de creacion de titulo 554749", folderPath);
		
		
		//Expedir
		
		
		
		
		screenshot(folderPath ,"Estos son los casos: " + Aplicador);
		
		
		
		
		
		return this;}
	
	
	
	@Step("Crear expedir")
	public ExpedirPage MercanciaGenerica(File folderPath, String nitExpedir, String descripcion, String tipoMercanciaE,String SubModuloExpedir,String Titulobonoprenda)
			throws Exception 
	
	
	{
		
			
		click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir");
		writeText(txtNitRazonSocial, nitExpedir, folderPath, "Se ingresa el dato Nit");
		click(locatorVariable(lblOpciones2, tipoMercanciaE), folderPath, "Click en opciones titulo");
		listRandom(lblTipoMercancia, folderPath, "");
		writeText(txtDescripcionGeneral, descripcion, folderPath, "");
		listRandom(lblAplicaCondicion, folderPath, "");
		scrollElementV(folderPath, btnGuardarExpedir, tipoMercanciaE);
		click(btnGuardarExpedir, folderPath, "");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitCargue, Titulobonoprenda, folderPath, SubModuloExpedir);
		
		click(btnVisualizarImpresiones, folderPath, "click en modificar");
		click(ImpresionA, folderPath, "click en impresion de talon ");
		click(ImpresionCDM, folderPath, "click en impresion de talon");
		click(ImpresionBonoprenda, folderPath, "click en impresion de talon");
		submit(ImpresionA, folderPath, "");
		
		
		
		screenshot(folderPath ,"Estos son los casos: " + CP03);
		
		
		return this;
	}

	
	
	
	
	

	@Step("Ver Bodega de cargue")
	public ExpedirPage CP05(File folderPath,String usuario2,String ModuloT,String SubModuloExpedir,String Titulobonoprenda,String infogeneraltitulo,String lblbonoprenda,String LapsoTiempo,String TituloNoEditable ) throws Exception {
		
		
		
		
		writeText(SearchUsuary, usuario2, folderPath, "");
		click(btnVisualizarUsuario, folderPath, "Click en visualizar usuario");
		scrollElementV(folderPath, txtEmailUsuario, "scroll hasta elemento deseado");
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitCargue, Titulobonoprenda, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		
		desplazarseVertical(0, 400);
		
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo");
		//click(FechaExpedicion);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo");
		
		screenshot(folderPath ,"Estos son los casos: " + FechaGeneracion);
		
		return this;
	}
	
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage CP08(File folderPath,String usuario2,
			String ModuloT,String SubModuloExpedir,String TituloNoEditable,
			String Prorroga,String lblbonoprenda,
			String LapsoTiempo,String infogeneraltitulo,String Mercancias ) throws Exception {
		
		
		writeText(SearchUsuary, usuario2, folderPath, "");
		click(btnVisualizarUsuario, folderPath, "Click en visualizar usuario");
		scrollElementV(folderPath, txtEmailUsuario, "scroll hasta elemento deseado");
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		
		writeText(txtNitCargue, TituloNoEditable, folderPath, "Se escribe el titulo a buscar");
		
		String codigo = readText(NumberProrrogaValida, folderPath, "Escritura");
		
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		
		click(lblModificarHistorico, folderPath, "click en modificar titulo");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		//boolean validarbtndescargaE = validarElemento(btnDescargar, 10);
		//boolean validarbtncargarE = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		
		//ValidacionObjetos(validarbtncargarE,validarbtndescargaE,"542494 Se valida la no presencia de los botones de carge y descargue de archivos el caso 542494 es exitoso", folderPath);
		
		
		
		click(locatorVariable(lblsecciones, Prorroga),folderPath,"click en la seccion expedir");
		writeText(BusquedaProrroga, codigo, folderPath, "Se escribe el titulo a prorrogar");
		
		click(lblBusquedaProrroga, folderPath, "click en prorroga");
		
		desplazarseVertical(0, 600);
		
		click(lblBonoPrenda, folderPath, "Click sobre bono de prenda");
		
		desplazarseVertical(0, 400);
		
		writeRandomNum(txtplazoDeposito, 1);
		
		writeRandomNum(txtplazoCredito, 1);
		
		writeRandomNum(txtplazoCertificado, 1);
		
		click(btnGuardar, folderPath, "");
		
		click(btnAceptar, folderPath, "");
		
		click(locatorVariable(lblsecciones, Prorroga),folderPath,"click en la seccion expedir");
		
		writeText(BusquedaProrroga, codigo, folderPath, "Se escribe el titulo a prorrogar");
		
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		
		click(lblModificarHistorico, folderPath, "click en modificar");
		
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en bono de prenda");
		
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en bono de prenda");
		
		click(locatorVariable(lblOpciones, lblbonoprenda), folderPath, "Click en bono de prenda");
		
		click(locatorVariable(lblOpciones, lblbonoprenda), folderPath, "Click en bono de prenda");
		
		
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		
		writeText(txtNitCargue, TituloNoEditable, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, codigo);
		
		
		
		scrollElementV(folderPath, locatorVariable(lblOpciones, Mercancias), "scroll a  mercancias de titulo");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en  mercancias de titulo");
		
		// Validacion de botones de carga y descarga 
		
		//boolean validarbtndescarga = validarElemento(btnDescargar, 10);
		//boolean validarbtncargar = validarElemento(btnCargue1, 10);
	
		//ValidacionObjetos(validarbtndescargaf,validarbtncargarf,"542494 Se valida la presencia de los botones de carge y descargue de archivos, el caso 542494 es exitoso", folderPath);
		
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo");
		//click(FechaExpedicion);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo");
	
		screenshot(folderPath ,"Estos son los casos: " + Edicion);
		
		
		
		return this;
		
		
	}
	
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage ReversarLiberacion_558597(File folderPath,
			String ModuloT,String SubModuloExpedir,
			String estadoA,String infogeneraltitulo) throws Exception
	{
		
		
		
		//n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();
		String Titulo;
		Titulo = driver.findElement(ValorTituloReversable).getText();
		
		
		click(btnVisualizarReversion, folderPath, "click en visualizar reversion");
		scrollElementH(folderPath, chxReversar, "click en el check de reversar titulo");
		click(chxReversar, folderPath, "click en check de reversar");
		click(btnReversar, folderPath, "click en reversar");
		click(btnAceptarReversion, folderPath, "Click en aceptar, caso exitoso 558596,558597,558598");
		
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso exitoso 558601 ,558595, ", folderPath);
		
		
		
		
		
		click(lblExpedir, folderPath, "Click en expedir");
		
		writeText(txtNitCargue, Titulo, folderPath, SubModuloExpedir);
		searchElementGrid(GridTitulo, estadoA, folderPath, "estado aplicado");
		
		click(lblModificarHistorico, folderPath, "click en modificar");
		
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo");
		
		scrollElementV(folderPath, BodegaOpcionTransito, "scroll hasta bodega de transito ");
		boolean BodegaTransito = validarElemento(BodegaOpcionTransito, 10);
		ValidacionObjeto(BodegaTransito, "Validacion de aplicacion caso 558599 ,554763,558600,558602,558609 ", folderPath);
		
		
		
		return this;
		
		
	}
	
	
	
	
	
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage ProrrogasModificacion_546952(File folderPath,String TituloModificarProrroga,String SeccionP,String estadoA,String ValorProrroga) throws Exception {
		
		
		writeText(txtNitCargue, TituloModificarProrroga, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(lblModificarHistorico);
		
		searchElementGrid1(AlternativeGridstatus, estadoA, folderPath, "Se valida en estado aplicado caso 546952");
		String codigo = readText(NumberProrrogaValida, folderPath, "Escritura");
		click(locatorVariable(lblsecciones, SeccionP), folderPath, "Click en Prorrogar");
		writeText(txtCodigoTitulo, codigo, folderPath, "titulo con prorroga a buscar");
		click(lblBusquedaProrroga, folderPath, "click en prorroga");
		click(lblBonoPrenda, folderPath, "Click sobre bono de prenda");
		scrollElementV(folderPath, HeaderProrrogar, "Bajar a encabezados de la columna");
		
		searchElementGrid1(GridProrroga, ValorProrroga, folderPath, "Caso 546952,546953,546954 exitoso");
		scrollElementV(folderPath, lblPaginacion, SeccionP);
		screenshot(folderPath ,"Estos son los casos: " + Prorrogas);
		
		
		return this;
		
	}
	
	@Step("Crear expedir")
	public ExpedirPage OperacionTitulo_552036(File folderPath, 
			String TituloGrabado, String informacionGeneralE, String PersonaJuridica, String informacionG,String TituloHistorico)
			throws Exception {

	
	
			etiquetas(btnCrearExpedir, folderPath, "Etiqueta Crear expedir");
			click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir");
			click(btnCriterio, folderPath, "Se ingresa a crear expedir");
			click(RazonSocial, folderPath, "Se ingresa a crear expedir");
			writeText(txtNitRazonSocial, PersonaJuridica, folderPath, "Se ingresa el dato Nit");
			click(seleccionarNitRazon);
			waitInMs(2000);
			desplazarseVertical(0, 500);
			click(locatorVariable(lblOpciones, informacionGeneralE), folderPath, "Click en elemento");
			boolean btnTipoOperacion = validarElemento(TipoOperacion, 10);
			ValidacionObjeto(btnTipoOperacion, "Se valida boton de tipo de operacion", folderPath);
			desplazarseVertical(0, 500);
			click(locatorVariable(TipoOperacion, informacionGeneralE), folderPath, "Click en elemento, se desplega lista ");
			listRandom(TipoOperacion, folderPath, "Se selecciona valor random caso 552036,552037,552038,552039,552040 ");
			
			click(btnCancelarCreacion, folderPath, "");
			
		
			writeText(txtNitCargue, TituloGrabado, folderPath, "");
			click(lblModificarHistorico, folderPath, "click en modificar");
			click(locatorVariable(lblOpciones, informacionGeneralE), folderPath, "Click en elemento");
			boolean btnTipoOperacion2 = validarElemento(TipoOperacion, 10);
			ValidacionObjeto(btnTipoOperacion2, "Se valida boton de tipo de operacion caso 552036,552037,552038", folderPath);
			selectElementList(TipoOperacion, "Seleccione", folderPath, "Se deja sin seleccionar el tipo de operacion");
			desplazarseVertical(0, 500);
			click(btnAplicarCambios, folderPath, "click en Aplicar cambios  ");
			click(btnAceptar, folderPath, "click en Aceptar cambios  ");
			boolean btnTipoOperacion3 = validarElemento(btnAlertaTipoOperacion, 10);
			ValidacionObjeto(btnTipoOperacion3, "Se valida boton de tipo de operacion", folderPath);
			click(btnAlertaTipoOperacion, folderPath, "click en Aceptar cambios  ");
			
			click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en elemento Expedir ");
			//click(btnExpedirReal, folderPath, "click en expedir");
			
			writeText(txtNitCargue, TituloHistorico, folderPath, "");
			click(lblModificarHistorico, folderPath, "click en modificar");
			click(locatorVariable(lblOpciones, informacionGeneralE), folderPath, "Click en elemento");
			listRandom(TipoOperacion, folderPath, "Se selecciona valor random ");
			click(btnSaveChanges, folderPath, "click en guardar cambios  ");
			click(btnAceptar, folderPath, "click en Aceptar cambios  ");
			
			boolean btnTipoOperacion4 = validarElemento(AlertChangesSaved, 10);
			ValidacionObjeto(btnTipoOperacion4, "Se valida alerta de cambios realizados, caso exitoso 552036,552037,552038,552039,552040", folderPath);
			
			//RecargarPagina(AlertChangesSaved);
			
			//driver.switchTo().alert().accept();
			
			//
			
			
		return this;
	}

	
	
	//HU13
	
	@Step("Crear expedir")
	public ExpedirPage AutorizacionLiberacion_548143(File folderPath, 
			String TituloConLiberacionesPendientes, 
			String informacionGeneralE, 
			String PersonaJuridica, 
			String informacionG,String SubModuloAutorizar,
			String AutoriPend,String DetalleMercancia)
			throws Exception 
	{
		
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en elemento, se desplega lista ");
		writeText(TxtTituloLiberacion, TituloConLiberacionesPendientes, folderPath, "Se digita titulo de liberacion");
		click(btnSearchLiberacionButton, folderPath, "click en modificar");
		
		click(btnAutorizacionPendiente, folderPath, "Click en elemento, se desplega lista ");
		
		boolean CampoEdicionTxt = validarElemento(CampoModificarLiberacion, 10);
		ValidacionObjeto(CampoEdicionTxt, "caso 548142", folderPath);
		
		clear(CampoModificarLiberacion, folderPath, "Se elimina registros preexistentes");
		
		writeText(CampoModificarLiberacion, "50,4", folderPath, "");
		click(btnGuardarLiberacion, folderPath, "click en guardar cambios");
		
		boolean Alerta = validarElemento(AlertChangesSaved, 10);
		ValidacionObjeto(Alerta, "caso  exitoso 548142,548143,548144 cambios realizados", folderPath);
		
		//click(btnOkLiberacion, folderPath, "click en boton ok");
		//click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en elemento, se desplega lista ");
		
		writeText(TxtTituloLiberacion, TituloConLiberacionesPendientes, folderPath, "Se digita titulo de liberacion");
		click(btnSearchLiberacionButton, folderPath, "click en modificar");
		
		click(btnDetalleMercancia, folderPath, "Click en elemento, se desplega lista,Se visualiza informacion cambiada ");
		
		click(locatorVariable(lblsecciones, SubModuloAutorizar), folderPath, "Click en elemento, se desplega lista ");
		
		boolean VisualizarAutorizacion = validarElemento(btnVisualizarAutorizacionPendiente, 10);
		ValidacionObjeto(VisualizarAutorizacion, "caso 548144", folderPath);
		
		
		//click(btnVisualizarAutorizacionPendiente, folderPath, "click en visualizar autorizaciones, se visualiza caso 548144");
		//scrollElementH(folderPath, chxConfirmarLiberacion, "Se desplaza hasta checkbox de caso 548144");
		//RecargarPagina(lblsecciones);
		//acceptAlert(folderPath, "Se da aceptar");
		
		return this;
		
	}

	
	
	
	
}