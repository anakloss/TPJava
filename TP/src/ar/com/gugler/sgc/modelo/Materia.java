package ar.com.gugler.sgc.modelo;

/**
 *  Clase Materia que hereda de la clase Asignatura
 * @author Ana Kloss
 *
 */
public class Materia extends Asignatura {
	public Integer anio;
	
	/**
	 * Métodos utilizados como Constructores de la clase
	 */
	public Materia() {
		super();
	}
	public Materia(Integer anio) {
		super();
		this.anio = anio;
	}

	/**
	 * Métodos setters y getters
	 */
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
		
	/**
	 * Redefinición del método toString para mostrar información de la Materia
	 */
	@Override
	public String toString() {
		return super.toString() + "[Año:  " + getAnio() + "]"; 
	}
	
}
