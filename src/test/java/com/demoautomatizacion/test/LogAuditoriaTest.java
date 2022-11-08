package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.GenerarReportePdf;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

// TODO: Auto-generated Javadoc
/**
 * The Class LogAuditoriaTest.
 */
@Listeners({ TestListener.class })
@Epic("Log Auditoria")
@Feature("Log Auditoria Test")

public class LogAuditoriaTest extends BaseTest {
	
	/** The fileprops. */
	public Properties fileprops = new Properties();

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 * @throws Exception the exception
	 */
	public Properties getProperties() throws Exception {

		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/LogAuditoria.properties").getAbsolutePath()));

		return fileprops;
	}

	/**
	 * Login.
	 *
	 * @param nameTest the name test
	 * @param usuario the usuario
	 * @param contrasena the contrasena
	 * @throws Exception the exception
	 */
	//METODO PARA LOGUEARSE AL PORTAL DE ALMAVIVA
		public void login2(String nameTest, String usuario, String contrasena,String Evidencia) throws Exception 
		{

			//INSTANCIA DEL METODO DE GENERAR EL REPORTE PDF
			GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
			//INSTANCIA DE LA RUTA DONDE GUARDAMOS EL PDF
			File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderG"),
					getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

			GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
					getProperties().getProperty("urlPrivada"),getProperties().getProperty("Evidencia"));

			GenerarReportePdf.setImgContador(0);

			//LLAMADO DE CREDENCIALES Y LA RUTA URL DEL PORTAL DE ALMAVIVA
			home.irPortal(getProperties().getProperty("urlPrivada"));
			login.privacidadIp();
			home.irPortal(getProperties().getProperty("url"));
			login.privacidadIp();
			home.irPortal(getProperties().getProperty("urlPrivada"));
			login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
					folderPath,getProperties().getProperty("Evidencia"));
		}

	/**
	 * Crear usuario.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 0, description = "Lista de usuarios en log auditoría")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Log Auditoría")
	@Story("Varificar lista de Usuarios en log auditoría")
	public void crearUsuario() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderL"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestListaUsuariosLogAuditoria"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloL"),getProperties().getProperty("Evidencia"));
		
		String[] usuarios = logAuditoria.almacenarListaVector(folderPath);
		logAuditoria.usuariosLog(folderPath, usuarios,getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}

	/**
	 * Filtro fechas log.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 1, description = "Filtros de fechas y descarga de información en log auditoría")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Log Auditoría")
	@Story("Filtrar fechas 'desde/hasta' y descarga de información en log auditoría")
	public void filtroFechasLog() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderL"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestListaFiltrosLogAuditoria"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloL1"),getProperties().getProperty("Evidencia"));

		logAuditoria.botonesLog(folderPath,getProperties().getProperty("Evidencia"))
		
		.filtroFechasLog(folderPath, getProperties().getProperty("mesD"), getProperties().getProperty("anualD"),
				getProperties().getProperty("diaD"), getProperties().getProperty("mesH"),
				getProperties().getProperty("anualH"), getProperties().getProperty("diaH"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
}