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
@Epic("Notificaciones")
@Feature("Notificaciones Test")

public class NotificacionesTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Notificaciones.properties").getAbsolutePath()));
		return fileprops;
	}

	/*@Test(priority = 0, description = "Caso 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que la opción Notificaciones/Asignar solo se muestre al usuario con el rol y perfil que tenga los permisos")
	@Story("Notificaciones")
	@TmsLink("XRPRJ-1")
	public void b1() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones();
		home.Exit();
	}

	@Test(priority = 1, description = "Caso 2")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar función de la opción \"asignar\"")
	@Story("Notificaciones")
	@TmsLink("XRPRJ-1")
	public void b2() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones2().Agregar().BuscarUsuario(getProperties().getProperty("usuarioConvenio"))
		.Buscar().BotonAsignar().BotonConfirmar().Aceptar();
		home.Exit();
	}

	@Test(priority = 2, description = "Caso 3")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que el formulario muestre el encabezado \"Notificaciones\"")
	@Story("Notificaciones")
	@TmsLink("XRPRJ-1")
	public void b3() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar();
		ValidacionNotificaciones.ValidarCaso3("Notificaciones");
		home.Exit();
	}

	@Test(priority = 3, description = "Caso 4")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del campo \"Notificaciones del sistema\"")
	@Story("Notificaciones")
	@TmsLink("XRPRJ-1")
	public void b4() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar();
		ValidacionNotificaciones.ValidarCaso4("Notificaciones del sistema");
		Notificaciones.SeleccionarNotificaciones();
		home.Exit();
	}

	@Test(priority = 4, description = "Caso 5")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Creación Usuario")
	@Story("Notificaciones")
	@TmsLink("XRPRJ-1")
	public void b5() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso5("Creación Usuario");
		Notificaciones.SeleccionarNotificaciones();
		home.Exit();
	}

	@Test(priority = 5, description = "Caso 6")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Vencimiento de cupo - Alerta Preventiva")
	@Story("Notificaciones")
	@TmsLink("XRPRJ-1")
	public void b6() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso6("Vencimiento de cupo - Alerta Preventiva");
		Notificaciones.SeleccionarNotificaciones1();
		home.Exit();
	}

	@Test(priority = 6, description = "Caso 7")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Vencimiento de cupo - Alerta Correctiva")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b7() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso7("Vencimiento de cupo - Alerta Correctiva");
		Notificaciones.SeleccionarNotificaciones2();
		home.Exit();
	}

	@Test(priority = 7, description = "Caso 8")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Asignación cupo aprobado")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b8() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso8("Asignación cupo aprobado");
		Notificaciones.SeleccionarNotificaciones3();
		home.Exit();
	}

	@Test(priority = 8, description = "Caso 9")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Actualización cupo aprobado")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b9() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso9("Actualización cupo aprobado");
		Notificaciones.SeleccionarNotificaciones4();
		home.Exit();
	}

	@Test(priority = 9, description = "Caso 10")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Expedición de Título")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b10() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso10("Expedición de Título");
		Notificaciones.SeleccionarNotificaciones5();
		home.Exit();
	}
	
	@Test(priority = 10, description = "Caso 11")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Facturación juego prendario")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b11() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso11("Facturación juego prendario");
		Notificaciones.SeleccionarNotificaciones6();
		home.Exit();
		
	}

	@Test(priority = 11, description = "Caso 12")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para  Facturación almacenamiento")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b12() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso12("Facturación almacenamiento");
		Notificaciones.SeleccionarNotificaciones7();
		home.Exit();
		
	}

	@Test(priority = 12, description = "Caso 13")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Vencimiento de título - Alerta Preventiva")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b13() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso13("Vencimiento de título - Alerta Preventiva");
		Notificaciones.SeleccionarNotificaciones8();
		home.Exit();
	}

	@Test(priority = 13, description = "Caso 14")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Vencimiento de título - Alerta Correctiva")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b14() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso14("Vencimiento de título - Alerta Correctiva");
		Notificaciones.SeleccionarNotificaciones9();
		home.Exit();
		
	}

	@Test(priority = 14, description = "Caso 15")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Vencimiento de póliza - Alerta Preventiva")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b15() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso15("Vencimiento de póliza - Alerta Preventiva");
		Notificaciones.SeleccionarNotificaciones10();
		home.Exit();
		
	}

	@Test(priority = 15, description = "Caso 16")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Vencimiento de póliza - Alerta Correctiva")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b16() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso16("Vencimiento de póliza - Alerta Correctiva");
		Notificaciones.SeleccionarNotificaciones11();
		home.Exit();
		
	}

	@Test(priority = 16, description = "Caso 17")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Liberación total de mercancía – Alerta")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b17() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso17("Liberación total de mercancía – Alerta");
		Notificaciones.SeleccionarNotificaciones12();
		home.Exit();

	}

	@Test(priority = 17, description = "Caso 18")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Liberación parcial de mercancía – Alerta")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b18() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso18("Liberación parcial de mercancía – Alerta");
		Notificaciones.SeleccionarNotificaciones13();
		home.Exit();

	}

	@Test(priority = 18, description = "Caso 19")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Faltante")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b19() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso19("Faltante");
		Notificaciones.SeleccionarNotificaciones14();
		home.Exit();

	}

	@Test(priority = 19, description = "Caso 20")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Terminación de Tránsito (15 días)")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b20() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso20("Terminación de Transito (15 días)");
		Notificaciones.SeleccionarNotificaciones15();
		home.Exit();

	}

	@Test(priority = 20, description = "Caso 21")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad campo \"Tipo de Notificación\" para Terminación de Tránsito (8 días)")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b21() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().Seleccionar();
		ValidacionNotificaciones.ValidarCaso21("Terminación de Transito (8 días)");
		Notificaciones.SeleccionarNotificaciones16();
		home.Exit();

	}

	@Test(priority = 21, description = "Caso 22")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar botón \"Agregar\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b22() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().Scape();
		home.Exit();

	}

	@Test(priority = 22, description = "Caso 23")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar campo \"Nombre\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b23() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones();
		ValidacionNotificaciones.ValidarCaso23(getProperties().getProperty("validarNombre"));
		home.Exit();

	}

	@Test(priority = 23, description = "Caso 24")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar campo \"Usuario\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b24() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones();
		ValidacionNotificaciones.ValidarCaso24(getProperties().getProperty("validarUsuario"));
		home.Exit();

	}

	@Test(priority = 24, description = "Caso 25")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar campo \"Correo\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b25() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones();
		ValidacionNotificaciones.ValidarCaso25(getProperties().getProperty("validarCorreo"));
		home.Exit();

	}

	@Test(priority = 25, description = "Caso 26")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar campo \"Perfil\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b26() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones();
		ValidacionNotificaciones.ValidarCaso26(getProperties().getProperty("validarPerfil"));
		home.Exit();

	}

	@Test(priority = 26, description = "Caso 27")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar acción \"Ver\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b27() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Consultar().Regresar();
		home.Exit();

	}
////////////////////////
	@Test(priority = 27, description = "Caso 28")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar acción \"Editar y/o eliminar\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b28() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Modificar().Editar().Aceptar()
		.Agregar().BuscarUsuario(getProperties().getProperty("usuario")).Buscar().BotonAsignar().BotonConfirmar().Aceptar()
		.Eliminar().Aceptar();
		home.Exit();
		
	}

	@Test(priority = 28, description = "Caso 29")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar ventana emergente al \"Agregar\" una notificación")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b29() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar();
		ValidacionNotificaciones.ValidarCaso29("Asignar Usuario a Notificación");
		Notificaciones.Scape();
		home.Exit();

	}

	@Test(priority = 29, description = "Caso 30")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el filtro de búsqueda inicie a partir del tercer carácter")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b30() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar()
		.BuscarUsuario(getProperties().getProperty("TercerCaracter")).Scape();
		home.Exit();

	}

	@Test(priority = 30, description = "Caso 31")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar registros no existentes - filtro de búsqueda")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b31() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar()
		.BuscarUsuario(getProperties().getProperty("tercerCaracter")).Scape();
		home.Exit();;

	}

	@Test(priority = 31, description = "Caso 32")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar Usuarios encontrados en lista - filtro de búsqueda")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b32() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar()
		.BuscarUsuario(getProperties().getProperty("usuario")).Buscar().Scape();
		home.Exit();

	}

	@Test(priority = 32, description = "Caso 33")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del botón \"Asignar\" en cada fila de registros")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b33() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar()
		.BuscarUsuario(getProperties().getProperty("usuario")).Buscar().BotonAsignar().BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 33, description = "Caso 34")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el campo \"Usuario Dominio\" en fila de registro")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b34() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar();
		ValidacionNotificaciones.ValidarCaso34("Usuario Dominio");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 34, description = "Caso 35")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el campo \"Nombres\" en fila de registro")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b35() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar();
		ValidacionNotificaciones.ValidarCaso35("Nombre");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 35, description = "Caso 36")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el campo \"Apellidos\" en fila de registro")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b36() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar();
		ValidacionNotificaciones.ValidarCaso36("Apellido");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 36, description = "Caso 37")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el campo \"Correo\" en fila de registro")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b37() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar();
		ValidacionNotificaciones.ValidarCaso37("Correo");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 37, description = "Caso 38")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el campo \"Perfil\" en fila de registro")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b38() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar();
		ValidacionNotificaciones.ValidarCaso38("Perfil");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 38, description = "Caso 39")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar sección Bodegas asignadas")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b39() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar().ScrollAbajo2();
		ValidacionNotificaciones.ValidarCaso39("Oficinas Asignadas");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	
	@Test(priority = 39, description = "Caso 40")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar columna \"código Bodega\" en la grilla de \"Bodegas asignadas\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b40 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar().ScrollAbajo2();
		ValidacionNotificaciones.ValidarCaso40("Codigo");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 40, description = "Caso 41")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el campo \"Nombre Bodega\" en la sección Bodegas")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b41() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar().ScrollAbajo2();
		ValidacionNotificaciones.ValidarCaso41("Nombre");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 41, description = "Caso 42")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar \"checkbox\" por cada bodega mostrada en la grilla de \"Bodegas Asignadas\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b42() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar().ScrollAbajo2();
		ValidacionNotificaciones.ValidarCaso42("Accion");
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	
	@Test(priority = 42, description = "Caso 43")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar botones \"Confirmar\" y \"Cancelar\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b43() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar().ScrollAbajo2();
		ValidacionNotificaciones.ValidarCaso43();
		Notificaciones.BotonCancelar().Scape();
		home.Exit();

	}
	
	@Test(priority = 43, description = "Caso 44")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar la funcionalidad del botón \"Cancelar\" de la ventana emergente")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b44() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar().ScrollAbajo2()
		.BotonCancelar().Scape();
		home.Exit();
		
	}
	
	@Test(priority = 44, description = "Caso 45")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del botón \"Confirmar\" de la ventana emergente")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b45() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar().ScrollAbajo2()
		.BotonConfirmar().BotonCancelar1().Scape();
		home.Exit();

	}
	
	@Test(priority = 46, description = "Caso 46")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del botón \"Aceptar\" de la ventana emergente")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b46() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar().ScrollAbajo2()
		.BotonConfirmar().Aceptar();
		home.Exit();

	}
	
	@Test(priority = 45, description = "Caso 47")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar funcionalidad del botón \"Cancelar\" de la ventana emergente \"Está seguro de guardar el registro?\"")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b47() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar1().ScrollAbajo2()
		.BotonConfirmar().BotonCancelar1().Scape();
		home.Exit();

	}
	
	@Test(priority = 47, description = "Caso 48")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar el correcto guardado de la información")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b48() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().BotonAsignar1().ScrollAbajo2()
		.BotonConfirmar().Aceptar().Evidencias();
		home.Exit();

	}
	
	@Test(priority = 48, description = "Caso 49")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar campos obligatorios")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b49() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar()
		.BuscarUsuario(getProperties().getProperty("usuario")).Buscar().BotonAsignar().Check().BotonConfirmar()
		.BotonCancelar1().Scape();
		home.Exit();

	}
	
	@Test(priority = 49, description = "Caso 50")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar paginado")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b50() throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Notificaciones.Notificaciones().Asignar().SeleccionarNotificaciones().Agregar().ScrollAbajo3().Paginacion()
		.Sigiente().Anterior().Final().Inicial().Scape();
		home.Exit();

	}
	
	@Test(priority = 50, description = "Caso 51")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar log de auditoria")
	@Story("Liberación de Mercancía")
	@TmsLink("XRPRJ-1")
	public void b51 () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		login.ingresarCredenciales1(getProperties().getProperty("usuario"), getProperties().getProperty("password"));
		Liberacion.Seguridad().LogAuditoria().FechaDesde().FechaHasta().ConsultarUsuario(getProperties().getProperty("usr"))
		.Buscar1().ScrollAbajo1().PaginacionLog().PaginacionLog1().ScrollDerecha1().Evidencia().ScrollArriba();
		home.Exit();

	}*/
	
}