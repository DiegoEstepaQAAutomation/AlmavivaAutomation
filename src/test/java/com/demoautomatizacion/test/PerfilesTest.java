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
@Epic("Perfiles")
@Feature("Perfiles Tests")

public class PerfilesTest extends BaseTest {
	
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Perfiles.properties").getAbsolutePath()));
		
		return fileprops;
	}

	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"));

		GenerarReportePdf.setImgContador(0);

		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"), folderPath);
	}

	@Test(priority = 0, description = "Crear perfil")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Perfiles")
	@Story("Creación de perfil")
	public void crearPerfil() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestCrearPerfil"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloP"));

		//EJECUCION DE METODOS ASOCIADOS A CREAR UN PERFIL EN ALMAVIVA
		perfiles.obligatoriedadCampos(folderPath)
				
		.caracteres50100(folderPath, getProperties().getProperty("nombre50"),
						getProperties().getProperty("descripcion100"),
						getProperties().getProperty("nom50"),
						getProperties().getProperty("desc100"))
				
				.cancelarPerfil(folderPath)

				.crearPerfil(folderPath, getProperties().getProperty("nombre"),
						getProperties().getProperty("descripcion"))
		 .guardarPerfil(folderPath);
		 //.aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("");
	}  
	
	@Test(priority = 1, description = "Modificar perfil")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Perfiles")
	@Story("Modificación de perfil")
	public void modificarPerfil() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestModificarPerfil"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloP"));

		perfiles.modificarPerfil(folderPath, getProperties().getProperty("descripcion"),
				getProperties().getProperty("estadoI"))
		.guardarPerfil(folderPath);
		 //.aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("");
	}
	
	@Test(priority = 2, description = "Ver perfil")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Perfiles")
	@Story("Detalle de perfil")
	public void verPerfil() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerPerfil"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloP"));

		perfiles.verPerfil(folderPath);

		GenerarReportePdf.closeTemplate("");
	}
	
	@Test(priority = 3, description = "Consultar perfil")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Perfiles")
	@Story("Consulta de perfil")
	public void consultarUsuario() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestConsultarPerfil"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloP"));

		perfiles.botonesPerfil(folderPath)

		.consultaPerfil(folderPath, getProperties().getProperty("nom50"), getProperties().getProperty("nombrePerfil"));

		GenerarReportePdf.closeTemplate("");
	}
}
