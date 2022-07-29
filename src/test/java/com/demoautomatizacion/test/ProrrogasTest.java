package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.GenerarReportePdf;

@Listeners({ TestListener.class })
@Epic("Prorrogas")
@Feature("Prorrogas Test")

public class ProrrogasTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		return fileprops;
	}
	
	public void login(String nameTest, String usuario, String contrasena) throws Exception {
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderProrroga"),
				getProperties().getProperty("path"));
		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista1"),
				getProperties().getProperty("url"));
		GenerarReportePdf.setImgContador(0);

		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath);
	}

	
	@Test(priority = 0, description = "Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Story("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	public void AlmavivaBodegas1() throws Exception {
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderProrroga"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestProrroga"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		prorroga.prorrogas(folderPath);	
		
		GenerarReportePdf.closeTemplate("");
	}
	
	
	
	
	@Test(priority = 0, description = "Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Story("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	public void AlmavivaProrrogas() throws Exception {
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderProrroga"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestProrroga"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		prorroga.prorrogasHU24(folderPath,getProperties().getProperty("TituloModificarProrroga"));	
		
		GenerarReportePdf.closeTemplate("");
	}

	
	
	
	

	/*@Test(priority = 0, description = "Caso 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el modulo de titluos/Prórroga de títulos solo se muestre al usuario con el rol y perfil que tenga los permisos")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b1() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo();
		ValidacionProrrogas.ValidarCaso1(getProperties().getProperty("validarUsuarioPermisos"));
		home.Exit();
	}

	@Test(priority = 1, description = "Caso 2")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar la opción \"Prórrogar\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b2() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar();
		ValidacionProrrogas.ValidarCaso2(getProperties().getProperty("validarProrrogar"));
		home.Exit();
	}

	@Test(priority = 2, description = "Caso 3")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar encabezado de la pantalla \"Prórroga de Títulos\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b3() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar();
		ValidacionProrrogas.ValidarCaso3(getProperties().getProperty("validarEncabezado"));
		home.Exit();
	}

	@Test(priority = 3, description = "Caso 4")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar campo \"Buscar Título\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b4() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("texto"));
		ValidacionProrrogas.ValidarCaso4();
		home.Exit();
	}

	@Test(priority = 4, description = "Caso 5")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar longitud en el campo \"Buscar Título\"sea de 50 caracteres y Autocomplete")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b5() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar()
				.CodigoTitulo(getProperties().getProperty("busquedaTercerCaracter")).ClearCodigoTitulo()
				.CodigoTitulo(getProperties().getProperty("caracteres50"));
		ValidacionProrrogas.ValidarCaso4();
		home.Exit();
	}

	@Test(priority = 5, description = "Caso 6")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el campo \"Buscar código de Título\" busqueda por \"código de título\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b6() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().InformacionBasicaTitulo()
				.CodigoTitulo(getProperties().getProperty("tituloBonoPrenda")).SeleccionarCodigoTitulo();
		ValidacionLiberacion.ValidarCaso6();
		home.Exit();
	}

	@Test(priority = 6, description = "Caso 7")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el campo \"Buscar código de Título\"se inicie busqueda apartir del tercer carácter digitado")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b7() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar()
				.CodigoTitulo(getProperties().getProperty("busquedaTercerCaracter")).ClearCodigoTitulo()
				.CodigoTitulo(getProperties().getProperty("busquedaTercerCaracter2"));
		ValidacionLiberacion.ValidarCaso7();
		home.Exit();
	}

	@Test(priority = 7, description = "Caso 8")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el campo \"Buscar código de Título\" que  permita la consulta de titulos en estado “Aplicado”")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b8() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ExpedirCrear.Titulo().Expedir();
		ExpedirConsultar.ConsultaTitulo().TextoBuscar(getProperties().getProperty("tituloBonoPrenda")).BotonBuscar();
		ExpedirModificar.ScrollDerecha().Evidencia();
		Prorrogas.Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarCaso8();
		home.Exit();
	}
	
	@Test(priority = 8, description = "Caso 9")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el campo \"Buscar Título\" no permita la consulta de títulos en estado “Incompleto, grabado, anulado, cancelado”")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b9() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ExpedirCrear.Titulo().Expedir();
		ExpedirConsultar.ConsultaTitulo().TextoBuscar(getProperties().getProperty("tituloIncompleto")).BotonBuscar();
		ExpedirModificar.ScrollDerecha();
		ExpedirConsultar.ClearBuscar().TextoBuscar(getProperties().getProperty("tituloGrabado")).BotonBuscar();
		ExpedirModificar.ScrollDerecha();
		ExpedirConsultar.ClearBuscar().TextoBuscar(getProperties().getProperty("tituloCancelado")).BotonBuscar();
		ExpedirModificar.ScrollDerecha();
		ExpedirConsultar.ClearBuscar().TextoBuscar(getProperties().getProperty("tituloAnulado")).BotonBuscar();
		ExpedirModificar.ScrollDerecha();
		Prorrogas.Prorrogar().CodigoTitulo(getProperties().getProperty("tituloIncompleto"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		Prorrogas.ClearCodigoTitulo().CodigoTitulo(getProperties().getProperty("tituloGrabado"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		Prorrogas.ClearCodigoTitulo().CodigoTitulo(getProperties().getProperty("tituloCancelado"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		Prorrogas.ClearCodigoTitulo().CodigoTitulo(getProperties().getProperty("tituloAnulado"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		home.Exit();
	}

	@Test(priority = 9, description = "Caso 10")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el campo \"Buscar código de Título\" registros no existentes")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b10() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar()
				.CodigoTitulo(getProperties().getProperty("noExiste"));
		ValidacionProrrogas.ValidarCaso9(getProperties().getProperty("validarRegistrosNoExistentes"));
		home.Exit();
	}

//	@Test(priority = 10, description = "Caso 11")
//	@Severity(SeverityLevel.NORMAL)
//	@Description("Validar en la acción \"Buscar código de Título\" cuando se encuentren resultados muestre  formulario de consulta")
//	@Story("Liberación de Mercancía")
//	@TmsLink("XRPRJ-1")
//	public void b11() throws Exception {
//		home.irPortal(getProperties().getProperty("url"));
//		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
//		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
//		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
//		ValidacionLiberacion.ValidarCaso10(getProperties().getProperty("validarNIT"),
//				getProperties().getProperty("validarNombreRazonSocial"),
//				getProperties().getProperty("validarDireccion"), getProperties().getProperty("validarCiudad"),
//				getProperties().getProperty("validarFechaExpedicion"),
//				getProperties().getProperty("validarOficinaExpedicion"),
//				getProperties().getProperty("validarOficinaResponsable"),
//				getProperties().getProperty("validarTipoBodega"));
//		home.Exit();
//	}
	
	@Test(priority = 10, description = "Caso 11")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta título en tipo colapsable \"Información básica de título\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b11() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarTituloI("Información básica de título");
		home.Exit();
		
	}

	@Test(priority = 11, description = "Caso 12")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta en la grilla de \"Información básica de título\" campo \"NIT\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b12() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarNit(getProperties().getProperty("validarNIT"));
		home.Exit();
	}

	@Test(priority = 12, description = "Caso 13")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta en la grilla de \"Información básica de título\" campo \"Nombre razón social\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b13() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarNRS(getProperties().getProperty("validarNombreRazonSocial"));
		home.Exit();
		
	}

	@Test(priority = 13, description = "Caso 14")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta en la grilla de \"Información básica de título\" campo \"Dirección\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b14() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarDireccion(getProperties().getProperty("validarDireccion"));
		home.Exit();
		
	}

	@Test(priority = 14, description = "Caso 15")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta en la grilla de \"Información básica de título\"campo \"Ciudad\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b15() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarCiudad(getProperties().getProperty("validarCiudad"));
		home.Exit();
		
	}

	@Test(priority = 15, description = "Caso 16")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta en la grilla de \"Información básica de título\"campo \"Fecha expedición\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b16() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarFechaExpedicion(getProperties().getProperty("validarFechaExpedicion"));
		home.Exit();

	}

	@Test(priority = 16, description = "Caso 17")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta en la grilla de \"Información básica de título\" campo \"Oficina expedición\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b17() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarOficinaExpedicion(getProperties().getProperty("validarOficinaExpedicion"));
		home.Exit();

	}

	@Test(priority = 17, description = "Caso 18")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta en la grilla de \"Información básica de título\"campo \"Oficina responsable de almacenamiento\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b18() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarOficinaResponsable(getProperties().getProperty("validarOficinaResponsable"));
		home.Exit();

	}

	@Test(priority = 18, description = "Caso 19")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en formulario de consulta en la grilla de \"Información básica de título\"campo \"Tipo bodega\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b19() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloConDetalle"))
		.SeleccionarCodigoTitulo().InformacionBasicaTitulo();
		ValidacionProrrogas.ValidarTipoBodega(getProperties().getProperty("validarTipoBodega"));
		home.Exit();

	}

	@Test(priority = 19, description = "Caso 20")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda\" el encabezado \"Bono de prenda\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b20() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarTitulo2("Bono de prenda");
		home.Exit();

	}

	@Test(priority = 20, description = "Caso 21")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Días\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b21() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarDias("Días");
		home.Exit();

	}

	@Test(priority = 21, description = "Caso 22")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Nueva fecha\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b22() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarNuevaFecha("Nueva Fecha");
		home.Exit();

	}

	@Test(priority = 22, description = "Caso 23")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Fecha de deposito\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b23() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarFechaDeposito("Fecha de depósito:");
		home.Exit();

	}

	@Test(priority = 23, description = "Caso 24")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Plazo del deposito\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b24() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarPlazoDeposito("Plazo del depósito");
		Prorrogas.PlazoDeposito(getProperties().getProperty("NumeroDias")).ClearPlazoDeposito()
		.PlazoDeposito(getProperties().getProperty("Titulo"));
		home.Exit();

	}

	@Test(priority = 24, description = "Caso 25")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Nueva fecha plazo de deposito\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b25() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarNFPD("Nueva fecha plazo de depósito");
		home.Exit();

	}

	@Test(priority = 25, description = "Caso 26")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar para titulo \"Bono de prenda \" en el campo\"Nueva fecha plazo de deposito\"columna “Nueva fecha”calculo de la fecha")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b26() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ExpedirCrear.Titulo().Expedir();
		ExpedirConsultar.ConsultaTitulo().TextoBuscar(getProperties().getProperty("tituloBonoPrenda"));
		ExpedirModificar.ScrollDerecha().ModificarTitulo().Scroll2().Evidencia();
		Plazos.Plazos();
		ExpedirModificar.Scroll2().Evidencia();
		Prorrogas.Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda().ScrollAbajo().PlazoDeposito(getProperties().getProperty("NumeroDias"));
		home.Exit();
		
	}

	@Test(priority = 26, description = "Caso 27")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Fecha de crédito\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b27() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarFechaCredito("Fecha de crédito:");
		home.Exit();
		
	}

	@Test(priority = 27, description = "Caso 28")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Plazo del crédito\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b28() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarPlazoCredito("Plazo del crédito");
		Prorrogas.PlazoCredito(getProperties().getProperty("NumeroDias")).ClearPlazoCredito()
		.PlazoCredito(getProperties().getProperty("Titulo"));
		home.Exit();

	}
	
	@Test(priority = 28, description = "Caso 29")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"en campo \"Plazo del crédito\" sea igual o menor al plazo del deposito")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b29() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarPlazoCredito("Plazo del crédito");
		Prorrogas.PlazoDeposito(getProperties().getProperty("DiasP")).PlazoCredito(getProperties().getProperty("DiasC"));
		home.Exit();

	}

	@Test(priority = 29, description = "Caso 30")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Nueva fecha plazo de crédito\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b30() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda();
		ValidacionProrrogas.ValidarNFPC("Nueva fecha plazo de crédito");
		home.Exit();

	}

	@Test(priority = 30, description = "Caso 31")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Fecha de certificado\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b31() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda().ScrollAbajo();
		ValidacionProrrogas.ValidarFechaCertificado("Fecha de certificado:");
		home.Exit();

	}

	@Test(priority = 31, description = "Caso 32")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Plazo del certificado\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b32() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda().ScrollAbajo();
		ValidacionProrrogas.ValidarPlazoCertificado("Plazo del certificado");
		Prorrogas.PlazoCertificado(getProperties().getProperty("NumeroDias")).ClearPlazoCertificado()
		.PlazoCertificado(getProperties().getProperty("Titulo")).PlazoDeposito(getProperties().getProperty("DiasP"))
		.PlazoCredito(getProperties().getProperty("DiasC")).ClearPlazoCertificado()
		.PlazoCertificado(getProperties().getProperty("DiasC"));
		home.Exit();

	}
	
	@Test(priority = 32, description = "Caso 33")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Bono de prenda \"funcionalidad campo \"Nueva fecha plazo de certificado\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b33() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloBonoPrenda"))
		.SeleccionarCodigoTitulo().BonoPrenda().ScrollAbajo();
		ValidacionProrrogas.ValidarNFPCertificado("Nueva fecha plazo de certificado");
		home.Exit();

	}
	
	@Test(priority = 33, description = "Caso 34")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad de botón \"guardar\" BONO DE PRENDA")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b34() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloGuardar"))
		.SeleccionarCodigoTitulo().BonoPrenda().ScrollAbajo();
		Prorrogas.PlazoDeposito(getProperties().getProperty("NumeroDias")).PlazoCredito(getProperties().getProperty("NumeroDias"))
		.PlazoCertificado(getProperties().getProperty("NumeroDias")).BotonGuardar().BotonCancelar1();
		home.Exit();

	}
	
	@Test(priority = 35, description = "Caso 35")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en ventana emergente de guardar funcionalidad de los botones \"Aceptar\" y \"Cancelar\" BONO DE PRENDA")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b35() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloGuardar"))
		.SeleccionarCodigoTitulo().BonoPrenda().ScrollAbajo();
		Prorrogas.PlazoDeposito(getProperties().getProperty("NumeroDias")).PlazoCredito(getProperties().getProperty("NumeroDias"))
		.PlazoCertificado(getProperties().getProperty("NumeroDias")).BotonGuardar().BotonCancelar1().BotonGuardar().BotonAceptar();
		home.Exit();
		
	}
	
	@Test(priority = 34, description = "Caso 36")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad botón \"Cancelar\" BONO DE PRENDA")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b36() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloGuardar"))
		.SeleccionarCodigoTitulo().BonoPrenda().ScrollAbajo();
		Prorrogas.PlazoDeposito(getProperties().getProperty("NumeroDias")).PlazoCredito(getProperties().getProperty("NumeroDias"))
		.PlazoCertificado(getProperties().getProperty("NumeroDias")).BotonCancelar();
		home.Exit();
		
	}
	
	@Test(priority = 36, description = "Caso 37")
	@Severity(SeverityLevel.NORMAL)
	@Description("Valida paginado \"Bono de prenda\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b37() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloGuardar"))
		.SeleccionarCodigoTitulo().BonoPrenda().ScrollAbajo();
		Prorrogas.PlazoDeposito(getProperties().getProperty("NumeroDias")).PlazoCredito(getProperties().getProperty("NumeroDias"))
		.PlazoCertificado(getProperties().getProperty("NumeroDias")).ScrollAbajo().Paginacion().ScrollArriba().Screenshot();
		home.Exit();

	}
	
	@Test(priority = 37, description = "Caso 38")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Certificado deposito de mercancía \"se encabezado \"Certificado de deposito mercancía\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b38() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ExpedirCrear.Titulo().Expedir();
		ExpedirConsultar.ConsultaTitulo().TextoBuscar(getProperties().getProperty("tituloCertificado")).BotonBuscar();
		ExpedirModificar.ScrollDerecha();
		Prorrogas.Prorrogar().CodigoTitulo(getProperties().getProperty("tituloCertificado"))
		.SeleccionarCodigoTitulo();
		ValidacionProrrogas.ValidarCertificado("Certificado de depósito mercancía");
		Prorrogas.CDM();
		home.Exit();

	}
		
	@Test(priority = 38, description = "Caso 39")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Certificado deposito de mercancía\" funcionalidad campo \"Días\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b39 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloCertificado"))
		.SeleccionarCodigoTitulo().CDM();
		ValidacionProrrogas.ValidarDias("Días");
		home.Exit();
		
	}
	
	@Test(priority = 39, description = "Caso 40")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Certificado deposito de mercancía\" funcionalidad campo \"Nueva fecha\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b40() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloCertificado"))
		.SeleccionarCodigoTitulo().CDM();
		ValidacionProrrogas.ValidarNuevaFecha("Nueva Fecha");
		home.Exit();

	}
//////////////////////////////	

	@Test(priority = 40, description = "Caso 41")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en prórroga para tipo de titulo \"Certificado deposito de mercancía\" funcionalidad campo \"Fecha de deposito\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b41() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Prorrogas.Titulo().Prorrogar().CodigoTitulo(getProperties().getProperty("tituloCertificado"))
		.SeleccionarCodigoTitulo().CDM();
		ValidacionProrrogas.ValidarFechaDeposito("Fecha de depósito:");
		home.Exit();

	}
	


	}*/
	
}