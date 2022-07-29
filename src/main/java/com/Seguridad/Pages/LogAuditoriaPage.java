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

	@Step("Lista de Usuarios")
	public String[] almacenarListaVector(File folderPath) throws Exception {

		Integer i = 0;
		String[] usuario;

		List<WebElement> listUser = driver.findElements(TblListaUsuarios);
		waitInMs(2000);

		usuario = new String[listUser.size()];
		for (i = 0; i < listUser.size(); i++) {
			usuario[i] = listUser.get(i).getText();
		}
		return usuario;
	}

	@Step("Usuarios en Log-Auditoria")
	public void usuariosLog(File folderPath, String[] usuarios) throws Exception {

		Integer i = 0;

		click(lblLogAuditoria);
		click(btnBuscarUsuario);
		waitInMs(2000);

		for (i = 0; i < usuarios.length; i++) {
			String usuarios1 = usuarios[i];

			waitInMs(1000);
			clear(txtBuscarUsuarioLog, folderPath, "Se elimina el texto digitado anteriormente");
			writeText(txtBuscarUsuarioLog, usuarios1, folderPath, "Se ingresa el usuario: " + usuarios1);
			click(btnBuscar);

			String user = searchElementGrid(lblTablaLogAuditoria, usuarios1, folderPath, "");

			if (user.contains(usuarios1)) {
				printConsole("Usuario: " + usuarios1 + " = Log Auditoría: " + user);
			} else {
				GenerarReportePdf.closeTemplate("Error");
				Assert.fail("Error");
			}
		}
	}

	@Step("Filtro fechas Log Auditoría")
	public LogAuditoriaPage filtroFechasLog(File folderPath, String mesD, String anualD, String diaD, String mesH,
			String anualH, String diaH) throws Exception {

		String timeStamp = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
		diaH = timeStamp;

		click(calendarioFechaDesde, folderPath, "Se ingresa a calendario Fecha desde");
		selectElementList(lblMesFecha, mesD, folderPath, "Se selecciona el mes de Fecha desde");
		selectElementList(lblAnualFecha, anualD, folderPath, "Se selecciona el año de Fecha desde");
		waitInMs(1000);
		click(locatorVariable(lblDiaFecha, diaD), folderPath, "Se selecciona el día de Fecha desde");

		click(calendarioFechaHasta, folderPath, "Se ingresa a calendario Fecha hasta");
		selectElementList(lblMesFecha, mesH, folderPath, "Se selecciona el mes de Fecha hasta");
		selectElementList(lblAnualFecha, anualH, folderPath, "Se selecciona el año de Fecha hasta");
		waitInMs(1000);
		click(locatorVariable(lblDiaFecha, diaH), folderPath, "Se selecciona el día de Fecha hasta");
		printConsole("Día actual: " + timeStamp);
		click(btnBuscarLog, folderPath, "Se selecciona la opción Buscar");
		waitInMs(5000);
		
		if (lblUsuarioValidar == null) {
			GenerarReportePdf.closeTemplate("No se trajo la información correctamente");
			Assert.fail("No se trajo la información correctamente");
		}else {
			printConsole("Se trajo la información correctamente");
		}
		
		click(btnDescargar, folderPath, "Se descarga la información");
		return this;
	}

	@Step("Botones Log Auditoría")
	public LogAuditoriaPage botonesLog(File folderPath) throws Exception {

		x = new Object[2];
		x[0] = btnVerTodos;
		x[1] = btnDescargar;

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			click(btnVerTodos, folderPath, "Se selecciona la opción Ver Todos");
			waitInMs(20000);
			if (lblUsuarioValidar == null) {
				GenerarReportePdf.closeTemplate("No se trajo la información correctamente");
				Assert.fail("No se trajo la información correctamente");
			}else {
				printConsole("Se trajo la información correctamente");
			}
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados");
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		return this;
	}
}