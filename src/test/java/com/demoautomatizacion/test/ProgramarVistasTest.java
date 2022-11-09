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
@Epic("Programar Visitas")
@Feature("Programar Visitas Test")

public class ProgramarVistasTest extends BaseTest {

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(ConsultarRegistroVisitaTest.class.getName());
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/ProgramarVisitas.properties").getAbsolutePath()));
		return fileprops;
	}

	/*@Test(priority = 0, description = "Caso 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar modulo de Visitas / Programación a la persona que tenga el rol y que su perfil lo permita.")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b1() throws Exception {	

		System.setProperty("testname", nomClass);

		log.info("INICIA LA EJECUCION DE LA CLASE "+nomClass);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 1, description = "Caso 2")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  la opción “programar visita”")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b2() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 2, description = "Caso 3")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que se muestre el encabezado \"Programar visitas\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b3() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar();
		ValidacionProgramarVisitas.ValidarCaso3("Programar Visitas");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 3, description = "Caso 4")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “programar” se muestre nombre de campo \"Bodega\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b4() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar();
		ValidacionProgramarVisitas.ValidarCaso4("Bodega");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 4, description = "Caso 5")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “programar” se muestre nombre de campo \"Cliente\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b5() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar();
		ValidacionProgramarVisitas.ValidarCaso5("Cliente");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 5, description = "Caso 6")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “programar” se muestre nombre de campo \"Agendar\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b6() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar();
		ValidacionProgramarVisitas.ValidarCaso6("Agendar");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 6, description = "Caso 7")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “programar” se muestre nombre de campo \"Si\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b7() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar();
		ValidacionProgramarVisitas.ValidarCaso7();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 7, description = "Caso 8")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla \"programar\" campo \"Si\" permita fechas de visitas de lunes a viernes")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b8() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().Si().BotonCancelar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 8, description = "Caso 9")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla \"programar\" campo \"Si\"  no permita ver agendar")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b9() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().Si().BotonCancelar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 9, description = "Caso 10")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla \"programar\" campo \"Si\"  permita seleccionar mínimo una fecha")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b10() throws Exception {
	}
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().Si().SelectFecha().Guardar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
	
	@Test(priority = 10, description = "Caso 11")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “programar” se muestre nombre de campo \"No\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b11() throws Exception {
	}
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar();
		ValidacionProgramarVisitas.ValidarCaso11();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 11, description = "Caso 12")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “programar” se muestre nombre de campo \"Fecha\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b12() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));;
		ProgramarVisitas.Visitas().Programar().BotonProgramar();
		ValidacionProgramarVisitas.ValidarCaso12("Fecha");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 12, description = "Caso 13")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “programar” se muestre nombre de campo \"Fecha\" cuando se ha seleccionado \"Agendar/Si\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b13() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().Si().SelectFecha().Guardar();
		ValidacionProgramarVisitas.ValidarCaso12("Fecha");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 13, description = "Caso 14")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “programar” se muestre nombre de campo \"Fecha\" cuando se ha seleccionado \"Agendar/No\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b14() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().No();
		ValidacionProgramarVisitas.ValidarCaso12("Fecha");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
		
	}

	@Test(priority = 14, description = "Caso 15")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar condiciones de agendamiento")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b15() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().Si().SelectFecha().Guardar().No()
		.Si().SelectFecha1().SelectFecha2().Guardar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
		
	}

	@Test(priority = 15, description = "Caso 16")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar la funcionalidad del botón guardar")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b16() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().Si().SelectFecha2().Guardar().ScrollAbajo1()
		.Evidencias().Guardar1().BotonCancelar1();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");		
	}

	@Test(priority = 16, description = "Caso 17")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad de los botones \"Aceptar\"  y \"Cancelar\" de la ventana emergente")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b17() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().Si().SelectFecha2().Guardar().ScrollAbajo1()
		.Evidencias().Guardar1().BotonCancelar1().Guardar1().Aceptar();
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 17, description = "Caso 18")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del botón Cancelar")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b18() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().Si().SelectFecha2().Guardar().ScrollAbajo1()
		.Evidencias().BotonCancelar2();
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 18, description = "Caso 19")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar notificación de Visitas")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b19() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 19, description = "Caso 20")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “consultar” se muestre encabezado \"Consultar agenda\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b20() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar();
		ValidacionProgramarVisitas.ValidarCaso20("Consultar Agenda");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 20, description = "Caso 21")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “consultar” la estructura de Bodega, Cliente, fecha")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b21() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar();
		ValidacionProgramarVisitas.ValidarCaso21();
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 21, description = "Caso 22")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “consultar” Bodega, Cliente, fecha sean campos no editables.")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b22() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().Evidencias();
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 22, description = "Caso 23")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “consultar” se muestre nombre de campo \"Bodega\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b23() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar();
		ValidacionProgramarVisitas.ValidarCaso23("Bodega");
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 23, description = "Caso 24")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “consultar” se muestre nombre de campo \"Cliente\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b24() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar();
		ValidacionProgramarVisitas.ValidarCaso24("Cliente");
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 24, description = "Caso 25")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la grilla “consultar” se muestre nombre de campo \"Fecha\"")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b25() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar();
		ValidacionProgramarVisitas.ValidarCaso25("Fecha");
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 25, description = "Caso 26")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar la funcionalidad del botón Regresar")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b26() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().Regresar();
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 26, description = "Caso 27")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar paginado")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b27() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().Paginacion();
		home.Exit();

		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
	
	@Test(priority = 27, description = "Caso 28")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar campos obligatorios")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b28() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		ProgramarVisitas.Visitas().Programar().BotonProgramar().ScrollAbajo1().Guardar1().Aceptar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 28, description = "Caso 29")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar LOG")
	@Story("Programar Visitas")
	@TmsLink("XRPRJ-1")
	public void b29() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Liberacion.Seguridad().LogAuditoria().FechaDesde().FechaHasta().ConsultarUsuario(getProperties().getProperty("usr"))
		.Buscar1().ScrollAbajo1().PaginacionLog().PaginacionLog1().ScrollDerecha1().Evidencia().ScrollArriba();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");

	}*/

}