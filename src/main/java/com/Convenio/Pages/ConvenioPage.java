package com.Convenio.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.demoautomatizacion.Pages.BasePage;

public class ConvenioPage extends BasePage{

    
	// CONVENIOS
	By btnConvenio = By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/div/a");
	By btnGestion = By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/div/ul/li/div/a");
	
	By lblNit = By.xpath("//*[@id=\"tipo\"]/option[1]");
	By lblNombreRazonSocial = By.xpath("//*[@id=\"tipo\"]/option[2]");
	By txtIngreseNit = By.id("termino");
	By txtIngreseRazonSocial = By.id("termino");
	
	//CREAR CONVENIO
	By btnCrearConvenio = By.xpath("//*[@id=\"contenido\"]/convenios/convenios-home/div/div[2]/div/a");
	By lblNitCrearConvenio = By.xpath("//*[@id=\"criterio\"]/option[1]");
	By lblRazonSocialCrearConvenio = By.xpath("//*[@id=\"criterio\"]/option[2]");
	By txtNit = By.id("termino");
	By txtRazonSocial = By.id("termino");
	By btnSeleccionarNitRazonSocial = By.cssSelector(".ngb-highlight");
	
	By btnBuscar = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/busqueda-cliente/form/button");
	
	By txtValorImpresion= By.id("convValorprendario");
	By btnSeleccionarAplicaCobroPorModalidad= By.id("convCobroxmodalida");
	By btnSeleccionarAplicaCobroPorModalidadSi = By.xpath("//*[@id=\"convCobroxmodalida\"]/option[1]");
	By btnSeleccionarAplicaCobroPorModalidadNo = By.xpath("//*[@id=\"convCobroxmodalida\"]/option[2]");
	
	By lblParticularArrendada = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[1]/div/div[1]/div/div/button");	
	By lblPropia= By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblTransito = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[3]/div/div[1]/div/div/button");
	By lblParticular = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[4]/div/div[1]/div/div/button");
	
	By txtFijaPorcentaje1= By.id("coboValor");
	By txtFijaPorcentaje2= By.id("coboValor");
	
	By btnAplicaMinima = By.id("convAplicaminima");
	By btnAplicaMinimaSi = By.xpath("//*[@id=\"convAplicaminima\"]/option[1]");
	By btnAplicaMinimaNo = By.xpath("//*[@id=\"convAplicaminima\"]/option[2]");
	By txtValorMinima = By.id("convValor");
	By btnGuardarCrearConvenio = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button[1]");
	By btnCancelarCrearConvenio = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button[2]");
	
	By lblGuardarRegistro = By.xpath("//*[@id=\"swal2-title\"]");
	By btnAlertaCrearConvenioAceptar = By.xpath("/html/body/div[3]/div/div[3]/button[1]");
	By btnAlertaCrearConvenioCancelar = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	
	// FORMA DE COBRO TODAS LAS BODEGAS
	By lblFormaDeCobroParticularArrendada = By.id("coboFija_0");
	By lblFormaDeCobroPropia = By.id("coboFija_1");
	By lblFormaDeCobroTransito = By.id("coboFija_2");
	By lblFormaDeCobroParticular = By.id("coboFija_3");
	
	//FIJA / ESCALONADA
	By lblFormaDeCobroFijaParticularArrendada = By.xpath("//*[@id=\"coboFija_0\"]/option[1]");
	By lblFormaDeCobroFijaPropia = By.xpath("//*[@id=\"coboFija_1\"]/option[1]");
	By lblFormaDeCobroFijaTransito = By.xpath("//*[@id=\"coboFija_2\"]/option[1]");
	By lblFormaDeCobroFijaParticular = By.xpath("//*[@id=\"coboFija_3\"]/option[1]");
	
	By lblFormaDeCobroEscalonadaParticularArrendada = By.xpath("//*[@id=\"coboFija_0\"]/option[2]");
	By lblFormaDeCobroEscalonadaPropia = By.xpath("//*[@id=\"coboFija_1\"]/option[2]");
	By lblFormaDeCobroEscalonadaTransito = By.xpath("//*[@id=\"coboFija_2\"]/option[2]");
	By lblFormaDeCobroEscalonadaParticular = By.xpath("//*[@id=\"coboFija_3\"]/option[2]");
	
	By txtFijaParticularArrendada = By.id("coboValor_0");
	By txtFijaPropia = By.id("coboValor_1");
	By txtFijaTransito = By.id("coboValor_2");
	By txtFijaParticular = By.id("coboValor_3");
	
