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
@Epic("Cupo")
@Feature("Cupo Test")

public class CupoTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Cupo.properties").getAbsolutePath()));

		return fileprops;
	}

	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
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

	@Test(priority = 0, description = "Crear cupo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Creación de cupo")
	public void crearCupo() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestCrearCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		cupo.crearCupo(folderPath, getProperties().getProperty("nitC")).modalidadesCupo()
				.mercancia(getProperties().getProperty("mercancia"))
				.acreedor(folderPath, getProperties().getProperty("acreedor"));

		GenerarReportePdf.closeTemplate("");
	}

	@Test(priority = 1, description = "Modificar cupo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Modificación de cupo")
	public void modificarCupo() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestModificarCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		cupo.modificarCupo(folderPath, getProperties().getProperty("mercancia"),
				getProperties().getProperty("acreedor"));

		GenerarReportePdf.closeTemplate("");
	}

	@Test(priority = 2, description = "Ver cupo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Detalle de cupo")
	public void verCupo() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		cupo.verCupo(folderPath);

		GenerarReportePdf.closeTemplate("");
	}

	@Test(priority = 3, description = "Consultar cupo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Consulta de cupo")
	public void consultarCupo() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		cupo.consultaCupo(folderPath, getProperties().getProperty("nit50"), getProperties().getProperty("criterio"),
				getProperties().getProperty("nitConsultar"));

		GenerarReportePdf.closeTemplate("");
	}

/////////

	@SuppressWarnings("static-access")
	@Test(priority = 4, description = "Validar que en el modulo de cupos en la grilla modalidad de cupo se visualize")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Cupo")
	@Story("Validar Grilla")
	public void consultarCupoGrilla() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		// recording.startRecording("", folderPath);

		login(getProperties().getProperty("nameTestVerCupo"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		cupo.validarGrilla_548478(folderPath, getProperties().getProperty("Razon"),
				getProperties().getProperty("Empresa"), getProperties().getProperty("Empresa2"),
				getProperties().getProperty("Saldo"), getProperties().getProperty("ModuloT"),
				getProperties().getProperty("SubModuloExpedir"), getProperties().getProperty("Numero"),
				getProperties().getProperty("Estado"), getProperties().getProperty("ModuloC"),
				getProperties().getProperty("SubModuloCupo"), getProperties().getProperty("particular"),
				getProperties().getProperty("SubModuloAutorizarMercancia"), getProperties().getProperty("Comida"),
				getProperties().getProperty("CupoDisponible"), getProperties().getProperty("SaldoUtilizado"),
				getProperties().getProperty("ValorParticular"), getProperties().getProperty("ValorParticularArrendado"),
				getProperties().getProperty("Propia"), getProperties().getProperty("Transito"),
				getProperties().getProperty("ModificarNumero"), getProperties().getProperty("ModuloG"),
				getProperties().getProperty("SubModuloReporte"));

		generarReporte.reportes(folderPath, getProperties().getProperty("FechaI"),
				getProperties().getProperty("FechaF"));
		
		login.cerrarSesion(folderPath);
		
		// recording.stopRecording();

		GenerarReportePdf.closeTemplate("");
	}
}