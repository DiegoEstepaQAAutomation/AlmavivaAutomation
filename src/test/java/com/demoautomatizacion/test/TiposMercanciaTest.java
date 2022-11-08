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

	//INSTANCIA DE PROPIEDADES(ARCHIVO PLANO CON PROPERTIES QUE UTILIZAREMOS)
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/TiposMercancia.properties").getAbsolutePath()));
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
	@Test(priority = 0, description = "Caso 1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar opción Paramétricas")
	@Story("Tipos de Mercancias Funcionalidad Opciones Menú")
	public void TipoMercancia() throws Exception {

		
		//INSTANCIA DE RUTA DONDE GUARDAMOS INFORME PDF DE EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderBodega"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestMercancia"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		//INSTANCIA DE METODO DE INGRESO A MODULO Y SUBMODULO
		home.modulo(folderPath, getProperties().getProperty("ModuloP"), getProperties().getProperty("SubModuloM"),getProperties().getProperty("Evidencia"));

		
		//VALIDACIONES DE TIPO DE MERCANCIA Y BUSQUEDA
		tiposMercancia.validaciones(folderPath,getProperties().getProperty("Evidencia")).CodigoBuscar(folderPath,
				getProperties().getProperty("codigoMercanciaCrear"),
				getProperties().getProperty("nombreMercanciaCrear"),getProperties().getProperty("Evidencia"))
		
		.Busqueda(folderPath, getProperties().getProperty("tipos"), getProperties().getProperty("codigo"),
				getProperties().getProperty("estado"),getProperties().getProperty("Evidencia"));

		//CIERRE DE PLANTILLA
		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}
}
