package Service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.pojos.Detalle;
import dao.pojos.Pedido;
import extraSources.PDFHeaderFooter;

public class DocumentoService {
	
	//Métodos
	public static void exportarPDF(ArrayList<Detalle> detalles, Pedido p) {
		PdfWriter writer = null;
		Document documento = new Document(PageSize.A4, 20, 20, 70, 50);
		
		try {
			//Instancia del archivo
			String nombre = p.getNum_factura() + "factura.pdf";
			writer = PdfWriter.getInstance(documento, new FileOutputStream(nombre));
			
			//Insertamos cabecera y pies
	    	writer.setPageEvent(new PDFHeaderFooter());
	    	
	    	//Abrimos el documento para edición
			documento.open();
			
			//Párrafo inicial
			Paragraph para = new Paragraph();
			float tamanno = 20;
			para.add("\n\n");
			para.setFont(new Font(FontFactory.getFont("Sans", tamanno , Font.BOLD, BaseColor.BLACK)));
			para.add("\n\n");
			para.add("Número de factura: " + p.getNum_factura());
			para.setAlignment(Element.ALIGN_LEFT);
			para.add("\n\n");
			documento.add(para);
			
			
			
			//Parrafo siguiente
			Paragraph para2 = new Paragraph();
			tamanno = 12;
			para2.add("\n\n");
			para2.setFont(new Font(FontFactory.getFont("Sans", tamanno , Font.NORMAL, BaseColor.BLACK)));
			para2.add("Información del pedido: ");
			para2.add("\n\n");
			documento.add(para2);
			
			//TABLA
			PdfPTable tabla = new PdfPTable(4);
			
			//CABECERAS
			//1
			Phrase texto = new Phrase("Nombre producto");
			PdfPCell cabecera1 = new PdfPCell(texto);
			cabecera1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecera1.setBorderWidth(1);
			
			//2
			texto = new Phrase("Cantidad");
			PdfPCell cabecera2 = new PdfPCell(texto);
			cabecera2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecera2.setBorderWidth(1);
			
			//3
			texto = new Phrase("Precio U.");
			PdfPCell cabecera3 = new PdfPCell(texto);
			cabecera3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecera3.setBorderWidth(1);
			
			//4
			texto = new Phrase("Precio T.");
			PdfPCell cabecera4 = new PdfPCell(texto);
			cabecera4.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cabecera4.setBorderWidth(1);
			
			//Rellenamos cabecera
		    tabla.addCell(cabecera1);
		    tabla.addCell(cabecera2);
		    tabla.addCell(cabecera3);
		    tabla.addCell(cabecera4);
		    
		    //Rellenamos la tabla
		    for (Detalle d: detalles) {
		    	
		    	double totalProducto = Math.round(d.getTotal() * 100) /100d;
		    	tabla.addCell(d.getNombre());
		    	tabla.addCell(d.getUnidades() + "");
		    	tabla.addCell(d.getPrecio_unidad() + "");
		    	tabla.addCell(totalProducto + "");
		    	
		    }

			//Añadimos la tabla al documento
		    documento.add(tabla);
		    
		    //Total
		    Paragraph para1 = new Paragraph();
			double total = Math.round(p.getTotal() * 100) / 100d;
			tamanno = 12;
			para1.add("\n\n");
			para1.setFont(new Font(FontFactory.getFont("Sans", tamanno , Font.NORMAL, BaseColor.BLACK)));
			para1.add("Método de pago: " + p.getMetodo_pago() +".");
			para1.add("\n\n");
			para1.add("Coste total del pedido: " + total + "$");
			para1.add("\n\n");
			para1.add("\n\n");
			documento.add(para1);
		    
		    
		    //Cerramos el documento
		    documento.close();
		    writer.close();
		    
		    try {
		        File path = new File(nombre);
		        Desktop.getDesktop().open(path);
		    	
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
		    
	
		} catch (Exception ex) {
	    	ex.getMessage();
	    }
	}

}
