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
	public BodegasPage Parametrizacion(File folderPath,String Evidencia) throws Exception {

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
		click(crearBodega, folderPath, "Se da click sobre bodega",Evidencia);
		click(CodigoB, folderPath, "Se da click sobre la opcion codigo bodega",Evidencia);
		click(Oficina, folderPath, "Se da click sobre la opcion Oficina",Evidencia);
		click(Pais, folderPath, "Se da click en la opcion Pais",Evidencia);
		click(Departamento, folderPath, "Se da click en la opcion Departamento",Evidencia);
		click(Ciudad, folderPath, "Se da click en la opcion Ciudad",Evidencia);
		click(Nombre, folderPath, "Se da click en la opcion Nombre",Evidencia);
		click(Direccion, folderPath, "Se da click en la opcion Direccion",Evidencia);
		click(Telefono, folderPath, "Se da click sobre la opcion telefono",Evidencia);
		click(TipoBodega, folderPath, "Se selecciona la opcion tipo de bodega",Evidencia);
		click(Estado, folderPath, "Se selecciona la opcion estado",Evidencia);

		val = validarElementos(x, t);

		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento ",Evidencia);
			Assert.fail("Error en la validación: No se encontró el mensaje del elemento ");
		}

		click(Cancelar, folderPath, "Se selecciona la opcion cancelar ",Evidencia);
		return this;
	}

	//Formulario de creacion de bodega 
	@Step("Ingresar a Parametrizacion")
	public BodegasPage fillFormulary(File folderPath, String CodigoBodeg, String oficinaBodeg, String Nacion, String Depa,
			String ZonaUrbana, String Propietario, String Ubicacion, String NumeroTelefonico, 
			String Opcion1tipo, String Opcion2Tipo, String Opcion3Tipo, String Opcion4Tipo, String EstadoOpcion,String Evidencia)
			throws Exception {

		//Formulario de creacion de bodega, elementos de pais,ciudad,oficina y departamento 
		click(crearBodega, folderPath, "Se da click sobre bodega",Evidencia);
		writeText(CodigoB, CodigoBodeg, folderPath, "Se escribe Codigo Bodega",Evidencia);
		selectElementList(Oficina, oficinaBodeg, folderPath, "Se selecciona la Oficina",Evidencia);
		selectElementList(Pais, Nacion, folderPath, "Se selecciona Pais",Evidencia);
		selectElementList(Departamento, Depa, folderPath, "Se selecciona Departamento",Evidencia);
		selectElementList(Ciudad, ZonaUrbana, folderPath, "Se selecciona la Ciudad",Evidencia);
		writeText(Nombre, Propietario, folderPath, "Se escribe El nombre de la bodega",Evidencia);
		writeText(Direccion, Ubicacion, folderPath, "Se escribe Direccion",Evidencia);
		writeText(Telefono, NumeroTelefonico, folderPath, "Se escribe Numero Telefonico",Evidencia);
		scrollElementV(folderPath, TipoBodega, "Se desplaza hasta la opción Tipo de bodega",Evidencia);
		selectElementList(lblTipoBodega, Opcion1tipo, folderPath, "Se selecciona tipo de bodega Propia",Evidencia);
		click(cbxDLX, folderPath, "click en checkbox de dlx",Evidencia);
		//Tipos de bodega se selecciona tipo de bodega
		selectElementList(lblTipoBodega, Opcion2Tipo, folderPath, "Se selecciona tipo de bodega Particular",Evidencia);
		selectElementList(lblTipoBodega, Opcion3Tipo, folderPath, "Se selecciona la opcion tipo de bodega Particular Arrendada",Evidencia);
		selectElementList(lblTipoBodega, Opcion4Tipo, folderPath, "Se selecciona la  opcion tipo de bodega Tránsito",Evidencia);
		selectElementList(lblEstado, EstadoOpcion, folderPath, "Se selecciona el estado",Evidencia);
		// Aceptar
		// Guardar
		click(Guardar, folderPath, "Se da click sobre Guardar",Evidencia);
		click(Aceptar, folderPath, "Se da click sobre Aceptar",Evidencia);
		click(Ver, folderPath, "Se da click sobre Ver",Evidencia);
		
		return this;
	}
	
	//Crear bodega 
		@Step("Ingresar a Parametrizacion")
		public BodegasPage ScavValidacion_571747(File folderPath,String ValorFecha2,String Evidencia) throws Exception 
		
		
		{
			
			
			searchElementGrid(GridConsecutivo, "283", folderPath, Evidencia, Evidencia);
			scrollElementH(folderPath, btnVisualizar, Evidencia, Evidencia);
			click(btnVisualizar, folderPath, Evidencia, Evidencia);
			time(2);
			boolean alertaConsultaBodega = validarElemento(AlertaBusqueda, 6);
			ValidacionObjeto(alertaConsultaBodega, Evidencia, folderPath, Evidencia);
			scrollDown();
			scrollDown();
			scrollDown();
			click(btnScav, folderPath, "Click en scav", Evidencia);
			scrollDown();
			scrollDown();
			searchElementGrid(GridScav, ValorFecha2, folderPath, Evidencia, Evidencia);
			
			
			String Confirmacion = readText(txtScavConsecutive, folderPath, "Obtenemos el consecutivo", Evidencia);
			
			isEnabled(txtScavConsecutive, folderPath,"El consecutivo es"+ Confirmacion, Evidencia);
			
			click(btnScav, folderPath, "Click en scav", Evidencia);
			
			
			//GridConsecutivo
			
			
			
			return this;
		}
	
	
}
