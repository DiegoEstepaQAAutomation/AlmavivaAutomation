package com.Titulo.Pages;

import org.openqa.selenium.WebDriver;
import com.Titulo.Maps.AnularTituloMap;
import java.io.File;
import io.qameta.allure.Step;

public class AnularTituloPage extends AnularTituloMap {

	Object[] x;
	boolean val;
	int t = 15;

	public AnularTituloPage(WebDriver driver) {
		super(driver);
	}

	//PASO A PASO DE ANULAR TITULOS
	@Step("Anular título")
	public AnularTituloPage anularTitulo(File folderPath, String codigo,String Evidencia) throws Exception {

		//FORMULARIO DE ANULAR TITULO
		writeText(txtBuscarTitulo, codigo, folderPath, "Se Escribe el titulo que se va a anular",Evidencia);
		click(seleccionarTituloBuscar, folderPath, "Se da click en buscar el titulo",Evidencia);
		click(btnAnularTitulo, folderPath, "Click en anular titulo",Evidencia);
		listRandom(lblRazonAnulacion, folderPath, "Se selecciona una razon random de Anulacion",Evidencia);
		click(btnGuardarRazonAnulacion, folderPath, "Click guardar razon de anulacion",Evidencia);
		return this;
	}
}