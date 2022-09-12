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

// TODO: Auto-generated Javadoc
/**
 * The Class CupoTest.
 */
@Listeners({ TestListener.class })
@Epic("Cupo")
@Feature("Cupo Test")

public class CupoTest extends BaseTest {
	
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
		fileprops.load(new FileInputStream(new File("src/test/resources/Cupo.properties").getAbsolutePath()));

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
	//METODO DE LOGIN A PAGINA DE ALMAVIVA
	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		
		//INSTANCIA DE CARPETA DONDE VAMOS A GUARDAR INFORME PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"));

		GenerarReportePdf.setImgContador(0);

		//METODOS QUE TRAEN LAS URL DE ALMAVIVA
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}
	//METODO QUE PERMITE CREAR CUPO

	/**
	 * Crear cupo.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 0, description = "Crear cupo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Creación de cupo")
	public void crearCupo() throws Exception {

		//INSTANCIA DE CARPETA DONDE VAMOS A GUARDAR INFORME PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestCrearCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		cupo.crearCupo(folderPath, getProperties().getProperty("nitC"), getProperties().getProperty("Evidencia"))
		
		        .modalidadesCupo()
				.mercancia(getProperties().getProperty("mercancia"))
				.acreedor(folderPath, getProperties().getProperty("acreedor"));

		GenerarReportePdf.closeTemplate("Cierre de plantilla");
	}

	/**
	 * Modificar cupo.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 1, description = "Modificar cupo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Modificación de cupo")
	public void modificarCupo() throws Exception {

		//INSTANCIA DE CARPETA DONDE VAMOS A GUARDAR INFORME PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestModificarCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		cupo.modificarCupo(folderPath, getProperties().getProperty("mercancia"),
				getProperties().getProperty("acreedor"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("Cierre de plantilla");
	}

	/**
	 * Ver cupo.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 2, description = "Ver cupo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Detalle de cupo")
	public void verCupo() throws Exception {

		//INSTANCIA DE CARPETA DONDE VAMOS A GUARDAR INFORME PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		cupo.verCupo(folderPath,getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("");
	}

	/**
	 * Consultar cupo.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 3, description = "Consultar cupo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Consulta de cupo")
	public void consultarCupo() throws Exception {

		//INSTANCIA DE CARPETA DONDE VAMOS A GUARDAR INFORME PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		cupo.consultaCupo(folderPath, getProperties().getProperty("nit50"), getProperties().getProperty("criterio"),
				getProperties().getProperty("nitConsultar"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("");
	}
}