package com.Reportes.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Reportes.Maps.GenerarReporteMap;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class GenerarReportePage extends GenerarReporteMap {

	Object[] x;
	boolean val;
	int t = 15;

	String CP05 = " 550321, 552088";
	
	public GenerarReportePage(WebDriver driver) {
		super(driver);
	}

	//Paso a paso de generacion de reporte
	@Step("Reportes")
	public GenerarReportePage reportes(File folderPath, String fechaI, String fechaF,String Evidencia) throws Exception {

		//Se envia a dos variable string la fecha actual de sistema para su uso posterior
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
		fechaI = timeStamp;
		fechaF = timeStamp;

		//Tipo de reporte aleatorio y se escriben las fechas inicial y final
		listRandom(lblTipoReporte, folderPath, "Se toma un Reporte aleatorio",Evidencia);
		writeText(lblFechaInicio, fechaI, folderPath, "Se ingresa fecha inicial",Evidencia);
		writeText(lblFechaFin, fechaF, folderPath, "Se ingresa fecha final",Evidencia);

		val = validarElemento(btnDescargar, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
			click(btnDescargar, folderPath, "Se da click sobre descargar",Evidencia);

			val = validarElemento(reporteExitoso, t);

			if (Boolean.TRUE.equals(val)) {
			} else {
				GenerarReportePdf.closeTemplate("Descarga fallida",Evidencia);
				Assert.fail("Error en la validación, no se encontro el elemento");
			}
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, descarga fallida",Evidencia);
			Assert.fail("Error en la validación, descarga fallida");
		}
		
		time(5);
		return this;
	}
	
	
	//Paso a paso de creacion de reporte
	@Step("Reportes")
	public GenerarReportePage reportesCP05(File folderPath, String fechaI, String fechaF, String TipoReporte1,String TipoReporte2,String TipoReporte3,String Evidencia) throws Exception 
	
	
	{
		//Se envia a dos variable string la fecha actual de sistema para su uso posterior
		
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
		fechaI = timeStamp;
		fechaF = timeStamp;

		// OBTENER EL NOMBRE DEL M�TODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		//Seleccion y descarga de los 3 tipos de reporte existentes
		selectElementList(lblTipoReporte, TipoReporte1, folderPath, "seleccionar elemento random de lista",Evidencia);
		writeText(lblFechaInicio, fechaI, folderPath, "Se ingresa fecha inicial",Evidencia);
		writeText(lblFechaFin, fechaF, folderPath, "Se ingresa fecha final",Evidencia);
		click(btnDescargar, folderPath, "Se da click sobre descargar",Evidencia);
		
		selectElementList(lblTipoReporte, TipoReporte2, folderPath, "seleccionar elemento de lista",Evidencia);
		click(btnDescargar, folderPath, "Se da click sobre descargar",Evidencia);
		
		selectElementList(lblTipoReporte, TipoReporte3, folderPath, "seleccionar elemento de lista",Evidencia);
		writeText(lblFechaInicio, fechaI, folderPath, "Se ingresa fecha inicial",Evidencia);
		writeText(lblFechaFin, fechaF, folderPath, "Se ingresa fecha final",Evidencia);
		click(btnDescargar, folderPath, "Se da click sobre descargar",Evidencia);
		
		ValidacionObjeto2(validarElemento(AlertaExitoso, 6), nomTest, folderPath, Evidencia);
		
		
		assertTrue(validarElemento(AlertaExitoso, 6), "Estado del caso: Fallido");
		
        
		//Se valida la alerta de descarga de reporte exitoso
		//boolean alertaexito = validarElemento(AlertaExitoso, 10);
		
		//ValidacionObjeto(alertaexito, "casos exitosos", folderPath,Evidencia);
		
		screenshot(folderPath ,"Estos son los casos: " + CP05);
		
		return this;
		
		
		
	}
	
	
	
}