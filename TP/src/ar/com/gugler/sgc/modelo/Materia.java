package ar.com.gugler.sgc.modelo;

public class Materia extends Asignatura {
	public Integer anio;
	
	// Constructors
	public Materia() {
		super();
	}
	public Materia(Integer anio) {
		super();
		this.anio = anio;
	}

	// Getters and Setters
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
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

		Materia other = (Materia) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		return true;
	}
		
	// toString
	@Override
	public String toString() {
		return super.toString() + "[Año:  " + getAnio() + "]"; 
	}
	
}
