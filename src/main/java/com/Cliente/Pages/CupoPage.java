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
		String n = driver.findElement(By.xpath("//input[contains(@formcontrolname,'termino')]"))
				.getAttribute("maxlength");

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

//////////////////
	@Step("Validar Grilla")
	public CupoPage validarGrilla_548478(File folderPath, String Razon, String Empresa, String Empresa2, String Saldo,
			String ModuloT, String SubModuloExpedir, String Numero, String Estado, String ModuloC, String SubModuloCupo,
			String particular, String SubModuloAutorizarMercancia, String Comida, String CupoDisponible,
			String SaldoUtilizado, String ValorParticular, String ValorParticularArrendado, String Propia,
			String Transito, String ModificarNumero, String ModuloG, String SubModuloReporte) throws Exception {

		selectElementList(btnNit2, Razon);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		searchElementGrid(cupogrid, Empresa, folderPath, "548475,548476 Se valida Cliente de Cupo, caso exitoso");
		scrollElementH(folderPath, btnVerCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnVerCupo, folderPath, "Etiqueta Ver cupo");
		click(btnVerCupo, folderPath, "Se ingresa a ver Cupo");
		desplazarseVertical(0, 300);
		searchElementGrid(saldoUgrid, Saldo, folderPath,
				"548476 Se visualiza la grilla de la columna saldo, caso exitoso");

////////////
		click(locatorVariable(lblModulos, ModuloT), folderPath, "click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir), folderPath, "click en la seccion expedir");
		writeText(txtNitCargue, Numero, folderPath, "Se escribe 1854");
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza al elemento");
		searchElementGrid(numeroTgrid, Estado, folderPath, "Se visualiza la grilla de la columna Estado de Titulo");
		click(ModificartituloLiberado, folderPath, "Se ingresa a ver Modifacar Titulo");
		desplazarseVertical(0, 400);
		click(btnAplicar, folderPath, " Click en el boton aplicar");
		click(btnAceptarExpedir, folderPath, " Click en el boton aceptar expedir");
		click(locatorVariable(lblModulos, ModuloC), folderPath, "click en el modulo Cliente");
		click(locatorVariable(lblsecciones, SubModuloCupo), folderPath, "click en la seccion Cupo");
		selectElementList(btnNit2, Razon);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		scrollElementH(folderPath, btnVerCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnVerCupo, folderPath, "Etiqueta Ver cupo");
		click(btnVerCupo, folderPath, "Se ingresa a ver Cupo");
		desplazarseVertical(0, 300);
		searchElementGrid(particulargrid, particular, folderPath,
				"548477 Se visualiza la grilla de la columna particular, caso exitoso");

/////////  4

		click(locatorVariable(lblsecciones, SubModuloCupo), folderPath, "click en la seccion Cupo");
		selectElementList(btnNit2, Razon);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		scrollElementH(folderPath, btnModificarCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnModificarCupo, folderPath, "Etiqueta Ver cupo");
		click(btnModificarCupo, folderPath, "Se ingresa a ver Cupo");
		searchElementGrid(valorgrid2, ValorParticularArrendado, folderPath,
				"548478,Se visualiza la grilla del mismo valor particular arrendada, caso exitoso");
		desplazarseVertical(0, 500);
		click(btnGuardar, folderPath, "Boton Guardar");
		click(btnAceptar, folderPath, "Boton Aceptar");
		click(locatorVariable(lblModulos, ModuloT), folderPath, "click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloAutorizarMercancia), folderPath,
				"click en la seccion autorizar liberacion mercancia");
		click(btnVerDetalles, folderPath, "Se ingresa a ver detalles");
		searchElementGrid(detallesgrid, Comida, folderPath, "548478, Se visualiza la grilla de detalles autorizacion");
		scrollElementH(folderPath, btnDetallesAutorizacion, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnDetallesAutorizacion, folderPath, "Etiqueta Ver cupo");
		click(btnDetallesAutorizacion, folderPath, "Se autoriza");
		click(OkAutorizacion, folderPath, "Boton OK");
		click(locatorVariable(lblModulos, ModuloC), folderPath, "click en el modulo Cliente");
		click(locatorVariable(lblsecciones, SubModuloCupo), folderPath, "click en la seccion Cupo");
		selectElementList(btnNit2, Razon);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		scrollElementH(folderPath, btnVerCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnVerCupo, folderPath, "Etiqueta Ver cupo");
		click(btnVerCupo, folderPath, "Se ingresa a ver Cupo");
		desplazarseVertical(0, 300);
		searchElementGrid(particulargrid, particular, folderPath,
				"548478, Se visualiza la grilla de la columna particular, caso exitoso");

////////////
		click(locatorVariable(lblsecciones, SubModuloCupo), folderPath, "click en la seccion Cupo");
		selectElementList(btnNit2, Razon);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		scrollElementH(folderPath, btnModificarCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnModificarCupo, folderPath, "Etiqueta Ver cupo");
		click(btnModificarCupo, folderPath, "Se ingresa a ver Cupo");
		desplazarseVertical(0, 300);
		searchElementGrid(cupoDgrid, CupoDisponible, folderPath,
				"548479, Se visualiza la grilla de la columna cupo disponible, caso exitoso");
		searchElementGrid(saldoUUgrid, SaldoUtilizado, folderPath,
				"548479,Se visualiza la grilla de la columna saldo utilizado, caso exitoso");

//////////
		click(locatorVariable(lblsecciones, SubModuloCupo), folderPath, "click en la seccion Cupo");
		selectElementList(btnNit2, Razon);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		scrollElementH(folderPath, btnModificarCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnModificarCupo, folderPath, "Etiqueta Ver cupo");
		click(btnModificarCupo, folderPath, "Se ingresa a ver Cupo");
		click(btnCupoAlternativo, folderPath, "Se ingresa a SI/NO");
		click(btnCupoAlternativo2, folderPath, "Se ingresa a SI");
		desplazarseVertical(0, 300);
		searchElementGrid(valorgrid, ValorParticular, folderPath,
				"548480, Se visualiza la grilla del mismo valor particular, caso exitoso");
		searchElementGrid(valorgrid2, ValorParticularArrendado, folderPath,
				"548480,Se visualiza la grilla del mismo valor particular arrendada, caso exitoso");
		desplazarseVertical(0, 100);
		isEnabled(txtTotal, folderPath, "Campo No. Total No editable");

///////////////////////
		click(locatorVariable(lblsecciones, SubModuloCupo), folderPath, "click en la seccion Cupo");
		selectElementList(btnNit2, Razon);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		scrollElementH(folderPath, btnModificarCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnModificarCupo, folderPath, "Etiqueta Ver cupo");
		click(btnModificarCupo, folderPath, "Se ingresa a ver Cupo");
		click(btnCupoAlternativo, folderPath, "Se ingresa a SI/NO");
		click(btnCupoAlternativo3, folderPath, "Se ingresa a NO");
		desplazarseVertical(0, 400);
		searchElementGrid(valorgrid, ValorParticular, folderPath,
				"548481, Se visualiza la grilla del mismo valor particular, caso exitoso");
		searchElementGrid(valorgrid2, ValorParticularArrendado, folderPath,
				"548481,Se visualiza la grilla del mismo valor particular arrendada, caso exitoso");
		searchElementGrid(valorgrid3, Propia, folderPath,
				"548481, Se visualiza la grilla del mismo valor propia, caso exitoso");
		searchElementGrid(valorgrid4, Transito, folderPath,
				"548481,Se visualiza la grilla del mismo valor transito, caso exitoso");
		isEnabled(txtTotal, folderPath, "Campo No. Total No editable, Total de la suma");

//////////////
		click(locatorVariable(lblModulos, ModuloT), folderPath, "click en el modulo titulos");
		click(locatorVariable(lblsecciones, SubModuloExpedir), folderPath, "click en la seccion expedir");
		writeText(txtNitCargue, Numero, folderPath, "Se escribe 2852");
		scrollElementH(folderPath, ModificartituloLiberado, "Se desplaza al elemento");
		click(locatorVariable(lblModulos, ModuloC), folderPath, "click en el modulo Cliente");
		click(locatorVariable(lblsecciones, SubModuloCupo), folderPath, "click en la seccion Cupo");
		selectElementList(btnNit2, Razon);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		scrollElementH(folderPath, btnModificarCupo, "Se desplaza hasta la opción Ver cupo");
		etiquetas(btnModificarCupo, folderPath, "Etiqueta Ver cupo");
		click(btnModificarCupo, folderPath, "Se ingresa a Modificar Cupo");
		desplazarseVertical(0, 400);
		searchElementGrid(valorgrid2, ValorParticularArrendado, folderPath,
				"548482,Se visualiza la grilla del mismo valor particular arrendada, caso exitoso");
		clear(txtModificarNumero, folderPath, "borra registro");
		writeText(txtModificarNumero, ModificarNumero, folderPath, "Se escribe 15");
		desplazarseVertical(0, 200);
		click(btnGuardar, folderPath, "Boton Guardar");
		click(btnAceptar, folderPath, "Boton Aceptar");
		boolean x = validarElemento(Ok, 10);
		ValidacionObjeto(x, "548482", folderPath);
		click(Ok, folderPath, "Boton OK");

///////////////////////////
		click(locatorVariable(lblModulos, ModuloG), folderPath, "click en el modulo Reportes");
		click(locatorVariable(lblsecciones, SubModuloReporte), folderPath, "click en la seccion Generar Reportes");

		return this;
	}

}