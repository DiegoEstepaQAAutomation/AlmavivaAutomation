package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import io.qameta.allure.*;
import utilities.GenerarReportePdf;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Login")
@Feature("Login Tests")

public class LoginTest extends BaseTest {

	public Properties fileprops = new Properties();
	
	//LLAMADO DE LAS PROPIEDADES DE LOGIN
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		return fileprops;
	}

	//ESTE METODO LLAMA LAS PROPIEDADES QUE PERMITEN EL LOGUEO EN ALMAVIVA
	@Test(priority = 0, description = "Login Portal Almaviva")
	@Severity(SeverityLevel.NORMAL)
	@Description("Ingresar Portal Almaviva")
	@Story("Login")
	public void ingresarPortalAlmaviva() throws Exception { 
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolder"),
		        getProperties().getProperty("path"));
		GenerarReportePdf.createTemplate(folderPath,
		        getProperties().getProperty("nameTest"),
		        getProperties().getProperty("analista"),
		        getProperties().getProperty("url"));
		GenerarReportePdf.setImgContador(0);

		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"), folderPath)
	    .cerrarSesion(folderPath);
		
		GenerarReportePdf.closeTemplate("");
	}
}
