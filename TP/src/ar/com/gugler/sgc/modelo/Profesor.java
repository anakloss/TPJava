package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;

/**
 * Clase Profesor que hereda de la clase padre Persona
 * @author Ana Kloss
 *
 */
public class Profesor extends Persona {
	public String cuil;
	public LocalDate fechaIngreso;
	
	/**
	 * Métodos utilizados como Constructores de la clase
	 */
	public Profesor() {
		super();
	}
	public Profesor(String cuil, LocalDate fechaIngreso) {
		super();
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
	}
	
	/**
	 * Método utilizado como Constructor de la clase Profesor + Persona
	 * 
	 * @param numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, correoElectronico
	 * 		para crear el objeto Persona
	 * 
	 * @param cuil, fechaIngreso
	 * 		para crear el objeto Profesor
	 */
	public Profesor(String numeroDocumento, String apellido, String nombre, LocalDate fechaNacimiento, String domicilio,
			String telefono, String correoElectronico, String cuil, LocalDate fechaIngreso) {
		super(numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, correoElectronico);
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
	}
	
	
	/**
	 * Métodos setters y getters
	 */
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	/**
	 * Redefinición del método equals para determinar
	 * que dos profesores son iguales si tienen igual cuil 
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

		Profesor other = (Profesor) obj;
		if (cuil == null) {
			if (other.cuil != null)
				return false;
		} else if (!cuil.equals(other.cuil))
			return false;
		return true;
	}
	
	/**
	 * Redefinición del método toString para mostrar información del Profesor
	 */
	@Override
	public String toString() {
		return "[CUIL " + getCuil() + "] " + super.toString();
	}

	/**
	 * Método implementado por heredar de la clase Persona
	 */
	public String mostrarInformacion() {
		return nombre.toUpperCase() + " " + apellido.toUpperCase() + " - CUIL: " + cuil;
	}
}
