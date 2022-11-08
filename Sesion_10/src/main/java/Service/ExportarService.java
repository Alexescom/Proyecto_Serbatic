package Service;

import java.io.File;
import java.util.ArrayList;

import dao.OperationsProductosDB;
import dao.pojos.Articulo;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class ExportarService {
	
	//Variables
	
	//Métodos
	public static void exportarProductos(ArrayList<Articulo> articulos) {
		
		File fichero = new File("F:\\Ale\\Formaciones\\Sesion_10\\src\\main\\webapp\\Sources\\Ficheros\\Exportar\\articulos.xls");
		
        try {
        	int i = 1;
        	WritableWorkbook w = Workbook.createWorkbook(fichero);
        	
        	/*
        	Workbook wb = Workbook.getWorkbook(fichero);
        	WritableWorkbook w = Workbook.createWorkbook(fichero, wb);
        	*/
        	
        	//Nombre de la hoja
        	WritableSheet sheet = w.createSheet("Productos", 0);
        	
        	//Rellenamos primera fila
        	
			jxl.write.Label idn = new jxl.write.Label(0, i, "Id");
			sheet.addCell(idn);
			jxl.write.Label idcn = new jxl.write.Label(1, i, "Id_categoria");
			sheet.addCell(idcn);
			jxl.write.Label nombren = new jxl.write.Label(2, i, "Nombre");
			sheet.addCell(nombren);
			jxl.write.Label descripcionn = new jxl.write.Label(3, i, "Descripcion");
			sheet.addCell(descripcionn);
			jxl.write.Label precion = new jxl.write.Label(4, i, "Precio");
			sheet.addCell(precion);
			jxl.write.Label stockn = new jxl.write.Label(5, i, "Stock");
			sheet.addCell(stockn);
			jxl.write.Label impueston = new jxl.write.Label(6, i, "Impuesto");
			sheet.addCell (impueston);
			
        	i++;
        	
        	for (Articulo a : articulos) {
        			
        			jxl.write.Number id = new jxl.write.Number(0,i, a.getId());
        			sheet.addCell(id);
        			
        			jxl.write.Number idc = new jxl.write.Number(1,i, a.getId_categoria());
        			sheet.addCell(idc);
        			
        			jxl.write.Label nombre = new jxl.write.Label(2, i, a.getNombre());
        			sheet.addCell(nombre);
        			
        			jxl.write.Label descripcion = new jxl.write.Label(3, i, a.getDescripcion());
        			sheet.addCell(descripcion);
        			
        			jxl.write.Number precio = new jxl.write.Number(4,i, a.getPrecio());
        			sheet.addCell(precio);
        			
        			jxl.write.Number stock = new jxl.write.Number(5,i, a.getStock());
        			sheet.addCell(stock);
        			
        			jxl.write.Number impuesto = new jxl.write.Number(6,i, a.getImpuesto());
        			sheet.addCell(impuesto);


        		i++;
        	}

            w.write();
            w.close();
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
	}
	
	public static void importarProductos(String filename) {
		
		File fichero = new File("F:\\Ale\\Formaciones\\Sesion_10\\src\\main\\webapp\\Sources\\Ficheros\\Importar\\" + filename);
		ArrayList <Articulo> articulos = new ArrayList<Articulo>();
		
        try {
        	Workbook w = Workbook.getWorkbook(fichero);
        	
        	//Se lee la primera hoja de la excel
        	Sheet sheet = w.getSheet(0);
        	for (int f=0; f<sheet.getRows(); f++) {
        		Articulo artic = new Articulo();

        		artic.setId_categoria(Integer.parseInt(sheet.getCell(0,f).getContents()));
        		System.out.println("Categoria:" + artic.getId_categoria());
        		artic.setNombre(sheet.getCell(1,f).getContents());
        		System.out.println("Nombre: " + artic.getNombre());
        		artic.setDescripcion(sheet.getCell(2,f).getContents());
        		System.out.println("Descripcion: " + artic.getDescripcion());
        		artic.setPrecio(Float.parseFloat(sheet.getCell(3,f).getContents()));
        		System.out.println("Precio: " + artic.getPrecio());
        		artic.setStock(Integer.parseInt(sheet.getCell(4,f).getContents()));
        		System.out.println("Stock: " + artic.getStock());
        		artic.setImpuesto(Float.parseFloat(sheet.getCell(5,f).getContents()));
        		System.out.println("Impuesto: " + artic.getImpuesto());
        		
        		//Agregamos a base de datos
        		OperationsProductosDB.insertarProducto(artic);
        	}
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
	}
}
