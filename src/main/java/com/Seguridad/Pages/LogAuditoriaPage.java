package com.Seguridad.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.Seguridad.Maps.LogAuditoriaMap;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class LogAuditoriaPage extends LogAuditoriaMap {

	Object[] x;
	boolean val;
	int t = 15;

	public LogAuditoriaPage(WebDriver driver) {
		super(driver);
	}

	//Se almacena lista de usuarios paso a paso
	@Step("Lista de Usuarios")
	public String[] almacenarListaVector(File folderPath) throws Exception {

		//Se declaran una variable integer y una variable string con dispocision a arreglo o lista
		Integer i = 0;
		String[] usuario;

		//Se coloca en la variable list user todos los elementos de la tabla de usuarios
		List<WebElement> listUser = driver.findElements(TblListaUsuarios);
		waitInMs(2000);

		//Se crea un bucle que esta basado en el tamaño de la lista y la toma de valores de texto
		usuario = new String[listUser.size()];
		for (i = 0; i < listUser.size(); i++) {
			usuario[i] = listUser.get(i).getText();
		}
		return usuario;
	}

	//Usuarios en log auditoria
	@Step("Usuarios en Log-Auditoria")
	public void usuariosLog(File folderPath, String[] usuarios,String Evidencia) throws Exception {

		//Se hace el paso a paso de usuarios en log auditoria, se crea una variable integer
		Integer i = 0;

		click(lblLogAuditoria);
		click(btnBuscarUsuario);
		waitInMs(2000);

		//Se toma la variable integer y se envia con el tamaño de texto en un ciclo
		for (i = 0; i < usuarios.length; i++) {
			String usuarios1 = usuarios[i];

			//Se valida cada elemento que surge del ciclo en un ciclo de validacion
			waitInMs(1000);
			clear(txtBuscarUsuarioLog, folderPath, "Se elimina el texto digitado anteriormente",Evidencia);
			writeText(txtBuscarUsuarioLog, usuarios1, folderPath, "Se ingresa el usuario: " + usuarios1,Evidencia);
			click(btnBuscar);
			//Se envia elemento de grilla a una variable tipo string
			String user = searchElementGrid(lblTablaLogAuditoria, usuarios1, folderPath, "se busca elemento en grilla",Evidencia);

			if (user.contains(usuarios1)) {
				printConsole("Usuario: " + usuarios1 + " = Log Auditoría: " + user);
			} else {
				GenerarReportePdf.closeTemplate("Error",Evidencia);
				Assert.fail("Error");
			}
		}
	}

	@Step("Filtro fechas Log Auditoría")
	public LogAuditoriaPage filtroFechasLog(File folderPath, String mesD, String anualD, String diaD, String mesH,
			String anualH, String diaH,String Evidencia) throws Exception {

		//Se busca por fecha el log o informe de auditoria, se envia a una variable tipo string la fecha actual solo que tomando unicamente el dia
		String timeStamp = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
		diaH = timeStamp;

		//paso a paso de filtracion de auditoria por fecha
		click(calendarioFechaDesde, folderPath, "Se ingresa a calendario Fecha desde",Evidencia);
		selectElementList(lblMesFecha, mesD, folderPath, "Se selecciona el mes de Fecha desde",Evidencia);
		selectElementList(lblAnualFecha, anualD, folderPath, "Se selecciona el año de Fecha desde",Evidencia);
		waitInMs(1000);
		click(locatorVariable(lblDiaFecha, diaD), folderPath, "Se selecciona el día de Fecha desde",Evidencia);

		click(calendarioFechaHasta, folderPath, "Se ingresa a calendario Fecha hasta",Evidencia);
		selectElementList(lblMesFecha, mesH, folderPath, "Se selecciona el mes de Fecha hasta",Evidencia);
		selectElementList(lblAnualFecha, anualH, folderPath, "Se selecciona el año de Fecha hasta",Evidencia);
		waitInMs(1000);
		click(locatorVariable(lblDiaFecha, diaH), folderPath, "Se selecciona el día de Fecha hasta",Evidencia);
		//se valida mediante un imprimir en consola la fecha en formato dia
		printConsole("Día actual: " + timeStamp);
		click(btnBuscarLog, folderPath, "Se selecciona la opción Buscar",Evidencia);
		waitInMs(5000);
		
		if (lblUsuarioValidar == null) {
			GenerarReportePdf.closeTemplate("No se trajo la información correctamente",Evidencia);
			Assert.fail("No se trajo la información correctamente");
		}else {
			printConsole("Se trajo la información correctamente");
		}
		
		click(btnDescargar, folderPath, "Se descarga la información",Evidencia);
		return this;
	}

	//Botones de auditoria
	@Step("Botones Log Auditoría")
	public LogAuditoriaPage botonesLog(File folderPath,String Evidencia) throws Exception {

		x = new Object[2];
		x[0] = btnVerTodos;
		x[1] = btnDescargar;

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			click(btnVerTodos, folderPath, "Se selecciona la opción Ver Todos",Evidencia);
			waitInMs(20000);
			if (lblUsuarioValidar == null) {
				GenerarReportePdf.closeTemplate("No se trajo la información correctamente",Evidencia);
				Assert.fail("No se trajo la información correctamente");
			}else {
				printConsole("Se trajo la información correctamente");
			}
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados",Evidencia);
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		return this;
	}
}