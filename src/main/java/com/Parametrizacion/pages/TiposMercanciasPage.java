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

	//Paso a paso de validaciones de bodega
	@Step("Validaciones")
	public TiposMercanciasPage validaciones(File folderPath,String Evidencia) throws Exception {

		x = new Object[2];

		x[0] = lblCodigoDeMercanciaObligatorio;
		x[1] = lblNombreDeMercanciaObligatorio;

		//validaciones en tipo de bodega
		click(btnCrearTipoDeMercancia, folderPath, "Adiciona tipo de mercancia",Evidencia);
		click(txtCodigoDeMercanciaCrear, folderPath, "Se da click en campo codigo mercancia",Evidencia);
		click(txtNombreDeMercancia, folderPath, "Se da click en el campo nombre de mercancia",Evidencia);
		click(lblEstadoCrear, folderPath, "Se da click en el campo ",Evidencia);

		val = validarElementos(x, t);

		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento ");
			Assert.fail("Error en la validación: No se encontró el mensaje del elemento ");
		}
		click(btnCancelarCrearPrimeraOpcion, folderPath, "Se selecciona cancelar",Evidencia);
		return this;
	}

	//Busqueda de bodega por codigo
	@Step("Codigo Buscar")
	public TiposMercanciasPage CodigoBuscar(File folderPath, String codigoMercanciaCrear, String nombreMercanciaCrear,String Evidencia)
			throws Exception {

		//Se busca una bodega por codigo
		click(btnCrearTipoDeMercancia, folderPath, "Adiciona tipo de mercancia",Evidencia);
		writeText(txtCodigoDeMercanciaCrear, codigoMercanciaCrear, folderPath, "Se digita codigo de mercancia",Evidencia);
		writeText(txtNombreDeMercancia, nombreMercanciaCrear, folderPath, codigoMercanciaCrear,Evidencia);
		click(lblEstadoCrear, folderPath, "Se selecciona el menu estado",Evidencia);
		click(lblEstadoInactivoCrear, folderPath, "Se selecciona estado inactivo",Evidencia);
		click(lblEstadoCrear, folderPath, "Se selecciona el menu estado",Evidencia);
		click(lblEstadoActivoCrear, folderPath, "Se selecciona estado activo",Evidencia);
		click(btnCancelarCrearPrimeraOpcion,folderPath,"Se selecciona cancelar",Evidencia);
		return this;
	}

	//Busqueda general de bodega
	@Step("Busqueda General")
	public TiposMercanciasPage Busqueda(File folderPath, String tipos, String codigo, String estado,String Evidencia) throws Exception {

		//Se selecciona una de las opciones de busqueda,se busca el codigo
		selectElementList(lblOpcionBusqueda, tipos, folderPath, "Selecciona elemento de lista",Evidencia);
		writeText(txtCampoBuscar, codigo, folderPath, "digita codigo",Evidencia);
		click(btnBuscar, folderPath, "click en buscar",Evidencia);
		
		click(btnModificar, folderPath, "Se da click en modificar registro",Evidencia);
		selectElementList(lblEstadoInactivoModificar, estado, folderPath, "Seleccionar elemento de lista",Evidencia);
		//writeText(txtCampoBuscar, codigoMercanciaNuevo, folderPath, "Busqueda de tipo de mercancia");
		return this;
	}
}
