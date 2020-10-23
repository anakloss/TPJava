package ar.com.gugler.sgc.modelo;

import java.util.Date;

public class Profesor extends Persona {
	public String cuil;
	public Date fechaIngreso;
	
	// Constructors
	public Profesor() {
		super();
	}
	public Profesor(String cuil, Date fechaIngreso) {
		super();
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
	}
	
	// Getters and Setters
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

		Profesor other = (Profesor) obj;
		if (cuil == null) {
			if (other.cuil != null)
				return false;
		} else if (!cuil.equals(other.cuil))
			return false;
		return true;
	}
	
	// toString
	@Override
	public String toString() {
		return "[CUIL " + getCuil() + "] " + super.toString();
	}

	public String mostrarInformacion() {
		return nombre.toUpperCase() + " " + apellido.toUpperCase() + " - " + numeroDocumento;
	}
}
