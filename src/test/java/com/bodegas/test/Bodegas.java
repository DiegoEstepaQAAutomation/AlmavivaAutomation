

package com.bodegas.test;

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
@Epic("Bodegas")
@Feature("Bodegas Tests")

public class Bodegas extends BaseTest {
	public Properties fileprops = new Properties();

	//PROPIEDADES UTILIZADAS
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		return fileprops;
	}

	/** The recording. */
	//INSTANCIA DE MY SCREEN RECORDER(GRABACION DE PANTALLA)
	MyScreenRecorder recording;
	//LOGIN DE PAGINA ALMAVIVA
	public void login(String nameTest, String usuario, String contrasena) throws Exception {
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderBodega"),
				getProperties().getProperty("path"));
		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista1"),
				getProperties().getProperty("url"));
		GenerarReportePdf.setImgContador(0);
		
		//Evidencia
		
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}

	//PASO A PASO DE CREACION DE UNA BODEGA
	@Test(priority = 0, description = "Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Story("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	public void AlmavivaBodegas1() throws Exception {
		//VALIDAR ESTOS PASOS EN EXPEDIR TEST EN EL METODO CREAR EXPEDIR
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderBodega"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestBodega"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloP"), getProperties().getProperty("SubModuloB"),getProperties().getProperty("Evidencia"));

		//EJECUCION DE LOS CASOS DE BODEGA
		bodega.Parametrizacion(folderPath,getProperties().getProperty("Evidencia"))
		
				.fillFormulary(folderPath, getProperties().getProperty("CodigoBodeg"),
						getProperties().getProperty("oficinaBodeg"), getProperties().getProperty("Nacion"),
						getProperties().getProperty("Depa"), getProperties().getProperty("ZonaUrbana"),
						getProperties().getProperty("Propietario"), getProperties().getProperty("Ubicacion"),
						getProperties().getProperty("NumeroTelefonico"), getProperties().getProperty("Opcion1Tipo"),
						getProperties().getProperty("Opcion2Tipo"), getProperties().getProperty("Opcion3Tipo"),
						getProperties().getProperty("Opcion4Tipo"), getProperties().getProperty("EstadoOpcion"),getProperties().getProperty("Evidencia"));

		// FillFormulary(folderPath, "CodigoBodeg", "oficinaBodeg", "Propietario",
		// "Ubicacion", "NumeroTelefonico");

		GenerarReportePdf.closeTemplate("");
	}
	
	
	
	//PASO A PASO DE CREACION DE UNA BODEGA
		@SuppressWarnings("static-access")
		@Test(priority = 0, description = "Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
		@Severity(SeverityLevel.NORMAL)
		@Description("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
		@Story("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
		public void AlmavivaBodegasScav() throws Exception {
			//VALIDAR ESTOS PASOS EN EXPEDIR TEST EN EL METODO CREAR EXPEDIR
			File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderBodega"),
					getProperties().getProperty("path"));
			
			recording.startRecording("grabando", folderPath);
			
			login(getProperties().getProperty("nameTestBodega"), getProperties().getProperty("usuario"),
					getProperties().getProperty("password"));

			home.modulo(folderPath, getProperties().getProperty("ModuloP"), getProperties().getProperty("SubModuloB"),getProperties().getProperty("Evidencia"));

			//EJECUCION DE LOS CASOS DE BODEGA
			bodega.ScavValidacion_571747(folderPath, getProperties().getProperty("ValorFecha2"), getProperties().getProperty("Evidencia"));
			
			login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
			
			recording.stopRecording();
			
			// FillFormulary(folderPath, "CodigoBodeg", "oficinaBodeg", "Propietario",
			// "Ubicacion", "NumeroTelefonico");

			GenerarReportePdf.closeTemplate("");
		}

	
	
	
	
	
}
