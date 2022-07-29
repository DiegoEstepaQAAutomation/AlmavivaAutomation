package com.Cliente.Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Cliente.Maps.CupoMap;
import java.io.File;
import io.qameta.allure.Step;

public class CupoPage extends CupoMap {

	Object[] x;
	boolean val;
	int t = 15;

	public CupoPage(WebDriver driver) {
		super(driver);
	}

	@Step("Crear cupo")
	public CupoPage crearCupo(File folderPath, String nitC) throws Exception {

		click(btnCrearCupo, folderPath, "Se ingresa a crear Cupo");
		writeText(txtNit, nitC, folderPath, "Se digita en el campo Nit");
		enter(txtNit);
		scrollElementV(folderPath, txtCupoAParticular, "Se desplaza hasta la opción Cupo Particular");
		return this;
	}

	@Step("Modalidades cupo")
	public CupoPage modalidadesCupo() throws Exception {

		writeRandomNum(txtCupoAPropia, 15);
		writeText(txtFechaAPropia, datePlusYear(1));
		writeRandomNum(txtDiasCAPropia, 2);
		writeRandomAlp(txtNumeroAPropia, 11);

		writeRandomNum(txtCupoAParticular, 15);
		writeText(txtFechaAParticular, datePlusYear(2));
		writeRandomNum(txtDiasCAParticular, 2);
		writeRandomAlp(txtNumeroAParticular, 11);

		writeRandomNum(txtCupoAParticularA, 15);
		writeText(txtFechaAParticularA, datePlusYear(3));
		writeRandomNum(txtDiasCAParticularA, 2);
		writeRandomAlp(txtNumeroAParticularA, 11);

		writeRandomNum(txtCupoATransito, 15);
		writeText(txtFechaATransito, datePlusYear(4));
		writeRandomNum(txtDiasCATransito, 2);
		writeRandomAlp(txtNumeroATransito, 11);
		return this;
	}

	@Step("Mercancía")
	public CupoPage mercancia(String mercancia) throws Exception {

		click(locatorVariable(lblOpciones, mercancia));
		click(btnCrearMercancia);
		listRandom(lblTipoMercancia);
		listRandom(lblUnidadMedida);
		click(btnGuardarMercancia);
		click(locatorVariable(lblOpciones, mercancia));
		return this;
	}

	@Step("Acreedor")
	public CupoPage acreedor(File folderPath, String acreedor) throws Exception {

		click(locatorVariable(lblOpciones, acreedor));
		click(btnCrearAcreedor);
		click(btnGuardarAcreedor);

		try {
			click(locatorVariable(lblOpciones, acreedor));
		} catch (Exception e) {
			click(btnAceptarAcreedorYaAsociado);
			click(locatorVariable(lblOpciones, acreedor));
		}
		return this;
	}
	
	@Step("Modificar cupo")
	public CupoPage modificarCupo(File folderPath, String mercancia, String acreedor) throws Exception {

		scrollElementH(folderPath, btnModificarCupo, "Se desplaza hasta la opción Modificar cupo");
		etiquetas(btnModificarCupo, folderPath, "Etiqueta Modificar cupo");
		click(btnModificarCupo, folderPath, "Se ingresa a modificar Cupo");
		
		waitInMs(15000);
		click(locatorVariable(lblOpciones, mercancia), folderPath, "Se ingresa a la opción Mercancia");
		click(btnCrearMercancia, folderPath, "Se ingresa a crear mercancia");
		listRandom(lblTipoMercancia, folderPath, "Se elije una opción de tipo de mercancia random");
		listRandom(lblUnidadMedida, folderPath, "Se elije una opción de unidad de medida random");
		click(btnGuardarMercancia, folderPath, "Se guarda la información");
		click(locatorVariable(lblOpciones, mercancia), folderPath, "Se cierra a la opción Mercancia");
		
		click(locatorVariable(lblOpciones, acreedor), folderPath, "Se ingresa a la opción Acreedor");
		click(btnCrearAcreedor, folderPath, "Se ingresa a crear Acreedor");
		waitInMs(4000);
		click(btnGuardarAcreedor, folderPath, "Se guarda la información");
		waitInMs(50000);

		try {
			click(locatorVariable(lblOpciones, acreedor), folderPath, "Se cierra a la opción Acreedor");
		} catch (Exception e) {
			click(btnAceptarAcreedorYaAsociado, folderPath, "Se acpeta el pop-up");
			click(locatorVariable(lblOpciones, acreedor), folderPath, "Se cierra a la opción Acreedor");
		}
		scrollUp();
		modalidadesCupo();
		return this;
	}
	
	@Step("Ver cupo")
	public CupoPage verCupo(File folderPath) throws Exception {
		
		scrollElementH(folderPath, btnVerCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnVerCupo, folderPath, "Etiqueta Ver cupo");
		click(btnVerCupo, folderPath, "Se ingresa a ver Cupo");

		waitInMs(15000);
		scrollElementV(folderPath, lblCupoAlternativo, "Se desplaza hasta Modalidades de Cupo");
		isEnabled(txtCupoAPropia, folderPath, "Campo Cupo Aprobado No editable");
		isEnabled(txtFechaAPropia, folderPath, "Campo Fecha de Aprobación No editable");
		isEnabled(txtDiasCAPropia, folderPath, "Campo Días Cupo No editable");
		isEnabled(txtNumeroAPropia, folderPath, "Campo No. Acta de Aprobación No editable");
		
		isEnabled(txtCupoAParticular, folderPath, "Campo Cupo Aprobado No editable");
		isEnabled(txtFechaAParticular, folderPath, "Campo Fecha de Aprobación No editable");
		isEnabled(txtDiasCAParticular, folderPath, "Campo Días Cupo No editable");
		isEnabled(txtNumeroAParticular, folderPath, "Campo No. Acta de Aprobación No editable");
		
		isEnabled(txtCupoAParticularA, folderPath, "Campo Cupo Aprobado No editable");
		isEnabled(txtFechaAParticularA, folderPath, "Campo Fecha de Aprobación No editable");
		isEnabled(txtFechaAParticularA, folderPath, "Campo Días Cupo No editable");
		isEnabled(txtNumeroAParticularA, folderPath, "Campo No. Acta de Aprobación No editable");
		
		isEnabled(txtCupoATransito, folderPath, "Campo Cupo Aprobado No editable");
		isEnabled(txtFechaATransito, folderPath, "Campo Fecha de Aprobación No editable");
		isEnabled(txtDiasCATransito, folderPath, "Campo Días Cupo No editable");
		isEnabled(txtNumeroATransito, folderPath, "Campo No. Acta de Aprobación No editable");
		return this;
	}
	
	@Step("Consultar cupo")
	public CupoPage consultaCupo(File folderPath, String nom50, String criterio, String nit) throws Exception {

		String nitt = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String n = driver.findElement(By.xpath("//input[contains(@formcontrolname,'termino')]")).getAttribute("maxlength");

		if (n.contains(nom50)) {
			printConsole("Los campos contienen el maximo de 50 caracteres");
			writeText(txtConsultarNit, nitt, folderPath, "Se ingresa texto de 50 caracteres");
			clear(txtConsultarNit, folderPath, "Se eliminar texto antes digitado");
			selectElementList(lblCriterio, criterio, folderPath, "Se selecciona Criterio");
			writeText(txtConsultarNit, nit, folderPath, "Se ingresa nit");
			
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}
		return this;
	}
}