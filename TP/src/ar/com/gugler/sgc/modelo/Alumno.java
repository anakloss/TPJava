package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;

/**
 * Clase Alumno que hereda de la clase padre Persona
 * @author Ana Kloss
 *
 */

public class Alumno extends Persona {
	public String legajo;
	
	/**
	 * Métodos utilizados como Constructores de la clase
	 */
	public Alumno() {
		super();
	}
	public Alumno(String legajo) {
		super();
		this.legajo = legajo;
	}
	/**
	 * Método utilizado como Constructor de la clase Alumno + Persona
	 * 
	 * @param numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, correoElectronico
	 * 		para crear el objeto Persona
	 * 
	 * @param legajo
	 * 		para crear el objeto Alumno
	 */
	public Alumno(String numeroDocumento, String apellido, String nombre, LocalDate fechaNacimiento, String domicilio,
			String telefono, String correoElectronico, String legajo) {
		super(numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, correoElectronico);
		this.legajo = legajo;
	}

	/**
	 * Métodos setters y getters
	 */
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	/**
	 * Redefinición del método equals para determinar
	 * que dos alumnos son iguales si tienen igual legajo 
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

		Alumno other = (Alumno) obj;
		if (legajo == null) {
			if (other.legajo != null)
				return false;
		} else if (!legajo.equals(other.legajo))
			return false;
		return true;
	}

	/**
	 * Redefinición del método toString para mostrar información del Alumno
	 */
	@Override
	public String toString() {
		return "[Legajo " + getLegajo() + "] " + super.toString();
	}

	/**
	 * Método implementado por heredar de la clase Persona
	 */
	public String mostrarInformacion() {
		return nombre + " " + apellido + " - DNI: " + numeroDocumento;
	}

}
