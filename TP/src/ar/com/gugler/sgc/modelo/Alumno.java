package ar.com.gugler.sgc.modelo;

import java.util.Date;

public class Alumno extends Persona {
	public String legajo;

	// Constructors
	public Alumno() {
		super();
	}
	public Alumno(String legajo) {
		super();
		this.legajo = legajo;
	}
	public Alumno(String numeroDocumento, String apellido, String nombre, Date fechaNacimiento, String domicilio,
			String telefono, String correoElectronico, String legajo) {
		super(numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, correoElectronico);
		this.legajo = legajo;
	}

	// Getters and Setters
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	// Equals
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

	// toString
	@Override
	public String toString() {
		return "[Legajo " + getLegajo() + "] " + super.toString();
	}

	public String mostrarInformacion() {
		return nombre + " " + apellido + " - DNI: " + numeroDocumento;
	}

}
