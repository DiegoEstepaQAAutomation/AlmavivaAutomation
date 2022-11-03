package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.demoautomatizacion.Pages.BasePage;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerarReportePdf {

	static FileOutputStream archivo;
	static Paragraph titulo, urlApp, horaInicio;
	static String tipoPrueba = "Automatizada";
	static String routeImageReport;
	static int imgContador = 0;

	static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
	
	static Document documento = new Document(); // INSTANCIAR DOCUMENTO
	static String horaSinFormato = BasePage.horaSistema();
	static String fecha = BasePage.fechaPdf();
	static Date horaI = new Date();
	static Date horaF = new Date();
	static Font font = new Font();
	static String fondoFooter = "./src/test/resources/images/fondo.png/";

	public static void setRutaImagen(String routeImageReport) {
		GenerarReportePdf.routeImageReport = routeImageReport;
	}

	public static void setImgContador(int imgContador) {
		GenerarReportePdf.imgContador = imgContador;
	}

	public static void createTemplate(File folderPath, String nameTest, String analyst, String url,String Evidencia) {
		//documento = new Document();
		if(Evidencia.equals("SI")) {
		try {
			font.setColor(BaseColor.GRAY);
			font.setFamily("ITALIC");
			archivo = new FileOutputStream(folderPath + "\\" + "Reporte " + nameTest + " " + horaSinFormato + ".pdf");// RUTA/IMAGEN
																														// DEL
																														// PDF
			PdfWriter writer = PdfWriter.getInstance(documento, archivo);
			Image logoHeader = Image.getInstance(routeImageReport);// IMAGEN
			logoHeader.scalePercent(50);
			logoHeader.setWidthPercentage(100);
			titulo = new Paragraph("Caso de Prueba: " + nameTest + "\n\n" + "Fecha Ejecución: " + fecha + "\n"
					+ "Analista: " + analyst + "\n" + "Tipo de Prueba: " + tipoPrueba, font);// TITULO PDF
			titulo.setAlignment(1);
			urlApp = new Paragraph("Url de prueba: " + url);
			urlApp.setAlignment(Chunk.ALIGN_LEFT);
			urlApp.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL));
			horaInicio = new Paragraph("Hora de inicio: " + dateFormat.format(horaI));
			horaInicio.setAlignment(Chunk.ALIGN_LEFT);
			horaInicio.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL));
			PdfPTable table = new PdfPTable(2);// TABLA ENCABEZADO
			table.setWidthPercentage(100);
			PdfPCell p1 = new PdfPCell(titulo);
			p1.setHorizontalAlignment(1);
			p1.setVerticalAlignment(2);
			p1.setBorderColor(BaseColor.GRAY);
			PdfPCell p2 = new PdfPCell(logoHeader);
			p2.setHorizontalAlignment(1);
			p2.setVerticalAlignment(2);
			p2.setBorderColor(BaseColor.GRAY);
			table.addCell(p2);
			table.addCell(p1);
			documento.setMargins(60, 40, 30, 30);// MARGEN
			documento.open();
			documento.add(table);
			HeaderFooter headerFooter = new HeaderFooter();
			writer.setPageEvent(headerFooter);
			documento.add(urlApp);
			documento.add(horaInicio);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}   else {System.out.println("Archivo no creado"); 
	
	
	}  
		
	
	}
	

	public static void createBody(String steps, String imagePath)
			throws DocumentException, MalformedURLException, IOException {

		Paragraph parrafo = new Paragraph();// OBTENER EL NOMBRE DEL LOCALIZADOR
		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL));
		parrafo.add("\n\nAcción: " + steps + "\n");
		documento.add(parrafo);
		Image imagen = Image.getInstance(imagePath);
		imagen.scalePercent(26, 26);
		imagen.setAlignment(Chunk.ALIGN_CENTER);
		imagen.setBorder(Image.BOX);
		imagen.setBorderWidth(3);
		imagen.setBorderColor(BaseColor.BLACK);
		documento.add(imagen);
		imgContador = imgContador + 1;
		if (imgContador == 2) {
			documento.newPage();
			imgContador = 0;
		}
	}

	public static void createErrorBody(String steps, String imagePath, String errorMessage)
			throws DocumentException, MalformedURLException, IOException {

		Paragraph parrafo = new Paragraph();// OBTENER EL NOMBRE DEL LOCALIZADOR
		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Times", 8, Font.NORMAL, BaseColor.GRAY));
		parrafo.add("Acción: " + steps);
		documento.add(parrafo);
		Image imagen = Image.getInstance(imagePath);
		imagen.scalePercent(25, 35);
		imagen.scaleToFit(500, 500);
		imagen.setAlignment(Chunk.ALIGN_CENTER);
		documento.add(imagen);
		imgContador = imgContador + 1;
		if (imgContador == 2) {
			documento.newPage();
			imgContador = 0;
		}
		Paragraph elementoError = new Paragraph();
		elementoError.setAlignment(Chunk.ALIGN_LEFT);
		elementoError.setFont(FontFactory.getFont("Times", 10, Font.NORMAL, BaseColor.RED));
		elementoError.add("\nAcción con error: " + steps);
		Paragraph parrafoError = new Paragraph();
		parrafoError.setAlignment(Chunk.ALIGN_LEFT);
		parrafoError.setFont(FontFactory.getFont("Times", 6, Font.NORMAL, BaseColor.RED));
		parrafoError.add("\nMensaje de error:\n" + errorMessage);
		documento.add(elementoError);
		documento.add(parrafoError);
		documento.close();
	}

	public static void closeTemplate(String error,String Evidencia) throws DocumentException {
		if(Evidencia.equals("SI")) {
		horaF = new Date();
		long diff = (horaF.getTime() - horaI.getTime());
		String executionTime = simpleDateFormat.format(new Date(diff));
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_RIGHT);
		parrafo.setFont(FontFactory.getFont("Arial", 12, Font.NORMAL));
		parrafo.add("Hora de Finalización: " + dateFormat.format(horaF));
		parrafo.add("\nTiempo de Ejecucion:" + executionTime);
		documento.add(Chunk.NEWLINE);
		documento.add(parrafo);
		if (!error.equals("")) {
			documento.add(new Paragraph(error, FontFactory.getFont("Arial", 12, Font.NORMAL, BaseColor.RED)));
			Paragraph estate = new Paragraph("\n\nEstado: Fallido",
					FontFactory.getFont("Arial", 20, Font.UNDERLINE, BaseColor.RED));
			estate.setAlignment(1);
			documento.add(estate);
		}
		documento.close();
		
		}else { 
			
			System.out.println("Archivo no se creo");
			
		
		}
	}

	public static class HeaderFooter extends PdfPageEventHelper {

		@Override
		public void onEndPage(PdfWriter writer, Document document) {
			float x = (document.getPageSize().getLeft() + document.getPageSize().getRight()) / 2;
			font.setColor(BaseColor.GRAY);
			font.setFamily("Arial");
			ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
					new Phrase("Pagina: " + writer.getPageNumber(), font), x, 20, 0);
			PdfContentByte cb = writer.getDirectContentUnder();
			PdfGState trans = new PdfGState();
			try {
				Image logoFooter = Image.getInstance(fondoFooter);
				logoFooter.setAbsolutePosition(0, 0);
				logoFooter.scalePercent(23);
				trans.setFillOpacity(1f);
				cb.setGState(trans);
				cb.addImage(logoFooter);
			} catch (BadElementException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}
}
