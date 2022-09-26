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

	//Paso a paso de crear un cupo
	@Step("Crear cupo")
	public CupoPage crearCupo(File folderPath, String nitC,String Evidencia) throws Exception {

		//Se crea un cupo nuevo, se ingresa un nit, se da la tecla enter y se dirige hacia el nuevo cupo para hacerlo visible
		click(btnCrearCupo, folderPath, "Se ingresa a crear Cupo",Evidencia);
		writeText(txtNit, nitC, folderPath, "Se digita en el campo Nit",Evidencia);
		enter(txtNit);
		scrollElementV(folderPath, txtCupoAParticular, "Se desplaza hasta la opción Cupo Particular",Evidencia);
		return this;
	}

	//Se digita cada una de las opciones de cupo
	@Step("Modalidades cupo")
	public CupoPage modalidadesCupo() throws Exception {

		//Se digita un cupo con bodega propia
		writeRandomNum(txtCupoAPropia, 15);
		writeText(txtFechaAPropia, datePlusYear(1));
		writeRandomNum(txtDiasCAPropia, 2);
		writeRandomAlp(txtNumeroAPropia, 11);
		
		//Se digita un cupo con bodega particular
		writeRandomNum(txtCupoAParticular, 15);
		writeText(txtFechaAParticular, datePlusYear(2));
		writeRandomNum(txtDiasCAParticular, 2);
		writeRandomAlp(txtNumeroAParticular, 11);

		//Se digita un cupo con bodega particular arrendado
		writeRandomNum(txtCupoAParticularA, 15);
		writeText(txtFechaAParticularA, datePlusYear(3));
		writeRandomNum(txtDiasCAParticularA, 2);
		writeRandomAlp(txtNumeroAParticularA, 11);
		
		//Se digita un cupo con bodega de transito 
		writeRandomNum(txtCupoATransito, 15);
		writeText(txtFechaATransito, datePlusYear(4));
		writeRandomNum(txtDiasCATransito, 2);
		writeRandomAlp(txtNumeroATransito, 11);
		return this;
	}

	@Step("Mercancía")
	public CupoPage mercancia(String mercancia) throws Exception {

		
		//Opcion mercancia dentro del titulo(En desuso porque hay un metodo de creacion automatica de titulos
		click(locatorVariable(lblOpciones, mercancia));
		click(btnCrearMercancia);
		//Lista random de tipo de mercancia y unidad de mercancia 
		listRandom(lblTipoMercancia);
		listRandom(lblUnidadMedida);
		click(btnGuardarMercancia);
		click(locatorVariable(lblOpciones, mercancia));
		
		return this;
	}

	//Paso a paso de crear un acreedor 
	@Step("Acreedor")
	public CupoPage acreedor(File folderPath, String acreedor) throws Exception {

		//Se crea el acreedor
		click(locatorVariable(lblOpciones, acreedor));
		click(btnCrearAcreedor);
		click(btnGuardarAcreedor);
		
		//se asocia un nuevo acreedor y se acepta 
		try {
			click(locatorVariable(lblOpciones, acreedor));
		} catch (Exception e) {
			click(btnAceptarAcreedorYaAsociado);
			click(locatorVariable(lblOpciones, acreedor));
		}
		return this;
	}
	
	//Paso a paso de modificar un cupo ya existente 
	@Step("Modificar cupo")
	public CupoPage modificarCupo(File folderPath, String mercancia, String acreedor,String Evidencia) throws Exception {

		//Se dirige hacia el boton modificar cupo, se ingresa en mercancia , se seleccionan los valores de mercancia y medida de forma random
		
		scrollElementH(folderPath, btnModificarCupo, "Se desplaza hasta la opción Modificar cupo",Evidencia);
		etiquetas(btnModificarCupo, folderPath, "Etiqueta Modificar cupo",Evidencia);
		click(btnModificarCupo, folderPath, "Se ingresa a modificar Cupo",Evidencia);
		
		waitInMs(15000);
		click(locatorVariable(lblOpciones, mercancia), folderPath, "Se ingresa a la opción Mercancia",Evidencia);
		click(btnCrearMercancia, folderPath, "Se ingresa a crear mercancia",Evidencia);
		listRandom(lblTipoMercancia, folderPath, "Se elije una opción de tipo de mercancia random",Evidencia);
		listRandom(lblUnidadMedida, folderPath, "Se elije una opción de unidad de medida random",Evidencia);
		click(btnGuardarMercancia, folderPath, "Se guarda la información",Evidencia);
		
		click(locatorVariable(lblOpciones, mercancia), folderPath, "Se cierra a la opción Mercancia",Evidencia);
		//Se ingresa a acreedor y se guarda el nuevo acreedor
		
		click(locatorVariable(lblOpciones, acreedor), folderPath, "Se ingresa a la opción Acreedor",Evidencia);
		click(btnCrearAcreedor, folderPath, "Se ingresa a crear Acreedor",Evidencia);
		
		//Tiempos de espera largos porque la pagina toma bastante tiempo para guardar los cambios
		waitInMs(4000);
		click(btnGuardarAcreedor, folderPath, "Se guarda la información",Evidencia);
		waitInMs(50000);

		//Se acepta el nuevo acreedor
		try {
			click(locatorVariable(lblOpciones, acreedor), folderPath, "Se cierra a la opción Acreedor",Evidencia);
		} catch (Exception e) {
			click(btnAceptarAcreedorYaAsociado, folderPath, "Se acpeta el pop-up",Evidencia);
			click(locatorVariable(lblOpciones, acreedor), folderPath, "Se cierra a la opción Acreedor",Evidencia);
		}
		
		//Subimos en la pagina y se ejecuta el metodo modalidades de cupo
		scrollUp();
		modalidadesCupo();
		return this;
	}
	
	//El paso a paso del ver cupo 
	
	@Step("Ver cupo")
	public CupoPage verCupo(File folderPath,String Evidencia) throws Exception {
		
		//Validaciones al visualizar cupo, se da click en visualizar cupo
		
		scrollElementH(folderPath, btnVerCupo, "Se desplaza hasta la opción Ver cupo",Evidencia);
		etiquetas(btnVerCupo, folderPath, "Etiqueta Ver cupo",Evidencia);
		click(btnVerCupo, folderPath, "Se ingresa a ver Cupo",Evidencia);

		//Se valida si esta enabled o habilitado el campo en cupo con bodega propia
		waitInMs(15000);
		scrollElementV(folderPath, lblCupoAlternativo, "Se desplaza hasta Modalidades de Cupo",Evidencia);
		isEnabled(txtCupoAPropia, folderPath, "Campo Cupo Aprobado No editable",Evidencia);
		isEnabled(txtFechaAPropia, folderPath, "Campo Fecha de Aprobación No editable",Evidencia);
		isEnabled(txtDiasCAPropia, folderPath, "Campo Días Cupo No editable",Evidencia);
		isEnabled(txtNumeroAPropia, folderPath, "Campo No. Acta de Aprobación No editable",Evidencia);
		
		//Se valida si esta enabled o habilitado el campo en cupo con bodega particular
		isEnabled(txtCupoAParticular, folderPath, "Campo Cupo Aprobado No editable",Evidencia);
		isEnabled(txtFechaAParticular, folderPath, "Campo Fecha de Aprobación No editable",Evidencia);
		isEnabled(txtDiasCAParticular, folderPath, "Campo Días Cupo No editable",Evidencia);
		isEnabled(txtNumeroAParticular, folderPath, "Campo No. Acta de Aprobación No editable",Evidencia);
		
		//Se valida si esta enabled o habilitado el campo en cupo con bodega particular arrendada
		isEnabled(txtCupoAParticularA, folderPath, "Campo Cupo Aprobado No editable",Evidencia);
		isEnabled(txtFechaAParticularA, folderPath, "Campo Fecha de Aprobación No editable",Evidencia);
		isEnabled(txtFechaAParticularA, folderPath, "Campo Días Cupo No editable",Evidencia);
		isEnabled(txtNumeroAParticularA, folderPath, "Campo No. Acta de Aprobación No editable",Evidencia);
		
		//Se valida si esta enabled o habilitado el campo en cupo con bodega en transito
		isEnabled(txtCupoATransito, folderPath, "Campo Cupo Aprobado No editable",Evidencia);
		isEnabled(txtFechaATransito, folderPath, "Campo Fecha de Aprobación No editable",Evidencia);
		isEnabled(txtDiasCATransito, folderPath, "Campo Días Cupo No editable",Evidencia);
		isEnabled(txtNumeroATransito, folderPath, "Campo No. Acta de Aprobación No editable",Evidencia);
		return this;
	}
	
	//Consulta de cupo
	@Step("Consultar cupo")
	public CupoPage consultaCupo(File folderPath, String nom50, String criterio, String nit,String Evidencia) throws Exception {

		//Se digita un valor alfabetico random en minuscula y se toma el atributo de maxlegth o tamaño maximo
		String nitt = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String n = driver.findElement(By.xpath("//input[contains(@formcontrolname,'termino')]")).getAttribute("maxlength");

		//Se hace una validacion si el campo tiene maximo 50 caracteres
		if (n.contains(nom50)) {
			printConsole("Los campos contienen el maximo de 50 caracteres");
			writeText(txtConsultarNit, nitt, folderPath, "Se ingresa texto de 50 caracteres",Evidencia);
			clear(txtConsultarNit, folderPath, "Se eliminar texto antes digitado",Evidencia);
			selectElementList(lblCriterio, criterio, folderPath, "Se selecciona Criterio",Evidencia);
			writeText(txtConsultarNit, nit, folderPath, "Se ingresa nit",Evidencia);
			
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}
		return this;
	}
	
	
	//Metodo que me permite verificar el numero scav en cupo
		@Step("Modalidades cupo")
		public CupoPage ScavCupo_571690(File folderPath,String Evidencia,
				String ValorGrillaCupo,String valorGrillaCupo2,
				String valorGrillaCupo3,String valorGrillaCupo4,
				String valorGrillaCupo5,String valorGrillaCupo6,
				String valorGrillaCupo7,String valorGrillaCupo8) throws Exception {

			//Se dirige hacia el boton modificar cupo, se ingresa en mercancia , se seleccionan los valores de mercancia y medida de forma random
			scrollElementH(folderPath, btnVerCupo, "Se desplaza hasta la opción ver cupo",Evidencia);
			etiquetas(btnVerCupo, folderPath, "Etiqueta ver cupo",Evidencia);
			click(btnVerCupo, folderPath, "Se ingresa a ver Cupo",Evidencia);
			time(70);
			//Se digita un cupo con bodega propia
			click(btnVisualizarScav, folderPath, "Se ingresa a ver Cupo",Evidencia);
			
			desplazarseVertical(0, 600);
			
			
			//Busqueda de encabezados de informacion de scav
			
			boolean CampoPrueba = validarElemento(CampoSolicitud, 5);
			ValidacionObjeto(CampoPrueba, "Validaciom Caso exitoso 571686,571690,571691 ", folderPath, Evidencia);
			
			
			//busqueda de valores en grilla
			searchElementGrid(GridScav, ValorGrillaCupo, folderPath, "Caso exitoso 571686", Evidencia);
			searchElementGrid(GridScav, valorGrillaCupo2, folderPath, "Caso exitoso 571687", Evidencia);
			searchElementGrid(GridScav, valorGrillaCupo3, folderPath, "Caso exitoso 571687", Evidencia);
			searchElementGrid(GridScav, valorGrillaCupo4, folderPath, "Caso exitoso 571687", Evidencia);
			searchElementGrid(GridScav, valorGrillaCupo5, folderPath, "Caso exitoso 571687", Evidencia);
			searchElementGrid(GridScav, valorGrillaCupo6, folderPath, "Caso exitoso 571687", Evidencia);
			searchElementGrid(GridScav, valorGrillaCupo7, folderPath, "Caso exitoso 571687", Evidencia);
			searchElementGrid(GridValoresScav, valorGrillaCupo8, folderPath, "Caso exitoso 571690,571691", Evidencia);
			
			//Obtencion de valor de ficha unica
			String ficha = readText(txtFichaAprobacion, folderPath, "obtenemos el codigo de ficha", Evidencia);
			isEnabled(txtFichaAprobacion, folderPath,"Caso 571688 exitoso El consecutivo unico es" + ficha, Evidencia);
			
			
			writeRandomAlp(txtFichaAprobacion, 11);
			click(btnSearch, folderPath, "click en buscar consecutivo", Evidencia);
			time(6);
					
			boolean alertaBusqueda = validarElemento(AlertaBusqueda, 5);
			ValidacionObjeto(alertaBusqueda, "Caso exitoso 571689,571689", folderPath, Evidencia);
			
			clear(txtFichaAprobacion, folderPath, "borro campo", Evidencia);
			click(btnSearch, folderPath, "click en buscar consecutivo,571689,571692,571693", Evidencia);
			
			click(btnCancelar, folderPath, "click en cancelar", Evidencia);
			
			//Se dirige hacia el boton modificar cupo, se ingresa en mercancia , se seleccionan los valores de mercancia y medida de forma random
			scrollElementH(folderPath, btnModificarCupo, "Se desplaza hasta la opción ver cupo",Evidencia);
			etiquetas(btnModificarCupo, folderPath, "Etiqueta ver cupo",Evidencia);
			click(btnModificarCupo, folderPath, "Se ingresa a ver Cupo",Evidencia);
			
			click(btnGuardar, folderPath, "click en guardar", Evidencia);
			click(btnAceptarGuardar, folderPath, "click en guardar,Caso exitoso 571691,571690", Evidencia);
			
			
			return this;
		}

}