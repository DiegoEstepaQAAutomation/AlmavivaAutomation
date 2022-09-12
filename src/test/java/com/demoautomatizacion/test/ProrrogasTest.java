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
@Epic("Prorrogas")
@Feature("Prorrogas Test")

public class ProrrogasTest extends BaseTest {
	//INSTANCIA DE PROPIEDADES Y RUTA EN DONDE SE ENCUENTRAN DETERMINADAS PROPIEDADES
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		return fileprops;
	}
	
	//METODO DE LOGIN AL PORTAL DE ALMAVIVA
	public void login(String nameTest, String usuario, String contrasena) throws Exception {
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		//INSTANCIA DE RUTA EN DONDE SE GUARDAN LOS INFORMES PDF DE LA EJECUCION DE LA AUTOMATIZACION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderProrroga"),
				getProperties().getProperty("path"));
		//INSTANCIA DE LOS METODOS DE GENERAR INFORME PDF
		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista1"),
				getProperties().getProperty("url"));
		GenerarReportePdf.setImgContador(0);

		//INSTANCIA DE INGRESO DE URL Y CREDENCIALES
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}

	
	//METODO DE BODEGAS 
	@Test(priority = 0, description = "Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Story("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	public void AlmavivaBodegas1() throws Exception {
		//INSTANCIA DE RUTA EN DONDE SE GUARDAN LOS INFORMES PDF DE LA EJECUCION DE LA AUTOMATIZACION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderProrroga"),
				getProperties().getProperty("path"));

		//METODO DE LOGIN,MODULO Y PRORROGAS
		login(getProperties().getProperty("nameTestProrroga"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		prorroga.prorrogas(folderPath,getProperties().getProperty("Evidencia"));	
		
		GenerarReportePdf.closeTemplate("Cerrar plantilla");
	}
	
	
	
	
	@Test(priority = 0, description = "Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Story("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	public void AlmavivaProrrogas() throws Exception {
		//INSTANCIA DE RUTA EN DONDE SE GUARDAN LOS INFORMES PDF DE LA EJECUCION DE LA AUTOMATIZACION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderProrroga"),
				getProperties().getProperty("path"));
		
		//METODO DE LOGIN,MODULO Y PRORROGAS

		login(getProperties().getProperty("nameTestProrroga"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		prorroga.prorrogasHU24(folderPath,getProperties().getProperty("TituloModificarProrroga"),getProperties().getProperty("Evidencia"));	
		
		GenerarReportePdf.closeTemplate("Cerrar plantilla");
	}

	
}