	By btnAgregarRango = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[1]/div/div[2]/div/div/div[3]/app-cobro-escalonado/div/div[2]/div/a");
	By btnEliminarRango = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[1]/div/div[2]/div/div/div[3]/app-cobro-escalonado/div/table/tbody/tr[3]/td[5]/button");
	By txtR1LI = By.id("cbraLi_0");
	By txtR1LF = By.id("cbraLf_0");
	By txtR1Valor = By.id("cbraValor_0");
	By txtR2LI = By.id("cbraLi_1");
	By txtR2LF = By.id("cbraLf_1");
	By txtR2Valor = By.id("cbraValor_1");
	
	// MODIFICAR
	By btnModificar = By.xpath("//table[@id='tbConvenios']/tbody/tr/td[3]/div/a/i");
	By btnModificar2 = By.xpath("//table[@id='tbConvenios']/tbody/tr[2]/td[3]/div/a/i");
	By btnModificar3 = By.xpath("//table[@id='tbConvenios']/tbody/tr[3]/td[3]/div/a");
	By btnGuardarModificar = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button[1]");
	By btnCancelarModificar = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button[2]");
	
	// VER DETALLE
	By txtNITConsultar = By.id("convNit");
	By txtNombreRazonSocialConsultar = By.id("convRazonSocial");
	By txtValorImpresionBuscarConsultar = By.id("convValorprendario");
	By btnSeleccionarAplicaCobroPorModalidadConsultar = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[4]/input");
	By btnVerDetalle = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[1]/td[3]/div/a[2]");
	By btnVerDetalle2 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[2]/td[3]/div/a[2]");
	By btnVerDetalle3 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[3]/td[3]/div/a[2]");
	By btnVerDetalle4 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[4]/td[3]/div/a[2]");
	By btnRegresarVerDetalle = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button");
	
