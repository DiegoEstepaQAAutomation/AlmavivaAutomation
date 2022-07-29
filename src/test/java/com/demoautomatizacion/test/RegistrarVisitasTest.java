package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.test.utils.Listeners.TestListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Listeners({ TestListener.class })
@Epic("Regitrar Visitas")
@Feature("Regitrar Visitas Test")

public class RegistrarVisitasTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/CRVisitas.properties").getAbsolutePath()));
		return fileprops;
	}

	/*@Test(priority = 0, description = "Caso 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el modulo de visitas/Registrar Visita solo se muestre al usuario con el rol y perfil que tenga los permisos")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b1() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas();
		home.Exit();
	}

	@Test(priority = 1, description = "Caso 2")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar la opción \"Registrar Visita\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b2() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas();
		ValidacionCRVisitas.ValidarCaso2("Consultar registro de visita");
		CRVisitas.RV();
		home.Exit();
	}

	@Test(priority = 2, description = "Caso 3")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar encabezado de la pantalla \"Consultar registro de visita\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b3() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV();
		ValidacionCRVisitas.ValidarCaso3("Consultar registro de visita");
		home.Exit();
	}

	@Test(priority = 3, description = "Caso 4")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar campo \"Buscar\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b4() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV();
		ValidacionCRVisitas.ValidarCaso4();
		home.Exit();
	}

	@Test(priority = 4, description = "Caso 5")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar longitud en funcionalidad del campo \"Buscar \"sea de 50 caracteres y Autocomplete")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b5() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("caracteres50"));
		home.Exit();
	}

	@Test(priority = 5, description = "Caso 6")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del campo \"Buscar\" busqueda por \"bodega o cliente nit o nombre razón social\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b6() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().TipoBusqueda();
		home.Exit();
	}

	@Test(priority = 6, description = "Caso 7")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del campo \"Buscar\"se inicie busqueda apartir del tercer carácter digitado")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b7() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("tercerCaracter"));
		home.Exit();
	}

	@Test(priority = 7, description = "Caso 8")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del campo \"Buscar\" registros no existentes")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b8() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("noExiste"));
		home.Exit();
	}

	@Test(priority = 8, description = "Caso 9")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en consulta funcionalidad del campo \"Bodega\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b9() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV();
		ValidacionCRVisitas.ValidarCaso9("Bodega");
		home.Exit();
	}

	@Test(priority = 9, description = "Caso 10")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en consulta funcionalidad del campo \"Cliente\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b10() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV();
		ValidacionCRVisitas.ValidarCaso10("Cliente");
		home.Exit();
	}
	
	@Test(priority = 10, description = "Caso 11")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en consulta funcionalidad del campo \"Número de visita\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b11() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV();
		ValidacionCRVisitas.ValidarCaso11("Número de visita");
		home.Exit();
		
	}

	@Test(priority = 11, description = "Caso 12")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en consulta funcionalidad del campo \"Fecha\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b12() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV();
		ValidacionCRVisitas.ValidarCaso12("Fecha");
		home.Exit();
		
	}
	
	@Test(priority = 12, description = "Caso 13")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar columna \"Acción\" con los botones de \"Ver Detalles\" y \"Modificar\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b13() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV();
		ValidacionCRVisitas.ValidarCaso13("Acción");
		CRVisitas.VerDetalles().Modificar();
		home.Exit();
	}

	@Test(priority = 13, description = "Caso 14")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Ver Detalles\" funcionalidad del campo \"Registro de visita\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b14() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1();
		ValidacionCRVisitas.ValidarCaso14("Registro de Visita");
		home.Exit();
		
	}

	@Test(priority = 14, description = "Caso 15")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Ver Detalles\" funcionalidad del campo \"Fecha de registro\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b15() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().RegistroVista();
		ValidacionCRVisitas.ValidarCaso15("Fecha de Registro");
		home.Exit();
		
	}

	@Test(priority = 15, description = "Caso 16")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Ver Detalles\" funcionalidad del campo \"Fecha visita\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b16() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().RegistroVista();
		ValidacionCRVisitas.ValidarCaso16("Fecha realización visita");
		home.Exit();
		
	}

	@Test(priority = 16, description = "Caso 17")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b17() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().RegistroVista();
		ValidacionCRVisitas.ValidarCaso17("Nombre visitador");
		home.Exit();

	}

	@Test(priority = 17, description = "Caso 18")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b18() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().RegistroVista();
		ValidacionCRVisitas.ValidarCaso18("Numero de visita");
		home.Exit();

	}

	@Test(priority = 18, description = "Caso 19")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b19() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().RegistroVista();
		ValidacionCRVisitas.ValidarCaso19("Tipo de visita");
		home.Exit();

	}

	@Test(priority = 19, description = "Caso 20")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b20() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1();
		ValidacionCRVisitas.ValidarCaso20("Información General del Cliente");
		home.Exit();

	}

	@Test(priority = 20, description = "Caso 21")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b21() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().IGC();
		ValidacionCRVisitas.ValidarCaso21("Nombre del Cliente");
		home.Exit();

	}

	@Test(priority = 21, description = "Caso 22")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b22() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().IGC();
		ValidacionCRVisitas.ValidarCaso22("Nit del Cliente");
		home.Exit();

	}

	@Test(priority = 22, description = "Caso 23")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b23() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1();
		ValidacionCRVisitas.ValidarCaso23("Información General de la bodega");
		home.Exit();

	}

	@Test(priority = 23, description = "Caso 24")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b24() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().IGB();
		ValidacionCRVisitas.ValidarCaso24("Código de oficina");
		home.Exit();

	}

	@Test(priority = 24, description = "Caso 25")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b25() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().IGB();
		ValidacionCRVisitas.ValidarCaso25("Dirección de la oficina");
		home.Exit();

	}

	@Test(priority = 25, description = "Caso 26")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b26() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().IGB();
		ValidacionCRVisitas.ValidarCaso26("Toma análisis de calidad");
		home.Exit();


	}

	@Test(priority = 26, description = "Caso 27")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b27() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().IGB();
		ValidacionCRVisitas.ValidarCaso27("Pesaje aleatorio");
		home.Exit();

	}

	@Test(priority = 27, description = "Caso 28")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b28() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().IGB();
		ValidacionCRVisitas.ValidarCaso28("Toma registro fotográfico");
		home.Exit();
		
	}

	@Test(priority = 28, description = "Caso 29")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b29() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().IGB();
		ValidacionCRVisitas.ValidarCaso29("Acompañamiento director");
		home.Exit();

	}

	@Test(priority = 29, description = "Caso 30")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b30() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1();
		ValidacionCRVisitas.ValidarCaso30("Condiciones de bodega");
		home.Exit();

	}

	@Test(priority = 30, description = "Caso 31")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b31() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().CodicionesBodega();
		ValidacionCRVisitas.ValidarCaso31("Estado de seguridad, orden y aseo");
		home.Exit();

	}

	@Test(priority = 31, description = "Caso 32")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b32() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().CodicionesBodega();
		ValidacionCRVisitas.ValidarCaso32("Estado de seguridad de la mercancía");
		home.Exit();

	}

	@Test(priority = 32, description = "Caso 33")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b33() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().CodicionesBodega().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso33("Estado de instalaciones eléctricas");
		home.Exit();

	}
	
	@Test(priority = 33, description = "Caso 34")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b34() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1();
		ValidacionCRVisitas.ValidarCaso34("Título 2228");
		home.Exit();

	}
	
	@Test(priority = 34, description = "Caso 35")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b35() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso35("Descripción Mercancía");
		home.Exit();

	}
	
	@Test(priority = 35, description = "Caso 36")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b36() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso36("Cantidad");
		home.Exit();

	}
	
	@Test(priority = 36, description = "Caso 37")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b37() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso37("Unidad de Medida");
		home.Exit();

	}
	
	@Test(priority = 37, description = "Caso 38")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b38() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso38("Costo Unitario");
		home.Exit();

	}
	
	@Test(priority = 38, description = "Caso 39")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b39() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso39("Valor Mercancía");
		home.Exit();

	}
	
	
	@Test(priority = 39, description = "Caso 40")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b40 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso40("Cantidad Hallada");
		home.Exit();

	}
	
	@Test(priority = 40, description = "Caso 41")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar paginado")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b41() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso41("Valor Mercancía Hallada");
		home.Exit();
	}
	
	@Test(priority = 41, description = "Caso 42")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b42() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso42("Diferencia Cantidad");
		home.Exit();

	}
	
	@Test(priority = 42, description = "Caso 43")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b43() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso43("Diferencia Valor");
		home.Exit();

	}
	
	@Test(priority = 43, description = "Caso 44")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b44() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().ScrollAbajo().Evidencias();
		home.Exit();

	}
	
	@Test(priority = 44, description = "Caso 45")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b45() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).VerDetalles1().Titulo().ScrollAbajo().Evidencias()
		.Pag5();
		home.Exit();

	}
	
	@Test(priority = 45, description = "Caso 46")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b46() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().VerDetalles1().ScrollAbajo1().Evidencias()
		.Regresar();
		home.Exit();

	}
	
	@Test(priority = 46, description = "Caso 47")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b47() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2();
		ValidacionCRVisitas.ValidarCaso47("Modificación registro de visita");
		home.Exit();

	}
	
	@Test(priority = 47, description = "Caso 48")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar en \"Autorizar\" el campo \"Valor a liberar\"")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b48() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ModificacionRegistroVisita();
		ValidacionCRVisitas.ValidarCaso48("Fecha de Registro");
		home.Exit();

	}
	
	@Test(priority = 48, description = "Caso 49")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b49() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ModificacionRegistroVisita();
		ValidacionCRVisitas.ValidarCaso49("Fecha visita");
		home.Exit();

	}
	
	@Test(priority = 49, description = "Caso 50")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b50() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ModificacionRegistroVisita();
		ValidacionCRVisitas.ValidarCaso50("Nombre visitador");
		home.Exit();

	}
	
	@Test(priority = 50, description = "Caso 51")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b51 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ModificacionRegistroVisita();
		ValidacionCRVisitas.ValidarCaso51("Numero de visita");
		home.Exit();

	}
	
	@Test(priority = 51, description = "Caso 52")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b52 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ModificacionRegistroVisita();
		ValidacionCRVisitas.ValidarCaso52("Tipo de visita");
		home.Exit();

	}
	
	@Test(priority = 52, description = "Caso 53")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b53 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2();
		ValidacionCRVisitas.ValidarCaso53("Información General del Cliente");
		home.Exit();

	}
	
	@Test(priority = 53, description = "Caso 54")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b54 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().IGC1();
		ValidacionCRVisitas.ValidarCaso54("Nombre del Cliente");
		home.Exit();

	}
	
	@Test(priority = 54, description = "Caso 55")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b55 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().IGC1();
		ValidacionCRVisitas.ValidarCaso55("Nit del Cliente");
		home.Exit();

	}
	
	@Test(priority = 55, description = "Caso 56")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b56 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2();
		ValidacionCRVisitas.ValidarCaso56("Información General de la bodega");
		home.Exit();

	}
	
	@Test(priority = 56, description = "Caso 57")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b57 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().IGB1();
		ValidacionCRVisitas.ValidarCaso57("Código de oficina");
		home.Exit();

	}
	
	@Test(priority = 57, description = "Caso 58")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b58 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().IGB1();
		ValidacionCRVisitas.ValidarCaso58("Dirección de la oficina");
		home.Exit();

	}
	
	@Test(priority = 58, description = "Caso 59")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b59 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().IGB1();
		ValidacionCRVisitas.ValidarCaso59("Toma análisis de calidad");
		home.Exit();

	}
	
	@Test(priority = 59, description = "Caso 60")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b60 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().IGB1();
		ValidacionCRVisitas.ValidarCaso60("Pesaje aleatorio");
		home.Exit();

	}
	
	@Test(priority = 60, description = "Caso 61")
	@Severity(SeverityLevel.NORMAL)
	@Description("bug")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b61() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().IGB1();
		ValidacionCRVisitas.ValidarCaso61("Toma registro fotográfico");
		home.Exit();

	}
	
	@Test(priority =61, description = "Caso 62")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b62 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().IGB1();
		ValidacionCRVisitas.ValidarCaso62("Acompañamiento director");
		home.Exit();

	}
	
	@Test(priority =62, description = "Caso 63")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b63 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2();
		ValidacionCRVisitas.ValidarCaso63("Condiciones de bodega");
		home.Exit();

	}
	
	@Test(priority =63, description = "Caso 64")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b64 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().CodicionesBodega1();
		ValidacionCRVisitas.ValidarCaso64("Estado de seguridad, orden y aseo");
		home.Exit();
		
	}
	
	@Test(priority =64, description = "Caso 65")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b65 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().CodicionesBodega1();
		ValidacionCRVisitas.ValidarCaso65("Estado de seguridad de la mercancía");
		home.Exit();
		
	}
	
	@Test(priority =65, description = "Caso 66")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b66 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().CodicionesBodega1();
		ValidacionCRVisitas.ValidarCaso66("Estado de instalaciones eléctricas");
		home.Exit();
		
	}
	
	@Test(priority =66, description = "Caso 67")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b67 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo();
		ValidacionCRVisitas.ValidarCaso67("Título 2228");
		home.Exit();

	}
	
	@Test(priority =67, description = "Caso 68")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b68 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso68("Descripción mercancía");
		home.Exit();

	}
	
	@Test(priority =68, description = "Caso 69")
	@Severity(SeverityLevel.NORMAL)
	@Description("bug")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b69() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso69("Cantidad");
		home.Exit();
		
	}
	
	
	@Test(priority =69, description = "Caso 70")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b70() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso70("Unidad de Medida");
		home.Exit();
	}
	
	@Test(priority =70, description = "Caso 71")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b71() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso71("Costo Unitario");
		home.Exit();
	}
	
	@Test(priority =71, description = "Caso 72")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b72() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso72("Valor Mercancía");
		home.Exit();
	}
	
	@Test(priority =72, description = "Caso 73")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b73() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso73("Cantidad Hallada");
		CRVisitas.ClearCH().CantidadHallada(getProperties().getProperty("cantidadHallada"));
		home.Exit();
	}
	
	@Test(priority =73, description = "Caso 74")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b74() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso74("Valor Mercancía Hallada");
		home.Exit();
	}
	
	@Test(priority =74, description = "Caso 75")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b75() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso75("Diferencia Cantidad");
		home.Exit();
	}
	
	@Test(priority =75, description = "Caso 76")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b76() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1();
		ValidacionCRVisitas.ValidarCaso76("Diferencia Valor");
		home.Exit();
	}
	
	@Test(priority =76, description = "Caso 77")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b77() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Buscar(getProperties().getProperty("NitBuscar")).Modificar2().ScrollAbajo().Evidencias();
		home.Exit();
	}
	
	@Test(priority =77, description = "Caso 78")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b78() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Titulo1().ScrollAbajo().Evidencias().Guardar().Aceptar();
		home.Exit();
	}
	
	@Test(priority =78, description = "Caso 79")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b79() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Evidencias().Guardar().BotonCancelar1();
		home.Exit();
	}
	
	@Test(priority =79, description = "Caso 80")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b80() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().ScrollAbajo1().Modificar3().ScrollAbajo().Evidencias().Guardar().BotonCancelar1()
		.Guardar().Aceptar();
		home.Exit();
	}
	
	@Test(priority =80, description = "Caso 81")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b81() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ScrollAbajo().Evidencias().BotonCancelar();
		home.Exit();
	}
	
	@Test(priority =81, description = "Caso 82")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b82() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().ScrollAbajo1().Modificar3().ScrollAbajo().Evidencias().Guardar().Aceptar();
		home.Exit();
	}
	
	@Test(priority =82, description = "Caso 83")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b83() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		CRVisitas.Visitas().RV().Modificar2().ModificacionRegistroVisita().ClearNombreVisitador().ScrollAbajo()
		.IGB1().ClearDireccionOficina().ScrollAbajo().CodicionesBodega1().ClearESOA().ClearESM().ClearEIE().ScrollAbajo()
		.Titulo1().ClearCH().ScrollAbajo().Guardar().Aceptar().ScrollArriba1().Evidencias().ScrollAbajo().Evidencias()
		.ScrollAbajo().Evidencias().ScrollAbajo1().Evidencias();
		home.Exit();
	}
	
	@Test(priority =83, description = "Caso 84")
	@Severity(SeverityLevel.NORMAL)
	@Description("")
	@Story("Consulta Regitro de Visitas")
	@TmsLink("XRPRJ-1")
	public void b84() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Liberacion.Seguridad().LogAuditoria().FechaDesde().FechaHasta().ConsultarUsuario(getProperties().getProperty("usr"))
		.Buscar1().ScrollAbajo1().Evidencia().PaginacionLog().ScrollDerecha1().Evidencia().PaginacionLog1().ScrollDerecha1()
		.Evidencia().ScrollArriba().Evidencia();
		home.Exit();
	}*/
}