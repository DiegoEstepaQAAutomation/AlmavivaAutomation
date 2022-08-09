package com.demoautomatizacion.Pages;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.itextpdf.text.DocumentException;

import io.qameta.allure.Attachment;
import utilities.GenerarReportePdf;

public class BasePage {

	public static WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	public void desplazarseVertical(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		};
	

	// METODO DE ENVIAR TEXTO
	public static void printConsole(String texto) {
		System.out.println(texto);
	}

	// METODO LOCALIZAR VARIABLE
	public By locatorVariable(By locator, String valor) throws Exception {
		String jj = locator.toString().replace("{0}", valor);
		String kk = jj.replace("By.xpath: ", "");
		By localizador = By.xpath(kk);
		return localizador;
	}
	
	
    @Attachment(value = "{0}", type = "text/plain")

    public static String saveTextLog(String texto) {

        System.out.println(texto);

        return texto;

    }
    
    @Attachment(value = "Screenshot", type = "image/png")

    public  byte[] screenshot(File rutaCarpeta, String accion) throws IOException, DocumentException {

        String hora = horaSistema();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //String rutaImagen = rutaCarpeta + "\\" + hora + "_"+funcion+".png";

        String rutaImagen = rutaCarpeta + "\\" + hora + ".png";

        FileUtils.copyFile(scrFile, new File(rutaImagen));

        GenerarReportePdf.createBody(accion, rutaImagen);

        deleteFile(rutaImagen);



        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }


    
    // METODO PARA BUSCAR UN ELEMENTO EN UNA GRILLA  DE EXCEL
    public String searchElementGridExcel(By tableResult, File folderPath, String steps)
            throws Exception {
        String row = null;
        ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
                .findElements(By.tagName("tr"));
        for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
            WebElement campo = (WebElement) iterator.next();
            row = campo.getText();

            System.out.print(row);
        }

