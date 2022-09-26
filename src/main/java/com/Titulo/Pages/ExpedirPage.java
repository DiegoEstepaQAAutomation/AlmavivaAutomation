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

// TODO: Auto-generated Javadoc
/**
 * The Class ExpedirPage.
 */
public class ExpedirPage extends ExpedirMap {

	/** The x. */
	//objeto de tipo variable( en desuso)
	Object[] x;
	
	/** The val. */
	boolean val;
	
	/** The t. */
	int t = 15;
	
	
	/** The Validacion cargue. */
	//Strings con los casos existentes
	String ValidacionCargue = "542369, 542370, 542371";
	
	/** The Validacion titulos. */
	String ValidacionTitulos = "543825";
	
	/** The Validar liberacion. */
	String ValidarLiberacion = "543826, 543828, 543832, 543827";
	
	/** The Validar mercancia liberada. */
	String ValidarMercanciaLiberada = "543829, 543830";
	
	/** The Objeto presente. */
	String ObjetoPresente = "543831,543832";
	
	/** The Historico. */
	String Historico = "546943, 546944, 546945, 546946, 546947, 546948, 546949, 546950";

	/** The Prorrogas. */
	String Prorrogas = "546952";
	
	/** The Polizas. */
	String Polizas ="547049, 547050, 547051, 547054, 547055"; 
	
	/** The Fecha generacion. */
	String FechaGeneracion="545511, 545512, 545513, 545514 ";
	
	/** The hu30. */
	String HU30 ="545511, 545512, 545513, 545514 ";
	
	/** The Edicion. */
	String Edicion ="545515, 545516, 545517 ";
	
	/** The cp03. */
	String CP03 = "550319, 550320,550321, 552082, 552086, 552087";
	
	/** The Aplicador. */
	String Aplicador="554748,554763,554749,554750,554751";
	
	/**
	 * Instantiates a new expedir page.
	 *
	 * @param driver the driver
	 */
	public ExpedirPage(WebDriver driver) {
		super(driver);
	}
	
	//Creacion de expedicion pero con seleccion multiple de tipo de bodega

	/**
	 * Crear expedir.
	 *
	 * @param folderPath the folder path
	 * @param n the n
	 * @param t the t
	 * @param o the o
	 * @param informacionG the informacion G
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Crear expedir")
	public ExpedirPage crearExpedir(File folderPath, String n, String t, String o, String informacionG,String Evidencia)
			throws Exception {
		
		//CODIGO HECHO POR DIEGO ESTEPA,ALMAVIVA
		
		String tb = null;

		//Se obtiene valor de localizador
		n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();

		//Se busca un titlo y se modifica
		writeText(txtNitCliente, n);
		click(btnBuscarCliente);
		scrollElementH(btnVerCliente);
		click(btnVerCliente);
		click(lblTipoBodegaCliente);

		t = driver.findElement(By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText();
		o = driver.findElement(By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[5]")).getText();

		
		// Ciclo de seleccion de tipo de bodega
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
			//Metodo de validar etiqueta, valida una etiqueta existente  
			etiquetas(btnCrearExpedir, folderPath, "Etiqueta Crear expedir",Evidencia);
			//Click sobre un elemento
			click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir",Evidencia);
			// se escribe un string en este caso del localizador existente del que se tomo un valor
			writeText(txtNitRazonSocial, n, folderPath, "Se ingresa el dato Nit",Evidencia);
			//Click sobre el parametro nit razon
			click(seleccionarNitRazon);
			//tiempo espera de codigo
			waitInMs(2000);
			//Click sobre localizador en especifico 
			click(locatorVariable(lblOpciones, informacionG), folderPath, "Click en elemento",Evidencia);
			//Scroll hacia abajo
			scrollDown();
			//Tiempo de espera 
			waitInMs(500);
			//Selecciona elemento de oficina responsable deacuerdo al ciclo establecido
			selectElementList(lblOficinaResponsable, o);
			//Selecciona elemento de oficina responsable deacuerdo al ciclo establecido
			selectElementList(lblTipoBodega, tb);
			//Click en Bodega 
			click(lblBodega);
			click(lblBodegaOpcion, folderPath, "click en opcion",Evidencia);

		} else {
			printConsole("Error");
			Assert.fail("Error");
		}
		return this;
	}
	
	
	//Paso de seleccion de tipo de operacion
	
	/**
	 * Tipo operacion.
	 *
	 * @param folderPath the folder path
	 * @param n the n
	 * @param t the t
	 * @param o the o
	 * @param infogeneraltitulo the infogeneraltitulo
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Crear expedir")
	public ExpedirPage tipoOperacion(File folderPath, String n, String t, String o, String infogeneraltitulo,String Evidencia)
			throws Exception 
	
	
	
	{
		//Obtenemos un elemento de texto existente en un xpath
		
		n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();

		//Escribimos dicho elemento en el buscador de Titulos
		writeText(txtNitCliente, n);
		
		//Click en buscar cliente
		click(btnBuscarCliente);
		//Click en crear nuevo titulo
		click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir",Evidencia);
		
		//Escribimos el texto tomado del localizador ya usado
		writeText(txtNitRazonSocial, n, folderPath, "Se ingresa el dato Nit",Evidencia);
		//Click en la opcion Nit razon social
		click(seleccionarNitRazon);
		
		//Tiempo de espera
		waitInMs(2000);
		//Click en localizador pero se envia con variable
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en elemento",Evidencia);
		//Scroll hacia abajo
		scrollDown();

		
		
		
		
		return this;
		
	}

	
/**
 * Lpn dtlnum coincidan 1.
 *
 * @param folderPath the folder path
 * @param TipoDeBodega the tipo de bodega
 * @param estadoA the estado A
 * @param Mercancias the mercancias
 * @param Lista the lista
 * @param Lpm the lpm
 * @param dataBDD the data BDD
 * @param SubModuloExpedir the sub modulo expedir
 * @param Lista1 the lista 1
 * @return the expedir page
 * @throws Exception the exception
 */
//////HU16 CONTINU Continuacion del HU16
	@Step("Hu16")
 public ExpedirPage LpnDtlnumCoincidan1(File folderPath,String TipoDeBodega,String estadoA,String Mercancias,
 		String Lista,String Lpm,
 		String dataBDD,
 		String SubModuloExpedir,
 		//String dataBDD2
 		String Lista1,String Evidencia) throws Exception {


	//Escritura del titulo
     writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo",Evidencia);
     //Validacion de un elemento en una grilla
     searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia",Evidencia);
     //Scroll vertical hacia un elemento hacia abajo
     scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo",Evidencia);
     //Validacion de un elemento existente en una grilla
     searchElementGrid(FrameofGridClient1, estadoA, folderPath,"Se valida estado titulo aplicada",Evidencia);
     //Click en modificar titulo
     click(btnModificar, folderPath, "Click en modificar cliente",Evidencia);
     //Click en localizador por variable
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ",Evidencia);
     //Dezplazamiento vertical por coordenada
     desplazarseVertical(0, 250);
     //Validacion de un elemento existente en una grilla
     searchElementGrid(FrameofGridList, Lista, folderPath,"Se valida la lista ",Evidencia);
     //Dezplazamiento vertical por coordenada
     desplazarseVertical(0, 500);
     //Click en filtro de busqueda
     click(btnSelectFiltro, folderPath, "click selecfiltro",Evidencia);
     //click en elemento en especifico del filtro
     click(btnFiltro, folderPath, "click filtro",Evidencia); 
     //searchElementGridExcel2(FrameofGridExcel, folderPath,"Se lee LA TABLA");
     //searchElementGridExcel(FrameofGridExcel, folderPath,"Se lee LA TABLA");
     
     //Captura de pantalla
     captureScreen(folderPath, dataBDD,Evidencia);
     //Click en localizador por variable
     click(locatorVariable(btnActualizarLpm, Lpm), folderPath, "Click en Actualizar Lpm ",Evidencia);
     //click en localizador
     click(btnActualizarCantidades, folderPath, "click Actualizar Cantidades",Evidencia);
     //Se establece variable boolean de un localizador
     boolean validarAlertaCargue = validarElemento(AlertaCargue, 10);
     //Se valida variable booleana
		ValidacionObjeto(validarAlertaCargue, "Validacion", folderPath,Evidencia);
		
		//cp02
		//Click en variable de localizador
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		//Se escribe en el campo buscar titulo un titulo
		writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo",Evidencia);
		//Se busca en tabla o grilla un tipo de bodega en especifico
		searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia",Evidencia);
		//Se hace scroll vertical hacia localizador
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo",Evidencia);
		//Se busca elemento presente  en una grilla
     searchElementGrid(FrameofGridClient1, estadoA, folderPath,"Se valida estado titulo aplicada",Evidencia);
     //Click en modificar titulo
     click(btnModificar, folderPath, "Click en modificar cliente",Evidencia);
     //click en localizador por variable
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ",Evidencia);
     //Scroll vertical por coordenada
     desplazarseVertical(0, 500);
     //Click en localizador
     click(btnSelectFiltro, folderPath, "click selecfiltro",Evidencia);
     //Click en localizador
     click(btnFiltro, folderPath, "click filtro",Evidencia); 
     //captureScreen(folderPath, dataBDD2);
     searchElementGrid(FrameofGridList1, Lista1, folderPath,"Se valida la fila de la lista ",Evidencia);
     captureScreen(folderPath, dataBDD,Evidencia);
     click(locatorVariable(btnActualizarLpm, Lpm), folderPath, "Click en Actualizar Lpm ",Evidencia);
     //Click en localizador
     click(btnActualizarCantidades, folderPath, "click Actualizar Cantidades",Evidencia);
     boolean validarAlertaCargue1 = validarElemento(AlertaCargue, 10);
		ValidacionObjeto(validarAlertaCargue1, "Validacion", folderPath,Evidencia);
		 //Click en localizador
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		//Se escribe titulo en campo de busqueda
		writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo",Evidencia);
		//Se busca elemento presente en grilla
		searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia",Evidencia);
		//Scroll vertical hacia modificar titulo
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo",Evidencia);
		 //Click en localizador
		click(btnModificar, folderPath, "Click en modificar cliente",Evidencia);
		 //Click en localizador
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ",Evidencia);
     //desplazarseVertical(0, 300);
     
     //Se crea una variable booleana de cantidad de productos
     boolean validarProducto = validarElemento(lblProductos, 10);
     //se valida variable creada
		ValidacionObjeto(validarProducto, "Validacion de los productos", folderPath,Evidencia);
		//Scroll horizontal hacia etiqueta CJ
		scrollElementH(folderPath, lblCJ, "scroll",Evidencia);
		//Se crea variable booleana de cantidad de saldo
		boolean cantidadSaldo = validarElemento(lblCantidadSaldo, 10);
		//Se valida variable booleana de cantidad de saldo
		ValidacionObjeto(cantidadSaldo, "Validacion de Cantidad Saldo", folderPath,Evidencia);
		

     return this;
	}

	//////////////////// HU07

