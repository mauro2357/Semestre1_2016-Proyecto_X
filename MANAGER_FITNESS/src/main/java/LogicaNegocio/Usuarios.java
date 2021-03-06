package LogicaNegocio;

import repositorios.UsuariosRepositorio;

public class Usuarios {
	private int id;
	private String nombre;
	private String direccion;
	private Long telefono;
	private String correo;
	private String password;
	private String fechaN ;
	private String tipoUsuario;
	private int talla;
	private int peso;
	
	public int getTalla() {
		return talla;
	}
	public void setTalla(int talla) {
		this.talla = talla;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFechaN() {
		return fechaN;
	}
	public void setFechaN(String fechaN) {
		this.fechaN = fechaN;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Usuarios(int id, String nombre, String direccion, Long telefono, String correo, String password,
			String fechaN, String tipoUsuario) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.password = password;
		this.fechaN = fechaN;
		this.tipoUsuario = tipoUsuario;
	}
	public boolean agregar() throws Exception{
		return UsuariosRepositorio.agregarUsuario(this);
	}
}