        waitInMs(2000);
        captureScreen(folderPath, steps);
        return row;
    }
    
	
	
	
	//METODO I CLICK Y SENKEY

    public By localizadorVariable(By locator, String valor) throws Exception {
        String jj = locator.toString().replace("{0}", valor);
        String kk = jj.replace("By.xpath: ", "");
        By localizador = By.xpath(kk);
        return localizador;
    }
	
	// METODO PARA COMPROBAR SI UN ELEMENTO SE ENCUENTRA Y ES VISIBLE
	public void visibilityOfElementLocated(By elementLocation) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
	}

	// METODO QUE DEVUELVE EL TEXTO DE UN ELEMENTO
	public String readText(By elementLocation, File folderPath, String steps) throws Exception {
		String readText = null;
		try {
			visibilityOfElementLocated(elementLocation);
			readText = driver.findElement(elementLocation).getText();
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
		return readText;
	}

	public String readText(By elementLocation) throws Exception {
		String readText = null;

		visibilityOfElementLocated(elementLocation);
		readText = driver.findElement(elementLocation).getText();
		waitInMs(2000);
		return readText;
	}

	// METODO PARA ESCRIBIR EN UN ELEMENTO
	public void writeText(By elementLocation, String text, File folderPath, String steps) throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).sendKeys(text);
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}
	
	public void writeText(By elementLocation, String text) throws Exception {
			//visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).sendKeys(text);
			waitInMs(2000);
	}
	
	public void KeysWrite(String text) 
	{
		Keys.valueOf(text);
		
		
	}
	
	

	// METODO PARA DEVOLVER UN ELEMENTO
	public WebElement getElement(By elementLocation, File folderPath, String steps) throws Exception {
		WebElement element = null;
		try {
			visibilityOfElementLocated(elementLocation);
			element = driver.findElement(elementLocation);
			waitInMs(2000);
			captureScreen(folderPath, steps);
			return element;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
		return element;
	}

	// METODO PARA DAR CLICK EN UN ELEMENTO
	public void click(By elementLocation, File folderPath, String steps) throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).click();
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}
	
	public void click(By elementLocation) throws Exception {
			//visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).click();
			waitInMs(2000);
	}

	// METODO ENTER SUBMIN
	public void submit(By elementLocation, File folderPath, String steps) throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).submit();
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}

	// METODO PARA LIMPIAR UN CAMPO
	public void clear(By elementLocation, File folderPath, String steps) throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).clear();
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}

	// METODO DE ELIMINAR TEXTO CON EL TECLADO
	public void eliminarTextoKeyBoard(By elemento) throws Exception {
		waitInMs(2000);
		driver.findElement(elemento).sendKeys(Keys.CONTROL + "a");
		driver.findElement(elemento).sendKeys(Keys.DELETE);
		waitInMs(2000);
	}

	// METODO PARA COMPROBAR SI UN EMLEMENTO SE ENCUENTRA
	public boolean displayed(By elementLocation, File folderPath, String steps) throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			boolean displayed = driver.findElement(elementLocation).isDisplayed();
			waitInMs(2000);
			captureScreen(folderPath, steps);
			return displayed;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
		return false;
	}

	// METODO PARA COMPROBAR SI UN ELEMENTO SE ENCUENTRA SIN CAPTURA DE PANTALLA
	public boolean displayed(By elementLocation) throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			boolean display = driver.findElement(elementLocation).isDisplayed();
			waitInMs(2000);
			return display;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
		return false;
	}

	// METODO PARA SELECCIONAR UN ELEMENTO DE UNA LISTA
	public void selectElementList(By elementLocation, String valorLista, File folderPath, String steps)
			throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			Select lista = new Select(driver.findElement(elementLocation));
			lista.selectByVisibleText(valorLista);
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}
	
	public void selectElementList(By elementLocation, String valorLista) throws Exception {
			visibilityOfElementLocated(elementLocation);
			Select lista = new Select(driver.findElement(elementLocation));
			lista.selectByVisibleText(valorLista);
			waitInMs(2000);
	}

	// METODO PARA BUSCAR UN ELEMENTO EN UNA GRILLA
	public String searchElementGrid(By tableResult, String searchValue, File folderPath, String steps)
			throws Exception {
		String row = null;
		ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
				.findElements(By.tagName("td"));
		for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
			WebElement campo = (WebElement) iterator.next();
			row = campo.getText();
			if (row.equals(searchValue)) {
				break;
			}
		}
		waitInMs(2000);
		captureScreen(folderPath, steps);
		return row;
	}
	
	
	
	public String searchElementGrid1(By tableResult, String searchValue, File folderPath, String steps)
			throws Exception {
		String row = null;
		ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
				.findElements(By.tagName("td"));
		for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
			WebElement campo = (WebElement) iterator.next();
			row = campo.getText();
			if (row.equals(searchValue)) {
				captureScreen(folderPath, steps);
			}
		}
		waitInMs(2000);
		captureScreen(folderPath, steps);
		return row;
	}

	
	
	
	// METODO PARA DAR CLICK AL ELEMENTO DENTRO DE UNA GRILLA
	public void clickElementGrid(By tableResult, String searchValue, File folderPath, String steps) throws Exception {
		ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
				.findElements(By.tagName("td"));
		for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
			WebElement campo = (WebElement) iterator.next();
			String row = campo.getText();
			if (row.equals(searchValue)) {
				campo.click();
				break;
			}
		}
		waitInMs(2000);
		captureScreen(folderPath, steps);
	}

	// METODO PARA CONTAR LA CANTIDAD DE FILAS
	public int numberRows(By tableResult, File folderPath, String steps) throws Exception {
		ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
				.findElements(By.tagName("tr"));
		waitInMs(2000);
		captureScreen(folderPath, steps);
		return resultado.size() - 2;
	}

	// METODO DE SCROLL HACIA UN LOCALIZADOR VERTICAL
	public void scrollElementV(File folderPath, By locator, String steps) throws DocumentException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(locator);
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {

			GenerarReportePdf.closeTemplate(e.toString());
		}
	}

	// METODO DE SCROLL HACIA UN LOCALIZADOR HORIZONTAL
	public void scrollElementH(File folderPath, By locator, String steps) throws DocumentException {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", element);
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {

			GenerarReportePdf.closeTemplate(e.toString());
		}
	}
	
	public void scrollElementH(By locator) throws DocumentException {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", element);
			waitInMs(2000);
	}

	// METODO DE SCROLL HACIA ABAJO
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		waitInMs(2000);
	}

	// METODO DE SCROLL HACIA ARRIBA
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");
		waitInMs(2000);
	}

	// METODO DE ESPERA
	public static void waitInMs(Integer milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// METODO DE ESPERA
	public void time(long time) throws InterruptedException {
		Thread.sleep(time * 1000);
	}

	// FECHA CON UN MEJOR FORMATO PARA MOSTRAR EN PDF
	public static String fechaPdf() {
		LocalDateTime fechaSistema = LocalDateTime.now();
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String fechaPdf = fecha.format(fechaSistema);
		return fechaPdf;
	}

	// HORA CON UN MEJOR FORMATO PARA MOSTRAR EN PDF
	public static String horaPdf() {
		LocalDateTime horaSistema = LocalDateTime.now();
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaPdf = hora.format(horaSistema);
		return horaPdf;
	}

	// METODO PARA TRAER LA FECHA DEL SISTEMA
	public static String fechaSistema() {
		LocalDateTime fechaSistema = LocalDateTime.now();
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String Fecha = fecha.format(fechaSistema);
		return Fecha;
	}

	// METODO PARA TRAER LA HORA DEL SISTEMA
	public static String horaSistema() {
		LocalTime horaSistema = LocalTime.now();
		DateTimeFormatter horaS = DateTimeFormatter.ofPattern("HHmmss");
		String hora = horaS.format(horaSistema);
		return hora;
	}

	// CAPTURA DE PANTALLA
	public void captureScreen(File folderPath, String steps) throws Exception {
		String hora = horaSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(folderPath + "\\" + hora + ".png"));
		String imagePath = new File(folderPath + "\\" + hora + ".png").toString();
		GenerarReportePdf.createBody(steps, imagePath);// INSTALAR LOCALIZADOR DE IMAGEN PDF
		deleteFile(imagePath);// ELIMNAR IMAGEN CREADA
	}

	
	
	// CAPTURA DE PANTALLA
	public static void captureScreenA(File folderPath, String steps) throws Exception {
		String hora = horaSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(folderPath + "\\" + hora + ".png"));
		String imagePath = new File(folderPath + "\\" + hora + ".png").toString();
		GenerarReportePdf.createBody(steps, imagePath);// INSTALAR LOCALIZADOR DE IMAGEN PDF
		deleteFileA(imagePath);// ELIMNAR IMAGEN CREADA
	}
	
	
	@Attachment(value = "Screenshot", type = "image/png")
	public static byte[] screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// CAPTURA DE PANTALLA ERROR
	public void captureError(File rutaCarpeta, String texto, String Evidencia, String mensajeError) throws Exception {
		if (Evidencia.contains("SI")) {
			String hora = horaSistema();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
			String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();
			GenerarReportePdf.createErrorBody(texto, rutaImagen, mensajeError);// INSTALAR LOCALIZADOR DE IMAGEN PDF
			deleteFile(rutaImagen);// ELIMNAR IMAGEN CREADA
		}
	}

	// METODO CAPTURA PDF
	public void captureScreenPdf(File rutaCarpeta, String funcion) throws Exception {
		String hora = horaSistema();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(rutaCarpeta + "/" + hora + ".jpg"));
		String rutaImagen = rutaCarpeta + "/" + hora + ".jpg";
		GenerarReportePdf.createBody(funcion, rutaImagen);
		deleteFile(rutaImagen);
	}

	// METODO PARA CREAR CARPETA PARA CAPTURA
	public static File createFolder(String nameFolder, String path) {
		String fecha = fechaSistema();
		String nomCarpeta = nameFolder + " " + fecha;
		File directorio = new File(path + nomCarpeta);
		directorio.mkdir();
		return directorio;
	}

	// METODO PARA ELIMINAR ARCHIVO
	public void deleteFile(String rutaImagen) {
		File fichero = new File(rutaImagen);
		fichero.delete();
	}
	
	
	// METODO PARA ELIMINAR ARCHIVO
		public static void deleteFileA(String rutaImagen) {
			File fichero = new File(rutaImagen);
			fichero.delete();
		}


	// METODO PARA CARGAR UN ARCHIVO DESDE LA MAQUINA
	public void fileUpload(By elementLocation, String archive, File folderPath, String steps) throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			File file = new File(archive);
			WebElement ruta = driver.findElement(elementLocation);
			ruta.sendKeys(file.getAbsolutePath());
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}
	
	
	
	public void fileUpFull(By elementLocation, String archive) throws Exception {
			//	visibilityOfElementLocated(elementLocation);
			File file = new File(archive);
			WebElement ruta = driver.findElement(elementLocation);
			ruta.sendKeys(file.getAbsolutePath());
			waitInMs(2000);
			
	}
	

	
	

	public void acceptAlert(File folderPath, String steps) throws Exception {
		driver.switchTo().alert().accept();
		waitInMs(2000);
		captureScreen(folderPath, steps);
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
		waitInMs(2000);
	}

	public void writeAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
		waitInMs(2000);
	}

	public void enter(By elementLocation) throws IOException {
		driver.findElement(elementLocation).sendKeys(Keys.ENTER);
	}

	public void ByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,1000)");
	}

	// SALTO DE PAGINA
	public void jumpPage(File folderPath, String steps) throws DocumentException {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().window(driver.getWindowHandle());
			Object[] parentHandle = driver.getWindowHandles().toArray();
			driver.switchTo().window((String) parentHandle[1]);
			driver.manage().window().maximize();
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}

	// CAMBIO DE VENTANA
	public void changeWindows(File folderPath, String steps) throws DocumentException {
		try {
			ArrayList<String> ventana = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) ventana.get(1));
			driver.close();
			driver.switchTo().window((String) ventana.get(0));
			waitInMs(2000);
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}

	public static void selectKeyBoard(WebElement field) {
		field.sendKeys(Keys.UP);
		field.click();
		field.sendKeys(Keys.ENTER);
		waitInMs(2000);
	}

	// METODO ETIQUETA
	public void etiquetas(By elementLocation, File folderPath, String steps) throws DocumentException {
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(elementLocation);
			action.moveToElement(element).perform();
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}

	// METODO LISTA RANDOM
	public void listRandom(By elementLocation, File folderPath, String steps) throws DocumentException {
		try {
			WebElement Drplistdown = driver.findElement(elementLocation);
			Select objSel = new Select(Drplistdown);
			List<WebElement> weblist = objSel.getOptions();
			int iCnt = weblist.size();
			Random num = new Random();
			int iSelect = num.nextInt(iCnt);
			objSel.selectByIndex(iSelect);
			printConsole(Drplistdown.getAttribute("value"));
			captureScreen(folderPath, steps);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
	}
	
	public void listRandom(By elementLocation) throws DocumentException {
			WebElement Drplistdown = driver.findElement(elementLocation);
			Select objSel = new Select(Drplistdown);
			List<WebElement> weblist = objSel.getOptions();
			int iCnt = weblist.size();
			Random num = new Random();
			int iSelect = num.nextInt(iCnt);
			objSel.selectByIndex(iSelect);
			printConsole(Drplistdown.getAttribute("value"));
	}

	// METODO VALIDACIÓN
	public static boolean validarElemento(By elementLocation, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
			return true ;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static boolean validarElementoA(By elementLocation, int time,File folderPath,String steps) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
			captureScreenA(folderPath, steps);
			return true ;
		} catch (Exception ex) {
			return false;
		}
	}
	
	
	
	
	
	
	

	public boolean validarElementos(Object[] x, int time) {
		boolean val = true;
		for (int i = 0; i < x.length; i++) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.visibilityOfElementLocated((By) x[i]));
			} catch (Exception ex) {
				val = false;
				break;
			}
		}
		return val;
	}

	public WebElement getElement(By elementLocation) {
		return driver.findElement(elementLocation);
	}

	public boolean isSelected(By elementLocation, File folderPath, String steps) throws DocumentException {
		try {
			visibilityOfElementLocated(elementLocation);
			boolean selected = driver.findElement(elementLocation).isSelected();
			waitInMs(2000);
			return selected;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
		return false;
	}

	public boolean isEnabled(By elementLocation, File folderPath, String steps) throws DocumentException {
		try {
			visibilityOfElementLocated(elementLocation);
			boolean enabled = driver.findElement(elementLocation).isEnabled();
			waitInMs(2000);
			captureScreen(folderPath, steps);
			return enabled;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString());
		}
		return false;
	}
	
	public String datePlusYear(int year) {
		LocalDate lastAprilDay = LocalDate.now();
        LocalDate firstMay = lastAprilDay.plusYears(year);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formatDate = formatter.format(firstMay);
        System.out.println("Fecha: " + formatDate);
		return formatDate;
	}
	
	public void writeRandomNum(By elementLocation, int num) {
		String acta = RandomStringUtils.randomNumeric(num);
		driver.findElement(elementLocation).sendKeys(acta);
		waitInMs(1000);
	}
	
	public void writeRandomAlp(By elementLocation, int num) {
		String acta = RandomStringUtils.randomAlphabetic(num).toLowerCase();
		driver.findElement(elementLocation).sendKeys(acta);
	}
	
	public void escape() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public void ValidacionObjetos(boolean valor1, boolean valor2, String caso, File folderPath ) throws IOException, DocumentException 
	
	{
		
	
		
		if(valor1 == true  && valor2 == true )
			
		{
			screenshot(folderPath ,"La validacion es exitosa  para el caso " + caso );			
		}
		else 
		{
			screenshot(folderPath ,"La validacion no es exitosa para los casos ejecutados " );
					
		}
	}
	
	
	public void ValidacionObjeto(boolean valor1, String caso, File folderPath ) throws IOException, DocumentException 
	
	{
		
		if(valor1 == true  )
			
		{
			screenshot(folderPath ,"La validacion es exitosa  para el caso " + caso );			
		}
		else 
		{
			screenshot(folderPath ,"La validacion no es exitosa el elemento a validar no esta presente " );
					
		}
		
			
	}
	
	public void RecargarPagina(By elemenLocation) 
	{
		driver. findElement(elemenLocation).sendKeys(Keys.F5);
	}
	
	
}