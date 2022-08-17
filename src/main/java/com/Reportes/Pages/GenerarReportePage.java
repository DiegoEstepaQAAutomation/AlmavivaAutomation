package com.Reportes.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Reportes.Maps.GenerarReporteMap;
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
	public GenerarReportePage reportes(File folderPath, String fechaI, String fechaF) throws Exception {

		//Se envia a dos variable string la fecha actual de sistema para su uso posterior
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
		fechaI = timeStamp;
		fechaF = timeStamp;

		//Tipo de reporte aleatorio y se escriben las fechas inicial y final
		listRandom(lblTipoReporte, folderPath, "Se toma un Reporte aleatorio");
		writeText(lblFechaInicio, fechaI, folderPath, "Se ingresa fecha inicial");
		writeText(lblFechaFin, fechaF, folderPath, "Se ingresa fecha final");

		val = validarElemento(btnDescargar, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
			click(btnDescargar, folderPath, "Se da click sobre descargar");

			val = validarElemento(reporteExitoso, t);

			if (Boolean.TRUE.equals(val)) {
			} else {
				GenerarReportePdf.closeTemplate("Descarga fallida");
				Assert.fail("Error en la validación, no se encontro el elemento");
			}
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, descarga fallida");
			Assert.fail("Error en la validación, descarga fallida");
		}
		return this;
	}
	
	
	//Paso a paso de creacion de reporte
	@Step("Reportes")
	public GenerarReportePage reportesCP05(File folderPath, String fechaI, String fechaF, String TipoReporte1,String TipoReporte2,String TipoReporte3) throws Exception 
	
	
	{
		//Se envia a dos variable string la fecha actual de sistema para su uso posterior
		
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
		fechaI = timeStamp;
		fechaF = timeStamp;

		//Seleccion y descarga de los 3 tipos de reporte existentes
		selectElementList(lblTipoReporte, TipoReporte1, folderPath, "");
		writeText(lblFechaInicio, fechaI, folderPath, "Se ingresa fecha inicial");
		writeText(lblFechaFin, fechaF, folderPath, "Se ingresa fecha final");
		click(btnDescargar, folderPath, "Se da click sobre descargar");
		
		selectElementList(lblTipoReporte, TipoReporte2, folderPath, "");
		click(btnDescargar, folderPath, "Se da click sobre descargar");
		
		selectElementList(lblTipoReporte, TipoReporte3, folderPath, "");
		writeText(lblFechaInicio, fechaI, folderPath, "Se ingresa fecha inicial");
		writeText(lblFechaFin, fechaF, folderPath, "Se ingresa fecha final");
		click(btnDescargar, folderPath, "Se da click sobre descargar");
		//Se valida la alerta de descarga de reporte exitoso
		boolean alertaexito = validarElemento(AlertaExitoso, 10);
		
		ValidacionObjeto(alertaexito, "casos exitosos", folderPath);
		
		screenshot(folderPath ,"Estos son los casos: " + CP05);
		
		return this;
		
		
		
	}
	
	
	
}