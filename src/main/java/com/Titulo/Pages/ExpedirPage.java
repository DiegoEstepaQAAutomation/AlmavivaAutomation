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

	//objeto de tipo variable( en desuso)
	Object[] x;
	boolean val;
	int t = 15;
	
	
	//Strings con los casos existentes
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
	
	//Creacion de expedicion pero con seleccion multiple de tipo de bodega

	@Step("Crear expedir")
	public ExpedirPage crearExpedir(File folderPath, String n, String t, String o, String informacionG)
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
			etiquetas(btnCrearExpedir, folderPath, "Etiqueta Crear expedir");
			//Click sobre un elemento
			click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir");
			// se escribe un string en este caso del localizador existente del que se tomo un valor
			writeText(txtNitRazonSocial, n, folderPath, "Se ingresa el dato Nit");
			//Click sobre el parametro nit razon
			click(seleccionarNitRazon);
			//tiempo espera de codigo
			waitInMs(2000);
			//Click sobre localizador en especifico 
			click(locatorVariable(lblOpciones, informacionG), folderPath, "Click en elemento");
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
			click(lblBodegaOpcion, folderPath, "click en opcion");

		} else {
			printConsole("Error");
			Assert.fail("Error");
		}
		return this;
	}
	
	
	//Paso de seleccion de tipo de operacion
	
	@Step("Crear expedir")
	public ExpedirPage tipoOperacion(File folderPath, String n, String t, String o, String infogeneraltitulo)
			throws Exception 
	
	
	
	{
		//Obtenemos un elemento de texto existente en un xpath
		
		n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();

		//Escribimos dicho elemento en el buscador de Titulos
		writeText(txtNitCliente, n);
		
		//Click en buscar cliente
		click(btnBuscarCliente);
		//Click en crear nuevo titulo
		click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir");
		
		//Escribimos el texto tomado del localizador ya usado
		writeText(txtNitRazonSocial, n, folderPath, "Se ingresa el dato Nit");
		//Click en la opcion Nit razon social
		click(seleccionarNitRazon);
		
		//Tiempo de espera
		waitInMs(2000);
		//Click en localizador pero se envia con variable
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en elemento");
		//Scroll hacia abajo
		scrollDown();

		
		
		
		
		return this;
		
	}

	
