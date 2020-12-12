package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;
import java.util.Objects;

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
	 * @param numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, email
	 * 		para crear el objeto Persona
	 * 
	 * @param legajo
	 * 		para crear el objeto Alumno
	 */
	public Alumno(String numeroDocumento, String apellido, String nombre, LocalDate fechaNacimiento, String domicilio,
			String telefono, String email, String legajo) {
		super(numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, email);
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
	 * Redefinición del método equals para determinar que dos alumnos 
	 * son iguales si tienen igual numero de documento, heredado de persona
	 * 
	 * @param obj
	 *              Objeto a comparar
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(numeroDocumento, other.numeroDocumento);
	}

	/**
	 * Método implementado por heredar de la clase Persona
	 */
	public String mostrarInformacion() {
		return nombre + " " + apellido + " - DNI: " + numeroDocumento;
	}

}
