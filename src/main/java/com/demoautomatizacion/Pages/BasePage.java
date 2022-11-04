
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
import java.util.Arrays;
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
import utilities.WriteExcelFile;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePage.
 */
public class BasePage {

	/** The driver. */
	public static WebDriver driver;
	
	/** The wait. */
	public WebDriverWait wait;

	/**
	 * Instantiates a new base page.
	 *
	 * @param driver the driver
	 */
	@SuppressWarnings("static-access")
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	/**
	 * Desplazarse vertical.
	 *
	 * @param x the x
	 * @param y the y
	 */
	//Desplazamiento vertical por coordenada
	public void desplazarseVertical(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		};
	

	/**
	 * Prints the console.
	 *
	 * @param texto the texto
	 */
	// METODO DE ENVIAR TEXTO
	public static void printConsole(String texto) {
		System.out.println(texto);
	}

	/**
	 * Locator variable.
	 *
	 * @param locator the locator
	 * @param valor the valor
	 * @return the by
	 * @throws Exception the exception
	 */
	// METODO LOCALIZAR VARIABLE
	public By locatorVariable(By locator, String valor) throws Exception {
		String jj = locator.toString().replace("{0}", valor);
		String kk = jj.replace("By.xpath: ", "");
		By localizador = By.xpath(kk);
		return localizador;
	}
	
	
    /**
     * Save text log.
     *
     * @param texto the texto
     * @return the string
     */
    @Attachment(value = "{0}", type = "text/plain")

    public static String saveTextLog(String texto) {

        System.out.println(texto);

        return texto;

    }
    
