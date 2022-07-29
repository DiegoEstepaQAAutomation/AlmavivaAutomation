package com.Visitas.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Visitas.Maps.ConsultarRegistroVisitaMap;
import java.io.File;
import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class ConsultarRegistroVisitaPage extends ConsultarRegistroVisitaMap {

	Object[] x;
	boolean val;
	int t = 15;

	public ConsultarRegistroVisitaPage(WebDriver driver) {
		super(driver);
	}

	@Step("Consultar registro de visita")
	public ConsultarRegistroVisitaPage consultarRegistroV(File folderPath) throws Exception {

		etiquetas(btnCrearRegistrarVisita, folderPath, "");
		click(btnCrearRegistrarVisita, folderPath, "");
		scrollElementH(btnAccion);
		etiquetas(btnAccion, folderPath, "");
		click(btnAccion, folderPath, "");

		// Registro de Visita
		click(locatorVariable(lblOpciones, " Registro de Visita "), folderPath, "Se ingresa a Registro de Visita");
		writeText(txtFechaVisita, datePlusYear(1));
		writeRandomAlp(txtNombreVisitador, 50);
		click(locatorVariable(lblOpciones, " Registro de Visita "), folderPath, "");

		// Información General del Cliente
		click(locatorVariable(lblOpciones, " Información General del Cliente "), folderPath, "Se ingresa a Información General del Título");
		isEnabled(txtNombreCliente, folderPath, "Campo Nombre del Cliente No editable");
		isEnabled(txtNitCliente, folderPath, "Campo Nit del Cliente No editable");
		click(locatorVariable(lblOpciones, " Información General del Cliente "), folderPath, "Se ingresa a Información General del Título");

		// Información General de la bodega
		click(locatorVariable(lblOpciones, " Información General de la bodega "), folderPath, "Se ingresa a Información General del Título");
		selectElementList(lblTomaAnalsisCalidad, "No", folderPath, "");
		selectElementList(lblPesajeAleatorio, "Si", folderPath, "");
		selectElementList(lblTomaRegistroFotografico, "No", folderPath, "");
		selectElementList(lblAcompanamientoDirector, "Si", folderPath, "");
		desplazarseVertical(0, -160);
		click(locatorVariable(lblOpciones, " Información General de la bodega "), folderPath, "Se ingresa a Información General del Título");

		// Condiciones de bodega
		click(locatorVariable(lblOpciones, " Condiciones de bodega "), folderPath, "Se ingresa a Información General del Título");
		writeRandomAlp(txtEstadoSeguridadOA, 60);
		writeRandomAlp(txtEstadoSeguridadMercancia, 90);
		writeRandomAlp(txtEstadoInstalacionesElectricas, 120);
		click(locatorVariable(lblOpciones, " Condiciones de bodega "), folderPath, "Se ingresa a Información General del Título");
		click(btnCancelarConsultarRegistroVisita, folderPath, "");

		val = validarElemento(lblRegistrarVisita, t);
		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error");
			Assert.fail("Error");
		}
		return this;
	}
}