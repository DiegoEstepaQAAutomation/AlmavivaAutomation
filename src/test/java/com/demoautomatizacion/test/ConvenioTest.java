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
@Epic("Convenio")
@Feature("Convenio Test")

public class ConvenioTest extends BaseTest {

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(ConvenioTest.class.getName());
	
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Convenio.properties").getAbsolutePath()));
		return fileprops;
	}

	/*@Test(priority = 0, description = "Caso 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la opción de convenios solo se muestre a la persona que tenga el rol y el perfil que lo permita")
	@Story("Convenio Funcionalidad Opciones Menú")
	@TmsLink("XRPRJ-1")
	public void a1() throws Exception {
	

		System.setProperty("testname", nomClass);

		log.info("INICIA LA EJECUCION DE LA CLASE "+nomClass);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio();
		validacionConvenios.ValidarCaso1(getProperties().getProperty("resultadoRolPerfil"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 1, description = "Caso 2")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que se pueda crear un convenio desde la opción \"Cliente-Convenio\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a2() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitCrearConvenio"))
				.SeleccionarNitRazonSocialCrear().ValorImpresion(getProperties().getProperty("valorImpresion"))
				.AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("fijaPorcentaje"))
				.ParticularArrendada().Propia().FormaDeCobroFijaPropia(getProperties().getProperty("fijaPorcentaje"))
				.Propia().Transito().FormaDeCobroFijaTransito(getProperties().getProperty("fijaPorcentaje")).Transito()
				.Particular().FormaDeCobroFijaParticular(getProperties().getProperty("fijaPorcentaje")).Particular()
				.AplicaMinimaSi().AplicaMinimaValorMinima(getProperties().getProperty("valorMinima")).Scroll()
				.BotonGuardar().ValidarResultadoCrearConvenio(getProperties().getProperty("ResultadoCrearConvenio"))
				.CrearConvenioAceptar();
				
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 2, description = "Caso 3")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que al dar clic en la opción de crear convenio se muestre un formulario")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a3() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 3, description = "Caso 4")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el campo \"crear convenio\" tipo de campo \"label\" donde aparece la información del nombre para identificar el modulo")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a4() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 4, description = "Caso 5")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación el campo \"Buscar\" tipo de campo Text box , con longitud de 50 caracteres")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a5() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("caracteres50"))
				.ClearNitCrear().RazonSocialCrear(getProperties().getProperty("caracteres50"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 5, description = "Caso 6")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Buscar\" deba mostrar un campo de filtro de busqueda que permita buscar clientes por : NIT")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a6() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 6, description = "Caso 7")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Buscar\" deba mostrar un campo de filtro de busqueda que permita buscar clientes por : Nombre/Razón Social")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a7() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 7, description = "Caso 8")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el filtro de busqueda inicie apartir del 3 Carácter")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a8() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitTercerCaracter"))
				.ClearNitCrear().RazonSocialCrear(getProperties().getProperty("razonSocialTercerCaracter"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 8, description = "Caso 9")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que si no existen registros debe mostrar un mensaje en la parte inferior del campo indicando el siguiente mensaje “No existen registros para la búsqueda”. La consulta debe ser a partir de los clientes con asignación de cupo")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a9() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("buscarNitNoExitoso"))
				.ClearNitCrear().RazonSocialCrear(getProperties().getProperty("buscarRazonSocialNoExitoso"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
		}
	}

	@Test(priority = 9, description = "Caso 10")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación el campo \\\"NIT\\\" , tipo de campo \\\"TextBox\\\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a10() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 10, description = "Caso 11")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación el campo \"NIT\" sea un campo obligatorio")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a11() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 11, description = "Caso 12")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"NIT\"  es traido automaticamente del sistema al seleccionar de la busqueda el cliente deseado NO EDITABLE")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a12() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear();
		home.Exit();		
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 12, description = "Caso 13")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación el campo \"Nombre/Razón social\" , tipo de campo \"TextBox\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a13() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 13, description = "Caso 14")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación el campo \"Nombre/Razón social\" debe ser obligatorio")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a14() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 14, description = "Caso 15")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación el campo \"Nombre/Razón social\"  es traido automaticamente del sistema al seleccionar de la busqueda el cliente deseado NO EDITABLE")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a15() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
	
	@Test(priority = 15, description = "Caso 16")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación  el campo \"Valor Impresión Juego Prendario\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a16() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 16, description = "Caso 17")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Valor Impresión Juego Prendario\" sea un tipo campo \"TextBox\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a17() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().ValorImpresion(getProperties().getProperty("valorImpresion"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 17, description = "Caso 18")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"valor Impresión Juego Prendario\" sea un campo obligatorio")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a18() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().ValorImpresion("").RazonSocialCrear("");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 18, description = "Caso 19")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"valor Impresión Juego Prendario\" sea un campo Tipo numérico y este tenga el signo $ y separador de miles (EDITABLE) (Regla de negocio: solo se cobra al momento de \"aplicar un titulo\")")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a19() throws Exception 

		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().ValorImpresion(getProperties().getProperty("valorImpresion"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 19, description = "Caso 20")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación el campo \"Aplica Cobro por Modalidad\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a20() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 20, description = "Caso 21")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Aplica Cobro por Modalidad\" sea un tipo de campo ListBox")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a21() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobro();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 21, description = "Caso 22")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Aplica Cobro por Modalidad\"  sea un campo obligatorio")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a22() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobro().ClickValorImpresion();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 22, description = "Caso 23")
	@Severity(SeverityLevel.NORMAL)
	@Description("alidar que el campo \"Aplica Cobro por Modalidad\"  permita seleccionar la opción \"Si/No\" (EDITABLE)")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a23() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobro().AplicaCobroSi().AplicaCobroNo();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 23, description = "Caso 24")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que al escoger en el campo \"Aplica Cobro por Modalidad\" del formulario de creación la opción \"Si\" se debe mostrar bajo el campo anterior en tipo acordeón los tipos de bodegas que se tienen configurado para ese cliente en la asignación de cupo")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a24() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 24, description = "Caso 27")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que cada Bodega contenga el campo \"Seleccione forma de cobro\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a27() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada().ParticularArrendada()
				.Propia().Propia().Transito().Transito().Particular().Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 25, description = "Caso 28")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario creación que el campo \"Seleccione forma de cobro \"  sea un tipo de campo listBox")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a28() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.SeleccioneFormaDeCobroParticularArrendada().ParticularArrendada().Propia()
				.SeleccioneFormaDeCobroPropia().Propia().Transito().SeleccioneFormaDeCobroTransito().Transito()
				.Particular().SeleccioneFormaDeCobroParticular().Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 26, description = "Caso 29")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo  \"Seleccione forma de cobro \"  sea un campo obligatorio")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a29() throws Exception 
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);

		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.SeleccioneFormaDeCobroParticularArrendada().ValorImpresion("");
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 27, description = "Caso 30")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el campo  \"Seleccione forma de cobro \"  permita seleccionar la opción \"Fija/Escalonada\" (EDITABLE)")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a30() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada("").FormaDeCobroEscalonadaParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 28, description = "Caso 31")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que cada Bodega contenga el campo \"Fija\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a31() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada("").ParticularArrendada().Propia().FormaDeCobroFijaPropia("")
				.Propia().Transito().FormaDeCobroFijaTransito("").Transito().Particular().FormaDeCobroFijaParticular("")
				.Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 29, description = "Caso 32")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Fija\" sea un tipo de campo TextBox")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a32() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("numeroTextBox"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");

	}

	@Test(priority = 30, description = "Caso 33")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario creación que el campo \"Fija\" tenga una longitud de 5")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a33() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("numeroTextBox"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 31, description = "Caso 34")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Fija\" sea un campo obligatorio , solo se mostrara si la forma de pago seleccionada fue Fija")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a34() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada("").ClickValorImpresion();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 32, description = "Caso 35")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario campo Fija sea un campo tipo númerico con formato en %")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a35() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("caracterTextBox"))
				.ClearFormaDeCobroFijaParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("fijaCampo5"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 33, description = "Caso 36")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que cada Bodega contenga el campo \"Escalonada\" en el formulario de creación")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a36() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroEscalonadaParticularArrendada().ParticularArrendada().Propia()
				.FormaDeCobroEscalonadaPropia().Propia().Transito().FormaDeCobroEscalonadaTransito().Transito()
				.Particular().FormaDeCobroEscalonadaParticular().Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 34, description = "Caso 37")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar formulario campo Escalonada sea tipo campo Grilla")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a37() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.SeleccioneFormaDeCobroParticularArrendada().FormaDeCobroEscalonadaParticularArrendada().Scroll()
				.Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 35, description = "Caso 38")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Escalonada\" sea un campo obligatorio,solo se mostrara si la forma de pago seleccionada fue Escalonada")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a38() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroEscalonadaParticularArrendada().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 36, description = "Caso 39")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la grilla debe tener la opción de agregar y eliminar líneas las cuales debe estar edificadas con la letra R + el número de la línea")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a39() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroEscalonadaParticularArrendada().EscalonadaAgregarRango().Scroll().EscalonadaEliminar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 37, description = "Caso 40")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la grilla tenga el campo \"Rangos\" Esta columna contiene dos columnas adicionales - LI: Tipo numérico con formato en $. - LF: Tipo numérico con formato en $, debe ser mayor al LI")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a40() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroEscalonadaParticularArrendada().Scroll()
				.DatosEscalonadaPrimeraFila(getProperties().getProperty("R1LI"), getProperties().getProperty("R1LF"),
						getProperties().getProperty("valor"))

				.DatosEscalonadaSegundaFila(getProperties().getProperty("R2LI"), getProperties().getProperty("R2LF"),
						getProperties().getProperty("valor"));

		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 38, description = "Caso 41")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la grilla tenga el campo \"Valor\" Tipo númerico, longitud 5 y con formato en %")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a41() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroEscalonadaParticularArrendada().Scroll()
				.DatosEscalonadaPrimeraFila(getProperties().getProperty("R1LI"), getProperties().getProperty("R1LF"),
						getProperties().getProperty("valorAlfanumerico"))

				.DatosEscalonadaSegundaFila(getProperties().getProperty("R2LI"), getProperties().getProperty("R2LF"),
						getProperties().getProperty("valorAlfanumerico"));

		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 39, description = "Caso 42")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la forma de pago \"Escalonada\" debe tener como minimo dos rangos ")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a42() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroEscalonadaParticularArrendada().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 40, description = "Caso 43")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que muestre el campo \\\" Aplica minima\\\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a43() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 41, description = "Caso 44")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Aplica minima\" sea un tipo de campo ListBox")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a44() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().Scroll().AplicaMinima();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 42, description = "Caso 45")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \\\"Aplica minima\\\" sea un campo obligatorio")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a45() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().Scroll().AplicaMinima().Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 43, description = "Caso 46")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario creación que en esa lista desplegable de deben mostrar las opciones \"Si/No\" (EDITABLE)")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a46() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().Scroll().AplicaMinima().AplicaMinimaSi()
				.AplicaMinimaNo();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 44, description = "Caso 47")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que muestre el campo \"Si\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a47() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().Scroll().AplicaMinimaSi();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 45, description = "Caso 48")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Si\" sea un tipo de campo textBox")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a48() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().Scroll().AplicaMinimaSi()
				.AplicaMinimaValorMinima(getProperties().getProperty("valorMinima"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 46, description = "Caso 49")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación que el campo \"Si\" sea un campo obligatorio  (solo se mostrar este campo si la selección del campo anterior fue si, debe ser un campo numérico, con separador de miles y con formato en $. Editable)")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a49() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroNo().AplicaMinimaSi()
				.AplicaMinimaValorMinima(getProperties().getProperty("valorMinima")).ClearAplicaMinimaValorMinima()
				.ClickValorImpresion().AplicaMinimaValorMinima("").ClickValorImpresion();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 47, description = "Caso 50")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que en la parte inferior aparezcan los botones \"Guardar\" \"Cancelar\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a50() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.RazonSocialCrear(getProperties().getProperty("razonSocialConvenioPrueba"))
				.SeleccionarNitRazonSocialCrear().AplicaCobroSi().Scroll().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 48, description = "Caso 51")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que Si el usuario da clic en la opción  \"Guardar\", el sistema muestre  una ventana emergente con el siguiente mensaje: “Está seguro de guardar el registro?”")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a51() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.NitCrear(getProperties().getProperty("nitCrearConvenioPrueba")).SeleccionarNitRazonSocialCrear()
				.ValorImpresion(getProperties().getProperty("valorImpresion")).AplicaCobroSi().Scroll()
				.ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("fijaPorcentaje"))
				.ParticularArrendada().Propia().FormaDeCobroFijaPropia(getProperties().getProperty("fijaPorcentaje"))
				.Propia().Transito().FormaDeCobroFijaTransito(getProperties().getProperty("fijaPorcentaje")).Transito()
				.Particular().FormaDeCobroFijaParticular(getProperties().getProperty("fijaPorcentaje")).Particular()
				.AplicaMinimaSi().AplicaMinimaValorMinima(getProperties().getProperty("valorMinima")).Scroll()
				.BotonGuardar().ValidarResultadoCrearConvenio(getProperties().getProperty("ResultadoCrearConvenio"));
				
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 49, description = "Caso 52")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que al mostrar el mensaje y dar clic en el botón \"Aceptar\" la información se guarda en la BD y muestra el siguiente mensaje \"el registro se ha guardado\"")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a52() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio().NitCrear(getProperties().getProperty("nitCrearConvenio1"))
				.SeleccionarNitRazonSocialCrear().ValorImpresion(getProperties().getProperty("valorImpresion"))
				.AplicaCobroSi().Scroll().ParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("fijaPorcentaje"))
				.ParticularArrendada().Propia().FormaDeCobroFijaPropia(getProperties().getProperty("fijaPorcentaje"))
				.Propia().Transito().FormaDeCobroFijaTransito(getProperties().getProperty("fijaPorcentaje")).Transito()
				.Particular().FormaDeCobroFijaParticular(getProperties().getProperty("fijaPorcentaje")).Particular()
				.AplicaMinimaSi().AplicaMinimaValorMinima(getProperties().getProperty("valorMinima")).Scroll()
				.BotonGuardar().ValidarResultadoCrearConvenio(getProperties().getProperty("ResultadoCrearConvenio"))
				.CrearConvenioAceptar();
				
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 50, description = "Caso 54")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que si se selecciona el botón \"Cancelar\" regresa a la ventana de creación con la información del formulario")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a54() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.NitCrear(getProperties().getProperty("nitCrearConvenioPrueba")).SeleccionarNitRazonSocialCrear()
				.ValorImpresion(getProperties().getProperty("valorImpresion")).AplicaCobroNo().AplicaMinimaNo().Scroll()
				.BotonCancelar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 51, description = "Ccaso 55")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que se visualice el campo \"Cancelar\"  y que este sea de tipo botón")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a55() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.NitCrear(getProperties().getProperty("nitCrearConvenioPrueba")).SeleccionarNitRazonSocialCrear();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 52, description = "Ccaso 56")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que si el usuario da clic en la opción  \"Cancelar\",debe limpiar la información de los campos y regresar al HOME del sistema.")
	@Story("Convenio Funcionalidad Crear")
	@TmsLink("XRPRJ-1")
	public void a56() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonCrearConvenio()
				.NitCrear(getProperties().getProperty("nitCrearConvenioPrueba")).SeleccionarNitRazonSocialCrear()
				.Scroll().Scroll().BotonCancelar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 53, description = "Caso 59")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que si el usuario da clic en \"Consultar\" convenio , el sistema deba mostrar un formulario")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a59() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 54, description = "Caso 60")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta un campo \" Consultar cliente\"")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a60() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 55, description = "Caso 61")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta que el campo \"Consultar cliente\" sea un campo tipo label")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a61() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 56, description = "Caso 62")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta que en el campo \"Consultar cliente\"aparece la información del nombre para identificar el módulo.")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a62() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso62(getProperties().getProperty("resultadoFormularioConsultarNIT"),
				getProperties().getProperty("resultadoFormularioConsultarNombreRazonSocial"),
				getProperties().getProperty("resultadoFormularioConsultarValorImpresion"),
				getProperties().getProperty("resultadoFomularioConsultarAplicaCobro"),
				getProperties().getProperty("resultadoFormularioConsultarAplicaMinima"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 57, description = "Caso 63")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta que el campo \"Buscar\" sea un campo tipo TextBox")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a63() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().NitBuscar(getProperties().getProperty("numeroTextBox")).ClearNitBuscar()
				.RazonSocialBuscar(getProperties().getProperty("caracterTextBox"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 58, description = "Caso 64")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta que el campo \"Buscar\" tenga una longitud de 50 caracteres")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a64() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().NitBuscar(getProperties().getProperty("numericos50")).ClearNitBuscar()
				.RazonSocialBuscar(getProperties().getProperty("caracteres50"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 59, description = "Caso 65")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de consulta que el campo \" Buscar\" mostrar un campo de filtro de búsqueda que permita buscar clientes por NIT o Nombre o Razón Social, el filtro de búsqueda debe iniciar a partir del tercer carácter")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a65() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().NitBuscar(getProperties().getProperty("nitTercerCaracterBuscar"))
				.ClearNitBuscar().RazonSocialBuscar(getProperties().getProperty("razonSocialTercerCaracterBuscar"));
		validacionConvenios.ValidarCaso65();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 60, description = "Caso 66")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de consulta que si en el campo \"Buscar\"  no existen registros debe mostrar un mensaje en la parte inferior del campo indicando el siguiente mensaje “No existen registros para la búsqueda”")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a66() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().NitBuscar(getProperties().getProperty("buscarNitNoExitoso"));
		validacionConvenios
				.ValidarCaso66(getProperties().getProperty("resultadoNiExitenRegistrosParaLaBusquedaBuscar"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 61, description = "Ccaso 67")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que en la parte inferior de la busqueda debe aparecer una grilla de información con el campo \" NIT\" Trae la información del tipo de tercero almacenado")
	@Story("Convenio Funcionalidad Buscar")
	@TmsLink("XRPRJ-1")
	public void a67() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion();
		validacionConvenios.ValidarCaso67();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
		
	}

	@Test(priority = 62, description = "Caso 68")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que  en el formulario de consulta el campo \"NIT\" debe permitir ordenar de menor a mayor o viceversa.")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a68() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().OrdenarNit().OrdenarNit().OrdenarNit().OrdenarNit();
		validacionConvenios.ValidarCaso68();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 63, description = "Caso 69")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta el campo \"Nombre/Razon Social\" (label) el cual debe traer información del Nombre /Razón social del cliente")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a69() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().RazonSocialBuscar(getProperties().getProperty("razonSocialConvenioBuscar"));
		validacionConvenios.ValidarCaso69(getProperties().getProperty("resultadoCampoLabelRazonSocial"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 64, description = "Caso 70")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que  en el formulario de consulta el campo \"Nombre/Razon Social\"  debe permitir ordenar de menor a mayor o viceversa.")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a70() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().RazonSocialBuscar("").OrdenarRazonSocial().OrdenarRazonSocial()
				.OrdenarRazonSocial().OrdenarRazonSocial();
		validacionConvenios.ValidarCaso70();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 65, description = "Caso 71")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta el campo \"Acción\" (label) el cual debe mostrar icono de ver o modificar, de acuerdo al rol y perfil asignado al usuario que realice la consulta")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a71() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().EtiquetaVer().EtiquetaModificar().BotonModificar().BotonCancelarModificar()
				.BotonVerDetalle().BotonRegresarVerDetalle();
		validacionConvenios.ValidarCaso71(getProperties().getProperty("resultadoCampoLabelAccion"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 66, description = "Caso 72")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que al seleccionar la opción ver se evidencie el campo \"NIT\" tipo de campo textBox en el formulario de consulta")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a72() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().EtiquetaVer().BotonVerDetalle();
		validacionConvenios.ValidarCaso72();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 67, description = "Caso 73")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el campo \"NIT\" sea un campo obligatorio en el formulario de consulta")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a73() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso73();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 68, description = "Caso 74")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el campo \"NIT\" es traído automáticamente del sistema al seleccionar de la búsqueda el cliente deseado. NO EDITABLE en el formulario de consulta")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a74() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso74();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 69, description = "Caso 75")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de consulta el campo \"Nombre/Razon Social\" y este debe ser  tipo de campo textbox")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a75() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso75();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 70, description = "Caso 76")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de consulta el campo \"Nombre/Razon Social\" debe ser obligatorio")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a76() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso76();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 71, description = "Caso 77")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de consulta el campo \"Nombre/Razon Social\" es traído automáticamente del sistema al seleccionar de la búsqueda el cliente deseado NO EDITABLE")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a77() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso77();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 72, description = "Caso 78")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta el campo \"Valor impresión Juego Prendario\" (label) con tipo de campo TextBox")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a78() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 73, description = "Caso 79")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario  de consulta el campo \"valor Impresión Juego Prendario\" sea un campo obligatorio")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a79() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso79();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 74, description = "Caso 80")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario consulta el campo \"valor Impresión Juego Prendario\" sea un campo Tipo numérico y este tenga el signo $ y separador de miles (NO EDITABLE)")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a80() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso80();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 75, description = "Caso 81")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario consulta el campo \"Aplica Cobro por Modalidad\" sea un tipo de campo ListBox")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a81() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso81();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 76, description = "Caso 83")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que al seleccionar \"Si\" del campo \"Aplica cobro por modalidad\", debe mostrar bajo el campo anterior en tipo acordeón los tipos de bodegas que se tienen configurado para ese cliente en la asignación de cupo (Formulario de consulta)")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a83() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 80, description = "Caso 87")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la bodega contenga en el formulario de consulta el campo \"Seleccione forma de cobro\"  con tipo de campo listbox")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a87() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().ParticularArrendada()
				.SeleccioneFormaDeCobroParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 81, description = "Caso 88")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que en el formulario de consulta el campo \"Seleccione forma de cobro\" sea un campo obligatorio")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a88() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().ParticularArrendada()
				.SeleccioneFormaDeCobroParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
	
	@Test(priority = 82, description = "Caso 89")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que en el formulario de consulta el campo \"Seleccione forma de cobro\" permita seleccionar la opción \"Fija/Escalonada\" NO EDITABLE")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a89() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().ParticularArrendada().Scroll().Scroll()
				.BotonRegresarVerDetalle().BotonVerDetalleBuscar2().Propia().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 83, description = "Caso 90")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que cada Bodega contenga el campo \"Fija\" en el formulario de consulta")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a90() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().Scroll().ParticularArrendada().ParticularArrendada()
				.Propia().Propia().Transito().Transito().Particular().Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 84, description = "Caso 94")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario creación  el campo \"Fija\" sea un campo tipo númerico con formato en % (NO EDITABLE)")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a94() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().Scroll().ParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 85, description = "Caso 95")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que cada Bodega contenga el campo \"Escalonada\" en el formulario de consulta")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a95() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll().ParticularArrendada().ParticularArrendada()
				.Propia().Propia().Transito().Transito().Particular().Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 86, description = "Caso 96")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta  el campo \"Escalonada\" sea un tipo de campo Grilla")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a96() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll().ParticularArrendada().ParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 87, description = "Caso 97")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta el campo \"Escalonada\" sea un campo obligatorio,solo se mostrara si la forma de pago seleccionada fue Escalonada")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a97() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll().Propia().Propia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 88, description = "Caso 98")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar grilla debe tener la opción de agregar  líneas las cuales debe estar edificadas con la letra R + el número de la línea")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a98() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll().ParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 89, description = "Caso 99")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la grilla tenga el campo \"Rangos\" Esta columna contiene dos columnas adicionales - LI: Tipo numérico con formato en $. - LF: Tipo numérico con formato en $, debe ser mayor al LI")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a99() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar3().Scroll().ParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 90, description = "Caso 100")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la grilla tenga el campo \"Valor\" Tipo numerico, longitud 5 y con formato en % (para el formulario de consulta)")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a100() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar3().Scroll().ParticularArrendada();
		validacionConvenios.ValidarCaso100();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 91, description = "Caso 101")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la forma de pago \"Escalonada\" debe tener como minimo dos rangos   (para el formulario de consulta)")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a101() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll().ParticularArrendada().ParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 92, description = "Caso 102")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario  de consulta muestre el campo \" Aplica minima\"")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a102() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 93, description = "Caso 103")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta el campo \"Aplica minima\" sea un tipo de campo ListBox")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a103() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().BotonRegresarVerDetalle().BotonVerDetalleBuscar2()
				.Scroll().AplicaMinima();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 94, description = "Caso 104")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta el campo \"Aplica minima\" sea un campo obligatorio")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a104() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().BotonRegresarVerDetalle().BotonVerDetalleBuscar2()
				.Scroll();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 95, description = "Caso 105")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de consulta en esa lista desplegable se deben mostrar las opciones \"Si/No\" (NO EDITABLE)")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a105() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().BotonRegresarVerDetalle().BotonVerDetalleBuscar2()
				.Scroll().AplicaMinima();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 96, description = "Caso 106")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta muestre el campo \"Si\"")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a106() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 97, description = "Caso 107")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta el campo \"Si\" sea un tipo de campo textBox")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a107() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 98, description = "Caso 108")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta el campo \"Si\" sea un campo obligatorio  (solo se mostrar este campo si la selección del campo anterior fue si)")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a108() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 99, description = "Caso 109")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de consulta  el campo \"Si\" sea un campo numérico, con separador de miles y con formato en $) NO EDITABLE")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a109() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalleBuscar2().Scroll();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 100, description = "Caso 110")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que en la parte inferior del formulario de consulta se visualicen los botónes \"Guardar\" \"Cancelar\"")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a110() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		validacionConvenios.ValidarCaso10(getProperties().getProperty("resultadoGuardarConsultar"),
				getProperties().getProperty("password"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 101, description = "Caso 111")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en la parte inferior del formulario consulta el campo \"regresar\" este debe ser tipó botón")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a111() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("resultadoCancelarConsultar"));
		Convenios.Convenio().Gestion().BotonVerDetalle();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 102, description = "Caso 112")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que al dar clic en la opción \"regresar\" debe volver a la pantalla de consulta")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a112() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonVerDetalle().BotonRegresarVerDetalle();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 103, description = "Caso 113")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar la grilla de consulta debe permitir ordenar campos de menor a mayor y viceversa en todas las columnas (si es visible la columna de Acción, ésta no es objeto de ordenamiento)")
	@Story("Convenio Funcionalidad Consulta")
	@TmsLink("XRPRJ-1")
	public void a113() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().OrdenarNit().OrdenarNit().OrdenarNit().OrdenarRazonSocial().OrdenarRazonSocial()
				.OrdenarRazonSocial();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 104, description = "Caso 114")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar filtro de búsqueda en la consulta de convenio debe permitir buscar por id cliente o Nombre")
	@Story("Convenio Funcionalidad Buscar")
	@TmsLink("XRPRJ-1")
	public void a114() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().NitBuscar(getProperties().getProperty("nitConvenioBuscar")).ClearNitBuscar()
				.RazonSocialBuscar(getProperties().getProperty("razonSocialConvenioBuscar"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 105, description = "Caso 115")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que  si se ingresa a la accion de modificar de la grilla se debe mostrar el campo \"NIT\" tipo de campo TextBox")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a115() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 106, description = "Caso 116")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el campo \"NIT\" en el formulario modificar sea obligatorio")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a116() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 107, description = "Caso 117")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el campo \"NIT\" en el formulario modificar sea traido automáticamente del sistema al seleccionar de la búsqueda el cliente deseado. NO EDITABLE")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a117() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 108, description = "Caso 118")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de modificar el campo \"Nombre/Razon Social\" y este debe ser  tipo de campo textbox")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a118() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 109, description = "Caso 119")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de modificar el campo \"Nombre/Razon Social\" debe ser obligatorio")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a119() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 110, description = "Caso 120")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de modificar el campo \"Nombre/Razon Social\" es traído automáticamente del sistema al seleccionar de la búsqueda el cliente deseado NO EDITABLE")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a120() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 111, description = "Caso 121")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar el campo \"Valor impresión Juego Prendario\" (label) con tipo de campo TextBox")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a121() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().ClearValorImpresion()
				.ValorImpresion(getProperties().getProperty("valorImpresion"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 112, description = "Caso 122")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar el campo \"Valor impresión Juego Prendario\" sea obligatorio")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a122() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().ClearValorImpresion();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 113, description = "Caso 123")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar el campo \"Valor impresión Juego Prendario\" sea un campo tipo numerico , debe tener signo $ y separador de miles ( EDITABLE)")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a123() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().ClearValorImpresion()
				.ValorImpresion(getProperties().getProperty("valorImpresion"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 114, description = "Caso 124")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar el campo \"Aplica cobro por modalidad\" tipo de campo Listbox")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a124() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().AplicaCobro();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 115, description = "Caso 125")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar el campo \"Aplica cobro por modalidad\" sea obligatorio y permita seleccionar la opción \"Si/No\" (EDITABLE)")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a125() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().AplicaCobroNo().AplicaCobroSi();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 116, description = "Caso 126")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que al seleccionar \"Si\" del campo \"Aplica cobro por modalidad\", debe mostrar bajo el campo anterior en tipo acordeón los tipos de bodegas que se tienen configurado para ese cliente en la asignación de cupo (Formulario de modificar)")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a126() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().Gestion().BotonModificarBuscar().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 117, description = "Caso 129")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la bodega contenga en el formulario de modificar el campo \"Seleccione forma de cobro\"  con tipo de campo listbox")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a129() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().ParticularArrendada()
				.SeleccioneFormaDeCobroParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 118, description = "Caso 130")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que en el formulario de modificar el campo \"Seleccione forma de cobro\" sea un campo obligatorio")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a130() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().ParticularArrendada()
				.SeleccioneFormaDeCobroParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 119, description = "Caso 131")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que en el formulario de modificar el campo \"Seleccione forma de cobro\" permita seleccionar la opción \"Fija/Escalonada\"  EDITABLE")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a131() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().Propia().FormaDeCobroFijaPropia("")
				.FormaDeCobroEscalonadaPropia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 120, description = "Caso 132")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que cada Bodega contenga el campo \"Fija\" en el formulario de modificar")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a132() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().Scroll().ParticularArrendada().ParticularArrendada()
				.Propia().Propia().Transito().Transito().Particular().Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 121, description = "Caso 133")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar que el campo \"Fija\" sea un tipo de campo TextBox")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a133() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().Scroll().ParticularArrendada()
				.ClearFormaDeCobroFijaParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("fijaPorcentaje"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 122, description = "Caso 134")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de modificar que el campo \"Fija\" tenga una longitud de 5")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a134() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().Scroll().ParticularArrendada()
				.ClearFormaDeCobroFijaParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("numeroTextBox"))
				.ClearFormaDeCobroFijaParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("caracterTextBox"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 123, description = "Caso 135")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar que el campo \"Fija\" sea un campo obligatorio , solo se mostrara si la forma de pago seleccionada fue Fija")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a135() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().Scroll().ParticularArrendada()
				.ClearFormaDeCobroFijaParticularArrendada();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 124, description = "Caso 136")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar que el campo \"Fija\" sea un campo tipo númerico con formato en % (EDITABLE)")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a136() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().Scroll().ParticularArrendada()
				.ClearFormaDeCobroFijaParticularArrendada()
				.FormaDeCobroFijaParticularArrendada(getProperties().getProperty("numeroTextBox"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 125, description = "Caso 137")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que cada Bodega contenga el campo \"Escalonada\" en el formulario de modificar")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a137() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().ParticularArrendada().ParticularArrendada()
				.Propia().Propia().Transito().Transito().Particular().Particular();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 126, description = "Caso 138")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar que el campo \"Escalonada\" sea un tipo de campo Grilla")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a138() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().Propia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 127, description = "Caso 139")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar que el campo \"Escalonada\" sea un campo obligatorio,solo se mostrara si la forma de pago seleccionada fue Escalonada")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a139() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().Transito().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 128, description = "Caso 140")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la grilla debe tener la opción de agregar y eliminar líneas las cuales debe estar edificadas con la letra R + el número de la línea (en el formulario de modificar)")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a140() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().ParticularArrendada().EscalonadaAgregarRango()
				.Scroll().EscalonadaEliminar();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 129, description = "Caso 141")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la grilla tenga el campo \"Rangos\" Esta columna contiene dos columnas adicionales - LI: Tipo numérico con formato en $. - LF: Tipo numérico con formato en $, debe ser mayor al LI")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a141() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().ParticularArrendada().DatosEscalonadaClear()
				.Scroll().DatosEscalonadaPrimeraFila(getProperties().getProperty("R2LI"),
						getProperties().getProperty("R2LF"), getProperties().getProperty("valor"));
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 130, description = "Caso 142")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la grilla tenga el campo \"Valor\" Tipo alfanumérico, longitud 5 y con formato en % (Formulario de modificar)")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a142() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().ParticularArrendada().DatosEscalonadaClear()
				.Scroll()
				.DatosEscalonadaPrimeraFila(getProperties().getProperty("R2LI"), getProperties().getProperty("R1LF"),
						getProperties().getProperty("valorAlfanumerico"))

				.DatosEscalonadaSegundaFila(getProperties().getProperty("R1LI"), getProperties().getProperty("R2LF"),
						getProperties().getProperty("valorAlfanumerico"));

		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 131, description = "Caso 143")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la forma de pago \"Escalonada\" debe tener como minimo dos rangos")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a143() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar2().Scroll().Particular().Scroll().Evidencia();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 132, description = "Caso 144")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario  de modificar muestre el campo \" Aplica minima\"")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a144() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().Scroll();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	@Test(priority = 133, description = "Caso 145")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar el campo \"Aplica minima\" sea un tipo de campo ListBox")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a145() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificarBuscar().Scroll().AplicaMinima();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	// 146. Validar en el formulario de modificar el campo "Aplica minima" sea un
	// campo obligatorio
	@Test(priority = 134, description = "Caso 146")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en el formulario de modificar el campo \"Aplica minima\" sea un campo obligatorio")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a146() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificar().AplicaMinima();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	// 147. Validar en el formulario de modificar en la lista desplegable se deben
	// mostrar las opciones "Si/No" (EDITABLE)
	@Test(priority = 135, description = "Caso 147")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar  en el formulario de modificar en la lista desplegable se deben mostrar las opciones \"Si/No\" (EDITABLE)")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a147() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificar().AplicaMinimaSi().AplicaMinimaNo();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	// 148. Validar en el formulario de modificar muestre el campo "Si"
	@Test(priority = 136, description = "Caso 148")
	@Severity(SeverityLevel.NORMAL)
	@Description("148. Validar en el formulario de modificar muestre el campo \"Si\"")
	@Story("Convenio Funcionalidad Modificar")
	@TmsLink("XRPRJ-1")
	public void a148() throws Exception {
	
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales(getProperties().getProperty("usuarioConvenio"),
				getProperties().getProperty("password"));
		Convenios.Convenio().Gestion().BotonModificar().AplicaMinimaSi()
				.AplicaMinimaValorMinima(getProperties().getProperty("valorMinima")).AplicaMinimaNo();
		home.Exit();
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}*/
}