//////HU16 CONTINU Continuacion del HU16
	@Step("Hu16")
 public ExpedirPage LpnDtlnumCoincidan1(File folderPath,String TipoDeBodega,String estadoA,String Mercancias,
 		String Lista,String Lpm,
 		String dataBDD,
 		String SubModuloExpedir,
 		//String dataBDD2
 		String Lista1) throws Exception {


	//Escritura del titulo
     writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo");
     //Validacion de un elemento en una grilla
     searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia");
     //Scroll vertical hacia un elemento hacia abajo
     scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
     //Validacion de un elemento existente en una grilla
     searchElementGrid(FrameofGridClient1, estadoA, folderPath,"Se valida estado titulo aplicada");
     //Click en modificar titulo
     click(btnModificar, folderPath, "Click en modificar cliente");
     //Click en localizador por variable
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ");
     //Dezplazamiento vertical por coordenada
     desplazarseVertical(0, 250);
     //Validacion de un elemento existente en una grilla
     searchElementGrid(FrameofGridList, Lista, folderPath,"Se valida la lista ");
     //Dezplazamiento vertical por coordenada
     desplazarseVertical(0, 500);
     //Click en filtro de busqueda
     click(btnSelectFiltro, folderPath, "click selecfiltro");
     //click en elemento en especifico del filtro
     click(btnFiltro, folderPath, "click filtro"); 
     //searchElementGridExcel2(FrameofGridExcel, folderPath,"Se lee LA TABLA");
     //searchElementGridExcel(FrameofGridExcel, folderPath,"Se lee LA TABLA");
     
     //Captura de pantalla
     captureScreen(folderPath, dataBDD);
     //Click en localizador por variable
     click(locatorVariable(btnActualizarLpm, Lpm), folderPath, "Click en Actualizar Lpm ");
     //click en localizador
     click(btnActualizarCantidades, folderPath, "click Actualizar Cantidades");
     //Se establece variable boolean de un localizador
     boolean validarAlertaCargue = validarElemento(AlertaCargue, 10);
     //Se valida variable booleana
		ValidacionObjeto(validarAlertaCargue, "Validacion", folderPath);
		
		//cp02
		//Click en variable de localizador
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		//Se escribe en el campo buscar titulo un titulo
		writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo");
		//Se busca en tabla o grilla un tipo de bodega en especifico
		searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia");
		//Se hace scroll vertical hacia localizador
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		//Se busca elemento presente  en una grilla
     searchElementGrid(FrameofGridClient1, estadoA, folderPath,"Se valida estado titulo aplicada");
     //Click en modificar titulo
     click(btnModificar, folderPath, "Click en modificar cliente");
     //click en localizador por variable
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ");
     //Scroll vertical por coordenada
     desplazarseVertical(0, 500);
     //Click en localizador
     click(btnSelectFiltro, folderPath, "click selecfiltro");
     //Click en localizador
     click(btnFiltro, folderPath, "click filtro"); 
     //captureScreen(folderPath, dataBDD2);
     searchElementGrid(FrameofGridList1, Lista1, folderPath,"Se valida la fila de la lista ");
     captureScreen(folderPath, dataBDD);
     click(locatorVariable(btnActualizarLpm, Lpm), folderPath, "Click en Actualizar Lpm ");
     //Click en localizador
     click(btnActualizarCantidades, folderPath, "click Actualizar Cantidades");
     boolean validarAlertaCargue1 = validarElemento(AlertaCargue, 10);
		ValidacionObjeto(validarAlertaCargue1, "Validacion", folderPath);
		 //Click en localizador
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		//Se escribe titulo en campo de busqueda
		writeText(txtNitRazonSocial, "1726", folderPath, "Se escribe titulo");
		//Se busca elemento presente en grilla
		searchElementGrid(FrameofGridClient1, TipoDeBodega, folderPath,"Se valida si la bodega es propia");
		//Scroll vertical hacia modificar titulo
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		 //Click en localizador
		click(btnModificar, folderPath, "Click en modificar cliente");
		 //Click en localizador
     click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Mercancia ");
     //desplazarseVertical(0, 300);
     
     //Se crea una variable booleana de cantidad de productos
     boolean validarProducto = validarElemento(lblProductos, 10);
     //se valida variable creada
		ValidacionObjeto(validarProducto, "Validacion de los productos", folderPath);
		//Scroll horizontal hacia etiqueta CJ
		scrollElementH(folderPath, lblCJ, "scroll");
		//Se crea variable booleana de cantidad de saldo
		boolean cantidadSaldo = validarElemento(lblCantidadSaldo, 10);
		//Se valida variable booleana de cantidad de saldo
		ValidacionObjeto(cantidadSaldo, "Validacion de Cantidad Saldo", folderPath);
		

     return this;
	}

	//////////////////// HU07

	//Validaciones en el formulario de creacion de titulo
	@Step("Ver Titulo Expedir")
	public ExpedirPage ValidacionExpedirFormulario1_556552(File folderPath, String Empresa2, String InfGTitulo,
			String NumeroTitulo, String SubModuloExpedir) throws Exception {
		
		//Click en el localizador de crear titulo
		click(btnCrearExpedir, folderPath, "click en crearExpedir");
		//Click en criterio de busqueda de titulo
		click(btnNit2, folderPath, "click en Razon");
		//Click en razon social
		click(btnNit, folderPath, "click en Razon Social");
		//Se escribe el titulo a buscar
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		//click en localizador
		click(btnSelecClaro, folderPath, "click en Claro");
		//click en localizador
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		//Desplazamiento vertical por coordenada
		desplazarseVertical(0,300);
		//Se busca elemento presente en una grilla, en este caso numero de titulo
		searchElementGrid(txtNumeroTitulo, NumeroTitulo, folderPath, "Se valida el numero de titulos");
		//Desplazamiento vertical por coordenada
		desplazarseVertical(0,300);
		//click en localizador en este caso boton de ingresos
		click(btnIngreso, folderPath, "Se verifica Division de ingreso");
		//se selecciona valor random de una lista del campo ingresos
		listRandom(btnIngreso, folderPath, "caso  exitoso 556550,556551, Se verifica Division de ingreso");
		//click en localizador por variable en este caso submodulo expedir
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		//click en localizador
		click(btnSalirSinGuardar, folderPath, "Salir sin Guardar");
		
		return this;
	}
	 
	/////////HU07  Contunuacion
	//Validaciones en el area de division de ingresos
	@Step("Ver Titulo Expedir")
	public ExpedirPage ValidacionExpedirDivisionIngresos(File folderPath, String InfGTitulo, String ingreso, 
			String aplicar, String SubModuloExpedir, String OficnaExpedicion, String oficinaAlmacenamiento,
			String estadoA) throws Exception {
		
		//Se escribe un titulo a buscar 
		writeText(txtNitCargue, "1795");
		//Se hace scroll hacia modificar titulo
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		//Click en modificar titulo
		click(btnModificar, folderPath, "Click en modificar cliente");
		//Click en localizador por variable
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		//Scroll vertical por coordenada
		desplazarseVertical(0,600);
		//Click en el menu division de ingresos
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso");
		//click en si
		click(lblDivisionIngreso2, folderPath, "click en si");
		//Click en localizador por variable
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso");
		//Scroll vertical por coordenada
		desplazarseVertical(0,300);
		//Se escribe un valor en cuadro de texto
		writeText(btnPorcentajeEx, "50", folderPath, "Se escribe el Porcentaje Expedicion");
		//Se escribe un valor en cuadro de texto
		writeText(btnPorcentajeAlm, "60", folderPath, "Se escribe el Porcentaje Almacenamiento");
		//Click en localizador por variable
		click(locatorVariable(btnAplicar, aplicar), folderPath, "Click en Aplicar");
		//Click en localizador 
		click(btnAceptar, folderPath, "click en Aceptar cambios ");
		//Se crea variable booleana de una alerta de una liberacion de un titulo
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
		//Se valida alerta de liberacion de titulo
     ValidacionObjeto(alertaCreadaAplicada, "Validacion de la suma del porcentaje deben ser 100 caso exitoso 556554 ", folderPath);
     
     //cp06
   //Click en localizador por variable 
     click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
   //Se escribe un valor en cuadro de texto de busqueda de titulo
     writeText(txtNitCargue, "1795");
   //Se hace scroll hacia modificar titulo
     scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
   //Click en localizador por variable 
     click(btnModificar, folderPath, "Click en modificar cliente");
   //Click en localizador por variable 
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		//Scroll vertical por coordenada
		desplazarseVertical(0,600);
		 //Click en localizador en este caso menu de division de ingreso
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso");
		//Click en localizador en este caso menu de division de ingreso en este caso se selecciona la opcion no
		click(lblDivisionIngreso3, folderPath, "click en NO");
		 //Click en localizador en este caso menu de division de ingreso
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso");
		//Scroll vertical por coordenada
		desplazarseVertical(0,300);
		//Se valida elemento existente en grilla en este caso oficina de expedicion
		searchElementGrid(txtOficinaExpedicion, OficnaExpedicion, folderPath, "556555,Se valida Oficina expedicion");
		//Se valida elemento existente en grilla en este caso oficina de almacenamiento
		searchElementGrid(txtOficinaAlmacenamiento, oficinaAlmacenamiento, folderPath, "556555,Se valida porcentaje expedicion");
		//Se crea variable de tipo booleano de campo de texto codigo SAP
		boolean CodigoSapExp = validarElemento(txtCodigoSapExp, 10);
		//Se valida variable  de tipo booleano de campo de texto codigo SAP
     ValidacionObjeto(CodigoSapExp, "Validacion del Codigo Sap Expedicion caso exitoso 556557 ", folderPath);
   //Se escribe un valor en las opciones de codigo SAP 
     writeText(txtCodigoSapExp, "WDV753", folderPath, "Se escribe el Codigo Sap Expedicion");
     //Click en localizador en este caso menu de division de ingreso
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		
		//cp07
		//Se escribe un valor en cuadro de texto de busqueda de titulo, en este caso un titulo a buscar
		writeText(txtNitCargue, "1905");
		//Scroll hacia modificar titulo
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		//Se busca estado ACTIVO en grilla de titulo
		searchElementGrid(ClientEstatus1, estadoA, folderPath,"Se valida estado de titulo como Aplicado Caso 556556");
		//Click en visualizar impresiones
		click(btnVisualizarImpresiones, folderPath, "click en impresiones");
		
		//##Se establecen como variables booleanas cada una de las caras de las impresiones 
		boolean btnImpresionBonoprenda = validarElemento(ImpresionBonoprenda, 10);
		boolean btnImpresionBonoprendaB = validarElemento(ImpresionBonoprendaB, 10);
		boolean btnImpresionCDM = validarElemento(ImpresionCDM, 10);
		boolean btnImpresionCDMB = validarElemento(ImpresionCDMB, 10);
		boolean btnImpresionA = validarElemento(ImpresionA, 10);
		boolean btnImpresionB = validarElemento(ImpresionB, 10);
		
		//**Se validan cada una de las caras de las impresiones, mediante el envio de las variables booleanas a validar objeto
		ValidacionObjetos(btnImpresionBonoprenda, btnImpresionBonoprendaB,"caso exitoso 556556 se valida impresion",folderPath);
		ValidacionObjetos(btnImpresionCDM, btnImpresionCDMB,"caso exitoso 556556 se valida impresion",folderPath);
		ValidacionObjetos(btnImpresionA, btnImpresionB,"caso exitoso 556556 se valida impresion",folderPath);

		return this;
	}
	
	
	
	

	//Se utiliza este paso para realizar validaciones de la opcion bono de creacion de titulo
	@Step("Bono de Prenda")
	public ExpedirPage bono(File folderPath, String bono, String nitB, String nitBono, String diasPlazo)
			throws Exception {

		//Click en criterio de titulo
		click(lblTipoTitulo);
		//Click en titulos por bonos
		click(lblTipoTituloBono, folderPath, "Click en tipo titulo de bono");
		//Se da click en el campo de bono dentro del titulo
		click(locatorVariable(lblOpciones, bono), folderPath, "Click en opciones titulo");
		//click en creacion de bono
		click(btnCrearBono, folderPath, "Click en crear bono");
		//Se selecciona elemento de la lista de certificado de bono y se coloca un nit
		selectElementList(lblNitNombreCertificado, nitB);
		//Se escribe un nit que ya tiene asociado un bono
		writeText(txtNitNombreBono, nitBono, folderPath, "Se escribe Nit");
		//click en localizador de nombre en la seccion bono
		click(seleccionarNitNombreBono);
		//Se escribe un valor random numerico en el campo de texto capital inicial
		writeRandomNum(txtCapitalInicial, 4);
		//Se escriben los dias de plazo
		writeText(txtDiasPlazo, diasPlazo, folderPath, "Se escribe Dias de plazo");
		//Se escribe un valor random numerico en el campo de tipo de interes
		writeRandomAlp(txtTipoInteres, 35);
		//Se escribe un valor random numerico en el campo de texto valor de interes
		writeRandomNum(txtValorInteres, 10);
		//Se escribe un valor random numerico en el campo de texto frecuencia
		writeRandomAlp(txtFrecuencia, 20);
		//click en guardar bono
		click(btnGuardarBono, folderPath, "Click en guardar bono");
		//click en aceptar
		click(btnAceptarBono, folderPath, "Click en aceptar bono");
		//Tiempo de espera
		waitInMs(500);
		//Click en el campo bono 
		click(locatorVariable(lblOpciones, bono), folderPath, "");
		return this;
	}

	
	//Paso a paso de certificado de deposito de mercancia
	@Step("Certificado de Depósito de Mercancía")
	public ExpedirPage certificado(File folderPath, String certificado, String nitCertificado, String nitC,
			String tipoEndoso) throws Exception {

		// Long day = Long.valueOf(new
		// SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));

		//click en localizador de certificado
		click(locatorVariable(lblOpciones, certificado), folderPath, "Click en opciones titulo");
		//click en crear certificado
		click(btnCrearCertificado, folderPath, "Click en crear bono");
		//Seleccionar de opcion el tipo de certificado
		selectElementList(lblNitNombreCertificado, nitCertificado);
		//Se difita nit a buscar
		writeText(txtNitNombre, nitC, folderPath, "Se escribe Nit");
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

	//Paso a paso de creacion de plazos
	@Step("Plazos")
	public ExpedirPage plazos(File folderPath, String plazos, String pCertificado, String pContrato) throws Exception {

		//Click en plazos
		click(locatorVariable(lblOpciones, plazos), folderPath, "Click en opciones titulo");
		//se escribe un plazo de certificado
		writeText(txtPlazoCertificado, pCertificado, folderPath, "Se escribe plazo certificado");
		//se escribe un plazo de contrato
		writeText(txtPlazoContatro, pContrato, folderPath, "Se escribe plazo contrato");
		//Se da click en plazos para cerrar este menu
		click(locatorVariable(lblOpciones, plazos), folderPath, "Click en opciones titulo");
		return this;
	}
	
	

	//HU10 
	// Paso a paso de creacion de poliza
	@Step("Póliza")
	public ExpedirPage poliza_547049(File folderPath, String poliza) throws Exception {

		//Se da click en el modulo titulo
		click(locatorVariable(lblModulos, " Título "), folderPath, "Click en opciones titulo");
		//click en submodulo expedir
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en opciones titulo");
		//se escribe titulo de cliente a buscar
		writeText(txtNitCliente, "1661", folderPath, "escribir titulo cliente");
		//Click en modificar cliente
		click(btnModificar, folderPath, "Click en modificar cliente");
		//click en la opcion poliza
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en menu opciones poliza");
		//se escribe un valor random en el campo de texto poliza
		listRandom(lblPoliza, folderPath, "Se selecciona valor random,caso exitoso 547049,547050,547051,547054,547055");
		//click en la opcion poliza para cerrar la seccion de poliza
		click(locatorVariable(lblOpciones, poliza), folderPath, "Click en menu opciones poliza");
		return this;
	}

	@Step("Tipo de Mercancía")
	public ExpedirPage tipoMercancia(File folderPath, String tipoMercancia) throws Exception {

		
		//click en tipo de mercancia
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en menu opciones tipos de mercancia");
		//Se selecciona valor random en el tipo de mercancia
		listRandom(lblTipoMercancia, folderPath, "Se selecciona valor random");
		//se escribe valor random alfanumerico en descripcion general
		writeRandomAlp(txtDescripcionGeneral, 40);
		//Se escribe valor random numerico en la caja de texto de merma
		writeRandomNum(txtMerma, 4);
		//Se selecciona valor random en si o no  de aplicar condicion
		listRandom(lblAplicaCondicion, folderPath, "Se selecciona valor random");
		//se escribe valor alfanumerico random en observaciones
		writeRandomAlp(txtObservaciones, 10);
		//Scroll hacia arriba 
		scrollUp();
		//click en tipo de mercancia para cerrar esta seccion
		click(locatorVariable(lblOpciones, tipoMercancia), folderPath, "Click en opciones tipo mercancia");
		return this;
	}

	@Step("Mercancías 'Individual'")
	public ExpedirPage mercanciasIndividual(File folderPath, String mercancias, String cargueI) throws Exception {

		//Proceso de mercancias con cargue individual
		click(locatorVariable(lblOpciones, mercancias), folderPath, "Click en opciones tipo mercancias");
		selectElementList(lblTipoCargue, cargueI, folderPath, "Se selecciona valor de lista");
		click(btnCrearCargueIndividual, folderPath, "Click en crear mercancia");
		writeRandomAlp(txtDetalleMercancia, 40);
		listRandom(lblUnidadMedida, folderPath, "Se selecciona valor random de la lista");
		listRandom(lblUnidadMedidaSuper, folderPath, "Se selecciona valor random de la lista");
		writeRandomNum(txtValorConversion, 2);
		writeRandomNum(txtCantidad, 18);
		writeRandomNum(txtValorUnitario, 28);
		//Se escribe una fecha utilizando el metodo dateplusyear para sumar un año a la fecha actual
		writeText(txtFechaVencimientoMercancia, datePlusYear(3));
		writeRandomAlp(txtObservacionMercancia, 100);
		//se guarda mercancia 
		click(btnGuardarMercancia, folderPath, "Click en guardar mercancia");
		click(btnAceptarMercancias, folderPath, "Click en aceptar mercancia");
		click(locatorVariable(lblOpciones, mercancias), folderPath, "Se selecciona valor de opciones");
		return this;
	}

	//Paso a paso de tarifas
	@Step("Tarifas")
	public ExpedirPage tarifas(File folderPath, String tarifas) throws Exception {

		click(locatorVariable(lblOpciones, tarifas), folderPath, "Click en opciones tarifas");
		writeRandomNum(txtTarifa, 15);
		writeRandomNum(txtMinima, 50);
		click(locatorVariable(lblOpciones, tarifas), folderPath, "Click en opciones tarifas");
		return this;
	}

	//Guardar expedir
	@Step("Guardar expedir")
	public ExpedirPage guardarExpedir(File folderPath) throws Exception {

		click(btnGuardarExpedir, folderPath, "Click en Guardar y expedir");
		return this;
	}

	//Se realizan impresiones
	@Step("Imprimir")
	public ExpedirPage imprimir(File folderPath, String titulo) throws Exception {

		
		//proceso para visualizar impresiones
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
	
	//Modificaciones a titulos expedidos
	@Step("Modificar expedir")
	public ExpedirPage modificarExpedir(File folderPath, String titulo, String poliza, String tipoMercancia) throws Exception {
		
		//Proceso para visualizar y modificar titulo
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
		
		//Validacion antigua (en desuso)
		val = validarElemento(lblGudadoExitoso, t);

	    if (Boolean.FALSE.equals(val)) {
	    	GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + lblGudadoExitoso);
	        Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + lblGudadoExitoso);
	    }
		return this;
	}
	
	//Paso a paso de visualizar un titulo
	@Step("Ver expedir")
	public ExpedirPage verExpedir(File folderPath) throws Exception {

		//se ingresa a un titulo ya creado
		scrollElementH(folderPath, btnVerExpedir, "Se desplaza hasta la opción Ver expedir");
		etiquetas(btnVerExpedir, folderPath, "Etiqueta Ver expedir");
		click(btnVerExpedir, folderPath, "Se ingresa a ver expedir");

		
		//se utiliza is enabled para verificar que los campos de los localizadores estan en enabled 
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
		
		//proceso de cancelar la creacion de un titulo
		writeText(txtBuscar, TituloCancelado,folderPath, "Se escribe Id de titulo ");
		click(btnBusquedaTitulo, folderPath, "click busqueda titulo");
		scrollElementH(folderPath, ModificarCancelado, "Se desplaza hasta el elemento deseado");
		
		searchElementGrid(ClientEstatus1, EstadoC, folderPath, "Se valida estado de titulo como cancelado Caso 543825");
		click(VisualizarCancelado, folderPath, "click sobre modificar elemento");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		scrollElementV(folderPath, btnCantidadInicial, "Se desplaza hasta el elemento");
		
		//validaciones de grilla sobre cantidades inicial y actual
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543825 exitoso se validan campos");
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543825 exitoso se validan campos");
		
		screenshot(folderPath ,"Estos son los casos: " + ValidacionTitulos);
		return this;
	}

	//HU19 
	//Validaciones de liberacion paso a paso
	@Step("Ver expedir")
	public ExpedirPage ValidacionLiberacion_543826(File folderPath,String TituloLiberacion,
			String Detalle,String EstadoC,String CantInicial,String CantActual,
			String LiberarCantidad,String Sinicial,String TituloHistorico,String TituloLiberacionInicial,String Mercancias ) throws Exception 
	{
		//Se busca un titulo con liberaciones y se valida en grilla los campos de cantidad inicial,actual,liberar cantidad, y saldo inicial
		writeText(txtBuscaTitulo, TituloLiberacion, folderPath, "Se digita el titulo a buscar");
		click(lblCodigoLiberacion, folderPath, "");
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en detalle  Mercancias");
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Cant. Inicial"), "Se desplaza hasta el campo detalle de mercancia");
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543826 exitoso se validan campos");
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543826 exitoso se validan campos");
		searchElementGrid(ClienteMercanciaState, LiberarCantidad, folderPath, "Caso 543826 exitoso se validan campos");
		searchElementGrid(ClienteMercanciaState, Sinicial, folderPath, "Caso 543826 exitoso se validan campos");
		//scroll a una variable localizador en este caso valor total y accion
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Valor Total"), "Click en opciones titulo");
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Acción"), "Click en opciones titulo");
		
		
		//se ingresa a expedir y se busca y valida un titulo en estado cancelado
		click(locatorVariable(lblsecciones,"Expedir"),folderPath, "click en Liberacion");
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar, 546945 se consulta titulo en estado cancelado o aplicado");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		searchElementGrid(AlternativeGridstatus, EstadoC, folderPath, "Se valida el estado aplicado del titulo del caso 546943");

		
		//Se ingresa al submodulo de liberacion y se valida mediante grilla las cantidades inicial, actual,y el saldo inicial
		click(locatorVariable(lblsecciones,"Liberación"),folderPath, "click en Liberacion");
		writeText(txtBuscaTitulo, TituloHistorico, folderPath, "Se digita el titulo a buscar");
		click(lblCodigoLiberacion, folderPath, "");
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en detalle  Mercancias");
		scrollElementV(folderPath, locatorVariable(lblCamposDetalleMercancia, "Cant. Inicial"), "Se desplaza hasta el campo detalle de mercancia");
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543827 exitoso se validan campos");
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543827 exitoso se validan campos");
		searchElementGrid(ClienteMercanciaState, Sinicial, folderPath, "Caso 543827 exitoso se validan campos");
		click(locatorVariable(lblsecciones,"Liberación"),folderPath, "click en Liberacion");
		

		
		
		screenshot(folderPath ,"Estos son los casos: " + ValidarLiberacion);
		
		return this;
		
	}
	//paso a paso de mercancias liberadas 
	@Step("Ver expedir")
	public ExpedirPage ValidacionMercanciaLiberada(File folderPath,String TituloLiberado,
			String Detalle,String CantInicial,String CantActual,String TituloCancelado ) throws Exception 
	{ 
		
		//Proceso para liberar una mercancia
		writeText(BuscarTitulo, TituloLiberado);
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza hasta la opción modificar ");
        click(ModificartituloLiberado, folderPath, "Se da click sobre modificar ");
        scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias");
        
        //Validaciones de titulo liberado, Se validan los campos de cantidad inicial y actual , Se cancela la operacion 
        click(locatorVariable(lblOpciones2, " Mercancías "), folderPath, "Click en Mercancias");
        searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "Caso 543829,543830 exitoso se validan campos, Se valida que el valor esta en 0");
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "Caso 543829,543830 exitoso se validan campos, Se valida que el valor esta en 0");
        scrollElementV(folderPath, btnCancelar, "Se desplaza hasta la opcion cancelar");
		click(btnCancelar, folderPath, "Click en cancelar");
		
		//Verifica el funcionamiento de las funciones de liberacion
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en la seccion de liberacion");
		writeText(TxtTituloLiberacion, TituloCancelado, folderPath, "");
		click(btnBuscarLiberacion, folderPath, "click en la liberacion a buscar");
		click(locatorVariable(lblOpciones2, " Detalle de mercancía "), folderPath, "Click en Mercancias");
		click(btnOkLiberacion, folderPath, "click en aceptar liberacion");
		
		//Se valida que la liberacion sea efectiva mediante la alerta y su posterior consulta en el submodulo de expedir
		boolean validarbtncargarf = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(validarbtncargarf, "Se valida que el titulo ya no tiene liberaciones del caso 543829 caso exitoso",folderPath);
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en la seccion expedir");
		writeText(BuscarTitulo, TituloLiberado);
		scrollElementH(folderPath, VisualizarTitulo, "Se desplaza hasta la opción Ver cupo");
		
		//Visualizar el cupo de titulo 
		click(VisualizarTitulo, folderPath, "Se ingresa a ver Cupo");
		scrollElementV(folderPath, locatorVariable(lblOpciones2, " Mercancías "), "Se desplaza hacia la opcion mercancias");
	    click(locatorVariable(lblOpciones2, " Mercancías "), folderPath, "Click en Mercancias");
	    scrollElementV(folderPath, btnCancelar, "click en la opcion cancelar");
	    
	    //desplazarseVertical(0, 400);
			
	    click(btnCancelar, folderPath, "Click en cancelar");
	
		screenshot(folderPath ,"Estos son los casos: " + ValidarMercanciaLiberada);
		
		
		
		return this;
		
		
	}
	
	//HU32
	//Validaciones en detalle mercancia
	@Step("Ver expedir")
	public ExpedirPage ObjetoPresente(File folderPath,String TituloaLiberar,String Detalle) throws Exception 
	{ 
		
		//Busqueda de titulo y acciones sobre el ok al final
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
	
	@Step("Ver expedir")
	public ExpedirPage ValidacionExpedirLiberacion(File folderPath,String TituloLiberado,String Detalle,String Mercancias) throws Exception 
	{ 
		
		//Se escribe un titulo con liberaciones, se modifica y se visualiza el titulo
		writeText(txtBuscaTitulo, TituloLiberado, folderPath, "Se digita el titulo a buscar");
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza al elemento");
		click(ModificartituloLiberado, folderPath, "click en modificar articulo");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		scrollElementV(folderPath, btnObservarTitulo, "Se desplaza hasta la opcion observar titulo");
		//Se visualiza el titulo
		click(btnObservarTitulo, folderPath, "click en observar titulo");
		click(btnCancelarvista, folderPath, "click en cancelar vista");
		
		
		
		
		
		return this;
		
		
	}
	
	
	
	
	
	
	
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage BodegaCargue(File folderPath,String NitClienteAsociado,String Mercancias) throws Exception {
		

		
		//Se busca un titulo, se modifica y se busca cancelarlo, pero al final se cancela el titulo
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
		
		
		//Se dezplaza horizonta y verticalmente para situarse sobre el boton modificar anulacion, se da click en mercancias
		scrollElementH(folderPath, ModificarAnulado, "Se desplaza hasta el boton modificar cliente");
		scrollElementV(folderPath, ModificarAnulado, "Se desplaza hasta el boton modificar cliente");
		click(ModificarAnulado, folderPath, Mercancias);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0,400);
		click(btnCancelarEstado, folderPath, Mercancias);
	
		
		
		return this;
	}
	
	//HU08
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
	
	@Step("Ver Bodega de cargue")
	public ExpedirPage ValidacionHistorico_546943(File folderPath,
			String TituloHistorico,String DetalleMercancia,String EstadoC,
			String Mercancias,String ValidarVisualizacionLiberacion,
			String CantInicial,String CantActual,String LiberarCantidad,String Sinicial,String etiquetaPoliza,
			String  poliza,String TituloEjemplo,
			String TituloIncompleto,String TituloCancelado,String Producto
			) throws Exception {
		
		//Se busca un titulo con historico de liberaciones 
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar, 546945 se consulta titulo en estado cancelado o aplicado");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		searchElementGrid(AlternativeGridstatus, EstadoC, folderPath, "Se valida el estado aplicado del titulo del caso 546943");
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en Mercancias");
		writeText(TxtTituloLiberacion, TituloHistorico, folderPath, "Se digita titulo de liberacion");
		click(btnSearchLiberacionButton, folderPath, "click en modificar");
		
		//Validaciones de los encabezados de cantidad inicial,actual,cantidad a liberar y saldo inicial
		click(DetalleMercancialbl, folderPath, "Click en Mercancias");
		//scrollElementV(folderPath, btnClose, "scroll hacia boton cerrar");
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "caso 546943 exitoso se puede observar informacion");
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "caso 546943 exitoso se puede observar informacion");
		searchElementGrid(ClienteMercanciaState, LiberarCantidad, folderPath, "caso 546943 exitoso se puede observar informacion");
		searchElementGrid(ClienteMercanciaState, Sinicial, folderPath, "caso 546943 exitoso se puede observar informacion");
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en Mercancias");
		writeText(BuscarCliente, "1651", folderPath, "Se digita titulo de liberacion");
		click(lblVisualizarTitulo, folderPath, "Click en visualizar");
		
		desplazarseVertical(0, 600);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		click(btnVisualizarLiberacionGrid, folderPath, "click en visualizacion");
		searchElementGrid(gridLiberacion, ValidarVisualizacionLiberacion, folderPath, "caso 546943 exitoso se puede observar informacion");
		click(btnClose, folderPath, "cerrar consulta");
		
		//Se valida la existencia del boton visualizar mediante la variable booleana y el metodo validar objeto
		scrollElementH(folderPath, lblVisualizarHistorico, "scroll a elemento");
		boolean btnVisualizarHistorico = validarElemento(lblVisualizarHistorico, 10);
		ValidacionObjeto(btnVisualizarHistorico,"caso 546943,546947 se valida existencia de boton visualizar ", folderPath);
		click(lblVisualizarHistorico, folderPath, "click en visualizar liberacion,546945 se visualiza cantidad inicial");
		click(btnClose, folderPath, "cerrar consulta");
		
		//Se consulta en expedir nuevamente el titulo para cersiorarse de que esten los campos cantidad inicial y cantidad actual si el titulo esta cancelado
		click(locatorVariable(lblsecciones, "Expedir"), folderPath, "Click en Mercancias");
		writeText(txtNitCargue, TituloCancelado, folderPath, "Se escribe el titulo a buscar,546946 se consulta estado diferente a aplicado");
		scrollElementH(folderPath, lblVisualizarTitulo, "Se desplaza hasta modificar titulo");
		click(lblModificarHistorico, folderPath, "click en modificar");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		desplazarseVertical(0, 500);
		
		scrollElementH(folderPath, btnVisualizarLiberacion, "Se desplaza hasta elemento");
		click(btnVisualizarLiberacion, folderPath, "Click en visualizar");
		searchElementGrid(ClienteMercanciaState, CantInicial, folderPath, "caso 543825,543827, 543829,543830,546944,546945,546946 exitoso se puede observar informacion");
		searchElementGrid(ClienteMercanciaState, CantActual, folderPath, "caso 543825,543829,543827,543830,546944,546945,546946 exitoso se puede observar informacion");
		click(btnClose, folderPath, "cerrar consulta");
		
		//GridLiberacionesHistoricos
		//screenshot(folderPath ,"Estos son los casos: " + Historico);
		
		return this;
	}
	
	//HU10 
	//Paso a paso para validar que el usuario administrador pueda modificar titulos
	@Step("Ver Bodega de cargue")
	public ExpedirPage UsuarioAdmin(File folderPath,String etiquetaPoliza,String  poliza, 
			String TituloHistorico,String SeccionA,String usuario2,
			String TituloGrabado,String TituloIncompleto,
			String Mercancias,String ModuloS) throws Exception {
		
		
		//se busca y se ingresa a un titulo con historico de liberaciones
		
		writeText(txtNitCargue, TituloHistorico, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		//boolean validarbtndescargaE = validarElemento(btnDescargar, 10);
		//boolean validarbtncargarE = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		
		//ValidacionObjetos(validarbtncargarE,validarbtndescargaE,"542494 Se valida la no presencia de los botones de carge y descargue de archivos el caso 542494 es exitoso", folderPath);
		
		
		desplazarseVertical(0, 400);
		//POLIZA acciones sobre la seccion de poliza y validaciones 
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias");
		desplazarseVertical(0, 400);
		desplazarseVertical(0, 300);	
		click(btnCancelar, folderPath, "click en cancelar");
		
		
		writeText(txtNitCargue, TituloGrabado, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		//Validaciones de botones de cargue y descargar archivos
		boolean validarbtndescarga = validarElemento(btnDescargar, 10);
		boolean validarbtncargar = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		
		ValidacionObjetos(validarbtndescarga,validarbtncargar,"542493 Se valida la presencia de los botones de carge y descargue de archivos", folderPath);
		
		
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias");
		desplazarseVertical(0, 400);
		click(locatorVariable(lblOpciones, etiquetaPoliza), folderPath, "Click en Mercancias");
		
		
		desplazarseVertical(0, 400);
		click(btnCancelar, folderPath, "click en cancelar");
		
		//Validaciones de botones de cargue y descargue en titulos incompletos	
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
		
		//Se digita una fecha en calendario y se guardan los cambios
		writeText(btnCalendar, "07072022", folderPath, "escribe en calendario");
		click(btnGuardarCambios, folderPath, "guarda cambios");
		click(btnSeguroCambiar, folderPath, "acepta cambios");
		click(btnOkay, folderPath, "click en ok");
		
		click(btnCloseMercaciaEdicion, folderPath, "cierra edicion de mercancia");
		
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
	
		click(btnCancelar, folderPath, "click en cancelar");	
		//se consulta el usuario en en submodulo de usuarios en el modulo de seguridad
		
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
		searchElementGrid(GridUsuario, tipoUser, folderPath, "Se valida tipo de usuario superadmin casos 545511, 545512, 545513, 545514");
		click(btnVisualizarUsuario, folderPath, "Click en visualizar usuario");
		scrollElementV(folderPath, txtEmailUsuario, "scroll hasta elemento deseado");
		
		//Se ingresa al submodulo expedir y se busca un titulo que contenga la opcion bono prenda y se ingresa a informacion general del titulo
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitCargue, Titulobonoprenda, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo, Se visualiza campo fecha casos 545511, 545512, 545513, 545514");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo, Se visualiza campo fecha casos 545511, 545512, 545513, 545514");
		
		//click en ver bono prenda
		//desplazarseVertical(0, 600);
		click(btnVerBonoPrenda, folderPath, "Click en ver bono prenda,casos exitosos 545511, 545512, 545513, 545514, el elemento actualmente no permite realizar accion alguna sobre el pero es editable y cambia de acuerdo al caso");
		//scrollElementH(folderPath, FechaVencimiento, "scroll hasta elemento casos exitosos 545511, 545512, 545513, 545514, el elemento actualmente no permite realizar accion alguna sobre el pero es editable y cambia de acuerdo al caso");
		click(btnVerBonoPrenda, folderPath, "Click en ver bono prenda");
		
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en tiempo de prenda");
		click(locatorVariable(lblOpciones, LapsoTiempo), folderPath, "Click en tiempo de prenda");
		
		//Se busca un titulo en el submodulo expedir
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");		
		writeText(txtNitCargue, TituloNoEditable, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo,Se visualiza fecha no editable 545513 ");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo");
		
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitCargue, Titulobonoprenda, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		
		//Se valida mediante variables booleanas y validar elemento los botones de impresion y de bono prenda
		boolean btnImpresion = validarElemento(btnVisualizarImpresiones, 10);
		ValidacionObjeto(btnImpresion, "Caso 545514 se valida boton impresiones", folderPath);
		//click en el icono de impresiones para visualizar dichas impresiones
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
	
	//Se verifica mediante el paso a paso que el tipo de usuario aplicador funcione
	@Step("Ver Bodega de cargue")
	public ExpedirPage UsuarioAplicador_554763(File folderPath,String usuario2,String ModuloT,String SubModuloExpedir,String titulograbado,
			String Titulobonoprenda,String infogeneraltitulo,
			String SubModuloExpedir1,String ModuloT1,String aplicador,String SeccionPerfil,String UsuarioAplicador ) throws Exception {
		
		
		//Se consulta el usuario aplicador
		click(locatorVariable(lblModulos, " Seguridad "),folderPath,"click en la seccion perfil");
		click(locatorVariable(lblsecciones, "Roles"),folderPath,"click en la seccion perfil");
		writeText(SearchRole, UsuarioAplicador, folderPath, "");
		searchElementGrid(GridRoles, UsuarioAplicador, folderPath, "Se valida tipo de usuario aplicador caso 554748 ");
		click(btnVisualizarRolesExistentes, folderPath, "click en rol");
		
		//searchElementGrid(GridRol, aplicador, folderPath, "Se valida que el usuario sea aplicador");
		
		//se consulta su perfil
		click(locatorVariable(lblsecciones, SeccionPerfil),folderPath,"click en la seccion perfil");
		writeText(txtBusquedaUsuario, aplicador, folderPath, "Se busca el perfil de aplicador");
		searchElementGrid(GridDePerfiles, aplicador, folderPath, "Se valida la existencia del perfil de aplicador 554763,554749");
		click(btnModificarPerfil, folderPath, "Click en modificar perfil");
			
		click(lblTitulo,folderPath,"click en la seccion perfil");
		click(lblExpedir,folderPath,"click en la seccion expedir");
		
		
		//se consulta si el usuario aplicador puede liberar un titulo
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
		
		
		// Se guarda y se aceptan los cambios
		click(btnSafe, folderPath, "guardar titulo ");
		click(btnAceptarCambios, folderPath, "click en aceptar");
		boolean alertaCreada = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(alertaCreada, "Validacion de creacion de titulo 554749", folderPath);
		
		
		
		
		
		
		
		screenshot(folderPath ,"Estos son los casos: " + Aplicador);
		
		
		
		
		
		return this;}
	
	
	//Paso a paso de impresion de titulo con una mercancia de tipo generica 
	@Step("Crear expedir")
	public ExpedirPage MercanciaGenerica(File folderPath, String nitExpedir, String descripcion, String tipoMercanciaE,String SubModuloExpedir,String Titulobonoprenda)
			throws Exception 
	
	
	{
		
		//Se crea un titulo y se valida el funcionamiento de los botones de impresiones
			
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
		
		//se da click en los botones de impresiones
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
		
		
		
		//Se busca un usuario y se visualiza, se valida que el usuario puede modificar titulos
		writeText(SearchUsuary, usuario2, folderPath, "Se busca un usuario");
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
	
	//HU22
	@Step("Ver Bodega de cargue")
	public ExpedirPage CP08(File folderPath,String usuario2,
			String ModuloT,String SubModuloExpedir,String TituloNoEditable,
			String Prorroga,String lblbonoprenda,
			String LapsoTiempo,String infogeneraltitulo,String Mercancias ) throws Exception {
		
		//Busqueda de un usuario en el modulo de seguridad
		writeText(SearchUsuary, usuario2, folderPath, "");
		click(btnVisualizarUsuario, folderPath, "Click en visualizar usuario");
		scrollElementV(folderPath, txtEmailUsuario, "scroll hasta elemento deseado");
		//Se ingresa de nuevo a modulo titulos y a submodulo expedir
		click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		writeText(txtNitCargue, TituloNoEditable, folderPath, "Se escribe el titulo a buscar");
		
		//se toma un valor de texto de un localizador y se envia a una variable de tipo string
		String codigo = readText(NumberProrrogaValida, folderPath, "Escritura");
		
		
		//Se dirige hacia modificar titulo y se ingresa a mercancias
		scrollElementH(folderPath, lblModificarHistorico, "Se desplaza hasta modificar");
		click(lblModificarHistorico, folderPath, "click en modificar titulo");
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		//boolean validarbtndescargaE = validarElemento(btnDescargar, 10);
		//boolean validarbtncargarE = validarElemento(btnCargue1, 10);
		click(locatorVariable(lblOpciones, Mercancias), folderPath, "Click en Mercancias");
		
		//ValidacionObjetos(validarbtncargarE,validarbtndescargaE,"542494 Se valida la no presencia de los botones de carge y descargue de archivos el caso 542494 es exitoso", folderPath);
		
		
		//Se ingresa a la seccion y prorroga y se hacen los paso a paso de esta
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
		
		//Se verifican las secciones que existen dentro del titulo
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
	
		//se toma un screenshot final
		screenshot(folderPath ,"Estos son los casos: " + Edicion);
		
		
		
		return this;
		
		
	}
	
	//Paso a paso de la reversion de liberaciones
	@Step("Ver Bodega de cargue")
	public ExpedirPage ReversarLiberacion_558597(File folderPath,
			String ModuloT,String SubModuloExpedir,
			String estadoA,String infogeneraltitulo) throws Exception
	{
		
		
		
		//n = driver.findElement(By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]")).getText();
		//se crea una variable string llamada titulo y se le envia un valor de texto de un localizador
		String Titulo;
		Titulo = driver.findElement(ValorTituloReversable).getText();
		
		//Proceso de reversion de liberacion de mercancia
		click(btnVisualizarReversion, folderPath, "click en visualizar reversion");
		scrollElementH(folderPath, chxReversar, "click en el check de reversar titulo");
		click(chxReversar, folderPath, "click en check de reversar");
		click(btnReversar, folderPath, "click en reversar");
		click(btnAceptarReversion, folderPath, "Click en aceptar, caso exitoso 558596,558597,558598");
		
		//Se valida como ya se ha visto antes la existencia 
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
		ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso exitoso 558601 ,558595, ", folderPath);
		click(lblExpedir, folderPath, "Click en expedir");
		
		//proceso de busqueda y validacion de un titulo en estado activo
		writeText(txtNitCargue, Titulo, folderPath, SubModuloExpedir);
		searchElementGrid(GridTitulo, estadoA, folderPath, "estado aplicado");
		click(lblModificarHistorico, folderPath, "click en modificar");
		click(locatorVariable(lblOpciones, infogeneraltitulo), folderPath, "Click en info general de titulo");
		scrollElementV(folderPath, BodegaOpcionTransito, "scroll hasta bodega de transito ");
		// Se valida la opcion de transito
		boolean BodegaTransito = validarElemento(BodegaOpcionTransito, 10);
		ValidacionObjeto(BodegaTransito, "Validacion de aplicacion caso 558599 ,554763,558600,558602,558609 ", folderPath);
		
		
		
		return this;
		
		
	}
	
	
	
	
	
	//HU15 Modificacion de prorrogas
	//Se hace un paso a paso de la modificacion de una prorroga
	@Step("Ver Bodega de cargue")
	public ExpedirPage ProrrogasModificacion_546952(File folderPath,String TituloModificarProrroga,String SeccionP,String estadoA,String ValorProrroga) throws Exception {
		
		//se ingresa normalmente a un titulo en especifico
		writeText(txtNitCargue, TituloModificarProrroga, folderPath, "Se escribe el titulo a buscar");
		scrollElementH(lblModificarHistorico);
		
		searchElementGrid(AlternativeGridstatus, estadoA, folderPath, "Se valida en estado aplicado caso 546952");
		//Se toma el valor de texto de un localizador y se envia a una variable de tipo string para su uso posterior
		String codigo = readText(NumberProrrogaValida, folderPath, "Escritura");
		click(locatorVariable(lblsecciones, SeccionP), folderPath, "Click en Prorrogar");
		// Se escribe el valor tomado del localizador codigo 
		writeText(txtCodigoTitulo, codigo, folderPath, "titulo con prorroga a buscar");
		click(lblBusquedaProrroga, folderPath, "click en prorroga");
		click(lblBonoPrenda, folderPath, "Click sobre bono de prenda");
		scrollElementV(folderPath, HeaderProrrogar, "Bajar a encabezados de la columna");
		//se realizan las validaciones finales
		searchElementGrid(GridProrroga, ValorProrroga, folderPath, "Caso 546952,546953,546954 exitoso");
		scrollElementV(folderPath, lblPaginacion, SeccionP);
		screenshot(folderPath ,"Estos son los casos: " + Prorrogas);
		
		
		return this;
		
	}
	
	//Operaciones de titulo 
	@Step("Crear expedir")
	public ExpedirPage OperacionTitulo_552036(File folderPath, 
			String TituloGrabado, String informacionGeneralE, String PersonaJuridica, String informacionG,String TituloHistorico)
			throws Exception {

			//Se ingresa a las opciones de creacion de titulo 
	
			etiquetas(btnCrearExpedir, folderPath, "Etiqueta Crear expedir");
			click(btnCrearExpedir, folderPath, "Se ingresa a crear expedir");
			click(btnCriterio, folderPath, "Se ingresa a crear expedir");
			click(RazonSocial, folderPath, "Se ingresa a crear expedir");
			writeText(txtNitRazonSocial, PersonaJuridica, folderPath, "Se ingresa el dato Nit");
			click(seleccionarNitRazon);
			waitInMs(2000);
			desplazarseVertical(0, 500);
			click(locatorVariable(lblOpciones, informacionGeneralE), folderPath, "Click en elemento");
			
			//Validaciones de tipo de operacion 
			boolean btnTipoOperacion = validarElemento(TipoOperacion, 10);
			ValidacionObjeto(btnTipoOperacion, "Se valida boton de tipo de operacion", folderPath);
			desplazarseVertical(0, 500);
			click(locatorVariable(TipoOperacion, informacionGeneralE), folderPath, "Click en elemento, se desplega lista ");
			listRandom(TipoOperacion, folderPath, "Se selecciona valor random caso 552036,552037,552038,552039,552040 ");
			
			click(btnCancelarCreacion, folderPath, "");
			
			//Se modifica un titulo que esta en estado grabado y se realizan modificaciones para validar las alertas de funcionamiento
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
			
			//Se escribe un titulo con historial de liberaciones y se revisa por dentro
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
	//Autorizacion de liberaciones paso a paso
	@Step("Crear expedir")
	public ExpedirPage AutorizacionLiberacion_548143(File folderPath, 
			String TituloConLiberacionesPendientes, 
			String informacionGeneralE, 
			String PersonaJuridica, 
			String informacionG,String SubModuloAutorizar,
			String AutoriPend,String DetalleMercancia)
			throws Exception 
	{
		
		//click en el submodulo de liberacion
		click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en elemento, se desplega lista ");
		//Se escribe un titulo con liberaciones pendientes
		writeText(TxtTituloLiberacion, TituloConLiberacionesPendientes, folderPath, "Se digita titulo de liberacion");
		//Se da click en boton buscar
		click(btnSearchLiberacionButton, folderPath, "click en buscar");
		//click en autorizaciones pendientes
		click(btnAutorizacionPendiente, folderPath, "Click en elemento, se desplega lista ");
		
		//se envia como variable booleana el campo de modificar liberacion
		boolean CampoEdicionTxt = validarElemento(CampoModificarLiberacion, 10);
		//se valida variable booleana de campo de modificar liberacion
		ValidacionObjeto(CampoEdicionTxt, "caso 548142", folderPath);
		//se limpia el campo de texto de modificar liberacion
		clear(CampoModificarLiberacion, folderPath, "Se elimina registros preexistentes");
		
		//se escribe un valor numerico en campo de modificar liberacion
		writeText(CampoModificarLiberacion, "50,4", folderPath, "");
		//se da click en el boton de guardar liberacion
		click(btnGuardarLiberacion, folderPath, "click en guardar cambios");
		
		//Se envia a una variable booleana el localizador de la alerta de cambios guardados
		boolean Alerta = validarElemento(AlertChangesSaved, 10);
		//se valida alerta de cambios guardados
		ValidacionObjeto(Alerta, "caso  exitoso 548142,548143,548144 cambios realizados", folderPath);
		
		//click(btnOkLiberacion, folderPath, "click en boton ok");
		//click(locatorVariable(lblsecciones, "Liberación"), folderPath, "Click en elemento, se desplega lista ");
		
		//se busca un titulo con liberaciones por autorizar y se valida el boton de autorizaciones pendientes
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