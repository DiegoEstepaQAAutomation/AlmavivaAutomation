package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(UnidadesMedidaTest.class.getName());
	public Properties fileprops = new Properties();
	
	//INSTANCIA DE PROPIEDADES(ARCHIVO PLANO CON PROPERTIES)
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        return fileprops;
    }
	
	public void login(String nameTest, String usuario, String contrasena) throws Exception {
		
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		//INSTANCIA DE RUTA DONDE GUARDAMOS EL INFORME PDF DE LA EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderUnidad"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		//INSTANCIA DE METODOS DE CREACION DE INFORME PDF
		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista1"),
				getProperties().getProperty("url"),getProperties().getProperty("Evidencia"));
		GenerarReportePdf.setImgContador(0);

		
		//METODOS DE INGRESO A PORTAL ALMAVIVA E INGRESO DE CREDENCIALES 
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


		System.setProperty("testname", nomClass);

		log.info("INICIA LA EJECUCION DE LA CLASE "+nomClass);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		//INSTANCIA DE RUTA DONDE GUARDAMOS EL INFORME PDF DE LA EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderUnidad"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestUnidad"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"));
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

		log.info("FINALIZA LA EJECUCION DEL TEST");
    }
}