	/**
	 * Validacion expedir formulario 1 556552.
	 *
	 * @param folderPath the folder path
	 * @param Empresa2 the empresa 2
	 * @param InfGTitulo the inf G titulo
	 * @param NumeroTitulo the numero titulo
	 * @param SubModuloExpedir the sub modulo expedir
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Validaciones en el formulario de creacion de titulo
	@Step("Ver Titulo Expedir")
	public ExpedirPage ValidacionExpedirFormulario1_556552(File folderPath, String Empresa2, String InfGTitulo,
			String NumeroTitulo, String SubModuloExpedir,String Evidencia) throws Exception {
		
		//Click en el localizador de crear titulo
		click(btnCrearExpedir, folderPath, "click en crearExpedir",Evidencia);
		//Click en criterio de busqueda de titulo
		click(btnNit2, folderPath, "click en Razon",Evidencia);
		//Click en razon social
		click(btnNit, folderPath, "click en Razon Social",Evidencia);
		//Se escribe el titulo a buscar
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro",Evidencia);
		//click en localizador
		click(btnSelecClaro, folderPath, "click en Claro",Evidencia);
		//click en localizador
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ",Evidencia);
		//Desplazamiento vertical por coordenada
		desplazarseVertical(0,300);
		//Se busca elemento presente en una grilla, en este caso numero de titulo
		searchElementGrid(txtNumeroTitulo, NumeroTitulo, folderPath, "Se valida el numero de titulos",Evidencia);
		//Desplazamiento vertical por coordenada
		desplazarseVertical(0,300);
		//click en localizador en este caso boton de ingresos
		click(btnIngreso, folderPath, "Se verifica Division de ingreso",Evidencia);
		//se selecciona valor random de una lista del campo ingresos
		listRandom(btnIngreso, folderPath, "caso  exitoso 556550,556551, Se verifica Division de ingreso",Evidencia);
		//click en localizador por variable en este caso submodulo expedir
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		//click en localizador
		click(btnSalirSinGuardar, folderPath, "Salir sin Guardar",Evidencia);
		
		return this;
	}
	 
	/////////HU07  Contunuacion
	/**
	 * Validacion expedir division ingresos.
	 *
	 * @param folderPath the folder path
	 * @param InfGTitulo the inf G titulo
	 * @param ingreso the ingreso
	 * @param aplicar the aplicar
	 * @param SubModuloExpedir the sub modulo expedir
	 * @param OficnaExpedicion the oficna expedicion
	 * @param oficinaAlmacenamiento the oficina almacenamiento
	 * @param estadoA the estado A
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Validaciones en el area de division de ingresos
	@Step("Ver Titulo Expedir")
	public ExpedirPage ValidacionExpedirDivisionIngresos(File folderPath, String InfGTitulo, String ingreso, 
			String aplicar, String SubModuloExpedir, String OficnaExpedicion, String oficinaAlmacenamiento,
			String estado,String Evidencia) throws Exception {
		
		//Se escribe un titulo a buscar 
		writeText(txtNitCargue, "1795");
		//Se hace scroll hacia modificar titulo
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo",Evidencia);
		//Click en modificar titulo
		click(btnModificar, folderPath, "Click en modificar cliente",Evidencia);
		//Click en localizador por variable
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ",Evidencia);
		//Scroll vertical por coordenada
		desplazarseVertical(0,600);
		//Click en el menu division de ingresos
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso",Evidencia);
		//click en si
		click(lblDivisionIngreso2, folderPath, "click en si",Evidencia);
		//Click en localizador por variable
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso",Evidencia);
		//Scroll vertical por coordenada
		desplazarseVertical(0,300);
		//Se escribe un valor en cuadro de texto
		writeText(btnPorcentajeEx, "50", folderPath, "Se escribe el Porcentaje Expedicion",Evidencia);
		//Se escribe un valor en cuadro de texto
		writeText(btnPorcentajeAlm, "60", folderPath, "Se escribe el Porcentaje Almacenamiento",Evidencia);
		//Click en localizador por variable
		click(locatorVariable(btnAplicar, aplicar), folderPath, "Click en Aplicar",Evidencia);
		//Click en localizador 
		click(btnAceptar, folderPath, "click en Aceptar cambios ",Evidencia);
		//Se crea variable booleana de una alerta de una liberacion de un titulo
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
		//Se valida alerta de liberacion de titulo
     ValidacionObjeto(alertaCreadaAplicada, "Validacion de la suma del porcentaje deben ser 100 caso exitoso 556554 ", folderPath,Evidencia);
     
     //cp06
   //Click en localizador por variable 
     click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
   //Se escribe un valor en cuadro de texto de busqueda de titulo
     writeText(txtNitCargue, "1795");
   //Se hace scroll hacia modificar titulo
     scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo",Evidencia);
   //Click en localizador por variable 
     click(btnModificar, folderPath, "Click en modificar cliente",Evidencia);
   //Click en localizador por variable 
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ",Evidencia);
		//Scroll vertical por coordenada
		desplazarseVertical(0,600);
		 //Click en localizador en este caso menu de division de ingreso
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso",Evidencia);
		//Click en localizador en este caso menu de division de ingreso en este caso se selecciona la opcion no
		click(lblDivisionIngreso3, folderPath, "click en NO",Evidencia);
		 //Click en localizador en este caso menu de division de ingreso
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso",Evidencia);
		//Scroll vertical por coordenada
		desplazarseVertical(0,300);
		//Se valida elemento existente en grilla en este caso oficina de expedicion
		searchElementGrid(txtOficinaExpedicion, OficnaExpedicion, folderPath, "556555,Se valida Oficina expedicion",Evidencia);
		//Se valida elemento existente en grilla en este caso oficina de almacenamiento
		searchElementGrid(txtOficinaAlmacenamiento, oficinaAlmacenamiento, folderPath, "556555,Se valida porcentaje expedicion",Evidencia);
		//Se crea variable de tipo booleano de campo de texto codigo SAP
		boolean CodigoSapExp = validarElemento(txtCodigoSapExp, 10);
		//Se valida variable  de tipo booleano de campo de texto codigo SAP
     ValidacionObjeto(CodigoSapExp, "Validacion del Codigo Sap Expedicion caso exitoso 556557 ", folderPath,Evidencia);
   //Se escribe un valor en las opciones de codigo SAP 
     writeText(txtCodigoSapExp, "WDV753", folderPath, "Se escribe el Codigo Sap Expedicion",Evidencia);
     //Click en localizador en este caso menu de division de ingreso
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		
		//cp07
		//Se escribe un valor en cuadro de texto de busqueda de titulo, en este caso un titulo a buscar
		writeText(txtNitCargue, "1905");
		//Scroll hacia modificar titulo
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo",Evidencia);
		//Se busca estado ACTIVO en grilla de titulo
		searchElementGrid(ClientEstatus1, estado, folderPath,"Se valida estado de titulo como Aplicado Caso 556556",Evidencia);
		//Click en visualizar impresiones
		click(btnVisualizarImpresiones, folderPath, "click en impresiones",Evidencia);
		
		//##Se establecen como variables booleanas cada una de las caras de las impresiones 
		boolean btnImpresionBonoprenda = validarElemento(ImpresionBonoprenda, 10);
		boolean btnImpresionBonoprendaB = validarElemento(ImpresionBonoprendaB, 10);
		boolean btnImpresionCDM = validarElemento(ImpresionCDM, 10);
		boolean btnImpresionCDMB = validarElemento(ImpresionCDMB, 10);
		boolean btnImpresionA = validarElemento(ImpresionA, 10);
		boolean btnImpresionB = validarElemento(ImpresionB, 10);
		
		//**Se validan cada una de las caras de las impresiones, mediante el envio de las variables booleanas a validar objeto
		ValidacionObjetos(btnImpresionBonoprenda, btnImpresionBonoprendaB,"caso exitoso 556556 se valida impresion",folderPath,Evidencia);
		ValidacionObjetos(btnImpresionCDM, btnImpresionCDMB,"caso exitoso 556556 se valida impresion",folderPath,Evidencia);
		ValidacionObjetos(btnImpresionA, btnImpresionB,"caso exitoso 556556 se valida impresion",folderPath,Evidencia);

		return this;
	}
	
	
	
	

	/**
	 * Bono.
	 *
	 * @param folderPath the folder path
	 * @param bono the bono
	 * @param nitB the nit B
	 * @param nitBono the nit bono
	 * @param diasPlazo the dias plazo
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Se utiliza este paso para realizar validaciones de la opcion bono de creacion de titulo
	@Step("Bono de Prenda")
	public ExpedirPage bono(File folderPath, String bono, String nitB, String nitBono, String diasPlazo,String Evidencia)
			throws Exception {

		//Click en criterio de titulo
		click(lblTipoTitulo);
		//Click en titulos por bonos
		click(lblTipoTituloBono, folderPath, "Click en tipo titulo de bono",Evidencia);
		//Se da click en el campo de bono dentro del titulo
		click(locatorVariable(lblOpciones, bono), folderPath, "Click en opciones titulo",Evidencia);
		//click en creacion de bono
		click(btnCrearBono, folderPath, "Click en crear bono",Evidencia);
		//Se selecciona elemento de la lista de certificado de bono y se coloca un nit
		selectElementList(lblNitNombreCertificado, nitB);
		//Se escribe un nit que ya tiene asociado un bono
		writeText(txtNitNombreBono, nitBono, folderPath, "Se escribe Nit",Evidencia);
		//click en localizador de nombre en la seccion bono
		click(seleccionarNitNombreBono);
		//Se escribe un valor random numerico en el campo de texto capital inicial
		writeRandomNum(txtCapitalInicial, 4);
		//Se escriben los dias de plazo
		writeText(txtDiasPlazo, diasPlazo, folderPath, "Se escribe Dias de plazo",Evidencia);
		//Se escribe un valor random numerico en el campo de tipo de interes
		writeRandomAlp(txtTipoInteres, 35);
		//Se escribe un valor random numerico en el campo de texto valor de interes
		writeRandomNum(txtValorInteres, 10);
		//Se escribe un valor random numerico en el campo de texto frecuencia
		writeRandomAlp(txtFrecuencia, 20);
		//click en guardar bono
		click(btnGuardarBono, folderPath, "Click en guardar bono",Evidencia);
		//click en aceptar
		click(btnAceptarBono, folderPath, "Click en aceptar bono",Evidencia);
		//Tiempo de espera
		waitInMs(500);
		//Click en el campo bono 
		click(locatorVariable(lblOpciones, bono), folderPath, "click en campo bono",Evidencia);
		return this;
	}

	
	/**
	 * Certificado.
	 *
	 * @param folderPath the folder path
	 * @param certificado the certificado
	 * @param nitCertificado the nit certificado
	 * @param nitC the nit C
	 * @param tipoEndoso the tipo endoso
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Paso a paso de certificado de deposito de mercancia
	@Step("Certificado de Depósito de Mercancía")
	public ExpedirPage certificado(File folderPath, String certificado, String nitCertificado, String nitC,
			String tipoEndoso,String Evidencia) throws Exception {

		// Long day = Long.valueOf(new
		// SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));

		//click en localizador de certificado
		click(locatorVariable(lblOpciones, certificado), folderPath, "Click en opciones titulo",Evidencia);
		//click en crear certificado
		click(btnCrearCertificado, folderPath, "Click en crear bono",Evidencia);
		//Seleccionar de opcion el tipo de certificado
		selectElementList(lblNitNombreCertificado, nitCertificado);
		//Se difita nit a buscar
		writeText(txtNitNombre, nitC, folderPath, "Se escribe Nit",Evidencia);
		//click en localizador
		click(seleccionarNitNombre);
		//se selecciona tipo de endoso
		selectElementList(lblTipoEndoso, tipoEndoso);
		
		// click(txtFechaEndoso);
		
	

		//click(btnGuardarEndoso, folderPath, "");
		waitInMs(20000);
		// click(locatorVariable(lblOpciones, certificado), folderPath, "");
		return this;
	}

	/**
	 * Plazos.
	 *
	 * @param folderPath the folder path
	 * @param plazos the plazos
	 * @param pCertificado the certificado
	 * @param pContrato the contrato
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Paso a paso de creacion de plazos
	@Step("Plazos")
	public ExpedirPage plazos(File folderPath, String plazos, String pCertificado, String pContrato,String Evidencia) throws Exception {

		//Click en plazos
		click(locatorVariable(lblOpciones, plazos), folderPath, "Click en opciones titulo",Evidencia);
		//se escribe un plazo de certificado
		writeText(txtPlazoCertificado, pCertificado, folderPath, "Se escribe plazo certificado",Evidencia);
		//se escribe un plazo de contrato
		writeText(txtPlazoContatro, pContrato, folderPath, "Se escribe plazo contrato",Evidencia);
		//Se da click en plazos para cerrar este menu
		click(locatorVariable(lblOpciones, plazos), folderPath, "Click en opciones titulo",Evidencia);
		return this;
	}
	
	

	//HU10 
	/**
	 * Poliza 547049.
	 *
	 * @param folderPath the folder path
	 * @param poliza the poliza
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	// Paso a paso de creacion de poliza
	@Step("Póliza")
	public ExpedirPage poliza_547049(File folderPath, String poliza,String Evidencia) throws Exception {

		//Se da click en el modulo titulo
		click(locatorVariable(lblModulos, " Título "), folderPath, "Click en opciones titulo",Evidencia);
		//click en submodulo expedir
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en opciones titulo",Evidencia);
		//se escribe titulo de cliente a buscar
		writeText(txtNitCliente, "1661", folderPath, "escribir titulo cliente",Evidencia);
		//Click en modificar cliente
		click(btnModificar, folderPath, "Click en modificar cliente",Evidencia);
		//click en la opcion poliza
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en menu opciones poliza",Evidencia);
		//se escribe un valor random en el campo de texto poliza
		listRandom(lblPoliza, folderPath, "Se selecciona valor random,caso exitoso 547049,547050,547051,547054,547055",Evidencia);
		//click en la opcion poliza para cerrar la seccion de poliza
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en menu opciones poliza",Evidencia);
		return this;
	}

	/**
	 * Tipo mercancia.
	 *
	 * @param folderPath the folder path
	 * @param tipoMercancia the tipo mercancia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Tipo de Mercancía")
	public ExpedirPage tipoMercancia(File folderPath, String tipoMercancia,String Evidencia) throws Exception {

		
		//click en tipo de mercancia
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en menu opciones tipos de mercancia",Evidencia);
		//Se selecciona valor random en el tipo de mercancia
		listRandom(lblTipoMercancia, folderPath, "Se selecciona valor random",Evidencia);
		//se escribe valor random alfanumerico en descripcion general
		writeRandomAlp(txtDescripcionGeneral, 40);
		//Se escribe valor random numerico en la caja de texto de merma
		writeRandomNum(txtMerma, 4);
		//Se selecciona valor random en si o no  de aplicar condicion
		listRandom(lblAplicaCondicion, folderPath, "Se selecciona valor random",Evidencia);
		//se escribe valor alfanumerico random en observaciones
		writeRandomAlp(txtObservaciones, 10);
		//Scroll hacia arriba 
		scrollUp();
		//click en tipo de mercancia para cerrar esta seccion
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia",Evidencia);
		return this;
	}

	/**
	 * Mercancias individual.
	 *
	 * @param folderPath the folder path
	 * @param mercancias the mercancias
	 * @param cargueI the cargue I
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Mercancías 'Individual'")
	public ExpedirPage mercanciasIndividual(File folderPath, String mercancias, String cargueI,String Evidencia) throws Exception {

		//Proceso de mercancias con cargue individual
		click(locatorVariable(lblOpciones, mercancias), folderPath, "Click en opciones tipo mercancias",Evidencia);
		selectElementList(lblTipoCargue, cargueI, folderPath, "Se selecciona valor de lista",Evidencia);
		click(btnCrearCargueIndividual, folderPath, "Click en crear mercancia",Evidencia);
		writeRandomAlp(txtDetalleMercancia, 40);
		listRandom(lblUnidadMedida, folderPath, "Se selecciona valor random de la lista",Evidencia);
		listRandom(lblUnidadMedidaSuper, folderPath, "Se selecciona valor random de la lista",Evidencia);
		writeRandomNum(txtValorConversion, 2);
		writeRandomNum(txtCantidad, 18);
		writeRandomNum(txtValorUnitario, 28);
		//Se escribe una fecha utilizando el metodo dateplusyear para sumar un año a la fecha actual
		writeText(txtFechaVencimientoMercancia, datePlusYear(3));
		writeRandomAlp(txtObservacionMercancia, 100);
		//se guarda mercancia 
		click(btnGuardarMercancia, folderPath, "Click en guardar mercancia",Evidencia);
		click(btnAceptarMercancias, folderPath, "Click en aceptar mercancia",Evidencia);
		click(locatorVariable(lblOpciones, mercancias), folderPath, "Se selecciona valor de opciones",Evidencia);
		return this;
	}

	/**
	 * Tarifas.
	 *
	 * @param folderPath the folder path
	 * @param tarifas the tarifas
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Paso a paso de tarifas
	@Step("Tarifas")
	public ExpedirPage tarifas(File folderPath, String tarifas,String Evidencia) throws Exception {

		click(locatorVariable(lblOpciones, tarifas), folderPath, "Click en opciones tarifas",Evidencia);
		writeRandomNum(txtTarifa, 15);
		writeRandomNum(txtMinima, 50);
		click(locatorVariable(lblOpciones, tarifas), folderPath, "Click en opciones tarifas",Evidencia);
		return this;
	}

	/**
	 * Guardar expedir.
	 *
	 * @param folderPath the folder path
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Guardar expedir
	@Step("Guardar expedir")
	public ExpedirPage guardarExpedir(File folderPath,String Evidencia) throws Exception {

		click(btnGuardarExpedir, folderPath, "Click en Guardar y expedir",Evidencia);
		return this;
	}

	/**
	 * Imprimir.
	 *
	 * @param folderPath the folder path
	 * @param titulo the titulo
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Se realizan impresiones
	@Step("Imprimir")
	public ExpedirPage imprimir(File folderPath, String titulo,String Evidencia) throws Exception {

		
		//proceso para visualizar impresiones
		writeText(txtBuscarTitulo, titulo);
		click(btnBuscarTitulo, folderPath, "Click en buscar titulo",Evidencia);
		scrollElementH(btnImprimir);
		etiquetas(btnImprimir, folderPath, "Se evidencia etiqueta imprimir",Evidencia);
		click(btnImprimir, folderPath, "Click en buscar imprimir",Evidencia);
		
		val = validarElemento(lblImprimirOriginal, t);

	    if (Boolean.FALSE.equals(val)) {
	    	GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + lblImprimirOriginal,Evidencia);
	        Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + lblImprimirOriginal);
	    }
		escape();
		return this;
	}
	
	//Metodo para validar opcion scav en expedir titulo
	@Step("Imprimir")
	public ExpedirPage ValidacionScav_571761(File folderPath,
			String valorGrillaCupo2,String ValorGrillaCupo3,
			String ValorGrillaCupo7,String ValorGrillaTipoTitulo,
			String ValorGrillaCupo8,String Evidencia) throws Exception {

	
		//LLamamos al metodo ver expedir
		verExpedir(folderPath, Evidencia);
		
		//Validacion mediante variable booleana del boton scav
		boolean ScavButtonOption = validarElemento(btnScav, 5);
		ValidacionObjeto(ScavButtonOption, "Caso exitoso 571755", folderPath, Evidencia);
		click(btnScav, folderPath, "click en scav", Evidencia);
		
		//Cancelamos operacion y volvemos a entrar pero a modificar
		//scrollElementV(folderPath, btnCancelarAlterno, "scroll hasta cancelar", Evidencia);
		click(btnCancelarAlterno2, folderPath, "click en cancelar", Evidencia);
		time(15);
		
		scrollElementV(folderPath, btnModificar2, "scroll a modificar", Evidencia);
		click(btnModificar2, folderPath, "click en modificar", Evidencia);
		
		time(30);
		
		//desplazarseVertical(0, 600);
		//scrollElementV(folderPath, btnScav, "scroll hasta boton scav", Evidencia);
		//Busqueda de encabezados de informacion de scav
		click(btnScav, folderPath, "click en scav", Evidencia);
		
		//571759
		time(3);
		desplazarseVertical(0, 600);
		time(10);
		//Validacion de valores en grilla
		searchElementGrid(ScavGridTitulo, valorGrillaCupo2, folderPath, "Caso exitoso 571756", Evidencia);
		searchElementGrid(ScavGridTitulo, ValorGrillaCupo3, folderPath, "validacion campo", Evidencia);
		searchElementGrid(ScavGridTitulo, ValorGrillaCupo7, folderPath, "validacion campo", Evidencia);
		searchElementGrid(ScavGridTitulo, ValorGrillaTipoTitulo, folderPath, "validacion campo", Evidencia);
		searchElementGrid(ScavGridTituloValores, ValorGrillaCupo8, folderPath, "Caso exitoso 571759", Evidencia);
		//Obtencion de valor unico de ficha
		String ficha = readText(txtFichaAprobacion, folderPath, "obtenemos el codigo de ficha", Evidencia);
		isEnabled(txtFichaAprobacion, folderPath,"Caso 571757 exitoso El consecutivo unico es" + ficha, Evidencia);
		
		//Busqueda de valores diferentes
		clear(txtFichaAprobacion, folderPath, "limpia campo", Evidencia);
		writeRandomAlp(txtFichaAprobacion, 11);
		click(btnSearch, folderPath, "click en buscar consecutivo", Evidencia);
		time(3);
		boolean alertaBusqueda = validarElemento(AlertaBusqueda, 5);
		ValidacionObjeto(alertaBusqueda, "Caso exitoso 571758,571762,571761", folderPath, Evidencia);
		time(3);
		clear(txtFichaAprobacion, folderPath, "limpia campo", Evidencia);
		//writeText(txtFichaAprobacion, ficha, folderPath, "escribimos de nuevo nuestra ficha de referencia", Evidencia);
		click(btnSearch, folderPath, "click en buscar consecutivo", Evidencia);
		
		click(btnCancelarAlterno, folderPath, "click en modificar", Evidencia);
		time(8);
		
		return this;
		
	}

	
	
	
	
	/**
	 * Modificar expedir.
	 *
	 * @param folderPath the folder path
	 * @param titulo the titulo
	 * @param poliza the poliza
	 * @param tipoMercancia the tipo mercancia
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Modificaciones a titulos expedidos
	@Step("Modificar expedir")
	public ExpedirPage modificarExpedir(File folderPath, String titulo, String poliza, String tipoMercancia,String Evidencia) throws Exception {
		
		//Proceso para visualizar y modificar titulo
		writeText(txtBuscarTitulo, titulo);
		click(btnBuscarTitulo, folderPath, "Click en buscar titulo",Evidencia);
		scrollElementH(btnImprimir);
		etiquetas(btnModificar, folderPath, "Se evidencia etiqueta modificar expedicion",Evidencia);
		click(btnModificar, folderPath, "Click en modificar",Evidencia);

		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en opciones poliza",Evidencia);
		listRandom(lblPoliza, folderPath, "Se selecciona un objeto random",Evidencia);
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en opciones poliza",Evidencia);
		
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia",Evidencia);
		listRandom(lblTipoMercancia, folderPath, "Se selecciona elemento random de la lista",Evidencia);
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia",Evidencia);
		click(btnGuardarExpedir, folderPath, "Click en Guardar y expedir",Evidencia);
		click(btnAceptarGuardarModificar, folderPath, "Click en Guardar y modificar",Evidencia);
		
		//Validacion antigua (en desuso)
		val = validarElemento(lblGudadoExitoso, t);

	    if (Boolean.FALSE.equals(val)) {
	    	GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + lblGudadoExitoso,Evidencia);
	        Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + lblGudadoExitoso);
	    }
		return this;
	}
	
	/**
	 * Ver expedir.
	 *
	 * @param folderPath the folder path
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Paso a paso de visualizar un titulo
	@Step("Ver expedir")
	public ExpedirPage verExpedir(File folderPath,String Evidencia) throws Exception {

		//se ingresa a un titulo ya creado
		scrollElementH(folderPath, btnVerExpedir, "Se desplaza hasta la opción Ver expedir",Evidencia);
		etiquetas(btnVerExpedir, folderPath, "Etiqueta Ver expedir",Evidencia);
		click(btnVerExpedir, folderPath, "Se ingresa a ver expedir",Evidencia);

		
		//se utiliza is enabled para verificar que los campos de los localizadores estan en enabled 
		isEnabled(txtNit, folderPath, "Campo Nit No editable",Evidencia);
		isEnabled(txtNombreRazon, folderPath, "Campo Nombre/Razón social No editable",Evidencia);
		isEnabled(txtDireccion, folderPath, "Campo Dirección No editable",Evidencia);
		isEnabled(txtCiudad, folderPath, "Campo Ciudad No editable",Evidencia);
		isEnabled(txtTelefono, folderPath, "Campo Teléfono No editable",Evidencia);
		isEnabled(txtCorreo, folderPath, "Campo Correo No editable",Evidencia);
		return this;
	}
	
	
	//Paso a paso de visualizar un titulo
		@Step("Ver expedir")
		public ExpedirPage ProrrogaScav_573824(File folderPath,
				String TituloScav,
				String FicheroUnico,String ValorGrillaCupo,String valorGrillaCupo2,
				String valorGrillaCupo3,String valorGrillaCupo7,String ValorGrillaTipoTitulo,
				String ValorGrillaNumeroTitulo,
				String Evidencia) throws Exception {

		writeText(txtBuscarTituloScav, TituloScav, folderPath, "Escritura de titulo a buscar", Evidencia);
		time(5);
		click(btnSeleccionaTitulo, folderPath, "click en titulo buscado", Evidencia);
		time(5);
		click(btnScav2, folderPath, "click en scav", Evidencia);	
		
		boolean encabezado = validarElemento(EncabezadoFicha, 5);
		ValidacionObjeto(encabezado, "Caso exitoso 571764", folderPath, Evidencia);
		
		writeText(txtFichaAprobacion, FicheroUnico, folderPath, "Digitar fichero unico", Evidencia);
		
		
		desplazarseVertical(0, 600);
		time(8);
		click(btnSearch2, folderPath, "click en buscar", Evidencia);
		
		time(8);
		//busqueda de valores en grilla
		searchElementGrid(GridScav2, ValorGrillaCupo, folderPath, "Caso exitoso 571765", Evidencia);
		searchElementGrid(GridScav2, valorGrillaCupo2, folderPath, "Caso exitoso 571765", Evidencia);
		searchElementGrid(GridScav2, valorGrillaCupo3, folderPath, "Caso exitoso 571765", Evidencia);
		searchElementGrid(GridScav2, valorGrillaCupo7, folderPath, "Caso exitoso 571765", Evidencia);
		searchElementGrid(GridScav2, ValorGrillaTipoTitulo, folderPath, "Caso exitoso 571765", Evidencia);
		searchElementGrid(GridScav2, ValorGrillaNumeroTitulo, folderPath, "Caso exitoso 571765", Evidencia);
		
		
		
		//Obtencion de valor de ficha unica
		String ficha = readText(txtFichaAprobacion, folderPath, "obtenemos el codigo de ficha", Evidencia);
		isEnabled(txtFichaAprobacion, folderPath,"Caso 571688 exitoso El consecutivo unico es" + ficha, Evidencia);
		
		clear(txtFichaAprobacion, folderPath, "borro campo", Evidencia);
		
		click(btnSearch2, folderPath, "click en buscar consecutivo,571689,571692,571693", Evidencia);
		boolean alertaBusqueda = validarElemento(AlertaBusqueda, 5);
		ValidacionObjeto(alertaBusqueda, "Caso exitoso 571689,571689", folderPath, Evidencia);
		time(8);
		click(btnSavingScav, folderPath, "click en guardar", Evidencia);
		
		boolean alertaBusqueda2 = validarElemento(AlertaBusqueda, 5);
		ValidacionObjeto(alertaBusqueda2, "Caso exitoso 571689,571689", folderPath, Evidencia);
		
		click(btnAceptarGuardar, folderPath, "click en aceptar guardar", Evidencia);
			
			return this;
		}

		
		
		
		
		@Step("Ver expedir")
		public ExpedirPage LiberacionesScav_571785(File folderPath,
				String TituloScav,
				String FicheroLiberaciones,String ValorGrillaCupo,String valorGrillaCupo2,
				String valorGrillaCupo3,String valorGrillaCupo7,String ValorGrillaTipoTitulo,
				String ValorGrillaNumeroTitulo,String ValorGrillaLiberacion1,String ValorGrillaLiberacion2,
				String Evidencia) throws Exception 
		
		{
			
			writeText(txtBuscarTituloScav, TituloScav, folderPath, "Escritura de titulo a buscar", Evidencia);
			time(5);
			click(btnSeleccionaTitulo, folderPath, "click en titulo buscado", Evidencia);
			time(5);
			click(btnScavLiberaciones, folderPath, "click en boton scav", Evidencia);
			
			boolean encabezado = validarElemento(EncabezadoFichaScavLiberaciones, 5);
			ValidacionObjeto(encabezado, "Caso exitoso 571780", folderPath, Evidencia);
			
			
			writeText(txtFichaAprobacion, FicheroLiberaciones, folderPath, "Digitar fichero unico", Evidencia);
			
			
			desplazarseVertical(0, 600);
			time(8);
			click(btnBuscarScavLiberaciones, folderPath, "click en buscar", Evidencia);
			
			time(8);
			//busqueda de valores en grilla
			searchElementGrid(GridLiberacionesScav, ValorGrillaCupo, folderPath, "Caso exitoso 571781", Evidencia);
			searchElementGrid(GridLiberacionesScav, valorGrillaCupo2, folderPath, "Caso exitoso 571781", Evidencia);
			searchElementGrid(GridLiberacionesScav, valorGrillaCupo3, folderPath, "Caso exitoso 571781", Evidencia);
			searchElementGrid(GridLiberacionesScav, valorGrillaCupo7, folderPath, "Caso exitoso 571781", Evidencia);
			searchElementGrid(GridLiberacionesScav, ValorGrillaTipoTitulo, folderPath, "Caso exitoso 571781", Evidencia);
			searchElementGrid(GridLiberacionesScav, ValorGrillaNumeroTitulo, folderPath, "Caso exitoso 571781", Evidencia);
			searchElementGrid(GridLiberacionesScav, ValorGrillaLiberacion1, folderPath, "Caso exitoso 571781", Evidencia);
			searchElementGrid(GridLiberacionesScav, ValorGrillaLiberacion2, folderPath, "Caso exitoso 571781", Evidencia);
			
			
			isEnabled(txtFichaAprobacion, folderPath,"Caso 571782 exitoso" , Evidencia);
			
			clear(txtFichaAprobacion, folderPath, "borro campo", Evidencia);
			
			writeRandomAlp(txtFichaAprobacion, 5);
			
			click(btnBuscarScavLiberaciones, folderPath, "click en buscar consecutivo Caso 571783 exitoso", Evidencia);
			boolean alertaBusqueda = validarElemento(AlertaBusqueda, 5);
			ValidacionObjeto(alertaBusqueda, "Caso exitoso 571783", folderPath, Evidencia);
			
			clear(txtFichaAprobacion, folderPath, "borro campo", Evidencia);
			
			click(btnBuscarScavLiberaciones, folderPath, "click en buscar consecutivo Caso 571784 exitoso", Evidencia);
			boolean alertaBusqueda2 = validarElemento(AlertaBusqueda, 5);
			ValidacionObjeto(alertaBusqueda2, "Caso exitoso 571784,571785", folderPath, Evidencia);
			
			return this;
			
		}
		
		
	
	//VALIDACIONES DE SEGUNDA HISTORIA DE USUARIO SOBRE TITULOS Y LIBERACIONES
	
	
	/**
	 * Expedir cancelar.
	 *
	 * @param folderPath the folder path
	 * @param TituloCancelado the titulo cancelado
	 * @param Mercancias the mercancias
	 * @param EstadoC the estado C
	 * @param CantInicial the cant inicial
	 * @param CantActual the cant actual
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Ver expedir")
	public ExpedirPage ExpedirCancelar(File folderPath,String TituloCancelado,String Mercancias,
			String EstadoC,String CantInicial,String CantActual,String Evidencia) throws Exception 
	{
		
		//proceso de cancelar la creacion de un titulo
		writeText(txtBuscar, TituloCancelado,folderPath, "Se escribe Id de titulo ",Evidencia);
		click(btnBusquedaTitulo, folderPath, "click busqueda titulo",Evidencia);
		scrollElementH(folderPath, ModificarCancelado, "Se desplaza hasta el elemento deseado",Evidencia);
		
		searchElementGrid(ClientEstatus1, EstadoC, folderPath, "Se valida estado de titulo como cancelado Caso 543825",Evidencia);
		click(VisualizarCancelado, folderPath, "click sobre modificar elemento",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		scrollElementV(folderPath, btnCantidadInicial, "Se desplaza hasta el elemento",Evidencia);
		
		//validaciones de grilla sobre cantidades inicial y actual
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543825 exitoso se validan campos",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543825 exitoso se validan campos",Evidencia);
		
		screenshot(folderPath ,"Estos son los casos: " + ValidacionTitulos);
		return this;
	}

	//HU19 
	/**
	 * Validacion liberacion 543826.
	 *
	 * @param folderPath the folder path
	 * @param TituloLiberacion the titulo liberacion
	 * @param Detalle the detalle
	 * @param EstadoC the estado C
	 * @param CantInicial the cant inicial
	 * @param CantActual the cant actual
	 * @param LiberarCantidad the liberar cantidad
	 * @param Sinicial the sinicial
	 * @param TituloHistorico the titulo historico
	 * @param TituloLiberacionInicial the titulo liberacion inicial
	 * @param Mercancias the mercancias
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Validaciones de liberacion paso a paso
	@Step("Ver expedir")
	public ExpedirPage ValidacionLiberacion_543826(File folderPath,String TituloLiberacion,
			String Detalle,String EstadoC,String CantInicial,String CantActual,
			String LiberarCantidad,String Sinicial,String TituloHistorico,String TituloLiberacionInicial,String Mercancias,String Evidencia ) throws Exception 
	{
		//Se busca un titulo con liberaciones y se valida en grilla los campos de cantidad inicial,actual,liberar cantidad, y saldo inicial
		writeText(txtBuscaTitulo, TituloLiberacion, folderPath, "Se digita el titulo a buscar",Evidencia);
		click(lblCodigoLiberacion, folderPath, "Click en codigo de liberacion",Evidencia);
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en detalle  Mercancias",Evidencia);
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Cant. Inicial"), "Se desplaza hasta el campo detalle de mercancia",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543826 exitoso se validan campos",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543826 exitoso se validan campos",Evidencia);
		searchElementGrid(ClienteMercanciaState, LiberarCantidad, folderPath, "Caso 543826 exitoso se validan campos",Evidencia);
		searchElementGrid(ClienteMercanciaState, Sinicial, folderPath, "Caso 543826 exitoso se validan campos",Evidencia);
		//scroll a una variable localizador en este caso valor total y accion
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Valor Total"), "Click en opciones titulo",Evidencia);
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Acción"), "Click en opciones titulo",Evidencia);
		
		
		//se ingresa a expedir y se busca y valida un titulo en estado cancelado
		click(locatorVariable(lblsecciones,"Expedir"),folderPath, "click en Liberacion",Evidencia);
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar, 546945 se consulta titulo en estado cancelado o aplicado",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		searchElementGrid(AlternativeGridstatus, EstadoC, folderPath, "Se valida el estado aplicado del titulo del caso 546943",Evidencia);

		
		//Se ingresa al submodulo de liberacion y se valida mediante grilla las cantidades inicial, actual,y el saldo inicial
		click(locatorVariable(lblsecciones,"Liberación"),folderPath, "click en Liberacion",Evidencia);
		writeText(txtBuscaTitulo, TituloHistorico, folderPath, "Se digita el titulo a buscar",Evidencia);
		click(lblCodigoLiberacion, folderPath, "Click en codigo de liberacion",Evidencia);
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en detalle  Mercancias",Evidencia);
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Cant. Inicial"), "Se desplaza hasta el campo detalle de mercancia",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543827 exitoso se validan campos",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543827 exitoso se validan campos",Evidencia);
		searchElementGrid(ClienteMercanciaState, Sinicial, folderPath, "Caso 543827 exitoso se validan campos",Evidencia);
		click(locatorVariable(lblsecciones,"Liberación"),folderPath, "click en Liberacion",Evidencia);
		

		
		
		screenshot(folderPath ,"Estos son los casos: " + ValidarLiberacion);
		
		return this;
		
	}
	
	/**
	 * Validacion mercancia liberada.
	 *
	 * @param folderPath the folder path
	 * @param TituloLiberado the titulo liberado
	 * @param Detalle the detalle
	 * @param CantInicial the cant inicial
	 * @param CantActual the cant actual
	 * @param TituloCancelado the titulo cancelado
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//paso a paso de mercancias liberadas 
	@Step("Ver expedir")
	public ExpedirPage ValidacionMercanciaLiberada(File folderPath,String TituloLiberado,
			String Detalle,String CantInicial,String CantActual,String TituloCancelado,String Evidencia ) throws Exception 
	{ 
		
		//Proceso para liberar una mercancia
		writeText(BuscarTitulo, TituloLiberado);
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza hasta la opción modificar ",Evidencia);
        click(ModificartituloLiberado, folderPath, "Se da click sobre modificar ",Evidencia);
        scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias",Evidencia);
        
        //Validaciones de titulo liberado, Se validan los campos de cantidad inicial y actual , Se cancela la operacion 
        click(locatorVariable(lblOpciones2, " Mercancías "), folderPath, "Click en Mercancias",Evidencia);
        searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543829,543830 exitoso se validan campos, Se valida que el valor esta en 0",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543829,543830 exitoso se validan campos, Se valida que el valor esta en 0",Evidencia);
        scrollElementV(folderPath, btnCancelar, "Se desplaza hasta la opcion cancelar",Evidencia);
		click(btnCancelar, folderPath, "Click en cancelar",Evidencia);
		
		//Verifica el funcionamiento de las funciones de liberacion
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en la seccion de liberacion",Evidencia);
		writeText(TxtTituloLiberacion, TituloCancelado, folderPath, "Se escribe titulo cancelado",Evidencia);
		click(btnBuscarLiberacion, folderPath, "click en la liberacion a buscar",Evidencia);
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en Mercancias",Evidencia);
		click(btnOkLiberacion, folderPath, "click en aceptar liberacion",Evidencia);
		
		//Se valida que la liberacion sea efectiva mediante la alerta y su posterior consulta en el submodulo de expedir
		boolean validarbtncargarf = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(validarbtncargarf, "Se valida que el titulo ya no tiene liberaciones del caso 543829 caso exitoso",folderPath,Evidencia);
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en la seccion expedir",Evidencia);
		writeText(BuscarTitulo, TituloLiberado);
		scrollElementH(folderPath, VisualizarTitulo, "Se desplaza hasta la opción Ver cupo",Evidencia);
		
		//Visualizar el cupo de titulo 
		click(VisualizarTitulo, folderPath, "Se ingresa a ver Cupo",Evidencia);
		scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias",Evidencia);
	    click(locatorVariable(lblOpciones2, " Mercancías "), folderPath, "Click en Mercancias",Evidencia);
	    scrollElementV(folderPath, btnCancelar, "click en la opcion cancelar",Evidencia);
	    
	    //desplazarseVertical(0, 400);
			
	    click(btnCancelar, folderPath, "Click en cancelar",Evidencia);
	
		screenshot(folderPath ,"Estos son los casos: " + ValidarMercanciaLiberada);
		
		
		
		return this;
		
		
	}
	
	//HU32
	/**
	 * Objeto presente.
	 *
	 * @param folderPath the folder path
	 * @param TituloaLiberar the tituloa liberar
	 * @param Detalle the detalle
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Validaciones en detalle mercancia
	@Step("Ver expedir")
	public ExpedirPage ObjetoPresente(File folderPath,String TituloaLiberar,String Detalle,String Evidencia) throws Exception 
	{ 
		
		//Busqueda de titulo y acciones sobre el ok al final
		writeText(txtBuscaTitulo, TituloaLiberar, folderPath, "Se escribe titulo",Evidencia);
		click(lblCodigoLiberacion, folderPath, Detalle,Evidencia);
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en Mercancias",Evidencia);
		
		scrollElementV(folderPath, btnDone, "Se desplaza hasta el boton ok",Evidencia);
		scrollElementH(folderPath, cbxAccion, "Se desplaza hasta el checkbox de accion",Evidencia);
		click(cbxAccion, folderPath, "Se da click sobre el checkbox de accion del caso 543831",Evidencia);
		
		/*click(btnDone, folderPath, "caso 543831 exitoso");
		
		desplazarseVertical(600, 0);
		
		writeText(txtBuscaTitulo, TituloaLiberar, folderPath, "");
		
		click(lblCodigoLiberacion, folderPath, "");
		
		scrollElementV(folderPath, btnDone, "");
		
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en Mercancias");
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543829,543830,543831 exitoso se validan campos, Se valida que el valor esta en 0");
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543829,543830,543831,543832 exitoso se validan campos, Se valida que el valor esta en 0");
		
		click(locatorVariable(lblsecciones,"Expedir"),folderPath,""))
		writeText(txtBuscaTitulo, TituloaLiberar, folderPath, "");
		
		click(locatorVariable(lblOpciones2, " Mercancia "), folderPath, "Click en Mercancias");
			*
		*/
		
