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

@Listeners({ TestListener.class })
@Epic("Log Auditoria")
@Feature("Log Auditoria Test")

public class LogAuditoriaTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {

		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/LogAuditoria.properties").getAbsolutePath()));

		return fileprops;
	}

	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderL"),
				getProperties().getProperty("path"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"));

		GenerarReportePdf.setImgContador(0);

		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath);
	}

	@Test(priority = 0, description = "Lista de usuarios en log auditoría")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Log Auditoría")
	@Story("Varificar lista de Usuarios en log auditoría")
	public void crearUsuario() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderL"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestListaUsuariosLogAuditoria"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloL"));
		
		String[] usuarios = logAuditoria.almacenarListaVector(folderPath);
		logAuditoria.usuariosLog(folderPath, usuarios);

		GenerarReportePdf.closeTemplate("");
	}

	@Test(priority = 1, description = "Filtros de fechas y descarga de información en log auditoría")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Log Auditoría")
	@Story("Filtrar fechas 'desde/hasta' y descarga de información en log auditoría")
	public void filtroFechasLog() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderL"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestListaFiltrosLogAuditoria"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloL1"));

		logAuditoria.botonesLog(folderPath)
		
		.filtroFechasLog(folderPath, getProperties().getProperty("mesD"), getProperties().getProperty("anualD"),
				getProperties().getProperty("diaD"), getProperties().getProperty("mesH"),
				getProperties().getProperty("anualH"), getProperties().getProperty("diaH"));

		GenerarReportePdf.closeTemplate("");
	}
}