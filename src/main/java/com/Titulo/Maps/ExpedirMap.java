package com.Titulo.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class ExpedirMap extends BasePage {

	public ExpedirMap(WebDriver driver) {
		super(driver);
	}

	//Maps object de modulo titulo y liberacion
	protected By Tipobodega = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[1]/div/div/button");
	protected By MercanciaGrid = By.xpath("//*[@id='tbMercancia']/thead/tr/th[(text()='{0}')]");
	protected By TxtTituloLiberacion = By.xpath("//*[@id='titulo']");
	protected By ClientEstatus1 = By.xpath("//*[@id='tbClientes']/tbody/tr");
	protected By ClienteMercanciaState = By.xpath("//*[@id='tbMercancia']/thead/tr");
	protected By btnBuscarLiberacion = By.xpath("//*[@id='ngb-typeahead-1-0']");
	protected By alertaLiberacion = By.xpath("//*[@id='toast-container']");
	protected By btnOkLiberacion = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[3]/div/div[2]/div/div[4]/div/button[1]");
	protected By gridLiberacion = By.xpath("//*[@id='tbClientes']/thead/tr");
	protected By AlternativeGridstatus = By.xpath("//*[@id='tbClientes']/tbody/tr");
	protected By GridLiberacionMercancia= By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/thead/tr");
	protected By btnSearchLiberacionButton = By.xpath("//body/app-root/div/div/div/main-titulos/app-liberacion-mercancia/div/app-filtrotitulo/form/div/div/ngb-typeahead-window/button");
	protected By btnVisualizarLiberacion = By.xpath("//*[@id='tbMercancia']/tbody/tr/td[10]/a");
	protected By btnVisualizarLiberacionGrid = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[11]/a");
	protected By GridLiberacionesHistoricos = By.xpath("//*[@id='tbClientes']/thead/tr");
	protected By gridLiberacion2 = By.xpath("//*[@id='tbClientes']/thead/tr/th[contains(text(),'{0}')]");
	protected By GridProrroga = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[3]/div/div[2]/div/div[2]/div[1]/table/thead/tr");
	protected By TipoOperacion = By.xpath("//*[@id='tipoOperacion']");
	protected By btnAlertaTipoOperacion = By.xpath("//body/div[3]/div/div[3]/button[1]");
	protected By btnAplicarCambios = By.xpath("//button[@class='btn float-right col-2 mr-2 botones-rojo ng-star-inserted']");
	protected By btnCriterio  = By.xpath("//*[@id='criterio']");
	protected By btnSaveChanges = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button[1]");
	protected By AlertChangesSaved = By.xpath("//*[@id='toast-container']");
	protected By CampoModificarLiberacion= By.xpath("/html/body/app-root/div/div/div/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[2]/div/div[2]/div/app-modificacion-autorizaciones/div[1]/table/tbody/tr[1]/td[5]/input");
	protected By btnSalirSinGuardar= By.xpath("//body/div[3]/div/div[3]/button[2]");
	protected By btnCancelarCreacion = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button[2]");
	protected By btnGuardarLiberacion = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[2]/div/div[2]/div/app-modificacion-autorizaciones/div[3]/div/button");
	protected By btnDetalleMercancia = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	
	protected By btnAutorizacionPendiente = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	protected By DetalleMercancia2 = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	protected By btnVisualizarAutorizacionPendiente = By.xpath("/*[@id='tbClientes']/tbody/tr[1]/td[5]/a");
	protected By chxConfirmarLiberacion = By.xpath("//*[@id='flexCheckCheckedSi']");
	protected By btnConfirmarLiberacion = By.xpath("//body/modal-container/div/div/app-detalleautorizacion/div/div[1]/button");
	protected By btnExpedirReal = By.xpath("/html/body/app-root/div/app-sidebar/nav/ul/li[4]/div/ul/li[1]/div/a");
	
	//Roles y seguridad
	protected By GridSeguridad = By.xpath("//*[@id='tbRoles']/tbody/tr"); 
	protected By txtBusquedaUsuario = By.xpath("//*[@id='terminoBusqueda']");
	protected By GridPerfil = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/div[3]/table/tbody/tr[5]");
	protected By btnModificarPerfil = By.xpath("//body/app-root/div/div/div/perfiles-perfiles/ng-component/div/div[3]/table/tbody/tr/td[4]/div/a[1]");
	protected By btnRolVisualizar = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/accordion/accordion-group/div/div[1]/div/div/button/div");
	protected By GridRol = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/accordion/accordion-group/div/div[2]/div/div[2]/div/table/tbody/tr");
	protected By GridRoles = By.xpath("//*[@id=\"tbRoles\"]/tbody/tr");
	protected By TituloModulo = By.xpath("//*[@id='sidebar']/ul/li[4]/div/a");
	protected By SeccionModuloExpedir = By.xpath("//*[@id='sidebar']/ul/li[4]/div/ul/li[1]/div/a");
	protected By GridDePerfiles= By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/div[3]/table/tbody/tr");
	
	
	
	//Reversar aplicaciones 
	
	protected By ValorTituloReversable = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[2]");
	protected By btnVisualizarReversion = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[5]/a");
	protected By btnVisualizarReversion2 = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[5]/a");
	protected By chxReversar = By.xpath("//*[@id='flexCheckChecked']");
	
	protected By btnReversar = By.xpath("//body/modal-container/div/div/app-detallereversionliberaciones/div/div[2]/div[2]/div/button");
	protected By GridTitulo = By.xpath("//*[@id='tbClientes']/tbody/tr");
	protected By btnAceptarReversion = By.xpath("//body/div[2]/div/div[3]/button[1]");
	
	protected By btnAcceptReversion = By.xpath("//body/div[2]/div/div[3]/button[1]");
	protected By BodegaOpcionTransito =  By.xpath("//*[@id='desde']");
	//
	
	protected By btnVerBonoPrenda = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	
	protected By RazonSocial = By.xpath("//*[@id='criterio']/option[2]");
	
	//Admin usuario 
	
	protected By GridUsuario = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[3]/table/tbody/tr");
	
	
	//*[@id="tbMercancia"]/thead/tr/th[(text()='Cantidad Liberar')]
	
	// CREAR
	protected By lblTitulo = By.xpath("//*[@id='sidebar']/ul/li/div/a[contains(text(),'Título')]");
	protected By lblExpedir = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[contains(text(),'Expedir')]");
	protected By btnCrearExpedir = By.xpath("//*[@id='contenido']/main-titulos/titulos-home/div/div/div/a");
	protected By txtNitRazonSocial = By.id("termino");
	protected By seleccionarNitRazon = By.xpath("//body/app-root/div/div/div/main-titulos/app-titulo/div/busqueda-cliente/form/div/ngb-typeahead-window/button[1]/ngb-highlight");
	
	protected By lblOpciones = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div/div/accordion/accordion-group/div/div/div/div/button[contains(text(),'{0}')]");
	protected By lblOpciones2 = By.xpath("//button[(text()='{0}')]");
	protected By DetalleMercancialbl = By.xpath("//body/app-root/div/div/div/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	
	
	protected By btnGuardarExpedir = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div/div/button[contains(text(),'Guardar')]");
	// Opciones de cliente - gestión
	protected By txtNitCliente = By.id("termino");
	protected By btnBuscarCliente = By.xpath("//*[@id='contenido']/app-main/clientes-home/div/form/button[(text() = ' Buscar ')]");
	protected By btnVerCliente = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/div[2]/a");
	protected By lblTipoBodegaCliente = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group/div/div/div/div/button[contains(text(),'Tipo de Bodega')]");
	
	// Información General del Título
	protected By lblOficinaResponsable = By.id("oficinaResponsableSelect");
	protected By lblTipoBodega = By.id("tipoBodega");
	protected By lblBodega = By.id("bodegaSelect");
	protected By lblBodegaOpcion = By.xpath("//*[@id='bodegaSelect']/option[2]");
	protected By lblTipoTitulo = By.id("tipoTituloSelect");
	protected By lblTipoTituloCertificado = By.xpath("//*[@id='tipoTituloSelect']/option[2]");
	protected By lblTipoTituloBono = By.xpath("//*[@id='tipoTituloSelect']/option[3]");
	protected By cbxMercanciaTransito = By.id("mercanciaTransito");
	protected By cbxBodegasAuxiliares = By.id("masBodegas");
	protected By FechaExpedicion = By.xpath("//body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[1]/div/div[2]/div/div/div[3]/input");
	protected By FechaVencimiento = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[3]/div/div[2]/div/div/table/tbody/tr/td[10]"); 	
	
	protected By AlertaCargue = By.xpath("//*[@id='toast-container']");
	
	
	
	// Detalle de la mercancia
	
	// Endoso del Certificado de Depósito - Bono de Prenda
	protected By btnCrearBono = By.xpath("//*[@id='contenido']//accordion-group[3]/div/div/div/div/div/a");
	protected By btnCrearCertificado = By.xpath("//*[@id='contenido']//accordion/accordion-group[4]/div/div/div/div/div/a");
	protected By lblNitNombreCertificado = By.id("tipo");
	protected By txtNitNombre = By.xpath("//body/modal-container/div/div/app-depositomencancia/div/app-fitro-acreedor/div/div/div/form/div[2]/input");
	protected By seleccionarNitNombre = By.xpath("//body/modal-container/div/div/app-depositomencancia/div/app-fitro-acreedor/div/div/div/form/div/ngb-typeahead-window/button");
	protected By lblTipoEndoso = By.id("tipointeres");
	protected By txtFechaEndoso = By.id("fendoso");
	protected By btnGuardarEndoso = By.xpath("//modal-container/div/div/app-depositomencancia/div/form/div/button[contains(text(),'Guardar')]");
	
	
	protected By FrameofGridClient = By.xpath("//*[@id='tbClientes']/tbody/tr/td[contains(text(),'{0}')]");
	
	
	protected By ClientStatus = By.xpath("//*[@id='tbClientes']/tbody/tr/td[8]");
	
	protected By CantInicial = By.xpath("//*[@id='tbMercancia']/thead/tr/th[3]");
	protected By CantInicialLiberacion = By.xpath("//*[@id='tbMercancia']/thead/tr/th[4]");
	
	
	protected By CantActual = By.xpath("//*[@id='tbMercancia']/thead/tr/th[4]");
	
	protected By CantActualLiberacion = By.xpath("//*[@id='tbMercancia']/thead/tr/th[5]");
	protected By CantaLiberar = By.xpath("//*[@id='tbMercancia']/thead/tr/th[7]");
	
	
	protected By txtNitNombreBono = By.xpath("//body/modal-container/div/div/app-bonoprenda/div/app-fitro-acreedor/div/div/div/form/div[2]/input");
	protected By seleccionarNitNombreBono = By.xpath("//body/modal-container/div/div/app-bonoprenda/div/app-fitro-acreedor/div/div/div/form/div/ngb-typeahead-window/button/ngb-highlight");
	protected By txtCapitalInicial = By.id("capital");
	protected By txtDiasPlazo = By.id("diasplazo");
	protected By txtTipoInteres = By.id("tipointeres");
	protected By txtValorInteres = By.id("valorinteres");
	protected By txtFrecuencia = By.id("frecuencia");
	protected By btnGuardarBono = By.xpath("//modal-container/div/div/app-bonoprenda/div/form/div/button[contains(text(),'Guardar')]");
	protected By btnAceptarBono = By.xpath("//div/div/div/button[contains(text(),'Aceptar')]");
	
	// Plazos
	protected By txtPlazoCertificado = By.id("plazoCertificadoDeposito");
	protected By txtPlazoContatro = By.id("plazoContratoDeposito");
	
	// Póliza
	protected By lblPoliza = By.id("polizaSelect");
	
	// Tipo de mercancía
	protected By lblTipoMercancia = By.id("tipoMercancia");
	protected By txtDescripcionGeneral = By.id("timeDescripcion");
	protected By txtMerma = By.id("merma");
	protected By lblAplicaCondicion = By.id("aplicaCondicionCalidad");
	protected By txtObservaciones = By.id("observaciones");
	
	// Mercancías
	protected By lblTipoCargue = By.id("tipoCargue");
	protected By btnCrearCargueIndividual = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div/div/accordion/accordion-group[8]/div/div/div/div/div/a");
	protected By txtDetalleMercancia = By.id("detalleMercancia");
	protected By lblUnidadMedida = By.id("unidadMedida");
	protected By lblUnidadMedidaSuper = By.id("unidadMedidaSuper");
	protected By txtValorConversion = By.name("valorConversion");
	protected By txtCantidad = By.id("cantidad");
	protected By txtValorUnitario = By.id("valorUnitario");
	protected By txtFechaVencimientoMercancia = By.xpath("//div/div/mercancia-titulos/div/form/div/div[8]/input");
	protected By txtObservacionMercancia = By.xpath("//div/div/mercancia-titulos/div/form/div/div[9]/input");
	protected By btnGuardarMercancia = By.xpath("//modal-container/div/div/mercancia-titulos/div/form/div/div/button[contains(text(),'Guardar')]");
	protected By btnAceptarMercancias = By.xpath("//div/div/div/button[contains(text(),'Aceptar')]");
	
	// Tarifas
	protected By txtTarifa = By.id("tarifa");
	protected By txtMinima = By.id("minima");
	
	// Buscar
	protected By txtBuscarTitulo = By.id("termino");
	protected By btnBuscarTitulo = By.xpath("//*[@id='contenido']/main-titulos/titulos-home/div/form/button[contains(text(),'Buscar')]");
	protected By btnImprimir = By.xpath("//*[@id='tbClientes']/tbody/tr/td[9]/div/a[3]");
	protected By lblImprimirOriginal = By.xpath("//modal-container/div/div/app-impresion-titulo/div/div/h5[contains(text(),'Imprimir Original')]");

	///html/body/div[3]/div/div[3]/button[(text()='Ok')]
	
	// Modificar
	protected By btnModificar = By.xpath("//*[@id='tbClientes']/tbody/tr/td[9]/div/a[1]");
	
	
	// Modificar
	protected By btnModificar2 = By.xpath("//*[@id='tbClientes']/tbody/tr[10]/td[9]/div/a[1]");
	
	//Universal de interaccion de titulos
	
	protected By btnInteraccionTitulos = By.xpath("//*[@id='tbClientes']/tbody/tr[{0}]/td[9]/div/a[contains(text(),'{0}')]");
	
	protected By btnInteraccionTitulos2 = By.xpath("//*[@id='tbClientes']/tbody/tr[(text()='{0}')]/td[9]/div/a[contains(text(),'{0}')]");
			
			
			
	protected By btnAceptarGuardarModificar = By.xpath("//div/div/div/button[contains(text(),'Aceptar')]");
	protected By lblGudadoExitoso = By.xpath("//div[@id='toast-container']/div/div[contains(text(),'El registro se ha guardado con estado')]");

	// Ver
	protected By btnVerExpedir = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td/div/a[2]");
	protected By txtNit = By.id("nit");
	protected By txtNombreRazon = By.id("razonSocial");
	protected By txtDireccion = By.id("direccionTitulo");
	protected By txtCiudad = By.id("ciudad");
	protected By txtTelefono = By.id("telefono");
	protected By txtCorreo = By.id("correo");
	protected By btnVisualizarUsuario = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[3]/table/tbody/tr/td[7]/div/div/a");
	protected By txtEmailUsuario = By.xpath("//*[@id='contenido']/app-main/usuarios-consultar/div/form/div[7]/div/input");
	
	
	protected By txtBuscar = By.xpath("//*[@id='termino']");
	
	protected By SeleccionarNitCrear = By.xpath("//*[@id='ngb-typeahead-0-0']");
	
	//ClienteCargueMasivo
	protected By btnModificarCliente = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/div[1]/a");
	protected By txtConsultarNit = By.xpath("//input[contains(@formcontrolname,'termino')]");
	protected By btnBuscar = By.xpath("//*[@id='contenido']/app-main/clientes-home/div/form/button[(text() = ' Buscar ')]");
	protected By btnTipoBodega = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[1]/div/div/button");
	protected By lblTobacco = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[12]/td[1]");
	protected By btnTitulo = By.xpath("//*[@id='sidebar']/ul/li[4]/div/a");
	protected By btnExpedir = By.xpath("//body/app-root/div/app-sidebar/nav/ul/li[4]/div/ul/li[1]/div/a");
	protected By txtNitCargue = By.xpath("//*[@id='termino']");
	protected By lblTipoDeDato = By.xpath("//*[@id='criterio']");
	protected By lblRegistro = By.xpath("//*[@id='tbClientes']/tbody/tr[10]/td[1]");
	protected By ModificarRegistro = By.xpath("//*[@id='tbClientes']/tbody/tr[9]/td[9]/div/a[1]");
	
	protected By lblModificarHistorico = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	protected By lblVisualizarTitulo = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[2]");
	protected By VisualizarMercanciasLZ = By.xpath("//*[@id='tbClientes']/tbody/tr");
	
	//*[@id="tbClientes"]/tbody/tr[9]/td[9]/div/a[1]
	
	
	protected By btnCancelar = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button[2]");
	protected By btnVisualizarImpresiones = By.xpath("//*[@id='tbClientes']/tbody/tr/td[9]/div/a[3]");
	protected By ImpresionA = By.xpath("//body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[3]/div[2]/div/button[1]");
	protected By ImpresionCDM = By.xpath("//body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[2]/div[2]/div/button[1]");
	protected By ImpresionBonoprenda = By.xpath("//body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[1]/div[2]/div/button[1]");
	
	//Scav
	protected By CampoSolicitud = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form[2]/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/table/thead/tr/th[1];");
	protected By btnScav = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/app-integracion-scav/accordion-group/div/div[1]/div/div/button");
	protected By txtFichaAprobacion = By.xpath("//*[@id='numRef']");
	
	protected By btnScav2 = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/app-integracion-scav/accordion-group/div/div[1]/div/div/button");
	
	protected By campoValidar = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[3]/table/thead/tr/th[1]");
	protected By ScavGridTitulo = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[3]/table/thead/tr"); 
	protected By btnSearch = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/button");
	
	protected By btnSearch2 = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-prorroga/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/button");
	
	protected By btnModificarcliente = By.xpath("//*[@id='tbClientes']/tbody/tr/td[9]/div/div[1]/a");
	protected By AlertaBusqueda = By.xpath("//*[@id='toast-container']");
	protected By ScavGridTituloValores = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[3]/table/tbody/tr");
	protected By txtBuscarTituloScav = By.xpath("//*[@id='titulo']");
	protected By btnSeleccionaTitulo = By.xpath("//*[@id='ngb-typeahead-0-0']");
	protected By EncabezadoFicha = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[1]/label");
	protected By GridScav = By.xpath("/html/body/app-root/div/div/div/app-main/app-formulario/div/form[2]/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/table/thead/tr");
	protected By btnSavingScav = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/div[2]/div/button[1]");
	
	protected By btnAceptarGuardar= By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	protected By GridScav2 = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[3]/table/thead/tr");
	
	protected By btnCancelarAlterno = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button[2]");
	
	protected By btnCancelarAlterno2 = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button");
	
	protected By BuscarTitulo = By.xpath("//body/app-root/div/div/div/main-titulos/titulos-home/div/form/div[2]/input");
	protected By ModificartituloLiberado = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	protected By VisualizarTitulo = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	
	
	
	protected By ModificarCancelado = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
	
	protected By VisualizarCancelado = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[2]");
	
	protected By btnCantidadInicial = By.xpath("//*[@id='tbMercancia']/thead/tr/th[3]");
	
	protected By ModificarAplicado = By.xpath("//*[@id='tbClientes']/tbody/tr[2]/td[9]/div/a[1]");
	protected By ModificarAnulado = By.xpath("//*[@id='tbClientes']/tbody/tr[8]/td[9]/div/a[1]");
	protected By btnCancelarEstado = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button");
	protected By txtBuscaTitulo = By.xpath("//*[@id='titulo']");
	protected By txtBusquedaTermino = By.xpath("//*[@id='termino']");
	protected By btnDescargar = By.xpath("//body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[3]/div/div[2]/button");
	
	//*[@id="contenido"]/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[3]/div/div[2]/button
	
	protected By btnCargue = By.xpath("//input[contains(@id,'fileCsv')]");
	protected By btnCargue1 = By.xpath("//*[@class='label']");
	
	protected By btnTableofdates = By.xpath("//input[@type='date']");
	
	protected By BuscarCliente= By.xpath("//*[@id='termino']");
	
	
	protected By btnObservarTitulo = By.xpath("//*[@id='tbMercancia']/tbody/tr/td[10]/a");
	protected By btnCancelarvista = By.xpath("//body/modal-container/div/div/app-consulta-liberacion-mercancia/div/div[2]/div[2]/button");
	protected By CheckBox= By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[9]/input");
	
	//input[contains(@name,'fileCsv')
	
	protected By btnupload = By.xpath("//*[@id='fileCsv']");
	protected By Cargue = By.id("//*[@id='fileCsv']");
	protected By lblCodigoLiberacion = By.xpath("//app-filtrotitulo/form/div/div/ngb-typeahead-window/button");
	protected By btnBusquedaTitulo = By.xpath("//button[(text()=' Buscar ')]");
	protected By lblCamposDetalleMercancia = By.xpath("//th[(text()='{0}')]");
	
	protected By value1 = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[5]/td[(text() ='{0}')]");
	
	protected By FilaElemento = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[5]/td[(text() ='{0}')]");
	
	protected By FilaElemento2 = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[5]/td[contains(text(),'')]");
	
	protected By JdaValor = By.xpath("//*[@id='contenido']/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[2]/div/div[2]/div[2]/table/tbody/tr[5]/td[5]");
	protected By lblBusquedaProrroga = By.xpath("//form/div/div/ngb-typeahead-window/button");
	protected By lblsecciones = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[(text()='{0}')]");
	
	
	protected By lblModulos = By.xpath("//*[@id='sidebar']/ul/li/div/a[contains(text(),'{0}')]");
	
	protected By SearchUsuary = By.xpath("//*[@id='nombre']");
	protected By SearchRole = By.xpath("//*[@id='termino']");
	
	//Expedir y editar mercancia
	protected By txtCodigoTitulo = By.id("titulo");
	protected By btnDone = By.xpath("//button[(text()=' Ok ')]");
	protected By cbxAccion = By.id("flexCheckChecked");
	protected By btnVistaLiberado = By.xpath("//*[@id='tbMercancia']/tbody/tr/td[10]/a");
	protected By lblVistaSinLiberacion = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[9]/td[11]/a");
	protected By lblVisualizarHistorico = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[11]/a");
	protected By btnClose = By.xpath("//body/modal-container/div/div/app-consulta-liberacion-mercancia/div/div[2]/div[2]/button");
	protected By btnCloseMercaciaEdicion = By.xpath("//body/modal-container/div/div/mercancia-titulos/div/form/div[2]/div/button[2]");
	protected By ModificarMercancia = By.xpath("//*[@id='tbMercancia']/tbody/tr/td[9]/a[1]");
	
	
	protected By BusquedaProrroga = By.xpath("//*[@id='titulo']");
	
	protected By btnCalendar = By.xpath("//body/modal-container/div/div/mercancia-titulos/div/form/div[1]/div[8]/input");
	protected By btnGuardarCambios = By.xpath("//body/modal-container/div/div/mercancia-titulos/div/form/div[2]/div/button[1]");
	protected By btnSeguroCambiar = By.xpath("//body/div[2]/div/div[3]/button[1]");
	protected By btnOkay = By.xpath("//body/div[2]/div/div[3]/button[1]");
	
	protected By NumberProrrogaValida = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]");
	protected By HeaderProrrogar = By.xpath("//*[@id='plazoCertificado']");
	protected By lblBonoPrenda = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	protected By lblPaginacion = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/accordion/accordion-group[3]/div/div[2]/div/div[2]/div[2]/div/div/ngb-pagination/ul/li[3]/a");
	protected By txtplazoDeposito = By.id("plazoDeposito");
	protected By txtplazoCredito = By.id("plazoCredito");
	protected By txtplazoCertificado = By.id("plazoCertificado");
	
	//Botones generales
	protected By btnGuardar = By.xpath("//*[@id='contenido']/main-titulos/app-prorroga/div/div[2]/div/button[1]");
	protected By btnAceptar = By.xpath("//body/div[3]/div/div[3]/button[1]");
	protected By btnSafe = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button[1]");
	protected By btnAplicar = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[2]/div/button[2]");
	
	protected By btnAceptarCambios = By.xpath("//body/div[2]/div/div[3]/button[1]");
	
	protected By Plazos = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[4]/div/div[1]/div/div/button");
	protected By Poliza = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[5]/div/div[1]/div/div/button");
	protected By TipoMercancia = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[6]/div/div[1]/div/div/button");
	protected By Mercancia = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[1]/div/div/button");
	protected By Tarifa = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[8]/div/div[1]/div/div/button");
	protected By DivisionIngreso = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[9]/div/div[1]/div/div/button");
	protected By btnVisualizarRolesExistentes = By.xpath("//*[@id='tbRoles']/tbody/tr/td[4]/div/a[1]");
	protected By btnCriterioTitulo = By.xpath("//*[@id='criterio']");
	protected By btnRefreshTitulosPorfecha = By.xpath("//*[@id='tbClientes']/thead/tr/th[1]/i");
	protected By UltimoRegistroCreado = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[1]");
	protected By PaginacionNueva = By.xpath("//*[@id='contenido']/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[9]/a");
	
	
	//body/div[3]/div/div[3]/button[1]
	
	//protected By Cargue = By.xpath("//input[contains(@name,'fileCsv')]");
	
	
	//creacion de formulario Expedir 

	protected By lblOficinaResponsable1 = By.xpath("//*[@id='oficinaResponsableSelect']"); 

	protected By lblOficinaResponsable2 = By.xpath("//*[@id='oficinaResponsableSelect']/option[3]"); 

	protected By lblTipoBodega1 = By.xpath("//*[@id='tipoBodega']"); 

	protected By lblTipoBodega2 = By.xpath("//*[@id='tipoBodega']/option[4]"); 

	protected By lblBodega1 = By.xpath("//*[@id='bodegaSelect']"); 

	protected By lblBodega2 = By.xpath("//*[@id='bodegaSelect']/option[2]"); 

	protected By lblTipoTitulo1 = By.xpath("//*[@id='tipoTituloSelect']"); 

	protected By lblTipoTitulo2 = By.xpath("//*[@id='tipoTituloSelect']/option[2]"); 

	protected By lblTipoOperacion1 = By.xpath("//*[@id='tipoOperacion']"); 

	protected By lblTipoOperacion2 = By.xpath("//*[@id='tipoOperacion']/option[2]"); 

	protected By lblDivisionIngreso1 = By.xpath("//*[@id='divisionIngreso']"); 

	protected By lblDivisionIngreso2 = By.xpath("//*[@id='divisionIngreso']/option[1]"); 

	protected By lblDivisionIngreso3 = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[1]/div/div[2]/div/div/div[12]/select/option[2]"); 

	protected By btnInformacionGeneralTitulo = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[1]/div/div[1]/div/div/button"); 

	protected By btnPlazo = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[4]/div/div[1]/div/div/button"); 

	protected By txtPlazoCertificadoDias = By.xpath("//*[@id='plazoCertificadoDeposito']"); 

	protected By txtPlazoContratoDias = By.xpath("//*[@id='plazoContratoDeposito']"); 
	
	protected By txtNumeroTitulo = By.xpath("//*[@id='tituloDisabled']"); 
	
	protected By btnNit2 = By.xpath("//*[@id='criterio']"); 

	protected By btnNit = By.xpath("//*[@id='criterio']/option[2]"); 
	
	protected By btnSelecClaro = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/busqueda-cliente/form/div[2]/ngb-typeahead-window/button/ngb-highlight"); 
	protected By btnPoliza = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[5]/div/div[1]/div/div/button"); 

	protected By btnPoliza1 = By.xpath("//*[@id='polizaSelect']"); 

	protected By btnPoliza2 = By.xpath("//*[@id='polizaSelect']/option[3]"); 
	protected By btnTipoMercancia = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[6]/div/div[1]/div/div/button"); 

	protected By btnTipoMercancia1 = By.xpath("//*[@id='tipoMercancia']"); 

	protected By btnTipoMercancia2 = By.xpath("//*[@id='tipoMercancia']/option[5]"); 

	protected By txtDescripcionMercancia = By.xpath("//*[@id='timeDescripcion']"); 

	protected By txtmerma = By.xpath("//*[@id='merma']"); 

	protected By btnAplicadaCalidad1 = By.xpath("//*[@id='aplicaCondicionCalidad']"); 

	protected By btnAplicadaCalidad2 = By.xpath("//*[@id='aplicaCondicionCalidad']/option[1]"); 

	protected By btnMercanciaDesignada1 = By.xpath("//*[@id='mercanciaGenericaDesignada']"); 

	protected By btnMercanciaDesignada2 = By.xpath("//*[@id='mercanciaGenericaDesignada']/option[1]"); 

	protected By txtObservaciones1 = By.xpath("//*[@id='observaciones']"); 
	protected By btnMercancias = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[1]/div/div/button"); 

	protected By btnTipoCargue1 = By.xpath("//*[@id='tipoCargue']"); 

	protected By btnTipoCargue2 = By.xpath("//*[@id='tipoCargue']/option[3]"); 

	protected By btnCrearMercancia = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div"); 

	protected By txtDetalleMercancia1 = By.xpath("//*[@id='detalleMercancia']"); 

	protected By btnTarifas = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[8]/div/div[1]/div/div/button"); 

	protected By btnMaterialSap = By.xpath("//*[@id='materialERPSelect']"); 

	protected By btnMaterialSap2 = By.xpath("//*[@id='materialERPSelect']/option[2]"); 
	protected By btnDivisionIngreso = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[9]/div/div[1]/div/div/button"); 

	protected By btnPorcentajeEx = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[9]/div/div[2]/div/div/div[3]/input"); 

	protected By btnPorcentajeAlm = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[9]/div/div[2]/div/div/div[4]/input"); 

	//Liberaciones
	
	protected By btnScavLiberaciones= By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/app-integracion-scav/accordion-group/div/div[1]/div/div/button");
	protected By EncabezadoFichaScavLiberaciones = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[1]/label"); 
	protected By btnBuscarScavLiberaciones= By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[2]/button");
	protected By GridLiberacionesScav = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/app-integracion-scav/accordion-group/div/div[2]/div/div[2]/div[3]/table/thead/tr");
	
	
	

	protected By btnCodigoSapExp = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[9]/div/div[2]/div/div/div[5]/textarea"); 

	protected By btnCodigoSapAlm = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[9]/div/div[2]/div/div/div[6]/textarea"); 

	// cara B
	protected By ImpresionBonoprendaB = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[1]/div[2]/div/button[2]");
	protected By ImpresionCDMB = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[2]/div[2]/div/button[2]");
	protected By ImpresionB = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[2]/div[3]/div[2]/div/button[2]");

	protected By txtOficinaExpedicion = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[9]/div/div[2]/div/div/div[1]/label");
	protected By txtOficinaAlmacenamiento = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[9]/div/div[2]/div/div/div[2]/label");
	
	protected By txtCodigoSapExp = By.xpath("//*[@id='codigoSapExpedicion']");
	
	protected By btnIngreso = By.xpath("//*[@id='divisionIngreso']");

	
	// HU16
	
		//protected By txtNitRazonSocial = By.id("termino");

		
		protected By FrameofGridClient1 = By.xpath("//*[@id='tbClientes']/tbody/tr");
		protected By FrameofGridList = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/thead/tr");
		protected By FrameofGridList1 = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[4]");
		protected By FrameofGridExcel = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table");

		//protected By lblModificarHistorico = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[9]/div/a[1]");
		
		
		protected By btnSelectFiltro = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[2]/div/div/select");
		protected By btnFiltro = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[2]/div/div/select/option[4]");
		protected By btnFiltro2 = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[2]/div/div/select");
		//protected By FrameofGridClient1 = By.xpath("//*[@id='tbClientes']/tbody/tr");

		


	// hu16
		
		protected By btnActualizarLpm = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[3]/div/div/button");
		protected By btnActualizarCantidades = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
		protected By lblProductos = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[8]/td[1]");
		protected By lblCJ = By.xpath("//*[@id='contenido']/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[8]/td[7]");
		protected By lblCantidadSaldo = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[1]/div/accordion/accordion-group[7]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[8]/td[6]/input");

	
	
}