		screenshot(folderPath ,"Estos son los casos: " + ObjetoPresente);
		
		return this;
		
	}
	
	/**
	 * Validacion expedir liberacion.
	 *
	 * @param folderPath the folder path
	 * @param TituloLiberado the titulo liberado
	 * @param Detalle the detalle
	 * @param Mercancias the mercancias
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Ver expedir")
	public ExpedirPage ValidacionExpedirLiberacion(File folderPath,String TituloLiberado,String Detalle,String Mercancias,String Evidencia) throws Exception 
	{ 
		
		//Se escribe un titulo con liberaciones, se modifica y se visualiza el titulo
		writeText(txtBuscaTitulo, TituloLiberado, folderPath, "Se digita el titulo a buscar",Evidencia);
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza al elemento",Evidencia);
		click(ModificartituloLiberado, folderPath, "click en modificar articulo",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		scrollElementV(folderPath, btnObservarTitulo, "Se desplaza hasta la opcion observar titulo",Evidencia);
		//Se visualiza el titulo
		click(btnObservarTitulo, folderPath, "click en observar titulo",Evidencia);
		click(btnCancelarvista, folderPath, "click en cancelar vista",Evidencia);
		
		
		
		
		
		return this;
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Bodega cargue.
	 *
	 * @param folderPath the folder path
	 * @param NitClienteAsociado the nit cliente asociado
	 * @param Mercancias the mercancias
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Ver Bodega de cargue")
	public ExpedirPage BodegaCargue(File folderPath,String NitClienteAsociado,String Mercancias,String Evidencia) throws Exception {
		

		
		//Se busca un titulo, se modifica y se busca cancelarlo, pero al final se cancela el titulo
		scrollElementH(folderPath, btnModificarCliente, "Se desplaza hasta el boton modificar cliente",Evidencia);
		click(ModificarCancelado, folderPath, "Click en modificar titulo",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias,Evidencia);
		scrollElementH(folderPath, ModificarAplicado, "Se desplaza hasta el boton modificar cliente",Evidencia);
		click(ModificarAplicado, folderPath, "Click en modificar titulo",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias,Evidencia);
		
		
		//Se dezplaza horizonta y verticalmente para situarse sobre el boton modificar anulacion, se da click en mercancias
		scrollElementH(folderPath, ModificarAnulado, "Se desplaza hasta el boton modificar cliente",Evidencia);
		scrollElementV(folderPath, ModificarAnulado, "Se desplaza hasta el boton modificar cliente",Evidencia);
		click(ModificarAnulado, folderPath, "Click en modificar titulo",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, "Click en cancelar estado",Evidencia);
	
		
		
		return this;
	}
	
	//HU08
	/**
	 * Validacion expedicion 542372.
	 *
	 * @param folderPath the folder path
	 * @param NitClienteAsociado the nit cliente asociado
	 * @param TipoDato the tipo dato
	 * @param InformacionGeneral the informacion general
	 * @param DetalleMercancia the detalle mercancia
	 * @param Plazo the plazo
	 * @param Poliza the poliza
	 * @param TipodeMercancia the tipode mercancia
	 * @param Mercancias the mercancias
	 * @param Route the route
	 * @param RouteA the route A
	 * @param RouteB the route B
	 * @param ModuloT the modulo T
	 * @param SubModuloExpedir the sub modulo expedir
	 * @param TipoBodega the tipo bodega
	 * @param ValorBuscado the valor buscado
	 * @param RouteC the route C
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Validaciones en el cargue de archivos
	@Step("Ver Bodega de cargue")
	public ExpedirPage ValidacionExpedicion_542372(File folderPath,String NitClienteAsociado,String TipoDato,String InformacionGeneral,
			String DetalleMercancia,String Plazo,String Poliza,
			String TipodeMercancia,String Mercancias,String Route,
			String RouteA,String RouteB,String ModuloT,String SubModuloExpedir,
			String TipoBodega,String ValorBuscado,String RouteC,String Evidencia ) throws Exception {

		
		//Se busca un cliente con un nit asociado a almaviva
		writeText(BuscarCliente, NitClienteAsociado, folderPath, "Se busca cliente asociado",Evidencia);
		
		click(btnModificarcliente, folderPath, "click en modificar cliente",Evidencia);
		
		desplazarseVertical(0,600);
		//
		scrollElementV(folderPath, Tipobodega, "scroll hacia tipo de bodega",Evidencia);
		click(Tipobodega, folderPath, "click en tipo de bodega",Evidencia);
		
		
		//Se valida que tenga una bodega propia y sea JDA
		searchElementGrid(FilaElemento2, ValorBuscado, folderPath, "Se encuentra Validacion de Bodega propia y wms, Caso 542372,542369",Evidencia);
		
		//Click en titulo y en expedir
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos",Evidencia);
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		//selectElementList(lblTipoDeDato, TipoDato);
		writeText(txtNitCargue, "1604", folderPath, "Se escribe el nit que se desea buscar ",Evidencia);
		
		scrollElementH(folderPath, lblModificarHistorico, "Scroll hacia elemento",Evidencia);
		
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		
		//scrollElementV(folderPath, lblRegistro, "Se dezplaza hacia el ultimo registro");
		//scrollElementH(folderPath, ModificarRegistro, "Se dezplaza hacia modificar registro");
		//click(ModificarRegistro, folderPath, "Click en modificar registro");
		
		waitInMs(10);
		
		//Se hace un recorrido por los diferentes campos del titulo como informacion general, plazo,poliza,tipo de mercancia 
		desplazarseVertical(0,300);
		click(locatorVariable(lblOpciones, InformacionGeneral), folderPath, "Click en menu opciones poliza y se visualizan los datos necesarios caso 542370,542372",Evidencia);
		click(locatorVariable(lblOpciones, InformacionGeneral), folderPath, "Click en menu opciones poliza",Evidencia);
		
		click(DetalleMercancia2, folderPath, "Click en Detalle Mercancia y se visualizan los datos necesarios caso 542370,542372",Evidencia);
		click(DetalleMercancia2, folderPath, "Click detalle mercancia",Evidencia);
		
		//click(locatorVariable(lblOpciones, DetalleMercancia), folderPath, "Click en Detalle Mercancia y se visualizan los datos necesarios caso 542370,542372");
		//click(locatorVariable(lblOpciones, DetalleMercancia), folderPath, "Click en Detalle Mercancia");
		
		desplazarseVertical(0,250);
		click(locatorVariable(lblOpciones, Plazo), folderPath, "Click en Plazo y se visualizan los datos necesarios caso 542370,542372",Evidencia);
		click(locatorVariable(lblOpciones, Plazo), folderPath, "Click en Plazo",Evidencia);
		
		click(locatorVariable(lblOpciones, Poliza), folderPath, "Click en menu opciones poliza y se visualizan los datos necesarios caso 542370,542372",Evidencia);
		click(locatorVariable(lblOpciones, Poliza), folderPath, "Click en menu opciones poliza",Evidencia);
		
		desplazarseVertical(0,300);
		
		click(locatorVariable(lblOpciones, TipodeMercancia), folderPath, "Click en tipo de mercancia y se visualizan los datos necesarios caso 542370,542372",Evidencia);
		click(locatorVariable(lblOpciones, TipodeMercancia), folderPath, "Click en tipo de mercancia",Evidencia);
		
		desplazarseVertical(0,300);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias, Se valida el funcionamiento de la seccion mercancias del caso 542369",Evidencia);
		
		
		//Se valida los botones de carga y descarga del area de mercancias 
		scrollElementV(folderPath, btnDescargar, "Se dezplaza hasta elemento el caso 542369 es exitoso ",Evidencia);
		boolean validarbtndescarga = validarElemento(btnDescargar, 10);
		
		boolean validarbtncargar = validarElemento(btnCargue1, 10);
		
		//Se validan los objetos existentes, los dos botones 
		ValidacionObjetos(validarbtndescarga,validarbtncargar," Se valida la presencia de los botones de carge y descargue de archivos", folderPath,Evidencia);
		
		click(btnDescargar, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente",Evidencia);
		
		
		waitInMs(3);
		
		// Se validan las alertas de cargue exitoso
		fileUpFull(btnCargue, Route);
		boolean validarAlertaCargueerrado = validarElemento(AlertaCargue,10);
		ValidacionObjeto(validarAlertaCargueerrado,"caso 542371 se valida la existencia de la alerta de cargue no exitoso, no aparece una alerta de error sino de advertencia por tanto el caso 542371 falla", folderPath,Evidencia);
		
		fileUpFull(btnCargue, RouteA);
		boolean validarAlertaCargue = validarElemento(AlertaCargue,10);
		ValidacionObjeto(validarAlertaCargue,"caso 542370 es exitoso ,542373 es exitoso,542375 se valida la existencia de la alerta de cargue exitoso, 542375 cargue de datos decimales esta prueba falla porque si permitio realizar la carga de archivos, Caso 542378 exitoso se carga esa cantidad de mercancias", folderPath,Evidencia);
		fileUpFull(btnCargue, RouteB);
		
		boolean validarAlertaCargue2 = validarElemento(AlertaCargue,10);
		ValidacionObjeto(validarAlertaCargue2,"casos exitosos 542370,542373,542376, se valida la existencia de la alerta de cargue exitoso,caso 542376 falla porque no esta la tabla de calculo, valida cargue de caso 542377", folderPath,Evidencia);
			
		
		//No se puede jamas automatizar la creacion perpetua de titulos debido a que estos solo cambian de estado y no es posible borrarlos como tal, sigue sin ser recomendado por la parte funcional
		
		//click(btnAplicar, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		//click(btnAceptar, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		//click(btnSafe, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		//click(btnAceptar, folderPath, "click en boton descargar 542371,542372 , el caso 542370 se ejecuta correctamente");
		//boolean validarAlertaCargue = validarElemento(AlertaCargue,10);
		//ValidacionObjeto(validarAlertaCargue,"caso 542370 se valida la existencia de la alerta de cargue exitoso, caso 542377 es exitoso en el guardado de cargue", folderPath);
		
		//Scroll hasta checkbox 
		scrollElementV(folderPath, CheckBox, "Se dezplaza hasta checkbox, Se valido el funcionamiento de la funcion de cargue masivo y el checkbox del caso 542369, datos caso 542372,checkbox cargados 542374",Evidencia);
		
		//Cargue de archivo de excel y validacion de alerta
		fileUpFull(btnCargue, RouteC);
		
		boolean validarAlertaCargue3 = validarElemento(AlertaCargue,10);
		
		ValidacionObjeto(validarAlertaCargue3,"caso 542492 exitoso se valida el mensaje de cargue exitoso de un archivo con cantidades negativas", folderPath,Evidencia);
		
		
		return this;
	}
	
		
	
	//VALIDACION DE HISTORICOS paso a paso para validar un titulo con historico de liberaciones
	
	/**
	 * Validacion historico 546943.
	 *
	 * @param folderPath the folder path
	 * @param TituloHistorico the titulo historico
	 * @param DetalleMercancia the detalle mercancia
	 * @param EstadoC the estado C
	 * @param Mercancias the mercancias
	 * @param ValidarVisualizacionLiberacion the validar visualizacion liberacion
	 * @param CantInicial the cant inicial
	 * @param CantActual the cant actual
	 * @param LiberarCantidad the liberar cantidad
	 * @param Sinicial the sinicial
	 * @param etiquetaPoliza the etiqueta poliza
	 * @param poliza the poliza
	 * @param TituloEjemplo the titulo ejemplo
	 * @param TituloIncompleto the titulo incompleto
	 * @param TituloCancelado the titulo cancelado
	 * @param Producto the producto
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Ver Bodega de cargue")
	public ExpedirPage ValidacionHistorico_546943(File folderPath,
			String TituloHistorico,String DetalleMercancia,String EstadoC,
			String Mercancias,String ValidarVisualizacionLiberacion,
			String CantInicial,String CantActual,String LiberarCantidad,String Sinicial,String etiquetaPoliza,
			String  poliza,String TituloEjemplo,
			String TituloIncompleto,String TituloCancelado,String Producto,String Evidencia
			) throws Exception {
		
		//Se busca un titulo con historico de liberaciones 
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar, 546945 se consulta titulo en estado cancelado o aplicado",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		searchElementGrid(AlternativeGridstatus, EstadoC, folderPath, "Se valida el estado aplicado del titulo del caso 546943",Evidencia);
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en Mercancias",Evidencia);
		writeText(TxtTituloLiberacion, TituloHistorico, folderPath, "Se digita titulo de liberacion",Evidencia);
		click(btnSearchLiberacionButton, folderPath, "click en modificar",Evidencia);
		
		//Validaciones de los encabezados de cantidad inicial,actual,cantidad a liberar y saldo inicial
		click(DetalleMercancialbl, folderPath, "Click en Mercancias",Evidencia);
		//scrollElementV(folderPath, btnClose, "scroll hacia boton cerrar");
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "caso 546943 exitoso se puede observar informacion",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "caso 546943 exitoso se puede observar informacion",Evidencia);
		searchElementGrid(ClienteMercanciaState, LiberarCantidad, folderPath, "caso 546943 exitoso se puede observar informacion",Evidencia);
		searchElementGrid(ClienteMercanciaState, Sinicial, folderPath, "caso 546943 exitoso se puede observar informacion",Evidencia);
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en Mercancias",Evidencia);
		writeText(BuscarCliente, "1651", folderPath, "Se digita titulo de liberacion",Evidencia);
		click(lblVisualizarTitulo, folderPath, "Click en visualizar",Evidencia);
		
		desplazarseVertical(0, 600);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		click(btnVisualizarLiberacionGrid, folderPath, "click en visualizacion",Evidencia);
		searchElementGrid(gridLiberacion, ValidarVisualizacionLiberacion, folderPath, "caso 546943 exitoso se puede observar informacion",Evidencia);
		click(btnClose, folderPath, "cerrar consulta",Evidencia);
		
		//Se valida la existencia del boton visualizar mediante la variable booleana y el metodo validar objeto
		scrollElementH(folderPath, lblVisualizarHistorico, "scroll a elemento",Evidencia);
		boolean btnVisualizarHistorico = validarElemento(lblVisualizarHistorico, 10);
		ValidacionObjeto(btnVisualizarHistorico,"caso 546943,546947 se valida existencia de boton visualizar ", folderPath,Evidencia);
		click(lblVisualizarHistorico, folderPath, "click en visualizar liberacion,546945 se visualiza cantidad inicial",Evidencia);
		click(btnClose, folderPath, "cerrar consulta",Evidencia);
		
		//Se consulta en expedir nuevamente el titulo para cersiorarse de que esten los campos cantidad inicial y cantidad actual si el titulo esta cancelado
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en Mercancias",Evidencia);
		writeText(txtNitCargue, TituloCancelado, folderPath, "Se escribe el titulo a buscar,546946 se consulta estado diferente a aplicado",Evidencia);
		scrollElementH(folderPath, lblVisualizarTitulo, "Se desplaza hasta modificar titulo",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		desplazarseVertical(0, 500);
		
		scrollElementH(folderPath, btnVisualizarLiberacion, "Se desplaza hasta elemento",Evidencia);
		click(btnVisualizarLiberacion, folderPath, "Click en visualizar",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "caso 543825,543827, 543829,543830,546944,546945,546946 exitoso se puede observar informacion",Evidencia);
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "caso 543825,543829,543827,543830,546944,546945,546946 exitoso se puede observar informacion",Evidencia);
		click(btnClose, folderPath, "cerrar consulta",Evidencia);
		
		//GridLiberacionesHistoricos
		//screenshot(folderPath ,"Estos son los casos: " + Historico);
		
		return this;
	}
	
	//HU10 
	/**
	 * Usuario admin.
	 *
	 * @param folderPath the folder path
	 * @param etiquetaPoliza the etiqueta poliza
	 * @param poliza the poliza
	 * @param TituloHistorico the titulo historico
	 * @param SeccionA the seccion A
	 * @param usuario2 the usuario 2
	 * @param TituloGrabado the titulo grabado
	 * @param TituloIncompleto the titulo incompleto
	 * @param Mercancias the mercancias
	 * @param ModuloS the modulo S
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Paso a paso para validar que el usuario administrador pueda modificar titulos
	@Step("Ver Bodega de cargue")
	public ExpedirPage UsuarioAdmin(File folderPath,String etiquetaPoliza,String  poliza, 
			String TituloHistorico,String SeccionA,String usuario2,
			String TituloGrabado,String TituloIncompleto,
			String Mercancias,String ModuloS,String Evidencia) throws Exception {
		
		
		//se busca y se ingresa a un titulo con historico de liberaciones
		
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		//boolean validarbtndescargaE = validarElemento(btnDescargar, 10);
		//boolean validarbtncargarE = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		
		//ValidacionObjetos(validarbtncargarE,validarbtndescargaE,"542494 Se valida la no presencia de los botones de carge y descargue de archivos el caso 542494 es exitoso", folderPath);
		
		
		desplazarseVertical(0, 400);
		//POLIZA acciones sobre la seccion de poliza y validaciones 
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias",Evidencia);
		desplazarseVertical(0, 400);
		desplazarseVertical(0, 300);	
		click(btnCancelar, folderPath, "click en cancelar",Evidencia);
		
		
		writeText(txtNitCargue, TituloGrabado, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		//Validaciones de botones de cargue y descargar archivos
		boolean validarbtndescarga = validarElemento(btnDescargar, 10);
		boolean validarbtncargar = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		
		ValidacionObjetos(validarbtndescarga,validarbtncargar,"542493 Se valida la presencia de los botones de carge y descargue de archivos", folderPath,Evidencia);
		
		
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias",Evidencia);
		desplazarseVertical(0, 400);
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias",Evidencia);
		
		
		desplazarseVertical(0, 400);
		click(btnCancelar, folderPath, "click en cancelar",Evidencia);
		
		//Validaciones de botones de cargue y descargue en titulos incompletos	
		writeText(txtNitCargue, TituloIncompleto, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		boolean validarbtndescargaf = validarElemento(btnDescargar, 10);
		boolean validarbtncargarf = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		ValidacionObjetos(validarbtndescargaf,validarbtncargarf,"542493 Se valida la presencia de los botones de carge y descargue de archivos", folderPath,Evidencia);
		
		scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		
		
		scrollElementH(folderPath, ModificarMercancia, Mercancias,Evidencia);
		click(ModificarMercancia, folderPath, "click en visualizar liberacion",Evidencia);
		
		//Se digita una fecha en calendario y se guardan los cambios
		writeText(btnCalendar, "07072022", folderPath, "escribe en calendario",Evidencia);
		click(btnGuardarCambios, folderPath, "guarda cambios",Evidencia);
		click(btnSeguroCambiar, folderPath, "acepta cambios",Evidencia);
		click(btnOkay, folderPath, "click en ok",Evidencia);
		
		click(btnCloseMercaciaEdicion, folderPath, "cierra edicion de mercancia",Evidencia);
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
	
		click(btnCancelar, folderPath, "click en cancelar",Evidencia);	
		//se consulta el usuario en en submodulo de usuarios en el modulo de seguridad
		
		click(locatorVariable(lblModulos, ModuloS),folderPath,"click en modulo",Evidencia);
		click(locatorVariable(lblsecciones, SeccionA),folderPath,"click en seccion",Evidencia);
		writeText(SearchUsuary, usuario2, folderPath, "escribir usuario",Evidencia);

		screenshot(folderPath ,"Estos son los casos: " + Historico);
		
		
		return this;
		
		
	}
	
	//var dateControl = document.querySelector(btnTableofdates);
			//dateControl.value = "2017-06-01";
		
	//HU30 Verificacion de edicion de fechas con usuario super admin
	
	/**
	 * Usuario editar admin 545511.
	 *
	 * @param folderPath the folder path
	 * @param usuario2 the usuario 2
	 * @param ModuloT the modulo T
	 * @param SubModuloExpedir the sub modulo expedir
	 * @param Titulobonoprenda the titulobonoprenda
	 * @param infogeneraltitulo the infogeneraltitulo
	 * @param lblbonoprenda the lblbonoprenda
	 * @param LapsoTiempo the lapso tiempo
	 * @param TituloNoEditable the titulo no editable
	 * @param TituloEstadoAnulado the titulo estado anulado
	 * @param Mercancias the mercancias
	 * @param tipoUser the tipo user
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Ver Bodega de cargue")
	public ExpedirPage UsuarioEditarAdmin_545511(File folderPath,String usuario2,String ModuloT,String SubModuloExpedir,
			String Titulobonoprenda,String infogeneraltitulo,String lblbonoprenda,
			String LapsoTiempo,String TituloNoEditable,String TituloEstadoAnulado,String Mercancias,String tipoUser,String Evidencia ) throws Exception {
		
		
		writeText(SearchUsuary, usuario2, folderPath, "escribir usuario",Evidencia);
		searchElementGrid(GridUsuario, tipoUser, folderPath, "Se valida tipo de usuario superadmin casos 545511, 545512, 545513, 545514",Evidencia);
		click(btnVisualizarUsuario, folderPath, "Click en visualizar usuario",Evidencia);
		scrollElementV(folderPath, txtEmailUsuario, "scroll hasta elemento deseado",Evidencia);
		
		//Se ingresa al submodulo expedir y se busca un titulo que contenga la opcion bono prenda y se ingresa a informacion general del titulo
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos",Evidencia);
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		writeText(txtNitCargue, Titulobonoprenda, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo, Se visualiza campo fecha casos 545511, 545512, 545513, 545514",Evidencia);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo, Se visualiza campo fecha casos 545511, 545512, 545513, 545514",Evidencia);
		
		//click en ver bono prenda
		//desplazarseVertical(0, 600);
		click(btnVerBonoPrenda, folderPath, "Click en ver bono prenda,casos exitosos 545511, 545512, 545513, 545514, el elemento actualmente no permite realizar accion alguna sobre el pero es editable y cambia de acuerdo al caso",Evidencia);
		//scrollElementH(folderPath, FechaVencimiento, "scroll hasta elemento casos exitosos 545511, 545512, 545513, 545514, el elemento actualmente no permite realizar accion alguna sobre el pero es editable y cambia de acuerdo al caso");
		click(btnVerBonoPrenda, folderPath, "Click en ver bono prenda",Evidencia);
		
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en tiempo de prenda",Evidencia);
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en tiempo de prenda",Evidencia);
		
		//Se busca un titulo en el submodulo expedir
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);		
		writeText(txtNitCargue, TituloNoEditable, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo,Se visualiza fecha no editable 545513 ",Evidencia);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo",Evidencia);
		
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		writeText(txtNitCargue, Titulobonoprenda, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		
		//Se valida mediante variables booleanas y validar elemento los botones de impresion y de bono prenda
		boolean btnImpresion = validarElemento(btnVisualizarImpresiones, 10);
		ValidacionObjeto(btnImpresion, "Caso 545514 se valida boton impresiones", folderPath,Evidencia);
		//click en el icono de impresiones para visualizar dichas impresiones
		click(btnVisualizarImpresiones, folderPath, "click en impresiones",Evidencia);
		boolean btnImpresionA = validarElemento(ImpresionA, 10);
		boolean btnImpresionCDM = validarElemento(ImpresionCDM, 10);
		ValidacionObjetos(btnImpresionA,btnImpresionCDM,"caso exitoso 545515, 545516, 545517 se valida impresion", folderPath,Evidencia);
		boolean btnImpresionBonoprenda = validarElemento(ImpresionBonoprenda, 10);
		ValidacionObjeto(btnImpresionBonoprenda,"caso exitoso 545515, 545516, 545517 se valida impresion", folderPath,Evidencia);
		
		//click(ImpresionA, folderPath, "click en impresion");
		//click(ImpresionCDM, folderPath, "click en impresion");
		//click(ImpresionBonoprenda, folderPath, "click en impresion");
			
		//screenshot(folderPath ,"Estos son los casos: " + FechaGeneracion);
		
		
		
		return this;
	}
	
	/**
	 * Usuario aplicador 554763.
	 *
	 * @param folderPath the folder path
	 * @param usuario2 the usuario 2
	 * @param ModuloT the modulo T
	 * @param SubModuloExpedir the sub modulo expedir
	 * @param titulograbado the titulograbado
	 * @param Titulobonoprenda the titulobonoprenda
	 * @param infogeneraltitulo the infogeneraltitulo
	 * @param SubModuloExpedir1 the sub modulo expedir 1
	 * @param ModuloT1 the modulo T 1
	 * @param aplicador the aplicador
	 * @param SeccionPerfil the seccion perfil
	 * @param UsuarioAplicador the usuario aplicador
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Se verifica mediante el paso a paso que el tipo de usuario aplicador funcione
	@Step("Ver Bodega de cargue")
	public ExpedirPage UsuarioAplicador_554763(File folderPath,String usuario2,String ModuloT,String SubModuloExpedir,String titulograbado,
			String Titulobonoprenda,String infogeneraltitulo,
			String SubModuloExpedir1,String ModuloT1,String aplicador,String SeccionPerfil,String UsuarioAplicador,String Evidencia ) throws Exception {
		
		
		//Se consulta el usuario aplicador
		click(locatorVariable(lblModulos, " Seguridad "),folderPath,"click en la seccion perfil",Evidencia);
		click(locatorVariable(lblsecciones, "Roles"),folderPath,"click en la seccion perfil",Evidencia);
		writeText(SearchRole, UsuarioAplicador, folderPath, "Se busca rol ",Evidencia);
		searchElementGrid(GridRoles, UsuarioAplicador, folderPath, "Se valida tipo de usuario aplicador caso 554748 ",Evidencia);
		click(btnVisualizarRolesExistentes, folderPath, "click en rol",Evidencia);
		
		//searchElementGrid(GridRol, aplicador, folderPath, "Se valida que el usuario sea aplicador");
		
		//se consulta su perfil
		click(locatorVariable(lblsecciones, SeccionPerfil),folderPath,"click en la seccion perfil",Evidencia);
		writeText(txtBusquedaUsuario, aplicador, folderPath, "Se busca el perfil de aplicador",Evidencia);
		searchElementGrid(GridDePerfiles, aplicador, folderPath, "Se valida la existencia del perfil de aplicador 554763,554749",Evidencia);
		click(btnModificarPerfil, folderPath, "Click en modificar perfil",Evidencia);
			
		click(lblTitulo,folderPath,"click en la seccion perfil",Evidencia);
		click(lblExpedir,folderPath,"click en la seccion expedir",Evidencia);
		
		
		//se consulta si el usuario aplicador puede liberar un titulo
		writeText(txtBuscarTitulo, titulograbado, folderPath, "buscar titulo con bodega propia, y estado grabado ",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar titulo ",Evidencia);
		
		
		time(17);
		
		desplazarseVertical(0, 700);
		
		click(btnAplicar, folderPath, "click en aplicar",Evidencia);
		click(btnAceptarCambios, folderPath, "click en aceptar",Evidencia);
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso 554751 ,554763 ", folderPath,Evidencia);
		
		
		
		
		
		click(locatorVariable(lblsecciones, "Expedir"),folderPath,"click en la seccion perfil",Evidencia);
	
		writeText(txtBuscarTitulo, titulograbado, folderPath, "buscar titulo con bodega propia, y estado grabado ",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar titulo ",Evidencia);
		
		time(17);
		desplazarseVertical(0, 700);
		
		
		// Se guarda y se aceptan los cambios
		click(btnSafe, folderPath, "guardar titulo ",Evidencia);
		click(btnAceptarCambios, folderPath, "click en aceptar",Evidencia);
		boolean alertaCreada = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(alertaCreada, "Validacion de creacion de titulo 554749", folderPath,Evidencia);
		
		
		
		
		
		
		
		screenshot(folderPath ,"Estos son los casos: " + Aplicador);
		
		
		
		
		
		return this;}
	
	
	/**
	 * Mercancia generica.
	 *
	 * @param folderPath the folder path
	 * @param nitExpedir the nit expedir
	 * @param descripcion the descripcion
	 * @param tipoMercanciaE the tipo mercancia E
	 * @param SubModuloExpedir the sub modulo expedir
	 * @param Titulobonoprenda the titulobonoprenda
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Paso a paso de impresion de titulo con una mercancia de tipo generica 
	@Step("Crear expedir")
	public ExpedirPage MercanciaGenerica(File folderPath, String nitExpedir, String descripcion, String tipoMercanciaE,String SubModuloExpedir,String Titulobonoprenda,String Evidencia)
			throws Exception 
	
	
	{
		
		//Se crea un titulo y se valida el funcionamiento de los botones de impresiones
			
		click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir",Evidencia);
		writeText(txtNitRazonSocial, nitExpedir, folderPath, "Se ingresa el dato Nit",Evidencia);
		click(locatorVariable(lblOpciones2, tipoMercanciaE), folderPath, "Click en opciones titulo",Evidencia);
		listRandom(lblTipoMercancia, folderPath, "selecciona valor random de lista",Evidencia);
		writeText(txtDescripcionGeneral, descripcion, folderPath, "escribe descripcion general",Evidencia);
		listRandom(lblAplicaCondicion, folderPath, "selecciona valor random",Evidencia);
		scrollElementV(folderPath, btnGuardarExpedir, "Scroll hasta elemento",Evidencia);
		click(btnGuardarExpedir, folderPath, "click en guardar",Evidencia);
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		writeText(txtNitCargue, Titulobonoprenda, folderPath, SubModuloExpedir,Evidencia);
		
		//se da click en los botones de impresiones
		click(btnVisualizarImpresiones, folderPath, "click en modificar",Evidencia);
		click(ImpresionA, folderPath, "click en impresion de talon ",Evidencia);
		click(ImpresionCDM, folderPath, "click en impresion de talon",Evidencia);
		click(ImpresionBonoprenda, folderPath, "click en impresion de talon",Evidencia);
		submit(ImpresionA, folderPath, "submit de informacion",Evidencia);
		
		
		
		screenshot(folderPath ,"Estos son los casos: " + CP03);
		
		
		return this;
	}

	
	
	
	
	

	/**
	 * Cp05.
	 *
	 * @param folderPath the folder path
	 * @param usuario2 the usuario 2
	 * @param ModuloT the modulo T
	 * @param SubModuloExpedir the sub modulo expedir
	 * @param Titulobonoprenda the titulobonoprenda
	 * @param infogeneraltitulo the infogeneraltitulo
	 * @param lblbonoprenda the lblbonoprenda
	 * @param LapsoTiempo the lapso tiempo
	 * @param TituloNoEditable the titulo no editable
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	@Step("Ver Bodega de cargue")
	public ExpedirPage CP05(File folderPath,String usuario2,String ModuloT,String SubModuloExpedir,String Titulobonoprenda,String infogeneraltitulo,String lblbonoprenda,String LapsoTiempo,String TituloNoEditable,String Evidencia ) throws Exception {
		
		
		
		//Se busca un usuario y se visualiza, se valida que el usuario puede modificar titulos
		writeText(SearchUsuary, usuario2, folderPath, "Se busca un usuario",Evidencia);
		click(btnVisualizarUsuario, folderPath, "Click en visualizar usuario",Evidencia);
		scrollElementV(folderPath, txtEmailUsuario, "scroll hasta elemento deseado",Evidencia);
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos",Evidencia);
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		writeText(txtNitCargue, Titulobonoprenda, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		
		desplazarseVertical(0, 400);
		
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo",Evidencia);
		//click(FechaExpedicion);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo",Evidencia);
		
		screenshot(folderPath ,"Estos son los casos: " + FechaGeneracion);
		
		return this;
	}
	
	/**
	 * Cp08.
	 *
	 * @param folderPath the folder path
	 * @param usuario2 the usuario 2
	 * @param ModuloT the modulo T
	 * @param SubModuloExpedir the sub modulo expedir
	 * @param TituloNoEditable the titulo no editable
	 * @param Prorroga the prorroga
	 * @param lblbonoprenda the lblbonoprenda
	 * @param LapsoTiempo the lapso tiempo
	 * @param infogeneraltitulo the infogeneraltitulo
	 * @param Mercancias the mercancias
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//HU22
	@Step("Ver Bodega de cargue")
	public ExpedirPage CP08(File folderPath,String usuario2,
			String ModuloT,String SubModuloExpedir,String TituloNoEditable,
			String Prorroga,String lblbonoprenda,
			String LapsoTiempo,String infogeneraltitulo,String Mercancias,String Evidencia ) throws Exception {
		
		//Busqueda de un usuario en el modulo de seguridad
		writeText(SearchUsuary, usuario2, folderPath, "escribe usuario",Evidencia);
		click(btnVisualizarUsuario, folderPath, "Click en visualizar usuario",Evidencia);
		scrollElementV(folderPath, txtEmailUsuario, "scroll hasta elemento deseado",Evidencia);
		//Se ingresa de nuevo a modulo titulos y a submodulo expedir
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos",Evidencia);
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		writeText(txtNitCargue, TituloNoEditable, folderPath, "Se escribe el titulo a buscar",Evidencia);
		
		//se toma un valor de texto de un localizador y se envia a una variable de tipo string
		String codigo = readText(NumberProrrogaValida, folderPath, "Escritura",Evidencia);
		
		
		//Se dirige hacia modificar titulo y se ingresa a mercancias
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar titulo",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		//boolean validarbtndescargaE = validarElemento(btnDescargar, 10);
		//boolean validarbtncargarE = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias",Evidencia);
		
		//ValidacionObjetos(validarbtncargarE,validarbtndescargaE,"542494 Se valida la no presencia de los botones de carge y descargue de archivos el caso 542494 es exitoso", folderPath);
		
		
		//Se ingresa a la seccion y prorroga y se hacen los paso a paso de esta
		click(locatorVariable(lblsecciones, Prorroga),folderPath,"click en la seccion expedir",Evidencia);
		writeText(BusquedaProrroga, codigo, folderPath, "Se escribe el titulo a prorrogar",Evidencia);
		click(lblBusquedaProrroga, folderPath, "click en prorroga",Evidencia);
		desplazarseVertical(0, 600);
		click(lblBonoPrenda, folderPath, "Click sobre bono de prenda",Evidencia);
		desplazarseVertical(0, 400);
		writeRandomNum(txtplazoDeposito, 1);
		writeRandomNum(txtplazoCredito, 1);
		writeRandomNum(txtplazoCertificado, 1);
		click(btnGuardar, folderPath, "click en guardar",Evidencia);
		click(btnAceptar, folderPath, "click en guardar",Evidencia);
		
		//Se verifican las secciones que existen dentro del titulo
		click(locatorVariable(lblsecciones, Prorroga),folderPath,"click en la seccion expedir",Evidencia);
		writeText(BusquedaProrroga, codigo, folderPath, "Se escribe el titulo a prorrogar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en bono de prenda",Evidencia);
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en bono de prenda",Evidencia);
		click(locatorVariable(lblOpciones, lblbonoprenda), folderPath, "Click en bono de prenda",Evidencia);
		click(locatorVariable(lblOpciones, lblbonoprenda), folderPath, "Click en bono de prenda",Evidencia);
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos",Evidencia);
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir",Evidencia);
		writeText(txtNitCargue, TituloNoEditable, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar",Evidencia);
		click(lblModificarHistorico, folderPath, codigo,Evidencia);	
		scrollElementV(folderPath, locatorVariable(lblOpciones, Mercancias), "scroll a  mercancias de titulo",Evidencia);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en  mercancias de titulo",Evidencia);
		
		// Validacion de botones de carga y descarga 
		
		//boolean validarbtndescarga = validarElemento(btnDescargar, 10);
		//boolean validarbtncargar = validarElemento(btnCargue1, 10);
	
		//ValidacionObjetos(validarbtndescargaf,validarbtncargarf,"542494 Se valida la presencia de los botones de carge y descargue de archivos, el caso 542494 es exitoso", folderPath);
		
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo",Evidencia);
		//click(FechaExpedicion);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo",Evidencia);
	
		//se toma un screenshot final
		screenshot(folderPath ,"Estos son los casos: " + Edicion);
		
		
		
		return this;
		
		
	}
	
	/**
	 * Reversar liberacion 558597.
	 *
	 * @param folderPath the folder path
	 * @param ModuloT the modulo T
	 * @param SubModuloExpedir the sub modulo expedir
	 * @param estadoA the estado A
	 * @param infogeneraltitulo the infogeneraltitulo
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Paso a paso de la reversion de liberaciones
	@Step("Ver Bodega de cargue")
	public ExpedirPage ReversarLiberacion_558597(File folderPath,
			String ModuloT,String SubModuloExpedir,
			String estadoA,String infogeneraltitulo,String Evidencia) throws Exception
	{
		
		
		
		//n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();
		//se crea una variable string llamada titulo y se le envia un valor de texto de un localizador
		String Titulo;
		Titulo = driver.findElement(ValorTituloReversable).getText();
		
		//Proceso de reversion de liberacion de mercancia
		click(btnVisualizarReversion, folderPath, "click en visualizar reversion",Evidencia);
		scrollElementH(folderPath, chxReversar, "click en el check de reversar titulo",Evidencia);
		click(chxReversar, folderPath, "click en check de reversar",Evidencia);
		click(btnReversar, folderPath, "click en reversar",Evidencia);
		click(btnAceptarReversion, folderPath, "Click en aceptar, caso exitoso 558596,558597,558598",Evidencia);
		
		//Se valida como ya se ha visto antes la existencia 
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso exitoso 558601 ,558595, ", folderPath,Evidencia);
		click(lblExpedir, folderPath, "Click en expedir",Evidencia);
		
		//proceso de busqueda y validacion de un titulo en estado activo
		writeText(txtNitCargue, Titulo, folderPath, SubModuloExpedir,Evidencia);
		searchElementGrid(GridTitulo, estadoA, folderPath, "estado aplicado",Evidencia);
		click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo",Evidencia);
		scrollElementV(folderPath, BodegaOpcionTransito, "scroll hasta bodega de transito ",Evidencia);
		// Se valida la opcion de transito
		boolean BodegaTransito = validarElemento(BodegaOpcionTransito, 10);
		ValidacionObjeto(BodegaTransito, "Validacion de aplicacion caso 558599 ,554763,558600,558602,558609 ", folderPath,Evidencia);
		
		
		
		return this;
		
		
	}
	
	
	
	
	
	//HU15 Modificacion de prorrogas
	/**
	 * Prorrogas modificacion 546952.
	 *
	 * @param folderPath the folder path
	 * @param TituloModificarProrroga the titulo modificar prorroga
	 * @param SeccionP the seccion P
	 * @param estadoA the estado A
	 * @param ValorProrroga the valor prorroga
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Se hace un paso a paso de la modificacion de una prorroga
	@Step("Ver Bodega de cargue")
	public ExpedirPage ProrrogasModificacion_546952(File folderPath,String TituloModificarProrroga,String SeccionP,String estadoA,String ValorProrroga,String Evidencia) throws Exception {
		
		//se ingresa normalmente a un titulo en especifico
		writeText(txtNitCargue, TituloModificarProrroga, folderPath, "Se escribe el titulo a buscar",Evidencia);
		scrollElementH(lblModificarHistorico);
		
		searchElementGrid(AlternativeGridstatus, estadoA, folderPath, "Se valida en estado aplicado caso 546952",Evidencia);
		//Se toma el valor de texto de un localizador y se envia a una variable de tipo string para su uso posterior
		String codigo = readText(NumberProrrogaValida, folderPath, "Escritura",Evidencia);
		click(locatorVariable(lblsecciones, SeccionP), folderPath, "Click en Prorrogar",Evidencia);
		// Se escribe el valor tomado del localizador codigo 
		writeText(txtCodigoTitulo, codigo, folderPath, "titulo con prorroga a buscar",Evidencia);
		click(lblBusquedaProrroga, folderPath, "click en prorroga",Evidencia);
		click(lblBonoPrenda, folderPath, "Click sobre bono de prenda",Evidencia);
		scrollElementV(folderPath, HeaderProrrogar, "Bajar a encabezados de la columna",Evidencia);
		//se realizan las validaciones finales
		searchElementGrid(GridProrroga, ValorProrroga, folderPath, "Caso 546952,546953,546954 exitoso",Evidencia);
		scrollElementV(folderPath, lblPaginacion, SeccionP,Evidencia);
		screenshot(folderPath ,"Estos son los casos: " + Prorrogas);
		
		
		return this;
		
	}
	
	/**
	 * Operacion titulo 552036.
	 *
	 * @param folderPath the folder path
	 * @param TituloGrabado the titulo grabado
	 * @param informacionGeneralE the informacion general E
	 * @param PersonaJuridica the persona juridica
	 * @param informacionG the informacion G
	 * @param TituloHistorico the titulo historico
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Operaciones de titulo 
	@Step("Crear expedir")
	public ExpedirPage OperacionTitulo_552036(File folderPath, 
			String TituloGrabado, String informacionGeneralE, String PersonaJuridica, String informacionG,String TituloHistorico,String Evidencia)
			throws Exception {

			//Se ingresa a las opciones de creacion de titulo 
	
			etiquetas(btnCrearExpedir, folderPath, "Etiqueta Crear expedir",Evidencia);
			click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir",Evidencia);
			click(btnCriterio, folderPath, "Se ingresa a crear expedir",Evidencia);
			click(RazonSocial, folderPath, "Se ingresa a crear expedir",Evidencia);
			writeText(txtNitRazonSocial, PersonaJuridica, folderPath, "Se ingresa el dato Nit",Evidencia);
			click(seleccionarNitRazon);
			waitInMs(2000);
			desplazarseVertical(0, 500);
			click(locatorVariable(lblOpciones, informacionGeneralE), folderPath, "Click en elemento",Evidencia);
			
			//Validaciones de tipo de operacion 
			boolean btnTipoOperacion = validarElemento(TipoOperacion, 10);
			ValidacionObjeto(btnTipoOperacion, "Se valida boton de tipo de operacion", folderPath,Evidencia);
			desplazarseVertical(0, 500);
			click(locatorVariable(TipoOperacion, informacionGeneralE), folderPath, "Click en elemento, se desplega lista ",Evidencia);
			listRandom(TipoOperacion, folderPath, "Se selecciona valor random caso 552036,552037,552038,552039,552040 ",Evidencia);
			
			click(btnCancelarCreacion, folderPath, "Click en cancelar creacion",Evidencia);
			
			//Se modifica un titulo que esta en estado grabado y se realizan modificaciones para validar las alertas de funcionamiento
			writeText(txtNitCargue, TituloGrabado, folderPath, "Se escribe titulo grabado",Evidencia);
			click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
			click(locatorVariable(lblOpciones, informacionGeneralE), folderPath, "Click en elemento",Evidencia);
			boolean btnTipoOperacion2 = validarElemento(TipoOperacion, 10);
			ValidacionObjeto(btnTipoOperacion2, "Se valida boton de tipo de operacion caso 552036,552037,552038", folderPath,Evidencia);
			selectElementList(TipoOperacion, "Seleccione", folderPath, "Se deja sin seleccionar el tipo de operacion",Evidencia);
			desplazarseVertical(0, 500);
			click(btnAplicarCambios, folderPath, "click en Aplicar cambios  ",Evidencia);
			click(btnAceptar, folderPath, "click en Aceptar cambios  ",Evidencia);
			boolean btnTipoOperacion3 = validarElemento(btnAlertaTipoOperacion, 10);
			ValidacionObjeto(btnTipoOperacion3, "Se valida boton de tipo de operacion", folderPath,Evidencia);
			click(btnAlertaTipoOperacion, folderPath, "click en Aceptar cambios  ",Evidencia);
			
			click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en elemento Expedir ",Evidencia);
			//click(btnExpedirReal, folderPath, "click en expedir");
			
			//Se escribe un titulo con historial de liberaciones y se revisa por dentro
			writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe titulo historico",Evidencia);
			click(lblModificarHistorico, folderPath, "click en modificar",Evidencia);
			click(locatorVariable(lblOpciones, informacionGeneralE), folderPath, "Click en elemento",Evidencia);
			listRandom(TipoOperacion, folderPath, "Se selecciona valor random ",Evidencia);
			click(btnSaveChanges, folderPath, "click en guardar cambios  ",Evidencia);
			click(btnAceptar, folderPath, "click en Aceptar cambios  ",Evidencia);
			
			boolean btnTipoOperacion4 = validarElemento(AlertChangesSaved, 10);
			ValidacionObjeto(btnTipoOperacion4, "Se valida alerta de cambios realizados, caso exitoso 552036,552037,552038,552039,552040", folderPath,Evidencia);
			
			//RecargarPagina(AlertChangesSaved);
			
			//driver.switchTo().alert().accept();
			
			//
			
			
		return this;
	}

	
	
	//HU13
	/**
	 * Autorizacion liberacion 548143.
	 *
	 * @param folderPath the folder path
	 * @param TituloConLiberacionesPendientes the titulo con liberaciones pendientes
	 * @param informacionGeneralE the informacion general E
	 * @param PersonaJuridica the persona juridica
	 * @param informacionG the informacion G
	 * @param SubModuloAutorizar the sub modulo autorizar
	 * @param AutoriPend the autori pend
	 * @param DetalleMercancia the detalle mercancia
	 * @param Evidencia the evidencia
	 * @return the expedir page
	 * @throws Exception the exception
	 */
	//Autorizacion de liberaciones paso a paso
	@Step("Crear expedir")
	public ExpedirPage AutorizacionLiberacion_548143(File folderPath, 
			String TituloConLiberacionesPendientes, 
			String informacionGeneralE, 
			String PersonaJuridica, 
			String informacionG,String SubModuloAutorizar,
			String AutoriPend,String DetalleMercancia,String Evidencia)
			throws Exception 
	{
		
		//click en el submodulo de liberacion
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en elemento, se desplega lista ",Evidencia);
		//Se escribe un titulo con liberaciones pendientes
		writeText(TxtTituloLiberacion, TituloConLiberacionesPendientes, folderPath, "Se digita titulo de liberacion",Evidencia);
		//Se da click en boton buscar
		click(btnSearchLiberacionButton, folderPath, "click en buscar",Evidencia);
		//click en autorizaciones pendientes
		click(btnAutorizacionPendiente, folderPath, "Click en elemento, se desplega lista ",Evidencia);
		
		//se envia como variable booleana el campo de modificar liberacion
		boolean CampoEdicionTxt = validarElemento(CampoModificarLiberacion, 10);
		//se valida variable booleana de campo de modificar liberacion
		ValidacionObjeto(CampoEdicionTxt, "caso 548142", folderPath,Evidencia);
		//se limpia el campo de texto de modificar liberacion
		clear(CampoModificarLiberacion, folderPath, "Se elimina registros preexistentes",Evidencia);
		
		//se escribe un valor numerico en campo de modificar liberacion
		writeText(CampoModificarLiberacion, "50,4", folderPath, "Se escribe un valor",Evidencia);
		//se da click en el boton de guardar liberacion
		click(btnGuardarLiberacion, folderPath, "click en guardar cambios",Evidencia);
		
		//Se envia a una variable booleana el localizador de la alerta de cambios guardados
		boolean Alerta = validarElemento(AlertChangesSaved, 10);
		//se valida alerta de cambios guardados
		ValidacionObjeto(Alerta, "caso  exitoso 548142,548143,548144 cambios realizados", folderPath,Evidencia);
		
		//click(btnOkLiberacion, folderPath, "click en boton ok");
		//click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en elemento, se desplega lista ");
		
		//se busca un titulo con liberaciones por autorizar y se valida el boton de autorizaciones pendientes
		writeText(TxtTituloLiberacion, TituloConLiberacionesPendientes, folderPath, "Se digita titulo de liberacion",Evidencia);
		click(btnSearchLiberacionButton, folderPath, "click en modificar",Evidencia);
		click(btnDetalleMercancia, folderPath, "Click en elemento, se desplega lista,Se visualiza informacion cambiada ",Evidencia);
		click(locatorVariable(lblsecciones, SubModuloAutorizar), folderPath, "Click en elemento, se desplega lista ",Evidencia);
		boolean VisualizarAutorizacion = validarElemento(btnVisualizarAutorizacionPendiente, 10);
		ValidacionObjeto(VisualizarAutorizacion, "caso 548144", folderPath,Evidencia);
		
		
		//click(btnVisualizarAutorizacionPendiente, folderPath, "click en visualizar autorizaciones, se visualiza caso 548144");
		//scrollElementH(folderPath, chxConfirmarLiberacion, "Se desplaza hasta checkbox de caso 548144");
		//RecargarPagina(lblsecciones);
		//acceptAlert(folderPath, "Se da aceptar");
		
		return this;
		
	}

	
	
	
	
}