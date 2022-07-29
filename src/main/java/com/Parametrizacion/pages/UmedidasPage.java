package com.Parametrizacion.pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Parametrizacion.Maps.UmedidaMap;

import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class UmedidasPage extends UmedidaMap {
	public UmedidasPage(WebDriver driver) {
		super(driver);
	}

	Object[] x;
	boolean val;
	int t = 15;

	@Step("Revision")
	public UmedidasPage validacion(File folderPath) throws Exception {

		x = new Object[2];

		x[0] = Obligatorio1;
		x[1] = Obligatorio2;

		click(Adicionar, folderPath, "Se da click sobre la opcion adicionar medida ");
		click(Inputtext, folderPath, "Click en codigo bodega");
		click(Des, folderPath, "Click en descripcion");
		click(Selection, folderPath, "Click en Seleccion de Estado");
		click(SelectionActivo, folderPath, "Seleccion de estado activo");
		click(SelectionInactivo, folderPath, "Seleccion de estado inactivo");

		val = validarElementos(x, t);

		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento ");
			Assert.fail("Error en la validación: No se encontró el mensaje del elemento ");
		}
		return this;
	}

	@Step("Validadr el modulo Crear Unidad de Medida")
	public UmedidasPage crearModulo(File folderPath, String CodBodega, String Resume) throws Exception {

		writeText(Inputtext, CodBodega, folderPath, "Se digita el codigo de Unidad de medida");
		writeText(Des, Resume, folderPath, "Se digita el codigo de Unidad de medida");
		click(Selection, folderPath, "Se da click sobre estado");
		click(SelectionActivo, folderPath, "Se da click sobre activo");
		click(save, folderPath, "Se guarda cambios");
		click(Confirm, folderPath, "Se confirma adicion");
		return this;
	}

	@Step("Modificar/Consultar Unidad medida")
	public UmedidasPage busqueda(File folderPath, String Umedida, String Resume) throws Exception {

		writeText(Element1, Umedida, folderPath, "Se realiza busqueda de unidad de medida");
		click(btnModificar, folderPath, "Se da click en edicion de registro");
		writeText(Des, Resume, folderPath, "Se digita el codigo de Unidad de medida");
		click(save, folderPath, "Se guarda cambios");
		click(Confirm, folderPath, "Se confirma cambios");
		return this;
	}
}
