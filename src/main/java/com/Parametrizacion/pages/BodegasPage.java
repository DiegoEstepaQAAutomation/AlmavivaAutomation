package com.Parametrizacion.pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Parametrizacion.Maps.BodegaMap;

import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class BodegasPage extends BodegaMap {

	Object[] x;
	boolean val;
	int t = 15;

	public BodegasPage(WebDriver driver) {
		super(driver);
	}

	//Crear bodega 
	@Step("Ingresar a Parametrizacion")
	public BodegasPage Parametrizacion(File folderPath) throws Exception {

		x = new Object[8];

		x[0] = Obligatorio1;
		x[1] = Obligatorio2;
		x[2] = Obligatorio3;
		x[3] = Obligatorio4;
		x[4] = Obligatorio5;
		x[5] = Obligatorio6;
		x[6] = Obligatorio7;
		x[7] = Obligatorio8;

		//Paso a paso de crear bodega con todos los elementos necesarios, funciona basicamente con clicks
		click(crearBodega, folderPath, "Se da click sobre bodega");
		click(CodigoB, folderPath, "Se da click sobre la opcion codigo bodega");
		click(Oficina, folderPath, "Se da click sobre la opcion Oficina");
		click(Pais, folderPath, "Se da click en la opcion Pais");
		click(Departamento, folderPath, "Se da click en la opcion Departamento");
		click(Ciudad, folderPath, "Se da click en la opcion Ciudad");
		click(Nombre, folderPath, "Se da click en la opcion Nombre");
		click(Direccion, folderPath, "Se da click en la opcion Direccion");
		click(Telefono, folderPath, "Se da click sobre la opcion telefono");
		click(TipoBodega, folderPath, "Se selecciona la opcion tipo de bodega");
		click(Estado, folderPath, "Se selecciona la opcion estado");

		val = validarElementos(x, t);

		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento ");
			Assert.fail("Error en la validación: No se encontró el mensaje del elemento ");
		}

		click(Cancelar, folderPath, "Se selecciona la opcion cancelar ");
		return this;
	}

	//Formulario de creacion de bodega 
	@Step("Ingresar a Parametrizacion")
	public BodegasPage fillFormulary(File folderPath, String CodigoBodeg, String oficinaBodeg, String Nacion, String Depa,
			String ZonaUrbana, String Propietario, String Ubicacion, String NumeroTelefonico, 
			String Opcion1tipo, String Opcion2Tipo, String Opcion3Tipo, String Opcion4Tipo, String EstadoOpcion)
			throws Exception {

		//Formulario de creacion de bodega, elementos de pais,ciudad,oficina y departamento 
		click(crearBodega, folderPath, "Se da click sobre bodega");
		writeText(CodigoB, CodigoBodeg, folderPath, "Se escribe Codigo Bodega");
		selectElementList(Oficina, oficinaBodeg, folderPath, "Se selecciona la Oficina");
		selectElementList(Pais, Nacion, folderPath, "Se selecciona Pais");
		selectElementList(Departamento, Depa, folderPath, "Se selecciona Departamento");
		selectElementList(Ciudad, ZonaUrbana, folderPath, "Se selecciona la Ciudad");
		writeText(Nombre, Propietario, folderPath, "Se escribe El nombre de la bodega");
		writeText(Direccion, Ubicacion, folderPath, "Se escribe Direccion");
		writeText(Telefono, NumeroTelefonico, folderPath, "Se escribe Numero Telefonico");
		scrollElementV(folderPath, TipoBodega, "Se desplaza hasta la opción Tipo de bodega");
		selectElementList(lblTipoBodega, Opcion1tipo, folderPath, "Se selecciona tipo de bodega Propia");
		click(cbxDLX, folderPath, "");
		//Tipos de bodega
		selectElementList(lblTipoBodega, Opcion2Tipo, folderPath, "Se selecciona tipo de bodega Particular");
		selectElementList(lblTipoBodega, Opcion3Tipo, folderPath, "Se selecciona la opcion tipo de bodega Particular Arrendada");
		selectElementList(lblTipoBodega, Opcion4Tipo, folderPath, "Se selecciona la  opcion tipo de bodega Tránsito");
		selectElementList(lblEstado, EstadoOpcion, folderPath, "Se selecciona el estado");
		// Aceptar
		// Guardar
		click(Guardar, folderPath, "Se da click sobre Guardar");
		click(Aceptar, folderPath, "Se da click sobre Aceptar");
		click(Ver, folderPath, "Se da click sobre Ver");
		
		return this;
	}
}