    /**
     * Screenshot.
     *
     * @param rutaCarpeta the ruta carpeta
     * @param accion the accion
     * @param Evidencia the evidencia
     * @return the byte[]
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws DocumentException the document exception
     */
    //Metodo screenshot
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


    
    /**
     * Search element grid excel.
     *
     * @param tableResult the table result
     * @param folderPath the folder path
     * @param steps the steps
     * @param Evidencia the evidencia
     * @return the string
     * @throws Exception the exception
     */
    // METODO PARA BUSCAR UN ELEMENTO EN UNA GRILLA  DE EXCEL
    public String searchElementGridExcel(By tableResult, File folderPath, String steps,String Evidencia)
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
        captureScreen(folderPath, steps,Evidencia);
        return row;
    }
    
	
	
	
	//METODO I CLICK Y SENKEY

    /**
	 * Localizador variable.
	 *
	 * @param locator the locator
	 * @param valor the valor
	 * @return the by
	 * @throws Exception the exception
	 */
	public By localizadorVariable(By locator, String valor) throws Exception {
        String jj = locator.toString().replace("{0}", valor);
        String kk = jj.replace("By.xpath: ", "");
        By localizador = By.xpath(kk);
        return localizador;
    }
	
	/**
	 * Visibility of element located.
	 *
	 * @param elementLocation the element location
	 */
	// METODO PARA COMPROBAR SI UN ELEMENTO SE ENCUENTRA Y ES VISIBLE
	public void visibilityOfElementLocated(By elementLocation) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
	}

	/**
	 * Read text.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @return the string
	 * @throws Exception the exception
	 */
	// METODO QUE DEVUELVE EL TEXTO DE UN ELEMENTO
	public String readText(By elementLocation, File folderPath, String steps,String Evidencia) throws Exception {
		String readText = null;
		try {
			//TOMA EL TEXTO DE UN LOCALIZADOR
			visibilityOfElementLocated(elementLocation);
			readText = driver.findElement(elementLocation).getText();
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}
		return readText;
	}

	/**
	 * Read text.
	 *
	 * @param elementLocation the element location
	 * @return the string
	 * @throws Exception the exception
	 */
	public String readText(By elementLocation) throws Exception {
		String readText = null;

		visibilityOfElementLocated(elementLocation);
		readText = driver.findElement(elementLocation).getText();
		waitInMs(2000);
		return readText;
	}

	/**
	 * Write text.
	 *
	 * @param elementLocation the element location
	 * @param text the text
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	// METODO PARA ESCRIBIR EN UN ELEMENTO
	public void writeText(By elementLocation, String text, File folderPath, String steps,String Evidencia) throws Exception {
		if(Evidencia.equals("SI")) {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).sendKeys(text);
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		} }else { 
			driver.findElement(elementLocation).sendKeys(text);
			waitInMs(2000);
		}
	}
	
	public void numeroAleatorio(By locator) throws Exception {



	       Random aleatorio = new Random();



	       int min = 1000;
	        int max = 99999;
	        int random_int = (int) (Math.random() * (max - min + 1) + min);
	        int random_int2 = (int) (Math.random() * (max - min + 1) + min);



	       driver.findElement(locator).sendKeys(Integer.toString(random_int) + Integer.toString(random_int2));
	    }
	
	/**
	 * Write text.
	 *
	 * @param elementLocation the element location
	 * @param text the text
	 * @throws Exception the exception
	 */
	public void writeText(By elementLocation, String text) throws Exception {
			//visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).sendKeys(text);
			waitInMs(2000);
	}
	
	/**
	 * Keys write.
	 *
	 * @param text the text
	 */
	public void KeysWrite(String text) 
	{
		Keys.valueOf(text);
		
		
	}
	
	

	/**
	 * Gets the element.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @return the element
	 * @throws Exception the exception
	 */
	// METODO PARA DEVOLVER UN ELEMENTO
	public WebElement getElement(By elementLocation, File folderPath, String steps,String Evidencia) throws Exception {
		WebElement element = null;
		if(Evidencia.equals("SI")) {
		try {
			visibilityOfElementLocated(elementLocation);
			element = driver.findElement(elementLocation);
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
			return element;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}
		return element; 
		} else 
		{
			visibilityOfElementLocated(elementLocation);
			element = driver.findElement(elementLocation);
			waitInMs(2000);
			return element;
		}
	}

	/**
	 * Click.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	// METODO PARA DAR CLICK EN UN ELEMENTO
	public void click(By elementLocation, File folderPath, String steps,String Evidencia) throws Exception {
		if(Evidencia.equals("SI")) {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).click();
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}  
		
		} else {	
			
			driver.findElement(elementLocation).click();
			waitInMs(2000);
		}
		
	}
	
	
	/**
	 * Click 2.
	 *
	 * @param elementLocation the element location
	 * @throws Exception the exception
	 */
	public void click2(By elementLocation) throws Exception {
		//visibilityOfElementLocated(elementLocation);
		driver.findElement(elementLocation).click();
		waitInMs(2000);
}

	
	
	/**
	 * Click.
	 *
	 * @param elementLocation the element location
	 * @throws Exception the exception
	 */
	public void click(By elementLocation) throws Exception {
			//visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).click();
			waitInMs(2000);
	}

	/**
	 * Submit.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	// METODO ENTER SUBMIN
	public void submit(By elementLocation, File folderPath, String steps,String Evidencia) throws Exception {
		if(Evidencia.equals("SI")) {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).submit();
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		} 
		} else { 
			
			try {
				//visibilityOfElementLocated(elementLocation);
				driver.findElement(elementLocation).submit();
				waitInMs(2000);
				
			} catch (Exception e) {System.out.print(e);} 
				
		
			}
	}

	/**
	 * Clear.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	// METODO PARA LIMPIAR UN CAMPO
	public void clear(By elementLocation, File folderPath, String steps,String Evidencia) throws Exception {
		if(Evidencia.equals("SI")) {
		try {
			visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).clear();
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		} } else { 
			
			try {
			//visibilityOfElementLocated(elementLocation);
			driver.findElement(elementLocation).clear();
			waitInMs(2000);
			
		} catch (Exception e) {System.out.print(e);}
			
		
		}
	}

	/**
	 * Eliminar texto key board.
	 *
	 * @param elemento the elemento
	 * @throws Exception the exception
	 */
	// METODO DE ELIMINAR TEXTO CON EL TECLADO
	public void eliminarTextoKeyBoard(By elemento) throws Exception {
		waitInMs(2000);
		driver.findElement(elemento).sendKeys(Keys.CONTROL + "a");
		driver.findElement(elemento).sendKeys(Keys.DELETE);
		waitInMs(2000);
	}

	/**
	 * Displayed.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	// METODO PARA COMPROBAR SI UN EMLEMENTO SE ENCUENTRA
	public boolean displayed(By elementLocation, File folderPath, String steps,String Evidencia) throws Exception {
		if(Evidencia.equals("SI")) {
		try {
			visibilityOfElementLocated(elementLocation);
			boolean displayed = driver.findElement(elementLocation).isDisplayed();
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
			return displayed;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}
		return false; } else 
		{ try {
			visibilityOfElementLocated(elementLocation);
			boolean displayed = driver.findElement(elementLocation).isDisplayed();
			waitInMs(2000);
			
			return displayed;
		} catch (Exception e) {System.out.print(e);} 
		return false;} 
	}

	/**
	 * Displayed.
	 *
	 * @param elementLocation the element location
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	// METODO PARA COMPROBAR SI UN ELEMENTO SE ENCUENTRA SIN CAPTURA DE PANTALLA
	public boolean displayed(By elementLocation) throws Exception {
		try {
			visibilityOfElementLocated(elementLocation);
			boolean display = driver.findElement(elementLocation).isDisplayed();
			waitInMs(2000);
			return display;
		} catch (Exception e) {System.out.print(e);}
		
		return false;
	}

	/**
	 * Select element list.
	 *
	 * @param elementLocation the element location
	 * @param valorLista the valor lista
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	// METODO PARA SELECCIONAR UN ELEMENTO DE UNA LISTA
	public void selectElementList(By elementLocation, String valorLista, File folderPath, String steps,String Evidencia)
			throws Exception {
		if(Evidencia.equals("SI")) {
		try {
			visibilityOfElementLocated(elementLocation);
			Select lista = new Select(driver.findElement(elementLocation));
			lista.selectByVisibleText(valorLista);
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		} 
		
		}else 
		{ 
			
		visibilityOfElementLocated(elementLocation);
		Select lista = new Select(driver.findElement(elementLocation));
		lista.selectByVisibleText(valorLista);
		waitInMs(2000);
		
		}
	}
	
	/**
	 * Select element list.
	 *
	 * @param elementLocation the element location
	 * @param valorLista the valor lista
	 * @throws Exception the exception
	 */
	public void selectElementList(By elementLocation, String valorLista) throws Exception {
			visibilityOfElementLocated(elementLocation);
			Select lista = new Select(driver.findElement(elementLocation));
			lista.selectByVisibleText(valorLista);
			waitInMs(2000);
	}

	/**
	 * Search element grid.
	 *
	 * @param tableResult the table result
	 * @param searchValue the search value
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @return the string
	 * @throws Exception the exception
	 */
	// METODO PARA BUSCAR UN ELEMENTO EN UNA GRILLA
	public String searchElementGrid(By tableResult, String searchValue, File folderPath, String steps,String Evidencia)
			throws Exception {
		if(Evidencia.equals("SI")) 
		{
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
		captureScreen(folderPath, steps,Evidencia);
		return row; } else 
		{  
			
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
		return row;
			
			
			
		}
		
	 }
	
	

	
	
	/**
	 * Search element grid 1.
	 *
	 * @param tableResult the table result
	 * @param searchValue the search value
	 * @param steps the steps
	 * @return the string
	 * @throws Exception the exception
	 */
	public String searchElementGrid1(By tableResult, String searchValue, String steps)
			throws Exception {
		String row = null;
		ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
				.findElements(By.tagName("td"));
		for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
			WebElement campo = (WebElement) iterator.next();
			row = campo.getText();
			if (row.equals(searchValue)) {
				
			}
		}
		waitInMs(2000);
		
		return row;
	}

	
	
	
	/**
	 * Click element grid.
	 *
	 * @param tableResult the table result
	 * @param searchValue the search value
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	// METODO PARA DAR CLICK AL ELEMENTO DENTRO DE UNA GRILLA
	public void clickElementGrid(By tableResult, String searchValue, File folderPath, String steps,String Evidencia) throws Exception {
		if(Evidencia.equals("SI")) {
		
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
		captureScreen(folderPath, steps,Evidencia);
	} else { 

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
		 } 
		
	}

	/**
	 * Number rows.
	 *
	 * @param tableResult the table result
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @return the int
	 * @throws Exception the exception
	 */
	// METODO PARA CONTAR LA CANTIDAD DE FILAS
	public int numberRows(By tableResult, File folderPath, String steps,String Evidencia) throws Exception {
		if(Evidencia.equals("SI")) {
		
		ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
				.findElements(By.tagName("tr"));
		waitInMs(2000);
		captureScreen(folderPath, steps,Evidencia);
		return resultado.size() - 2;
	} else {  
		
		
		ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
				.findElements(By.tagName("tr"));
		waitInMs(2000);
		return resultado.size() - 2;
	} }

	/**
	 * Scroll element V.
	 *
	 * @param folderPath the folder path
	 * @param locator the locator
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws DocumentException the document exception
	 */
	// METODO DE SCROLL HACIA UN LOCALIZADOR VERTICAL
	public void scrollElementV(File folderPath, By locator, String steps,String Evidencia) throws DocumentException {
		if(Evidencia.equals("SI")) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(locator);
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {

			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}} else { 
			
			
			try {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				WebElement element = driver.findElement(locator);
				executor.executeScript("arguments[0].scrollIntoView(true);", element);
				waitInMs(2000);
				
			} catch (Exception e) {System.out.print(e);			}
			
			
		}
	}

	
	/**
	 * Scroll element V 2.
	 *
	 * @param locator the locator
	 * @param steps the steps
	 * @throws DocumentException the document exception
	 */
	// METODO DE SCROLL HACIA UN LOCALIZADOR VERTICAL
	public void scrollElementV2( By locator, String steps,String Evidencia) throws DocumentException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(locator);
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			waitInMs(2000);
			
		} catch (Exception e) {

			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}
	}

	/**
	 * Scroll element H.
	 *
	 * @param folderPath the folder path
	 * @param locator the locator
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws DocumentException the document exception
	 */
	// METODO DE SCROLL HACIA UN LOCALIZADOR HORIZONTAL
	public void scrollElementH(File folderPath, By locator, String steps,String Evidencia) throws DocumentException {
		if(Evidencia.equals("SI")) {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", element);
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {

			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}
		
		} else {  
			try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", element);
			waitInMs(2000);
			} 
			catch (Exception e) {System.out.print(e);			}
		}
	}
	
	/**
	 * Scroll element H.
	 *
	 * @param locator the locator
	 * @throws DocumentException the document exception
	 */
	public void scrollElementH(By locator) throws DocumentException {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", element);
			waitInMs(2000);
	}

	/**
	 * Scroll down.
	 */
	// METODO DE SCROLL HACIA ABAJO
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		waitInMs(2000);
	}

	/**
	 * Scroll up.
	 */
	// METODO DE SCROLL HACIA ARRIBA
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");
		waitInMs(2000);
	}

	/**
	 * Wait in ms.
	 *
	 * @param milliseconds the milliseconds
	 */
	// METODO DE ESPERA
	public static void waitInMs(Integer milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Time.
	 *
	 * @param time the time
	 * @throws InterruptedException the interrupted exception
	 */
	// METODO DE ESPERA
	public void time(long time) throws InterruptedException {
		Thread.sleep(time * 1000);
	}

	/**
	 * Fecha pdf.
	 *
	 * @return the string
	 */
	// FECHA CON UN MEJOR FORMATO PARA MOSTRAR EN PDF
	public static String fechaPdf() {
		LocalDateTime fechaSistema = LocalDateTime.now();
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String fechaPdf = fecha.format(fechaSistema);
		return fechaPdf;
	}

	/**
	 * Hora pdf.
	 *
	 * @return the string
	 */
	// HORA CON UN MEJOR FORMATO PARA MOSTRAR EN PDF
	public static String horaPdf() {
		LocalDateTime horaSistema = LocalDateTime.now();
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaPdf = hora.format(horaSistema);
		return horaPdf;
	}

	/**
	 * Fecha sistema.
	 *
	 * @return the string
	 */
	// METODO PARA TRAER LA FECHA DEL SISTEMA
	public static String fechaSistema() {
		LocalDateTime fechaSistema = LocalDateTime.now();
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String Fecha = fecha.format(fechaSistema);
		return Fecha;
	}

	/**
	 * Hora sistema.
	 *
	 * @return the string
	 */
	// METODO PARA TRAER LA HORA DEL SISTEMA
	public static String horaSistema() {
		LocalTime horaSistema = LocalTime.now();
		DateTimeFormatter horaS = DateTimeFormatter.ofPattern("HHmmss");
		String hora = horaS.format(horaSistema);
		return hora;
	}

	/**
	 * Capture screen.
	 *
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	// CAPTURA DE PANTALLA
	public void captureScreen(File folderPath, String steps,String Evidencia) throws Exception {
		String hora = horaSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(folderPath + "\\" + hora + ".png"));
		String imagePath = new File(folderPath + "\\" + hora + ".png").toString();
		GenerarReportePdf.createBody(steps, imagePath);// INSTALAR LOCALIZADOR DE IMAGEN PDF
		deleteFile(imagePath);// ELIMNAR IMAGEN CREADA
	}

	
	
	/**
	 * Capture screen A.
	 *
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @throws Exception the exception
	 */
	// CAPTURA DE PANTALLA
	public static void captureScreenA(File folderPath, String steps) throws Exception {
		String hora = horaSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(folderPath + "\\" + hora + ".png"));
		String imagePath = new File(folderPath + "\\" + hora + ".png").toString();
		GenerarReportePdf.createBody(steps, imagePath);// INSTALAR LOCALIZADOR DE IMAGEN PDF
		deleteFileA(imagePath);// ELIMNAR IMAGEN CREADA
	}
	
	
	/**
	 * Screenshot.
	 *
	 * @return the byte[]
	 */
	@Attachment(value = "Screenshot", type = "image/png")
	public static byte[] screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	/**
	 * Capture error.
	 *
	 * @param rutaCarpeta the ruta carpeta
	 * @param texto the texto
	 * @param Evidencia the evidencia
	 * @param mensajeError the mensaje error
	 * @throws Exception the exception
	 */
	// CAPTURA DE PANTALLA ERROR
	public void captureError(File rutaCarpeta, String texto, String Evidencia, String mensajeError) throws Exception {
		 
			String hora = horaSistema();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
			String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();
			GenerarReportePdf.createErrorBody(texto, rutaImagen, mensajeError);// INSTALAR LOCALIZADOR DE IMAGEN PDF
			deleteFile(rutaImagen);// ELIMNAR IMAGEN CREADA
		
	}

	/**
	 * Capture screen pdf.
	 *
	 * @param rutaCarpeta the ruta carpeta
	 * @param funcion the funcion
	 * @throws Exception the exception
	 */
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

	/**
	 * Creates the folder.
	 *
	 * @param nameFolder the name folder
	 * @param path the path
	 * @return the file
	 */
	// METODO PARA CREAR CARPETA PARA CAPTURA
	public static File createFolder(String nameFolder, String path,String Evidencia) {
		if(Evidencia.equals("SI")) 
		{
			
		
		String fecha = fechaSistema();
		String nomCarpeta = nameFolder + " " + fecha;
		File directorio = new File(path + nomCarpeta);
		directorio.mkdir();
		return directorio;  
		}
		else 
		{
			System.out.println("Carpeta no creada");
			
		}
		return null;
		
		
	}

	/**
	 * Delete file.
	 *
	 * @param rutaImagen the ruta imagen
	 */
	// METODO PARA ELIMINAR ARCHIVO
	public void deleteFile(String rutaImagen) {
		File fichero = new File(rutaImagen);
		fichero.delete();
	}
	
	
	/**
	 * Delete file A.
	 *
	 * @param rutaImagen the ruta imagen
	 */
	// METODO PARA ELIMINAR ARCHIVO
		public static void deleteFileA(String rutaImagen) {
			File fichero = new File(rutaImagen);
			fichero.delete();
		}


	/**
	 * File upload.
	 *
	 * @param elementLocation the element location
	 * @param archive the archive
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	// METODO PARA CARGAR UN ARCHIVO DESDE LA MAQUINA
	public void fileUpload(By elementLocation, String archive, File folderPath, String steps,String Evidencia) throws Exception {
		if(Evidencia.equals("SI")) {
		try {
			visibilityOfElementLocated(elementLocation);
			File file = new File(archive);
			WebElement ruta = driver.findElement(elementLocation);
			ruta.sendKeys(file.getAbsolutePath());
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}}else { 
			
			File file = new File(archive);
			WebElement ruta = driver.findElement(elementLocation);
			ruta.sendKeys(file.getAbsolutePath());
			waitInMs(2000);
			
			
		}
	}
	
	
	/**
	 * File up full.
	 *
	 * @param elementLocation the element location
	 * @param archive the archive
	 * @throws Exception the exception
	 */
	// METODO PARA CARGAR UN ARCHIVO DESDE LA MAQUINA
	public void fileUpFull(By elementLocation, String archive) throws Exception {
			//	visibilityOfElementLocated(elementLocation);
			File file = new File(archive);
			WebElement ruta = driver.findElement(elementLocation);
			ruta.sendKeys(file.getAbsolutePath());
			waitInMs(2000);
			
	}
	

	
	
	/**
	 * Accept alert.
	 *
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	//Metodo para aceptar una alerta
	public void acceptAlert(File folderPath, String steps,String Evidencia) throws Exception {
		driver.switchTo().alert().accept();
		waitInMs(2000);
		captureScreen(folderPath, steps,Evidencia);
	}

	/**
	 * Cancel alert.
	 */
	//Metodo para cancelar una alerta
	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
		waitInMs(2000);
	}

	/**
	 * Write alert.
	 *
	 * @param text the text
	 */
	//Metodo para escribir una alerta
	public void writeAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
		waitInMs(2000);
	}

	/**
	 * Enter.
	 *
	 * @param elementLocation the element location
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//Metodo para dar entera una alerta
	public void enter(By elementLocation) throws IOException {
		driver.findElement(elementLocation).sendKeys(Keys.ENTER);
	}

	/**
	 * By pixel.
	 */
	//Metodo para medir el tamaño de un elemento
	public void ByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,1000)");
	}

	/**
	 * Jump page.
	 *
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws DocumentException the document exception
	 */
	// SALTO DE PAGINA
	public void jumpPage(File folderPath, String steps,String Evidencia) throws DocumentException {
		if(Evidencia.equals("SI")) {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().window(driver.getWindowHandle());
			Object[] parentHandle = driver.getWindowHandles().toArray();
			driver.switchTo().window((String) parentHandle[1]);
			driver.manage().window().maximize();
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		} }else {  
			
			driver.switchTo().defaultContent();
			driver.switchTo().window(driver.getWindowHandle());
			Object[] parentHandle = driver.getWindowHandles().toArray();
			driver.switchTo().window((String) parentHandle[1]);
			driver.manage().window().maximize();
			
		}
	}

	/**
	 * Change windows.
	 *
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws DocumentException the document exception
	 */
	// CAMBIO DE VENTANA
	public void changeWindows(File folderPath, String steps,String Evidencia) throws DocumentException {
		if(Evidencia.equals("SI")) {
		try {
			ArrayList<String> ventana = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) ventana.get(1));
			driver.close();
			driver.switchTo().window((String) ventana.get(0));
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}} else { 
			
			ArrayList<String> ventana = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) ventana.get(1));
			driver.close();
			driver.switchTo().window((String) ventana.get(0));
			waitInMs(2000);
			
		}
	}

	/**
	 * Select key board.
	 *
	 * @param field the field
	 */
	public static void selectKeyBoard(WebElement field) {
		field.sendKeys(Keys.UP);
		field.click();
		field.sendKeys(Keys.ENTER);
		waitInMs(2000);
	}

	/**
	 * Etiquetas.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws DocumentException the document exception
	 */
	// METODO ETIQUETA
	public void etiquetas(By elementLocation, File folderPath, String steps,String Evidencia) throws DocumentException {
		if(Evidencia.equals("SI")) {
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(elementLocation);
			action.moveToElement(element).perform();
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}} else { 
			
			
			try {
				Actions action = new Actions(driver);
				WebElement element = driver.findElement(elementLocation);
				action.moveToElement(element).perform();
				captureScreen(folderPath, steps,Evidencia);
			} 
			catch (Exception e) {System.out.print(e);}			
			
		} 
		
	}
	

	/**
	 * List random.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @throws DocumentException the document exception
	 */
	// METODO LISTA RANDOM
	public void listRandom(By elementLocation, File folderPath, String steps,String Evidencia) throws DocumentException {
		if(Evidencia.equals("SI")) {
		try {
			WebElement Drplistdown = driver.findElement(elementLocation);
			Select objSel = new Select(Drplistdown);
			List<WebElement> weblist = objSel.getOptions();
			int iCnt = weblist.size();
			Random num = new Random();
			int iSelect = num.nextInt(iCnt);
			objSel.selectByIndex(iSelect);
			printConsole(Drplistdown.getAttribute("value"));
			captureScreen(folderPath, steps,Evidencia);
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		} } else {
			
			try {
			WebElement Drplistdown = driver.findElement(elementLocation);
			Select objSel = new Select(Drplistdown);
			List<WebElement> weblist = objSel.getOptions();
			int iCnt = weblist.size();
			Random num = new Random();
			int iSelect = num.nextInt(iCnt);
			objSel.selectByIndex(iSelect);
			printConsole(Drplistdown.getAttribute("value"));
			} catch (Exception e) {System.out.print(e);	}
			
		}
	}
	
	
	//catch (Exception e) {System.out.print(e);			}
	//Metodo sin screenshot de lista random
	
	/**
	 * List random.
	 *
	 * @param elementLocation the element location
	 * @throws DocumentException the document exception
	 */
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

	/**
	 * Validar elemento.
	 *
	 * @param elementLocation the element location
	 * @param time the time
	 * @return true, if successful
	 */
	// METODO VALIDACIÓN devuelve una respuesta booleana de falso o verdadero que se puede usar para validar objetos
	public static boolean validarElemento(By elementLocation, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
			return true ;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * Validar elemento A.
	 *
	 * @param elementLocation the element location
	 * @param time the time
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @return true, if successful
	 */
	//Metodos de validacion no usables
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
	
	
	
	
	
	
	//Metodos de validacion no usables

	/**
	 * Validar elementos.
	 *
	 * @param x the x
	 * @param time the time
	 * @return true, if successful
	 */
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

	/**
	 * Gets the element.
	 *
	 * @param elementLocation the element location
	 * @return the element
	 */
	public WebElement getElement(By elementLocation) {
		return driver.findElement(elementLocation);
	}

	/**
	 * Checks if is selected.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @return true, if is selected
	 * @throws DocumentException the document exception
	 */
	//Metodo para saber si un elemento esta seleccionado
	public boolean isSelected(By elementLocation, File folderPath, String steps,String Evidencia) throws DocumentException {
		try {
			visibilityOfElementLocated(elementLocation);
			boolean selected = driver.findElement(elementLocation).isSelected();
			waitInMs(2000);
			return selected;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}
		return false;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @param elementLocation the element location
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @return true, if is enabled
	 * @throws DocumentException the document exception
	 */
	//Metodo para saber si un campo esta habilitado de ser asi retorna un enabled
	public boolean isEnabled(By elementLocation, File folderPath, String steps,String Evidencia) throws DocumentException {
		if(Evidencia.equals("SI")) {
		try {
			
			visibilityOfElementLocated(elementLocation);
			//esta habilitado o is enabled  de un elemento localizador 
			boolean enabled = driver.findElement(elementLocation).isEnabled();
			waitInMs(2000);
			captureScreen(folderPath, steps,Evidencia);
			//Retorna enabled
			return enabled;
		} catch (Exception e) {
			GenerarReportePdf.closeTemplate(e.toString(), Evidencia);
		}
		return false;  
			
			
			
		
	}
	else {
		
		try {
			
			visibilityOfElementLocated(elementLocation);
			//esta habilitado o is enabled  de un elemento localizador 
			boolean enabled = driver.findElement(elementLocation).isEnabled();
			waitInMs(2000);
			return enabled;
			} catch (Exception e) {System.out.print(e);} 
		
		return false;
		
		
	}  
		
	} 
	
	
	//catch (Exception e) {System.out.print(e);			}
	
	
	/**
	 * Date plus year.
	 *
	 * @param year the year
	 * @return the string
	 */
	//Metodo de escritura de una fecha mas la cantidad de años deseados
	public String datePlusYear(int year) {
		LocalDate lastAprilDay = LocalDate.now();
        LocalDate firstMay = lastAprilDay.plusYears(year);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formatDate = formatter.format(firstMay);
        System.out.println("Fecha: " + formatDate);
		return formatDate;
	}
	//Metodo de escritura de un valor random numerico
	
	/**
	 * Write random num.
	 *
	 * @param elementLocation the element location
	 * @param num the num
	 */
	public void writeRandomNum(By elementLocation, int num) {
		String acta = RandomStringUtils.randomNumeric(num);
		driver.findElement(elementLocation).sendKeys(acta);
		waitInMs(1000);
	}
	
	/**
	 * Write random alp.
	 *
	 * @param elementLocation the element location
	 * @param num the num
	 */
	//Metodo de escribir un valor random alfanumerico
	public void writeRandomAlp(By elementLocation, int num) {
		String acta = RandomStringUtils.randomAlphabetic(num).toLowerCase();
		driver.findElement(elementLocation).sendKeys(acta);
	}
	
	/**
	 * Escape.
	 */
	//Metodo de darle escape a la pagina
	public void escape() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	/**
	 * Validacion objetos.
	 *
	 * @param valor1 the valor 1
	 * @param valor2 the valor 2
	 * @param caso the caso
	 * @param folderPath the folder path
	 * @param Evidencia the evidencia
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws DocumentException the document exception
	 */
	//Se valida varios objetos que sea existente al convertirlo en un valor booleano de true o false
	public void ValidacionObjetos(boolean valor1, boolean valor2, String caso, File folderPath,String Evidencia ) throws IOException, DocumentException 
	
	{
		if(Evidencia.equals("SI")) {
	//##Ver el metodo validar objeto, se validan varios objetos pero se usa la misma mecanica de validar objeto
		
		if(valor1 == true  && valor2 == true )
			
		{
			screenshot(folderPath ,"La validacion es exitosa  para el caso " + caso );			
		}
		else 
		{
			screenshot(folderPath ,"La validacion no es exitosa para los casos ejecutados ");
					
		}
		
		} 
		else if(valor1 == true  && valor2 == true ) 
		{
			System.out.println("Validacion exitosa");
		}
		else 
		{
			System.out.println("Validacion no exitosa");
		}
	}
	
	//Se valida un objeto que sea existente al convertirlo en un valor booleano de true o false 
	
	/**
	 * Validacion objeto.
	 *
	 * @param valor1 the valor 1
	 * @param caso the caso
	 * @param folderPath the folder path
	 * @param Evidencia the evidencia
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws DocumentException the document exception
	 */
	public void ValidacionObjeto(boolean valor1, String caso, File folderPath,String Evidencia ) throws IOException, DocumentException 
	
	{
		if(Evidencia.equals("SI")) {
		//Si el objeto booleano es verdadero imprimira en evidencias caso exitoso
		if(valor1 == true  )
			
		{
			screenshot(folderPath ,"La validacion es exitosa  para el caso " + caso );			
		}
		//En caso contrario imprimira otro mensaje
		else 
		{
			screenshot(folderPath ,"La validacion no es exitosa el elemento a validar no esta presente " );
					
		}
		} else if(valor1 == true  ) 
		{
			
			System.out.println("Validacion exitosa");
			
			
		}
		else 
		{
			System.out.println("Validacion no exitosa");
		}
		
			
	}
	
public void ValidacionObjeto2(boolean valor1, String caso, File folderPath,String Evidencia ) throws IOException, DocumentException 
	
	{
		
		if(Evidencia.equals("SI")) 
		{
		//Si el objeto booleano es verdadero imprimira en evidencias caso exitoso
		if(valor1 == true  ) 
			
		{
			screenshot(folderPath ,"La validacion es exitosa  para el caso " + caso );			
		}
		//En caso contrario imprimira otro mensaje
		else 
		{
			
			screenshot(folderPath ,"La validacion no es exitosa el elemento a validar no esta presente " );
			
			GenerarReportePdf.closeTemplate(caso, Evidencia);
					
		}
		} 
		else if(valor1 == true  ) 
		{
			
			System.out.println("Validacion exitosa");
			
			
		}
		else 
		{
			System.out.println("Validacion no exitosa");
		}
		
			
	}
	
	
	//try {
	//Metodo de recargar pagina
	
	/**
	 * Recargar pagina.
	 *
	 * @param elemenLocation the elemen location
	 */
	public void RecargarPagina(By elemenLocation) 
	{
		driver. findElement(elemenLocation).sendKeys(Keys.F5);
	}
	
	/**
	 * Search element grid excel 2.
	 *
	 * @param tableResult the table result
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @return the string
	 * @throws Exception the exception
	 */
	// METODO PARA BUSCAR UN ELEMENTO EN UNA GRILLA  DE EXCEL 2
	   public String searchElementGridExcel2(By tableResult, File folderPath, String steps,String Evidencia)
	         throws Exception {
	      String row = null;
	      ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult)
	            .findElements(By.tagName("thead"));
	      for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
	         WebElement campo = (WebElement) iterator.next();
	         row = campo.getText();
	         String[] prueba = row.split(row);
	         System.out.println(Arrays.toString(prueba));
	         WriteExcelFile.writeExcel("./Data/Prueba.xlsx", "Hoja1", prueba); } 
	   waitInMs(2000);
	   captureScreen(folderPath, steps,Evidencia);
	   return row;
	}
	   
	/**
	 * Send table to excel.
	 *
	 * @param tableResult the table result
	 * @param folderPath the folder path
	 * @param steps the steps
	 * @param Evidencia the evidencia
	 * @return the string
	 * @throws Exception the exception
	 */
	// METODO PARA BUSCAR UN ELEMENTO EN UNA GRILLA  DE EXCEL
	public String sendTableToExcel(By tableResult, File folderPath, String steps,String Evidencia) throws Exception {
	       String row = null;
	       WebElement tabla = null;
	       ArrayList<String> prueba1 = new ArrayList<String>();
	       visibilityOfElementLocated(tableResult);
	       ArrayList<WebElement> resultado = (ArrayList<WebElement>) driver.findElement(tableResult).findElements(By.tagName("td"));
	       for (Iterator<WebElement> iterator = resultado.iterator(); iterator.hasNext();) {
	           tabla = (WebElement) iterator.next();
	           row = tabla.getText();
	           prueba1.add(row);
	       }
	       System.out.println(prueba1);   
	       captureScreen(folderPath, steps,Evidencia);
	       return row;
	   }
	
	/**
	 * Select colunm grid.
	 *
	 * @param numColumn the num column
	 * @param numColumn1 the num column 1
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//TRAER DATA DE UNA TABLA WEB A UN EXCEL 
	public void selectColunmGrid(int numColumn, int numColumn1) throws IOException {

        String beforeXpath =  "//tbody/tr[";//tbody/tr[]/td[]

        String afterXpath =  "]/td[";

        String cierre  =  "]";



        List<WebElement> rows = driver.findElements(By.xpath("//table[@role='grid']//tr"));

        ArrayList<String> array = new ArrayList<String>();

        for(int i=1; i<rows.size(); i++){

            String actualXpath = beforeXpath+i+afterXpath+numColumn+cierre;

            String column = driver.findElement(By.xpath(actualXpath)).getText();

            array.add(column);



        }

        System.out.println(array);

    }
	
	/**
	 * Select colunm grid.
	 *
	 * @param numColumn the num column
	 * @param numColumn1 the num column 1
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//TRAER DATA DE UNA TABLA WEB A UN EXCEL 
	public ArrayList<String> SelectedColunmGrid(int numColumn) throws IOException {

        String beforeXpath =  "//tbody/tr[";//tbody/tr[]/td[]

        String afterXpath =  "]/td[";

        String cierre  =  "]";

        List<WebElement> rows = driver.findElements(By.xpath("//table[@role='grid']//tr"));

        ArrayList<String> array = new ArrayList<String>();

        for(int i=1; i<rows.size(); i++){

            String actualXpath = beforeXpath+i+afterXpath+numColumn+cierre;

            String column = driver.findElement(By.xpath(actualXpath)).getText();

            array.add(column);

        }

        System.out.println(array);
        return array;

    }

	
}