	By txtValorImpresionBuscar = By.id("convValorprendario");
	By btnOrdenarNit = By.xpath("//*[@id=\"tbConvenios\"]/thead/tr/th[1]/div/i");
	By btnOrdenarRazonSocial = By.xpath("//*[@id=\"tbConvenios\"]/thead/tr/th[2]/div/i");
	
	
		public ConvenioPage(WebDriver driver) {
		super(driver);
	}
	
	
	// SCROLL
		/*@Step("Scroll")
		public ConvenioPage Scroll() {
		
		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Utilidades.waitInMs(1000);

		return this;
	}
		
	// EVIDENCIA	
		
		@Step("Evidencia")
		public ConvenioPage Evidencia() {
		
		Utilidades.waitInMs(3000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
	
	// INGRESAR A MODULO CONVENIO / GESTIÓN 
		@Step("Ingresar al modulo Convenio")
		public ConvenioPage Convenio() {
		
		Utilidades.waitInMs(2000);
		click(btnConvenio);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Ingresar al Sub modulo Gestion")
		public ConvenioPage Gestion() {
		
		Utilidades.waitInMs(2000);
		click(btnGestion);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
	// OPCIONES BUSCAR CONVENIO
		@Step("Nit Buscar")
		public ConvenioPage NitBuscar(String nitBuscar) {
		
		Utilidades.waitInMs(2000);
		click(lblNit);
		Utilidades.waitInMs(1000);
		writeText(txtIngreseNit, nitBuscar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Nombre o Razón Social Buscar")
		public ConvenioPage RazonSocialBuscar(String razonSocialConvenioBuscar) {
		
		Utilidades.waitInMs(2000);
		click(lblNombreRazonSocial);
		Utilidades.waitInMs(1000);
		writeText(txtIngreseRazonSocial, razonSocialConvenioBuscar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Clear Nit Buscar")
		public ConvenioPage ClearNitBuscar() {
			
		Utilidades.waitInMs(2000);
		clear(txtIngreseNit);
		Utilidades.waitInMs(1000);

		return this;
	}
	
	// OPCIONES CREAR CONVENIO
		@Step("Botón crear Convenio")
		public ConvenioPage BotonCrearConvenio() {
		
		Utilidades.waitInMs(2000);
		click(btnCrearConvenio);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		@Step("Nit Crear")
		public ConvenioPage NitCrear(String nitConvenio) {
		
		Utilidades.waitInMs(2000);
		writeText(txtNit, nitConvenio);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Clear Nit Crear")
		public ConvenioPage ClearNitCrear() {
			
		Utilidades.waitInMs(2000);
		clear(txtNit);
		Utilidades.waitInMs(1000);

		return this;
	}
	
		@Step("Nombre o Razón Social Crear")
		public ConvenioPage RazonSocialCrear(String razonSocialConvenio) {
			
		Utilidades.waitInMs(2000);
		click(lblRazonSocialCrearConvenio);
		Utilidades.waitInMs(1000);
		writeText(txtRazonSocial, razonSocialConvenio);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		@Step("Clear Nombre o Razón Social Crear")
		public ConvenioPage ClearRazonSocialCrear() {
			
		Utilidades.waitInMs(2000);
		click(lblRazonSocialCrearConvenio);
		Utilidades.waitInMs(1000);
		clear(txtRazonSocial);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Seleccionar NIT / Nombre o Razón Social")
		public ConvenioPage SeleccionarNitRazonSocialCrear() {
			
		Utilidades.waitInMs(2000);
		click(btnSeleccionarNitRazonSocial);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Valor Impresión Juego Prendario")
		public ConvenioPage ValorImpresion(String valorImpresion) {
			
		Utilidades.waitInMs(2000);
		writeText(txtValorImpresion, valorImpresion);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		@Step("Clear Valor Impresión Juego Prendario")
		public ConvenioPage ClearValorImpresion() {
			
		Utilidades.waitInMs(2000);
		clear(txtValorImpresion);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Click Valor Impresión Juego Prendario")
		public ConvenioPage ClickValorImpresion() {
			
		Utilidades.waitInMs(2000);
		click(txtValorImpresion);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Aplica Cobro por Modalidad")
		public ConvenioPage AplicaCobro() {
			
		Utilidades.waitInMs(2000);
		click(btnSeleccionarAplicaCobroPorModalidad);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Aplica Cobro por Modalidad opción SI")
		public ConvenioPage AplicaCobroSi() {
			
		Utilidades.waitInMs(2000);
		click(btnSeleccionarAplicaCobroPorModalidadSi);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Aplica Cobro por Modalidad opción NO")
		public ConvenioPage AplicaCobroNo() {
			
		Utilidades.waitInMs(2000);
		click(btnSeleccionarAplicaCobroPorModalidadNo);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
	// BODEGA PARTICULAR ARRENDADA
		@Step("Click Particular Arrendada")
		public ConvenioPage ParticularArrendada() {
			
		Utilidades.waitInMs(2000);
		click(lblParticularArrendada);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Click Seleccione forma de cobro Particular Arrendada")
		public ConvenioPage SeleccioneFormaDeCobroParticularArrendada() {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroParticularArrendada);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}	
		
		@Step("Forma De Cobro Particular Arrendada cobro 'Fija'")
		public ConvenioPage FormaDeCobroFijaParticularArrendada(String fijaPorcentaje) {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroFijaParticularArrendada);
		Utilidades.waitInMs(1000);
		writeText(txtFijaParticularArrendada, fijaPorcentaje);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Forma De Cobro Particular Arrendada cobro 'Escalonada'")
		public ConvenioPage FormaDeCobroEscalonadaParticularArrendada() {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroEscalonadaParticularArrendada);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
		
		return this;
	}
	
		@Step("Clear Forma De Cobro Particular Arrendada cobro Fija")
		public ConvenioPage ClearFormaDeCobroFijaParticularArrendada() {
			
		Utilidades.waitInMs(2000);
		clear(txtFijaParticularArrendada);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
	// BODEGA PROPIA
		@Step("Click Propia")
		public ConvenioPage Propia() {
			
		Utilidades.waitInMs(2000);
		click(lblPropia);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Click Seleccione forma de cobro Propia")
		public ConvenioPage SeleccioneFormaDeCobroPropia() {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroPropia);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Forma De Cobro Propia cobro 'Fija'")
		public ConvenioPage FormaDeCobroFijaPropia(String fijaPorcentaje) {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroFijaPropia);
		Utilidades.waitInMs(1000);
		writeText(txtFijaPropia, fijaPorcentaje);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Forma De Cobro Propia cobro 'Escalonada'")
		public ConvenioPage FormaDeCobroEscalonadaPropia() {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroEscalonadaPropia);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Clear Forma De Cobro Particular Arrendada cobro Fija")
		public ConvenioPage ClearFormaDeCobroFijaPropia() {
			
		Utilidades.waitInMs(2000);
		clear(txtFijaPropia);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
	// BODEGA TRANSITO
		@Step("Click Transito")
		public ConvenioPage Transito() {
			
		Utilidades.waitInMs(2000);
		click(lblTransito);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Click Seleccione forma de cobro Transito")
		public ConvenioPage SeleccioneFormaDeCobroTransito() {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroTransito);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Forma De Cobro Transito cobro 'Fija'")
		public ConvenioPage FormaDeCobroFijaTransito(String fijaPorcentaje) {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroFijaTransito);
		Utilidades.waitInMs(1000);
		writeText(txtFijaTransito, fijaPorcentaje);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Forma De Cobro Transito cobro 'Escalonada'")
		public ConvenioPage FormaDeCobroEscalonadaTransito() {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroEscalonadaTransito);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Clear Forma De Cobro Particular Arrendada cobro Fija")
		public ConvenioPage ClearFormaDeCobroFijaTransito() {
			
		Utilidades.waitInMs(2000);
		clear(txtFijaTransito);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
	// BODEGA PARTICULAR
		@Step("Click Particular")
		public ConvenioPage Particular() {
			
		Utilidades.waitInMs(2000);
		click(lblParticular);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Click Seleccione forma de cobro Particular")
		public ConvenioPage SeleccioneFormaDeCobroParticular() {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroParticular);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Forma De Cobro Particular cobro 'Fija'")
		public ConvenioPage FormaDeCobroFijaParticular(String fijaPorcentaje) {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroFijaParticular);
		Utilidades.waitInMs(1000);
		writeText(txtFijaParticular, fijaPorcentaje);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Forma De Cobro Particular cobro 'Escalonada'")
		public ConvenioPage FormaDeCobroEscalonadaParticular() {
			
		Utilidades.waitInMs(2000);
		click(lblFormaDeCobroEscalonadaParticular);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Clear Forma De Cobro Particular Arrendada cobro Fija")
		public ConvenioPage ClearFormaDeCobroFijaParticular() {
			
		Utilidades.waitInMs(2000);
		clear(txtFijaParticular);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
	// OPCIONES TODAS LAS BODEGAS
		@Step("Escalonada Agregar Rango")
		public ConvenioPage EscalonadaAgregarRango() {
			
		Utilidades.waitInMs(2000);
		click(btnAgregarRango);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}	
		
		@Step("Datos Escalonada Primera fila")
		public ConvenioPage DatosEscalonadaPrimeraFila(String R1LI, String R1LF, String valor) {
			
		Utilidades.waitInMs(2000);
		writeText(txtR1LI, R1LI); 
		Utilidades.waitInMs(1000);
		writeText(txtR1LF, R1LF);
		Utilidades.waitInMs(1000);
		writeText(txtR1Valor, valor);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}	
		
		@Step("Datos Escalonada Segunda fila")
		public ConvenioPage DatosEscalonadaSegundaFila(String R2LI, String R2LF, String valor) {
			
		Utilidades.waitInMs(2000);
		writeText(txtR2LI, R2LI); 
		Utilidades.waitInMs(1000);
		writeText(txtR2LF, R2LF);
		Utilidades.waitInMs(1000);
		writeText(txtR2Valor, valor);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}	
		
		@Step("Clear Datos Escalonada Primera fila")
		public ConvenioPage DatosEscalonadaClear() {
			
		Utilidades.waitInMs(2000);
		clear(txtR1LI); 
		clear(txtR1LF);
		clear(txtR1Valor);
		clear(txtR2LI); 
		clear(txtR2LF);
		clear(txtR2Valor);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Escalonada Eliminar Rango")
		public ConvenioPage EscalonadaEliminar() {
			
		Utilidades.waitInMs(2000);
		click(btnEliminarRango);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
	// APLICA MINIMA Y OPCIONES
		
		@Step("Click Aplica Mínima")
		public ConvenioPage AplicaMinima() {
			
		Utilidades.waitInMs(2000);
		click(btnAplicaMinima);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Aplica Mínima opción Si")
		public ConvenioPage AplicaMinimaSi() {
			
		Utilidades.waitInMs(2000);
		click(btnAplicaMinimaSi);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Aplica Mínima opción No")
		public ConvenioPage AplicaMinimaNo() {
			
		Utilidades.waitInMs(2000);
		click(btnAplicaMinimaNo);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Aplica Mínima / Valor Mínima")
		public ConvenioPage AplicaMinimaValorMinima(String valorMinima) {
			
		Utilidades.waitInMs(2000);
		writeText(txtValorMinima, valorMinima);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Clear Aplica Mínima / Valor Mínima")
		public ConvenioPage ClearAplicaMinimaValorMinima() {
			
		Utilidades.waitInMs(2000);
		clear(txtValorMinima);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
	
	// BOTONES GUARDAR / CANCELAR
		@Step("Botón Guardar")
		public ConvenioPage BotonGuardar() {
			
		Utilidades.waitInMs(2000);
		click(btnGuardarCrearConvenio);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Cancelar")
		public ConvenioPage BotonCancelar() {
			
		Utilidades.waitInMs(2000);
		click(btnCancelarCrearConvenio);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Validar resultado crear Convenio")
	 	public ConvenioPage ValidarResultadoCrearConvenio(String ResultadoCrearConvenio) {
			
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Assert.assertEquals(getElement(lblGuardarRegistro).getText(), ResultadoCrearConvenio);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Click botón Aceptar en crear Convenio")
	 	public ConvenioPage CrearConvenioAceptar() {
			
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		click(btnAlertaCrearConvenioAceptar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		@Step("Click botón Cancelar en crear Convenio")
	 	public ConvenioPage CrearConvenioCancelar() {
			
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		click(btnAlertaCrearConvenioCancelar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
			
		return this;
	}
		
		
	// CONSULTAS
		
		@Step("Botón Modificar")
		public ConvenioPage BotonModificar() {
			
		Utilidades.waitInMs(2000);
		click(btnModificar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Modificar Buscar opción 1")
		public ConvenioPage BotonModificarBuscar() {
			
		Utilidades.waitInMs(2000);
		click(btnModificar2);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Modificar Buscar opción 2")
		public ConvenioPage BotonModificarBuscar2() {
			
		Utilidades.waitInMs(2000);
		click(btnModificar3);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Ver Detalle")
		public ConvenioPage BotonVerDetalle() {
			
		Utilidades.waitInMs(2000);
		click(btnVerDetalle);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Ver Detalle Buscar opción 1")
		public ConvenioPage BotonVerDetalleBuscar() {
			
		Utilidades.waitInMs(2000);
		click(btnVerDetalle2);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Ver Detalle Buscar opción 2")
		public ConvenioPage BotonVerDetalleBuscar2() {
			
		Utilidades.waitInMs(2000);
		click(btnVerDetalle3);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Ver Detalle Buscar opción 3")
		public ConvenioPage BotonVerDetalleBuscar3() {
			
		Utilidades.waitInMs(2000);
		click(btnVerDetalle4);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Cancelar Modificar")
		public ConvenioPage BotonCancelarModificar() {
			
		Utilidades.waitInMs(2000);
		click(btnCancelarModificar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}	
		
		@Step("Botón Guardar Modificar")
		public ConvenioPage BotonGuardarModificar() {
			
		Utilidades.waitInMs(2000);
		click(btnGuardarModificar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Botón Regresar Ver Detalle")
		public ConvenioPage BotonRegresarVerDetalle() {
			
		Utilidades.waitInMs(2000);
		click(btnRegresarVerDetalle);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Opción ordenar NIT")
		public ConvenioPage OrdenarNit() {
			
		Utilidades.waitInMs(2000);
		click(btnOrdenarNit);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Opción ordenar Nombre / Razón Social")
		public ConvenioPage OrdenarRazonSocial() {
			
		Utilidades.waitInMs(2000);
		click(btnOrdenarRazonSocial);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Valor Impresión Juego Prendario")
		public ConvenioPage ValorImpresionBuscar(String valorImpresionBuscar) {
			
		Utilidades.waitInMs(2000);
		writeText(txtValorImpresionBuscar, valorImpresionBuscar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
		
		@Step("Clear Valor Impresión Juego Prendario")
		public ConvenioPage ClearValorImpresionBuscar() {
			
		Utilidades.waitInMs(2000);
		clear(txtValorImpresionBuscar);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}	
		
		@Step("Etiqueta Ver")
		public ConvenioPage EtiquetaVer() {
			
		Utilidades.waitInMs(2000);
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[1]/td[3]/div/a[2]"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}	
		
		@Step("Etiqueta Ver")
		public ConvenioPage EtiquetaModificar() {
			
		Utilidades.waitInMs(2000);
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[1]/td[3]/div/a[1]"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}	*/
}
