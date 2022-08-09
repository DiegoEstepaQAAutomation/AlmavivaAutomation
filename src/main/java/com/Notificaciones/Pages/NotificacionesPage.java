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
	
	
	
	
	
	@Step("Bono de Prenda")
	public NotificacionesPage Notificacion_557159(File folderPath,String DatoFaltante,
			String ModuloCliente,String Submodulo,String FechaDeCargue,String estadoA,String Encabezado)
			throws Exception {

		
		click(lblNotificaciones2, folderPath, "click en menu desplegable de notificaciones");
		selectElementList(lblNotificaciones2, DatoFaltante, folderPath, "Seleccion de dato faltante");
		click(btnAgregarNuevo, folderPath, "click en agregar nueva notificacion");
		writeText(BTitulo, "mauricio", folderPath, DatoFaltante);
		click(btnAsignarA, folderPath, "click en asignar");
		click(chxAsignacion, folderPath, "click en un check ");
		click(btnConfirm, folderPath, "click en confirmar");
		click(btnConfirmAcept, folderPath, "click en confirmar");
		
		
		click(locatorVariable(lblModulos, ModuloCliente),folderPath,"click en la seccion perfil");
		click(locatorVariable(lblsecciones, Submodulo),folderPath,"click en la seccion perfil");
		
		click(btnCriterio, folderPath, "click en criterio");
		selectElementList(btnCriterio, FechaDeCargue, folderPath, "Se selecciona razon social");
		writeText(txtNitRazonSocial, "claro");
		
		click(ModificarCupo, folderPath, "click en modificar");
		
		searchElementGrid(GridCupo, Encabezado, folderPath, "Busqueda de fecha vencimiento,Caso exitoso 557156,557157,557158,557159");
		boolean DiasCupo = validarElemento(DaysBox, 0);
		ValidacionObjeto(DiasCupo, "valida caja de dias/cupo, Caso exitoso 557150,557151,557152,557153,557154,557155", folderPath);
		
		//boolean AlertaCreada = validarElemento(alertaLiberacion, 10);
		//ValidacionObjeto(AlertaCreada, "validacion de asignacion", folderPath);
		
		click(locatorVariable(lblModulos, " Título "),folderPath,"click en la seccion perfil");
		click(locatorVariable(lblsecciones, "Expedir"),folderPath,"click en la seccion perfil");
				
		writeText(txtNitRazonSocial, "2845", folderPath, DatoFaltante);
		searchElementGrid(GridTitulo, estadoA, folderPath, "Se valida estado aplicado");
		
		click(lblModificarHistorico, folderPath, "click en modificar titulo");
			
		
		
		
		return this;
	}

	
	
}