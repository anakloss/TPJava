package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;

/**
 * Clase Persona
 * @author Ana Kloss
 *
 */
public abstract class Persona {

	public String numeroDocumento;
	public String apellido;
	public String nombre;
	public LocalDate fechaNacimiento;
	public String domicilio;
	public String telefono;
	public String correoElectronico;
	
	/**
	 * Métodos utilizados como Constructores de la clase
	 */
	public Persona() {
		super();
	}
	public Persona(String numeroDocumento, String apellido, String nombre, LocalDate fechaNacimiento,
			String domicilio, String telefono, String correoElectronico) {
		super();
		this.numeroDocumento = numeroDocumento;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}

	/**
	 * Métodos setters y getters
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	/**
	 * Redefinición del método equals para determinar
	 * que dos personas son iguales si tienen igual numero de documento 
	 * 
	 * @param obj
	 *              Objeto a comparar
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (numeroDocumento == null) {
			if (other.numeroDocumento != null)
				return false;
		} else if (!numeroDocumento.equals(other.numeroDocumento))
			return false;
		return true;
	}
		
	/**
	 * Redefinición del método toString para mostrar información de la Persona
	 */
	@Override
	public String toString() {
		if (nombre != null && apellido != null) 
			return nombre + " " + apellido;
		else if (nombre != null)
			return nombre;
		else if (apellido != null)
			return apellido;
		return null;
	}
	

	/**
	 * Quienes extiendan de esta clase deberán escribir código para el método mostrarInformacion()
	 * o declararse como clases abstractas.
	 */
	public abstract String mostrarInformacion();
	
}
