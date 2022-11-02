package Service;

import java.util.ArrayList;
import java.util.List;

import dao.ConfiguracionDB;
import dao.pojos.Configuracion;

public class ConfiguracionService {
	
	//Variables
	
	//Métodos
	public static String getNumeroFactura() {
//		ConfiguracionDB.create(new Configuracion("numero_factura", "1"));
//		ConfiguracionDB.create(new Configuracion("prefijo", "49012"));
//		ConfiguracionDB.create(new Configuracion("ajuste", "5"));
		//Recogemos informacion de la base de datos
		String num_factura = ConfiguracionDB.getConfiguracion("FROM Configuracion WHERE clave='numero_factura'").get(0).getValor();
		String prefijo = ConfiguracionDB.getConfiguracion("FROM Configuracion WHERE clave='prefijo'").get(0).getValor();
		String ajuste = ConfiguracionDB.getConfiguracion("FROM Configuracion WHERE clave='ajuste'").get(0).getValor();
		int ajust = Integer.parseInt(ajuste);
		//Actualizamos la base de datos
		Integer num = Integer.parseInt(num_factura);
		num += 1;
		Configuracion cf = new Configuracion();
		//cf.setId(1);
		cf.setClave("numero_factura");
		cf.setValor(num.toString());
		ConfiguracionDB.update(cf);
		//Rellenamos con 0 a la izquierda
		 for (int i = num_factura.length(); i < ajust; i++) {
			 num_factura = 0 + num_factura;
		 }
		
		return prefijo + num_factura;
	}
	
	
	public static List<Configuracion> getConfiguracion() {

		return ConfiguracionDB.getConfiguracion("");
		
	}
	
	public static void setConfiguracion(ArrayList<Configuracion> c) {

		ConfiguracionDB.update(c);
		
	}
}
