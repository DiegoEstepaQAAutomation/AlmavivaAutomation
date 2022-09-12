package com.Notificaciones.Pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ExpedirTitulo.Pages.ExpedirrPage;
import com.NotificacionesMap.NotificacionesMap;
import com.Titulo.Pages.ExpedirPage;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class NotificacionesPage extends NotificacionesMap {


	
	public NotificacionesPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	//Paso a paso del proceso de asociar una notificacion
	
	@Step("Bono de Prenda")
	public NotificacionesPage Notificacion_557159(File folderPath,String DatoFaltante,
			String ModuloCliente,String Submodulo,String FechaDeCargue,String estadoA,String Encabezado,String Evidencia)
			throws Exception {

		//se selecciona un tipo de notificacion, se asigna a una persona y se confirma y acepta
		click(lblNotificaciones2, folderPath, "click en menu desplegable de notificaciones",Evidencia);
		selectElementList(lblNotificaciones2, DatoFaltante, folderPath, "Seleccion de dato faltante",Evidencia);
		click(btnAgregarNuevo, folderPath, "click en agregar nueva notificacion",Evidencia);
		writeText(BTitulo, "mauricio", folderPath, DatoFaltante,Evidencia);
		click(btnAsignarA, folderPath, "click en asignar",Evidencia);
		click(chxAsignacion, folderPath, "click en un check ",Evidencia);
		click(btnConfirm, folderPath, "click en confirmar",Evidencia);
		click(btnConfirmAcept, folderPath, "click en confirmar",Evidencia);
		
		//Se recurre a cliente perfil  y se busca razon social y luego cupo
		click(locatorVariable(lblModulos, ModuloCliente),folderPath,"click en la seccion perfil",Evidencia);
		click(locatorVariable(lblsecciones, Submodulo),folderPath,"click en la seccion perfil",Evidencia);
		
		click(btnCriterio, folderPath, "click en criterio",Evidencia);
		selectElementList(btnCriterio, FechaDeCargue, folderPath, "Se selecciona razon social",Evidencia);
		writeText(txtNitRazonSocial, "claro");
		
		click(ModificarCupo, folderPath, "click en modificar",Evidencia);
		//Se valida mediante metodo busqueda en grilla que el titulo tenga fecha de vencimiento
		searchElementGrid(GridCupo, Encabezado, folderPath, "Busqueda de fecha vencimiento,Caso exitoso 557156,557157,557158,557159",Evidencia);
		//Se valida el check box de dias 
		boolean DiasCupo = validarElemento(DaysBox, 0);
		ValidacionObjeto(DiasCupo, "valida caja de dias/cupo, Caso exitoso 557150,557151,557152,557153,557154,557155", folderPath,Evidencia);
		
		//boolean AlertaCreada = validarElemento(alertaLiberacion, 10);
		//ValidacionObjeto(AlertaCreada, "validacion de asignacion", folderPath);
		
		//se busca el mismo titulo y se valida su estado como aplicado
		click(locatorVariable(lblModulos, " Título "),folderPath,"click en la seccion perfil",Evidencia);
		click(locatorVariable(lblsecciones, "Expedir"),folderPath,"click en la seccion perfil",Evidencia);
				
		writeText(txtNitRazonSocial, "2845", folderPath, DatoFaltante,Evidencia);
		searchElementGrid(GridTitulo, estadoA, folderPath, "Se valida estado aplicado",Evidencia);
		
		click(lblModificarHistorico, folderPath, "click en modificar titulo",Evidencia);
			
		
		
		
		return this;
	}

	
	
}