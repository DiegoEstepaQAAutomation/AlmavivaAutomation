package com.Parametrizacion.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Parametrizacion.Maps.TipoMercanciaMap;

import java.io.File;

import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class TiposMercanciasPage extends TipoMercanciaMap {

	Object[] x;
	boolean val;
	int t = 15;

	public TiposMercanciasPage(WebDriver driver) {
		super(driver);
	}

	@Step("Validaciones")
	public TiposMercanciasPage validaciones(File folderPath) throws Exception {

		x = new Object[2];

		x[0] = lblCodigoDeMercanciaObligatorio;
		x[1] = lblNombreDeMercanciaObligatorio;

		click(btnCrearTipoDeMercancia, folderPath, "Adiciona tipo de mercancia");
		click(txtCodigoDeMercanciaCrear, folderPath, "Se da click en campo codigo mercancia");
		click(txtNombreDeMercancia, folderPath, "Se da click en el campo nombre de mercancia");
		click(lblEstadoCrear, folderPath, "Se da click en el campo ");

		val = validarElementos(x, t);

		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento ");
			Assert.fail("Error en la validación: No se encontró el mensaje del elemento ");
		}
		click(btnCancelarCrearPrimeraOpcion, folderPath, "Se selecciona cancelar");
		return this;
	}

	@Step("Codigo Buscar")
	public TiposMercanciasPage CodigoBuscar(File folderPath, String codigoMercanciaCrear, String nombreMercanciaCrear)
			throws Exception {

		click(btnCrearTipoDeMercancia, folderPath, "Adiciona tipo de mercancia");
		writeText(txtCodigoDeMercanciaCrear, codigoMercanciaCrear, folderPath, "Se digita codigo de mercancia");
		writeText(txtNombreDeMercancia, nombreMercanciaCrear, folderPath, codigoMercanciaCrear);
		click(lblEstadoCrear, folderPath, "Se selecciona el menu estado");
		click(lblEstadoInactivoCrear, folderPath, "Se selecciona estado inactivo");
		click(lblEstadoCrear, folderPath, "Se selecciona el menu estado");
		click(lblEstadoActivoCrear, folderPath, "Se selecciona estado activo");
		click(btnCancelarCrearPrimeraOpcion,folderPath,"Se selecciona cancelar");
		return this;
	}

	@Step("Busqueda General")
	public TiposMercanciasPage Busqueda(File folderPath, String tipos, String codigo, String estado) throws Exception {

		selectElementList(lblOpcionBusqueda, tipos, folderPath, "");
		writeText(txtCampoBuscar, codigo, folderPath, "");
		click(btnBuscar, folderPath, "");
		
		click(btnModificar, folderPath, "Se da click en modificar registro");
		selectElementList(lblEstadoInactivoModificar, estado, folderPath, "");
		//writeText(txtCampoBuscar, codigoMercanciaNuevo, folderPath, "Busqueda de tipo de mercancia");
		return this;
	}
}
