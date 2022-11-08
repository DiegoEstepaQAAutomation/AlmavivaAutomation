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
	
	//INSTANCIA DE PROPIEDADES(ARCHIVO PLANO CON PROPERTIES)
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        return fileprops;
    }
	
	//METODO PARA LOGUEARSE AL PORTAL DE ALMAVIVA
	public void login2(String nameTest, String usuario, String contrasena,String Evidencia) throws Exception 
	{

		//INSTANCIA DEL METODO DE GENERAR EL REPORTE PDF
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		//INSTANCIA DE LA RUTA DONDE GUARDAMOS EL PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderG"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.setImgContador(0);

		//LLAMADO DE CREDENCIALES Y LA RUTA URL DEL PORTAL DE ALMAVIVA
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}

	@Test(priority=0, description="Unidades de Medida")
    @Severity(SeverityLevel.NORMAL)
    @Description("Unidades de Medida")
    @Story("Unidades de Medida")
    public void ingresarPortalAlmaviva () throws Exception {
		
		//INSTANCIA DE RUTA DONDE GUARDAMOS EL INFORME PDF DE LA EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderUnidad"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestUnidad"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));
		//INGRESO A MODULO,VALIDACIONES Y CIERRE DE PLANTILLA
		home.modulo(folderPath, getProperties().getProperty("ModuloP"),
				getProperties().getProperty("SubModuloU"),getProperties().getProperty("Evidencia"));

		medidas.validacion(folderPath,getProperties().getProperty("Evidencia")) 
		
		.crearModulo(folderPath, 
		getProperties().getProperty("CodBodega"),
		getProperties().getProperty("Resume"),
		getProperties().getProperty("Evidencia"))
		.busqueda(folderPath, 
		getProperties().getProperty("Umedida"), 
		getProperties().getProperty("Resume"),
		getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
    }
}