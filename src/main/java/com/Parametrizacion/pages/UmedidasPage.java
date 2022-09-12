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

	//Validacion del submodulo de unidad de medida
	@Step("Revision")
	public UmedidasPage validacion(File folderPath,String Evidencia) throws Exception {

		x = new Object[2];

		x[0] = Obligatorio1;
		x[1] = Obligatorio2;

		click(Adicionar, folderPath, "Se da click sobre la opcion adicionar medida ",Evidencia);
		click(Inputtext, folderPath, "Click en codigo bodega",Evidencia);
		click(Des, folderPath, "Click en descripcion",Evidencia);
		click(Selection, folderPath, "Click en Seleccion de Estado",Evidencia);
		click(SelectionActivo, folderPath, "Seleccion de estado activo",Evidencia);
		click(SelectionInactivo, folderPath, "Seleccion de estado inactivo",Evidencia);

		val = validarElementos(x, t);

		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento ");
			Assert.fail("Error en la validación: No se encontró el mensaje del elemento ");
		}
		return this;
	}
	//Creacion de unidad de medida

	@Step("Validadr el modulo Crear Unidad de Medida")
	public UmedidasPage crearModulo(File folderPath, String CodBodega, String Resume,String Evidencia) throws Exception {

		writeText(Inputtext, CodBodega, folderPath, "Se digita el codigo de Unidad de medida",Evidencia);
		writeText(Des, Resume, folderPath, "Se digita el codigo de Unidad de medida",Evidencia);
		click(Selection, folderPath, "Se da click sobre estado",Evidencia);
		click(SelectionActivo, folderPath, "Se da click sobre activo",Evidencia);
		click(save, folderPath, "Se guarda cambios",Evidencia);
		click(Confirm, folderPath, "Se confirma adicion",Evidencia);
		return this;
	}

	//Busqueda de unidad de medida
	@Step("Modificar/Consultar Unidad medida")
	public UmedidasPage busqueda(File folderPath, String Umedida, String Resume,String Evidencia) throws Exception {

		writeText(Element1, Umedida, folderPath, "Se realiza busqueda de unidad de medida",Evidencia);
		click(btnModificar, folderPath, "Se da click en edicion de registro",Evidencia);
		writeText(Des, Resume, folderPath, "Se digita el codigo de Unidad de medida",Evidencia);
		click(save, folderPath, "Se guarda cambios",Evidencia);
		click(Confirm, folderPath, "Se confirma cambios",Evidencia);
		return this;
	}
}
