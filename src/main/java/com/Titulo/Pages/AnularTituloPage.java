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

	@Step("Anular título")
	public AnularTituloPage anularTitulo(File folderPath, String codigo) throws Exception {

		writeText(txtBuscarTitulo, codigo, folderPath, "Se Escribe el titulo que se va a anular");
		click(seleccionarTituloBuscar, folderPath, "Se da click en buscar el titulo");
		click(btnAnularTitulo, folderPath, "Click en anular titulo");
		listRandom(lblRazonAnulacion, folderPath, "Se selecciona una razon random de Anulacion");
		click(btnGuardarRazonAnulacion, folderPath, "Click guardar razon de anulacion");
		return this;
	}
}