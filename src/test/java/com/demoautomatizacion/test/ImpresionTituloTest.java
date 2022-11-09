package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.test.utils.Listeners.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Listeners({ TestListener.class })
@Epic("Imprimir")
@Feature("Imprimir Test")

public class ImpresionTituloTest extends BaseTest {

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(ImpresionTituloTest.class.getName());
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Impresion.properties").getAbsolutePath()));
		return fileprops;
	}
	
	/*@Test(priority = 1, description = "Caso 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el modulo expedición de titulos la funcionalidad “consultar”")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b1() throws Exception {	

		System.setProperty("testname", nomClass);

		log.info("INICIA LA EJECUCION DE LA CLASE "+nomClass);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarNIT()
				.IngreseConsulta(getProperties().getProperty("ConsultaNit"));
		ValidacionImpresion.ValidarCaso1();
		Impresion.ClearConsulta().SeleccionarNombreRazonSocial()
				.IngreseConsulta(getProperties().getProperty("ConsultaNombreRazonSocial"));
		ValidacionImpresion.ValidarCaso_1();
		Impresion.ClearConsulta().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("consultaTitulo"));
		ValidacionImpresion.ValidarCaso__1();
		Impresion.ClearConsulta().SeleccionarFecha()
		.IngreseConsulta(getProperties().getProperty("consultaFecha"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 2, description = "Caso 2")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en “consultar” se muestre nombre de campo \"Buscar\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b2() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir();
		ValidacionImpresion.ValidarCaso2();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 3, description = "Caso 3")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en “consultar” el campo \"Buscar\"la logintud sea de 50 caracteres y textbox")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b3() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarNIT()
		.IngreseConsulta(getProperties().getProperty("caracteres50"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 4, description = "Caso 4")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en “consultar” busqueda por \"Nit\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b4() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarNIT()
		.IngreseConsulta(getProperties().getProperty("ConsultaNit"));
		ValidacionImpresion.ValidarCaso1();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 5, description = "Caso 5")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en “consultar” busqueda por \"Nombre/Razón Social\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b5() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarNombreRazonSocial()
		.IngreseConsulta(getProperties().getProperty("ConsultaNombreRazonSocial"));
		ValidacionImpresion.ValidarCaso_1();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 6, description = "Caso 6")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en “consultar” busqueda por \"título\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b6() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("consultaTitulo"));
		ValidacionImpresion.ValidarCaso__1();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 7, description = "Caso 7")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en “consultar” busqueda por \"fecha\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b7() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarFecha()
		.IngreseConsulta(getProperties().getProperty("consultaFecha"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 8, description = "Caso 8")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en “consultar” para los campos alfanuméricos se inicie apartir del tercer carácter la consulta")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b8() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TercerAlfaCaracter")).ClearConsulta()
		.IngreseConsulta(getProperties().getProperty("tercerCaracter"));
		ValidacionImpresion.ValidarCaso8();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 9, description = "Caso 9")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Número de título\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b9() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir();
		ValidacionImpresion.ValidarCaso9(getProperties().getProperty("validarNumeroTitulo"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 10, description = "Caso 10")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"NIT\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b10() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir();
		ValidacionImpresion.ValidarCaso10(getProperties().getProperty("validarNit"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 11, description = "Caso 11")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Nombre/Razón social\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b11() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir();
		ValidacionImpresion.ValidarCaso11("Nombre/Razón social");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
		
	}

	@Test(priority = 12, description = "Caso 12")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Tipo de Bodega\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b12() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir();
		ValidacionImpresion.ValidarCaso12(getProperties().getProperty("validarTipoBodega"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 13, description = "Caso 13")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Tipo de título\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b13() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir();
		ValidacionImpresion.ValidarCaso13(getProperties().getProperty("validarTipoTitulo"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 14, description = "Caso 14")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Tipo de mercancía\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b14() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("consultaTitulo")).ScrollDerecha();
		ValidacionImpresion.ValidarCaso14(getProperties().getProperty("validarTipoMercancia"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 15, description = "Caso 15")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Valor de Mercancía\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b15() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("consultaTitulo")).ScrollDerecha();
		ValidacionImpresion.ValidarCaso15(getProperties().getProperty("validarValorMercancia"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 16, description = "Caso 16")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Estado de título\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b16() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("consultaTitulo")).ScrollDerecha();
		ValidacionImpresion.ValidarCaso16(getProperties().getProperty("validarEstado"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 17, description = "Caso 17")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Acción\" botón \"Ver\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b17() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("consultaTitulo")).ScrollDerecha();
		ValidacionImpresion.ValidarCaso17(getProperties().getProperty("validarAccion"));
		Impresion.EtiquetaVerTitulo();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 18, description = "Caso 18")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla el campo \"Acción\" botón \"Modificar\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b18() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("consultaTitulo")).ScrollDerecha();
		ValidacionImpresion.ValidarCaso17(getProperties().getProperty("validarAccion"));
		Impresion.EtiquetaModificarTitulo();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 19, description = "Caso 19")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla la opción \"Impresión\" para el titulo en estado “Gravado”")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b19() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha();
		Impresion.EtiquetaImprimirTitulo();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 20, description = "Caso 20")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla la opción \"Impresión\" marca de agua")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b20() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo().ImprimirTituloCMDA().Scape1().Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 21, description = "Caso 21")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar la impresión de titulo en estado \"Gravado\" varias veces")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b21() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo().ImprimirTituloCMDA().Scape1().ImprimirTituloBonoA().Scape1().ImprimirTituloTalonA().Scape1()
		.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 22, description = "Caso 22")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b22() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo().Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 23, description = "Caso 23")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Imprimir Borrador\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b23() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso23(getProperties().getProperty("validarImprimirBorrador"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 24, description = "Caso 24")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"CDM\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b24() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso24(getProperties().getProperty("ValidarCDM"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 25, description = "Caso 25")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara A de CDM\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b25() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso25();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 26, description = "Caso 26")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara B de CDM\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b26() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso26();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 27, description = "Caso 27")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Bono de prenda\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b27() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso27(getProperties().getProperty("ValidarBonoPrenda"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 28, description = "Caso 28")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara A de Bono de prenda\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b28() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso28();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 29, description = "Caso 29")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara B de Bono de prenda\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b29() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso29();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 30, description = "Caso 30")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Talón\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b30() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso30(getProperties().getProperty("ValidarTalon"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 31, description = "Caso 31")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara A de Talón\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b31() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso31();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 32, description = "Caso 32")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara B de Talón\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b32() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso32();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 33, description = "Caso 33")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Salir\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b33() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		//Salir
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 34, description = "Caso 34")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar paginado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b34() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().ScrollAbajo1().PagSig().PagAtras().PagFinal().PagPrincipal().SelectPag()
		.ScrollAbajo1().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 35, description = "Caso 35")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la consulta todos lo campos de la grilla se pueda ordenar de menor a mayor o viceversa")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b35() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().OrdenarNT().OrdenarNT().OrdenarNT().OrdenarNIT().OrdenarNIT().OrdenarNIT()
		.OrdenaNRS().OrdenaNRS().OrdenaNRS().OrdenaTB().OrdenaTB().OrdenaTB().OrdenaTT().OrdenaTT().OrdenaTT()
		.ScrollAbajo1().ScrollDerecha1().ScrollArriba1().OrdenaTM().OrdenaTM().OrdenaTM().OrdenaVM().OrdenaVM()
		.OrdenaVM().OrdenaET().OrdenaET().OrdenaET();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
	
	@Test(priority = 36, description = "Caso 36")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en resultado de la consulta en la grilla la opción \"Impresión\" para el titulo en estado “Aplicado”")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b36() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 37, description = "Caso 37")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar la impresión de titulo en estado \"Aplicado\" una única vez")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b37() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo().ImprimirTituloCMDA().AceptarBonoA().Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}


	@Test(priority = 38, description = "Caso 38")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente en estado \"Aplicado\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b38() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo().Scape();
		home.Exit()

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 39, description = "Caso 39")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en pantalla emergente el campo \"Imprimir Original\"")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b39() throws Exception {
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
	
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso23(getProperties().getProperty("validarImprimirOriginal"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 40, description = "Caso 40")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en pantalla emergente el campo \"CDM\" - Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b40() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso24(getProperties().getProperty("ValidarCDM"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 41, description = "Caso 41")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara A de CDM\"  - Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b41() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso25();
		Impresion.Scape();
		home.Exit()

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 42, description = "Caso 42")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara B de CDM\"  - Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b42() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso26();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
///////////
	@Test(priority = 43, description = "Caso 43")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Bono de prenda\"  - Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b43() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso27(getProperties().getProperty("ValidarBonoPrenda"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 44, description = "Caso 44")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara A de Bono de prenda\" - Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b44() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso28();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 45, description = "Caso 45")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara B de Bono de prenda\"- Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b45() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso29();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 46, description = "Caso 46")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Talón\" - Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b46() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso30(getProperties().getProperty("ValidarTalon"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 47, description = "Caso 47")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara A de Talón\" - Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b47() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso31();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 48, description = "Caso 48")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Cara B de Talón\" - Titulo estado aplicado")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b48() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso32();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 49, description = "Caso 49")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Impresión\" pantalla emergente el campo \"Salir\"(título original)")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b49() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		//Salir
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 50, description = "Caso 50")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que aparezca el botón de imprimir borrador a los títulos en estado “Gravado”")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b50() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloGravado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso23(getProperties().getProperty("validarImprimirBorrador"));
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 51, description = "Caso 51")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que aparezca el botón de imprimir original a los títulos en estado “Aplicado”")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b51() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo();
		ValidacionImpresion.ValidarCaso23(getProperties().getProperty("validarImprimirOriginal"));
		Impresion.ImprimirTituloBonoA().AceptarBonoA();
		Impresion.Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 52, description = "Caso 52")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que no permita la impresión de borrador para los títulos en ninguno de los otros estados (Incompleto, Cancelado, Anulado, Aplicado)")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b52() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloIncompleto")).ScrollDerecha2().ClearConsulta()
		.IngreseConsulta(getProperties().getProperty("TituloCancelado")).ScrollDerecha2().ClearConsulta()
		.IngreseConsulta(getProperties().getProperty("TituloAnulado")).ScrollDerecha2();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 53, description = "Caso 53")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que no permita la impresión de original para los títulos en ninguno de los otros estados (Incompleto, Cancelado, Anulado, Gravado)")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b53() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloIncompleto")).ScrollDerecha2().ClearConsulta()
		.IngreseConsulta(getProperties().getProperty("TituloCancelado")).ScrollDerecha2().ClearConsulta()
		.IngreseConsulta(getProperties().getProperty("TituloAnulado")).ScrollDerecha2();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 54, description = "Caso 54")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en ventana emergente de imprimir, si ya fue impreso el titulo original para los titulos en estado aplicado validar mensaje de alerta.")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b54() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Impresion.Titulo().Expedir().SeleccionarTitulo()
		.IngreseConsulta(getProperties().getProperty("TituloAplicado")).ScrollDerecha().EtiquetaImprimirTitulo()
		.ImprimirTitulo().ImprimirTituloBonoA();
		ValidacionImpresion.ValidarResultadoImpresion("Cara A de títulos ya se imprimió");
		Impresion.AceptarBonoA().Scape();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
		
	}

	@Test(priority = 55, description = "Caso 55")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar Log")
	@Story("Expedir Título")
	@TmsLink("XRPRJ-1")
	public void b55() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Liberacion.Seguridad().LogAuditoria().FechaDesde().FechaHasta().ConsultarUsuario(getProperties().getProperty("usr"))
		.Buscar1().ScrollAbajo1().PaginacionLog().PaginacionLog1().ScrollDerecha1().ScrollArriba();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}*/

	
}