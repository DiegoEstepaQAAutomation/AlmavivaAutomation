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
@Epic("Anular Título")
@Feature("Anular Título Test")

public class AnularTituloTest extends BaseTest {
	public Properties fileprops = new Properties();
	//LLAMADO DE LAS PROPIEDADES UTILIZADAS EN EL TEST
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		return fileprops;
	}

	//METODO LOGIN CON INICIACION DE GENERAR REPORTE
	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderAT"),
				getProperties().getProperty("path"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"));

		GenerarReportePdf.setImgContador(0);

		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}

	@Test(priority = 0, description = "Anular título")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Anular Título")
	@Story("Anulación de título")
	public void crearExpedir() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderAT"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestAnular"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloAnular"),getProperties().getProperty("Evidencia"));

		//EJECUCION DEL METODO ANULAR TITULO 
		anularTitulo.anularTitulo(folderPath, getProperties().getProperty("codigoAnular"),getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("");
	}
}