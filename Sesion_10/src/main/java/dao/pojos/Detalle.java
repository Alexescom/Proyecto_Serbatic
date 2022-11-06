package dao.pojos;

public class Detalle {
	
	//Variables
	private int id;
	private int id_pedido;
	private int id_producto;
	private boolean cancelar;
	private int unidades;
	private float precio_unidad;
	private float impuesto;
	private double total = precio_unidad * unidades;
	private String nombre;
	

	//Métodos
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public float getPrecio_unidad() {
		return precio_unidad;
	}
	public void setPrecio_unidad(float precio_unidad) {
		this.precio_unidad = precio_unidad;
	}
	public float getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isCancelar() {
		return cancelar;
	}
	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}
	
}
