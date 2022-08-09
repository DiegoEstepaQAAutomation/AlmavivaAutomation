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
import utilities.MyScreenRecorder;

@Listeners({ TestListener.class })
@Epic("Notificaciones")
@Feature("Notificaciones Test")

public class NotificacionesTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Notificaciones.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Gestion.properties").getAbsolutePath()));
		
		
		
		return fileprops;
	}
	
	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
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

	
	
	MyScreenRecorder recording;

	
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionHU25() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));
		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloN"), getProperties().getProperty("submoduloN"));
		
		
		
		notificacionespage.Notificacion_557159(folderPath, getProperties().getProperty("DatoFaltante"), getProperties().getProperty("ModuloCliente"), 
				getProperties().getProperty("Submodulo"), getProperties().getProperty("FechaDeCargue"), getProperties().getProperty("estadoA"), 
				getProperties().getProperty("Encabezado"));
		
		
		
		
		login.cerrarSesion(folderPath);
		
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("");
	}

	
}