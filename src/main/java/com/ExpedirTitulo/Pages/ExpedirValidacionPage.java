package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirValidacionPage extends BasePage {

	By lblRolPerfil = By.id("dropdown04");
	By lblEtiquetaCrearTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[2]/div/a");
	By lblExpedirTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/div[1]/div/h5/span[1]");
	By lblBuscarDepositante = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/div[2]/div/h6");
	By lblNitCrear = By.id("nitDisabled");
	By lblNombreRazonSocialCrear = By.id("razonSocial");
	By lblNitNombreRazonSocialCrearNoExiste = By.id("termino");
	By lblNitNombreRazonSocialTercerCaracter = By.id("termino");
	By lblNitObligatorioNoEditable = By.id("nitDisabled");
	By lblNombreRazonSocialObligatorioNoEditable = By.id("razonSocial");
	By lblDireccionObligatorioNoEditable = By.id("direccionTitulo");
	By lblCiudadObligatorioNoEditable = By.id("ciudad");
	By lblCorreoObligatorioNoEditable = By.id("correo");
	By lblInformacionGeneralDeTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[1]/div/div[1]/div/div/button");
	By lblNumeroDeTitulo = By.id("tituloDisabled");
	By lblCodigoTitulo = By.id("numeroDeTitulo");
	By lblFechaExpedicion = By.id("fechaExpedicion");
	By lblOficinaExpedicion = By.id("oficinaExpedicion");
	By lblOficinaResponsableDeAlmacenamiento = By.id("oficinaResponsableSelect");
	By lblTipoBodegaObligatorio = By.id("tipoBodega");
	By lblBodega = By.id("bodegaSelect");
	By lblDireccionTitulo = By.id("bodeDireccion");
	By lblCiudadTitulo = By.id("bodeCiudad");
	By lblMercanciaTransito = By.id("mercanciaTransito");
	By lblDesdeObligatorio = By.xpath("//*[@id=\"desde\"]");
	By lblHastaObligatorio = By.xpath("//*[@id=\"desde\"]");
	By lblTipoTituloCertificado = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblTipoTitulBono = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblVerCertificado = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblVerBono = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblBuscarAcreedorEndosatario = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/div/h4");
	By lblNitNombreRazonSocialBono = By.id("termino");
	By lblNitBono = By.id("termino");
	By lblNombreRazonSocialBono = By.id("termino");
	By lblAcreedorEndosatarioNoExiste = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/app-fitro-acreedor/div/div/div/form/div[2]/div");
	By lblNitBonoCrear = By.id("clieNitDisabled");
	By lblNombreRazonSocialBonoCrear = By.id("clieRazonSocialDisabled");
	By lblDireccionBonoCrear = By.id("clieDireccionDisabled");
	By lblCiudadBonoCrear = By.id("clieCiudadDisabled");
	By lblCorreoBonoCrear = By.id("clieCorreoDisabled");
	By lblFechaVencimientoBonoCrear = By.id("fvencimiento");
	By lblCapitalInicialCredito100 = By.id("capital");
	By lblCapitalInicialCreditoObligatorio = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/form/div[1]/div[6]/div");
	By lblDiasPlazoObligatorio = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/form/div[1]/div[7]/div");
	By lblDiasPlazo = By.id("diasplazo");
	By lblAlertaPlazos = By.xpath("//*[@id=\"swal2-title\"]");
	By lblTipoInteresAlfanumerico = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/table/tbody/tr/td[8]");
	By lblValorInteresObligatorio = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/form/div[1]/div[11]/div");
	By lblFrecuenciaObligatorio = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/form/div[1]/div[12]/div");
	By lblEstaSeguroGuardarBono = By.xpath("//*[@id=\"swal2-title\"]");
	By lblvalidarBonoGuardado = By.cssSelector(".toast-message");
	By lblBonoEtiquetaCrear = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[1]/div/a");
	By lblBonoCancelar = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	By lblEtiquetaCertificado = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[1]/div/a");
	By lblNitNombreRazonSocialCertificado = By.id("termino");
	By lblNitNombreRazonSocialCertificado50 = By.id("termino");
	By lblNitCertificado = By.id("termino");
	By lblNombreRazonSocialCertificado = By.id("termino");
	By lblNitNombreRazonSocialCertificadoNoExiste = By.xpath("/html/body/modal-container/div/div/app-depositomencancia/div/app-fitro-acreedor/div/div/div/form/div[2]/div");
	By lblNitCertificadoNoEditable = By.id("nit");
	By lblNombreRazonSocialCertificadoNoEditable = By.id("nombre");
	By lblDireccionCertificadoNoEditable = By.id("direccionTitulo");
	By lblCiudadCertificadoNoEditable = By.id("cuidad");
	By lblCorreoCertificadoNoEditable = By.id("correo");
	By lblFechaMayor = By.id("fendoso");
	By lblEliminarCertificado = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/table/tbody/tr/td[9]/button");
	By lblEstaSeguroGuardarRegistro = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[1]/div");
	By lblBotonAceptar = By.xpath("");
	By lblBotonCancelar = By.xpath("");
	By lblTituloOpcionCancelar = By.xpath("/html/body/modal-container/div/div/app-depositomencancia/div/div/h4");
	By lblMensajeFaltanDatos = By.xpath("");
	By lblFaltanDatosEntradaBono = By.xpath("//*[@id=\"swal2-title\"]");
	By lblGrillaPlazos = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblPlazoContratoDepositoOobligatorio = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div/div[2]/div");
	By lblPlazoContratoDeposito = By.id("plazoContratoDeposito");
	By lblFechaVencimientoPlazoContratoDeposito = By.id("fechaVencimientoContrato");
	By lblPlazoCertificadoDeposito3 = By.id("plazoCertificadoDeposito");
	By lblFechaVencimientoPlazoCertificadoDeposito = By.id("fechaVencimientoCertificado");
	By lblNumPolizaNoEditable = By.id("numeroPoliza");
	By lblAseguradoraNoEditable = By.id("aseguradora");
	By lblCampoValorAsegurado = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[3]/div/div[2]/div/div/div[6]/label");
	By lblListaTipoDeMercancia = By.id("tipoMercancia");
	By lblCodigoObligatorio = By.id("mediDlx1");
	By lblDescripcionMercanciaObligatorioAlfanumerico = By.id("timeDescripcion");
	By lblMermaNumericoEditable = By.id("merma");
	By lblMerma3 = By.id("merma");
	By lblAplicaCondicionDeCalidadOblogatorioSINO = By.id("aplicaCondicionCalidad");
	By lblObservacionesObligatorioAlfanumerico = By.id("observaciones");
	By lblLongitud1056 = By.id("observaciones");
	By lblGrillaPlazos1 = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	By lblGrillaPoliza = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[4]/div/div[1]/div/div/button");
	By lblGrillaTipoMercancia = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[5]/div/div[1]/div/div/button");
	By lblGrillaMercancias = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[1]/div/div/button");
	By lblGrillaTarifas = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[7]/div/div[1]/div/div/button");
	By lblAgregarNuevaMercancia = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/div/h4");
	By lblDetalleMercanciaObligatorio = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/form/div[1]/div[1]/div");
	By lblDetalleMercanciaLongitud200 = By.xpath("//*[@id=\"tbMercancia\"]/tbody/tr/td[1]");
	By lblUnidadMedidaObligatorio = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/form/div[1]/div[2]/div");
	By lblUnidadMedidaSuperObligatorio = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/form/div[1]/div[3]/div");
	By lblLogitud6ValorConversion = By.id("valorConversion");
	By lblCantidadObligatorio = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/form/div[1]/div[5]/div");
	By lblCantidadNumerico = By.id("cantidad");
	By lblValorUnitario = By.id("valorUnitario");
	By lblTotal = By.id("valorTotalDisabled");
	By lblFechaVencimiento = By.id("fechaVencimiento");
	By lblFecha = By.id("fechaVencimiento");
	By lblObservacion = By.id("observaciones");
	By lblMercanciaLongitud256 = By.xpath("//*[@id=\"tbMercancia\"]/tbody/tr/td[7]");
	By lblFila20 = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[2]/div/div[3]/div[2]/div/div/select");
	By lblvalidarMensajeGuardar = By.xpath("//*[@id=\"swal2-title\"]");
	By lblMercancia = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[1]/div/div/button");
	By lblMercanciaModificarBotonCancelar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[1]/div/div/button");
	By lblMercanciaModificarBotonCancelarOpcion2 = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/div/h4");
	

	By lblDetalleMercanciaMasivo = By.xpath("//*[@id=\"tbMercancia\"]/thead/tr/th[1]");
	By lblUnidadMedidaMasivo = By.xpath("//*[@id=\"tbMercancia\"]/thead/tr/th[2]");
	By lblCantidadMasivo = By.xpath("//*[@id=\"tbMercancia\"]/thead/tr/th[3]");
	By lblValorUnitarioMasivo = By.xpath("//*[@id=\"tbMercancia\"]/thead/tr/th[4]");
	By lblValorTotalMasivo = By.xpath("//*[@id=\"tbMercancia\"]/thead/tr/th[5]");
	By lblFechaVencimientoMasivo = By.xpath("//*[@id=\"tbMercancia\"]/thead/tr/th[6]");
	By lblObservacionMercanciaMasivo = By.xpath("//*[@id=\"tbMercancia\"]/thead/tr/th[7]");
	By lblAccionMasivo = By.xpath("//*[@id=\"tbMercancia\"]/thead/tr/th[8]");
	By lblIndividualCrear = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/div/h4");
	By lblCargueMasivo = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[2]/div/div[2]/div[3]/label");
	By lblAccionEliminarCargueMasivo = By.xpath("//*[@id=\"tbMercancia\"]/tbody/tr/td[8]/button");
	By lblTarifa = By.id("tarifa");
	By lblMinima = By.id("minima");
	By lblBotonAgregarMercancia = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[2]/div/div[2]/div/a");
	By lblRegistroIncompleto = By.cssSelector(".toast-message");
	By lblValidarBotonGuardarEstaSeguro = By.xpath("//*[@id=\"swal2-title\"]");
	By lblValidarBotonCancelar = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[1]/div/h5");
	By lblValidarBotonCancelarOpcion2 = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button[1]");
	By lblValidarTextoModificar = By.id("termino");
	By lblConsultaTercerCaracter = By.id("termino");
	By lblNitConsultarCaracteres50 = By.id("termino");
	By lblNitConsultar = By.id("termino");
	By lblNombreRazonSocialConsultar = By.id("termino");
	By lblConsultaTitulo = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[1]");
	By lblConsultaFecha = By.id("tituloDisabled");
	By lblTituloConsultar = By.id("termino");
	By lblFechaConsultar = By.id("termino");
	By lblFechaConsulta = By.id("termino");
	By lblNumeroTitulo = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[1]");
	By lblNIT = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[2]");
	By lblNombreRazonSocial = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[3]");
	By lblTipoBodega = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[4]");
	By lblTipoTitulo = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[5]");
	By lblTipoMercancia = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[6]");
	By lblValorMercancia = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[7]");
	By lblEstado = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[8]");
	By lblAccion = By.xpath("//*[@id=\"tbClientes\"]/thead/tr/th[9]");
	By lblNoExistenRegistros = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/form/div[2]/div");
	By lblVisualizarTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/div/div/h5/span[1]");
	By lblTipoBodegaModificar = By.id("tipoBodega");
	By lblBodegaModificar = By.id("bodegaSelect");
	By lblTipoTituloModificar = By.id("tipoTituloSelect");
	By lblDesdeModificar = By.id("desde");
	By lblHastaModificar = By.id("hasta");
	By lblNumeroTituloModificar = By.id("tituloDisabled");
	By lblCodigoTituloModificar = By.id("numeroDeTitulo");
	By lblFechaExpedicionModificar = By.id("fechaExpedicion");
	By lblOficinaExpedicionModificar = By.id("oficinaExpedicion");
	By lblOficinaResponsableModificar = By.id("oficinaResponsableSelect");
	By lblCudadModificar = By.id("bodeCiudad");
	By lblCapitalInicialModificar = By.id("capital");
	By lblDiasPlazoModificar = By.id("diasplazo");
	By lblTipoInteresModificarBono = By.id("tipointeres");
	By lblFrecuenciaModificar = By.id("frecuencia");
	By lblNitModificarBono = By.id("clieNitDisabled");
	By lblNombreRazonSocialModificarBono = By.id("clieRazonSocialDisabled");
	By lblDireccionModificarBono = By.id("clieDireccionDisabled");
	By lblCiudadModificarBono = By.id("clieCiudadDisabled");
	By lblCorreoModidicarBono = By.id("clieCorreoDisabled");
	By lblFechaVencimientoModificarBono = By.id("fvencimiento");
	By lblTipoInteresModificar = By.id("tipointeres");
	By lblFechaEndosoModificar = By.id("fendoso");
	By lblNitModificar = By.id("nit");
	By lblNombreRazonSocialModificar = By.id("nombre");
	By lblDireccionModificar = By.id("direccionTitulo");
	By lblCiudadModificar = By.id("cuidad");
	By lblCorreoModificar = By.id("correo");
	By lblNumeroPolizaModificar = By.id("numeroPoliza");
	By lblAseguradoraModificar = By.id("aseguradora");
	By lblFechaExpedicionPolizaModificar = By.id("fechaExpedicionPlazo");
	By lblFechaVencimientoPolizaModificar = By.id("fechaVencimiento");
	By lblValorAseguradoPolizaModificar = By.id("valorPolizaVencimiento");
	By lblDetalleMercanciaModificar = By.id("detalleMercancia");
	By lblUnidadMedidaModificar = By.id("unidadMedida");
	By lblUnidadMedidaSuperModificar = By.id("unidadMedidaSuper");
	By lblCantidadModificar = By.id("cantidad");
	By lblValorUnitarioModificar = By.id("valorUnitario");
	By lblFechaVencimientoMercanciaModificar = By.id("fechaVencimiento");
	By lblObservacionesModificar = By.id("observaciones");
	By lblImprimirBorrador = By.xpath("/html/body/modal-container/div/div/app-impresion-titulo/div/div[1]/h5");
	By lblModificarNit = By.id("nitDisabled");
	By lblModificarNombreRazonSocial = By.id("razonSocial");
	By lblModificarDireccion = By.id("direccionTitulo");
	By lblModificarCiudad = By.id("ciudad");
	By lblModificarTelefono = By.id("telefono");
	By lblModificarCorreo = By.id("correo");
	By lblValidarBotonAplicar = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[3]/div/button[2]");
	By lblNitModificacion = By.id("nitDisabled");
	By lblNombreRazonSocialModificacion = By.id("razonSocial");
	By lblDireccionModificacion = By.id("direccionTitulo");
	By lblCiudadModificacion = By.id("ciudad");
	By lblTelefonoModificacion = By.id("telefono");
	By lblCorreoModificacion = By.id("correo");
	By lblDesdeModificacion = By.id("desde");
	By lblHastaModificacion = By.id("hasta");
	By lblVerBonoPrendaModificar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblVerCertificadoDepositoModificar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblTarifasModificar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[7]/div/div[1]/div/div/button");
	By lblMayusculasMinusculasCrear = By.name("termino");
	By lblFaltanDatosEntrada = By.xpath("//*[@id=\"swal2-title\"]");

	
	public ExpedirValidacionPage(WebDriver driver) {
		super(driver);
	}

	@Step("Validar que la opción titulos/ Expedir titulo solo se muestre al usuario con el rol y perfil que tenga los permisos")
	public ExpedirValidacionPage ValidarCaso1(String validarResultadoRolPerfil) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblRolPerfil).getText(), validarResultadoRolPerfil);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar función de la opcion \"Expedir Titulo\"")
	public ExpedirValidacionPage ValidarCaso2() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblEtiquetaCrearTitulo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar que el formulario muestre el encabezado \"Expedir título\"")
	public ExpedirValidacionPage ValidarCaso3(String validarResultadoExpedirTitulo) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblExpedirTitulo).getText(), validarResultadoExpedirTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar que en formulario muestre nombre de campo \"Buscar Depositante\"")
	public ExpedirValidacionPage ValidarCaso4(String validarResultadoBuscarDepositante) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblBuscarDepositante).getText(), validarResultadoBuscarDepositante);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo filtro de busqueda por \"Nit\"")
	public ExpedirValidacionPage ValidarCaso5() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitCrear).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo filtro de busqueda por \"Nombre/Razón Social\"")
	public ExpedirValidacionPage ValidarCaso6() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNombreRazonSocialCrear).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo consulta de registros no existentes")
	public ExpedirValidacionPage ValidarCaso7() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitNombreRazonSocialCrearNoExiste).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo la consulta inicie apartir del tercer caracter")
	public ExpedirValidacionPage ValidarCaso8() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitNombreRazonSocialTercerCaracter).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo campo \"NIT\" sea traído automaticamente, obligatorio, textbox y no editable")
	public ExpedirValidacionPage ValidarCaso9() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitObligatorioNoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo campo \"Nombre/Razon Social\" sea traido automaticamente, obligatorio, textbox y no editable")
	public ExpedirValidacionPage ValidarCaso10() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNombreRazonSocialObligatorioNoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo campo \"Dirección\"sea traido automaticamente, obligatorio, textbox y no editable")
	public ExpedirValidacionPage ValidarCaso11() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDireccionObligatorioNoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir titulo campo \"Ciudad\"sea traido automaticamente, obligatorio, textbox y no editable")
	public ExpedirValidacionPage ValidarCaso12() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCiudadObligatorioNoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo campo \"Correo\"sea traido automaticamente, obligatorio, textbox y no editable")
	public ExpedirValidacionPage ValidarCaso13() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCorreoObligatorioNoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo la consulta inicie apartir del tercer caracter")
	public ExpedirValidacionPage ValidarCaso14(String validarResultadoInformacionGeneralDeTitulo) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblInformacionGeneralDeTitulo).getText(),
				validarResultadoInformacionGeneralDeTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo la grilla Información general del título el campo \"Número de título\"")
	public ExpedirValidacionPage ValidarCaso15() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumeroDeTitulo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo la grilla Información general del título el campo \"Código de título\" ")
	public ExpedirValidacionPage ValidarCaso16() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCodigoTitulo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo la grilla Información general del título el campo \"Código de título\" (C)")
	public ExpedirValidacionPage ValidarCaso17() {

		Utilidades.waitInMs(3000);
		// Assert.assertEquals(getElement(lblCodigoTituloC).isDisplayed(), true);
		// Assert.assertEquals("C187",driver.findElement(By.id("numeroDeTitulo")).getText());
		Assert.assertNull(null);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo la grilla Información general del título el campo \"Código de título\" (B)")
	public ExpedirValidacionPage ValidarCaso18() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumeroDeTitulo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo la grilla Información general del título el campo \"Fecha Expedición\"")
	public ExpedirValidacionPage ValidarCaso19() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblFechaExpedicion).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Oficina Expedición\" ")
	public ExpedirValidacionPage ValidarCaso20() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblOficinaExpedicion).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Oficina responsable de almacenamiento\"")
	public ExpedirValidacionPage ValidarCaso21() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblOficinaResponsableDeAlmacenamiento).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo len grilla Información general del título el campo \"Tipo de Bodega\"")
	public ExpedirValidacionPage ValidarCaso22() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTipoBodegaObligatorio).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Bodega\"")
	public ExpedirValidacionPage ValidarCaso23() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblBodega).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir titulo en grilla Información general del título el campo \"Dirección\"")
	public ExpedirValidacionPage ValidarCaso24() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDireccionTitulo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Ciudad\"")
	public ExpedirValidacionPage ValidarCaso25() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCiudadTitulo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Mercancía en Tránsito\"")
	public ExpedirValidacionPage ValidarCaso26() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblMercanciaTransito).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Desde (Origen)\"")
	public ExpedirValidacionPage ValidarCaso27(String resultadoObligatorioDesde) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDesdeObligatorio).getText(), resultadoObligatorioDesde);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Hasta (Destino)\"")
	public ExpedirValidacionPage ValidarCaso28(String resultadoObligatorioHasta) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblHastaObligatorio).getText(), resultadoObligatorioHasta);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Tipo de título\"")
	public ExpedirValidacionPage ValidarCaso29(String resultadoTipoTituloCertificado) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTipoTituloCertificado).getText(), resultadoTipoTituloCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Tipo de título\"")
	public ExpedirValidacionPage ValidarCaso029(String resultadoTipoTituloBono) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTipoTitulBono).getText(), resultadoTipoTituloBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir titulo en grilla Información general del título el campo \"Tipo de título\" Certificado de Depósito de Mercancía")
	public ExpedirValidacionPage ValidarCaso30(String resultadoVerCertificado) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblVerCertificado).getText(), resultadoVerCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir Titulo en grilla Información general del título el campo \"Tipo de título\"  Bono de Prenda")
	public ExpedirValidacionPage ValidarCaso31(String resultadoVerBono) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblVerBono).getText(), resultadoVerBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir titulo grilla \"Ver Bono de Prenda\" campo \"Buscar Acreedor/Endosatario\"")
	public ExpedirValidacionPage ValidarCaso32(String resultadoBuscarAcreedorEndosatario) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblBuscarAcreedorEndosatario).getText(), resultadoBuscarAcreedorEndosatario);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Expedir titulo grilla \"Ver Bono de Prenda\" campo \"Buscar Acreedor/Endosatario\"la logintud sea de 50 caracteres")
	public ExpedirValidacionPage ValidarCaso33() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitNombreRazonSocialBono).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en \"Ver Bono de Prenda\" en el campo Buscar Acreedor/Endosatario busqueda por \"Nit\"")
	public ExpedirValidacionPage ValidarCaso34() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitBono).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en Ver Bono de Prenda en el campo Buscar Acreedor/Endosatario busqueda por \"Nombre/Razón Social\"")
	public ExpedirValidacionPage ValidarCaso35() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNombreRazonSocialBono).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en \"Ver Bono de Prenda\" en el campo Buscar Acreedor/Endosatario consulta de registros no existentes")
	public ExpedirValidacionPage ValidarCaso36(String resultadoNitNombreRazonSocialNoExiste) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblAcreedorEndosatarioNoExiste).getText(), resultadoNitNombreRazonSocialNoExiste);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" resultado de consunlta los campos NIT, Nombre/Razón social, Dirección (Domicilio), Ciudad, Correo y fecha de vencimiento, No Editables")
	public ExpedirValidacionPage ValidarCaso37() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitBonoCrear).isDisplayed(), true);
		Utilidades.waitInMs(500);
		Assert.assertEquals(getElement(lblNombreRazonSocialBonoCrear).isDisplayed(), true);
		Utilidades.waitInMs(500);
		Assert.assertEquals(getElement(lblDireccionBonoCrear).isDisplayed(), true);
		Utilidades.waitInMs(500);
		Assert.assertEquals(getElement(lblCiudadBonoCrear).isDisplayed(), true);
		Utilidades.waitInMs(500);
		Assert.assertEquals(getElement(lblCorreoBonoCrear).isDisplayed(), true);
		Utilidades.waitInMs(500);
		Assert.assertEquals(getElement(lblFechaVencimientoBonoCrear).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" resultado de consulta el campo \"Capital inicial crédito\" longitud 100")
	public ExpedirValidacionPage ValidarCaso38() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCapitalInicialCredito100).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" resultado de consulta el campo \"Capital inicial crédito\"  obligatorio, formato $. Editable")
	public ExpedirValidacionPage ValidarCaso39(String resultadoCapitalInicialCreditoObligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCapitalInicialCreditoObligatorio).getText(),resultadoCapitalInicialCreditoObligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" resultado de consulta el campo \"Días de plazo\" obligatorio, Numérico y editable")
	public ExpedirValidacionPage ValidarCaso40(String resultadoDiasPlazoObligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDiasPlazoObligatorio).getText(), resultadoDiasPlazoObligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" resultado de consulta el campo \"Días de plazo\" longitud 3")
	public ExpedirValidacionPage ValidarCaso41() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDiasPlazo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" los días y fecha de vencimiento digitados en este formulario deben ser menor o igual a los dos días y fecha de la sección de plazos")
	public ExpedirValidacionPage ValidarCaso42(String validarTituloPlazos) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblAlertaPlazos).getText(), validarTituloPlazos);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" resultado de consulta el campo \"Tipo interés\" no obligatorio, alfanumérico y editable")
	public ExpedirValidacionPage ValidarCaso43(String validarTipoInteresAlfanumerico) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTipoInteresAlfanumerico).getText(), validarTipoInteresAlfanumerico);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" resultado de consulta el campo \"Valor interés\" obligatorio, alfanumérico y ditable")
	public ExpedirValidacionPage ValidarCaso44(String validarValorInteresObligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblValorInteresObligatorio).getText(), validarValorInteresObligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" resultado de consulta el campo \"Frecuencia\" obligatorio, alfanumérico y ditable")
	public ExpedirValidacionPage ValidarCaso45(String validarFrecuenciaObligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblFrecuenciaObligatorio).getText(), validarFrecuenciaObligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("47. Validar en expedir titulo en grilla \"Ver Bono de Prenda\" en Buscar Acreedor/Endosatario el botón \"Guardar\"")
	public ExpedirValidacionPage ValidarCaso46(String validarEstaSeguroGuardarBono) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblEstaSeguroGuardarBono).getText(), validarEstaSeguroGuardarBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("48. Validar en expedir titulo en grilla \"Ver Bono de Prenda\" en Buscar Acreedor/Endosatario el botón \"Aceptar\" de ventana emergente")
	public ExpedirValidacionPage ValidarCaso47(String validarBonoGuardado) {

		Assert.assertEquals(getElement(lblvalidarBonoGuardado).getText(), validarBonoGuardado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver Bono de Prenda\" en Buscar Acreedor/Endosatario el botón \"Cancelar\"")
	public ExpedirValidacionPage ValidarCaso48() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblBonoEtiquetaCrear).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("49. Validar en expedir titulo en grilla \"Ver Bono de Prenda\" en Buscar Acreedor/Endosatario el botón \"Cancelar\" de ventana emergente")
	public ExpedirValidacionPage ValidarCaso49() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblBonoCancelar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Información general del título\" el campo \"Tipo de título \"Ver certificado de Depósito de Mercancía (botón agregar)")
	public ExpedirValidacionPage ValidarCaso50() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblEtiquetaCertificado).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("52. Validar en expedir titulo grilla \"Ver certificado de Depósito de Mercancía\" campo \"Buscar Acreedor/Endosatario\"")
	public ExpedirValidacionPage ValidarCaso51() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitNombreRazonSocialCertificado).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("53. Validar en expedir titulo grilla \"Ver certificado de Depósito de Mercancía\" campo \"Buscar Acreedor/Endosatario\"la logintud sea de 50 caracteres")
	public ExpedirValidacionPage ValidarCaso52() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitNombreRazonSocialCertificado50).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("54. Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" el campo Buscar Acreedor/Endosatario busqueda por \"Nit\"")
	public ExpedirValidacionPage ValidarCaso53() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitCertificado).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla en \"Ver certificado de Depósito de Mercancía\" en campo Buscar Acreedor/Endosatario busqueda por \"Nombre/Razón Social\"")
	public ExpedirValidacionPage ValidarCaso54() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNombreRazonSocialCertificado).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" en campo Buscar Acreedor/Endosatario consulta de registros no existentes")
	public ExpedirValidacionPage ValidarCaso55(String validarNitNombreRazonSocialCertificadoNoExiste) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitNombreRazonSocialCertificadoNoExiste).getText(),validarNitNombreRazonSocialCertificadoNoExiste);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" resultado de consultaa los campos NIT, Nombre/Razón social, Dirección (Domicilio), Ciudad y Correo, No Editables")
	public ExpedirValidacionPage ValidarCaso56() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitCertificadoNoEditable).isDisplayed(), true);
		Assert.assertEquals(getElement(lblNombreRazonSocialCertificadoNoEditable).isDisplayed(), true);
		Assert.assertEquals(getElement(lblDireccionCertificadoNoEditable).isDisplayed(), true);
		Assert.assertEquals(getElement(lblCiudadCertificadoNoEditable).isDisplayed(), true);
		Assert.assertEquals(getElement(lblCorreoCertificadoNoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" resultado de consulta los campos Tipo endoso y Fecha Endoso sean editables ")
	public ExpedirValidacionPage ValidarCaso57() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitCertificadoNoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" resultado de consunlta el campo Fecha Endoso no puede ser inferior a la fecha de creación del título")
	public ExpedirValidacionPage ValidarCaso58() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblFechaMayor).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar cuando se está expidiendo el título y este no se ha aplicado o está en estado “Incompleto”, tendrá la acción de Eliminar")
	public ExpedirValidacionPage ValidarCaso59() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblEliminarCertificado).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" en Buscar Certificado de Depósito Mercancía el botón \"Guardar\"")
	public ExpedirValidacionPage ValidarCaso60(String validarMensajeGuardar) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblEstaSeguroGuardarRegistro).getText(),validarMensajeGuardar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" en Buscar Certificado de Depósito Mercancía el botón \"Aceptar\" de ventana emergente")
	public ExpedirValidacionPage ValidarCaso61(String validarBotonAceptar) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblBotonAceptar).getText(),validarBotonAceptar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" en Buscar Certificado de Depósito Mercancía el botón \"Cancelar\"")
	public ExpedirValidacionPage ValidarCaso62(String validarBotonCancelar) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblBotonCancelar).getText(),validarBotonCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en grilla \"Ver certificado de Depósito de Mercancía\" en Buscar Certificado de Depósito Mercancía el botón \"Cancelar\" de ventana emergente")
	public ExpedirValidacionPage ValidarCaso63(String validarTituloOpcionCancelar) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTituloOpcionCancelar).getText(),validarTituloOpcionCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en grilla  \"Ver certificado de Depósito de Mercancía\" campos obligatorios de pantalla \"Certificado de Depósito Mercancía\"")
	public ExpedirValidacionPage ValidarCaso64(String validarMensajesFaltanDatos) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblMensajeFaltanDatos).getText(),validarMensajesFaltanDatos);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en grilla \"Ver Bono de Prenda\" campos obligatorios de pantalla \"Buscar Acreedor/Endosatario\"")
	public ExpedirValidacionPage ValidarCaso65(String validarFaltanDatosEntradaBono) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblFaltanDatosEntradaBono).getText(), validarFaltanDatosEntradaBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo grilla \"Plazos\" Acordeón")
	public ExpedirValidacionPage ValidarCaso66(String validarGrillaPlazos) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblGrillaPlazos).getText(), validarGrillaPlazos);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo grilla \"Plazos\" el campo \"Plazo Contrato Depósito\" obligatorio, Numérico y editable")
	public ExpedirValidacionPage ValidarCaso67(String validarPlazoContratoDepositoOobligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblPlazoContratoDepositoOobligatorio).getText(), validarPlazoContratoDepositoOobligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo grilla \"Plazos\" el campo \"Fecha Vencimiento\" No editable (Plazo Contrato Depósito)")
	public ExpedirValidacionPage ValidarCaso69() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblFechaVencimientoPlazoContratoDeposito).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo grilla \"Plazos\" el campo \"Plazo Certificado Depósito\" longitud 3")
	public ExpedirValidacionPage ValidarCaso71() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblPlazoCertificadoDeposito3).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo grilla \"Plazos\" el campo \"Fecha Vencimiento\" No editable (Plazo Certificado Depósito)")
	public ExpedirValidacionPage ValidarCaso72() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblFechaVencimientoPlazoCertificadoDeposito).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo grilla \"Plazos\" el plazo y fecha de vencimiento del certificado de depósito debe ser menor o igual al plazo y fecha de vencimiento del contrato de depósito")
	public ExpedirValidacionPage ValidarCaso73() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblFechaVencimientoPlazoCertificadoDeposito).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoPlazoContratoDeposito).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Póliza\"  los campos Número de Póliza y Aseguradora no editables")
	public ExpedirValidacionPage ValidarCaso74() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumPolizaNoEditable).isDisplayed(), true);
		Assert.assertEquals(getElement(lblAseguradoraNoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Póliza\" el campo \"Valor asegurado\"")
	public ExpedirValidacionPage ValidarCaso75(String validarCampoValorAsegurado) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCampoValorAsegurado).getText(), validarCampoValorAsegurado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Póliza\" el campo \"Fecha Vencimiento\"")
	public ExpedirValidacionPage ValidarCaso76() {

		Utilidades.waitInMs(3000);

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Tipo de mercancía\" obligatorio y lista las mercancías")
	public ExpedirValidacionPage ValidarCaso77() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblListaTipoDeMercancia).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Código\" obligatorio, automático y no editable")
	public ExpedirValidacionPage ValidarCaso78() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCodigoObligatorio).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Descripción general de mercancía\" obligatorio, alfanumérico y editable")
	public ExpedirValidacionPage ValidarCaso79() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDescripcionMercanciaObligatorioAlfanumerico).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Descripción general de mercancía\" longitud 100")
	public ExpedirValidacionPage ValidarCaso80() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDescripcionMercanciaObligatorioAlfanumerico).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Merma\" numérico y editable")
	public ExpedirValidacionPage ValidarCaso81() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblMermaNumericoEditable).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Merma\" numérico y editable")
	public ExpedirValidacionPage ValidarCaso82() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblMerma3).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Aplica condición de calidad\"Obligatorio y selección de SI/NO")
	public ExpedirValidacionPage ValidarCaso83() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblAplicaCondicionDeCalidadOblogatorioSINO).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Observaciones\" obligatorio, alfanumérico y editable")
	public ExpedirValidacionPage ValidarCaso84() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblObservacionesObligatorioAlfanumerico).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía\" el campo \"Observaciones\" longitud 1056")
	public ExpedirValidacionPage ValidarCaso85() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblLongitud1056).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Tipo de mercancía \" el campo \"Observaciones\" longitud 1056")
	public ExpedirValidacionPage ValidarCaso86() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblLongitud1056).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar expedición de titulo con bodega propia con mercancía en transito")
	public ExpedirValidacionPage ValidarCaso87(String validarPlazos, String validarPoliza, String validarTipoMercancia,
			String validarMercancias, String validarTarifas) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblGrillaPlazos1).getText(), validarPlazos);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblGrillaPoliza).getText(), validarPoliza);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblGrillaTipoMercancia).getText(), validarTipoMercancia);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblGrillaMercancias).getText(), validarMercancias);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblGrillaTarifas).getText(), validarTarifas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Mercancías\" botón agregar lineas de manera individual")
	public ExpedirValidacionPage ValidarCaso95(String validarAgregarNuevaMercancia) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblAgregarNuevaMercancia).getText(), validarAgregarNuevaMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Mercancías\" pantalla \"Agregar una nueva mercancía\" campo \"Detalle de mercancía\" obligatorio y editable")
	public ExpedirValidacionPage ValidarCaso96(String validarDetalleMercanciaObligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDetalleMercanciaObligatorio).getText(), validarDetalleMercanciaObligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Mercancías\" pantalla \"Agregar una nueva mercancía\" campo \"Detalle de mercancía\" longitud 100")
	public ExpedirValidacionPage ValidarCaso97(String validarDetalleMercanciaLongitud200) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDetalleMercanciaLongitud200).getText(), validarDetalleMercanciaLongitud200);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Mercancías\" pantalla \"Agregar una nueva mercancía\" campo \"Unidad de medida\" obligatorio y listar unidades de medida parametrizadas en el sistema")
	public ExpedirValidacionPage ValidarCaso98(String validarUnidadMedidaObligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblUnidadMedidaObligatorio).getText(), validarUnidadMedidaObligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" pantalla \"Agregar una nueva mercancía\" campo \"Unidad de medida super\" obligatorio")
	public ExpedirValidacionPage ValidarCaso100(String validarUnidadMedidaSuperObligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblUnidadMedidaSuperObligatorio).getText(), validarUnidadMedidaSuperObligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("")
	public ExpedirValidacionPage ValidarCaso101() {

		Utilidades.waitInMs(3000);
		
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Valor de conversión\" longitud de 6")
	public ExpedirValidacionPage ValidarCaso103() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblLogitud6ValorConversion).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Cantidad\" obligatorio, numérico y editable")
	public ExpedirValidacionPage ValidarCaso104(String validarCantidadObligatorio) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCantidadObligatorio).getText(), validarCantidadObligatorio);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Cantidad\" obligatorio, numérico y editable")
	public ExpedirValidacionPage ValidarCaso0106() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCantidadNumerico).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Valor unitario\" longitud 20")
	public ExpedirValidacionPage ValidarCaso108() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblValorUnitario).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Valor total\" obligatorio, numérico, formato $, automático producto de la multiplicación de cantidad por valor unitario")
	public ExpedirValidacionPage ValidarCaso109() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblTotal).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Fecha de vencimiento\" (dd/mm/aaaa) y editable")
	public ExpedirValidacionPage ValidarCaso110() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblFechaVencimiento).isDisplayed(), false);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Fecha de vencimiento\" no puede ser inferior a la fecha del título a expedir")
	public ExpedirValidacionPage ValidarCaso111() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblFecha).isDisplayed(), false);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Observación de la mercancía\" alfanumérico y editable")
	public ExpedirValidacionPage ValidarCaso112() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblObservacion).isDisplayed(), false);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Observación de la mercancía\"longitud 256")
	public ExpedirValidacionPage ValidarCaso113(String validarMercanciaLongitud256) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblMercanciaLongitud256).getText(), validarMercanciaLongitud256);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" paginación")
	public ExpedirValidacionPage ValidarCaso114() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblFila20).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("")
	public ExpedirValidacionPage ValidarCaso115(String validarMensajeGuardar) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblvalidarMensajeGuardar).getText(), validarMensajeGuardar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" en pantalla \"Agregar una nueva mercancía\"el botón \"Cancelar\"")
	public ExpedirValidacionPage ValidarCaso116(String validarMercancia) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblMercancia).getText(), validarMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" en pantalla \"Agregar una nueva mercancía\"el botón \"Cancelar\"")
	public ExpedirValidacionPage ValidarCaso117(String validarMercanciaBotonCancelar) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblMercanciaModificarBotonCancelar).getText(), validarMercanciaBotonCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" en pantalla \"Agregar una nueva mercancía\"el botón \"Cancelar\"de ventana emergente")
	public ExpedirValidacionPage ValidarCaso118(String validarMercanciaBotonCancelarOpcion2) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblMercanciaModificarBotonCancelarOpcion2).getText(), validarMercanciaBotonCancelarOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	By lblCantidadMercancia = By.cssSelector("#tbMercancia td:nth-child(3)");
	By lblValorUnitarioMercancia = By.cssSelector("#tbMercancia td:nth-child(4)");
	By lblValorTotalMercancias = By.cssSelector(".table > tr > td");
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" el campo \"Valor total mercancía del título\" obligatorio y trae por defecto sumatoria del total de cada línea de mercancía de la grilla y no Editable")
	public ExpedirValidacionPage ValidarCaso119() {

		Utilidades.waitInMs(2000);
		
		String cantidad = getElement(lblCantidadMercancia).getText();
		String valorUnitario = getElement(lblValorUnitarioMercancia).getText();

		int cant = Integer.parseInt(cantidad);
		int vUnitario = Integer.parseInt(valorUnitario);

		int resultado = vUnitario * cant;

		String result = String.valueOf("$") + (resultado);
		System.out.println(result);

		Assert.assertEquals(getElement(lblValorTotalMercancias).getText(), result);

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo en la grilla \"Mercancías\" opción de cargue masivo")
	public ExpedirValidacionPage ValidarCaso120(String validarDetalleMercanciaMasivo,
			String validarUnidadMedidaMasivo, String validarCantidadMasivo, String validarValorUnitarioMasivo,
			String validarValorTotalMasivo) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblDetalleMercanciaMasivo).getText(), validarDetalleMercanciaMasivo);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaMasivo).getText(), validarUnidadMedidaMasivo);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCantidadMasivo).getText(), validarCantidadMasivo);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorUnitarioMasivo).getText(), validarValorUnitarioMasivo);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorTotalMasivo).getText(), validarValorTotalMasivo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo en la grilla \"Mercancías\" opción de cargue masivo")
	public ExpedirValidacionPage ValidarCaso0120(String validarFechaVencimientoMasivo, String ObservacionMercanciaMasivo,
			String validarAccionMasivo) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblFechaVencimientoMasivo).getText(), validarFechaVencimientoMasivo);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblObservacionMercanciaMasivo).getText(), ObservacionMercanciaMasivo);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblAccionMasivo).getText(), validarAccionMasivo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo grilla \"Mercancía\" con selección de bodega propia\" botón agregar")
	public ExpedirValidacionPage ValidarCaso123() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblBotonAgregarMercancia).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulo grilla \"Mercancía con selección de bodega propia\" cargue individual")
	public ExpedirValidacionPage ValidarCaso124(String validarIndividualCrear) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblIndividualCrear).getText(), validarIndividualCrear);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo grilla \"Mercancía con selección de bodega propia\" cargue masivo")
	public ExpedirValidacionPage ValidarCaso125(String validarCargueMasivo) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblCargueMasivo).getText(), validarCargueMasivo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo grilla \"Mercancía con selección de bodega propia\" Cuando se está expidiendo el título y este no se ha aplicado o está en estado “Incompleto”, tendrá la acción de Eliminar")
	public ExpedirValidacionPage ValidarCaso127() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblAccionEliminarCargueMasivo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo el campo \"Tarifa\" obligatorio, numérico y no editable")
	public ExpedirValidacionPage ValidarCaso128() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblTarifa).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulo el campo \"mínima\" obligatorio, numérico y no editable")
	public ExpedirValidacionPage ValidarCaso129() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblMinima).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedición de titulos el estado incompleto (“El registro se ha guardado con estado incompleto”)")
	public ExpedirValidacionPage ValidarCaso130(String validarRegistroIncompleto) {

		Assert.assertEquals(getElement(lblRegistroIncompleto).getText(), validarRegistroIncompleto);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en expedir titulos botón \"Guardar\"")
	public ExpedirValidacionPage ValidarCaso133(String validarEstaSeguroBotonGuardar) {

		Assert.assertEquals(getElement(lblValidarBotonGuardarEstaSeguro).getText(), validarEstaSeguroBotonGuardar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulos botón \"Cancelar\"")
	public ExpedirValidacionPage ValidarCaso135(String validarBotonCancelar) {

		Assert.assertEquals(getElement(lblValidarBotonCancelar).getText(), validarBotonCancelar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en expedir titulos botón \"Cancelar\" ventana emergente")
	public ExpedirValidacionPage ValidarCaso136(String validarBotonCancelarOpcion2) {

		Assert.assertEquals(getElement(lblValidarBotonCancelarOpcion2).getText(), validarBotonCancelarOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar funcionalidad de “Consultar” con las opciones NIT/Nombre o Razón social, título y fecha")
	public ExpedirValidacionPage ValidarCaso137() {
		
		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblValidarTextoModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación en la consulta se inicie apartir del tercer caracter")
	public ExpedirValidacionPage ValidarCaso138() {
		
		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblConsultaTercerCaracter).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación la opción \"Buscar\" sea TextBox y longitud de 50 Caracteres")
	public ExpedirValidacionPage ValidarCaso139() {
		
		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblNitConsultarCaracteres50).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar consulta por NIT")
	public ExpedirValidacionPage ValidarCaso140() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblNitConsultar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar consulta por título")
	public ExpedirValidacionPage ValidarCaso141() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblNombreRazonSocialConsultar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar consulta por título")
	public ExpedirValidacionPage ValidarCaso142(String validarConsultaTitulo) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblConsultaTitulo).getText(), validarConsultaTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar consulta por fecha")
	public ExpedirValidacionPage ValidarCaso143() {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblConsultaFecha).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en la consulta la estructura de muestra de la información(Número de título, NIT, Nombre/Razón social, Tipo de Bodega, Tipo de título, Tipo de mercancía, Valor de Mercancía, Estado de título y Acción)")
	public ExpedirValidacionPage ValidarCaso144(String validarNumeroTitulo, String validarNit, String validarNombreRazonSocial,
			String validarTipoBodega, String validarTipoTitulo, String validarTipoMercancia, String validarValorMercancia) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblNumeroTitulo).getText(), validarNumeroTitulo);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblNIT).getText(), validarNit);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblNombreRazonSocial).getText(), validarNombreRazonSocial);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblTipoBodega).getText(), validarTipoBodega);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblTipoTitulo).getText(), validarTipoTitulo);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblTipoMercancia).getText(), validarTipoMercancia);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorMercancia).getText(), validarValorMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en la consulta la estructura de muestra de la información(Número de título, NIT, Nombre/Razón social, Tipo de Bodega, Tipo de título, Tipo de mercancía, Valor de Mercancía, Estado de título y Acción)")
	public ExpedirValidacionPage ValidarCaso0144(String validarEstado, String validarAccion) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblEstado).getText(), validarEstado);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblAccion).getText(), validarAccion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en consulta registros no existentes")
	public ExpedirValidacionPage ValidarCaso146(String validarNoExistenRegistros) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblNoExistenRegistros).getText(), validarNoExistenRegistros);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en \"Acción\" el botón \"Ver\" detalle título")
	public ExpedirValidacionPage ValidarCaso147(String validarVisualizarTitulo) {

		Utilidades.waitInMs(2000);
		Assert.assertEquals(getElement(lblVisualizarTitulo).getText(), validarVisualizarTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Incompleto” campos editables en información general del titulo")
	public ExpedirValidacionPage ValidarCaso150() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTipoBodegaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblBodegaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblTipoTituloModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblDesdeModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblHastaModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Incompleto” campos no editables en información general del titulo")
	public ExpedirValidacionPage ValidarCaso151() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumeroTituloModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCodigoTituloModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaExpedicionModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblOficinaExpedicionModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblOficinaResponsableModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCudadModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Incompleto” campos editables en Ver Bono de Prenda")
	public ExpedirValidacionPage ValidarCaso152() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCapitalInicialModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblDiasPlazoModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblTipoInteresModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFrecuenciaModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Incompleto” campos no editables en Ver Bono de Prenda")
	public ExpedirValidacionPage ValidarCaso153() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblNombreRazonSocialModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblDireccionModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCiudadModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCorreoModidicarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Incompleto” campos editables en Ver Certificado de Depósito de Mercancía")
	public ExpedirValidacionPage ValidarCaso154() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTipoInteresModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaEndosoModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Incompleto” campos no editables en Ver Certificado de Depósito de Mercancía")
	public ExpedirValidacionPage ValidarCaso155() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblNombreRazonSocialModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblDireccionModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCiudadModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCorreoModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Incompleto” campos no editables en Pólizapara bodega particular, particular arrendada y transito")
	public ExpedirValidacionPage ValidarCaso156() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumeroPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblAseguradoraModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaExpedicionPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorAseguradoPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Incompleto” campos editables en Mercancías(Individual)para bodega particular, particular arrendada y transito")
	public ExpedirValidacionPage ValidarCaso157() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDetalleMercanciaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaSuperModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCantidadModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorUnitarioModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoMercanciaModificar).isDisplayed(), false);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblObservacionesModificar).isDisplayed(), false);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado estado “Grabado” campos no editables de la grilla \"Información del título Depositante\"")
	public ExpedirValidacionPage ValidarCaso160() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblModificarNit).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblModificarNombreRazonSocial).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblModificarDireccion).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblModificarCiudad).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblModificarTelefono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblModificarCorreo).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Grabado” campos no editables de la grilla \"Información general del título\"")
	public ExpedirValidacionPage ValidarCaso161() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumeroTituloModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCodigoTituloModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaExpedicionModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblOficinaExpedicionModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblOficinaResponsableModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCudadModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Grabado” campos editables de la grilla \"Ver Bono de Prenda\"")
	public ExpedirValidacionPage ValidarCaso163() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblCapitalInicialModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblDiasPlazoModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblTipoInteresModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFrecuenciaModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Grabado” campos no editables de la grilla \"Ver Bono de Prenda\"")
	public ExpedirValidacionPage ValidarCaso164() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblNombreRazonSocialModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblDireccionModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCiudadModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCorreoModidicarBono).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoModificarBono).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Grabado” campos editables de la grilla \"Certificado de Depósito de Mercancía\"")
	public ExpedirValidacionPage ValidarCaso165() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTipoInteresModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaEndosoModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Grabado” campos no editables de la grilla \"Certificado de Depósito de Mercancía\"")
	public ExpedirValidacionPage ValidarCaso166() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblNombreRazonSocialModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblDireccionModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCiudadModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCorreoModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}


	@Step("Validar en modificación título en estado “Grabado” campos no editables de la grilla \"Póliza\"")
	public ExpedirValidacionPage ValidarCaso167() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumeroPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblAseguradoraModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaExpedicionPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorAseguradoPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Grabado” campos no editables de la grilla \"Mercancías\"")
	public ExpedirValidacionPage ValidarCaso168() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDetalleMercanciaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaSuperModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCantidadModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorUnitarioModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoMercanciaModificar).isDisplayed(), false);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblObservacionesModificar).isDisplayed(), false);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Grabado” campos editables de la grilla \"Mercancías\"")
	public ExpedirValidacionPage ValidarCaso169() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDetalleMercanciaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaSuperModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCantidadModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorUnitarioModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoMercanciaModificar).isDisplayed(), false);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblObservacionesModificar).isDisplayed(), false);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Grabado” funcionalidad del botón \"Aplicar\"")
	public ExpedirValidacionPage ValidarCaso170(String validarBotonAplicar) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblValidarBotonAplicar).getText(), validarBotonAplicar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Aplicado” (Imprimir Originales)")
	public ExpedirValidacionPage ValidarCaso171(String validarImprimirOriginal) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblImprimirBorrador).getText(), validarImprimirOriginal);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Aplicado”campos no editables de la grilla \"Información del título Depositante\"")
	public ExpedirValidacionPage ValidarCaso172() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNitModificacion).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblNombreRazonSocialModificacion).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblDireccionModificacion).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCiudadModificacion).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblTelefonoModificacion).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCorreoModificacion).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Aplicado”campos editables de la grilla \"Información general del título\"")
	public ExpedirValidacionPage ValidarCaso173() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDesdeModificacion).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblHastaModificacion).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado“Aplicado”campos no editables de la grilla \"Información general del título\"")
	public ExpedirValidacionPage ValidarCaso174() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumeroTituloModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCodigoTituloModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaExpedicionModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblOficinaExpedicionModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblOficinaResponsableModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCudadModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Aplicado”campos no editables de la grilla \"Ver Bono de Prenda\"")
	public ExpedirValidacionPage ValidarCaso175(String validarVerBonoPrendaModificar) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblVerBonoPrendaModificar).getText(), validarVerBonoPrendaModificar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Aplicado”campos editables de la grilla \"Ver Bono de Prenda\"")
	public ExpedirValidacionPage ValidarCaso176(String validarVerBonoPrendaModificar) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblVerBonoPrendaModificar).getText(), validarVerBonoPrendaModificar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Aplicado”campos no editables de la grilla \"Ver Certificado de Depósito de Mercancía\"")
	public ExpedirValidacionPage ValidarCaso177(String validarVerCertificadoDepositoModificar) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblVerCertificadoDepositoModificar).getText(), validarVerCertificadoDepositoModificar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validar en modificación título en estado “Aplicado”campos editables de la grilla \"Ver Certificado de Depósito de Mercancía\"")
	public ExpedirValidacionPage ValidarCaso178() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTipoInteresModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaEndosoModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Aplicado”campos no editables de la grilla \"Póliza\"")
	public ExpedirValidacionPage ValidarCaso179() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblNumeroPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblAseguradoraModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorAseguradoPolizaModificar).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en modificación título en estado “Aplicado”campos no editables de la grilla \"Mercancías\" para las bodegas particular, particular arrendada y transito.")
	public ExpedirValidacionPage ValidarCaso180() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblDetalleMercanciaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblUnidadMedidaSuperModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblCantidadModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblValorUnitarioModificar).isDisplayed(), true);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblFechaVencimientoMercanciaModificar).isDisplayed(), false);
		Utilidades.waitInMs(1000);
		Assert.assertEquals(getElement(lblObservacionesModificar).isDisplayed(), false);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar mensaje “El título ya estaba en estado grabado, no puede dejar información incompleta”")
	public ExpedirValidacionPage ValidarCaso181(String validarinformacionCompleta) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblTarifasModificar).getText(), validarinformacionCompleta);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	
	@Step("Validar en la consulta diferencia entre minúsculas y mayúsculas")
	public ExpedirValidacionPage ValidarCaso182() {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblMayusculasMinusculasCrear).isDisplayed(), true);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Validacion campos obligatorios en el formulario de expedicióin de titulos")
	public ExpedirValidacionPage ValidarCaso183(String validarFaltanDatosEntrada) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblFaltanDatosEntrada).getText(), validarFaltanDatosEntrada);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
	By lblClienteNoExisteCrear = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/busqueda-cliente/form/div[2]/div");
	@Step("Validar la expedición de titulo de un cliente que no existe")
	public ExpedirValidacionPage ValidarCaso186(String validarFaltanDatosEntrada) {

		Utilidades.waitInMs(3000);
		Assert.assertEquals(getElement(lblClienteNoExisteCrear).getText(), validarFaltanDatosEntrada);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}
}