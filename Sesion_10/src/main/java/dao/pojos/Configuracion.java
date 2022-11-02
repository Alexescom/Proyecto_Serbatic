package dao.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Configuracion {
	
	//Variables
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	@Id
	private String clave;
	private String valor;


	public Configuracion() {

	}
	public Configuracion(String clave, String valor) {

		this.clave = clave;
		this.valor = valor;
	}
	//Métodos
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
