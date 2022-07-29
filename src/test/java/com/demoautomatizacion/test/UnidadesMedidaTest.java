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
@Epic("Unidades de Medida")
@Feature("Unidades de Medida Test")

public class UnidadesMedidaTest extends BaseTest{
	public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        return fileprops;
    }
	
	public void login(String nameTest, String usuario, String contrasena) throws Exception {
		
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderUnidad"),
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

	@Test(priority=0, description="Unidades de Medida")
    @Severity(SeverityLevel.NORMAL)
    @Description("Unidades de Medida")
    @Story("Unidades de Medida")
    public void ingresarPortalAlmaviva () throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderUnidad"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestUnidad"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"));
		
		home.modulo(folderPath, getProperties().getProperty("ModuloP"), getProperties().getProperty("SubModuloU"));

		medidas.validacion(folderPath) 
		
		.crearModulo(folderPath, 
		getProperties().getProperty("CodBodega"),
		getProperties().getProperty("Resume"))
		.busqueda(folderPath, 
		getProperties().getProperty("Umedida"), 
		getProperties().getProperty("Resume"));
		
		GenerarReportePdf.closeTemplate("");
    }
}