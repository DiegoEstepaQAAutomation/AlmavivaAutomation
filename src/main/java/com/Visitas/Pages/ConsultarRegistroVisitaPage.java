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
	public ConsultarRegistroVisitaPage consultarRegistroV(File folderPath,String Evidencia) throws Exception {

		etiquetas(btnCrearRegistrarVisita, folderPath, "Validacion de etiqueta crear registro visita",Evidencia);
		click(btnCrearRegistrarVisita, folderPath, "click en registro visita",Evidencia);
		scrollElementH(btnAccion);
		etiquetas(btnAccion, folderPath, "validacion de etiqueta accion",Evidencia);
		click(btnAccion, folderPath, "click en boton de registro",Evidencia);

		// Registro de Visita
		click(locatorVariable(lblOpciones, " Registro de Visita "), folderPath, "Se ingresa a Registro de Visita",Evidencia);
		writeText(txtFechaVisita, datePlusYear(1));
		writeRandomAlp(txtNombreVisitador, 50);
		click(locatorVariable(lblOpciones, " Registro de Visita "), folderPath, "click en opciones",Evidencia);

		// Informaci�n General del Cliente
		click(locatorVariable(lblOpciones, " Informaci�n General del Cliente "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);
		isEnabled(txtNombreCliente, folderPath, "Campo Nombre del Cliente No editable",Evidencia);
		isEnabled(txtNitCliente, folderPath, "Campo Nit del Cliente No editable",Evidencia);
		click(locatorVariable(lblOpciones, " Informaci�n General del Cliente "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);

		// Informaci�n General de la bodega
		click(locatorVariable(lblOpciones, " Informaci�n General de la bodega "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);
		selectElementList(lblTomaAnalsisCalidad, "No", folderPath, "seleccion de elemento de lista",Evidencia);
		selectElementList(lblPesajeAleatorio, "Si", folderPath, "Seleccion de elemento de lista",Evidencia);
		selectElementList(lblTomaRegistroFotografico, "No", folderPath, "Seleccion de elemento de lista",Evidencia);
		selectElementList(lblAcompanamientoDirector, "Si", folderPath, "Seleccion de elemento de lista",Evidencia);
		desplazarseVertical(0, -160);
		click(locatorVariable(lblOpciones, " Informaci�n General de la bodega "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);

		// Condiciones de bodega
		click(locatorVariable(lblOpciones, " Condiciones de bodega "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);
		writeRandomAlp(txtEstadoSeguridadOA, 60);
		writeRandomAlp(txtEstadoSeguridadMercancia, 90);
		writeRandomAlp(txtEstadoInstalacionesElectricas, 120);
		click(locatorVariable(lblOpciones, " Condiciones de bodega "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);
		click(btnCancelarConsultarRegistroVisita, folderPath, "click en elemento",Evidencia);

		val = validarElemento(lblRegistrarVisita, t);
		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error",Evidencia);
			Assert.fail("Error");
		}
		return this;
	}
}