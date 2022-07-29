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
@Epic("Tipos de mercancías")
@Feature("Tipos de mercancías Test")

public class TiposMercanciaTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/TiposMercancia.properties").getAbsolutePath()));
		return fileprops;
	}

	public void login(String nameTest, String usuario, String contrasena) throws Exception {
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderMercancia"),
				getProperties().getProperty("path"));
		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista1"),
				getProperties().getProperty("url"));
		GenerarReportePdf.setImgContador(0);
		
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath);
	}

	@Test(priority = 0, description = "Caso 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar opción Paramétricas")
	@Story("Tipos de Mercancias Funcionalidad Opciones Menú")
	public void TipoMercancia() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderBodega"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestMercancia"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloP"), getProperties().getProperty("SubModuloM"));

		tiposMercancia.validaciones(folderPath).CodigoBuscar(folderPath,
				getProperties().getProperty("codigoMercanciaCrear"),
				getProperties().getProperty("nombreMercanciaCrear"))
		
		.Busqueda(folderPath, getProperties().getProperty("tipos"), getProperties().getProperty("codigo"), getProperties().getProperty("estado"));

		GenerarReportePdf.closeTemplate("");
	}
}
